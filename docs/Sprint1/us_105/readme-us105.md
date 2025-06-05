# US105 - Automated deployment

## 1. Context

This task is being developed in **Sprint 1**. The goal is to provide simple and effective automation scripts to make project compilation, testing, and local execution easier for all team members. It ensures consistency across developer environments and simplifies usage for future users and evaluators.

### 1.1 List of issues

Analysis: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/97)

Design: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/98)

Implement: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/99)

Test: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/96)

## 2. Requirements

**US105** – As Project Manager, I want the team to add to the project the necessary scripts, so that build/executions/deployments can be executed effortlessly.

**Acceptance Criteria:**

- US105.1 - Scripts for compiling the full project.
- US105.2 - Scripts for running tests.
- US105.3 - Scripts for clean Maven project.

**Dependencies/References:**

- There is a dependency on US101 (non-functional requirements, constraints and concerns in section 5).
- There is a dependency on US102 (Project Repository) as the repository must be created.

## 3. Analysis

The team analyzed the necessary build, test, and deployment steps. The focus was on simplifying local setup and ensuring consistency across environments.

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

The implementation of US105 involves:
- Develop a script to automate the build process, including dependency installation and compilation.
- Develop scripts for executing unit and integration tests automatically before deployment.
- Write deployment automation scripts, ensuring rollback capabilities.
- Integrate scripts into the CI/CD pipeline to streamline build, test, and deployment processes.

## 6. Integration/Demonstration

### **Usage:**

To build the project on Windows:

    ./build-all.bat

on Linux/unix/macOS:

    ./build-all.sh

To run tests on the project on Windows:

    ./test-all.bat

on Linux/unix/macOS:

    ./test-all.sh

To generate plantuml diagrams (for the moment, only for linux/unix/macos):

    ./generate-plantuml-diagrams.sh

## 7. Observations

- n/a