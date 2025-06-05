package lapr4.maintenanceManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * Entidade que representa um tipo de manutenção, configurável pelo utilizador.
 */
@Entity
public class MaintenanceType implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    protected MaintenanceType() {
        // Construtor vazio para JPA
    }

    public MaintenanceType(String name, String description) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Nome é obrigatório.");
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("Descrição é obrigatória.");
        this.name = name.trim();
        this.description = description.trim();
    }

    // Getters públicos
    public Long identity() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    /**
     * Atualiza os atributos, se forem válidos.
     */
    public void update(String newName, String newDescription) {
        if (newName == null || newName.isBlank())
            throw new IllegalArgumentException("Novo nome é obrigatório.");
        if (newDescription == null || newDescription.isBlank())
            throw new IllegalArgumentException("Nova descrição é obrigatória.");

        this.name = newName.trim();
        this.description = newDescription.trim();
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MaintenanceType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
