package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.showProposalManagement.application.AbortShowProposalController;
import lapr4.showProposalManagement.application.AcceptShowProposalController;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.ShowProposalDTO;

import java.util.Optional;

public class AbortShowProposalUI extends AbstractUI {

    private final AbortShowProposalController controller = new AbortShowProposalController();

    @Override
    protected boolean doShow() {

        Iterable<ShowProposalDTO> proposalsDTO = controller.findAcceptedProposalByCustomer();

        final SelectWidget<ShowProposalDTO> selector = new SelectWidget<>("Select the Proposal Template to abort:", proposalsDTO);
        selector.show();

        final ShowProposalDTO selectedTemplate = selector.selectedElement();;

        if (selectedTemplate != null) {
            System.out.println("Selected Proposal: " + selectedTemplate);
            controller.abortProposal(selectedTemplate);
            System.out.println("Proposal aborted successfully!");
            return true;
        } else {
            System.out.println("No proposal selected.");
        }


        return false;
    }

    @Override
    public String headline() {
        return "Abort Show Proposal";
    }
}
