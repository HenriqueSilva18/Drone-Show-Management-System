# Sistema de Simulação de Figuras com Drones

## Descrição do Sistema

Este projeto implementa um sistema de simulação para o movimento de drones em um espaço 3D, desenvolvido como parte da **Sprint 2** do projeto **Shodrone**.

O sistema utiliza:

- Processos separados para cada drone.
- Comunicação via **pipes**.
- Deteção de colisões baseada em **distância euclidiana**.
- Geração do **relatório detalhado**.

A simulação é controlada por scripts que definem as posições dos drones em cada timestep, garantindo **sincronização** e **validação da segurança das figuras**. 


---

## Componentes da Solução

A arquitetura do sistema é composta por processos e comunicação via pipes, conforme ilustrado abaixo:


![img_1.png](img_1.png)


Este diagrama representa a arquitetura do sistema:
- Cada drone lê posições de um script (x, y, z).
- O processo principal sincroniza os drones com pipes.
- Dados são trocados entre main e drones.
- Todas as posições são armazenadas numa matriz.
- Um relatório é gerado com as trajetórias.
- Colisões são tratadas com sinais SIGUSR1/SIGTERM.
  


### Detalhes

- **Processo Principal (`main`)**:
    - Gerencia a simulação.
    - Cria processos filhos (`fork`) para cada drone.
    - Sincroniza os timesteps.

- **Processos Drone**:
    - Cada drone é um processo independente.
    - Lê posições de um arquivo `scriptX.txt`.
    - Envia coordenadas ao processo principal via pipe.

- **Pipes**:
    - **Sincronização**: `main → drone` (sinaliza avanço).
    - **Dados**: `drone → main` (envio de coordenadas x, y, z).

- **Sinais**:
    - `SIGUSR1`: Notifica colisões.
    - `SIGTERM`: Encerra os drones.

- **Arquivos**:
    - `scriptX.txt`: Define as posições de cada drone.
    - `simulation_report.txt`: Relatório com trajetórias, colisões e validação.

---

## Exemplo de Script de Movimento

Abaixo está um exemplo de script (`script0.txt`) que define as posições de um drone:

#### 9 9 0
#### 1 1 1 
#### 2 2 2
#### 3 3 3
#### 4 4 4
#### 5 5 3
#### 6 6 2
#### 7 7 1
#### 8 8 2
#### 9 9 3


Cada linha representa uma posição (x, y, z) ocupada pelo drone em um timestep.  
O drone permanece na posição por **1 segundo** antes de avançar para a próxima.

---

## Abordagem por User Story

### US261 - Iniciar simulação com processos, pipes e sinais

- Cada drone é executado como um processo independente criado via `fork`.
- Dois pipes por drone:
    - Um para sincronização (`main → drone`).
    - Um para envio de posições (`drone → main`).
- Sinais utilizados:
    - `SIGUSR1` para colisões.
    - `SIGTERM` para término.

### US262 - Captura e processamento de movimentos

- Cada drone lê posições do seu respectivo arquivo `scriptX.txt`.
- As posições são enviadas ao `main` via pipe.
- São armazenadas em uma matriz `[MAX_STEPS][MAX_DRONES]` para análise posterior.

### US263 - Detecção de colisões

- Verifica a **distância euclidiana** entre drones.
- Colisão ocorre se a distância for **inferior a 1 metro**.
- Em caso de colisão:
    - O `main` envia `SIGUSR1` aos drones envolvidos.
    - A simulação é encerrada se o número de colisões exceder o limite (`COLLISION_THRESHOLD`).

### US264 - Sincronização por timestep

- O `main` envia um sinal de sincronização a **todos os drones** no início de cada timestep.
- O próximo timestep **só inicia** após o `main` receber as posições de **todos os drones ativos**.

### US265 - Relatório da simulação

Gera o arquivo `simulation_report.txt` contendo:

- Data e hora da simulação.
- Número de drones e timesteps.
- Atividade de cada drone (quantidade de timesteps ativos).
- Trajetórias (limitadas a 10 posições por drone para legibilidade).
- Detalhes de colisões (se houver).
- Validação da figura:
    - `"PASSED"` (sem colisões).
    - `"FAILED"` (com colisões).
- Recomendações para ajustes, se necessário.

---

## Autoavaliação do Grupo

| Membro  | Contribuição (%) |
|---------|------------------|
| Nome A  | 100%             |
| Nome B  | 100%             |
| Nome C  | 100%             |

**Comentário:**  
Todos os membros do grupo contribuíram de forma ativa e equilibrada, participando da implementação, testes e documentação.  
Reuniões regulares garantiram o alinhamento e a colaboração eficiente.
