package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;
import lapr4.showProposalManagement.application.AcceptShowProposalController;
import lapr4.showProposalManagement.domain.ShowProposal;

import java.util.Optional;

public class AcceptShowProposalUI extends AbstractUI {

    private final AcceptShowProposalController controller = new AcceptShowProposalController();

    @Override
    protected boolean doShow() {
        int proposalNumber = Console.readInteger("Enter the Proposal Number to accept:");

        Optional<ShowProposal> opt = controller.findNonAcceptedProposalByNumber(proposalNumber);

        if (opt.isEmpty()) {
            System.out.println("Proposal not found or already ACCEPTED.");
            return false;
        }

        ShowProposal proposal = opt.get();
        System.out.println("\nProposal found:");
        System.out.println(proposal);  // usa toString()

        String confirm = Console.readLine("Do you want to accept this proposal? (Y/N): ");
        if (confirm.equalsIgnoreCase("Y")) {
            controller.acceptProposal(proposalNumber);
            System.out.println("Proposal status changed to ACCEPTED.");
        } else {
            System.out.println("Operation cancelled.");
        }

        return true;
    }

    @Override
    public String headline() {
        return "Accept Show Proposal";
    }
}
