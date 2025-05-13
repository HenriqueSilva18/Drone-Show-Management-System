package lapr4.customermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CustomerTest {

    @Mock
    private SystemUser mockSystemUser;

    private VAT validVAT;
    private String validName;
    private Address validAddress;
    private Email validEmail;
    private Phone validPhone;
    private CustomerType validCustomerType;
    private CustomerStatus validCustomerStatus;
    private List<Representative> validRepresentatives;
    private Representative validRepresentative;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        validVAT = new VAT("PT123456789");
        validName = "Test Company";
        validAddress = new Address("Test Street", "Test City", "1234-567", "Test Country");
        validEmail = new Email("company@test.com");
        validPhone = new Phone("+351912345678");
        validCustomerType = CustomerType.REGULAR;
        validCustomerStatus = CustomerStatus.CREATED;

        NIF validNif = new NIF("123456789");
        validRepresentative = new Representative(validNif, "John Doe",
                new Email("john.doe@example.com"),
                new Phone("+351987654321"),
                "Manager", mockSystemUser);

        validRepresentatives = new ArrayList<>();
        validRepresentatives.add(validRepresentative);
    }

    @Test
    void testConstructor_WithValidParameters_ShouldCreateCustomer() {
        Customer customer = new Customer(validVAT, validName, validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);

        assertNotNull(customer);
        assertEquals(validVAT, customer.identity());
        assertEquals(validCustomerType, customer.customerType());
        assertEquals(validCustomerStatus, customer.customerStatus());
        assertEquals(1, customer.representatives().size());
        assertTrue(customer.representatives().contains(validRepresentative));
    }

    @Test
    void testConstructor_WithNullVAT_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Customer(null, validName, validAddress, validEmail, validPhone,
                        validCustomerType, validCustomerStatus, validRepresentatives));
    }

    @Test
    void testConstructor_WithNullName_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Customer(validVAT, null, validAddress, validEmail, validPhone,
                        validCustomerType, validCustomerStatus, validRepresentatives));
    }

    @Test
    void testConstructor_WithNullAddress_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Customer(validVAT, validName, null, validEmail, validPhone,
                        validCustomerType, validCustomerStatus, validRepresentatives));
    }

    @Test
    void testConstructor_WithNullEmail_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Customer(validVAT, validName, validAddress, null, validPhone,
                        validCustomerType, validCustomerStatus, validRepresentatives));
    }

    @Test
    void testConstructor_WithNullPhone_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Customer(validVAT, validName, validAddress, validEmail, null,
                        validCustomerType, validCustomerStatus, validRepresentatives));
    }

    @Test
    void testConstructor_WithNullCustomerType_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Customer(validVAT, validName, validAddress, validEmail, validPhone,
                        null, validCustomerStatus, validRepresentatives));
    }

    @Test
    void testConstructor_WithNullCustomerStatus_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Customer(validVAT, validName, validAddress, validEmail, validPhone,
                        validCustomerType, null, validRepresentatives));
    }

    @Test
    void testConstructor_WithEmptyRepresentativesList_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Customer(validVAT, validName, validAddress, validEmail, validPhone,
                        validCustomerType, validCustomerStatus, new ArrayList<>()));
    }

    @Test
    void testConstructor_WithNullRepresentativesList_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Customer(validVAT, validName, validAddress, validEmail, validPhone,
                        validCustomerType, validCustomerStatus, null));
    }

    @Test
    void testConstructor_ShouldTrimName() {
        String nameWithSpaces = "  Test Company  ";

        Customer customer = assertDoesNotThrow(() -> new Customer(validVAT, nameWithSpaces, validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives));

        assertNotNull(customer);
    }

    @Test
    void testAddRepresentative_WithValidRepresentative_ShouldAddToList() {
        Customer customer = new Customer(validVAT, validName, validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);

        NIF newNif = new NIF("987654321");
        Representative newRepresentative = new Representative(newNif, "Jane Smith",
                new Email("jane.smith@example.com"),
                new Phone("+351911122233"),
                "Sales", mockSystemUser);

        customer.addRepresentative(newRepresentative);

        assertEquals(2, customer.representatives().size());
        assertTrue(customer.representatives().contains(newRepresentative));
    }

    @Test
    void testAddRepresentative_WithNullRepresentative_ShouldThrowException() {
        Customer customer = new Customer(validVAT, validName, validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);

        assertThrows(IllegalArgumentException.class, () -> customer.addRepresentative(null));
    }

    @Test
    void testAddRepresentative_WithDuplicateRepresentative_ShouldThrowException() {
        Customer customer = new Customer(validVAT, validName, validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);

        Representative duplicateRepresentative = new Representative(
                validRepresentative.identity(),
                "Different Name",
                validRepresentative.email(),
                validRepresentative.phone(),
                "Different Position",
                mockSystemUser);

        assertThrows(IllegalArgumentException.class, () -> customer.addRepresentative(duplicateRepresentative));
    }

    @Test
    void testRepresentatives_ShouldReturnUnmodifiableList() {
        Customer customer = new Customer(validVAT, validName, validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);

        List<Representative> representatives = customer.representatives();

        assertThrows(UnsupportedOperationException.class, () -> representatives.add(null));
    }

    @Test
    void testEquals_WithSameIdentity_ShouldReturnTrue() {
        Customer customer1 = new Customer(validVAT, validName, validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);
        Customer customer2 = new Customer(validVAT, "Different Name", validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);

        assertEquals(customer1, customer2);
    }

    @Test
    void testEquals_WithDifferentIdentity_ShouldReturnFalse() {
        Customer customer1 = new Customer(validVAT, validName, validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);
        Customer customer2 = new Customer(new VAT("PT987654321"), validName, validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);

        assertNotEquals(customer1, customer2);
    }

    @Test
    void testHashCode_WithSameIdentity_ShouldReturnSameHashCode() {
        Customer customer1 = new Customer(validVAT, validName, validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);
        Customer customer2 = new Customer(validVAT, "Different Name", validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);

        assertEquals(customer1.hashCode(), customer2.hashCode());
    }

    @Test
    void testSameAs_WithSameIdentity_ShouldReturnTrue() {
        Customer customer1 = new Customer(validVAT, validName, validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);
        Customer customer2 = new Customer(validVAT, "Different Name", validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);

        assertTrue(customer1.sameAs(customer2));
    }
} 