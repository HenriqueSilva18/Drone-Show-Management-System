US322 - List Maintenance Types

1. Context

Allows CRM Collaborators to view all existing maintenance types.

2. Requirements

As a CRM Collaborator, I want to list all existing Maintenance Types.

Acceptance Criteria:

System displays all types with name and description.

3. Analysis

Reads from MaintenanceTypeRepository.findAll()

4. Design

Controller:

ListMaintenanceTypesController

UI:

ListMaintenanceTypesUI

5. Implementation

listAllTypes() method returns all items from repository

6. Integration

Option in Backoffice Menu under CRM role