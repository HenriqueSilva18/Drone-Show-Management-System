package lapr4.droneModelManagement.application;

import jakarta.transaction.Transactional;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.droneModelManagement.application.DroneModelService;
import lapr4.droneModelManagement.domain.Language;

import java.util.List;

public class DroneModelController {

    private final DroneModelService droneModelService = new DroneModelService();

    @Transactional
    public DroneModel registerDroneModel(String name, List<String> specifications, Language language) {
        DroneModel model = new DroneModel(specifications, name, language);
        return droneModelService.registerDroneModel(model);
    }

    public Iterable<DroneModel> listAllModels() {
        return droneModelService.findAll();
    }

    public DroneModel findModelById(Long id) {
        return droneModelService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DroneModel not found with ID: " + id));
    }
}
