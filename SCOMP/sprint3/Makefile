# Nome dos executáveis
MAIN = main
DRONE = drone

# Compilador e flags de compilação
CC = gcc
CFLAGS = -Wall -Wextra -std=c11 -g

# Bibliotecas a ligar (linker flags)
# -lrt é para a memória partilhada e semáforos
# -lpthread é para as threads
MAIN_LIBS = -lrt -lpthread
DRONE_LIBS = -lrt

# Alvo padrão: compila tudo
all: $(MAIN) $(DRONE)

# Regra de compilação para o executável principal
$(MAIN): main.c report.c report.h shared.h
	$(CC) $(CFLAGS) -o $(MAIN) main.c report.c $(MAIN_LIBS)

# Regra de compilação para o executável do drone
$(DRONE): drone.c shared.h
	$(CC) $(CFLAGS) -o $(DRONE) drone.c $(DRONE_LIBS)

# Limpeza dos ficheiros binários e do relatório
clean:
	rm -f $(MAIN) $(DRONE) simulation_report.txt

# Execução da simulação com 4 drones
run: all
	./$(MAIN) 4

# Define alvos que não são nomes de ficheiros
.PHONY: all clean run
