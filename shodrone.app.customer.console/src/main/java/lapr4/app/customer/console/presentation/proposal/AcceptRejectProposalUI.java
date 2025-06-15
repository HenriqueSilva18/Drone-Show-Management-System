// File: shodrone.app.customer.console/src/main/java/lapr4/app/customer/console/presentation/proposal/AcceptRejectProposalUI.java
package lapr4.app.customer.console.presentation.proposal;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.app.customer.console.http.HttpClient;
import lapr4.showProposalManagement.application.AcceptShowProposalController;
import lapr4.showProposalManagement.domain.ShowProposal;

import java.util.Optional;

public class AcceptRejectProposalUI extends AbstractUI {

    private final AcceptShowProposalController controller = new AcceptShowProposalController();
    private final HttpClient httpClient;

    public AcceptRejectProposalUI(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    protected boolean doShow() {
        System.out.println("=== Accept/Reject a Proposal ===");
        /*final int proposalNumber = Console.readInteger("Enter the Proposal Number:");

        // For simplicity, we'll fetch the proposal details from the backoffice controller.
        // In a real-world scenario, this would likely be a call to the server.
        Optional<ShowProposal> opt = null;

        if (opt.isEmpty()) {
            System.out.println("Proposal not found or has already been accepted/rejected.");
            return false;
        }

        ShowProposal proposal = opt.get();
        System.out.println("\nProposal Details:");
        System.out.println(proposal);

        System.out.println("\n1. Accept Proposal");
        System.out.println("2. Reject Proposal");
        System.out.println("0. Cancel");

        final int choice = Console.readOption(1, 2, 0);

        if (choice == 0) {
            System.out.println("Operation cancelled.");
            return false;
        }

        String feedback = Console.readLine("Enter feedback (optional):");

        if (choice == 1) {
            // Here you would make an HTTP call to your server to accept the proposal
            // For now, we call the controller directly for demonstration
            controller.acceptProposal(proposalNumber);
            System.out.println("Proposal accepted successfully!");
        } else {
            // Similarly, a call to reject the proposal
            controller.rejectProposal(proposalNumber);
            System.out.println("Proposal rejected successfully!");
        }*/

        return false;
    }

    @Override
    public String headline() {
        return "Accept/Reject Proposal";
    }
}