package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget; // Import SelectWidget
import lapr4.showProposalManagement.application.AddVideoProposalController;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import lapr4.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddVideoProposalUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(AddVideoProposalUI.class);

    private final AddVideoProposalController theController;

    public AddVideoProposalUI() {
        this.theController = new AddVideoProposalController(
                PersistenceContext.repositories().showProposals(),
                AuthzRegistry.authorizationService()
        );
    }

    @Override
    protected boolean doShow() {
        final Iterable<ShowProposalDTO> eligibleProposals = theController.listProposalsForVideoAddition();

        if (!eligibleProposals.iterator().hasNext()) {
            System.out.println("There are no proposals awaiting a video link.");
            return false;
        }

        final SelectWidget<ShowProposalDTO> selector = new SelectWidget<>("Select a Proposal to add a video to:", eligibleProposals);
        selector.show();

        final ShowProposalDTO selectedProposal = selector.selectedElement();

        if (selectedProposal == null) {
            return false;
        }

        try {
            final String newVideoLink = Console.readLine("\nEnter the video link for proposal #" + selectedProposal.number + ": ");

            theController.addProposalVideo(selectedProposal.number, newVideoLink);

            System.out.println("\nVideo link added successfully!");

        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        } catch (ConcurrencyException | IntegrityViolationException ex) {
            System.out.println("\nError: The data was modified by another user. Please try again.");
        } catch (Exception e) {
            LOGGER.error("An unexpected error occurred: ", e);
            System.out.println("\nAn unexpected error occurred. Please check the logs for more details.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Add Video Link to Proposal";
    }
}