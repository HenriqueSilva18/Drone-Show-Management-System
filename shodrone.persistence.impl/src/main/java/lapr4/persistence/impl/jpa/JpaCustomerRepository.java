package lapr4.persistence.impl.jpa;


import lapr4.Application;
import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.CustomerType;
import lapr4.customermanagement.domain.VAT;
import lapr4.customermanagement.domain.Representative;
import lapr4.customermanagement.repositories.CustomerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class JpaCustomerRepository
        extends JpaAutoTxRepository<Customer, VAT, VAT>
        implements CustomerRepository {

    public JpaCustomerRepository(final TransactionalContext autoTx) {
        super(autoTx, "vat");
    }

    public JpaCustomerRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "vat");
    }

    @Override
    public Optional<Customer> findByVAT(final VAT vat) {
        final Map<String, Object> params = new HashMap<>();
        params.put("vat", vat);
        return matchOne("e.vat=:vat", params);
    }

    @Override
    public Optional<Customer> findByVAT(final String vatNumber) {
        final Map<String, Object> params = new HashMap<>();
        params.put("vatNumber", vatNumber);
        return matchOne("e.vat.number=:vatNumber", params);
    }

    @Override
    public Iterable<Customer> findAllActive() {
        return match("e.customerStatus = 'CREATED'");
    }

    @Override
    public Iterable<Customer> findByType(final CustomerType type) {
        final Map<String, Object> params = new HashMap<>();
        params.put("type", type);
        return match("e.customerType = :type", params);
    }

    @Override
    public Optional<Representative> findRepresentativeByNIF(String nif) {
        final Map<String, Object> params = new HashMap<>();
        params.put("nif", nif);
        return entityManager()
                .createQuery("SELECT r FROM Representative r WHERE r.nif.nif = :nif", Representative.class)
                .setParameter("nif", nif)
                .getResultStream()
                .findFirst();
    }
}
