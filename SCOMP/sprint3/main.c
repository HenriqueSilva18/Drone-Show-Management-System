#define _POSIX_C_SOURCE 200809L
#include <errno.h>
#include <fcntl.h>
#include <pthread.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/mman.h>
#include <sys/wait.h>
#include <unistd.h>

#include "report.h"
#include "shared.h"

SharedMemoryLayout* shm = NULL;
sem_t *sem_mutex, *sem_drone_sync, *sem_main_sync, *sem_ready;
pid_t drone_pids[MAX_DRONES];
Position trajectory[MAX_STEPS][MAX_DRONES];
int num_drones = 3;

void cleanup_resources() {
	sem_close(sem_mutex);
	sem_close(sem_drone_sync);
	sem_close(sem_main_sync);
	sem_close(sem_ready);
	sem_unlink(SEM_MUTEX_NAME);
	sem_unlink(SEM_DRONE_SYNC_NAME);
	sem_unlink(SEM_MAIN_SYNC_NAME);
	sem_unlink(SEM_READY_NAME);
	if (shm) {
		munmap(shm, sizeof(SharedMemoryLayout));
		shm_unlink(SHM_NAME);
	}
}

void* collision_thread_func(void* arg) {
	(void)arg;
	while (1) {
		pthread_mutex_lock(&shm->thread_sync_mutex);
		while (shm->current_step == 0 && !shm->simulation_finished_flag)
			pthread_cond_wait(&shm->step_completed_cond, &shm->thread_sync_mutex);
		if (shm->simulation_finished_flag) {
			pthread_mutex_unlock(&shm->thread_sync_mutex);
			break;
		}

		int step = shm->current_step;
		sem_wait(sem_mutex);

		for (int i = 0; i < shm->num_drones; i++) {
			for (int j = i + 1; j < shm->num_drones; j++) {
				DroneData di = shm->drone_data[i];
				DroneData dj = shm->drone_data[j];
				if (di.x == dj.x && di.y == dj.y && di.z == dj.z) {
					int duplicado = 0;
					for (int k = 0; k < shm->collision_log_count; k++) {
						CollisionEvent prev = shm->collision_log[k];
						if (prev.step == step &&
							 ((prev.drone1_id == i && prev.drone2_id == j) ||
							  (prev.drone1_id == j && prev.drone2_id == i))) {
							duplicado = 1;
							break;
						}
					}
					if (!duplicado && shm->collision_log_count < MAX_COLLISION_LOG) {
						printf("[COLLISION] Drones %d e %d colidiram em (%d,%d,%d) no passo %d\n",
								 i, j, di.x, di.y, di.z, step);

						CollisionEvent ev = {step, i, j, di.x, di.y, di.z};
						shm->collision_log[shm->collision_log_count++] = ev;
						shm->total_collisions++;

						pthread_cond_signal(&shm->new_collision_cond);

						if (shm->collision_log_count >= MAX_COLLISION_LOG) {
							printf("[COLLISION] Limite máximo de colisões atingido (%d). A terminar...\n", MAX_COLLISION_LOG);
							shm->simulation_active = 0;
							shm->simulation_finished_flag = 1;
						}
					}
				}
			}
		}

		sem_post(sem_mutex);
		pthread_mutex_unlock(&shm->thread_sync_mutex);
	}
	return NULL;
}

void* report_thread_func(void* arg) {
	(void)arg;
	while (1) {
		pthread_mutex_lock(&shm->thread_sync_mutex);
		while (shm->next_collision_to_report >= shm->collision_log_count && !shm->simulation_finished_flag)
			pthread_cond_wait(&shm->new_collision_cond, &shm->thread_sync_mutex);
		while (shm->next_collision_to_report < shm->collision_log_count) {
			CollisionEvent ev = shm->collision_log[shm->next_collision_to_report++];
			printf("[REPORT] Colisão registada: Drones %d & %d @ (%d,%d,%d), passo %d\n",
					 ev.drone1_id, ev.drone2_id, ev.x, ev.y, ev.z, ev.step);
		}
		if (shm->simulation_finished_flag) {
			pthread_mutex_unlock(&shm->thread_sync_mutex);
			break;
		}
		pthread_mutex_unlock(&shm->thread_sync_mutex);
	}
	return NULL;
}

void sigint_handler(int sig) {
	(void)sig;
	shm->simulation_active = 0;
}

int main(int argc, char* argv[]) {
	if (argc > 1)
		num_drones = atoi(argv[1]);
	if (num_drones < 1 || num_drones > MAX_DRONES) {
		fprintf(stderr, "Número inválido de drones.\n");
		exit(EXIT_FAILURE);
	}

	for (int i = 0; i < num_drones; i++) {
		char filename[64];
		snprintf(filename, sizeof(filename), "script%d.txt", i);
		FILE* f = fopen(filename, "r");
		if (!f) {
			fprintf(stderr, "[ERRO] Script '%s' não encontrado.\n", filename);
			exit(EXIT_FAILURE);
		}
		fclose(f);
	}

	struct sigaction sa;
	sa.sa_handler = sigint_handler;
	sigemptyset(&sa.sa_mask);
	sa.sa_flags = 0;
	sigaction(SIGINT, &sa, NULL);

	int fd = shm_open(SHM_NAME, O_CREAT | O_RDWR, 0666);
	ftruncate(fd, sizeof(SharedMemoryLayout));
	shm = mmap(0, sizeof(SharedMemoryLayout), PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
	close(fd);
	memset(shm, 0, sizeof(SharedMemoryLayout));
	shm->num_drones = num_drones;
	shm->simulation_active = 1;

	pthread_mutex_init(&shm->thread_sync_mutex, NULL);
	pthread_cond_init(&shm->step_completed_cond, NULL);
	pthread_cond_init(&shm->simulation_over_cond, NULL);
	pthread_cond_init(&shm->new_collision_cond, NULL);

	sem_mutex = sem_open(SEM_MUTEX_NAME, O_CREAT, 0666, 1);
	sem_drone_sync = sem_open(SEM_DRONE_SYNC_NAME, O_CREAT, 0666, 0);
	sem_main_sync = sem_open(SEM_MAIN_SYNC_NAME, O_CREAT, 0666, 0);
	sem_ready = sem_open(SEM_READY_NAME, O_CREAT, 0666, 0);

	for (int i = 0; i < num_drones; i++) {
		pid_t pid = fork();
		if (pid == 0) {
			char id[8];
			snprintf(id, sizeof(id), "%d", i);
			execl("./drone", "drone", id, NULL);
			exit(1);
		}
		drone_pids[i] = pid;
	}

	// Esperar que todos os drones sinalizem que estão prontos
	for (int i = 0; i < num_drones; i++)
		sem_wait(sem_ready);

	pthread_t t1, t2;
	pthread_create(&t1, NULL, collision_thread_func, NULL);
	pthread_create(&t2, NULL, report_thread_func, NULL);

	// passo 0
	for (int i = 0; i < num_drones; i++)
		sem_post(sem_drone_sync);
	for (int i = 0; i < num_drones; i++)
		sem_wait(sem_main_sync);

	sem_wait(sem_mutex);
	for (int d = 0; d < shm->num_drones; d++) {
		trajectory[0][d] = (Position){
			 .x = shm->drone_data[d].x,
			 .y = shm->drone_data[d].y,
			 .z = shm->drone_data[d].z,
			 .drone_id = d,
			 .step = 0};
	}
	sem_post(sem_mutex);
	shm->current_step = 1;

	for (int step = 1; step < MAX_STEPS && shm->simulation_active; step++) {
		shm->current_step = step;
		shm->actual_steps_run++;

		for (int i = 0; i < num_drones; i++)
			sem_post(sem_drone_sync);
		for (int i = 0; i < num_drones; i++)
			sem_wait(sem_main_sync);

		sem_wait(sem_mutex);
		for (int d = 0; d < shm->num_drones; d++) {
			trajectory[step][d] = (Position){
				 .x = shm->drone_data[d].x,
				 .y = shm->drone_data[d].y,
				 .z = shm->drone_data[d].z,
				 .drone_id = d,
				 .step = step};
		}
		sem_post(sem_mutex);

		pthread_mutex_lock(&shm->thread_sync_mutex);
		pthread_cond_signal(&shm->step_completed_cond);
		pthread_mutex_unlock(&shm->thread_sync_mutex);
	}

	shm->simulation_finished_flag = 1;
	shm->simulation_active = 0;
	pthread_cond_broadcast(&shm->new_collision_cond);
	pthread_cond_broadcast(&shm->step_completed_cond);

	pthread_join(t1, NULL);
	pthread_join(t2, NULL);

	for (int i = 0; i < num_drones; i++)
		kill(drone_pids[i], SIGTERM);
	for (int i = 0; i < num_drones; i++)
		waitpid(drone_pids[i], NULL, 0);

	generate_report("simulator_report.txt", trajectory, shm->current_step, shm->num_drones, shm->total_collisions);
	cleanup_resources();
	return 0;
}
