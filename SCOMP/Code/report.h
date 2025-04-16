#ifndef REPORT_H
#define REPORT_H

#define MAX_DRONES 10
#define MAX_STEPS 20

// Definição completa da estrutura Position (necessária em report.c)
typedef struct {
	int x, y, z;
	int drone_id;
	int step;
} Position;

void generate_report(const char* filename, Position matrix[MAX_STEPS][MAX_DRONES], int steps, int drones, int collision_count);

#endif  // REPORT_H
