package lapr4.customermanagement.domain;

import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.DomainEntities;
import jakarta.persistence.*;

@Entity
@Table(name = "REPRESENTATIVE")
public class Representative implements DomainEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Embedded
    private Email email;

    private String position;

    @ManyToOne
    @JoinColumn(name = "customer_vat")
    private Customer customer;

    public Representative(final String name, final Email email, final String position) {
        if (name == null || email == null || position == null) {
            throw new IllegalArgumentException("All representative attributes must be provided");
        }
        this.name = name.trim();
        this.email = email;
        this.position = position.trim();
    }

    protected Representative() {
        // for ORM only
    }

    public void associateCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Integer identity() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public Email email() {
        return this.email;
    }

    public String position() {
        return this.position;
    }
}