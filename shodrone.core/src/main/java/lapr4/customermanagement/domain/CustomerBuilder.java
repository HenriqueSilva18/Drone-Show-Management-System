package lapr4.customermanagement.domain;

import eapli.framework.domain.model.DomainFactory;

import java.util.ArrayList;
import java.util.List;

public class CustomerBuilder implements DomainFactory<Customer> {

    private VAT vat;
    private String name;
    private Address address;
    private Email email;
    private Phone phone;
    private CustomerType customerType;
    private CustomerStatus customerStatus = CustomerStatus.CREATED;
    private List<Representative> representatives = new ArrayList<>();

    public CustomerBuilder withVAT(final VAT vat) {
        this.vat = vat;
        return this;
    }

    public CustomerBuilder withVAT(final String vat) {
        this.vat = new VAT(vat);
        return this;
    }

    public CustomerBuilder withName(final String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder withAddress(final Address address) {
        this.address = address;
        return this;
    }

    public CustomerBuilder withAddress(final String street, final String city,
                                       final String postalCode, final String country) {
        this.address = new Address(street, city, postalCode, country);
        return this;
    }

    public CustomerBuilder withEmail(final Email email) {
        this.email = email;
        return this;
    }

    public CustomerBuilder withEmail(final String email) {
        this.email = new Email(email);
        return this;
    }

    public CustomerBuilder withPhone(final Phone phone) {
        this.phone = phone;
        return this;
    }

    public CustomerBuilder withPhone(final String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    public CustomerBuilder withCustomerType(final CustomerType customerType) {
        this.customerType = customerType;
        return this;
    }

    public CustomerBuilder withStatus(final CustomerStatus status) {
        this.customerStatus = status;
        return this;
    }

    public CustomerBuilder withRepresentative(final Representative representative) {
        this.representatives.add(representative);
        return this;
    }

    public CustomerBuilder withRepresentative(final String name, final String email, final String position) {
        Representative representative = new Representative(name, new Email(email), position);
        this.representatives.add(representative);
        return this;
    }

    @Override
    public Customer build() {
        if (this.representatives.isEmpty()) {
            throw new IllegalStateException("Customer must have at least one representative");
        }

        return new Customer(this.vat, this.name, this.address,
                this.email, this.phone, this.customerType, this.customerStatus, this.representatives);
    }
}