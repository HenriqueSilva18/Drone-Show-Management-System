package lapr4.showRequestManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.customermanagement.domain.VAT;
import lapr4.showRequestManagement.domain.ShowRequest;
import lapr4.showRequestManagement.domain.ShowRequestId;
import lapr4.showRequestManagement.repositories.ShowRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ShowRequestServiceTest {

    private ShowRequestService service;

    @Mock
    private ShowRequestRepository showRequestRepository;

    @Mock
    private AuthorizationService authorizationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new ShowRequestService(authorizationService, showRequestRepository);
    }

    @Test
    void testFindByIdDelegatesToRepository() {
        ShowRequestId id = new ShowRequestId(1);
        ShowRequest showRequest = mock(ShowRequest.class);
        when(showRequestRepository.ofIdentity(id)).thenReturn(Optional.of(showRequest));

        Optional<ShowRequest> result = service.findById(id);

        assertTrue(result.isPresent());
        assertEquals(showRequest, result.get());
        verify(showRequestRepository).ofIdentity(id);
    }

    @Test
    void testFindAllReturnsList() {
        ShowRequest mockRequest = mock(ShowRequest.class);
        Iterable<ShowRequest> iterable = List.of(mockRequest);

        when(showRequestRepository.findAll()).thenReturn(iterable);

        Iterable<ShowRequest> result = service.findAll();

        assertIterableEquals(iterable, result);
        verify(showRequestRepository).findAll();
    }

    @Test
    void testRegisterShowRequestSuccess() {
        ShowRequest request = mock(ShowRequest.class);
        when(showRequestRepository.save(request)).thenReturn(request);

        ShowRequest result = service.registerShowRequest(request);

        assertEquals(request, result);
        verify(showRequestRepository).save(request);
    }

    @Test
    void testUpdateShowRequestThrowsIfRequestNotFound() {
        ShowRequestId id = new ShowRequestId(1);
        VAT vat = new VAT("PT123456789");

        when(showRequestRepository.findByVATAndId(vat, id)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () ->
                service.updateShowRequest(vat, id, 2, 10.0, "new desc", "2025-05-19", "PENDING"));
    }

    @Test
    void testUpdateShowRequestSuccess() {
        ShowRequestId id = new ShowRequestId(1);
        VAT vat = new VAT("PT123456789");
        ShowRequest showRequest = mock(ShowRequest.class);

        when(showRequestRepository.findByVATAndId(vat, id)).thenReturn(Optional.of(showRequest));

        service.updateShowRequest(vat, id, 5, 15.0, "Updated Show", "2025-06-01", "IN_PROGRESS");

        verify(showRequest).setNumDrones(5);
        verify(showRequest).setDuration(15.0);
        verify(showRequest).setShowDescription("Updated Show");
        verify(showRequest).setDate("2025-06-01");
        verify(showRequest).setStatus("IN_PROGRESS");
        verify(showRequestRepository).save(showRequest);
    }
}
