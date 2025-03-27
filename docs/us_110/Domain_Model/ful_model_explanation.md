# Modelo de Domínio Avançado do Sistema Shodrone

Este documento apresenta uma explicação detalhada do modelo de domínio desenvolvido para o sistema Shodrone, que gerencia shows com drones e incorpora diversos conceitos do Domain-Driven Design (DDD). O modelo foi projetado para refletir os requisitos do projeto, tais como a gestão de clientes, usuários, drones, shows, figuras (figures), requisições e simulações, além de integrar funcionalidades avançadas como eventos de domínio, repositórios, especificações, serviços de domínio e aplicação, e uma camada de anti-corrupção.

---

## 1. Visão Geral do Modelo

O sistema Shodrone tem como objetivo gerenciar operações de uma empresa especializada em shows aéreos com drones. O modelo de domínio está dividido em duas grandes partes:

- **Core Domain:** Contém todas as entidades, agregados, value objects, eventos, repositórios, especificações e serviços que compõem o núcleo do negócio.
- **Anti-Corruption Layer:** Responsável por isolar o domínio de sistemas externos, garantindo que a integridade do modelo seja mantida mesmo quando integrando com outros sistemas.

---

## 2. Core Domain

Dentro do **Core Domain**, os principais elementos são agrupados para representar as regras e processos do negócio.

### 2.1 Entidades e Agregados

Cada entidade representa um objeto com identidade própria e é modelada para capturar aspectos essenciais do domínio. Alguns desses objetos são agregados, ou seja, constituem um cluster de objetos que devem ser consistentes e manipulados de forma conjunta.

- **User**  
  Representa um usuário do sistema (por exemplo, administradores ou colaboradores).  
  **Atributos:**
    - `id: UserId` – Identificador único (value object).
    - `username: Username` e `password: Password` – Dados de autenticação.
    - `email` e `phone` – Informações de contato.

- **Client**  
  Representa um cliente corporativo ou entidade pública.  
  **Atributos:**
    - `clientId: ClientId` – Identificador único (value object).
    - `vat` – Número de identificação fiscal europeu.
    - `address` – Endereço da entidade.

- **DroneModel**  
  Modela os diferentes tipos ou modelos de drones disponíveis.  
  **Atributos:**
    - `id: DroneModelId` – Identificador do modelo.
    - `name` – Nome do modelo.
    - `language` – Linguagem de programação suportada, indicando o código que pode ser gerado para este modelo.

- **Drone** (Aggregate Root)  
  Representa um drone específico que fará parte dos shows.  
  **Atributos:**
    - `id: DroneId` – Identificador único.
    - `droneModel: DroneModel` – Relação com o modelo do drone.
    - `serialNumber` – Número de série do drone.
    - `state: DroneState` – Estado atual do drone (por exemplo, ativo, em manutenção, etc.).
    - `maintenance_history: List<Maintenance>` – Histórico de manutenções realizadas.

- **Show** (Aggregate Root)  
  Representa um show com drones, composto por diversas figuras e drones envolvidos.  
  **Atributos:**
    - `id: ShowId` – Identificador único.
    - `date: DateValue` – Data e hora do show.
    - `figures: List<Figure>` – Lista de figuras que compõem o show.
    - `drones: List<Drone>` – Drones alocados para o show.

- **Figure**  
  Representa uma figura (ou sequência) que os drones executarão durante o show.  
  **Atributos:**
    - `id: FigureId` – Identificador único.
    - `description: Description` – Descrição textual da figura.
    - `dslCode` – Código gerado a partir da DSL (linguagem específica de domínio).
    - `version` – Versão da figura, permitindo atualizações sem impactar execuções anteriores.
    - `exclusive` – Indica se a figura é exclusiva para um cliente.

- **ShowProposal**  
  Representa a proposta de um show, que será enviada ao cliente após a validação da requisição.  
  **Atributos:**
    - `id: ProposalId` – Identificador único.
    - `show: Show` – Referência ao show proposto.

- **ShowRequest**  
  Representa uma requisição para um show, iniciada por um cliente.  
  **Atributos:**
    - `id: ShowRequestId` – Identificador único.
    - `client: Client` – Cliente solicitante.
    - `place` – Local do show.
    - `time: DateValue` – Data e hora solicitada.
    - `numberOfDrones` – Número aproximado de drones solicitados.
    - `description: Description` – Descrição ou documento com detalhes da requisição.
    - `status: RequestStatus` – Estado atual da requisição (por exemplo, pendente, aprovada, cancelada).

### 2.2 Value Objects

Os **Value Objects** são imutáveis e encapsulam atributos que possuem significado no domínio, sem identidade própria. Alguns exemplos:

- **Identificadores:**
    - `UserId`, `ClientId`, `DroneId`, `DroneModelId`, `ShowId`, `FigureId`, `ProposalId` e `ShowRequestId` – Cada um encapsula um valor único, garantindo a identidade das respectivas entidades.

- **Atributos de Autenticação:**
    - `Username` e `Password` – Garantem que os dados sensíveis sejam tratados de forma encapsulada.

- **Estado e Manutenção:**
    - `DroneState` – Representa o estado do drone.
    - `Maintenance` – Contém `maintenance_start_date` e `maintenance_final_date`, representando o período de manutenção de um drone.

- **Dados Temporais e Descritivos:**
    - `DateValue` – Um valor que encapsula datas e horários.
    - `Description` – Utilizado para armazenar descrições textuais de figuras ou requisições.
    - `RequestStatus` – Indica o status de uma requisição de show.

- **Coordenadas:**
    - `Position` – Representa a posição em um espaço 3D (x, y, z) e é utilizado na simulação para a detecção de colisões.

### 2.3 Eventos de Domínio

Os **Domain Events** capturam acontecimentos significativos no sistema, permitindo reações assíncronas e o desacoplamento entre componentes.

- **DroneMaintenanceCompletedEvent**  
  Disparado quando um drone conclui um ciclo de manutenção.  
  **Atributos:**
    - `droneId: DroneId`
    - `maintenance: Maintenance`
    - `occurredOn: DateValue`

- **ShowScheduledEvent**  
  Disparado quando um show é agendado.  
  **Atributos:**
    - `showId: ShowId`
    - `scheduledDate: DateValue`

- **CollisionDetectedEvent**  
  Disparado durante a simulação, caso seja detectada uma colisão entre drones.  
  **Atributos:**
    - `droneId: DroneId`
    - `position: Position`
    - `timestamp: DateValue`

### 2.4 Repositórios

Os **Repositórios** abstraem a camada de persistência e fornecem métodos para salvar e recuperar agregados.

- **DroneRepository**  
  Define operações para persistir e buscar drones, incluindo métodos para recuperar drones disponíveis de acordo com regras de negócio.

- **ShowRepository**  
  Gerencia a persistência de objetos do tipo `Show`.

- **ShowRequestRepository**  
  Responsável por operações relacionadas a requisições de show (`ShowRequest`).

### 2.5 Especificações

A classe **DroneAvailableSpecification** encapsula a regra de negócio que determina se um drone está disponível para ser alocado em um show. Esse padrão ajuda a centralizar e reutilizar regras de validação complexas.

### 2.6 Serviços de Domínio

Os **Serviços de Domínio** contêm regras de negócio que não se encaixam naturalmente em uma entidade ou value object, mas que fazem parte do núcleo do sistema.

- **Inventory**  
  Gerencia o inventário de drones disponíveis. Utiliza a `DroneAvailableSpecification` para filtrar e retornar os drones que podem ser alocados.  
  Também integra com sistemas externos por meio do `ExternalDroneSystemAdapter`.

- **SimulationService**  
  Responsável por simular a execução de uma figura. Por exemplo, pode simular o código da figura e retornar resultados sobre a segurança (verificação de colisões) e a execução do show.

### 2.7 Serviços de Aplicação

Os **Serviços de Aplicação** orquestram operações que envolvem interações entre múltiplos agregados e a camada de infraestrutura.

- **ShowApplicationService**  
  Responsável por processar a proposta de um show, interagindo com o `ShowRepository` para salvar o show e disparando o `ShowScheduledEvent` quando o agendamento for concluído.

---

## 3. Anti-Corruption Layer

Para evitar que sistemas externos corrompam ou influenciem indevidamente o modelo de domínio, foi introduzida uma camada de anti-corrupção:

- **ExternalDroneSystemAdapter**  
  Atua como uma interface entre o sistema Shodrone e sistemas externos de monitoramento ou controle dos drones. Por exemplo, o método `fetchDroneStatus` recupera o status de um drone em um sistema externo, mantendo o modelo de domínio isolado das variações externas.

---

## 4. Relacionamentos entre Componentes

O modelo de domínio estabelece diversas relações que garantem a integridade e a consistência do sistema:

- **Associações entre Entidades e Value Objects:**  
  Cada entidade possui um identificador (ex.: `UserId`, `ClientId`, etc.) que é representado por um value object, garantindo a imutabilidade e a consistência dos identificadores.

- **Relação entre Agregados:**
    - Um `Drone` está associado a um `DroneModel`, que define características essenciais do drone.
    - Um `Show` contém uma lista de `Figure` e de `Drone`, refletindo a composição de um show.
    - Uma `ShowProposal` encapsula um `Show`, representando a proposta a ser validada e enviada ao cliente.
    - Um `ShowRequest` associa um `Client` com os detalhes da requisição (local, data, quantidade de drones, etc.).

- **Eventos e Acionamentos:**
    - Alterações no estado de um `Drone` (como a conclusão de manutenção) podem disparar um `DroneMaintenanceCompletedEvent`.
    - O agendamento de um `Show` dispara um `ShowScheduledEvent`.
    - Durante a simulação, se dois drones se encontrarem na mesma posição, é disparado um `CollisionDetectedEvent`.

- **Interação via Repositórios e Especificações:**  
  Os repositórios isolam a persistência e permitem que os serviços de domínio e aplicação operem de forma consistente. A especificação de disponibilidade de drones é utilizada para filtrar os drones elegíveis para um show.

---

## 5. Conclusões

O modelo de domínio avançado apresentado:

- **Alinha-se com os Requisitos:**  
  Reflete as funcionalidades essenciais do sistema Shodrone, incluindo a gestão de usuários, clientes, drones, shows, figuras e requisições.

- **Incorpora Conceitos Avançados de DDD:**  
  Ao eliminar o uso desnecessário de fábricas e ao introduzir eventos, repositórios, especificações e serviços, o modelo torna-se mais robusto, modular e escalável.

- **Isola Integrações Externas:**  
  A camada de anti-corrupção assegura que sistemas externos possam ser integrados sem comprometer a integridade do modelo de domínio.

Este modelo serve como uma base sólida para o desenvolvimento do sistema, permitindo que os aspectos mais complexos do negócio sejam gerenciados de forma organizada e de acordo com as melhores práticas de engenharia de software.

---
