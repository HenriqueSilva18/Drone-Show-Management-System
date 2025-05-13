package lapr4.app.backoffice.console.presentation.menu;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import lapr4.app.backoffice.console.presentation.MainMenu;
import lapr4.app.backoffice.console.presentation.authz.AddUserUI;
import lapr4.app.backoffice.console.presentation.customer.*;
import lapr4.app.backoffice.console.presentation.figure.ListActivePublicFiguresUI;
import lapr4.app.backoffice.console.presentation.figure.ListFigureCategoriesUI;
import lapr4.app.backoffice.console.presentation.figure.SearchFigureCatalogueUI;
import lapr4.app.backoffice.console.presentation.showrequest.RegShowRequestUI;
import lapr4.app.backoffice.console.presentation.showrequest.ListShowRequestsByVATUI;
import lapr4.app.backoffice.console.presentation.showrequest.EditShowRequestUI;

public class CollaboratorMenu extends MainMenu {
	private static final String RETURN_LABEL = "Return ";
	private static final int EXIT_OPTION = 0;

	// CUSTOMERS
	private static final int REG_CUSTOMER_OPTION = 1;
	private static final int ADD_CUSTOMER_REPRESENTATIVE_OPTION = 2;
	private static final int LIST_CUSTOMER_REPRESENTATIVES_OPTION = 3;
	private static final int EDIT_CUSTOMER_REPRESENTATIVE_OPTION = 4;
	private static final int DISABLE_CUSTOMER_REPRESENTATIVE_OPTION = 5;
	private static final int REG_SHOW_REQUEST_OPTION = 6;
	private static final int LIST_SHOW_REQUESTS_BY_VAT_OPTION = 7;
	private static final int EDIT_SHOW_REQUEST_OPTION = 8;
	private static final int LIST_ACTIVE_PUBLIC_FIGURES = 9;
	private static final int SEARCH_FIGURE_CATALOGUE = 10;
	private static final int LIST_FIGURE_CATEGORIES = 11;

	// MAIN MENU
	private static final int CUSTOMERS_OPTION = 2;

	public static void buildCollaboratorMenu(Menu mainMenu) {
		final Menu customersMenu = CollaboratorMenu.buildCustomersMenu();
		mainMenu.addSubMenu(CUSTOMERS_OPTION, customersMenu);
	}

	private static Menu buildCustomersMenu() {
		final var menu = new Menu("Customers >");

		menu.addItem(REG_CUSTOMER_OPTION, "Register Customer", new RegCustomerUI()::show);
		menu.addItem(ADD_CUSTOMER_REPRESENTATIVE_OPTION, "Add Customer Representative", new AddCustomerRepresentativeUI()::show);
		menu.addItem(LIST_CUSTOMER_REPRESENTATIVES_OPTION, "List Customer Representatives", new ListCustomerRepresentativeUI()::show);
		menu.addItem(EDIT_CUSTOMER_REPRESENTATIVE_OPTION, "Edit Customer Representative", new EditCustomerRepresentativeUI()::show);
		menu.addItem(DISABLE_CUSTOMER_REPRESENTATIVE_OPTION, "Disable Customer Representative", new DisableCustomerRepresentativeUI()::show);
		menu.addItem(REG_SHOW_REQUEST_OPTION, "Register Show Request", new RegShowRequestUI()::show);
		menu.addItem(LIST_SHOW_REQUESTS_BY_VAT_OPTION, "List Show Requests by Customer VAT", new ListShowRequestsByVATUI()::show);
		menu.addItem(EDIT_SHOW_REQUEST_OPTION, "Edit Show Request", new EditShowRequestUI()::show);
		menu.addItem(LIST_ACTIVE_PUBLIC_FIGURES, "List Active Public Figures", new ListActivePublicFiguresUI()::show);
		menu.addItem(SEARCH_FIGURE_CATALOGUE, "Search Figure Catalogue", new SearchFigureCatalogueUI()::show);
		menu.addItem(LIST_FIGURE_CATEGORIES, "List Figure Categories", new ListFigureCategoriesUI()::show);
		menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

		return menu;
	}
}
