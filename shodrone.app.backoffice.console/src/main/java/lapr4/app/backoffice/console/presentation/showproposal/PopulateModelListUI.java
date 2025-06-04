package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.droneModelManagement.domain.dto.DroneModelDTO;
import lapr4.showProposalManagement.application.PopulateModelListController;
import lapr4.showProposalManagement.dto.PopulateProposalDTO;

import java.util.List;

public class PopulateModelListUI extends AbstractUI {

    private final PopulateModelListController controller = new PopulateModelListController();

    @Override
    protected boolean doShow() {
        List<PopulateProposalDTO> proposals = controller.listUnassignedShowProposals();
        if (proposals.isEmpty()) {
            System.out.println("No proposals available for model assignment.");
            return false;
        }

        System.out.println("Available Show Proposals:");
        for (PopulateProposalDTO dto : proposals) {
            System.out.printf("Proposal #%d - Drones: %d assigned of %d%n",
                    dto.proposalNumber, dto.dronesAssigned, dto.totalDrones);
        }

        int proposalNumber = Console.readInteger("Enter proposal number to populate:");
        PopulateProposalDTO proposal = controller.getProposalByNumber(proposalNumber);
        if (proposal == null) {
            System.out.println("Invalid proposal number.");
            return false;
        }

        int remainingSlots = proposal.totalDrones - proposal.dronesAssigned;

        while (remainingSlots > 0) {
            List<DroneModelDTO> models = controller.listAvailableDroneModels();
            if (models.isEmpty()) {
                System.out.println("No drone models available.");
                return false;
            }

            System.out.println("Available Drone Models:");
            for (DroneModelDTO m : models) {
                System.out.printf("ID: %d | Name: %s%n", m.id, m.name);
            }

            long modelId = Console.readLong("Enter the ID of the Drone Model:");
            int available = controller.countAvailableOfModel(modelId);

            System.out.printf("Drones remaining to assign: %d%n", remainingSlots);
            System.out.printf("Available units of this model: %d%n", available);

            int quantity = Console.readInteger("How many drones of this model to assign?");
            if (quantity <= 0 || quantity > remainingSlots || quantity > available) {
                System.out.println("Invalid quantity.");
                continue;
            }

            controller.assignModelToProposal(proposalNumber, modelId, quantity);
            remainingSlots -= quantity;

            System.out.printf("Assigned %d units of model ID %d.%n", quantity, modelId);
        }

        System.out.println("ShowProposal successfully populated with models.");
        return true;
    }

    @Override
    public String headline() {
        return "Populate Drone Models in ShowProposal";
    }
}

