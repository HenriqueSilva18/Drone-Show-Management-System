package lapr4.customermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CustomerBuilderTest {

    @Mock
    private SystemUser mockSystemUser;

    private CustomerBuilder builder;
    private Representative validRepresentative;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        builder = new CustomerBuilder();

        NIF validNif = new NIF("123456789");
        validRepresentative = new Representative(validNif, "John Doe",
                new Email("john.doe@example.com"),
                new Phone("+351912345678"),
                "Manager", mockSystemUser);
    }

    @Test
    void testBuild_WithAllRequiredParameters_ShouldCreateCustomer() {
        Customer customer = builder
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .withRepresentative(validRepresentative)
                .build();

        assertNotNull(customer);
        assertEquals("PT123456789", customer.identity().toString());
        assertEquals(CustomerType.REGULAR, customer.customerType());
        assertEquals(CustomerStatus.CREATED, customer.customerStatus());
    }

    @Test
    void testBuild_WithoutRepresentative_ShouldThrowException() {
        assertThrows(IllegalStateException.class, () -> builder
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .build());
    }

    @Test
    void testBuild_WithCustomStatus_ShouldUseProvidedStatus() {
        Customer customer = builder
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .withStatus(CustomerStatus.INFRINGEMENT)
                .withRepresentative(validRepresentative)
                .build();

        assertEquals(CustomerStatus.INFRINGEMENT, customer.customerStatus());
    }

    @Test
    void testWithAddressComponents_ShouldCreateValidAddress() {
        Customer customer = builder
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .withRepresentative(validRepresentative)
                .build();

        assertNotNull(customer);
    }

    @Test
    void testWithAddress_ShouldUseProvidedAddress() {
        Address address = new Address("Test Street", "Test City", "1234-567", "Test Country");

        Customer customer = builder
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress(address)
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .withRepresentative(validRepresentative)
                .build();

        assertNotNull(customer);
    }

    @Test
    void testWithEmail_WithStringParameter_ShouldCreateValidEmail() {
        Customer customer = builder
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .withRepresentative(validRepresentative)
                .build();

        assertNotNull(customer);
    }

    @Test
    void testWithEmail_WithEmailObject_ShouldUseProvidedEmail() {
        Email email = new Email("company@test.com");

        Customer customer = builder
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail(email)
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .withRepresentative(validRepresentative)
                .build();

        assertNotNull(customer);
    }

    @Test
    void testWithPhone_WithStringParameter_ShouldCreateValidPhone() {
        Customer customer = builder
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .withRepresentative(validRepresentative)
                .build();

        assertNotNull(customer);
    }

    @Test
    void testWithPhone_WithPhoneObject_ShouldUseProvidedPhone() {
        Phone phone = new Phone("+351987654321");

        Customer customer = builder
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone(phone)
                .withCustomerType(CustomerType.REGULAR)
                .withRepresentative(validRepresentative)
                .build();

        assertNotNull(customer);
    }

    @Test
    void testWithVAT_WithStringParameter_ShouldCreateValidVAT() {
        Customer customer = builder
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .withRepresentative(validRepresentative)
                .build();

        assertEquals("PT123456789", customer.identity().toString());
    }

    @Test
    void testWithVAT_WithVATObject_ShouldUseProvidedVAT() {
        VAT vat = new VAT("PT123456789");

        Customer customer = builder
                .withVAT(vat)
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .withRepresentative(validRepresentative)
                .build();

        assertEquals(vat, customer.identity());
    }

    @Test
    void testWithMultipleRepresentatives_ShouldAddAllToCustomer() {
        Representative rep1 = new Representative(
                new NIF("123456781"), "Rep 1",
                new Email("rep1@example.com"),
                new Phone("+351111111111"),
                "Position 1", mockSystemUser);

        Representative rep2 = new Representative(
                new NIF("123456782"), "Rep 2",
                new Email("rep2@example.com"),
                new Phone("+351222222222"),
                "Position 2", mockSystemUser);

        Representative rep3 = new Representative(
                new NIF("123456783"), "Rep 3",
                new Email("rep3@example.com"),
                new Phone("+351333333333"),
                "Position 3", mockSystemUser);

        Customer customer = builder
                .withVAT("PT123456789")
                .withName("Test Company")
                .withAddress("Test Street", "Test City", "1234-567", "Test Country")
                .withEmail("company@test.com")
                .withPhone("+351987654321")
                .withCustomerType(CustomerType.REGULAR)
                .withRepresentative(rep1)
                .withRepresentative(rep2)
                .withRepresentative(rep3)
                .build();

        assertEquals(3, customer.representatives().size());
        assertTrue(customer.representatives().contains(rep1));
        assertTrue(customer.representatives().contains(rep2));
        assertTrue(customer.representatives().contains(rep3));
    }
} 