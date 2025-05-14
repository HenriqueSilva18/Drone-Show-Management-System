/* report.c - Geração do relatório da simulação */
#define _POSIX_C_SOURCE 200809L

#include "report.h"
#include <stdio.h>
#include <time.h>

// US265 - Gera o relatório da simulação
void generate_report(const char* filename, Position matrix[MAX_STEPS][MAX_DRONES], int steps, int drones, int collision_count) {
	FILE* fp = fopen(filename, "w");
	if (!fp) {
		perror("fopen");
		return;
	}

	time_t now = time(NULL);
	struct tm *tm_info = localtime(&now);
	char time_str[26];
	strftime(time_str, 26, "%Y-%m-%d %H:%M:%S", tm_info);

	fprintf(fp, "=== Simulation Report ===\n");
	fprintf(fp, "Generated: %s\n", time_str);
	fprintf(fp, "Total drones: %d\n", drones);
	fprintf(fp, "Total timesteps: %d\n", steps);
	fprintf(fp, "Total collisions: %d\n\n", collision_count);

	// Track how many steps each drone was active
	int drone_active_steps[MAX_DRONES] = {0};
	for (int t = 0; t < steps; t++) {
		for (int d = 0; d < drones; d++) {
			if (matrix[t][d].drone_id != -1) {
				drone_active_steps[matrix[t][d].drone_id]++;
			}
		}
	}

	fprintf(fp, "Drone Activity Summary:\n");
	for (int d = 0; d < drones; d++) {
		fprintf(fp, "  Drone %d: active for %d steps\n", d, drone_active_steps[d]);
	}
	fprintf(fp, "\n");

	if (collision_count > 0) {
		fprintf(fp, "Collisions detected at: (step, drone_id, x, y, z)\n");
		for (int t = 0; t < steps; t++) {
			for (int d1 = 0; d1 < drones; d1++) {
				Position p1 = matrix[t][d1];
				if (p1.drone_id == -1)
					continue;
				for (int d2 = d1 + 1; d2 < drones; d2++) {
					Position p2 = matrix[t][d2];
					if (p2.drone_id == -1)
						continue;
					if (p1.x == p2.x && p1.y == p2.y && p1.z == p2.z) {
						fprintf(fp, "  Step %d: Drones %d & %d at (%d,%d,%d)\n",
								t, p1.drone_id, p2.drone_id, p1.x, p1.y, p1.z);
					}
				}
			}
		}
		fprintf(fp, "\n");
	}

	// Add drone trajectories
	fprintf(fp, "Drone Trajectories:\n");
	for (int d = 0; d < drones; d++) {
		fprintf(fp, "  Drone %d path: ", d);
		int found = 0;
		for (int t = 0; t < steps; t++) {
			for (int i = 0; i < drones; i++) {
				if (matrix[t][i].drone_id == d) {
					if (found > 0) fprintf(fp, " -> ");
					fprintf(fp, "(%d,%d,%d)", matrix[t][i].x, matrix[t][i].y, matrix[t][i].z);
					found++;
					break;
				}
			}
			// Limit to 10 positions to avoid extremely long lines
			if (found >= 10) {
				fprintf(fp, " ... (and more)");
				break;
			}
		}
		if (found == 0) {
			fprintf(fp, "No movement data recorded");
		}
		fprintf(fp, "\n");
	}
	fprintf(fp, "\n");

	fprintf(fp, "Figure validation: %s\n", (collision_count > 0 ? "FAILED" : "PASSED"));
	
	if (collision_count > 0) {
		fprintf(fp, "\nRECOMMENDATION: The current figure contains collisions and should be redesigned.\n");
		fprintf(fp, "Consider adjusting the flight paths to maintain safe distances between drones.\n");
	} else {
		fprintf(fp, "\nRECOMMENDATION: The current figure is safe for performance.\n");
	}
	
	fclose(fp);
}
