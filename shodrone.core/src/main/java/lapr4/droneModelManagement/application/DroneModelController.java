package lapr4.droneModelManagement.application;

import jakarta.transaction.Transactional;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.droneModelManagement.application.DroneModelService;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.droneModelManagement.domain.Language;
import lapr4.maintenanceManagement.domain.MaintenanceType;

import java.util.List;

public class DroneModelController {

    private final DroneModelService droneModelService = new DroneModelService();

    @Transactional
    public DroneModel registerDroneModel(String name, List<String> specifications, Language language, DroneType droneType) {
        DroneModel model = new DroneModel(specifications, name, language, droneType);
        return droneModelService.registerDroneModel(model);
    }

    @Transactional
    public void addMaintenanceToDroneModel(Long droneModelId,
                                           String description,
                                           String startDate,
                                           String endDate,
                                           MaintenanceType type) {
        DroneModel model = findModelById(droneModelId);
        model.scheduleMaintenance(description, startDate, endDate, type);
        droneModelService.save(model); // persiste alterações
    }

    public Iterable<DroneModel> listAllModels() {
        return droneModelService.findAll();
    }

    public DroneModel findModelById(Long id) {
        return droneModelService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DroneModel not found with ID: " + id));
    }
}
