package lapr4.droneModelManagement.domain.dto;

import lapr4.droneModelManagement.domain.DroneModel;

public class DroneModelDTO {
    public Long id;
    public String name;

    public DroneModelDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
