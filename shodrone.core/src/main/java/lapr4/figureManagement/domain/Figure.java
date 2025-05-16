package lapr4.figureManagement.domain;

import jakarta.persistence.*;
import lapr4.customermanagement.domain.VAT;
import eapli.framework.domain.model.AggregateRoot;

import java.util.*;
import java.util.Objects;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

@Entity
public class Figure implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @ElementCollection
    @CollectionTable(name = "figure_keywords", joinColumns = @JoinColumn(name = "figure_id"))
    @Column(name = "keyword")
    private Set<String> keywords = new HashSet<>();


    private boolean exclusive;

    private boolean isActive = true;

    @ManyToOne(optional = false)
    private FigureCategory category;

    @Embedded
    private VAT clientVAT;


    private LocalDateTime decommissionDate;

    protected Figure() {
        // for JPA
    }

    public Figure(String description, Set<String> keywords, boolean exclusive, VAT clientVAT, FigureCategory category) {
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("Description cannot be null or blank.");

        if (clientVAT == null)
            throw new IllegalArgumentException("Client VAT cannot be null.");

        if (category == null)
            throw new IllegalArgumentException("Category cannot be null.");

        this.decommissionDate = null;
        this.category = category;
        this.keywords = keywords;
        this.description = description;
        this.exclusive = exclusive;
        this.clientVAT = clientVAT;
    }

    public Figure(String description, boolean exclusive, VAT clientVAT, FigureCategory category) {
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("Description cannot be null or blank.");

        if (clientVAT == null)
            throw new IllegalArgumentException("Client VAT cannot be null.");

        if (category == null)
            throw new IllegalArgumentException("Category cannot be null.");

        this.decommissionDate = null;
        this.category = category;
        this.keywords = new HashSet<>();
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

    public FigureCategory category() {
        return category;
    }

    public void setCategory(FigureCategory category) {
        this.category = category;
    }

    public Set<String> keywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        if (keywords == null) {
            throw new IllegalArgumentException("Keywords cannot be null.");
        }
        this.keywords = new HashSet<>(keywords);
    }

    public void addKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException("Keyword cannot be null or blank.");
        }
        this.keywords.add(keyword);
    }

    public void removeKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException("Keyword cannot be null or blank.");
        }
        this.keywords.remove(keyword);
    }

    public boolean hasKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException("Keyword cannot be null or blank.");
        }
        return this.keywords.contains(keyword);
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank.");
        }
        this.description = description;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }


    public LocalDateTime getDecommissionDate() {
        return decommissionDate;
    }

    public void setDecommissionDate(LocalDateTime decommissionDate) {
        this.decommissionDate = decommissionDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Figure ID: %d | Description: %s | Keywords: [%s] | Category: %s | %s | Active: %s",
                id,
                description,
                keywords.stream().collect(Collectors.joining(", ")),
                category.name(),
                exclusive ? "Private to " + clientVAT : "Public",
                isActive ? "Yes" : "No"
        );
    }

    /* Method to be used ONLY for tests */
    public void setIdentity(long l) {
        if (l <= 0) {
            throw new IllegalArgumentException("ID must be a positive number.");
        }
        this.id = l;
    }
}
