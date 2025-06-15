# US341 - Validate Figure Description

## 1. Context
This ReadME provides an overview of the User Story US341, which focuses on validating the syntax of figure descriptions (DSL) for show designs. The goal is to ensure that Show Designers can register figures in the system with syntactically correct descriptions.

### 1.1 List of Issues
US341 Issues: [GitHub issues link](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-2024-2025-sem4pi_2024_2025_g39/issues/363)

## 2. Requirements

### US341 - Validate Figure Description

As a Show Designer, I want to validate the syntax of the figure description (DSL), so that I can register the figure in the system.

### Acceptance Criteria:
- The system must validate DSL syntax using ANTLR parser.
- Validation errors must be clearly displayed to the user.
- Successfully validated DSL must extract and display the DSL version.
- Only syntactically correct figure descriptions can be registered in the system.
- The validation process must handle file input containing DSL code.

## 3. Analysis

### 3.1 Business Rules

* Authorization Rules:
    * Only authenticated users with SHOW_DESIGNER roles can validate figure descriptions.

* Validation Rules:
    * The DSL code must conform to the predefined grammar specification.
    * Figure declarations and actions must meet minimum count requirements.
    * The DSL must include a valid version declaration.
    * Validation must be performed before any figure registration attempt.
    * The system must provide detailed error messages for validation failures.

## 4. Design

### 4.1 Architecture
- Using the standard layered architecture of the application.
- Following Domain-Driven Design (DDD) principles.
- Integrating ANTLR for DSL parsing and validation.
- Adopting the use of DTOs for validation results.

### 4.2 Domain Classes

* Main Classes:
    * ValidateFigureDescriptionController - Application controller managing validation workflow and caching last valid results
    * FigureDescriptionValidationService - Core service handling DSL validation logic using ANTLR components
    * ValidationResult - DTO containing validation outcome, errors list, and parsed DSL version

* ANTLR Integration:
    * DSLValidationListener - Custom listener extending DSL_GRAMMARBaseListener for tracking figures, actions, drone types, and positions
    * DSLValidationVisitor - Visitor extending DSL_GRAMMARBaseVisitor for extracting DSL version and performing specific validations
    * ValidationErrorListener - Custom error listener for capturing ANTLR parsing errors
    * DSL_GRAMMARLexer, DSL_GRAMMARParser - ANTLR generated lexer and parser components

* Value Objects:
    * ValidationResult - Contains validation status, errors list, and parsed DSL version with factory methods for valid/invalid results

### 4.3 Controllers and Services

* Controller: ValidateFigureDescriptionController
    - Coordinates the validation process between UI and service layers.
    - Caches last valid DSL code and version for potential reuse.
    - Delegates actual validation to FigureDescriptionValidationService.

* Service: FigureDescriptionValidationService
    - Performs core DSL validation using ANTLR lexer, parser, and custom error handling.
    - Uses DSLValidationListener to track figure declarations, actions, drone types, and positions.
    - Uses DSLValidationVisitor to extract DSL version from parsed content.
    - Executes additional business rule validations (minimum figures, actions required).
    - Creates and returns ValidationResult objects with detailed error information.

### 4.4 Sequence Diagram
The validation process follows this sequence:
1. Show Designer requests validation through UI
2. UI prompts for and receives file path
3. UI reads DSL code from file and calls controller
4. Controller delegates validation to service
5. Service uses ANTLR components for parsing and validation
6. Validation results are passed back through the layers
7. UI displays success message with DSL version or error list

### 4.5 Class Diagram
The class diagram shows the relationships between:
- UI layer (ValidateFigureDescriptionUI)
- Application layer (ValidateFigureDescriptionController)
- Service layer (FigureDescriptionValidationService)
- ANTLR integration components (Listener and Visitor patterns)
- Data transfer objects (ValidationResult)

## 5. Implementation

### Core Components

* DSL Validation:
    * ValidateFigureDescriptionController - Orchestrates validation workflow and maintains state of last valid results
    * FigureDescriptionValidationService - Core validation logic using ANTLR lexer, parser, and custom components
    * ValidationResult - Encapsulates validation outcomes with factory methods for valid/invalid results

* ANTLR Integration:
    * DSLValidationListener - Extends DSL_GRAMMARBaseListener, tracks figure declarations, actions, drone types, and positions
    * DSLValidationVisitor - Extends DSL_GRAMMARBaseVisitor, extracts DSL version and performs specific validations
    * ValidationErrorListener - Custom error listener for capturing and formatting ANTLR parsing errors
    * Integration with ANTLR generated lexer and parser for robust DSL processing

* Business Rule Validations:
    * Minimum figure declaration validation (at least one figure required)
    * Action count validation (at least one action required)
    * DSL version extraction and validation
    * Empty/null DSL code validation

### UI Components

* Console-based UI classes:
    * ValidateFigureDescriptionUI - Comprehensive UI handling file input, validation process, and result display
    * File path input with cancellation support
    * Detailed error reporting and success confirmation
    * State management for validation results and user interaction flow

## 6. Integration/Demonstration
The system integrates DSL validation in the following ways:

1. Backoffice Application:
    * Menu option for Show Designer to validate figure descriptions.
    * File selection interface for DSL code input.
    * Clear display of validation results (success with version or error details).
    * Integration point for figure registration workflow.

2. Integration with other modules:
    * Figure Management - validation as prerequisite for figure registration.
    * File Management - reading DSL code from user-specified files.
    * Grammar Management - using predefined DSL grammar for validation.

## 7. Testing

### 7.1 Domain Tests

#### ValidationResult Tests (ValidationResultTest.java)

```java
@Test
void ensureCanCreateValidResult() {
    ValidationResult result = ValidationResult.valid("1.0");
    assertTrue(result.isValid());
    assertEquals("1.0", result.getDslVersion());
    assertTrue(result.getErrors().isEmpty());
}

@Test
void ensureCanCreateInvalidResult() {
    List<String> errors = Arrays.asList("Syntax error", "Missing declaration");
    ValidationResult result = ValidationResult.invalid(errors);
    assertFalse(result.isValid());
    assertEquals(2, result.getErrors().size());
    assertNull(result.getDslVersion());
}

@Test
void ensureCannotCreateInvalidResultWithEmptyErrors() {
    assertThrows(IllegalArgumentException.class, 
        () -> ValidationResult.invalid(Collections.emptyList()));
}
```

#### FigureDescriptionValidationService Tests

```java
@Test
void ensureValidDslReturnsValidResult() {
    String validDsl = "version 1.0\nfigure test { drone_type d1; position p1; lights_on; }";
    ValidationResult result = service.validateFigureDescription(validDsl);
    assertTrue(result.isValid());
    assertEquals("1.0", result.getDslVersion());
}

@Test
void ensureInvalidDslReturnsErrorList() {
    String invalidDsl = "invalid syntax here";
    ValidationResult result = service.validateFigureDescription(invalidDsl);
    assertFalse(result.isValid());
    assertFalse(result.getErrors().isEmpty());
}

@Test
void ensureEmptyDslReturnsError() {
    ValidationResult result = service.validateFigureDescription("");
    assertFalse(result.isValid());
    assertEquals("DSL code cannot be empty", result.getErrors().get(0));
}

@Test
void ensureNullDslReturnsError() {
    ValidationResult result = service.validateFigureDescription(null);
    assertFalse(result.isValid());
    assertEquals("DSL code cannot be empty", result.getErrors().get(0));
}

@Test
void ensureMissingVersionReturnsError() {
    String dslWithoutVersion = "figure test { drone_type d1; lights_on; }";
    ValidationResult result = service.validateFigureDescription(dslWithoutVersion);
    assertFalse(result.isValid());
    assertTrue(result.getErrors().stream()
        .anyMatch(error -> error.contains("version not found")));
}

@Test
void ensureNoFigureDeclarationReturnsError() {
    String dslWithoutFigures = "version 1.0\n// no figures defined";
    ValidationResult result = service.validateFigureDescription(dslWithoutFigures);
    assertFalse(result.isValid());
    assertTrue(result.getErrors().stream()
        .anyMatch(error -> error.contains("Nenhuma declaração de figura encontrada")));
}

@Test
void ensureNoActionsReturnsError() {
    String dslWithoutActions = "version 1.0\nfigure test { drone_type d1; }";
    ValidationResult result = service.validateFigureDescription(dslWithoutActions);
    assertFalse(result.isValid());
    assertTrue(result.getErrors().stream()
        .anyMatch(error -> error.contains("Nenhuma ação definida")));
}
```

#### ValidateFigureDescriptionController Tests

```java
@Test
void ensureControllerCachesLastValidResult() {
    String validDsl = "version 1.0\nfigure test { drone_type d1; lights_on; }";
    ValidationResult result = controller.validateFigureDescription(validDsl);
    assertTrue(result.isValid());
    assertEquals(validDsl, controller.getLastValidDslCode());
    assertEquals("1.0", controller.getLastValidDslVersion());
}

@Test
void ensureControllerDoesNotCacheInvalidResult() {
    String invalidDsl = "invalid syntax";
    controller.validateFigureDescription(invalidDsl);
    assertNull(controller.getLastValidDslCode());
    assertNull(controller.getLastValidDslVersion());
}
```

### 7.2 Functional Tests

#### Test Case: Validate Figure Description

**ID:** #341  
**Description:** Validate the syntax of a figure description (DSL).

**Prerequisites:**

1. Authenticate as Show Designer.
2. Have DSL files available for testing (both valid and invalid).
3. System configured with DSL grammar definition.

**Test Steps:**

1. Validate a correct DSL file:
    1. Select a file containing valid DSL syntax.
    2. Verify the system parses the DSL successfully.
    3. Confirm the DSL version is extracted and displayed.
    4. Verify success message is shown.

2. Validate an incorrect DSL file:
    1. Select a file containing invalid DSL syntax.
    2. Verify the system detects syntax errors.
    3. Confirm detailed error messages are displayed.
    4. Verify validation failure is clearly indicated.

3. Validate DSL with missing version:
    1. Select a file with valid syntax but missing version declaration.
    2. Verify the system reports missing version error.
    3. Confirm validation fails appropriately.

4. Validate empty or malformed file:
    1. Select an empty file or file with completely malformed content.
    2. Verify the system handles the error gracefully.
    3. Confirm appropriate error messages are displayed.

5. File handling validation:
    1. Test with non-existent file path.
    2. Test with files containing special characters.
    3. Verify proper error handling for file access issues.

## 8. Observations

* The validation process uses ANTLR for robust DSL parsing with custom error handling through ValidationErrorListener.
* ValidationResult encapsulates all validation outcomes with factory methods (valid/invalid) for consistent object creation.
* The system provides detailed error messages in Portuguese to help Show Designers correct DSL syntax issues.
* DSLValidationListener tracks multiple DSL elements: figures, actions, drone types, and positions for comprehensive validation.
* DSLValidationVisitor specifically handles DSL version extraction from the parsed syntax tree.
* The controller caches the last valid DSL code and version for potential reuse in subsequent operations.
* Business rule validations include minimum requirements: at least one figure declaration and one action.
* File reading and DSL parsing are handled with comprehensive error handling for various failure scenarios.
* The UI provides user-friendly file input with cancellation support and clear success/error reporting.
* The system handles edge cases like empty files, invalid paths, and null/empty DSL content gracefully.
* All validation errors are collected and presented together rather than failing on the first error encountered.