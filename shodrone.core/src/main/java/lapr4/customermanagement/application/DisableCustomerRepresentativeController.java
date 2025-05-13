package lapr4.customermanagement.application;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import jakarta.transaction.Transactional;
import lapr4.customermanagement.domain.*;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import eapli.framework.validations.Preconditions;
import lapr4.usermanagement.application.DeactivateUserController;

public class DisableCustomerRepresentativeController {

    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final DeactivateUserController userDeactivator = new DeactivateUserController();

    public void disableRepresentative(VAT customerVAT, String repNIF) throws ConcurrencyException, IntegrityViolationException {
        Preconditions.noneNull(customerVAT, repNIF);

        Customer customer = customerRepository.findByVAT(customerVAT)
                .orElseThrow(() ->
                        new IllegalArgumentException("Customer with VAT " + customerVAT + " not found."));

        Representative rep = customer.representatives().stream()
                .filter(r -> r.nif().equals(NIF.valueOf(repNIF)))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Representative with NIF " + repNIF + " not found."));

        try {
            userDeactivator.deactivateUser(rep.user());
        } catch (IntegrityViolationException | ConcurrencyException | IllegalStateException ex) {
            throw ex;
        }
    }
}