#include "report.h"
#include <stdio.h>
#include <time.h>
#include "shared.h"

void generate_report(const char* filename, Position matrix[MAX_STEPS][MAX_DRONES], int steps, int drones, int collision_count) {
	FILE* f = fopen(filename, "w");
	if (!f) {
		perror("fopen");
		return;
	}

	time_t now = time(NULL);
	fprintf(f, "=== Simulation Report ===\n");
	fprintf(f, "Generated: %s", ctime(&now));
	fprintf(f, "Total drones: %d\n", drones);
	fprintf(f, "Steps executed: %d\n", steps);
	fprintf(f, "Collisions: %d\n\n", collision_count);

	fprintf(f, "Final Positions:\n");
	for (int i = 0; i < drones; i++) {
		Position p = matrix[steps - 1][i];
		fprintf(f, "Drone %d: (%d,%d,%d)\n", p.drone_id, p.x, p.y, p.z);
	}

	fprintf(f, "\nTrajectories:\n");
	for (int s = 0; s < steps; s++) {
		fprintf(f, "Step %d:\n", s);
		for (int d = 0; d < drones; d++) {
			Position p = matrix[s][d];
			fprintf(f, "  Drone %d -> (%d,%d,%d)\n", p.drone_id, p.x, p.y, p.z);
		}
	}

	fclose(f);
}
