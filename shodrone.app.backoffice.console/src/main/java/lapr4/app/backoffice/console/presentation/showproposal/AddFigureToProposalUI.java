package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.presentation.console.AbstractUI;
import lapr4.showProposalManagement.application.AddFigureToProposalController;

public class AddFigureToProposalUI extends AbstractUI {

    private final AddFigureToProposalController controller = new AddFigureToProposalController();


    @Override
    protected boolean doShow() {
        return false;
    }

    @Override
    public String headline() {
        return "";
    }
}
