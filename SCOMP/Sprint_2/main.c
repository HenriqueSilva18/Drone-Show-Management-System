/* main.c - Simulador de movimento de drones com espaço 3D físico */
#define _POSIX_C_SOURCE 200809L

#include <errno.h>
#include <fcntl.h>
#include <math.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <time.h>
#include <unistd.h>

#include "report.h"	// US265 - Geração do relatório

#define MAX_DRONES 10
#define MAX_STEPS 20
#define MAX_X 10
#define MAX_Y 10
#define MAX_Z 5

// US262 - Captura e armazenamento de posições no tempo
Position positionMatrix[MAX_STEPS][MAX_DRONES];
int space3D[MAX_X][MAX_Y][MAX_Z];

int num_drones;
int pipefds[MAX_DRONES][2];	  // Pipe for synchronization
int data_pipes[MAX_DRONES][2];  // Pipe for Position data
pid_t drone_pids[MAX_DRONES];
int collision_count = 0;
int active_drones = 0;	// Número de drones ativos
const int COLLISION_THRESHOLD = 3;

// Flag para tratamento de sinais no processo principal
volatile sig_atomic_t terminate_simulation = 0;

void handle_signal(int sig) {
	if (sig == SIGINT || sig == SIGTERM) {
		printf("[MAIN] Received signal %d. Terminating simulation...\n", sig);
		terminate_simulation = 1;
	}
}

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

int droneTooNear(Position pos) {
	for (int i = 0; i < num_drones; i++) {
		Position other = positionMatrix[pos.step][i];
		if (other.drone_id == pos.drone_id) {
			continue;
		}
		// Calculate Euclidean distance
		double dx = other.x - pos.x;
		double dy = other.y - pos.y;
		double dz = other.z - pos.z;
		double distance = sqrt(dx * dx + dy * dy + dz * dz);
		// Check if distance is within 1 meter
		if (distance < 1.0) {
			return 1;
		}
	}
	return 0;
}

int check_collision(Position pos) {
	if (pos.x < 0 || pos.x >= MAX_X || pos.y < 0 || pos.y >= MAX_Y ||
		 pos.z < 0 || pos.z >= MAX_Z) {
		printf("[WARNING] Drone %d position (%d,%d,%d) out of bounds\n",
				 pos.drone_id, pos.x, pos.y, pos.z);
		return 0;
	}

	if (droneTooNear(pos)) {
		log_collision(pos.step, pos.x, pos.y, pos.z);
		return 1;
	}

	/* if (space3D[pos.x][pos.y][pos.z] != -1) {
		log_collision(pos.step, pos.x, pos.y, pos.z);
		return 1;
	} */
	space3D[pos.x][pos.y][pos.z] = pos.drone_id;
	return 0;
}

// US262 - Guardar posição na matriz de passos
void save_position(int step, Position pos) {
	if (step < 0 || step >= MAX_STEPS) {
		return;
	}

	for (int i = 0; i < num_drones; i++) {
		if (positionMatrix[step][i].drone_id == -1 ||
			 positionMatrix[step][i].drone_id == pos.drone_id) {
			positionMatrix[step][i] = pos;
			return;
		}
	}
}

// Fechar todos os pipes e terminar drones
void cleanup_resources() {
	for (int i = 0; i < num_drones; i++) {
		if (drone_pids[i] > 0) {
			kill(drone_pids[i], SIGTERM);
		}

		// Fechar os pipes
		if (pipefds[i][0] >= 0)
			close(pipefds[i][0]);
		if (pipefds[i][1] >= 0)
			close(pipefds[i][1]);
		if (data_pipes[i][0] >= 0)
			close(data_pipes[i][0]);
		if (data_pipes[i][1] >= 0)
			close(data_pipes[i][1]);
	}
}

int main(int argc, char* argv[]) {
	if (argc != 2) {
		fprintf(stderr, "Usage: %s <num_drones>\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	// Configurar handler para SIGINT e SIGTERM
	signal(SIGINT, handle_signal);
	signal(SIGTERM, handle_signal);

	num_drones = atoi(argv[1]);
	if (num_drones <= 0) {
		fprintf(stderr, "Error: Number of drones must be positive\n");
		exit(EXIT_FAILURE);
	}

	if (num_drones > MAX_DRONES)
		num_drones = MAX_DRONES;

	active_drones = num_drones;

	// Inicializar estruturas
	for (int i = 0; i < MAX_STEPS; i++)
		for (int j = 0; j < MAX_DRONES; j++)
			positionMatrix[i][j].drone_id = -1;

	// Inicializar file descriptors com -1
	for (int i = 0; i < MAX_DRONES; i++) {
		pipefds[i][0] = pipefds[i][1] = -1;
		data_pipes[i][0] = data_pipes[i][1] = -1;
	}

	clear_space3D();

	// Criação de pipes e drones
	for (int i = 0; i < num_drones; i++) {
		// Pipe for synchronization
		if (pipe(pipefds[i]) == -1) {
			perror("sync pipe");
			cleanup_resources();
			exit(EXIT_FAILURE);
		}

		// Pipe for Position data
		if (pipe(data_pipes[i]) == -1) {
			perror("data pipe");
			cleanup_resources();
			exit(EXIT_FAILURE);
		}

		// Debug: Print file descriptors before fork
		printf("[MAIN] Drone %d: sync_fd=%d, data_fd=%d\n", i, pipefds[i][0], data_pipes[i][1]);

		pid_t pid = fork();
		if (pid == 0) {
			// Fechar pipes não utilizados por este filho
			for (int j = 0; j < i; j++) {	 // Only close pipes for previous drones
				close(pipefds[j][0]);
				close(pipefds[j][1]);
				close(data_pipes[j][0]);
				close(data_pipes[j][1]);
			}

			// Processo filho (drone)
			close(pipefds[i][1]);	  // Filho lê do pipe de sincronização
			close(data_pipes[i][0]);  // Filho escreve no pipe de dados

			char id[10];
			sprintf(id, "%d", i);
			char sync_fd[10];
			sprintf(sync_fd, "%d", pipefds[i][0]);
			char data_fd[10];
			sprintf(data_fd, "%d", data_pipes[i][1]);

			execl("drone", "drone", id, sync_fd, data_fd, NULL);
			perror("execl failed");
			exit(EXIT_FAILURE);
		} else if (pid > 0) {
			// Processo pai
			drone_pids[i] = pid;
			// Delay closing pipefds[i][0] until after all forks
		} else {
			perror("fork");
			cleanup_resources();
			exit(EXIT_FAILURE);
		}
	}

	// Close sync pipe read ends and data pipe write ends after all forks
	for (int i = 0; i < num_drones; i++) {
		close(pipefds[i][0]);	  // Pai escreve no pipe de sincronização
		close(data_pipes[i][1]);  // Pai lê do pipe de dados
		// Configurar o pipe de dados para operação não-bloqueante
		fcntl(data_pipes[i][0], F_SETFL, O_NONBLOCK);
	}

	// Simulação por passos de tempo (timesteps)
	for (int step = 0; step < MAX_STEPS && !terminate_simulation && active_drones > 0; step++) {
		clear_space3D();
		printf("[MAIN] Starting timestep %d (active drones: %d)\n", step, active_drones);

		// US264 - Sinalizar o início do timestep para todos os drones ativos
		char sync_signal = 1;
		for (int i = 0; i < num_drones; i++) {
			if (drone_pids[i] > 0) {
				if (write(pipefds[i][1], &sync_signal, 1) < 0) {
					perror("write sync signal");
				}
			}
		}

		// Dar um tempo para drones processarem seus movimentos
		usleep(100000);  // 100ms

		// Array para rastrear quais drones responderam neste passo
		int drone_responded[MAX_DRONES] = {0};
		int responses = 0;

		// Ler posições com timeout para evitar bloqueio se um drone não responder
		time_t start_time = time(NULL);
		time_t current_time;

		while (responses < active_drones &&
				 (current_time = time(NULL)) - start_time < 2 &&  // 2 segundos de timeout
				 !terminate_simulation) {
			for (int i = 0; i < num_drones; i++) {
				if (drone_pids[i] <= 0 || drone_responded[i]) {
					continue;  // Drone já terminou ou já respondeu
				}

				Position pos;
				int bytes = read(data_pipes[i][0], &pos, sizeof(Position));

				if (bytes == sizeof(Position)) {
					pos.step = step;
					drone_responded[i] = 1;
					responses++;

					if (check_collision(pos)) {
						kill(drone_pids[i], SIGUSR1);
					}

					save_position(step, pos);
				} else if (bytes == 0 || (bytes < 0 && errno != EAGAIN)) {
					// Pipe fechado ou erro
					printf("[MAIN] Drone %d has terminated or had an error\n", i);
					drone_pids[i] = -1;
					close(data_pipes[i][0]);
					close(pipefds[i][1]);
					data_pipes[i][0] = -1;
					pipefds[i][1] = -1;
					active_drones--;
					drone_responded[i] = 1;
					responses++;
				}
			}

			// Pequena pausa para evitar consumo excessivo de CPU
			usleep(10000);	 // 10ms
		}

		// Contar drones que não responderam
		for (int i = 0; i < num_drones; i++) {
			if (drone_pids[i] > 0 && !drone_responded[i]) {
				printf("[WARNING] Drone %d did not respond in timestep %d\n", i, step);
			}
		}

		if (step == 0 || step % 5 == 0) {  // Reduzir volume de logs
			printf("### SPACE 3D (step %d) ###\n", step);
			for (int x = 0; x < MAX_X; x++)
				for (int y = 0; y < MAX_Y; y++)
					for (int z = 0; z < MAX_Z; z++)
						if (space3D[x][y][z] != -1)
							printf("space3D[%d][%d][%d] = %d\n", x, y, z, space3D[x][y][z]);
		}

		if (collision_count >= COLLISION_THRESHOLD) {
			printf("Too many collisions (%d). Terminating simulation...\n", collision_count);
			break;
		}

		printf("[MAIN] Completed timestep %d\n", step);
	}

	// Limpeza e encerramento
	cleanup_resources();

	// Aguardar que todos os processos terminem
	for (int i = 0; i < num_drones; i++) {
		if (drone_pids[i] > 0) {
			int status;
			waitpid(drone_pids[i], &status, 0);
			if (WIFEXITED(status)) {
				printf("[MAIN] Drone %d exited with status %d\n", i, WEXITSTATUS(status));
			} else if (WIFSIGNALED(status)) {
				printf("[MAIN] Drone %d killed by signal %d\n", i, WTERMSIG(status));
			}
		}
	}

	generate_report("simulation_report.txt", positionMatrix, MAX_STEPS, num_drones, collision_count);
	printf("Simulation ended. Total collisions: %d\n", collision_count);
	return 0;
}
