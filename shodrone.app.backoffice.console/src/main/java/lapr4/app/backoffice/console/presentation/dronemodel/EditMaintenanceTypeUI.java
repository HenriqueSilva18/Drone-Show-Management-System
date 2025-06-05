package lapr4.app.backoffice.console.presentation.dronemodel;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.maintenanceManagement.application.EditMaintenanceTypeController;

public class EditMaintenanceTypeUI extends AbstractUI {

    private final EditMaintenanceTypeController controller = new EditMaintenanceTypeController();

    @Override
    protected boolean doShow() {
        Long id = Console.readLong("ID do tipo de manutenção a editar:");
        String newName = Console.readLine("Novo nome:");
        String newDescription = Console.readLine("Nova descrição:");

        try {
            controller.edit(id, newName, newDescription);
            System.out.println("Tipo de manutenção atualizado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Editar Tipo de Manutenção";
    }
}
