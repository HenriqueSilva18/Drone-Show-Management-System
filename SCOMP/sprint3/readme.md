# Relatório Técnico — Sprint 3: Hybrid Drone Simulation with Shared Memory and Advanced Synchronization

## Introdução

Este sprint teve como objetivo implementar uma simulação híbrida de drones com:
- Um processo pai multithreaded,
- Processos filhos (drones) independentes,
- Comunicação via memória partilhada POSIX,
- Sincronização rigorosa utilizando semáforos, mutexes e variáveis de condição,
- Terminação automática via sinais quando atingido um número limite de colisões.

O sistema foi desenvolvido com base nos requisitos definidos nas User Stories US361 a US365.

---

## Soluções Adotadas

### Arquitetura Híbrida

- O processo principal cria processos drone independentes (via `fork()` + `execl()`).
- Foi alocada uma zona de memória partilhada (`/shm_sim`) contendo:
    - Dados dos drones,
    - Log de colisões,
    - Passo atual da simulação,
    - Variáveis de sincronização (mutex e condições).
- Foram criadas duas threads no processo principal:
    - `collision_thread_func` para deteção de colisões,
    - `report_thread_func` para geração de relatórios em tempo real.

### Sincronização Passo-a-Passo

- A cada passo:
    - O processo principal liberta todos os drones com `sem_post(sem_drone_sync)`.
    - Cada drone atualiza os seus dados na memória e responde com `sem_post(sem_main_sync)`.
    - Só depois de todos responderem é que o passo avança.
- A progressão é protegida com `sem_mutex`.

### Comunicação entre Threads

- As threads internas usam `pthread_mutex_t` e `pthread_cond_t` para comunicação:
    - Quando ocorre uma colisão, a thread de colisão envia sinal à de relatório via `pthread_cond_signal(&new_collision_cond)`.
    - A thread de relatório permanece suspensa até receber o sinal (`pthread_cond_wait`).

### Relatório Final

- O relatório final (`simulator_report.txt`) inclui:
    - Número de drones,
    - Total de passos,
    - Colisões detalhadas (drone1, drone2, coordenadas, passo),
    - Trajetórias completas por drone.

---

## Opções Consideradas e Justificações

| Alternativa analisada                              | Motivo de exclusão                                                            |
|----------------------------------------------------|--------------------------------------------------------------------------------|
| Apenas semáforos POSIX                             | Ineficiente para comunicação entre threads com condições específicas.         |
| Busy-wait com `sleep()`                            | Pouco reativo e consumo de CPU desnecessário.                                 |
| Comunicação via `pipe` entre threads               | Não é apropriada nem necessária em comunicação intra-processo.                |
| Execução sem mecanismos de exclusão                | Leva a race conditions e resultados inconsistentes.                           |

A solução final combina as abordagens mais eficientes para cada tipo de sincronização:
- **Semáforos POSIX** para processos (drones),
- **Mutexes e condições pthread** para threads internas.

---

## Coerência com a Implementação

Todas as funcionalidades descritas correspondem diretamente ao que foi desenvolvido e testado:

- Os ficheiros `main.c`, `drone.c`, `report.c` e `shared.h` implementam rigorosamente a sincronização descrita.
- As variáveis globais de sincronização (`sem_t*`, `pthread_mutex_t`, `pthread_cond_t`) são inicializadas corretamente.
- A progressão passo a passo está controlada por contadores e semáforos.
- A deteção de colisões segue a lógica de verificação de duplicados e limitação (`MAX_COLLISION_LOG`).
- O relatório é escrito automaticamente no final e segue o formato exigido.

---

## Uso de Variáveis de Exclusão e Condição

A sincronização entre processos e threads foi feita com:

### Variáveis de Exclusão Mútua

- `sem_mutex` — semáforo POSIX para proteger a memória partilhada entre processos.
- `thread_sync_mutex` — mutex pthread para proteger acesso simultâneo à estrutura partilhada entre threads.

### Variáveis de Condição

- `step_completed_cond` — sinaliza que um passo foi concluído.
- `new_collision_cond` — sinaliza que uma colisão foi registada.
- `simulation_over_cond` — usada para indicar fim da simulação.

Exemplo de uso correto:

```c
pthread_mutex_lock(&shm->thread_sync_mutex);
while (shm->next_collision_to_report >= shm->collision_log_count && !shm->simulation_finished_flag)
    pthread_cond_wait(&shm->new_collision_cond, &shm->thread_sync_mutex);
// Processar colisão
pthread_mutex_unlock(&shm->thread_sync_mutex);
```

Este padrão garante que o acesso aos dados é seguro e que as threads apenas acordam quando têm trabalho a executar.

---

## Conclusão

A arquitetura implementada cumpre todos os requisitos funcionais do Sprint 3:

- Simulação híbrida passo-a-passo,
- Memória partilhada eficiente entre processos,
- Deteção e registo de colisões em tempo real,
- Geração automática de relatório final.

A utilização combinada de **semáforos POSIX** e **mecanismos pthread** (mutexes e variáveis de condição) garante robustez, desempenho e capacidade de extensão futura.

---

## Possibilidades Futuras

- Simulação distribuída entre máquinas (via TCP ou UDP).
- Interface gráfica em tempo real para visualização das trajetórias.
- Suporte a drones com autonomia parcial e lógica local.
- Validação de segurança das rotas antes da simulação.
- Exportação dos resultados para análise estatística ou dashboards.
