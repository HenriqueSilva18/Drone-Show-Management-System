#ifndef REPORT_H
#define REPORT_H

#include "shared.h"

void generate_report(const char* filename, Position matrix[MAX_STEPS][MAX_DRONES], int steps, int drones, int collision_count);

#endif  // REPORT_H
