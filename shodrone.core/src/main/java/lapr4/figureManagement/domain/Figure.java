package lapr4.figureManagement.domain;

import jakarta.persistence.*;
import lapr4.customermanagement.domain.VAT;
import eapli.framework.domain.model.AggregateRoot;

import java.util.Objects;

@Entity
public class Figure implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private boolean exclusive;

    private boolean isActive = true;

    private boolean isPublic = false;

    @ManyToOne(optional = false)
    private FigureCategory category;

    @Embedded
    private VAT clientVAT;

    protected Figure() {
        // for JPA
    }

    public Figure(String description, boolean exclusive, VAT clientVAT, FigureCategory category) {
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("Description cannot be null or blank.");
        if (clientVAT == null)
            throw new IllegalArgumentException("Client VAT cannot be null.");

        if (category == null)
            throw new IllegalArgumentException("Category cannot be null.");

        this.category = category;
        this.description = description;
        this.exclusive = exclusive;
        this.clientVAT = clientVAT;
    }

    public String description() {
        return description;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public VAT clientVAT() {
        return clientVAT;
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
        Figure that = (Figure) other;
        return Objects.equals(id, that.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Figure)) return false;
        Figure that = (Figure) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public FigureCategory category() {
        return category;
    }

}
