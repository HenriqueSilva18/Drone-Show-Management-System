package lapr4.app.backoffice.console.presentation.dronemodel;

import eapli.framework.presentation.console.AbstractUI;
import lapr4.maintenanceManagement.application.ListMaintenanceTypesController;
import lapr4.maintenanceManagement.domain.MaintenanceType;

public class ListMaintenanceTypesUI extends AbstractUI {

    private final ListMaintenanceTypesController controller = new ListMaintenanceTypesController();

    @Override
    protected boolean doShow() {
        System.out.println("\n--- Lista de Tipos de Manutenção ---");

        Iterable<MaintenanceType> types = controller.listAll();
        for (MaintenanceType type : types) {
            System.out.printf("ID: %d | Nome: %s | Descrição: %s%n", type.identity(), type.name(), type.description());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Listar Tipos de Manutenção";
    }
}
