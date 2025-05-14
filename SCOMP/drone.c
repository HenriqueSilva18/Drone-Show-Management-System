/* drone.c - Processo de simulação de um drone individual (versão com script) */
#define _POSIX_C_SOURCE 200809L

#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <unistd.h>

#include "report.h" // US262 - Incluir a definição da estrutura Position


int drone_id;
int stop = 0;
FILE* script = NULL;
int sync_fd = -1;  
int script_completed = 0;

// US263 - Handler para SIGUSR1 (colisão)
void handle_collision(int sig) {
	sigset_t mask;
	sigemptyset(&mask);
	sigaddset(&mask, SIGTERM);
	sigprocmask(SIG_BLOCK, &mask, NULL);

	printf("[DRONE %d] Received SIGUSR1: Collision detected!\n", drone_id);
	sleep(1);

	sigprocmask(SIG_UNBLOCK, &mask, NULL);
}

void handle_terminate(int sig) {
	printf("[DRONE %d] Received SIGTERM: Terminating...\n", drone_id);
	stop = 1;
}


void send_last_position(Position *pos) {
	printf("[DRONE %d] Script completed, sending last known position at step %d\n",
		drone_id, pos->step);
	write(STDOUT_FILENO, pos, sizeof(Position));
}

int main(int argc, char* argv[]) {
	if (argc < 2 || argc > 3) {
		fprintf(stderr, "Usage: %s <drone_id> [sync_fd]\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	drone_id = atoi(argv[1]);


	if (argc == 3) {
		sync_fd = atoi(argv[2]);
		printf("[DRONE %d] Using sync_fd: %d\n", drone_id, sync_fd);
	}

	// US263 - Regista handlers de sinais
	signal(SIGUSR1, handle_collision);
	signal(SIGTERM, handle_terminate);

	// Abrir o ficheiro de script para este drone
	char filename[32];
	sprintf(filename, "script%d.txt", drone_id);
	script = fopen(filename, "r");
	if (!script) {
		perror("Failed to open script file");
		exit(EXIT_FAILURE);
	}

	Position pos;
	pos.drone_id = drone_id;
	pos.x = 0;
	pos.y = 0;
	pos.z = 0;
	int step = 0;

	// Ler a primeira posição
	if (fscanf(script, "%d %d %d", &pos.x, &pos.y, &pos.z) != 3) {
		script_completed = 1;
	}

	while (!stop) {
		// US264 - Aguardar sinal do processo principal para avançar
		if (sync_fd != -1) {
			char sync_signal;
			printf("[DRONE %d] Waiting for sync signal at step %d...\n", drone_id, step);
			int bytes_read = read(sync_fd, &sync_signal, 1);
			if (bytes_read <= 0) {
				if (bytes_read == 0) {
					printf("[DRONE %d] Sync pipe closed. Terminating.\n", drone_id);
				} else {
					perror("Sync pipe read error");
				}
				break;
			}
			printf("[DRONE %d] Received sync signal for step %d\n", drone_id, step);
		}

		// Enviar a posição atual
		pos.step = step++;
		printf("[DRONE %d] Sending position (%d,%d,%d) at step %d\n",
			drone_id, pos.x, pos.y, pos.z, pos.step);
		write(STDOUT_FILENO, &pos, sizeof(Position));

		// Ler a próxima posição se o script não acabou
		if (!script_completed) {
			if (fscanf(script, "%d %d %d", &pos.x, &pos.y, &pos.z) != 3) {
				script_completed = 1;
				printf("[DRONE %d] Script completed, will stay at last position\n", drone_id);
				// Last position will be reused in next step
			}
		}
	}

	if (sync_fd != -1) {
		close(sync_fd);
	}

	fclose(script);
	printf("[DRONE %d] Finished execution.\n", drone_id);
	return 0;
}
