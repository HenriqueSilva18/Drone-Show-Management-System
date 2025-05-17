package lapr4.customermanagement.domain;

import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.persistence.*;

@Entity
@Table(name = "REPRESENTATIVE")
public class Representative implements DomainEntity<NIF> {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private NIF nif;

    private String name;

    @Embedded
    @Column(unique = true)
    private Email email;

    @Embedded
    @Column(unique = true)
    private Phone phone;

    private String position;

    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @OneToOne()
    private SystemUser systemUser;

    @ManyToOne
    @JoinColumn(name = "customer_vat")
    private Customer customer;

    public Representative(final NIF nif, final String name, final Email email, final Phone phone, final String position, final SystemUser systemUser) {
        if (nif == null || name == null || email == null || position == null || systemUser == null) {
            throw new IllegalArgumentException("All representative attributes must be provided");
        }
        this.nif = nif;
        this.name = name.trim();
        this.email = email;
        this.phone = phone;
        this.position = position.trim();
        this.systemUser = systemUser;
    }

    protected Representative() {
        // for ORM only
    }

    public void associateCustomer(Customer customer) {
        this.customer = customer;
    }

    public SystemUser user() {
        return this.systemUser;
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
    public NIF identity() {
        return this.nif;
    }

    public void updateContact(final Email newEmail, final Phone newPhone) {
        if (newEmail == null && newPhone == null) {
            throw new IllegalArgumentException("At least one of email or phone must be provided");
        }
        if (newEmail != null) {
            this.email = newEmail;
        }
        if (newPhone != null) {
            this.phone = newPhone;
        }
    }

    public String name() {
        return this.name;
    }

    public Email email() {
        return this.email;
    }

    public NIF nif() {return this.nif;}

    public Phone phone() {
        return this.phone;
    }

    public String position() {
        return this.position;
    }

    public Customer customer() {
        return this.customer;
    }
}