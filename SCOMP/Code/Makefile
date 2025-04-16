# Makefile - Compilação do simulador de drones

CC = gcc
CFLAGS = -Wall -Wextra -std=c99

BIN_MAIN = simulator
BIN_DRONE = drone

OBJS_MAIN = main.c report.c
HDRS = report.h

all: $(BIN_MAIN) $(BIN_DRONE)

$(BIN_MAIN): $(OBJS_MAIN) $(HDRS)
	$(CC) $(CFLAGS) -o $(BIN_MAIN) $(OBJS_MAIN)

$(BIN_DRONE): drone.c
	$(CC) $(CFLAGS) -o $(BIN_DRONE) drone.c

clean:
	rm -f $(BIN_MAIN) $(BIN_DRONE) *.o simulation_report.txt
