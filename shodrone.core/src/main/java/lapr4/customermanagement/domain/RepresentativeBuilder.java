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

    private String name;
    private Email email;
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
        if (this.name == null || this.email == null || this.position == null || this.systemUser == null) {
            throw new IllegalStateException("All representative attributes must be provided");
        }

        return new Representative(this.name, this.email, this.position, this.systemUser);
    }
}