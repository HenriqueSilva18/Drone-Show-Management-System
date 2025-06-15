package lapr4.showProposalManagement.application;

import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.domain.ShowProposalStatus;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AcceptShowProposalControllerTest {

    private ShowProposalRepository repo;
    private AcceptShowProposalController controller;

    @BeforeEach
    void setUp() {
        repo = mock(ShowProposalRepository.class);
        controller = new AcceptShowProposalController(repo);
    }

    /*@Test
    void testFindNonAcceptedProposalByNumberReturnsProposalIfNotAccepted() {
        ShowProposal proposal = mock(ShowProposal.class);
        when(proposal.status()).thenReturn(ShowProposalStatus.PENDENT);
        when(repo.findByProposalNumber(1)).thenReturn(Optional.of(proposal));

        var result = controller.findNonAcceptedProposalByNumber(1);
        assertTrue(result.isPresent());
    }

    @Test
    void testFindNonAcceptedProposalByNumberReturnsEmptyIfAccepted() {
        ShowProposal proposal = mock(ShowProposal.class);
        when(proposal.status()).thenReturn(ShowProposalStatus.ACCEPTED);
        when(repo.findByProposalNumber(1)).thenReturn(Optional.of(proposal));

        var result = controller.findNonAcceptedProposalByNumber(1);
        assertTrue(result.isEmpty());
    }

    @Test
    void testAcceptProposalChangesStatusToAccepted() {
        ShowProposal proposal = mock(ShowProposal.class);
        when(proposal.status()).thenReturn(ShowProposalStatus.CREATED);
        when(repo.findByProposalNumber(2)).thenReturn(Optional.of(proposal));

        controller.acceptProposal(2);

        verify(proposal).changeProposalStatus(ShowProposalStatus.ACCEPTED);
        verify(repo).save(proposal);
    }

    @Test
    void testAcceptProposalThrowsIfAlreadyAccepted() {
        ShowProposal proposal = mock(ShowProposal.class);
        when(proposal.status()).thenReturn(ShowProposalStatus.ACCEPTED);
        when(repo.findByProposalNumber(3)).thenReturn(Optional.of(proposal));

        assertThrows(IllegalStateException.class, () -> controller.acceptProposal(3));
    }*/
}
