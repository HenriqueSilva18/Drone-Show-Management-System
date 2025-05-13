package lapr4.customermanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.exceptions.UnauthenticatedException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.customermanagement.domain.*;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.usermanagement.domain.Roles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    private CustomerRepository customerRepository;
    private AuthorizationService authzService;
    private CustomerService customerService;

    private Customer testCustomer;
    private VAT testVAT;
    private SystemUser mockSystemUser;

    @BeforeEach
    void setUp() {
        customerRepository = mock(CustomerRepository.class);
        authzService = mock(AuthorizationService.class);
        mockSystemUser = mock(SystemUser.class);

        testVAT = new VAT("PT123456789");
        String validName = "Test Company";
        Address validAddress = new Address("Test Street", "Test City", "1234-567", "Test Country");
        Email validEmail = new Email("company@test.com");
        Phone validPhone = new Phone("+351912345678");
        CustomerType validCustomerType = CustomerType.REGULAR;
        CustomerStatus validCustomerStatus = CustomerStatus.CREATED;

        NIF validNif = new NIF("123456789");
        Representative validRepresentative = new Representative(validNif, "John Doe",
                new Email("john.doe@example.com"),
                new Phone("+351987654321"),
                "Manager", mockSystemUser);

        List<Representative> validRepresentatives = new ArrayList<>();
        validRepresentatives.add(validRepresentative);

        testCustomer = new Customer(testVAT, validName, validAddress, validEmail,
                validPhone, validCustomerType, validCustomerStatus, validRepresentatives);

        customerService = new CustomerService(customerRepository, authzService);
    }

    @Test
    void findCustomerByVAT_WithValidVATAndAuthorizedUser_ShouldReturnCustomer() {
        when(customerRepository.findByVAT(testVAT)).thenReturn(Optional.of(testCustomer));

        Optional<Customer> result = customerService.findCustomerByVAT(testVAT);

        assertTrue(result.isPresent());
        assertEquals(testCustomer, result.get());
        verify(authzService).ensureAuthenticatedUserHasAnyOf(
                Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
    }

    @Test
    void findCustomerByVAT_WithValidStringVATAndAuthorizedUser_ShouldReturnCustomer() {
        String vatNumber = "PT123456789";
        when(customerRepository.findByVAT(vatNumber)).thenReturn(Optional.of(testCustomer));

        Optional<Customer> result = customerService.findCustomerByVAT(vatNumber);

        assertTrue(result.isPresent());
        assertEquals(testCustomer, result.get());
        verify(authzService).ensureAuthenticatedUserHasAnyOf(
                Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
    }

    @Test
    void findCustomerByVAT_WithUnauthorizedUser_ShouldThrowException() {
        doThrow(new UnauthenticatedException())
                .when(authzService)
                .ensureAuthenticatedUserHasAnyOf(any(Role.class), any(Role.class), any(Role.class));

        assertThrows(UnauthenticatedException.class, () -> customerService.findCustomerByVAT(testVAT));
    }

    @Test
    void findAllActiveCustomers_WithAuthorizedUser_ShouldReturnAllActiveCustomers() {
        List<Customer> activeCustomers = new ArrayList<>();
        activeCustomers.add(testCustomer);
        when(customerRepository.findAllActive()).thenReturn(activeCustomers);

        Iterable<Customer> result = customerService.findAllActiveCustomers();

        assertEquals(activeCustomers, result);
        verify(authzService).ensureAuthenticatedUserHasAnyOf(
                Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
    }

    @Test
    void findAllActiveCustomers_WithUnauthorizedUser_ShouldThrowException() {
        doThrow(new UnauthenticatedException())
                .when(authzService)
                .ensureAuthenticatedUserHasAnyOf(any(Role.class), any(Role.class), any(Role.class));

        assertThrows(UnauthenticatedException.class, () -> customerService.findAllActiveCustomers());
    }

    @Test
    void registerCustomer_WithValidCustomerAndAuthorizedUser_ShouldSaveAndReturnCustomer() {
        when(customerRepository.save(testCustomer)).thenReturn(testCustomer);

        Customer result = customerService.registerCustomer(testCustomer);

        assertEquals(testCustomer, result);
        verify(customerRepository).save(testCustomer);
        verify(authzService).ensureAuthenticatedUserHasAnyOf(
                Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
    }

    @Test
    void registerCustomer_WithUnauthorizedUser_ShouldThrowException() {
        doThrow(new UnauthenticatedException())
                .when(authzService)
                .ensureAuthenticatedUserHasAnyOf(any(Role.class), any(Role.class), any(Role.class));

        assertThrows(UnauthenticatedException.class, () -> customerService.registerCustomer(testCustomer));
        verify(customerRepository, never()).save(any(Customer.class));
    }

    @Test
    void getCustomerTypes_ShouldReturnAllTypes() {
        Iterable<CustomerType> types = customerService.getCustomerTypes();

        assertNotNull(types);

        Iterable<CustomerType> expectedTypes = CustomerType.asList();
        assertEquals(expectedTypes, types);
    }
} 