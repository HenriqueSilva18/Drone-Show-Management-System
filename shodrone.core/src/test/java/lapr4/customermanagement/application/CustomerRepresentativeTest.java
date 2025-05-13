package lapr4.customermanagement.application;

import lapr4.customermanagement.domain.Address;
import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.CustomerType;
import lapr4.customermanagement.domain.Representative;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerRepresentativeTest {
    static RegCustomerController regCustomerController = new RegCustomerController();
    static CustomerService customerService = new CustomerService();
    @BeforeAll
    public static void setUp() {
        regCustomerController.registerCustomerWithMultipleRepresentatives("1", "name", new Address("street", "city", "postalCode", "country"), "email", "phone", CustomerType.REGULAR, new ArrayList<>());
    }

   @AfterAll
   public static void tearDown() {
        // TODO: Add 'remover customer' function to the controller and use it here
   }

    @Test
    public void addRepresentativeToCustomer() {
        AddCustomerRepresentativeController addCustomerRepresentativeController = new AddCustomerRepresentativeController();
        RegCustomerController.RepresentativeData repData = new RegCustomerController.RepresentativeData("name", "email", "position", "username", "password", "firstName", "lastName");
        addCustomerRepresentativeController.addRepresentative("1", repData);
        Optional<Customer> customerOptional = customerService.findCustomerByVAT("1");
        assertTrue(customerOptional.isPresent());
        Customer customer = customerOptional.get();
        assertEquals(1, customer.representatives().size());
        Representative representative = customer.representatives().get(0);
        assertEquals("name", representative.name());
    }
}
