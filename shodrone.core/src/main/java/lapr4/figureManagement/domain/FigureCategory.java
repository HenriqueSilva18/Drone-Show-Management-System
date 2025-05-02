package lapr4.figureManagement.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FigureCategory {

    @Id
    private String name;

    protected FigureCategory() {
        // for JPA
    }

    public FigureCategory(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Category name must not be blank.");
        }
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
