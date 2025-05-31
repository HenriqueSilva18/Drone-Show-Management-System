package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.showProposalManagement.application.CreateShowProposalController;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showRequestManagement.domain.ShowRequest;

import java.util.ArrayList;
import java.util.List;

public class CreateShowProposalUI extends AbstractUI {
    private final CreateShowProposalController controller;

    public CreateShowProposalUI() {
        this.controller = new CreateShowProposalController();
    }

    @Override
    protected boolean doShow() {
        try {
            // List available show requests
            System.out.println("Available Show Requests:");
            Iterable<ShowRequest> showRequests = controller.listAvailableShowRequests();
            List<ShowRequest> requestList = new ArrayList<>();
            int index = 1;
            
            for (ShowRequest request : showRequests) {
                System.out.printf("%d. Request ID: %d%n", index++, request.identity().value());
                requestList.add(request);
            }

            if (requestList.isEmpty()) {
                System.out.println("No show requests available.");
                return false;
            }

            // Select show request
            int requestChoice = Console.readInteger("Select a show request (number):");
            if (requestChoice < 1 || requestChoice > requestList.size()) {
                System.out.println("Invalid selection!");
                return false;
            }
            ShowRequest selectedRequest = requestList.get(requestChoice - 1);

            // Input total number of drones
            int totalDrones;
            do {
                totalDrones = Console.readInteger("Enter total number of drones:");
                if (!controller.validateTotalDrones(totalDrones)) {
                    System.out.println("Invalid number of drones! Must be greater than 0.");
                }
            } while (!controller.validateTotalDrones(totalDrones));

            // Create the proposal
            ShowProposal proposal = controller.createShowProposal(selectedRequest, totalDrones);
            System.out.printf("Show proposal created successfully with ID: %d%n", proposal.identity());
            
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String headline() {
        return "Create Show Proposal";
    }
}
