package lapr4.app.backoffice.console.presentation.dronemodel;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.droneModelManagement.application.DroneModelController;
import lapr4.maintenanceManagement.domain.MaintenanceType;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.maintenanceManagement.repositories.MaintenanceTypeRepository;
import lapr4.infrastructure.persistence.PersistenceContext;

import java.util.Optional;

public class EditDroneModelUI extends AbstractUI {

    private final DroneModelController controller = new DroneModelController();
    private final MaintenanceTypeRepository mtRepo = PersistenceContext.repositories().maintenanceTypes();

    @Override
    protected boolean doShow() {
        Long id = Console.readLong("ID do DroneModel a editar:");
        DroneModel model;
        try {
            model = controller.findModelById(id);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }

        System.out.printf("Selecionado: %s (%s)%n", model.name(), model.language());

        System.out.println("\n1. Adicionar manutenção");
        System.out.println("0. Sair");

        int option = Console.readOption(0, 1, 0);
        if (option == 1) {
            addMaintenanceToModel(model);
        }

        return false;
    }

    private void addMaintenanceToModel(DroneModel model) {
        final String description = Console.readLine("Descrição:");
        final String startDate = Console.readLine("Data início (yyyy-mm-dd):");
        final String endDate = Console.readLine("Data fim (yyyy-mm-dd):");
        final String typeName = Console.readLine("Tipo de manutenção:");

        Optional<MaintenanceType> optType = mtRepo.findById(Long.valueOf(typeName.trim()));
        if (optType.isEmpty()) {
            System.out.println("Tipo de manutenção não encontrado.");
            return;
        }

        try {
            controller.addMaintenanceToDroneModel(model.identity(), description, startDate, endDate, optType.get());
            System.out.println("Manutenção adicionada com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar manutenção: " + e.getMessage());
        }
    }

    @Override
    public String headline() {
        return "Editar Modelo de Drone";
    }
}
