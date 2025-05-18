package lapr4.showRequestManagement.application;

import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.VAT;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.showRequestManagement.domain.ShowRequest;
import lapr4.showRequestManagement.domain.ShowRequestId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegShowRequestControllerTest {

    @Mock
    private ShowRequestService mockService;

    @Mock
    private CustomerRepository mockCustomerRepository;

    private RegShowRequestController controller;

    private final String validVAT = "PT123456789"; // ✅ VAT válido para não dar erro
    private final int requestId = 1;
    private final String date = "2025-05-18";
    private final String description = "Drone show test";
    private final double duration = 15.0;
    private final int numDrones = 3;

    private Customer mockCustomer;

    @BeforeEach
    void setUp() {
        mockCustomer = mock(Customer.class);
        controller = new RegShowRequestController(mockService, mockCustomerRepository);
    }

    @Test
    void testRegisterShowRequestSuccess() {
        // Arrange
        when(mockCustomerRepository.findByVAT(new VAT(validVAT))).thenReturn(Optional.of(mockCustomer));
        ShowRequest expectedRequest = mock(ShowRequest.class);
        when(mockService.registerShowRequest(any(ShowRequest.class))).thenReturn(expectedRequest);

        // Act
        ShowRequest result = controller.registerShowRequest(numDrones, duration, description, requestId, date, validVAT);

        // Assert
        assertEquals(expectedRequest, result);
        verify(mockService).registerShowRequest(any(ShowRequest.class));
    }

    @Test
    void testRegisterShowRequestThrowsWhenNoCustomer() {
        // Arrange
        when(mockCustomerRepository.findByVAT(new VAT(validVAT))).thenReturn(Optional.empty());

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                controller.registerShowRequest(numDrones, duration, description, requestId, date, validVAT));

        assertTrue(exception.getMessage().contains("No customer found with VAT"));
    }

    @Test
    void testFindShowRequestsByVATDelegatesToService() {
        // Arrange
        when(mockService.findByClientVAT(validVAT)).thenReturn(Collections.emptyList());

        // Act
        Iterable<ShowRequest> result = controller.findShowRequestsByVAT(validVAT);

        // Assert
        assertNotNull(result);
        verify(mockService).findByClientVAT(validVAT);
    }

    @Test
    void testUpdateShowRequestDelegatesToService() {
        // Arrange
        String newDescription = "Updated";
        String newDate = "2025-06-01";
        String status = "CONFIRMED";

        // Act
        controller.updateShowRequest(validVAT, requestId, numDrones, duration, newDescription, newDate, status);

        // Assert
        verify(mockService).updateShowRequest(
                eq(new VAT(validVAT)),
                eq(new ShowRequestId(requestId)),
                eq(numDrones),
                eq(duration),
                eq(newDescription),
                eq(newDate),
                eq(status));
    }

    @Test
    void testFindShowRequestByVATAndIdReturnsShowRequest() {
        // Arrange
        ShowRequest mockRequest = mock(ShowRequest.class);
        when(mockService.findByVATAndId(new VAT(validVAT), new ShowRequestId(requestId))).thenReturn(Optional.of(mockRequest));

        // Act
        ShowRequest result = controller.findShowRequestByVATAndId(validVAT, requestId);

        // Assert
        assertEquals(mockRequest, result);
    }

    @Test
    void testFindShowRequestByVATAndIdThrowsIfNotFound() {
        // Arrange
        when(mockService.findByVATAndId(new VAT(validVAT), new ShowRequestId(requestId))).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                controller.findShowRequestByVATAndId(validVAT, requestId));
    }
}
