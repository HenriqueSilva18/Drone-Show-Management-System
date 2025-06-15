
# US376 – Show Testing

## Descrição

**User Story**:  
**Como** Drone Tech  
**Quero** selecionar um espetáculo para ser testado no Show Simulator  
**Para** que possa validar previamente o seu comportamento antes da execução real.

## Arquitetura Envolvida

A implementação da US376 respeita o modelo de componentes definido no Projeto 2 de RCOMP:

- `TestingApp` – Aplicação cliente usada pelo Drone Tech.
- `Simulator` – Servidor TCP que simula a execução do espetáculo.
- `Database` – (opcional) Fonte de dados com os shows disponíveis.

```
[TestingApp] ---> (TCP Socket) ---> [Simulator]
```

## Componentes

### TestingApp (cliente TCP)

- Escrita em Java ou C.
- Permite:
  - Listar shows disponíveis.
  - Escolher um show.
  - Enviar o show para o `Simulator` para testes.

### Simulator (servidor TCP)

- Recebe pedidos de teste de shows.
- Responde com ACK ou erro.
- Pode gerar logs ou simulações.

## Protocolo de Comunicação TCP

### Exemplo de pedido (JSON)
```json
{
  "command": "TEST_SHOW",
  "showId": 123
}
```

### Exemplo de resposta
```
ACK: Testing started for show 123
```

## Como Correr o Sistema

### 1. Compilar os componentes
```bash
javac TestingApp.java
javac Simulator.java
```

### 2. Iniciar o servidor (Simulator)
```bash
java Simulator
```

### 3. Executar o cliente (TestingApp)
```bash
java TestingApp
```

### 4. Selecionar um show e iniciar teste

A aplicação irá:

- Mostrar a lista de shows disponíveis.
- Pedir ao utilizador que escolha um show (por ID).
- Enviar o pedido ao Simulator por socket TCP.

## Estrutura do Projeto
```
/
├── README.md
├── TestingApp.java
├── Simulator.java
└── resources/
    └── mock_shows.json (opcional)
```

## Notas Técnicas

- A comunicação deve ser feita usando sockets TCP (Java: Socket, ServerSocket).
- O Simulator deve estar preparado para múltiplos clientes.
- Pode ser usado um protocolo próprio (ex: JSON) ou texto simples com separadores.

## Requisitos do Projeto 2

- Faz parte do backlog oficial do Projeto RCOMP 2.
- Comunicações entre aplicações devem usar sockets TCP.
- É exigida uma demonstração funcional fora da IDE e em ambientes distintos (cliente e servidor).
