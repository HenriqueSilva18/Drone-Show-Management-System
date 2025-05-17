# Class Diagram - Figure Category Management

## Description

This class diagram shows the main components involved in the Figure Categories Management system:

1. **Controllers**: 
   - `AddFigureCategoryController`: Adds a new category
   - `EditFigureCategoryController`: Actualizes the description of a category
   - `ToggleFigureCategoryController`: Activates or deactivates a category 
   - `ListFigureCategoryController`: List all categories

2. **Domain Objects**:
   - `FigureCategory`: contains the properties of a category and the logic to update its description, activate or deactivate it, and check if it's active.

3. **Service**:
   - `FigureCategoryService`: contains the logic of the application and delegates the persistence to the repository. It also checks if the user has the necessary permissions to perform actions.

4. **Repositories**:
   - `FigureCategoryRepository`: Interface containing the methods to persist and retrieve categories for JPA and in-memory implementations.

5. **Authorization**:
   - `AuthorizationService`: Verifies if the user has the necessary permissions to perform actions.

## Usage
This class diagram is used to understand the structure and relationships between the components involved in managing figure categories. It provides a high-level overview of how the system is organized and how different parts interact with each other.



