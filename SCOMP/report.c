/* report.c - Geração do relatório da simulação */
#define _POSIX_C_SOURCE 200809L

#include "report.h"
#include <stdio.h>

// US265 - Gera o relatório da simulação
void generate_report(const char* filename, Position matrix[MAX_STEPS][MAX_DRONES], int steps, int drones, int collision_count) {
	FILE* fp = fopen(filename, "w");
	if (!fp) {
		perror("fopen");
		return;
	}

	fprintf(fp, "=== Simulation Report ===\n");
	fprintf(fp, "Total drones: %d\n", drones);
	fprintf(fp, "Total timesteps: %d\n", steps);
	fprintf(fp, "Total collisions: %d\n\n", collision_count);

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
	}

	fprintf(fp, "\nFigure validation: %s\n", (collision_count > 0 ? "FAILED" : "PASSED"));
	fclose(fp);
}
