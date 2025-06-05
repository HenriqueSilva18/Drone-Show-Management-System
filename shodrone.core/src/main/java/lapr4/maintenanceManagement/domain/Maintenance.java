package lapr4.maintenanceManagement.domain;

import jakarta.persistence.*;
import lapr4.droneModelManagement.domain.DroneModel;


import java.util.Objects;

@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String startDate;
    private String endDate;

    @ManyToOne(optional = false)
    private MaintenanceType maintenanceType;

    @ManyToOne(optional = false)
    private DroneModel droneModel;

    protected Maintenance() {
        // for JPA
    }

    public Maintenance(String description, String startDate, String endDate,
                       MaintenanceType maintenanceType, DroneModel droneModel) {
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("Descrição inválida");
        if (startDate == null || endDate == null)
            throw new IllegalArgumentException("Datas não podem ser nulas");
        if (maintenanceType == null)
            throw new IllegalArgumentException("Tipo de manutenção obrigatório");
        if (droneModel == null)
            throw new IllegalArgumentException("DroneModel obrigatório");

        this.description = description.trim();
        this.startDate = startDate;
        this.endDate = endDate;
        this.maintenanceType = maintenanceType;
        this.droneModel = droneModel;
    }

    public Long id() {
        return id;
    }

    public String description() {
        return description;
    }

    public String startDate() {
        return startDate;
    }

    public String endDate() {
        return endDate;
    }

    public MaintenanceType maintenanceType() {
        return maintenanceType;
    }

    public DroneModel droneModel() {
        return droneModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Maintenance)) return false;
        Maintenance that = (Maintenance) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
