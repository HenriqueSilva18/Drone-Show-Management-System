US323 - Edit Maintenance Type

1. Context

Allows CRM Collaborators to modify the name or description of existing maintenance types.

2. Requirements

As a CRM Collaborator, I want to edit an existing Maintenance Type.

Acceptance Criteria:

Type is selected by ID

Both name and description must be validated before update

3. Analysis

Uses MaintenanceType.update(newName, newDescription)

Repository: save(type) persists changes

4. Design

Controller:

EditMaintenanceTypeController

UI:

EditMaintenanceTypeUI

5. Implementation

Loads type by ID

Applies .update(...)

Saves via repository

6. Integration

Option in CRM Backoffice menu

Reuses MaintenanceTypeRepository