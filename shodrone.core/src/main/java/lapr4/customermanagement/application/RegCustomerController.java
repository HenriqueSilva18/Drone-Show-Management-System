package lapr4.customermanagement.application;

import jakarta.transaction.Transactional;
import lapr4.customermanagement.domain.*;
import lapr4.usermanagement.application.AddUserController;
import eapli.framework.application.ApplicationService;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.domain.services.DomainService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationService
public class RegCustomerController {
    private final CustomerService customerService;
    private final AddUserController userController;

    public RegCustomerController() {
        this.customerService = new CustomerService();
        this.userController = new AddUserController();
    }

    @Transactional
    public Customer registerCustomerWithMultipleRepresentatives(
            String vatNumber, String name, Address address,
            String email, String phone, CustomerType type,
            List<RepresentativeData> representativesData)
            throws IntegrityViolationException {

        if (representativesData == null || representativesData.isEmpty()) {
            throw new IllegalArgumentException("At least one representative must be provided");
        }

        List<Representative> representatives = new ArrayList<>();

        for (RepresentativeData repData : representativesData) {
            Set<Role> roles = new HashSet<>();
            roles.add(Role.valueOf("CUSTOMER_REPRESENTATIVE"));

            var systemUser = userController.addUser(
                    repData.username,
                    repData.password,
                    repData.firstName,
                    repData.lastName,
                    repData.email,
                    roles);

            Representative representative = new RepresentativeBuilder()
                    .withName(repData.name)
                    .withEmail(repData.email)
                    .withPosition(repData.position)
                    .withSystemUser(systemUser)
                    .build();

            representatives.add(representative);
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

    public static class RepresentativeData {
        public String name;
        public String email;
        public String position;
        public String username;
        public String password;
        public String firstName;
        public String lastName;

        public RepresentativeData(String name, String email, String position,
                                  String username, String password, String firstName, String lastName) {
            this.name = name;
            this.email = email;
            this.position = position;
            this.username = username;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}
