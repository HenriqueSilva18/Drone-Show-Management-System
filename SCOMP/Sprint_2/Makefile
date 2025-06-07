# Makefile - Compilação do simulador de drones

CC = gcc
CFLAGS = -Wall -Wextra -std=c99 -g
LDFLAGS = -lm

BIN_MAIN = simulator
BIN_DRONE = drone

OBJS_MAIN = main.c report.c
HDRS = report.h

all: $(BIN_MAIN) $(BIN_DRONE)

$(BIN_MAIN): $(OBJS_MAIN) $(HDRS)
	$(CC) $(CFLAGS) -o $(BIN_MAIN) $(OBJS_MAIN) $(LDFLAGS)

$(BIN_DRONE): drone.c $(HDRS)
	$(CC) $(CFLAGS) -o $(BIN_DRONE) drone.c $(LDFLAGS)

clean:
	rm -f $(BIN_MAIN) $(BIN_DRONE) *.o simulation_report.txt

test: all
	@echo "Creating sample script files if they don't exist..."
	@if [ ! -f script0.txt ]; then echo "0 0 0\n1 1 1\n2 2 2\n3 3 3\n4 4 4\n5 5 3\n6 6 2\n7 7 1\n8 8 2\n9 9 3" > script0.txt; fi
	@if [ ! -f script1.txt ]; then echo "9 9 0\n8 8 1\n7 7 2\n6 6 3\n5 5 4\n4 4 3\n3 3 2\n2 2 1\n1 1 0\n0 0 1" > script1.txt; fi
	@echo "Running simulation with 2 drones..."
	./$(BIN_MAIN) 2
