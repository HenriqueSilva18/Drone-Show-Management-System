# US 104
## 1. Context

This task is being developed in **Sprint 1** and aims to create the initial version of the domain model of the system. The domain model will guide the design of the system's business logic and will be used in future user stories that involve business rules, persistence, and integration between modules.

### 1.1 List of issues

**Analysis:**
- Identify core entities, value objects and aggregates.
- Understand how the drone shows work (requests, figures, proposals, execution).

**Design:**
- Draw the initial class diagram.
- Organize entities into aggregates.
- Apply DDD principles.

**Implement:**
- Define Java classes/interfaces for aggregates and value objects.
- Use annotations or documentation to clarify roles (Entity, AggregateRoot, ValueObject).

**Test:**
- Validate model consistency (e.g., ID uniqueness, immutability of value objects).
- Compile domain module.

---

## 2. Requirements

**US104** – *As Domain Expert, I want the system's domain model to reflect the core business rules and entities so that development can follow a consistent, realistic design.*

### Acceptance Criteria:

- US104.1 The domain model must be implemented using DDD (aggregates, entities, value objects).
- US104.2 Class diagrams and documentation must exist under `docs/`.
- US104.3 Each aggregate must clearly identify its root.
- US104.4 Relationships between aggregates must be defined via IDs (not direct object references).

### Dependencies/References:

- Related to US103 (Project structure)
- Enables US110 (Domain logic implementation)
- Refers to domain documentation provided by the Product Owner

---

## 3. Analysis

The team analyzed the main business concepts: Client, Drone, DroneModel, Figure, Show, ShowProposal, ShowRequest, Maintenance, and User. Each of these was evaluated as a candidate for an aggregate.

The model is heavily influenced by Domain-Driven Design (Evans) and follows DDD terminology:
- Entities have identity and lifecycle.
- Value Objects are immutable and compared by value.
- Aggregates encapsulate consistency boundaries.

---

## 4. Design

### 4.1. Realization

Main aggregates defined:
- **Client** – root: `Client`, has: `ClientId`, `ClientStatus`, `Representative`.
- **Drone** – root: `Drone`, has: `DroneId`, `DroneState`, `Maintenance`, related to `DroneModelId`.
- **DroneModel** – root: `DroneModel`, has: `DroneModelId`, `ModelSpecifications`.
- **Figure** – root: `Figure`, has: `FigureId`, `Description`, `dslCode`, etc.
- **Show** – root: `Show`, has: `ShowId`, references `DroneId`, `FigureId`.
- **ShowProposal** – root: `ShowProposal`, has: `ProposalId`, `ShowId`, `ClientId`.
- **ShowRequest** – root: `ShowRequest`, has: `ShowRequestId`, `ClientId`, `Description`.

Relationships use only IDs to ensure aggregate isolation and loose coupling.

![a class diagram](class-diagram-us104.svg "A Class Diagram")

### 4.3. Applied Patterns

- **Domain-Driven Design (DDD)**: Entity, Aggregate, Value Object.
- **Separation of Concerns**: only the domain logic is represented here.

### 4.4. Acceptance Tests

**Test 1:** Domain module compiles successfully.  
**Refers to Acceptance Criteria:** US104.1

**Test 2:** All aggregates are implemented with a root and clear value objects.  
**Refers to Acceptance Criteria:** US104.3

**Test 3:** Diagrams exist under `docs/` and represent the model faithfully.  
**Refers to Acceptance Criteria:** US104.2

---

## 5. Implementation

All classes were placed in the `domain` module.

Classes created:
- `Client`, `ClientId`, `ClientStatus`, `Representative`, etc.
- `Drone`, `DroneId`, `DroneState`, `Maintenance`, etc.
- `Show`, `ShowId`, `Figure`, `FigureId`, etc.

Domain annotations or JavaDocs were used to mark roles (`@Entity`, `@AggregateRoot`, etc.).

### Main commits:
- `feat: initial domain model classes`
- `docs: add class diagram of aggregates`
- `chore: update domain module with full structure`

---

## 6. Integration/Demonstration

Domain module is referenced by `simulation-core`, `plugins`, etc.  
Other modules access aggregate roots via repositories or ID references.

To test:
```bash
cd domain
mvn clean compile