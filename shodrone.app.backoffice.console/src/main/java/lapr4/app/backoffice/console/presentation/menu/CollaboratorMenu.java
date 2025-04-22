package lapr4.app.backoffice.console.presentation.menu;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import lapr4.app.backoffice.console.presentation.MainMenu;
import lapr4.app.backoffice.console.presentation.authz.AddUserUI;
import lapr4.app.backoffice.console.presentation.customer.RegCustomerUI;

public class CollaboratorMenu extends MainMenu {
    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // CUSTOMERS
    private static final int REG_CUSTOMER_OPTION = 1;


    // MAIN MENU
    private static final int CUSTOMERS_OPTION = 2;

    public static void buildCollaboratorMenu(Menu mainMenu) {
        final Menu customersMenu = CollaboratorMenu.buildCustomersMenu();
        mainMenu.addSubMenu(CUSTOMERS_OPTION, customersMenu);
    }

    private static Menu buildCustomersMenu() {
            final var menu = new Menu("Customers >");

        menu.addItem(REG_CUSTOMER_OPTION, "Register Customer", new RegCustomerUI()::show); // do ui
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
}
