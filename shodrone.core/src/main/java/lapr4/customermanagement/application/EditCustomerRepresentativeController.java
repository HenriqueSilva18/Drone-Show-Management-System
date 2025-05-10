package lapr4.customermanagement.application;

import lapr4.customermanagement.domain.*;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import eapli.framework.validations.Preconditions;

import java.util.List;

public class EditCustomerRepresentativeController {

    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();

    public void editRepresentative(VAT customerVAT, String repId, Email newEmail, Phone newPhone) {
        Preconditions.noneNull(customerVAT, repId);

        Customer customer = customerRepository.findByVAT(customerVAT)
                .orElseThrow(() -> new IllegalArgumentException("Customer with VAT " + customerVAT + " not found."));

        NIF nif = new NIF(repId);

        Representative representative = customer.representatives().stream()
                .filter(rep -> rep.identity().equals(nif))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Representative with NIF " + repId + " not found."));

        representative.updateContact(newEmail, newPhone);

        customerRepository.save(customer);
    }
}
