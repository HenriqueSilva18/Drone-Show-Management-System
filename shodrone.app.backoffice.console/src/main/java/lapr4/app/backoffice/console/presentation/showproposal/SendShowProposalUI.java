package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.showProposalManagement.application.SendShowProposalController;
import lapr4.showProposalManagement.dto.ProposalTemplateDTO;
import lapr4.showProposalManagement.dto.ShowProposalDTO;

public class SendShowProposalUI extends AbstractUI {

    private final SendShowProposalController controller = new SendShowProposalController();

    @Override
    protected boolean doShow() {

        Iterable<ShowProposalDTO> proposals = controller.getAllProposalsToSend();

        final SelectWidget<ShowProposalDTO> selector = new SelectWidget<>("Select the Proposal Template to send:", proposals);
        selector.show();

        final ShowProposalDTO selectedTemplate = selector.selectedElement();

        if (selectedTemplate != null) {
            System.out.println("Selected Proposal: " + selectedTemplate);
            controller.sendProposal(selectedTemplate);
            System.out.println("Proposal sent successfully!");
            return true;
        } else {
            System.out.println("No proposal selected.");
        }


        return false;
    }

    @Override
    public String headline() {
        return "Send Show Proposal";
    }
}
