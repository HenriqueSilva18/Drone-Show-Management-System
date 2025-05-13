package lapr4.customermanagement.application;

import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.customermanagement.domain.*;
import lapr4.usermanagement.application.AddUserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RegCustomerControllerTest {

    private RegCustomerController controller;
    private CustomerService customerService;
    private AddUserController addUserController;

    private String validVatNumber;
    private String validName;
    private Address validAddress;
    private String validEmail;
    private String validPhone;
    private CustomerType validCustomerType;
    private List<RegCustomerController.RepresentativeData> validRepresentativesData;

    @BeforeEach
    void setUp() {
        customerService = mock(CustomerService.class);
        addUserController = mock(AddUserController.class);

        validVatNumber = "PT123456789";
        validName = "Test Company";
        validAddress = new Address("Test Street", "Test City", "1234-567", "Test Country");
        validEmail = "company@test.com";
        validPhone = "+351912345678";
        validCustomerType = CustomerType.REGULAR;

        validRepresentativesData = new ArrayList<>();
        validRepresentativesData.add(new RegCustomerController.RepresentativeData(
                "John Doe", "123456789", "john.doe@example.com", "+351987654321",
                "Manager", "johndoe", "password123", "John", "Doe"
        ));

        SystemUser mockUser = mock(SystemUser.class);
        when(addUserController.addUser(
                anyString(), anyString(), anyString(), anyString(), anyString(), any()
        )).thenReturn(mockUser);

        controller = new RegCustomerController(customerService, addUserController);
    }

    @Test
    void registerCustomerWithMultipleRepresentatives_WithValidDataAndOneRepresentative_ShouldRegisterSuccessfully() {
        Customer mockCustomer = mock(Customer.class);
        when(customerService.registerCustomer(any(Customer.class))).thenReturn(mockCustomer);

        Customer result = controller.registerCustomerWithMultipleRepresentatives(
                validVatNumber, validName, validAddress, validEmail, validPhone,
                validCustomerType, validRepresentativesData
        );

        assertNotNull(result);
        assertEquals(mockCustomer, result);

        verify(addUserController).addUser(
                eq("johndoe"), eq("password123"), eq("John"), eq("Doe"),
                eq("john.doe@example.com"), any()
        );

        verify(customerService).registerCustomer(any(Customer.class));
    }

    @Test
    void registerCustomerWithMultipleRepresentatives_WithMultipleRepresentatives_ShouldRegisterAllRepresentatives() {
        validRepresentativesData.add(new RegCustomerController.RepresentativeData(
                "Jane Smith", "987654321", "jane.smith@example.com", "+351911122233",
                "Sales", "janesmith", "password456", "Jane", "Smith"
        ));

        Customer mockCustomer = mock(Customer.class);
        when(customerService.registerCustomer(any(Customer.class))).thenReturn(mockCustomer);

        Customer result = controller.registerCustomerWithMultipleRepresentatives(
                validVatNumber, validName, validAddress, validEmail, validPhone,
                validCustomerType, validRepresentativesData
        );

        assertNotNull(result);

        verify(addUserController, times(2)).addUser(
                anyString(), anyString(), anyString(), anyString(), anyString(), any()
        );

        verify(customerService, times(1)).registerCustomer(any(Customer.class));
    }

    @Test
    void registerCustomerWithMultipleRepresentatives_WithNoRepresentatives_ShouldThrowException() {
        List<RegCustomerController.RepresentativeData> emptyList = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () ->
                controller.registerCustomerWithMultipleRepresentatives(
                        validVatNumber, validName, validAddress, validEmail, validPhone,
                        validCustomerType, emptyList
                )
        );

        verifyNoInteractions(addUserController);
        verifyNoInteractions(customerService);
    }

    @Test
    void registerCustomerWithMultipleRepresentatives_WithNullRepresentativesList_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                controller.registerCustomerWithMultipleRepresentatives(
                        validVatNumber, validName, validAddress, validEmail, validPhone,
                        validCustomerType, null
                )
        );

        verifyNoInteractions(addUserController);
        verifyNoInteractions(customerService);
    }

    @Test
    void registerCustomerWithMultipleRepresentatives_WhenUserCreationFails_ShouldPropagateException() {
        when(addUserController.addUser(
                anyString(), anyString(), anyString(), anyString(), anyString(), any()
        )).thenThrow(new IllegalArgumentException("Invalid user data"));

        assertThrows(IllegalArgumentException.class, () ->
                controller.registerCustomerWithMultipleRepresentatives(
                        validVatNumber, validName, validAddress, validEmail, validPhone,
                        validCustomerType, validRepresentativesData
                )
        );

        verifyNoInteractions(customerService);
    }

    @Test
    void registerCustomerWithMultipleRepresentatives_WhenCustomerSaveFails_ShouldPropagateException() {
        when(customerService.registerCustomer(any(Customer.class)))
                .thenThrow(new IntegrityViolationException("Duplicate entry"));

        assertThrows(IntegrityViolationException.class, () ->
                controller.registerCustomerWithMultipleRepresentatives(
                        validVatNumber, validName, validAddress, validEmail, validPhone,
                        validCustomerType, validRepresentativesData
                )
        );

        verify(addUserController).addUser(
                anyString(), anyString(), anyString(), anyString(), anyString(), any()
        );
    }

    @Test
    void getCustomerTypes_ShouldDelegateToService() {
        Iterable<CustomerType> types = CustomerType.asList();
        when(customerService.getCustomerTypes()).thenReturn(types);

        Iterable<CustomerType> result = controller.getCustomerTypes();

        assertEquals(types, result);
        verify(customerService).getCustomerTypes();
    }
} 