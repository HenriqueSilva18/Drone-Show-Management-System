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
sem_t *sem_mutex, *sem_drone_sync, *sem_main_sync;
pid_t drone_pids[MAX_DRONES];
Position trajectory[MAX_STEPS][MAX_DRONES];	// Histórico das posições
int num_drones = 3;

void cleanup_resources() {
	sem_close(sem_mutex);
	sem_close(sem_drone_sync);
	sem_close(sem_main_sync);
	sem_unlink(SEM_MUTEX_NAME);
	sem_unlink(SEM_DRONE_SYNC_NAME);
	sem_unlink(SEM_MAIN_SYNC_NAME);

	if (shm != NULL) {
		munmap(shm, sizeof(SharedMemoryLayout));
		shm_unlink(SHM_NAME);
	}
}

void* collision_thread_func(void* arg) {
	while (1) {
		pthread_mutex_lock(&shm->thread_sync_mutex);
		while (shm->last_completed_step >= shm->current_step && !shm->simulation_finished_flag) {
			pthread_cond_wait(&shm->step_completed_cond, &shm->thread_sync_mutex);
		}
		if (shm->simulation_finished_flag) {
			pthread_mutex_unlock(&shm->thread_sync_mutex);
			break;
		}

		int step = shm->current_step;
		sem_wait(sem_mutex);  // Take mutex to ensure consistent read
		for (int i = 0; i < shm->num_drones; i++) {
			for (int j = i + 1; j < shm->num_drones; j++) {
				DroneData di = shm->drone_data[i];
				DroneData dj = shm->drone_data[j];
				if (di.x == dj.x && di.y == dj.y && di.z == dj.z) {
					printf("[COLLISION] Drones %d e %d colidiram em (%d,%d,%d) no passo %d\n",
							 i, j, di.x, di.y, di.z, step);

					if (shm->collision_log_count < MAX_COLLISION_LOG) {
						CollisionEvent ev = {step, i, j, di.x, di.y, di.z};
						shm->collision_log[shm->collision_log_count++] = ev;
					}
					shm->total_collisions++;
					// Stop the simulation when collision is detected
					shm->simulation_active = 0;
					pthread_cond_signal(&shm->new_collision_cond);
				}
			}
		}
		sem_post(sem_mutex);  // Release mutex after reading

		shm->last_completed_step = step;
		pthread_mutex_unlock(&shm->thread_sync_mutex);
	}
	return NULL;
}

void* report_thread_func(void* arg) {
	while (1) {
		pthread_mutex_lock(&shm->thread_sync_mutex);
		while (shm->next_collision_to_report >= shm->collision_log_count && !shm->simulation_finished_flag) {
			pthread_cond_wait(&shm->new_collision_cond, &shm->thread_sync_mutex);
		}

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

	signal(SIGINT, sigint_handler);

	int fd = shm_open(SHM_NAME, O_CREAT | O_RDWR, 0666);
	ftruncate(fd, sizeof(SharedMemoryLayout));
	shm = mmap(0, sizeof(SharedMemoryLayout), PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
	close(fd);

	memset(shm, 0, sizeof(SharedMemoryLayout));
	shm->num_drones = num_drones;
	shm->simulation_active = 1;

	pthread_mutexattr_t mattr;
	pthread_condattr_t cattr;
	pthread_mutexattr_init(&mattr);
	pthread_condattr_init(&cattr);
	pthread_mutexattr_setpshared(&mattr, PTHREAD_PROCESS_SHARED);
	pthread_condattr_setpshared(&cattr, PTHREAD_PROCESS_SHARED);
	pthread_mutex_init(&shm->thread_sync_mutex, &mattr);
	pthread_cond_init(&shm->step_completed_cond, &cattr);
	pthread_cond_init(&shm->simulation_over_cond, &cattr);
	pthread_cond_init(&shm->new_collision_cond, &cattr);

	sem_mutex = sem_open(SEM_MUTEX_NAME, O_CREAT, 0666, 1);
	sem_drone_sync = sem_open(SEM_DRONE_SYNC_NAME, O_CREAT, 0666, 0);
	sem_main_sync = sem_open(SEM_MAIN_SYNC_NAME, O_CREAT, 0666, 0);

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

	pthread_t t1, t2;
	pthread_create(&t1, NULL, collision_thread_func, NULL);
	pthread_create(&t2, NULL, report_thread_func, NULL);

	for (int step = 0; step < MAX_STEPS && shm->simulation_active; step++) {
		shm->current_step = step;
		shm->actual_steps_run++;

		// Signal all drones to update their positions
		for (int i = 0; i < num_drones; i++)
			sem_post(sem_drone_sync);

		// Wait for all drones to complete their updates
		for (int i = 0; i < num_drones; i++)
			sem_wait(sem_main_sync);

		// Take mutex to ensure consistent read of all drone positions
		sem_wait(sem_mutex);
		for (int d = 0; d < shm->num_drones; d++) {
			trajectory[step][d].x = shm->drone_data[d].x;
			trajectory[step][d].y = shm->drone_data[d].y;
			trajectory[step][d].z = shm->drone_data[d].z;
			trajectory[step][d].drone_id = d;  // Use actual drone ID
			trajectory[step][d].step = step;
		}
		sem_post(sem_mutex);

		pthread_mutex_lock(&shm->thread_sync_mutex);
		pthread_cond_signal(&shm->step_completed_cond);
		pthread_mutex_unlock(&shm->thread_sync_mutex);

		if (!shm->simulation_active) {
			printf("[MAIN] Simulation stopped due to collision at step %d\n", step);
			break;
		}

		usleep(100000);
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
