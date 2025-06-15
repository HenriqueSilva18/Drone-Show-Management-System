package lapr4.droneModelManagement.application;

import lapr4.droneModelManagement.domain.DroneType;

public class DroneTypeController {

    private final DroneTypeService service = new DroneTypeService();



    public DroneType registerDroneType(String name, String description) {
        return service.registerDroneType(name, description);
    }

    public DroneType findByName(String name) {
        return service.findByName(name);
    }

    public Iterable<DroneType> getAllDroneTypes() {
        return service.findAll();
    }
}