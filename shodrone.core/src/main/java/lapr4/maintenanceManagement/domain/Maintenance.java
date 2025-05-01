package lapr4.maintenanceManagement.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private String startDate;
    private String endDate;

    protected Maintenance() {
        // for JPA
    }

    public Maintenance(String description, String startDate, String endDate) {
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("Description cannot be empty.");
        if (startDate == null || endDate == null)
            throw new IllegalArgumentException("Dates cannot be null.");

        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters
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

    // equals and hashCode based on ID (JPA identity)

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
