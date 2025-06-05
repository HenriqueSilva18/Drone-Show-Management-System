# US104 - Continuous integration server

## 1. Context

This task is being done for the first time in **Sprint 1**. It focuses on setting up a Continuous Integration (CI) server to automatically build and test the project. The goal is to detect issues early, ensure code quality, and support a smooth development workflow.

### 1.1 List of issues

Analysis: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/93)

Design: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/94)

Implement: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/95)

Test: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/92)

## 2. Requirements

**US104** - As Project Manager, I want the team to setup a continuous integration server.

**Acceptance Criteria:**

- US104.1 - GitHub Actions/Workflows should be used.

**Dependencies/References:**

- There is a dependency on US101 (non-functional requirements, constraints and concerns in section 5).

## 3. Analysis

The team studied common CI/CD practices and tools to choose a setup. The analysis focused on automating builds, tests, and deployments efficiently.

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

To validate the functionality it was used:
- A test commit that caused the acceptance test to fail, was successfully reverted.

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