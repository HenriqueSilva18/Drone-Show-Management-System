#ifndef SHARED_H
#define SHARED_H

#include <pthread.h>
#include <semaphore.h>
#include <signal.h>

#define SHM_NAME "/drone_sim_shm"
#define SEM_MUTEX_NAME "/drone_sim_mutex"
#define SEM_DRONE_SYNC_NAME "/drone_sim_drone_sync"
#define SEM_MAIN_SYNC_NAME "/drone_sim_main_sync"

#define MAX_DRONES 10
#define MAX_STEPS 20
#define MAX_COLLISION_LOG 3

typedef struct {
	int x, y, z;
	int drone_id;
	int script_completed;
} DroneData;

typedef struct {
	int step;
	int drone1_id;
	int drone2_id;
	int x, y, z;
} CollisionEvent;

typedef struct {
	volatile sig_atomic_t simulation_active;
	int num_drones, current_step, total_collisions;
	int actual_steps_run;

	DroneData drone_data[MAX_DRONES];

	pthread_mutex_t thread_sync_mutex;
	pthread_cond_t step_completed_cond;
	pthread_cond_t simulation_over_cond;
	pthread_cond_t new_collision_cond;
	int last_completed_step;
	int simulation_finished_flag;

	CollisionEvent collision_log[MAX_COLLISION_LOG];
	int collision_log_count;
	int next_collision_to_report;

} SharedMemoryLayout;

// Usado para guardar a trajetória no main
typedef struct {
	int x, y, z;
	int drone_id;
	int step;
} Position;

#endif  // SHARED_H
