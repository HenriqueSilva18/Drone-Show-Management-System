package lapr4.customermanagement.application;

import jakarta.transaction.Transactional;
import eapli.framework.application.ApplicationService;
import lapr4.customermanagement.domain.*;
import eapli.framework.validations.Preconditions;

@ApplicationService
public class EditCustomerRepresentativeController {

    private final CustomerService customerService = new CustomerService();

    @Transactional
    public void editRepresentative(VAT customerVAT, Integer repId, Email newEmail, Phone newPhone) {
        Preconditions.noneNull(customerVAT, repId, newEmail, newPhone);

        Customer customer = customerService.findCustomerByVAT(customerVAT)
                .orElseThrow(() -> new IllegalArgumentException("Customer with VAT " + customerVAT + " not found."));

        Representative representative = customer.representatives().stream()
                .filter(rep -> rep.identity().equals(repId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Representative with ID " + repId + " not found."));

        representative.updateContact(newEmail);

        customerService.registerCustomer(customer);
    }
}
