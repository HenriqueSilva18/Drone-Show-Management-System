# Class Diagram - Show Request Management

```mermaid
classDiagram
    class RegShowRequestController {
        -ShowRequestService service
        +registerShowRequest(ShowRequestData data)
    }

    class ListShowRequestsController {
        -ShowRequestService service
        +listByClientVAT(String vatStr)
    }

    class EditShowRequestController {
        -ShowRequestService service
        +editShowRequest(VAT vat, ShowRequestId id, ...)
    }

    class ShowRequestService {
        -AuthorizationService authz
        -ShowRequestRepository repo
        +registerShowRequest(ShowRequest): ShowRequest
        +findByClientVAT(String): Iterable~ShowRequest~
        +updateShowRequest(VAT, ShowRequestId, int, double, String, String, String): void
    }

    class ShowRequestRepository {
        +save(ShowRequest): ShowRequest
        +findByClientVAT(String): Iterable~ShowRequest~
        +findByVATAndId(VAT, ShowRequestId): Optional~ShowRequest~
    }

    class ShowRequest {
        -ShowRequestId id
        -int numDrones
        -double duration
        -String showDescription
        -String dateValue
        -String status
        +setNumDrones(int)
        +setDuration(double)
        +setShowDescription(String)
        +setDate(String)
        +setStatus(String)
    }

    class ShowRequestId {
        -int value
    }

    class VAT {
        -String value
    }

    class AuthorizationService {
        +ensureAuthenticatedUserHasAnyOf(...): void
    }

    RegShowRequestController --> ShowRequestService
    ListShowRequestsController --> ShowRequestService
    EditShowRequestController --> ShowRequestService

    ShowRequestService --> AuthorizationService
    ShowRequestService --> ShowRequestRepository
    ShowRequestService --> ShowRequest

    ShowRequest --> ShowRequestId
    ShowRequest --> VAT
```

## Description

This class diagram illustrates the main components for the Show Request Management system:

1. **Controllers**:
    - `RegShowRequestController`: Initiates a new show request registration.
    - `ListShowRequestsController`: Retrieves all requests for a given client VAT.
    - `EditShowRequestController`: Allows modification of an existing show request.

2. **Application Service**:
    - `ShowRequestService`: Contains business logic and ensures authorization before delegating to the repository.

3. **Repositories and Domain Entities**:
    - `ShowRequestRepository`: Interface to fetch and persist `ShowRequest` data.
    - `ShowRequest`: Core entity representing a show request.
    - `ShowRequestId` & `VAT`: Domain value objects encapsulating identification.

4. **Infrastructure**:
    - `AuthorizationService`: Verifies user roles to allow operations.
