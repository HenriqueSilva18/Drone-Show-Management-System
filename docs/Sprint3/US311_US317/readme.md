# Sprint 3 – Show Proposal Management: US311 & US317

This document provides a detailed explanation of the design and execution flow of two user stories from Sprint 3:

- **US311 – Add drones to a proposal**
- **US317 – Mark show proposal as accepted**

For each user story, we present a Class Diagram (CD) and a Sequence Diagram (SD) to illustrate the structural and behavioral aspects of the implementation.

---

## US311 – Add drones to a proposal

### Objective

Allow a manager to populate a show proposal with available drone models until the total required number of drones has been assigned. This task is carried out through a console interface, interacting with the domain via a dedicated controller.

---

### Class Diagram

![US311 Class Diagram](US311%20-%20Add%20drones%20to%20a%20proposal/CD.png)
#### Detailed Explanation

- **PopulateModelListUI**: The entry point of this feature. It interacts with the manager via the console, collects inputs, and calls methods on the controller.

- **PopulateModelListController**:
    - Acts as the application service.
    - Fetches `ShowProposal` instances from the repository.
    - Builds DTOs (`PopulateProposalDTO`, `DroneModelDTO`) to decouple the domain from the UI.
    - Directly accesses the `modelList()` of a `ShowProposal` to assign drone models in available slots.
    - Persists the updated proposal after assignment.

- **ShowProposal**:
    - The core domain entity representing a show proposal.
    - Exposes `modelList()` so the controller can access and modify the list of assigned drone models.
    - Maintains the total number of drones required and the proposal's status.

- **DroneModel**:
    - Represents the type of drone that can be assigned to a proposal.
    - Drone models are stored separately and associated with proposals by position.

- **DTOs**:
    - `PopulateProposalDTO`: Contains summary information (proposal ID, number of drones required and already assigned).
    - `DroneModelDTO`: Used to present available drone models to the UI.

- **Repositories**:
    - `ShowProposalRepository`: Provides access to show proposals.
    - `DroneModelRepository`: Provides access to available drone models.
    - `DroneRepository`: Offers availability statistics (e.g., how many units of a model are available).

---

### Sequence Diagram

![US311 Sequence Diagram](US311%20-%20Add%20drones%20to%20a%20proposal/SD.png)

#### Detailed Explanation

1. **Listing Proposals**:  
   The UI calls `listUnassignedShowProposals()` to retrieve all proposals that still require drone models. The controller queries the repository, filters the results, and builds `PopulateProposalDTO` instances.

2. **Selecting a Proposal**:  
   The manager selects a proposal number, and the UI invokes `getProposalByNumber()`. The controller retrieves the full `ShowProposal` from the repository and returns a summary DTO.

3. **Listing Drone Models**:  
   The UI requests the list of available drone models using `listAvailableDroneModels()`. The controller fetches all models from the `DroneModelRepository` and converts them to `DroneModelDTO`s.

4. **Checking Model Availability**:  
   The manager selects a model, and the UI calls `countAvailableOfModel(modelId)` to check how many drones of that type are ready to use. The controller delegates this to the `DroneRepository`.

5. **Assigning the Model**:  
   The manager inputs a quantity to assign. The UI calls `assignModelToProposal()`. The controller:
    - Loads the proposal and the drone model.
    - Accesses the list of drone models via `modelList()`.
    - Fills available slots with the selected model.
    - Saves the updated proposal via the repository.

---

## US317 – Mark show proposal as accepted

### Objective

Allow a manager to accept or reject a show proposal. A proposal can only be accepted if it is not already accepted. Once accepted, the proposal status is updated and persisted.

---

### Class Diagram

![US317 Class Diagram](US317%20-%20Mark%20show%20proposal%20as%20accepted/CD.png)

#### Detailed Explanation

- **AcceptShowProposalUI**:
    - Handles user interaction through the console.
    - Requests the proposal number from the manager.
    - Displays the proposal and asks for confirmation.

- **AcceptShowProposalController**:
    - Orchestrates the flow for accepting or rejecting proposals.
    - Retrieves the proposal from the repository.
    - Verifies that the current status allows for the action.
    - Updates the status using `changeProposalStatus(...)`.
    - Saves the modified entity.

- **ShowProposal**:
    - Contains the current status, accessible through `status()`.
    - The status is updated using `changeProposalStatus(...)`.
    - Only the controller enforces business logic around status transitions.

- **ShowProposalStatus (enum)**:
    - Defines the lifecycle of a proposal: `CREATED`, `PENDENT`, `REJECTED`, `ACCEPTED`.

- **ShowProposalRepository**:
    - Interface responsible for accessing and persisting `ShowProposal` instances.

---

### Sequence Diagram

![US317 Sequence Diagram](US317%20-%20Mark%20show%20proposal%20as%20accepted/SD.png)

#### Detailed Explanation

1. **Retrieving the Proposal**:  
   The manager provides a proposal number. The UI calls `findNonAcceptedProposalByNumber()`. The controller queries the repository and filters out proposals already marked as `ACCEPTED`.

2. **Confirmation**:  
   If the proposal is valid, the UI displays it and asks the manager to confirm the action.

3. **Accepting the Proposal**:  
   If confirmed, the UI invokes `acceptProposal(number)`. The controller:
    - Loads the proposal from the repository.
    - Verifies that its status is not `ACCEPTED`.
    - Calls `changeProposalStatus(ACCEPTED)` on the entity.
    - Persists the changes via the repository.

4. **(Optional) Rejecting a Proposal**:  
   If the manager chooses to reject instead, the controller calls `changeProposalStatus(REJECTED)` and saves the proposal.


## Test Coverage

This section documents the test coverage for both user stories implemented in Sprint 3. Each method is illustrated with an image showing the actual unit test code and assertions.

---

## US311 – Add drones to a proposal

### Class: `PopulateModelListControllerTest`

This test class verifies the controller’s ability to populate a show proposal with drone models and handle repository interactions correctly.

#### `testAssignModelToProposalAssignsCorrectly`

Verifies that the controller correctly assigns drone models into available slots in the proposal and persists the changes.

![testAssignModelToProposalAssignsCorrectly](US311%20-%20Add%20drones%20to%20a%20proposal/test_methods/testAssignModelToProposalAssignsCorrectly.png)

---

#### `testCountAvailableOfModelDelegatesToRepo`

Ensures the controller correctly delegates the responsibility of counting available drones to the `DroneRepository`.

![testCountAvailableOfModelDelegatesToRepo](US311%20-%20Add%20drones%20to%20a%20proposal/test_methods/testCountAvailableOfModelDelegatesToRepo.png)

---

#### `testGetProposalByNumberReturnsNullIfNotFound`

Checks that the method `getProposalByNumber` returns `null` when the proposal does not exist in the repository.

![testGetProposalByNumberReturnsNullIfNotFound](US311%20-%20Add%20drones%20to%20a%20proposal/test_methods/testGetProposalByNumberReturnsNullIfNotFound.png)

---

#### `testListUnassignedShowProposalsReturnsExpectedDTO`

Validates that the method filters proposals and only returns those that still need drones assigned.

![testListUnassignedShowProposalsReturnsExpectedDTO](US311%20-%20Add%20drones%20to%20a%20proposal/test_methods/testListUnassignedShowProposalsReturnsExpectedDTO.png)

---

## US317 – Mark show proposal as accepted

### Class: `AcceptShowProposalControllerTest`

This test class checks the logic for accepting and rejecting proposals, making sure state transitions are validated and saved correctly.

#### `testAcceptProposalChangesStatusToAccepted`

Ensures that the proposal status is updated to `ACCEPTED` and the change is persisted using the repository.

![testAcceptProposalChangesStatusToAccepted](US317%20-%20Mark%20show%20proposal%20as%20accepted/test_methods/testAcceptProposalChangesStatusToAccepted.png)

---

#### `testAcceptProposalThrowsIfAlreadyAccepted`

Confirms that trying to accept a proposal already marked as `ACCEPTED` throws an exception.

![testAcceptProposalThrowsIfAlreadyAccepted](US317%20-%20Mark%20show%20proposal%20as%20accepted/test_methods/testAcceptProposalThrowsIfAlreadyAccepted.png)

---

#### `testFindNonAcceptedProposalByNumberReturnsEmptyIfAccepted`

Checks that a proposal already marked as `ACCEPTED` is not returned by the lookup method.

![testFindNonAcceptedProposalByNumberReturnsEmptyIfAccepted](US317%20-%20Mark%20show%20proposal%20as%20accepted/test_methods/testFindNonAcceptedProposalByNumberReturnsEmptyIfAccepted.png)

---

#### `testFindNonAcceptedProposalByNumberReturnsProposalIfNotAccepted`

Ensures that proposals not yet accepted are returned properly for further action.

![testFindNonAcceptedProposalByNumberReturnsProposalIfNotAccepted](US317%20-%20Mark%20show%20proposal%20as%20accepted/test_methods/testFindNonAcceptedProposalByNumberReturnsProposalIfNotAccepted.png)

---

#### `testRejectProposalChangesStatusToRejected`

Checks that rejecting a proposal updates its status to `REJECTED` and saves the change through the repository.

![testRejectProposalChangesStatusToRejected](US317%20-%20Mark%20show%20proposal%20as%20accepted/test_methods/testRejectProposalChangesStatusToRejected.png)
   