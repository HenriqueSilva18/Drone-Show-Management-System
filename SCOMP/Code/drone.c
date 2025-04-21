/* drone.c - Processo de simulação de um drone individual (versão com script) */
#define _POSIX_C_SOURCE 200809L

#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <unistd.h>

// US262 - Estrutura para comunicar posição
typedef struct {
	int x, y, z;
	int drone_id;
	int step;
} Position;

int drone_id;
int stop = 0;
FILE* script = NULL;

// US263 - Handler para SIGUSR1 (colisão)
void handle_collision(int sig) {
	sigset_t mask;
	sigemptyset(&mask);
	sigaddset(&mask, SIGTERM);
	sigprocmask(SIG_BLOCK, &mask, NULL);

	printf("[DRONE %d] Received SIGUSR1: Collision detected!\n", drone_id);
	sleep(1);  // Simula processamento do sinal

	sigprocmask(SIG_UNBLOCK, &mask, NULL);
}

// US263 - Handler para SIGTERM (terminar)
void handle_terminate(int sig) {
	printf("[DRONE %d] Received SIGTERM: Terminating...\n", drone_id);
	stop = 1;
}

int main(int argc, char* argv[]) {
	if (argc != 2) {
		fprintf(stderr, "Usage: %s <drone_id>\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	drone_id = atoi(argv[1]);

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
	int step = 0;

	// Ler posições do ficheiro e enviá-las por pipe
	while (!stop && fscanf(script, "%d %d %d", &pos.x, &pos.y, &pos.z) == 3) {
		pos.step = step++;
		write(STDOUT_FILENO, &pos, sizeof(Position));
		sleep(1);
	}

	fclose(script);
	printf("[DRONE %d] Finished execution.\n", drone_id);
	return 0;
}
