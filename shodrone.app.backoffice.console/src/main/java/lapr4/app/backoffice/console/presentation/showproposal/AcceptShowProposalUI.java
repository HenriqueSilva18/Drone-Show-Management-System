package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.showProposalManagement.application.AcceptShowProposalController;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.ShowProposalDTO;

import java.util.Optional;

public class AcceptShowProposalUI extends AbstractUI {

    private final AcceptShowProposalController controller = new AcceptShowProposalController();

    @Override
    protected boolean doShow() {

        Iterable<ShowProposalDTO> proposalsDTO = controller.findAcceptedProposalByCustomer();

        final SelectWidget<ShowProposalDTO> selector = new SelectWidget<>("Select the Proposal Template to schedule:", proposalsDTO);
        selector.show();

        final ShowProposalDTO selectedTemplate = selector.selectedElement();;

        if (selectedTemplate != null) {
            System.out.println("Selected Proposal: " + selectedTemplate);
            controller.scheduleProposal(selectedTemplate);
            System.out.println("Proposal accepted successfully!");
            return true;
        } else {
            System.out.println("No proposal selected.");
        }


        return false;
    }

    @Override
    public String headline() {
        return "Accept Show Proposal";
    }
}
