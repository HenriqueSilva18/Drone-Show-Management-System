package lapr4.customermanagement.application;

import lapr4.customermanagement.domain.*;
import eapli.framework.application.ApplicationService;
import eapli.framework.domain.repositories.IntegrityViolationException;

@ApplicationService
public class RegCustomerController {
    private final CustomerService customerService;

    public RegCustomerController() {
        this.customerService = new CustomerService();
    }

    public Customer registerCustomer(String vatNumber, String name, Address address,
                                     String email, String phone, CustomerType type)
            throws IntegrityViolationException {

        Customer newCustomer = new CustomerBuilder()
                .withVAT(vatNumber)
                .withName(name)
                .withAddress(address)
                .withEmail(email)
                .withPhone(phone)
                .withCustomerType(type)
                .build();

        return customerService.registerCustomer(newCustomer);
    }

    public Iterable<CustomerType> getCustomerTypes() {
        return customerService.getCustomerTypes();
    }
}
