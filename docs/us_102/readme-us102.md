# US 102 – Project Repository

## 1. Context

This is the first time this task is assigned and it must be completed in Sprint 1. The goal of US102 is to ensure the team is working in a structured and professional environment with proper version control and project organization from the beginning.

The team must use the provided GitHub Classroom repository, organize it properly, and adopt a tool for project management (e.g., GitHub Projects).

### 1.1 List of issues

**Analysis:**
- Understand GitHub Classroom setup


**Design:**
- Decide on initial folder structure


**Implement:**
- Initialize repository with README, docs folder, and base structure
- Set up GitHub Project board

**Test:**
- Validate correct repository access
-

---

## 2. Requirements

**US102** – *As Project Manager, I want the team to use the defined project repository in GitHub and setup a GitHub tool for project management.*

### Acceptance Criteria:

**Dependencies/References:**

- Relates to US103 (Project structure setup)
- Relates to NFR04 (Source control)

---

## 3. Analysis

- The GitHub repository was provided via GitHub Classroom and follows standard naming.
- GitHub Projects (Kanban-style) allows for clear task tracking.
- Documentation folder (`/docs`) is needed for reporting.
- Using issues and branches supports asynchronous and parallel development.

---

## 4. Design

### 4.1. Realization

- Project root includes:
    - `README.md`
    - `/src` – Source code
    - `/docs` – Markdown documentation (e.g., US102.md)
    - `/scripts` – Build and execution scripts

- GitHub Project board configured with:
    - Columns: Backlog, To Do, In Progress, Review, Done
    - Issues linked to USs and assigned with priority labels

### 4.3. Applied Patterns

- GitHub Flow (branch-based workflow)
- Semantic Commit Messages (e.g., `feat:`, `fix:`)

### 4.4. Acceptance Tests


## 5. Implementation

- `README.md` created with basic info and contribution guidelines.
- Repository contains base folders (`/docs`, `/src`, etc.)
- GitHub Project board created.
- Issues created for each Sprint 1 User Story.

### Major Commits:

- `init: initial commit with base structure`
- `docs: add US102 documentation`

---

## 6. Integration/Demonstration

- GitHub Project board integrated with Issues and PRs.
- Example issue assigned, worked on, PR created and merged.
- Validated via team walkthrough.

---

## 7. Observations

- The setup enables traceability, collaboration, and continuous progress tracking.
- The board helps with sprint planning and tracking.
- Future improvements include automation of some workflows using GitHub Actions.

---
