package lapr4.app.backoffice.console.presentation.dronemodel;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.maintenanceManagement.application.CreateMaintenanceTypeController;

public class AddMaintenanceTypeUI extends AbstractUI {

    private final CreateMaintenanceTypeController controller = new CreateMaintenanceTypeController();

    @Override
    protected boolean doShow() {
        final String name = Console.readLine("Nome do tipo de manutenção:");
        final String description = Console.readLine("Descrição:");

        try {
            controller.create(name, description);
            System.out.println("Tipo de manutenção criado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar tipo: " + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Criar Tipo de Manutenção";
    }
}
