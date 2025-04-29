package lapr4.customermanagement.application;

import lapr4.customermanagement.domain.*;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import eapli.framework.validations.Preconditions;

import java.util.List;

public class EditCustomerRepresentativeController {

    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();

    public void editRepresentative(VAT customerVAT, Integer repId, Email newEmail, String newPosition) {
        Preconditions.noneNull(customerVAT, repId, newEmail, newPosition);

        Customer customer = customerRepository.findByVAT(customerVAT)
                .orElseThrow(() -> new IllegalArgumentException("Customer with VAT " + customerVAT + " not found."));

        Representative representative = customer.representatives().stream()
                .filter(rep -> rep.identity().equals(repId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Representative with ID " + repId + " not found."));

        representative.updateEmailAndPosition(newEmail, newPosition);

        customerRepository.save(customer);
    }
}
