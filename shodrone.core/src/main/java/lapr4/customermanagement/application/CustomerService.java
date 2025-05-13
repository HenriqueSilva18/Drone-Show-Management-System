package lapr4.customermanagement.application;

import jakarta.transaction.Transactional;
import lapr4.customermanagement.domain.CustomerType;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.usermanagement.domain.Roles;
import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.VAT;
import lapr4.customermanagement.repositories.CustomerRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Optional;

public class CustomerService {

    private final AuthorizationService authz;
    private final CustomerRepository repo;

    public CustomerService() {
        this.authz = AuthzRegistry.authorizationService();
        this.repo = PersistenceContext.repositories().customers();
    }

    /**
     * Constructor for testing purposes
     */
    public CustomerService(CustomerRepository repository, AuthorizationService authorizationService) {
        this.authz = authorizationService;
        this.repo = repository;
    }

    public Optional<Customer> findCustomerByVAT(final VAT vat) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
        return repo.findByVAT(vat);
    }

    public Optional<Customer> findCustomerByVAT(final String vatNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
        return repo.findByVAT(vatNumber);
    }

    public Iterable<Customer> findAllActiveCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
        return repo.findAllActive();
    }

    @Transactional
    public Customer registerCustomer(final Customer customer) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
        return repo.save(customer);
    }

    public Iterable<CustomerType> getCustomerTypes() {
        return CustomerType.asList();
    }
}
