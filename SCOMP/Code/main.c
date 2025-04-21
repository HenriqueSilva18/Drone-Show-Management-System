/* main.c - Simulador de movimento de drones com espaço 3D físico */
#define _POSIX_C_SOURCE 200809L

#include <errno.h>
#include <fcntl.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

#include "report.h"	// US265 - Geração do relatório

#define MAX_DRONES 10
#define MAX_STEPS 20
#define MAX_X 10
#define MAX_Y 10
#define MAX_Z 5

typedef struct {
	int x, y, z;
	int drone_id;
	int step;
} Position;

// US262 - Captura e armazenamento de posições no tempo
Position positionMatrix[MAX_STEPS][MAX_DRONES];
int space3D[MAX_X][MAX_Y][MAX_Z];

int num_drones;
int pipefds[MAX_DRONES][2];
pid_t drone_pids[MAX_DRONES];
int collision_count = 0;
const int COLLISION_THRESHOLD = 3;

void clear_space3D() {
	for (int x = 0; x < MAX_X; x++)
		for (int y = 0; y < MAX_Y; y++)
			for (int z = 0; z < MAX_Z; z++)
				space3D[x][y][z] = -1;
}

// US263 - Log de colisões
void log_collision(int step, int x, int y, int z) {
	printf("[COLLISION] Step %d at position (%d,%d,%d)\n", step, x, y, z);
	collision_count++;
}

// US263 - Deteção de colisões reais no espaço 3D
int check_collision(Position pos) {
	if (space3D[pos.x][pos.y][pos.z] != -1) {
		log_collision(pos.step, pos.x, pos.y, pos.z);
		return 1;
	}
	space3D[pos.x][pos.y][pos.z] = pos.drone_id;
	return 0;
}

// US262 - Guardar posição na matriz de passos
void save_position(int step, Position pos) {
	for (int i = 0; i < num_drones; i++) {
		if (positionMatrix[step][i].drone_id == -1) {
			positionMatrix[step][i] = pos;
			return;
		}
	}
}

int main(int argc, char* argv[]) {
	if (argc != 2) {
		fprintf(stderr, "Usage: %s <num_drones>\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	num_drones = atoi(argv[1]);
	if (num_drones > MAX_DRONES)
		num_drones = MAX_DRONES;

	// Inicializar estruturas
	for (int i = 0; i < MAX_STEPS; i++)
		for (int j = 0; j < MAX_DRONES; j++)
			positionMatrix[i][j].drone_id = -1;

	clear_space3D();

	// Criação de pipes e drones
	for (int i = 0; i < num_drones; i++) {
		if (pipe(pipefds[i]) == -1) {
			perror("pipe");
			exit(EXIT_FAILURE);
		}

		pid_t pid = fork();
		if (pid == 0) {
			// Processo filho (drone)
			close(pipefds[i][0]);
			dup2(pipefds[i][1], STDOUT_FILENO);
			char id[10];
			sprintf(id, "%d", i);
			execl("./drone", "drone", id, NULL);
			perror("execl failed");
			exit(EXIT_FAILURE);
		} else if (pid > 0) {
			// Processo pai
			close(pipefds[i][1]);
			drone_pids[i] = pid;
		} else {
			perror("fork");
			exit(EXIT_FAILURE);
		}
	}

	// Simulação por passos de tempo (timesteps)
	for (int step = 0; step < MAX_STEPS; step++) {
		clear_space3D();

		for (int i = 0; i < num_drones; i++) {
			Position pos;
			int bytes = read(pipefds[i][0], &pos, sizeof(Position));
			if (bytes == sizeof(Position)) {
				pos.step = step;

				if (check_collision(pos)) {
					kill(drone_pids[i], SIGUSR1);
				}

				save_position(step, pos);
			}
		}

		sleep(1);

		if (collision_count >= COLLISION_THRESHOLD) {
			printf("Too many collisions. Terminating simulation...\n");
			for (int i = 0; i < num_drones; i++) {
				kill(drone_pids[i], SIGTERM);
			}
			break;
		}
	}

	for (int i = 0; i < num_drones; i++) {
		wait(NULL);
	}

	generate_report("simulation_report.txt", positionMatrix, MAX_STEPS, num_drones, collision_count);
	printf("Simulation ended. Total collisions: %d\n", collision_count);
	return 0;
}
