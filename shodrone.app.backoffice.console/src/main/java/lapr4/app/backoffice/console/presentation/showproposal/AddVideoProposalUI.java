package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.showProposalManagement.application.ChangeProposalController;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import lapr4.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AddVideoProposalUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(AddVideoProposalUI.class);

    private final ChangeProposalController theController;

    public AddVideoProposalUI() {
        this.theController = new ChangeProposalController(
            PersistenceContext.repositories().showProposals(),
            AuthzRegistry.authorizationService()
        );
    }

    @Override
    protected boolean doShow() {
        try {
            Iterable<ShowProposalDTO> allProposals = this.theController.allProposals();
            List<ShowProposalDTO> proposalList = new ArrayList<>();
            allProposals.forEach(proposalList::add);

            if (proposalList.isEmpty()) {
                System.out.println("There are no registered proposals.");
                return false;
            }

            System.out.println("\nAvailable Proposals:");
            System.out.println("===================");
            for (int i = 0; i < proposalList.size(); i++) {
                ShowProposalDTO proposal = proposalList.get(i);
                System.out.printf("%d. Proposal ID: %d | Status: %s%n", 
                    i + 1, 
                    proposal.getShowRequestID(),
                    proposal.getStatus());
            }
            System.out.println("===================\n");

            int choice;
            do {
                choice = Console.readInteger("Select a proposal (number):");
            } while (choice < 1 || choice > proposalList.size());

            ShowProposalDTO selectedProposal = proposalList.get(choice - 1);

            String currentVideo = selectedProposal.getSimulationVideoLink();
            System.out.println("\nCurrent video link: " + (currentVideo != null ? currentVideo : "N/A"));

            String newVideoLink = Console.readLine("\nEnter new video link: ");

            ShowProposalDTO updatedProposal = theController.changeProposalVideo(selectedProposal.getShowRequestID(), newVideoLink);
            System.out.println("\nVideo link updated successfully for proposal ID: " + updatedProposal.getShowRequestID());

            return true;

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        } catch (ConcurrencyException ex) {
            System.out.println("It is not possible to change the proposal's video link because it was changed by another user. Please try again.");
            return false;
        } catch (IntegrityViolationException e) {
            LOGGER.error("Integrity violation while changing video link: ", e);
            System.out.println("Unfortunately, there was an unexpected error in the application. Please try again, and if the problem persists, contact your system administrator.");
            return false;
        } catch (Exception e) {
            LOGGER.error("An unexpected error occurred: ", e);
            System.out.println("An unexpected error occurred. Please check the logs.");
            return false;
        }
    }

    @Override
    public String headline() {
        return "Add Video Link to Proposal";
    }
}
