package lapr4.customermanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 * A factory for Representative entities.
 *
 * This class follows the factory (DDD) pattern using a fluent interface
 * and acts as a Builder (GoF).
 */
public class RepresentativeBuilder implements DomainFactory<Representative> {

    private NIF nif;
    private String name;
    private Email email;
    private Phone phone;
    private String position;
    private SystemUser systemUser;

    public RepresentativeBuilder withName(final String name) {
        this.name = name;
        return this;
    }

    public RepresentativeBuilder withEmail(final Email email) {
        this.email = email;
        return this;
    }

    public RepresentativeBuilder withEmail(final String email) {
        this.email = new Email(email);
        return this;
    }

    public RepresentativeBuilder withPhone(final Phone phone) {
        this.phone = phone;
        return this;
    }

    public RepresentativeBuilder withNIF(final String nif) {
        this.nif = new NIF(nif);
        return this;
    }

    public RepresentativeBuilder withNIF(final NIF nif) {
        this.nif = nif;
        return this;
    }

    public RepresentativeBuilder withPhone(final String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    public RepresentativeBuilder withPosition(final String position) {
        this.position = position;
        return this;
    }

    public RepresentativeBuilder withSystemUser(final SystemUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }

    @Override
    public Representative build() {
        if (this.nif == null || this.name == null || this.email == null || this.position == null || this.systemUser == null) {
            throw new IllegalStateException("All representative attributes must be provided");
        }

        return new Representative(this.nif, this.name, this.email, this.phone, this.position, this.systemUser);
    }
}