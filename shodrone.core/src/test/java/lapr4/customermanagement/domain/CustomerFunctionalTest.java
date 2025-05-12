package lapr4.customermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFunctionalTest {

    @Mock
    private SystemUser mockSystemUser1;

    @Mock
    private SystemUser mockSystemUser2;

    private CustomerBuilder customerBuilder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerBuilder = new CustomerBuilder();
    }

    @Test
    void testCustomerCreationWithBuilder() {
        RepresentativeBuilder repBuilder = new RepresentativeBuilder()
                .withNIF("123456789")
                .withName("John Doe")
                .withEmail("john.doe@example.com")
                .withPhone("+351912345678")
                .withPosition("Manager")
                .withSystemUser(mockSystemUser1);

        Representative representative = repBuilder.build();

        Customer customer = customerBuilder
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .withStatus(CustomerStatus.CREATED)
                .withRepresentative(representative)
                .build();

        assertNotNull(customer);
        assertEquals("PT123456789", customer.identity().toString());
        assertEquals(CustomerType.REGULAR, customer.customerType());
        assertEquals(CustomerStatus.CREATED, customer.customerStatus());
        assertEquals(1, customer.representatives().size());
    }

    @Test
    void testAddingNewRepresentativeToCustomer() {
        RepresentativeBuilder repBuilder1 = new RepresentativeBuilder()
                .withNIF("123456789")
                .withName("John Doe")
                .withEmail("john.doe@example.com")
                .withPhone("+351912345678")
                .withPosition("Manager")
                .withSystemUser(mockSystemUser1);

        Representative representative1 = repBuilder1.build();

        Customer customer = customerBuilder
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .withRepresentative(representative1)
                .build();

        RepresentativeBuilder repBuilder2 = new RepresentativeBuilder()
                .withNIF("987654321")
                .withName("Jane Smith")
                .withEmail("jane.smith@example.com")
                .withPhone("+351912345678")
                .withPosition("Sales Manager")
                .withSystemUser(mockSystemUser2);

        Representative representative2 = repBuilder2.build();

        customer.addRepresentative(representative2);

        assertEquals(2, customer.representatives().size());
        assertTrue(customer.representatives().contains(representative1));
        assertTrue(customer.representatives().contains(representative2));

        assertEquals(customer, representative1.customer());
        assertEquals(customer, representative2.customer());
    }

    @Test
    void testPreventingDuplicateRepresentatives() {
        Representative representative1 = new RepresentativeBuilder()
                .withNIF("123456789")
                .withName("John Doe")
                .withEmail("john.doe@example.com")
                .withPhone("+351912345678")
                .withPosition("Manager")
                .withSystemUser(mockSystemUser1)
                .build();

        Customer customer = new CustomerBuilder()
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .withStatus(CustomerStatus.CREATED)
                .withRepresentative(representative1)
                .build();

        Representative duplicateRepresentative = new RepresentativeBuilder()
                .withNIF("123456789")
                .withName("John D.")
                .withEmail("john.d@example.com")
                .withPhone("+351912345679")
                .withPosition("Manager")
                .withSystemUser(mockSystemUser1)
                .build();

        assertThrows(IllegalArgumentException.class,
                () -> customer.addRepresentative(duplicateRepresentative));

        assertEquals(1, customer.representatives().size());
    }

    @Test
    void testCustomerRequiresAtLeastOneRepresentative() {
        VAT vat = new VAT("PT123456789");
        String name = "Test Company";
        Address address = new Address("Test Street", "Test City", "1234-567", "Test Country");
        Email email = new Email("company@test.com");
        Phone phone = new Phone("+351987654321");

        assertThrows(IllegalStateException.class, () -> {
            customerBuilder
                    .withVAT(vat)
                    .withName(name)
                    .withAddress(address)
                    .withEmail(email)
                    .withPhone(phone)
                    .withCustomerType(CustomerType.REGULAR)
                    .build();
        });
    }

    @Test
    void testCustomerWithMultipleRepresentatives() {
        List<Representative> representatives = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            Representative rep = new RepresentativeBuilder()
                    .withNIF("12345678" + i)
                    .withName("Representative " + i)
                    .withEmail("rep" + i + "@example.com")
                    .withPhone("+35191234567" + i)
                    .withPosition("Position " + i)
                    .withSystemUser(mockSystemUser1)
                    .build();

            representatives.add(rep);
        }

        CustomerBuilder builder = new CustomerBuilder()
                .withVAT("PT123456789")
                .withName("Multi-Rep Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.VIP)
                .withStatus(CustomerStatus.CREATED);

        for (Representative rep : representatives) {
            builder.withRepresentative(rep);
        }

        Customer customer = builder.build();

        assertEquals(3, customer.representatives().size());
        for (Representative rep : representatives) {
            assertTrue(customer.representatives().contains(rep));
            assertEquals(customer, rep.customer());
        }
    }
} 