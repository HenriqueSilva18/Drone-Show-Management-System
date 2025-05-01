package lapr4.app.backoffice.console.presentation.menu;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import lapr4.app.backoffice.console.presentation.MainMenu;
import lapr4.app.backoffice.console.presentation.authz.AddUserUI;
import lapr4.app.backoffice.console.presentation.customer.AddCustomerRepresentativeUI;
import lapr4.app.backoffice.console.presentation.customer.RegCustomerUI;
import lapr4.app.backoffice.console.presentation.showrequest.RegShowRequestUI;
import lapr4.app.backoffice.console.presentation.showrequest.ListShowRequestsByVATUI;
import lapr4.app.backoffice.console.presentation.showrequest.EditShowRequestUI;

public class CollaboratorMenu extends MainMenu {
	private static final String RETURN_LABEL = "Return ";

	private static final int EXIT_OPTION = 0;

	// CUSTOMERS
	private static final int REG_CUSTOMER_OPTION = 1;
	private static final int ADD_CUSTOMER_REPRESENTATIVE_OPTION = 2;
	private static final int REG_SHOW_REQUEST_OPTION = 3;
	private static final int LIST_SHOW_REQUESTS_BY_VAT_OPTION = 4;

	private static final int EDIT_SHOW_REQUEST_OPTION = 5;

	// MAIN MENU
	private static final int CUSTOMERS_OPTION = 2;

	public static void buildCollaboratorMenu(Menu mainMenu) {
		final Menu customersMenu = CollaboratorMenu.buildCustomersMenu();
		mainMenu.addSubMenu(CUSTOMERS_OPTION, customersMenu);
	}

	private static Menu buildCustomersMenu() {
		final var menu = new Menu("Customers >");

		menu.addItem(REG_CUSTOMER_OPTION, "Register Customer", new RegCustomerUI()::show); // do ui
		menu.addItem(
				ADD_CUSTOMER_REPRESENTATIVE_OPTION, "Add Customer Representative",
				new AddCustomerRepresentativeUI()::show); // do ui
		menu.addItem(REG_SHOW_REQUEST_OPTION, "Register Show Request", new RegShowRequestUI()::show);
		menu.addItem(LIST_SHOW_REQUESTS_BY_VAT_OPTION, "List Show Requests by Customer VAT", new ListShowRequestsByVATUI()::show);
		menu.addItem(EDIT_SHOW_REQUEST_OPTION, "Edit Show Request", new EditShowRequestUI()::show);
		menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

		return menu;
	}

}
