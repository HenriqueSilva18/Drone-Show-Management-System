package lapr4.customermanagement.application;

import eapli.framework.application.ApplicationService;
import lapr4.customermanagement.domain.*;
import eapli.framework.validations.Preconditions;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationService
public class ListCustomerRepresentativesController {

    private final CustomerService customerService = new CustomerService();

    public List<Representative> listActiveRepresentatives(VAT customerVAT) {
        Preconditions.noneNull(customerVAT);

        Customer customer = customerService.findCustomerByVAT(customerVAT)
                .orElseThrow(() -> new IllegalArgumentException("Customer with VAT " + customerVAT + " not found."));

        return customer.representatives().stream()
                .filter(rep -> rep.user().isActive()) // ✅ Só listar ativos
                .collect(Collectors.toList());
    }
}
