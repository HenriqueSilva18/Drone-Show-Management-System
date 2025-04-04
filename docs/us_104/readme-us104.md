# US104 - Continuous integration server

## 1. Context

### 1.1 List of issues

Analysis: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/93)

Design: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/94)

Implement: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/95)

Test: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/92)


## 2. Requirements

**US104** - As Project Manager, I want the team to setup a continuous integration server.

**Acceptance Criteria:**

- GitHub Actions/Workflows should be used.

**Dependencies/References:**

- There is a dependency on Non-Functional Requirements (constraints and concerns in section 5).

## 3. Analysis

### 3.1. Relevant Domain Model Excerpt

- n/a

### 3.2. Other Remarks
- n/a

## 4. Design

### 4.1. Realization

- n/a

### 4.3. Applied Patterns

- n/a

### 4.4. Acceptance Tests

- n/a

## 5. Implementation

The implementation of US104 involves:
- Create the .github/workflows/maven.yml file in the repository.
- Configure the code checkout step.
- Add a step to compile the code.
- Add a step to run tests.
- Ensure that the workflow blocks merging if there are compilation or testing failures.
- Perform integration tests for the CI/CD process with test commits.

## 6. Integration/Demonstration

- n/a

## 7. Observations

- n/a