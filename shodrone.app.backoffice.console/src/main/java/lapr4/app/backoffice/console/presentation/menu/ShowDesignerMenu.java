package lapr4.app.backoffice.console.presentation.menu;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import lapr4.app.backoffice.console.presentation.MainMenu;
import lapr4.app.backoffice.console.presentation.authz.AddUserUI;
import lapr4.app.backoffice.console.presentation.figure.AddFigureToCatalogueUI;
import lapr4.app.backoffice.console.presentation.figure.AddFigureCategoryToCatalogueUI;

public class ShowDesignerMenu extends MainMenu {
    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int OPTION = 2;

    public static void buildShowDesignerMenu(Menu mainMenu) {
        final Menu sdMenu = ShowDesignerMenu.buildSDMenu();
        mainMenu.addSubMenu(OPTION, sdMenu);
    }

    private static Menu buildSDMenu() {
        final var menu = new Menu("Show Design >");

        menu.addItem(1, "Add Figure to Catalogue", new AddFigureToCatalogueUI()::show);
        menu.addItem(2, "Add Figure Category to Catalogue", new AddFigureCategoryToCatalogueUI()::show);
        //menu.addItem(3, "Edit Figure Category", new EditFigureCategoryUI()::show);
        //menu.addItem(4, "List Figure Categories", new ListFigureCategoryUI()::show);
        //menu.addItem(5, "Activate/Inactivate Figure Category", new ActivateInactivateFigureCategoryUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
}
