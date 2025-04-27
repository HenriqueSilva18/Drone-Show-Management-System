package lapr4.customermanagement.application;

import jakarta.transaction.Transactional;
import eapli.framework.application.ApplicationService;
import lapr4.customermanagement.domain.*;
import eapli.framework.validations.Preconditions;

import java.util.Calendar;

@ApplicationService
public class DisableCustomerRepresentativeController {

    private final CustomerService customerService = new CustomerService();

    @Transactional
    public void disableRepresentative(VAT customerVAT, Integer repId) {
        Preconditions.noneNull(customerVAT, repId);

        Customer customer = customerService.findCustomerByVAT(customerVAT)
                .orElseThrow(() -> new IllegalArgumentException("Customer with VAT " + customerVAT + " not found."));

        Representative representative = customer.representatives().stream()
                .filter(rep -> rep.identity().equals(repId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Representative with ID " + repId + " not found."));

        representative.user().deactivate(Calendar.getInstance());

        customerService.registerCustomer(customer);
    }
}
