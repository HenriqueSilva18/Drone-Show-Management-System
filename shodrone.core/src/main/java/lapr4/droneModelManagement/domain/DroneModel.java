package lapr4.droneModelManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lapr4.maintenanceManagement.domain.Maintenance;
import lapr4.maintenanceManagement.domain.MaintenanceType;

import java.util.*;

@Entity
public class DroneModel implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private List<String> modelSpecifications;

    private String name;

    @Embedded
    private Language language;

    @OneToMany(mappedBy = "droneModel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final Set<Maintenance> maintenances = new HashSet<>();


    protected DroneModel() {
        // for JPA
    }

    public DroneModel(List<String> modelSpecifications, String name, Language language) {
        if (modelSpecifications == null || modelSpecifications.isEmpty())
            throw new IllegalArgumentException("Model specifications cannot be empty.");
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank.");
        if (language == null)
            throw new IllegalArgumentException("Language cannot be null.");

        this.modelSpecifications = modelSpecifications;
        this.name = name;
        this.language = language;
    }


    public List<String> modelSpecifications() {
        return modelSpecifications;
    }

    public String name() {
        return name;
    }

    public Language language() {
        return language;
    }

    public Set<Maintenance> maintenances() {
        return Collections.unmodifiableSet(maintenances);
    }

    /**
     * Agendar nova manutenção para este modelo.
     */
    public void scheduleMaintenance(String description, String startDate, String endDate, MaintenanceType type) {
        Maintenance m = new Maintenance(description, startDate, endDate, type, this);
        maintenances.add(m);
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public boolean hasIdentity(Long id) {
        return this.id != null && this.id.equals(id);
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        DroneModel that = (DroneModel) other;
        return Objects.equals(id, that.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DroneModel)) return false;
        DroneModel that = (DroneModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
