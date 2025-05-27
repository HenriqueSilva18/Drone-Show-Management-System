package lapr4.showPrososalManagement.domain;

import lapr4.showRequestManagement.domain.ShowRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShowProposalTest {

    private ShowRequest showRequest;
    private ShowProposal proposal;

    @BeforeEach
    void setUp() {
        showRequest = mock(ShowRequest.class);
        proposal = new ShowProposal(showRequest, 5, ApprovalStatus.PENDENT);
    }

    @Test
    void proposalId() {
        assertEquals(0, proposal.proposalId()); // Not set until persisted
    }

    @Test
    void showRequest() {
        assertEquals(showRequest, proposal.showRequest());
    }

    @Test
    void totalDrones() {
        assertEquals(5, proposal.totalDrones());
    }

    @Test
    void approvalStatus() {
        assertEquals(ApprovalStatus.PENDENT, proposal.approvalStatus());
    }

    @Test
    void setApprovalStatus() {
        proposal.setApprovalStatus(ApprovalStatus.ACCEPTED);
        assertEquals(ApprovalStatus.ACCEPTED, proposal.approvalStatus());
    }

    @Test
    void identity() {
        assertEquals(proposal.proposalId(), proposal.identity());
    }

    @Test
    void sameAs() {
        ShowProposal other = new ShowProposal(showRequest, 5, ApprovalStatus.PENDENT);
        assertTrue(proposal.sameAs(other)); // Both have id 0, so they are considered the same
        assertTrue(proposal.sameAs(proposal));
    }

    @Test
    void testEquals() {
        ShowProposal other = new ShowProposal(showRequest, 5, ApprovalStatus.PENDENT);
        assertEquals(proposal, other); // Both have id 0, so they are considered equal
        assertEquals(proposal, proposal);
    }

    @Test
    void testHashCode() {
        assertEquals(Integer.hashCode(proposal.proposalId()), proposal.hashCode());
    }
}