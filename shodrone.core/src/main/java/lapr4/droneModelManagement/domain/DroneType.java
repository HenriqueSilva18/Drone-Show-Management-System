package lapr4.droneModelManagement.domain;

import jakarta.persistence.*;

@Entity
public class DroneType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    protected DroneType() {
        // for JPA
    }

    public DroneType(String name, String description) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank.");
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public void updateDescription(String description) {
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("Description cannot be null or blank.");
        this.description = description;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DroneType)) return false;
        DroneType droneType = (DroneType) o;
        return id != null && id.equals(droneType.id);
    }

    public Long identity() {
        return id;
    }
}
