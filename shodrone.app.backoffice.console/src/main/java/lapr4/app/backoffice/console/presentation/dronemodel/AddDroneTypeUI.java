package lapr4.app.backoffice.console.presentation.dronemodel;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.droneModelManagement.application.DroneTypeController;

public class AddDroneTypeUI extends AbstractUI {

    private final DroneTypeController typeController = new DroneTypeController();


    @Override
    protected boolean doShow() {
        final String name = Console.readLine("Nome do tipo de drone:");
        final String description = Console.readLine("Descrição do tipo de drone:");

        try {
            typeController.registerDroneType(name, description);
            System.out.println("Tipo de drone adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar tipo de drone: " + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Adicionar Tipo de Drone";
    }
}
