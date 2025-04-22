package lapr4.persistence.impl.inmemory;

import lapr4.customermanagement.domain.*;
import lapr4.customermanagement.repositories.CustomerRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class InMemoryCustomerRepository
        extends InMemoryDomainRepository<Customer, VAT>
        implements CustomerRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Customer> findByVAT(VAT vat) {
        return Optional.ofNullable(super.data().get(vat));
    }

    @Override
    public Optional<Customer> findByVAT(String vatNumber) {
        return StreamSupport.stream(super.findAll().spliterator(), false)
                .filter(c -> c.identity().toString().equals(vatNumber))
                .findFirst();
    }

    @Override
    public Iterable<Customer> findAllActive() {
        return StreamSupport.stream(super.findAll().spliterator(), false)
                .filter(c -> c.customerStatus() == CustomerStatus.CREATED) // Changed from ACTIVE to CREATED
                .collect(Collectors.toList());
    }


    @Override
    public Iterable<Customer> findByType(CustomerType type) {
        return StreamSupport.stream(super.findAll().spliterator(), false)
                .filter(c -> c.customerType() == type)
                .collect(Collectors.toList());
    }
}
