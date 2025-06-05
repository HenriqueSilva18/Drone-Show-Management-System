package lapr4.app.backoffice.console.presentation.dronemodel;

import eapli.framework.presentation.console.AbstractUI;
import lapr4.droneModelManagement.application.DroneModelController;
import lapr4.droneModelManagement.domain.DroneModel;

public class ListDroneModelsUI extends AbstractUI {

    private final DroneModelController controller = new DroneModelController();

    @Override
    protected boolean doShow() {
        Iterable<DroneModel> models = controller.listAllModels();

        System.out.println("\n--- Modelos de Drone ---");
        for (DroneModel m : models) {
            System.out.printf("ID: %d | Nome: %s | Linguagem: %s%n", m.identity(), m.name(), m.language());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Listar Modelos de Drone";
    }
}
