package lapr4.droneModelManagement.application;

import jakarta.transaction.Transactional;
import lapr4.droneModelManagement.domain.DroneType;

import java.util.Optional;

public class DroneTypeController {

    private final DroneTypeService droneTypeService = new DroneTypeService();

    @Transactional
    public DroneType registerDroneType(String name, String description) {
        DroneType type = new DroneType(name, description);
        return droneTypeService.registerDroneType(type);
    }

    public Iterable<DroneType> listAllTypes() {
        return droneTypeService.findAll();
    }

    public Optional<DroneType> findTypeByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("DroneType name cannot be null or empty");
        }
        return droneTypeService.findByName(name);
    }

    public DroneType editDroneTypeDescription(Long identity, String newDesc) {
        if (identity == null || newDesc == null || newDesc.isEmpty()) {
            throw new IllegalArgumentException("Identity and new description must not be null or empty");
        }
        DroneType type = droneTypeService.findById(identity)
                .orElseThrow(() -> new IllegalArgumentException("DroneType with given identity does not exist"));
        type.updateDescription(newDesc);
        return droneTypeService.updateDescription(type);
    }
}
