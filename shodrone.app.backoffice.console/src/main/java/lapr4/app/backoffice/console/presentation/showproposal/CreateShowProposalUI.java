package lapr4.app.backoffice.console.presentation.showproposal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showProposalManagement.application.CreateProposalController;
import lapr4.showProposalManagement.dto.CreateProposalDTO;
import lapr4.showProposalManagement.dto.ListRequestDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

public class CreateShowProposalUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(CreateShowProposalUI.class);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final CreateProposalController theController;

    public CreateShowProposalUI() {
        this.theController = new CreateProposalController(
            PersistenceContext.repositories().showProposals(),
            PersistenceContext.repositories().showRequests(),
            AuthzRegistry.authorizationService()
        );
    }

    private void displayRequestDetails(ListRequestDTO request) {
        System.out.println("\nSelected Request Details:");
        System.out.println("=========================");
        System.out.printf("Request ID: %d%n", request.getRequestId());
        System.out.printf("Number of Drones: %d%n", request.getNumDrones());
        System.out.printf("Duration (minutes): %.2f%n", request.getDuration());
        System.out.printf("Show Description: %s%n", request.getShowDescription());
        System.out.printf("Date: %s%n", request.getDateValue());
        System.out.printf("Status: %s%n", request.getStatus());
        System.out.printf("Client VAT: %s%n", request.getClientVAT());
        System.out.println("=========================\n");
    }

    private LocalDate readDate() {
        while (true) {
            try {
                String dateStr = Console.readLine("Enter proposal date (format: yyyy-MM-dd):");
                return LocalDate.parse(dateStr, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd");
            }
        }
    }

    private double readLatitude() {
        while (true) {
            double latitude = Console.readDouble("Enter latitude (-90 to 90):");
            if (latitude >= -90 && latitude <= 90) {
                return latitude;
            }
            System.out.println("Invalid latitude. Must be between -90 and 90.");
        }
    }

    private double readLongitude() {
        while (true) {
            double longitude = Console.readDouble("Enter longitude (-180 to 180):");
            if (longitude >= -180 && longitude <= 180) {
                return longitude;
            }
            System.out.println("Invalid longitude. Must be between -180 and 180.");
        }
    }

    @Override
    protected boolean doShow() {
        try {
            // List available show requests
            System.out.println("Available Show Requests:");
            List<ListRequestDTO> showRequests = theController.listAvailableShowRequests();
            
            if (showRequests.isEmpty()) {
                System.out.println("No show requests available.");
                return false;
            }

            // Display requests
            for (int i = 0; i < showRequests.size(); i++) {
                ListRequestDTO request = showRequests.get(i);
                System.out.printf("%d. Request ID: %d | Number of Drones Requested: %d%n", 
                    i + 1, 
                    request.getRequestId(),
                    request.getNumDrones());
            }

            // Select show request
            int requestChoice;
            do {
                requestChoice = Console.readInteger("Select a show request (number):");
            } while (requestChoice < 1 || requestChoice > showRequests.size());

            ListRequestDTO selectedRequestDTO = showRequests.get(requestChoice - 1);
            
            // Get and display detailed information about the selected request
            Optional<ListRequestDTO> selectedRequest = theController.getShowRequestById(selectedRequestDTO.getRequestId());
            if (selectedRequest.isEmpty()) {
                System.out.println("Error: Could not find detailed information for the selected request.");
                return false;
            }
            
            displayRequestDetails(selectedRequest.get());

            // Confirm if user wants to proceed
            String proceed = Console.readLine("Do you want to proceed with creating a proposal for this request? (Y/N)");
            if (!proceed.equalsIgnoreCase("Y")) {
                System.out.println("Operation cancelled by user.");
                return false;
            }

            // Input total number of drones
            int totalDrones;
            do {
                totalDrones = Console.readInteger("Enter total number of drones:");
                if (!theController.validateTotalDrones(totalDrones)) {
                    System.out.println("Invalid number of drones! Must be greater than 0.");
                }
            } while (!theController.validateTotalDrones(totalDrones));

            // Input duration
            int durationMinutes;
            do {
                durationMinutes = Console.readInteger("Enter show duration (minutes):");
                if (durationMinutes <= 0) {
                    System.out.println("Invalid duration! Must be greater than 0.");
                }
            } while (durationMinutes <= 0);

            // Input date
            LocalDate proposalDate = readDate();

            // Input coordinates
            System.out.println("\nEnter show location coordinates:");
            double latitude = readLatitude();
            double longitude = readLongitude();

            // Create the proposal
            CreateProposalDTO proposal = new CreateProposalDTO(
                selectedRequestDTO.getRequestId(),
                totalDrones,
                durationMinutes,
                proposalDate,
                latitude,
                longitude
            );

            CreateProposalDTO createdProposal = theController.createProposal(proposal);
            System.out.printf("Show proposal created successfully for Request ID: %d%n", 
                createdProposal.getShowRequestID());
            
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        } catch (final ConcurrencyException e) {
            LOGGER.error("This should never happen", e);
            System.out.println(
                    "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
            return false;
        }
    }

    @Override
    public String headline() {
        return "Create Show Proposal";
    }
}
