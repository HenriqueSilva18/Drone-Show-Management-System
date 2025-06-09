package lapr4.app.backoffice.console.presentation.menu;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import lapr4.app.backoffice.console.presentation.MainMenu;
import lapr4.app.backoffice.console.presentation.authz.AddUserUI;
import lapr4.app.backoffice.console.presentation.figure.DecommissionFigureUI;
import lapr4.app.backoffice.console.presentation.showproposal.ConfigureProposalTemplateUI;

public class ManagerMenu extends MainMenu {
    private static final String RETURN_LABEL = "Return ";


    private static final int DECOMMISSION_FIGURE = 1;
    private static final int CONFIGURE_PROPOSAL_TEMPLATE = 2; // Adicione esta linha
    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int OPTION = 2;

    public static void buildManagerMenu(Menu mainMenu) {
        final Menu mMenu = ManagerMenu.buildMMenu();
        mainMenu.addSubMenu(OPTION, mMenu);
    }

    private static Menu buildMMenu() {
        final var menu = new Menu("Managing tools >");

        menu.addItem(DECOMMISSION_FIGURE, "Decommission Figure", new DecommissionFigureUI()::show);
        menu.addItem(CONFIGURE_PROPOSAL_TEMPLATE, "Configure Proposal Template", new ConfigureProposalTemplateUI()::show); // Adicione esta linha

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
}
