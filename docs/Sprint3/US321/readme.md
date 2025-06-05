## US321 - Register Maintenance Type

### 1. Context

This README documents the design and implementation of **US321**, which allows CRM collaborators to register Maintenance Types in the Shodrone system.

#### 1.1 Issues

* Analysis: [GitHub Issue - US321 Analysis](#)
* Design: [GitHub Issue - US321 Design](#)
* Implementation: [GitHub Issue - US321 Impl](#)
* Test: [GitHub Issue - US321 Test](#)

---

### 2. Requirements

**US321 - Register Maintenance Type**

As a **CRM Collaborator**, I want to register a **Maintenance Type** (e.g., "Battery Inspection", "Propeller Replacement") so that they can later be used in Drone Models.

#### Acceptance Criteria:

* Each Maintenance Type must have a **unique name**.
* Each type must include a **non-empty description**.
* It must be possible to **edit** or **list** existing types.

---

### 3. Analysis

* `MaintenanceType` is a standalone aggregate root.
* It includes `name` and `description` fields.
* Linked to `DroneModel`, which can reference it for scheduling purposes.

**Excerpt Domain Model:**

```
+------------------------+
|    DroneModel          |
|------------------------|
| id : Long              |
| name : String          |
| language : Language    |
| specs : List<String>   |
| maintenanceType        |--> MaintenanceType
+------------------------+

+------------------------+
| MaintenanceType        |
|------------------------|
| id : Long              |
| name : String          |
| description : String   |
+------------------------+
```

---

### 4. Design

#### 4.1 Class Diagram (CD)

See `US321-CD.puml`

* `MaintenanceType` entity
* `CreateMaintenanceTypeController`, `ListMaintenanceTypesController`, `EditMaintenanceTypeController`
* Repositories and UI integration

#### 4.2 Sequence Diagram (SD)

See `US321-SD.puml`

* CRM Collaborator initiates type registration
* UI collects and validates input
* Controller and Repository handle persistence

#### 4.3 Patterns Applied

* **DDD**: Aggregate Root, Repository Pattern
* **GRASP**: Controller, Creator, Information Expert

---

### 5. Implementation

#### Domain Layer

* `MaintenanceType.java`

    * Validates name and description (non-null, non-empty)
    * Supports `update(name, description)`

#### Repositories

* `MaintenanceTypeRepository.java` (custom, no Spring)
* `JpaMaintenanceTypeRepository.java`
* `InMemoryMaintenanceTypeRepository.java`

#### Application Layer

* `CreateMaintenanceTypeController.java`
* `EditMaintenanceTypeController.java`
* `ListMaintenanceTypesController.java`

#### UI (Console Backoffice)

* `AddMaintenanceTypeUI.java`
* `EditMaintenanceTypeUI.java`
* `ListMaintenanceTypesUI.java`

---

### 6. Integration

* Accessible via **Backoffice Menu** under CRM role
* Drone Model creation/edition uses `MaintenanceType` as a required attribute
* Supported by in-memory and JPA persistence

---

### 7. Observations

* Role validation handled by `AuthorizationService`
* Bootstrap with default maintenance types can be implemented in a future US
* Code follows full EAPLI style (no Spring Data)

---

### 8. Diagrams

* US321-CD.puml
* US321-SD.puml
* US321-DM-EXCERPT.puml
