#ifndef SHARED_H
#define SHARED_H

#include <pthread.h>
#include <semaphore.h>

#define MAX_DRONES 10
#define MAX_STEPS  100
#define MAX_COLLISION_LOG 15

#define SHM_NAME "/shm_sim"
#define SEM_MUTEX_NAME "/sem_mutex"
#define SEM_DRONE_SYNC_NAME "/sem_dsync"
#define SEM_MAIN_SYNC_NAME  "/sem_msync"
#define SEM_READY_NAME "/sem_ready"

typedef struct {
	int x, y, z;
	int drone_id;
	int step;
	int script_completed;
} DroneData;

typedef struct {
	int step;
	int drone1_id;
	int drone2_id;
	int x, y, z;
} CollisionEvent;

typedef struct {
	int x, y, z;
	int drone_id;
	int step;
} Position;

typedef struct {
	int num_drones;
	int current_step;
	int actual_steps_run;
	int simulation_active;
	int simulation_finished_flag;

	int collision_log_count;
	int total_collisions;
	CollisionEvent collision_log[MAX_COLLISION_LOG];
	int next_collision_to_report;

	DroneData drone_data[MAX_DRONES];

	pthread_mutex_t thread_sync_mutex;
	pthread_cond_t step_completed_cond;
	pthread_cond_t new_collision_cond;
	pthread_cond_t simulation_over_cond;

} SharedMemoryLayout;

#endif // SHARED_H
