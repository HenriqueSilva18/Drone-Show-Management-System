# US 312 - Add Figure to Proposal

## 1. Context

This README covers the implementation of the user story for adding figures to show proposals in the system.

## 2. Requirements

### US - Add Figure to Proposal

As CRM_COLLABORATOR I want to add figures to an existing show proposal so that I can customize the drone show with specific formations and performances. Each figure requires specific drone types to be mapped to available drone models in the proposal.

**Acceptance Criteria:**
- Only authenticated users with CRM_COLLABORATOR roles can add figures to proposals
- Users can select from available active figures
- System must validate that the same figure cannot be added consecutively
- Each drone type required by the figure must be mapped to an available drone model in the proposal
- The figure is successfully added to the proposal with the specified drone mappings

## 3. Analysis

### 3.1 Business Rules

* Authorization Rules:
    * Only authenticated users with CRM_COLLABORATOR roles can add figures to proposals

* Figure Selection Rules:
    * Only active figures can be selected for addition to proposals
    * The same figure cannot be added in consecutive positions within a proposal
    * Figures must exist in the system and be accessible

* Drone Mapping Rules:
    * Each drone type required by the selected figure must be mapped to an available drone model
    * Drone models must be available in the selected proposal
    * All required drone types must have corresponding model mappings
    * The mapping must be complete before the figure can be added

* Proposal Rules:
    * The target proposal must exist in the system
    * Proposals must have available drone models for mapping
    * The proposal is updated and saved after successful figure addition

## 4. Design

### 4.1 Architecture

* Using the standard layered architecture of the application
* Following DDD principles
* Adopting the use of DTOs for data transfer
* Implementing proper separation of concerns between UI, Controller, and Domain layers

### 4.2 Domain Classes

* Aggregate Roots:
    * `ShowProposal` - Main aggregate root containing:
        * Identity: Integer (proposal number)
        * Collection of figures with drone mappings
        * Available drone models
        * Business logic for adding figures
    * `Figure` - Independent aggregate containing:
        * Identity: Long (figure ID)
        * Description and status information
        * Required drone types
        * Activation status

* Domain Entities:
    * `DroneModel` - Entity representing drone models with:
        * Identity: Long (model ID)
        * Name and type information
        * Association with drone types
    * `FigureInShowProposal` - Association entity linking figures to proposals with drone mappings

* Value Objects:
    * `DroneType` -  Representing different types of drones


### 4.3 Controllers and Repositories

* Controller: `AddFigureToProposalController`
    * Handles user authorization and validation
    * Manages the figure addition process
    * Coordinates between multiple repositories
    * Validates business rules and constraints
    * Handles DTO conversions

* Repositories:
    * `ShowProposalRepository` - Manages show proposals data access
    * `FigureRepository` - Manages figures data access
    * Both extend `DomainRepository` interface

* Services:
    * `AuthorizationService` - Handles user authentication and authorization

### 4.4 DTOs (Data Transfer Objects)

* `ShowProposalDTO` - Transfer object for proposal information
* `FigureDTO` - Transfer object for figure information
* `DroneModelDTO` - Transfer object for drone model information

### 4.5 Sequence Diagram
The sequence diagram shows the complete interaction flow between all classes involved in the add figure to proposal process, including authorization checks, data retrieval, validation, and figure addition.

### 4.6 Class Diagram
The class diagram illustrates the relationships between all domain classes, controllers, repositories, and DTOs involved in the use case.

## 5. Implementation

### Core Components

* Figure Management:
    * `AddFigureToProposalController` - Handles the complete figure addition process
    * `AddFigureToProposalUI` - Console-based user interface for figure selection and drone mapping
    * Business logic for consecutive figure validation

* Domain Models:
    * `ShowProposal` - Aggregate root managing proposal state and figure collection
    * `Figure` - Entity representing available figures with drone type requirements
    * `DroneModel` - Entity representing available drone models
    * `FigureInShowProposal` - Association class managing figure-to-proposal relationships
    * `DroneType` - Enumeration for drone type classification

* Repository Layer:
    * `ShowProposalRepository` - Data access interface for proposals with methods for finding by proposal number
    * `FigureRepository` - Data access interface for figures with methods for finding active figures
    * Both repositories provide comprehensive CRUD operations and specialized queries

* Authorization:
    * `AuthorizationService` - Service ensuring proper user permissions throughout the process

### UI Components

* Console-based UI classes:
    * `AddFigureToProposalUI` - Handles the complete user interaction flow:
        * Proposal selection from available proposals
        * Figure selection from active figures
        * Drone type to drone model mapping
        * Confirmation and error handling
    * Integration with existing menu system

### Key Methods

* `AddFigureToProposalController`:
    * `listAllProposals()` - Retrieves all available proposals
    * `availableActiveFigures()` - Gets all active figures
    * `droneTypesOfFigure(Long figureId)` - Gets required drone types for a figure
    * `availableModels(int proposalId)` - Gets available drone models for a proposal
    * `isLastFigureSameAs(Long figureId, int proposalId)` - Validates consecutive figure rule
    * `getDroneModelByID(int number, Long id)` - Retrieves specific drone model
    * `addFigureToProposal(int number, Long figureId, Map<DroneType, DroneModel> droneMapping)` - Main business operation

## 6. Integration/Demonstration

* The system integrates figure addition to proposals in the following ways:
    1. Backoffice Application:
        * Menu option for CRM_COLLABORATOR to add figures to proposals
        * Interactive console interface for proposal and figure selection
        * Drone type to model mapping interface
        * Real-time validation and error feedback
        * Confirmation of successful figure addition

    2. Integration with other modules:
        * Show Proposal Management - for proposal retrieval and updates
        * Figure Management - for figure availability and drone type requirements
        * Drone Model Management - for model availability and specifications
        * Authorization Management - for user permission validation

    3. Data Flow:
        * Retrieves existing proposals from the repository
        * Fetches active figures and their requirements
        * Maps user selections to domain objects
        * Validates business rules before persistence
        * Updates proposal state with new figure and mappings

## 7. Testing Scenarios

### 7.1 Domain Tests

#### Add Figure to Proposal Tests (`AddFigureToProposalControllerTest.java`)


### **Test 1:** Successful figure addition to proposal
```java
@Test
void addFigureToProposal_successfulAdd_shouldSaveProposal() {
    // Arrange
    int proposalId = 1;
    Long figureId = 10L;

    ShowProposal proposal = mock(ShowProposal.class);
    Figure figure = mock(Figure.class);
    Map<DroneType, DroneModel> mapping = new HashMap<>();

    when(proposalRepo.findByProposalNumber(proposalId)).thenReturn(Optional.of(proposal));
    when(figureRepo.findById(figureId)).thenReturn(Optional.of(figure));

    // Act
    controller.addFigureToProposal(proposalId, figureId, mapping);

    // Assert
    verify(proposal).addFigure(figure, mapping);
    verify(proposalRepo).save(proposal);
}
```
**Objective:** Verify that a figure can be successfully added to an existing proposal. The test confirms that:
- The proposal is found by ID
- The figure is found by ID
- The `addFigure` method is called on the proposal
- The proposal is saved to the repository

### **Test 2:** Failure when adding figure with invalid proposal
```java
@Test
void addFigureToProposal_invalidProposal_shouldThrowException() {
    // Arrange
    int invalidId = 999;
    when(proposalRepo.findByProposalNumber(invalidId)).thenReturn(Optional.empty());

    // Act + Assert
    assertThrows(IllegalArgumentException.class, () ->
            controller.addFigureToProposal(invalidId, 1L, new HashMap<>()));
}
```
**Objective:** Verify that an `IllegalArgumentException` is thrown when attempting to add a figure to a proposal that doesn't exist.

### **Test 3:** Failure when adding invalid figure
```java
@Test
void addFigureToProposal_invalidFigure_shouldThrowException() {
    // Arrange
    int proposalId = 1;
    long invalidFigureId = 999L;

    when(proposalRepo.findByProposalNumber(proposalId)).thenReturn(Optional.of(mock(ShowProposal.class)));
    when(figureRepo.findById(invalidFigureId)).thenReturn(Optional.empty());

    // Act + Assert
    assertThrows(IllegalArgumentException.class, () ->
            controller.addFigureToProposal(proposalId, invalidFigureId, new HashMap<>()));
}
```
**Objective:** Verify that an `IllegalArgumentException` is thrown when attempting to add a figure that doesn't exist to a valid proposal.

### **Test 4:** Figure addition with valid inputs
```java
@Test
void addFigureToProposal_shouldSucceedWithValidInputs() {
    // Arrange
    int proposalId = 100;
    Long figureId = 1L;

    Map<DroneType, DroneModel> droneMapping = new HashMap<>();

    when(proposalRepo.findByProposalNumber(proposalId)).thenReturn(Optional.of(sampleProposal));
    when(figureRepo.findById(figureId)).thenReturn(Optional.of(sampleFigure));

    // Act
    assertDoesNotThrow(() -> controller.addFigureToProposal(proposalId, figureId, droneMapping));

    // Assert
    verify(sampleProposal).addFigure(sampleFigure, droneMapping);
    verify(proposalRepo).save(sampleProposal);
}
```
**Objective:** Verify that adding a figure to a proposal doesn't throw exceptions when all parameters are valid. Confirms that the `addFigure` method is called and the proposal is saved.

### **Test 5:** Failure when figure is not found
```java
@Test
void addFigureToProposal_shouldThrowIfFigureNotFound() {
    // Arrange
    int proposalId = 100;
    Long figureId = 999L;

    when(proposalRepo.findByProposalNumber(proposalId)).thenReturn(Optional.of(sampleProposal));
    when(figureRepo.findById(figureId)).thenReturn(Optional.empty());

    // Act & Assert
    assertThrows(IllegalArgumentException.class, () ->
            controller.addFigureToProposal(proposalId, figureId, new HashMap<>()));
}
```
**Objective:** Verify that an `IllegalArgumentException` is thrown when attempting to add a non-existent figure to a valid proposal.

## Last Figure Verification Tests

### **Test 6:** Verify if last figure is the same (returns true)
```java
@Test
void isLastFigureSameAs_shouldReturnTrueIfSame() {
    // Arrange
    int proposalId = 1;
    long figureId = 100L;

    Figure lastFigure = mock(Figure.class);
    when(lastFigure.identity()).thenReturn(figureId);

    ShowProposal proposal = mock(ShowProposal.class);
    when(proposalRepo.findByProposalNumber(proposalId)).thenReturn(Optional.of(proposal));

    FigureInShowProposal last = mock(FigureInShowProposal.class);
    when(last.figure()).thenReturn(lastFigure);
    when(proposal.figuresList()).thenReturn(List.of(last));

    // Act
    boolean result = controller.isLastFigureSameAs(figureId, proposalId);

    // Assert
    assertTrue(result);
}
```
**Objective:** Verify that the method returns `true` when the last figure in the proposal's figure list has the same ID as the provided one.

### **Test 7:** Verify behavior with empty list (returns false)
```java
@Test
void isLastFigureSameAs_shouldReturnFalseIfEmpty() {
    // Arrange
    int proposalId = 1;
    when(proposalRepo.findByProposalNumber(proposalId))
            .thenReturn(Optional.of(mock(ShowProposal.class)));

    when(proposalRepo.findByProposalNumber(proposalId).get().figuresList())
            .thenReturn(Collections.emptyList());

    // Act
    boolean result = controller.isLastFigureSameAs(99L, proposalId);

    // Assert
    assertFalse(result);
}
```
**Objective:** Verify that the method returns `false` when the proposal's figure list is empty.