# US 105
# US 105 – Automated Deployment

## 1. Context

This task is being developed in **Sprint 1**. The goal is to provide simple and effective automation scripts to make project compilation, testing, and local execution easier for all team members. It ensures consistency across developer environments and simplifies usage for future users and evaluators.

### 1.1 List of issues

Analysis:
- Identify the most common commands needed: build, run, test.
- Clarify scope: remote deployment is out of Sprint 1.

Design:
- Define scripts for Windows and Unix-like systems.
- Decide naming conventions and folder organization (`scripts/`).

Implement:
- Create `.bat` and `.sh` scripts.
- Cover build, test and execution (where applicable).

Test:
- Execute scripts on different OSes.
- Validate that each script works independently.

## 2. Requirements

US105 – As Project Manager, I want the team to add to the project the necessary scripts, so that build/executions/deployments can be executed effortlessly.

Acceptance Criteria:
- US105.1 Scripts exist for compiling the full project (`build.bat`, `quick-build.bat`)
- US105.2 Scripts allow running tests with a single command.
- US105.3 Scripts are cross-platform (`.bat` and `.sh`)
- US105.4 Scripts are documented and included in the repository.

Dependencies/References:
- US102 (Project repo setup)
- US103 (Project structure)
- NFR04 (Automation and standardization)

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



Acceptance Tests:
- Test 1: Run build.bat and quick-build.bat successfully
- Test 2: Run test-all.bat and test-all.sh
- Test 3: Output messages are clear and useful

## 5. Implementation

Scripts created:

Windows:
build.bat: |
@echo off
echo Make sure JAVA_HOME is set to JDK folder
echo Make sure Maven is on the system PATH
mvn %1 dependency:copy-dependencies package

quick-build.bat: |
mvn -B %1 dependency:copy-dependencies verify -D maven.javadoc.skip=true

test-all.bat: |
@echo off
echo Running all tests...
mvn clean test

## 6. Integration/Demonstration

Usage:
- scripts/build.bat clean install
- scripts/test-all.sh

## 7. Observations

These scripts simplify onboarding and improve workflow consistency.

Future improvements:
- GitHub Actions for CI
- Remote deployment scripts using Docker or SSH
