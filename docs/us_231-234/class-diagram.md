# Class Diagram - Figure Management

```mermaid
classDiagram
    class ListActivePublicFiguresUI {
        -FigureController controller
        +show()
        -displayFigures(Iterable~Figure~)
    }

    class SearchFigureCatalogueUI {
        -FigureController controller
        +show()
        -displaySearchResults(Iterable~Figure~)
    }

    class AddFigureToCatalogueUI {
        -FigureController controller
        +show()
        -displaySuccess(Figure)
    }

    class DecommissionFigureUI {
        -FigureController controller
        +show()
        -displaySuccess(Figure)
    }

    class FigureController {
        -FigureService figureService
        +listActivePublicFigures()
        +search(String)
        +addFigure(String, boolean, FigureCategory, VAT)
        +decommissionFigure(Figure)
    }

    class FigureService {
        -FigureRepository repo
        -AuthorizationService authz
        +findActivePublic()
        +searchByCategoryOrKeyword(String)
        +registerFigure(String, boolean, VAT, FigureCategory)
        +decommissionFigure(Figure)
    }

    class Figure {
        -Long id
        -String description
        -Set~String~ keywords
        -boolean exclusive
        -boolean isActive
        -LocalDateTime decommissionDate
        -FigureCategory category
        -VAT clientVAT
        +isActive()
        +isExclusive()
        +setActive(boolean)
        +setDecommissionDate(LocalDateTime)
    }

    class FigureCategory {
        -String name
        -String description
        -boolean isActive
        -LocalDateTime creationDate
        -LocalDateTime lastEditionDate
        +name()
        +description()
        +isActive()
        +deactivate()
        +activate()
        +updateDescription(String)
    }

    class FigureRepository {
        <<interface>>
        +findActivePublic()
        +searchByCategoryOrKeyword(String)
        +save(Figure)
        +ofIdentity(Long)
    }

    class JpaFigureRepository {
        +findActivePublic()
        +searchByCategoryOrKeyword(String)
        +save(Figure)
        +ofIdentity(Long)
    }

    class InMemoryFigureRepository {
        +findActivePublic()
        +searchByCategoryOrKeyword(String)
        +save(Figure)
        +ofIdentity(Long)
    }

    ListActivePublicFiguresUI --> FigureController
    SearchFigureCatalogueUI --> FigureController
    AddFigureToCatalogueUI --> FigureController
    DecommissionFigureUI --> FigureController
    FigureController --> FigureService
    FigureService --> FigureRepository
    FigureService --> AuthorizationService
    Figure "1" -- "1" FigureCategory
    FigureRepository <|.. JpaFigureRepository
    FigureRepository <|.. InMemoryFigureRepository
```

## Description

This class diagram shows the main components involved in the Figure Management system:

1. **User Interfaces**:
   - `ListActivePublicFiguresUI`: Displays active public figures
   - `SearchFigureCatalogueUI`: Handles figure search functionality
   - `AddFigureToCatalogueUI`: Manages figure addition to catalogue
   - `DecommissionFigureUI`: Handles figure decommissioning

2. **Controllers**:
   - `FigureController`: Coordinates figure management operations
   - `FigureService`: Implements business logic for figure operations

3. **Domain Objects**:
   - `Figure`: Represents a figure entity with its properties
   - `FigureCategory`: Represents a category for figures

4. **Repositories**:
   - `FigureRepository`: Interface for figure data access
   - `JpaFigureRepository`: JPA implementation of figure repository
   - `InMemoryFigureRepository`: In-memory implementation for testing

The system follows a layered architecture with clear separation of concerns:
- Presentation Layer (UIs)
- Application Layer (Controllers and Services)
- Domain Layer (Figure and FigureCategory)
- Persistence Layer (Repositories) 