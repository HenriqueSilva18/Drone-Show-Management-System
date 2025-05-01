package lapr4.droneManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lapr4.maintenanceManagement.domain.Maintenance;
import lapr4.droneModelManagement.domain.DroneModel;

import java.util.List;
import java.util.Objects;

@Entity
public class Drone implements AggregateRoot<SerialNumber> {

    @EmbeddedId
    private SerialNumber serialNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Maintenance> maintenanceHistory;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DroneModel model;

    protected Drone() {
        // for JPA
    }

    public Drone(SerialNumber serialNumber, List<Maintenance> maintenanceHistory, DroneModel model) {
        this.serialNumber = serialNumber;
        this.maintenanceHistory = maintenanceHistory;
        this.model = model;
    }

    public SerialNumber serialNumber() {
        return serialNumber;
    }

    public List<Maintenance> maintenanceHistory() {
        return maintenanceHistory;
    }

    public DroneModel model() {
        return model;
    }

    @Override
    public SerialNumber identity() {
        return serialNumber;
    }

    @Override
    public boolean hasIdentity(SerialNumber id) {
        return serialNumber.equals(id);
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (!(other instanceof Drone)) return false;
        Drone that = (Drone) other;
        return Objects.equals(serialNumber, that.serialNumber);
    }
}
