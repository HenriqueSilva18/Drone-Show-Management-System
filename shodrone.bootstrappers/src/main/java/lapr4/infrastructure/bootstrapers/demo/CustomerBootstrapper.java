/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package lapr4.infrastructure.bootstrapers.demo;

import lapr4.customermanagement.application.RegCustomerController;
import lapr4.customermanagement.domain.Address;
import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.CustomerType;
import lapr4.infrastructure.bootstrapers.TestDataConstants;
import lapr4.mycustomer.application.SignupController;
import lapr4.utentemanagement.application.AcceptRefuseSignupFactory;
import lapr4.utentemanagement.application.AcceptRefuseSignupRequestController;
import lapr4.utentemanagement.domain.SignupRequest;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Sousa
 */
public class CustomerBootstrapper implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            CustomerBootstrapper.class);

    private final RegCustomerController customerController = new RegCustomerController();

    @Override
    public boolean execute() {
        registerCustomer(
                "PT123456789", "Company One",
                new Address("Rua 123", "Lisbon", "1000-100", "Portugal"),
                "companyone@email.com", "255123456",
                List.of(newRepresentative("John Smith", "john.rep@companyone.com", "Sales Manager", "johnrep", "Password1", "John", "Smith"))
        );

        registerCustomer(
                "PT987654321", "Company Two",
                new Address("Rua 321", "Porto", "4000-200", "Portugal"),
                "companytwo@email.com", "251987654",
                List.of(
                        newRepresentative("Maria Silva", "maria.rep@companytwo.com", "CEO", "mariarep", "Password1", "Maria", "Silva"),
                        newRepresentative("Carlos Santos", "carlos.rep@companytwo.com", "Sales Manager", "carlosrep", "Password1", "Carlos", "Santos")
                )
        );

        return true;
    }

    private void registerCustomer(String vat, String name, Address address, String email, String phone,
                                  List<RegCustomerController.RepresentativeData> representatives) {
        try {
            CustomerType type = customerController.getCustomerTypes().iterator().next();
            Customer customer = customerController.registerCustomerWithMultipleRepresentatives(
                    vat, name, address, email, phone, type, representatives
            );
            LOGGER.info("Customer {} registered", customer.identity());
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            LOGGER.warn("Error creating customer {}", name, e);
        }
    }

    private RegCustomerController.RepresentativeData newRepresentative(
            String fullName, String email, String role, String username, String password, String firstName, String lastName) {
        return new RegCustomerController.RepresentativeData(
                fullName, email, role, username, password, firstName, lastName
        );
    }
}
