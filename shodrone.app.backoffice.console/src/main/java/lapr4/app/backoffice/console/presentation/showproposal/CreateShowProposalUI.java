package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.app.backoffice.console.presentation.utils.ReadValidations;
import lapr4.showProposalManagement.application.CreateShowProposalController;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import lapr4.showRequestManagement.dto.ShowRequestDTO;

@SuppressWarnings("java:S106")
public class CreateShowProposalUI extends AbstractUI {

    private final CreateShowProposalController theController = new CreateShowProposalController();

    @Override
    protected boolean doShow() {

        final Iterable<ShowRequestDTO> showRequests = this.theController.listShowRequests();

        final SelectWidget<ShowRequestDTO> selector = new SelectWidget<>("Available Show Requests:", showRequests);
        selector.show();
        final ShowRequestDTO theShowRequest = selector.selectedElement();

        if (theShowRequest == null) {
            return false;
        }

        System.out.println("--- Enter New Proposal Details ---");
        final int totalNumDrones = ReadValidations.readValidInteger("Total number of drones:", 1);
        final double latitude = ReadValidations.readValidDouble("Event Latitude (-90 to 90):", -90.0, 90.0);
        final double longitude = ReadValidations.readValidDouble("Event Longitude (-180 to 180):", -180.0, 180.0);
        final String eventDate = ReadValidations.readValidDateString("Event Date (format yyyy-MM-dd):");
        final String eventHour = ReadValidations.readValidTimeString("Event Hour (format HH:mm):");
        final int eventDuration = ReadValidations.readValidInteger("Event Duration (in minutes):", 1);

        try {
            final ShowProposalDTO newProposalDTO = new ShowProposalDTO(
                    theShowRequest.id,
                    totalNumDrones,
                    latitude,
                    longitude,
                    eventDate,
                    eventHour,
                    eventDuration
            );

            final ShowProposalDTO createdProposal = this.theController.createShowProposal(newProposalDTO);
            System.out.println("\nShow Proposal created successfully!");
            System.out.println("Proposal Number: " + createdProposal.number);

        } catch (IntegrityViolationException e) {
            System.out.println("Error: A proposal with this data might already exist in the database.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Create Show Proposal";
    }

}