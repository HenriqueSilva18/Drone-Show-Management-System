package lapr4.app.backoffice.console.presentation.menu;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import lapr4.app.backoffice.console.presentation.MainMenu;
import lapr4.app.backoffice.console.presentation.authz.AddUserUI;
import lapr4.app.backoffice.console.presentation.dronemodel.*;
import lapr4.app.backoffice.console.presentation.figure.*;
import show_high_level_description_plugin.GenerateShowDslUI;

public class DroneTechMenu extends MainMenu {
    private static final String RETURN_LABEL = "Return ";
    private static final int EXIT_OPTION = 0;
    private static final int OPTION = 2; // posição do submenu Drone Tech no menu principal

    public static void buildDroneTechMenu(Menu mainMenu) {
        final Menu sdMenu = DroneTechMenu.buildDroneTechMenu();
        mainMenu.addSubMenu(OPTION, sdMenu);
    }

    private static Menu buildDroneTechMenu() {
        final var menu = new Menu("Drone Tech >");

        menu.addItem(1, "Add DroneModel ", new AddDroneModelUI()::show);
        menu.addItem(2, "Add MaintenanceType ", new AddMaintenanceTypeUI()::show);
        menu.addItem(3, "Edit Drone Model ", new EditDroneModelUI()::show);
        menu.addItem(4, "Edit MaintenanceType ", new EditMaintenanceTypeUI()::show);
        menu.addItem(5, "List DroneModels ", new ListDroneModelsUI()::show);
        menu.addItem(6, "List MaintenanceTypes ", new EditMaintenanceTypeUI()::show);

        menu.addItem(7, "Generate the Show high-level Description", () -> {
            try {
                new GenerateShowDslUI().show();
            } catch (Exception e) {
                System.out.println("Erro ao gerar descrição DSL: " + e.getMessage());
            }
            return true;
        });
        menu.addItem(8, "Validate Drone Program (Language 1)", () -> {
            new DroneValidator_L1_UI().display();
            return true;
        });
        menu.addItem(9, "Validate Drone Program (Language 2)", () -> {
            new DroneValidator_L2_UI().display();
            return true;
        });

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
}
