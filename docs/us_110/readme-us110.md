# US110 - Domain model

## 1. Context

This task is being developed in Sprint 1. The goal is to create a comprehensive Domain Model using Domain-Driven Design (DDD) principles. This model is intended to capture the major business entities, their relationships, and the overall structure of the system. It lays the foundation for consistent design decisions in later development phases.

### 1.1 List of issues

Analysis: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/71)

Design: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/72)

Implement: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/74)

Test: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/70)

## 2. Requirements

**US110** – As Project Manager, I want the team to elaborate a Domain Model using DDD.

**Acceptance Criteria:**

- US110.1 - The domain model must clearly represent all key business entities and their relationships.
- US110.2 - The domain model diagram should be integrated into the project documentation repository and reviewed by the team for consistency.

**Dependencies/References:**

- There is a dependency on US101 (non-functional requirements, constraints and concerns in section 5).

## 3. Analysis

The team studied the requirements to identify the major entities, value objects, aggregates, and services within the system.

### 3.1. Domain Model

![Domain Model](Domain_Model/Global_Domain_Model.png)

### 3.2. Other Remarks

- n/a

## 4. Design

### 4.1. Realization

The Domain Model is realized through a class diagram that illustrates the key entities, their attributes, and relationships. The design ensures that business rules are encapsulated within the appropriate domain objects.
This analysis defined clear boundaries and interactions between components.

### 4.3. Applied Patterns

- **Entity and Value Object:** To distinguish between mutable entities and immutable value objects.
- **Aggregates:** For grouping related entities and ensuring consistency boundaries.

### 4.4. Acceptance Tests

- n/a

## 5. Implementation

The implementation of US105 involves:
- Identify the main domain concepts and entities.
- Define relevant methods and behaviors for each class.
- Create UML diagrams to illustrate the relationships between system entities.
- Review and validate the domain model with the team.
- Document the domain model and UML diagrams in the repository.
- Update the documentation based on team feedback and project evolution.

## 6. Integration/Demonstration

- n/a

## 7. Observations

- n/a
