package lapr4.customermanagement.application;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.Representative;
import lapr4.customermanagement.domain.VAT;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.usermanagement.application.DeactivateUserController;

import java.util.Optional;

public class DisableCustomerRepresentativeController {

    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final DeactivateUserController deactivateUserController = new DeactivateUserController();

    public void disableRepresentative(VAT customerVAT, Integer repId) {
        authz.ensureAuthenticatedUserHasAnyOf(lapr4.usermanagement.domain.Roles.CRM_COLLABORATOR);

        final Customer customer = customerRepository.findByVAT(customerVAT)
                .orElseThrow(() -> new IllegalArgumentException("Customer with VAT " + customerVAT + " not found."));

        final Representative representative = customer.representatives().stream()
                .filter(rep -> rep.identity().equals(repId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Representative with ID " + repId + " not found."));

        final SystemUser user = representative.user();
        try {
            deactivateUserController.deactivateUser(user);
        } catch (IntegrityViolationException | ConcurrencyException e) {
            throw new IllegalStateException("Failed to deactivate the representative's user account.", e);
        }
    }
}
