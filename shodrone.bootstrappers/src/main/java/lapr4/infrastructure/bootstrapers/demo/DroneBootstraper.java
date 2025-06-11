/* package lapr4.infrastructure.bootstrapers.demo;

import eapli.framework.actions.Action;
import lapr4.droneManagement.application.DroneService;
import lapr4.droneManagement.domain.Drone;
import lapr4.droneManagement.domain.SerialNumber;
import lapr4.droneModelManagement.application.DroneModelService;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.maintenanceManagement.application.CreateMaintenanceTypeController;
import lapr4.maintenanceManagement.application.ListMaintenanceTypesController;
import lapr4.maintenanceManagement.domain.Maintenance;
import lapr4.maintenanceManagement.domain.MaintenanceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DroneBootstraper implements Action {

    private final DroneService droneService = new DroneService();
    private final DroneModelService droneModelService = new DroneModelService();
    private final CreateMaintenanceTypeController createMaintenanceTypeController = new CreateMaintenanceTypeController();
    private final ListMaintenanceTypesController listMaintenanceTypesController = new ListMaintenanceTypesController();

    @Override
    public boolean execute() {
        System.out.println("Bootstrapping Drones...");

        // Criar tipos de manutenção, se não existirem
        MaintenanceType inspectionType = ensureMaintenanceTypeExists("Inspeção", "Inspeção de rotina do drone.");
        MaintenanceType repairType = ensureMaintenanceTypeExists("Reparo", "Reparo de componentes danificados.");

        // Obter modelos de drone (assumindo que DroneModelBootstraper já foi executado)
        Iterable<DroneModel> models = droneModelService.findAll();
        List<DroneModel> droneModels = new ArrayList<>();
        models.forEach(droneModels::add);

        if (droneModels.isEmpty()) {
            System.out.println("Nenhum modelo de drone encontrado. Execute DroneModelBootstraper primeiro.");
            return false;
        }

        // Criar Drones e associá-los a modelos e manutenções
        // Drone 1: Associado a Phantom 4 Pro
        DroneModel phantom4Pro = droneModels.stream()
                .filter(m -> m.name().equals("Phantom 4 Pro"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Phantom 4 Pro not found"));

        List<Maintenance> maintenanceHistory1 = new ArrayList<>();
        maintenanceHistory1.add(new Maintenance("Verificação inicial", "2023-01-10", "2023-01-10", inspectionType, phantom4Pro));
        droneService.registerDrone(new Drone(new SerialNumber("DRONE-001"), maintenanceHistory1, phantom4Pro));

        // Drone 2: Associado a Mavic 2 Pro
        DroneModel mavic2Pro = droneModels.stream()
                .filter(m -> m.name().equals("Mavic 2 Pro"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Mavic 2 Pro not found"));

        List<Maintenance> maintenanceHistory2 = new ArrayList<>();
        maintenanceHistory2.add(new Maintenance("Troca de hélice", "2023-03-15", "2023-03-15", repairType, mavic2Pro));
        droneService.registerDrone(new Drone(new SerialNumber("DRONE-002"), maintenanceHistory2, mavic2Pro));

        // Drone 3: Associado a Inspire 2
        DroneModel inspire2 = droneModels.stream()
                .filter(m -> m.name().equals("Inspire 2"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Inspire 2 not found"));

        List<Maintenance> maintenanceHistory3 = new ArrayList<>();
        maintenanceHistory3.add(new Maintenance("Calibragem de câmera", "2023-05-20", "2023-05-20", inspectionType, inspire2));
        droneService.registerDrone(new Drone(new SerialNumber("DRONE-003"), maintenanceHistory3, inspire2));

        System.out.println("Drones bootstrapped successfully.");
        return true;
    }

    private MaintenanceType ensureMaintenanceTypeExists(String name, String description) {
        List<MaintenanceType> existingTypes = new ArrayList<>();
        listMaintenanceTypesController.listAll().forEach(existingTypes::add);
        Optional<MaintenanceType> existingType = existingTypes.stream()
                .filter(mt -> mt.name().equalsIgnoreCase(name))
                .findFirst();

        if (existingType.isPresent()) {
            return existingType.get();
        } else {
            return createMaintenanceTypeController.create(name, description);
        }
    }
}

 */