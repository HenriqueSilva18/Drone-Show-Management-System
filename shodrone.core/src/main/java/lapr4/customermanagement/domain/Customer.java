package lapr4.customermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import jakarta.persistence.*;


@Entity
@Table(name = "CUSTOMER")
public class Customer implements AggregateRoot<VAT> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    private VAT vat;

    private String name;

    @Embedded
    private Address address;

    @Embedded
    private Email email;

    @Embedded
    private Phone phone;

    @Enumerated(EnumType.STRING)
    public CustomerType customerType;

    @Enumerated(EnumType.STRING)
    public CustomerStatus customerStatus;

    public Customer(final VAT vat, final String name, final Address address, final Email email,
                    final Phone phone, final CustomerType customerType, final CustomerStatus customerStatus) {

        if (vat == null || name == null || address == null || email == null ||
                phone == null || customerType == null || customerStatus == null) {
            throw new IllegalArgumentException("All customer attributes must be provided");
        }

        this.vat = vat;
        this.name = name.trim();
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
        this.customerStatus = customerStatus;
    }

    protected Customer() {
        // for ORM only
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
    public VAT identity() {
        return this.vat;
    }

    public CustomerType customerType() {
        return this.customerType;
    }

    public CustomerStatus customerStatus() {
        return this.customerStatus;
    }
}
