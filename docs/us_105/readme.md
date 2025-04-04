# US 105


## 1. Context

This task is being developed in **Sprint 1**. The goal is to provide simple and effective automation scripts to make project compilation, testing, and local execution easier for all team members. It ensures consistency across developer environments and simplifies usage for future users and evaluators.

### 1.1 List of issues

Analysis:
- Identify the most common commands needed: build, run, test.

Design:

Implement:
- Create `.bat` and `.sh` scripts.

Test:
- Validate that each script works independently.

## 2. Requirements

US105 – As Project Manager, I want the team to add to the project the necessary scripts, so that build/executions/deployments can be executed effortlessly.

Acceptance Criteria:
- US105.1 Scripts exist for compiling the full project (`build.bat`, `quick-build.bat`)
- US105.2 Scripts allow running tests with a single command.
Dependencies/References:
- US102 (Project repo setup)
- US103 (Project structure)

## 3. Analysis

The team clarified with the instructor that deployment to other machines is out of scope for Sprint 1. Focus is on local automation: build, test and execute.

We identified three categories of scripts:
- Build scripts
- Test scripts
- Execution scripts (only if there's an app to run)

## 4. Design

Realization:
- Folder: `scripts/`
- Provided scripts:
    - `build.bat`
    - `quick-build.bat`
    - `test-all.bat`
    - `test-all.sh`

    


## 6. Integration/Demonstration

Usage:
- scripts/build.bat clean install
- scripts/test-all.sh

## 7. Observations

