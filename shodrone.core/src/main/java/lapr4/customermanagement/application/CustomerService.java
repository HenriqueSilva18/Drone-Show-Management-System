package lapr4.customermanagement.application;

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

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CustomerRepository repo = PersistenceContext.repositories().customers();

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

    public Customer registerCustomer(final Customer customer) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
        return repo.save(customer);
    }

    public Iterable<CustomerType> getCustomerTypes() {
        return CustomerType.asList();
    }
}
