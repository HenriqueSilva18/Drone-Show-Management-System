# US322 - List Maintenance Types

## Objective

Allow a Drone Tech to view all maintenance types currently defined in the system. The list provides a comprehensive view of available maintenance types that can be applied to drone models, helping technicians plan and schedule maintenance operations.

## 1. Context

This README covers the implementation of user story US322 for listing maintenance types in the system.

### 1.1 List of issues

* Analysis: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/416#issue-3091392988)
* Design: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/418#issue-3091394112)
* Implement: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/417#issue-3091393756)
* Test: [GitHub issue link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/419#issue-3091394747)

## 2. Requirements

### US322 - List Maintenance Types

**As** a Drone Tech
**I want** to list all maintenance types in the system

**Acceptance Criteria:**
- Must display all maintenance types in the system
- Only authorized Drone Techs can view the list
- The list should include all relevant information about each maintenance type


## 4. Design

### 4.1. Maintenance Type Listing

- **Sequence Diagram**
![Sequence-Diagram.png](US322_SD.png)
- **Class Diagram**
![Class-Diagram.png](US322_CD.png)

### 4.2. Component Details

- **ListMaintenanceTypesUI**:
    - Handles user interaction through the console
    - Formats and displays the list of maintenance types
    - Shows ID, name, and description for each type
- **ListMaintenanceTypesController**:
    - Orchestrates the listing flow
    - Validates user authorization (DRONE_TECH role)
    - Retrieves all maintenance types
    - Converts domain objects to DTOs
- **MaintenanceType**:
    - Core domain entity for maintenance types
    - Provides access to type properties (id, name, description)
- **MaintenanceTypeDTO**:
    - Data transfer object for maintenance types
    - Contains only necessary display information
    - Handles domain object conversion
- **MaintenanceTypeRepository**:
    - Provides persistence operations
    - Handles retrieval of all maintenance types

### 4.3. Applied Patterns

* Domain-Driven Design (DDD):
  * Repository Pattern
  * DTO Pattern
  * Aggregate Root (MaintenanceType)

* GRASP:
  * Controller
  * Information Expert
  * Low Coupling
  * High Cohesion

## 5. Implementation

### Core Components

* List Management:
  * `ListMaintenanceTypesController` - Handles type listing
  * `MaintenanceTypeDTO` - Data transfer object for display
  * `MaintenanceType` - Domain entity with data access

* Repository Layer:
  * `MaintenanceTypeRepository` - Data access interface
  * `findAll()` method implementation
  * Efficient bulk data retrieval

### UI Components

* Console-based UI classes:
  * `ListMaintenanceTypesUI` - Handles type listing display
  * Tabular format for easy reading
  * Clear error messages for authorization issues

## 6. Integration/Demonstration

* The listing functionality is integrated in two ways:
  1. Direct Menu Option:
     * Available in the Drone Tech menu
     * Shows all available maintenance types
  2. Supporting Feature:
     * Used when selecting types for maintenance
     * Helps in maintenance planning

## 7. Observations

* List is retrieved in a single transaction
* Authorization is checked before data access
* DTOs prevent domain object exposure
* Supports future pagination if needed
