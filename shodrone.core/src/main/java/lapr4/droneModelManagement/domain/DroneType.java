package lapr4.droneModelManagement.domain;

import jakarta.persistence.*;

@Entity
public class DroneType {


    @Id
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

    public String name() {
        return name;
    }
    public String description() {
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
        return name != null && name.equals(droneType.name);
    }

    public String identity() {
        return name;
    }
}
