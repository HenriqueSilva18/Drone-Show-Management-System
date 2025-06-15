package lapr4.showProposalManagement.domain;

import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.VAT;
import lapr4.showRequestManagement.domain.ShowRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShowProposalTest {
    // Mocks for dependencies
    private ShowRequest mockShowRequest;
    private ProposalTemplate mockTemplate;
    private Customer mockCustomer;

    // Valid test data
    private Coordinates validCoordinates;
    private LocalDateTime validEventDateTime;
    private int validEventDuration;
    private int validTotalNumDrones;

    // The subject under test
    private ShowProposal subject;

    @BeforeEach
    void setUp() {
        // Mocking dependencies
        mockShowRequest = mock(ShowRequest.class);
        mockTemplate = mock(ProposalTemplate.class);
        mockCustomer = mock(Customer.class);

        // Setting up mock behavior
        VAT vat = new VAT("PT508250917");
        when(mockShowRequest.customer()).thenReturn(mockCustomer);
        when(mockCustomer.identity()).thenReturn(vat);

        // Initializing valid data for tests
        validCoordinates = new Coordinates(41.14961, -8.61099);
        validEventDateTime = LocalDateTime.now().plusDays(10);
        validEventDuration = 60;
        validTotalNumDrones = 100;

        // Creating a new instance of ShowProposal for each test
        subject = new ShowProposal(mockShowRequest, validTotalNumDrones, validCoordinates, validEventDateTime, validEventDuration, mockTemplate);
    }

    @Test
    void ensureCanBuildValidShowProposal() {
        assertNotNull(subject);
    }

    @Test
    void ensureMustHaveShowRequest() {
        assertThrows(IllegalArgumentException.class, () ->
                new ShowProposal(null, validTotalNumDrones, validCoordinates, validEventDateTime, validEventDuration, mockTemplate)
        );
    }

    @Test
    void ensureMustHaveProposalTemplate() {
        assertThrows(IllegalArgumentException.class, () ->
                new ShowProposal(mockShowRequest, validTotalNumDrones, validCoordinates, validEventDateTime, validEventDuration, null)
        );
    }

    @Test
    void ensureMustHaveEventDate() {
        assertThrows(IllegalArgumentException.class, () ->
                new ShowProposal(mockShowRequest, validTotalNumDrones, validCoordinates, null, validEventDuration, mockTemplate)
        );
    }

    @Test
    void ensureTotalNumDronesMustBePositive() {
        assertThrows(IllegalArgumentException.class, () ->
                new ShowProposal(mockShowRequest, 0, validCoordinates, validEventDateTime, validEventDuration, mockTemplate)
        );
        assertThrows(IllegalArgumentException.class, () ->
                new ShowProposal(mockShowRequest, -10, validCoordinates, validEventDateTime, validEventDuration, mockTemplate)
        );
    }

    @Test
    void ensureStatusIsCREATED() {
        assertEquals(ShowProposalStatus.CREATED, subject.status());
    }

    @Test
    void ensureCanChangeVideo() {
        String videoLink = "http://shodrone.com/video.mp4";
        subject.changeVideoTo(videoLink);
        assertEquals(videoLink, subject.simulationVideoLink());
    }

    @Test
    void ensureCannotChangeVideoToNull() {
        assertThrows(IllegalArgumentException.class, () -> subject.changeVideoTo(null));
    }

    @Test
    void ensureCannotChangeVideoToEmpty() {
        assertThrows(IllegalArgumentException.class, () -> subject.changeVideoTo(""));
    }

    @Test
    void ensureCanChangeProposalStatus() {
        final ShowProposalStatus newStatus = ShowProposalStatus.PENDENT;
        subject.changeProposalStatus(newStatus);
        assertEquals(newStatus, subject.status());
    }

    @Test
    void ensureCannotChangeProposalStatusToNull() {
        assertThrows(IllegalArgumentException.class, () -> subject.changeProposalStatus(null));
    }

    @Test
    void ensureCanChangeSimulationStatus() {
        subject.changeSimulationStatus(SimulationStatus.PASSED);
        assertEquals(SimulationStatus.PASSED, subject.simulationStatus());
    }

    @Test
    void ensureCannotChangeSimulationStatusToNull() {
        assertThrows(IllegalArgumentException.class, () -> subject.changeSimulationStatus(null));
    }

    @Test
    void ensureCanChangeProposalText() {
        String text = "This is a new proposal text.";
        subject.changeProposalText(text);
    }

    @Test
    void ensureCannotChangeProposalTextToEmpty() {
        assertThrows(IllegalArgumentException.class, () -> subject.changeProposalText(""));
    }

    @Test
    void ensureCannotChangeProposalTextToNull() {
        assertThrows(IllegalArgumentException.class, () -> subject.changeProposalText(null));
    }

    @Test
    void identity() {
        assertEquals(0, subject.identity());
    }
}