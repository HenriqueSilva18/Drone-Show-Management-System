package lapr4.figureManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
public class FigureCategory implements AggregateRoot<String> {

    @Id
    private String name;

    private String description;

    private LocalDateTime creationDate;

    private LocalDateTime lastEditionDate;

    private boolean isActive = true;



    protected FigureCategory() {
        // for JPA
    }

    public FigureCategory(String name, String description) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Category name must not be blank.");
        }
        this.name = name;
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Category description must not be blank.");
        }
        this.description = description;
        this.creationDate = LocalDateTime.now();
        this.lastEditionDate = null;
        this.isActive = true;
    }

    public String name() {
        return name;
    }

    public void deactivate() {
        if (!isActive) {
            throw new IllegalStateException("Category is already deactivated.");
        }
        this.isActive = false;
        this.lastEditionDate = LocalDateTime.now();
    }

    public void activate() {
        if (isActive) {
            throw new IllegalStateException("Category is already active.");
        }
        this.isActive = true;
        this.lastEditionDate = LocalDateTime.now();
    }

    public String description() {
        return description;
    }

    public LocalDateTime lastEditionDate() {
        return lastEditionDate;
    }

    public LocalDateTime creationDate() {
        return creationDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void updateDescription(String newDescription) {
        if (newDescription == null || newDescription.isBlank()) {
            throw new IllegalArgumentException("Invalid Description.");
        }
        this.description = newDescription;
        this.lastEditionDate = LocalDateTime.now();
    }


    @Override
    public String toString() {
        String formattedCreationDate = creationDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        return  "Name: '" + name + '\'' +
                ", Description: '" + description + '\'' +
                ", Creation Date: " + formattedCreationDate +
                ", Last Edition Date: " + lastEditionDate +
                ", State: " + (isActive ? "Active" : "Inactive");
    }


    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        FigureCategory that = (FigureCategory) other;
        return Objects.equals(name, that.name);
    }

    @Override
    public String identity() {
        return name;
    }

    /*Method just for testing purposes*/
    public void setIdentity(long l) {
        this.name = String.valueOf(l);
    }


    public FigureCategory(String name) {
        this(name, "No description");
    }
}
