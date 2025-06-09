package lapr4.showProposalManagement.application;

import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.domain.ShowProposalStatus;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AcceptShowProposalControllerTest {

    private AcceptShowProposalController controller;
    private ShowProposalRepository mockRepo;

    @BeforeEach
    void setUp() {
        mockRepo = mock(ShowProposalRepository.class);
        controller = new AcceptShowProposalController(mockRepo);
    }

    @Test
    void testFindNonAcceptedProposalByNumberReturnsProposalIfNotAccepted() {
        ShowProposal proposal = mock(ShowProposal.class);
        when(proposal.status()).thenReturn(ShowProposalStatus.PENDENT);
        when(mockRepo.findByProposalNumber(1)).thenReturn(Optional.of(proposal));

        Optional<ShowProposal> result = controller.findNonAcceptedProposalByNumber(1);
        assertTrue(result.isPresent());
    }

    @Test
    void testFindNonAcceptedProposalByNumberReturnsEmptyIfAccepted() {
        ShowProposal proposal = mock(ShowProposal.class);
        when(proposal.status()).thenReturn(ShowProposalStatus.ACCEPTED);
        when(mockRepo.findByProposalNumber(2)).thenReturn(Optional.of(proposal));

        Optional<ShowProposal> result = controller.findNonAcceptedProposalByNumber(2);
        assertTrue(result.isEmpty());
    }

    @Test
    void testAcceptProposalChangesStatusToAccepted() {
        ShowProposal proposal = mock(ShowProposal.class);
        when(proposal.status()).thenReturn(ShowProposalStatus.PENDENT);
        when(mockRepo.findByProposalNumber(3)).thenReturn(Optional.of(proposal));

        controller.acceptProposal(3);
        verify(proposal).changeProposalStatus(ShowProposalStatus.ACCEPTED);
        verify(mockRepo).save(proposal);
    }

    @Test
    void testAcceptProposalThrowsIfAlreadyAccepted() {
        ShowProposal proposal = mock(ShowProposal.class);
        when(proposal.status()).thenReturn(ShowProposalStatus.ACCEPTED);
        when(mockRepo.findByProposalNumber(4)).thenReturn(Optional.of(proposal));

        assertThrows(IllegalStateException.class, () -> controller.acceptProposal(4));
    }

    @Test
    void testRejectProposalChangesStatusToRejected() {
        ShowProposal proposal = mock(ShowProposal.class);
        when(mockRepo.findByProposalNumber(5)).thenReturn(Optional.of(proposal));

        controller.rejectProposal(5);
        verify(proposal).changeProposalStatus(ShowProposalStatus.REJECTED);
        verify(mockRepo).save(proposal);
    }
}
