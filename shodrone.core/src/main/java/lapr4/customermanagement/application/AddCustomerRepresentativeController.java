package lapr4.customermanagement.application;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.customermanagement.domain.*;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import eapli.framework.validations.Preconditions;

import java.util.List;

public class AddCustomerRepresentativeController {

    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();

    public void addRepresentative(VAT customerVAT, String repName, Email repEmail, String position, SystemUser systemUser) {
        Preconditions.noneNull(customerVAT, repName, repEmail, position, systemUser);

        Customer customer = customerRepository.findByVAT(customerVAT)
                .orElseThrow(() -> new IllegalArgumentException("Customer with VAT " + customerVAT + " not found."));

        Representative representative = new Representative(repName, repEmail, position, systemUser);

        customer.addRepresentative(representative);

        customerRepository.save(customer);
    }
}