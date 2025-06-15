# Mark show proposal as accepted

## Objective

Allow a manager to accept or reject a show proposal. A proposal can only be accepted if it is not already accepted. Once accepted, the proposal status is updated and persisted.

---

## Class Diagram

![US317 Class Diagram](317CD.png)

### Detailed Explanation

- **AcceptShowProposalUI**: Handles user interaction through the console. Requests the proposal number from the manager. Displays the proposal and asks for confirmation.
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
- **ShowProposalStatus (enum)**: Defines the lifecycle of a proposal: `CREATED`, `PENDENT`, `REJECTED`, `ACCEPTED`.
- **ShowProposalRepository**: Interface responsible for accessing and persisting `ShowProposal` instances.

---

## Sequence Diagram

![US317 Sequence Diagram](317SD.png)

### Detailed Explanation

1. **Retrieving the Proposal**: The manager provides a proposal number. The UI calls `findNonAcceptedProposalByNumber()`. The controller queries the repository and filters out proposals already marked as `ACCEPTED`.
2. **Confirmation**: If the proposal is valid, the UI displays it and asks the manager to confirm the action.
3. **Accepting the Proposal**: If confirmed, the UI invokes `acceptProposal(number)`. The controller:
    - Loads the proposal from the repository.
    - Verifies that its status is not `ACCEPTED`.
    - Calls `changeProposalStatus(ACCEPTED)` on the entity.
    - Persists the changes via the repository.
4. **(Optional) Rejecting a Proposal**: If the manager chooses to reject instead, the controller calls `changeProposalStatus(REJECTED)` and saves the proposal.

---

## Test Coverage

### Class: AcceptShowProposalControllerTest

This test class checks the logic for accepting and rejecting proposals, making sure state transitions are validated and saved correctly.

#### testAcceptProposalChangesStatusToAccepted

Ensures that the proposal status is updated to ACCEPTED and the change is persisted using the repository.

![testAcceptProposalChangesStatusToAccepted](test_methods2/testAcceptProposalChangesStatusToAccepted.png)

---

#### testAcceptProposalThrowsIfAlreadyAccepted

Confirms that trying to accept a proposal already marked as ACCEPTED throws an exception.

![testAcceptProposalThrowsIfAlreadyAccepted](test_methods2/testAcceptProposalThrowsIfAlreadyAccepted.png)

---

#### testFindNonAcceptedProposalByNumberReturnsEmptyIfAccepted

Checks that a proposal already marked as ACCEPTED is not returned by the lookup method.

![testFindNonAcceptedProposalByNumberReturnsEmptyIfAccepted](test_methods2/testFindNonAcceptedProposalByNumberReturnsEmptyIfAccepted.png)

---

#### testFindNonAcceptedProposalByNumberReturnsProposalIfNotAccepted

Ensures that proposals not yet accepted are returned properly for further action.

![testFindNonAcceptedProposalByNumberReturnsProposalIfNotAccepted](test_methods2/testFindNonAcceptedProposalByNumberReturnsProposalIfNotAccepted.png)

---

#### testRejectProposalChangesStatusToRejected

Checks that rejecting a proposal updates its status to REJECTED and saves the change through the repository.

![testRejectProposalChangesStatusToRejected](test_methods2/testRejectProposalChangesStatusToRejected.png)


   