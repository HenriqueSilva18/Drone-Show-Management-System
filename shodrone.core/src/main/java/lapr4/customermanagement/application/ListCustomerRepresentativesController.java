package lapr4.customermanagement.application;

import lapr4.customermanagement.domain.*;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import eapli.framework.validations.Preconditions;
import java.util.List;
import java.util.stream.Collectors;

public class ListCustomerRepresentativesController {

    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();

    public List<Representative> listRepresentatives(VAT customerVAT) {
        Preconditions.nonNull(customerVAT);

        Customer customer = customerRepository.findByVAT(customerVAT)
                .orElseThrow(() ->
                        new IllegalArgumentException("Customer with VAT " + customerVAT + " not found."));

        return customer.representatives().stream()
                .filter(rep -> rep.user().isActive())
                .collect(Collectors.toList());
    }
}
