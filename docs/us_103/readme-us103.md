# US 103 – Project Structure Setup

## 1. Context

This task is being implemented for the first time during **Sprint 1**. It is a foundational task to define and organize the project structure, ensuring modularity, scalability, and maintainability. The goal is to prepare the system for upcoming user stories and simplify development across multiple modules.

### 1.1 List of issues

**Analysis:**
- Understand modular architecture using Maven.
- Identify required modules based on domain and functional requirements.

**Design:**
- Define folder/module structure.
- Establish naming conventions and dependencies.

**Implement:**
- Create Maven multi-module project.
- Implement folders: `domain`, `simulation-core`, `plugins`, `scripts`, `docs`.

**Test:**
- Compile all modules.
- Ensure isolated module builds and interactions work correctly.

---

## 2. Requirements

**US103** – *As Project Manager, I want the team to configure the project structure to facilitate/accelerate the development of upcoming user stories.*

### Acceptance Criteria:

- US103.1 The project must follow a modular Maven architecture.
- US103.2 The domain logic must be separated from technical concerns.
- US103.3 Plugins (like DSL and drone code generator) must be placed in their own modules.
- US103.4 Scripts and documentation should be clearly organized.

### Dependencies/References:

- Related to US102 (GitHub repo setup)
- Supports US110 (Domain Model)
- NFR04 – Use of version control
- NFR09 – Use of Java and modular design

---

## 3. Analysis

We reviewed best practices for Java modular systems and chose a Maven multi-module approach to split concerns clearly. This allows parallel development, plugin extensibility, and clean separation of logic. Inspired by Domain-Driven Design (DDD) and clean architecture.

---

## 4. Design

### 4.1. Realization

```text
project-root/
├── domain/
├── simulation-core/
├── plugins/
│   ├── dsl-parser/
│   └── drone-generator/
├── scripts/
├── docs/
└── pom.xml
