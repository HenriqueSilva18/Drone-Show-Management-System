# Class Diagram - Customer Representative Management

```mermaid
classDiagram
    class AddCustomerRepresentativeController {
        -CustomerService customerService
        -AddUserController userController
        +findCustomerByVAT(String vatNumber)
        +addRepresentative(String customerVAT, RepresentativeData repData)
    }

    class EditCustomerRepresentativeController {
        -CustomerRepository customerRepository
        +editRepresentative(VAT customerVAT, String repNIF, Email newEmail, Phone newPhone)
    }

    class DisableCustomerRepresentativeController {
        -CustomerRepository customerRepository
        -DeactivateUserController userDeactivator
        +disableRepresentative(VAT customerVAT, String repNIF)
    }

    class ListCustomerRepresentativesController {
        -CustomerRepository customerRepository
        +listRepresentatives(VAT customerVAT)
    }

    class Customer {
        +addRepresentative(Representative rep)
        +representatives() List~Representative~
    }

    class Representative {
        -NIF nif
        -Email email
        -Phone phone
        -SystemUser user
        +updateContact(Email, Phone)
        +identity()
        +user()
    }

    class CustomerService {
        +findCustomerByVAT(String)
        +registerCustomer(Customer)
    }

    class CustomerRepository {
        +findByVAT(VAT)
        +save(Customer)
    }

    AddCustomerRepresentativeController --> CustomerService
    AddCustomerRepresentativeController --> Customer
    EditCustomerRepresentativeController --> CustomerRepository
    EditCustomerRepresentativeController --> Customer
    DisableCustomerRepresentativeController --> CustomerRepository
    DisableCustomerRepresentativeController --> Customer
    ListCustomerRepresentativesController --> CustomerRepository
    ListCustomerRepresentativesController --> Customer
    Customer "1" *-- "*" Representative
```

## Description

This class diagram shows the main components involved in the Customer Representative Management system:

1. **Controllers**:
   - `AddCustomerRepresentativeController`: Handles adding new representatives
   - `EditCustomerRepresentativeController`: Manages representative information updates
   - `DisableCustomerRepresentativeController`: Handles deactivation of representatives
   - `ListCustomerRepresentativesController`: Retrieves representative information

2. **Domain Objects**:
   - `Customer`: Represents a customer entity that can have multiple representatives
   - `Representative`: Represents a customer representative with their details

3. **Services and Repositories**:
   - `CustomerService`: Business logic for customer operations
   - `CustomerRepository`: Data access for customer entities
