# Software Engineering Terms

| Term                                        | Definition                                                                                                                      |
|---------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| **ANTLR**                                   | Tool that must be used to implement support for the domain-specific language (DSL) and validation of drone languages.           |
| **Acceptance Criteria**                     | Conditions that must be met for a user story to be considered complete.                                                         |
| **Anti-Corruption Layer**                   | Layer that isolates the domain from external systems, preserving model integrity.                                               |
| **Aggregates**                              | A cluster of related objects treated as a cohesive unit for data changes.                                                       |
| **Attributes**                              | Properties that describe characteristics of entities and value objects.                                                         |
| **Build**                                   | Process of compiling the source code into executable code.                                                                      |
| **Deploy**                                  | Process of releasing the code to a production environment.                                                                      |
| **Domain Events**                           | Events that capture significant occurrences in the system.                                                                      |
| **Domain Model**                            | Conceptual model created using Domain-Driven Design principles to represent the system's entities and relationships.            |
| **Domain-Driven Design (DDD)**              | Software design approach that connects implementation to an evolving model.                                                     |
| **EAPLI**                                   | Application Engineering Curricular Unit of 4th semester of ISEP.                                                                |
| **Entities**                                | Objects with their own identity that persist over time.                                                                         |
| **GitHub**                                  | Platform used for version control and collaboration on the project.                                                             |
| **GitHub Actions**                          | Continuous Integration and Continuous Deployment (CI/CD) tool used for automating the build, test, and deployment processes.    |
| **GitHub Workflows**                        | Automated processes defined in GitHub Actions to build, test, and deploy the project.                                           |
| **Java**                                    | Programming language used for implementing the system.                                                                          |
| **LAPR4**                                   | Laboratory Project 4 Curricular Unit of 4th semester of ISEP.                                                                   |
| **LPROG**                                   | Languages and programming curricular unit of 4th semester of ISEP.                                                              |
| **Non-Functional Requirements**             | Requirements that define the quality attributes, system performance, and constraints.                                           |
| **PlantUML**                                | Tool used for creating UML diagrams to visualize the system's architecture and design.                                          |
| **PNG**                                     | Portable Network Graphics, a file format used for storing images.                                                               |
| **RCOMP**                                   | Computer networks curricular unit of 4th semester of ISEP.                                                                      |
| **RDBMS**                                   | Relational Database Management System, used for storing and managing data in a structured format.                               |
| **Repositories**                            | Components that abstract the data persistence layer.                                                                            |
| **SCOMP**                                   | Computer systems curricular unit of 4th semester of ISEP.                                                                       |
| **Scrum**                                   | Agile framework for managing and completing complex projects.                                                                   |
| **Scrum Master**                            | Role responsible for facilitating the Scrum process, ensuring that the team follows Scrum practices and principles.             |
| **Sprint**                                  | Time-boxed period in the Scrum methodology during which specific work must be completed and ready for review.                   |
| **Test**                                    | Process of executing the code to verify its correctness and functionality.                                                      |
| **Test-Driven**                             | Approach where tests are written before the code to ensure that the code meets the requirements and passes the tests            |
| **Use Case**                                | Description of how a user interacts with the system to achieve a specific goal.                                                 |
| **Use Case Diagram**                        | Visual representation of the interactions between users and the system, showing the relationships between actors and use cases. |
| **User Story**                              | Description of software functionality from the perspective of the end user.                                                     |
| **Value Objects**                           | Immutable objects with no identity that encapsulate domain attributes.                                                          |

# Shodrone System Terms

| Term                     | Definition                                                                                                            |
|--------------------------|-----------------------------------------------------------------------------------------------------------------------|
| **Admin**                | Role responsible for user management in the system.                                                                   |
| **Address**              | Value object that encapsulates addresses for clients.                                                                 |
| **ApprovalStatus**       | Status of an approval request (PENDING, ACCEPTED, REFUSED).                                                           |
| **Backoffice**           | Internal administrative system used by Shodrone to manage customers, figures, shows, and operations.                  |
| **Client**               | Entity representing a corporate client or public entity requesting drone shows.                                       |
| **Collision**            | When two drones occupy the same space at the same time during a show or simulation.                                   |
| **Coordinates**          | Value object that represents geographical coordinates for show locations.                                              |
| **CRM Collaborator**     | Shodrone employee responsible for customer service, registering show requests, and managing customer representatives. |
| **CRM Manager**          | Role responsible for client management and show request assignment to designers.                                      |
| **CustomerStatus**       | Status of a customer (CREATED, INFRINGEMENT, DELETED).                                                                 |
| **CustomerType**         | Type of customer (REGULAR or VIP).                                                                                     |
| **Date Value**           | Value object that encapsulates date and time information.                                                             |
| **Description**          | Used to store textual descriptions.                                                                                   |
| **Drone**                | Device that performs aerial maneuvers in a show. Each drone has a model and serial number in the inventory.           |
| **Drone Model**          | Entity representing a specific type or model of drone.                                                                |
| **Drone Tech**           | Role responsible for maintaining, testing and configuring drones.                                                     |
| **DroneType**            | Entity representing a category or type of drone with specific characteristics.                                         |
| **Dynamic Figure**       | A figure where drones move in the air performing a routine with a fixed duration.                                     |
| **Email**                | Value object that represents an email address.                                                                        |
| **Exclusive**            | Indicates whether a figure is exclusive to a client.                                                                  |
| **Figure**               | Represents a sequence that drones perform during a show.                                                              |
| **Figure Category**      | Represents a category of figures, with a description, name, creation date, last edition date and if it is active or not |
| **FigureInShowProposal** | Entity representing a figure within a show proposal, including its mapping to specific drone types and models.         |
| **Id**                   | Value object that encapsulates unique identifiers for entities.                                                       |
| **Language**             | Domain-specific language used to code drone figures.                                                                  |
| **Maintenance**          | Value object containing information about drone maintenance periods.                                                  |
| **MaintenanceType**      | Entity representing a type of maintenance that can be performed on drones.                                             |
| **Name**                 | Value object that encapsulates names of entities.                                                                     |
| **NIF**                  | Value object that encapsulates tax identification numbers.                                                            |
| **Password**             | Value object that represents the password of a user.                                                                  |
| **Phone**                | Value object that represents a phone number.                                                                          |
| **ProposalTemplate**     | Template used as a base for creating show proposals.                                                                  |
| **Report**               | Represents a report generated after a simulation, detailing potential issues.                                         |
| **Representative**       | Person who represents a client and interacts with Shodrone. Has id and name.                                          |
| **Serial Number**        | Unique number identifying a specific drone.                                                                           |
| **Shodrone**             | Company providing customized drone multimedia shows, the client for this software project.                            |
| **Show**                 | Represents a sequence of figures performed by drones.                                                                 |
| **Show Designer**        | Role responsible for creating and designing drone shows.                                                              |
| **Show Proposal**        | Represents a proposal sent to a client detailing the show configuration.                                              |
| **Show Proposal Status** | Status of a show proposal (CREATED, PENDENT, REJECTED, ACCEPTED, SCHEDULED, ABORTED).                                 |
| **Show Request**         | Represents a request from a client for a drone show.                                                                  |
| **ShowRequestId**        | Value object that represents a unique identifier for show requests.                                                    |
| **Simulation**           | Process of running a figure or show in a virtual environment to test for potential collisions or other issues.        |
| **Simulation Service**   | Service that simulates the execution of figures to verify safety and feasibility.                                     |
| **SimulationStatus**     | Status of a simulation (UNTESTED, FAILED, PASSED).                                                                     |
| **Specification**        | Value object that encapsulates specifications drone models such as dimensions, weight, maximum speed, flight time.    |
| **SystemRole**           | Role of a system user (ADMIN, CRM_MANAGER, CRM_COLLABORATOR, SHOW_DESIGNER, CUSTOMER_REPRESENTATIVE).                 |
| **SystemStatus**         | Status of a system user (ACTIVE or INACTIVE).                                                                          |
| **User**                 | Represents a user of the system with an email, phone number, username and password.                                   |
| **Username**             | Value object that represents the username of a user.                                                                  |
| **VAT**                  | Value object that encapsulates VAT numbers for clients.                                                               |