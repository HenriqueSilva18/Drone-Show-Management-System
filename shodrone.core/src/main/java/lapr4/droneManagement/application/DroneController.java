package lapr4.droneManagement.application;

import jakarta.transaction.Transactional;
import lapr4.droneManagement.domain.*;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.maintenanceManagement.domain.Maintenance;

import java.util.List;

public class DroneController {

    private final DroneService droneService;

    public DroneController() {
        this.droneService = new DroneService();
    }

    @Transactional
    public Drone registerDrone(String serialNumberStr, List<Maintenance> maintenanceHistory, DroneModel model) {
        SerialNumber serialNumber = new SerialNumber(serialNumberStr);

        Drone drone = new Drone(serialNumber, maintenanceHistory, model);
        return droneService.registerDrone(drone);
    }

    public Iterable<Drone> listAllDrones() {
        return droneService.findAll();
    }

    public Drone findDroneBySerialNumber(String serialNumberStr) {
        SerialNumber id = new SerialNumber(serialNumberStr);
        return droneService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Drone not found with serial: " + serialNumberStr));
    }
}
