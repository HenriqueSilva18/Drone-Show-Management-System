#define _POSIX_C_SOURCE 200809L
#include <errno.h>
#include <fcntl.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/mman.h>
#include <unistd.h>

#include "shared.h"

SharedMemoryLayout* shm = NULL;
sem_t *sem_mutex, *sem_drone_sync, *sem_main_sync;
volatile sig_atomic_t terminate = 0;

void handle_sigterm(int signum) {
	(void)signum;
	terminate = 1;
}

void init_communication_resources(int drone_id) {
	int fd = shm_open(SHM_NAME, O_RDWR, 0666);
	if (fd == -1) {
		perror("shm_open in drone");
		exit(EXIT_FAILURE);
	}

	shm = mmap(0, sizeof(SharedMemoryLayout), PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
	close(fd);
	if (shm == MAP_FAILED) {
		perror("mmap in drone");
		exit(EXIT_FAILURE);
	}

	sem_mutex = sem_open(SEM_MUTEX_NAME, 0);
	sem_drone_sync = sem_open(SEM_DRONE_SYNC_NAME, 0);
	sem_main_sync = sem_open(SEM_MAIN_SYNC_NAME, 0);

	if (sem_mutex == SEM_FAILED || sem_drone_sync == SEM_FAILED || sem_main_sync == SEM_FAILED) {
		perror("sem_open in drone");
		exit(EXIT_FAILURE);
	}

	printf("[DRONE %d] Recursos de comunicação preparados.\n", drone_id);
}

void cleanup_resources(int drone_id) {
	munmap(shm, sizeof(SharedMemoryLayout));
	sem_close(sem_mutex);
	sem_close(sem_drone_sync);
	sem_close(sem_main_sync);
	printf("[DRONE %d] Terminado e recursos libertados.\n", drone_id);
}

int main(int argc, char* argv[]) {
	if (argc != 2) {
		fprintf(stderr, "Uso: %s <drone_id>\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	int drone_id = atoi(argv[1]);
	init_communication_resources(drone_id);

	char filename[64];
	snprintf(filename, sizeof(filename), "script%d.txt", drone_id);
	FILE* script = fopen(filename, "r");
	if (!script) {
		fprintf(stderr, "[DRONE %d] ERRO: Não foi possível abrir o ficheiro de script '%s'.\n", drone_id, filename);
		exit(EXIT_FAILURE);
	}

	signal(SIGTERM, handle_sigterm);
	signal(SIGINT, SIG_IGN);

	int x = 0, y = 0, z = 0;
	int script_completed = 0;

	// Lê a primeira posição ANTES de entrar no loop
	if (fscanf(script, "%d %d %d", &x, &y, &z) != 3) {
		printf("[DRONE %d] Script vazio ou mal formatado.\n", drone_id);
		script_completed = 1;
	}

	while (!terminate) {
		sem_wait(sem_drone_sync);

		if (!shm->simulation_active || terminate)
			break;

		// Escreve a posição atual na memória partilhada
		sem_wait(sem_mutex);
		shm->drone_data[drone_id].x = x;
		shm->drone_data[drone_id].y = y;
		shm->drone_data[drone_id].z = z;
		shm->drone_data[drone_id].drone_id = drone_id;
		shm->drone_data[drone_id].script_completed = script_completed;
		sem_post(sem_mutex);

		sem_post(sem_main_sync);

		// Lê a próxima posição para o próximo passo
		if (!script_completed) {
			if (fscanf(script, "%d %d %d", &x, &y, &z) != 3) {
				printf("[DRONE %d] Script terminado. Última posição mantida.\n", drone_id);
				script_completed = 1;
			}
		}
	}

	fclose(script);
	cleanup_resources(drone_id);
	return 0;
}
