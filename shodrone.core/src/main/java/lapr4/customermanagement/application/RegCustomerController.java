package lapr4.customermanagement.application;

import lapr4.customermanagement.domain.*;
import eapli.framework.application.ApplicationService;
import eapli.framework.domain.repositories.IntegrityViolationException;

import java.util.ArrayList;
import java.util.List;

@ApplicationService
public class RegCustomerController {
    private final CustomerService customerService;

    public RegCustomerController() {
        this.customerService = new CustomerService();
    }

    public Customer registerCustomer(String vatNumber, String name, Address address,
                                     String email, String phone, CustomerType type,
                                     String repName, String repEmail, String repPosition)
            throws IntegrityViolationException {

        List<Representative> representatives = new ArrayList<>();
        representatives.add(new Representative(repName, new Email(repEmail), repPosition));

        Customer newCustomer = new CustomerBuilder()
                .withVAT(vatNumber)
                .withName(name)
                .withAddress(address)
                .withEmail(email)
                .withPhone(phone)
                .withCustomerType(type)
                .withRepresentative(repName, repEmail, repPosition)
                .build();

        return customerService.registerCustomer(newCustomer);
    }

    public Customer registerCustomerWithMultipleRepresentatives(String vatNumber, String name, Address address,
                                                                String email, String phone, CustomerType type,
                                                                List<Representative> representatives)
            throws IntegrityViolationException {

        if (representatives == null || representatives.isEmpty()) {
            throw new IllegalArgumentException("At least one representative must be provided");
        }

        CustomerBuilder builder = new CustomerBuilder()
                .withVAT(vatNumber)
                .withName(name)
                .withAddress(address)
                .withEmail(email)
                .withPhone(phone)
                .withCustomerType(type);

        for (Representative rep : representatives) {
            builder.withRepresentative(rep);
        }

        Customer newCustomer = builder.build();
        return customerService.registerCustomer(newCustomer);
    }

    public Iterable<CustomerType> getCustomerTypes() {
        return customerService.getCustomerTypes();
    }
}