package lapr4.customermanagement.repositories;

import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.CustomerType;
import lapr4.customermanagement.domain.VAT;
import lapr4.customermanagement.domain.Representative;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface CustomerRepository extends DomainRepository<VAT, Customer> {

    default Optional<Customer> findByVAT(final VAT vatNumber) {
        return ofIdentity(vatNumber);
    }

    Optional<Customer> findByVAT(String vatNumber);

    Iterable<Customer> findAllActive();

    Iterable<Customer> findByType(CustomerType type);

    Optional<Representative> findRepresentativeByNIF(String nif);
}
