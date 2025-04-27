package lapr4.customermanagement.application;

import lapr4.customermanagement.domain.*;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import eapli.framework.validations.Preconditions;

import java.util.List;


public class DisableCustomerRepresentativeController {

    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();

    public void disableRepresentative(VAT customerVAT, Integer repId) {
        Preconditions.noneNull(customerVAT, repId);

        Customer customer = customerRepository.findByVAT(customerVAT)
                .orElseThrow(() -> new IllegalArgumentException("Customer with VAT " + customerVAT + " not found."));

        Representative representative = customer.representatives().stream()
                .filter(rep -> rep.identity().equals(repId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Representative with ID " + repId + " not found."));

        customer.representatives().remove(representative);

        customerRepository.save(customer);
    }
}