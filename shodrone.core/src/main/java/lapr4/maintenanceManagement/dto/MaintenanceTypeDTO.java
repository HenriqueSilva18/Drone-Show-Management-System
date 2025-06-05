package lapr4.maintenanceManagement.dto;

import eapli.framework.representations.dto.DTO;
import lapr4.maintenanceManagement.domain.MaintenanceType;

@DTO
public class MaintenanceTypeDTO {

    public Long id;
    public String name;
    public String description;

    public MaintenanceTypeDTO() {}

    public MaintenanceTypeDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static MaintenanceTypeDTO fromDomain(MaintenanceType type) {
        return new MaintenanceTypeDTO(type.identity(), type.name(), type.description());
    }

    public MaintenanceType toDomain() {
        return new MaintenanceType(name, description);
    }
}
