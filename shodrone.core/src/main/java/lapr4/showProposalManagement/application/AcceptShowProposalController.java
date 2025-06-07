package lapr4.showProposalManagement.application;

import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showProposalManagement.domain.ShowProposalStatus;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;

import java.util.Optional;

public class AcceptShowProposalController {

    private final ShowProposalRepository repo = PersistenceContext.repositories().showProposals();

    public Optional<ShowProposal> findNonAcceptedProposalByNumber(int proposalNumber) {
        return repo.findByProposalNumber(proposalNumber)
                .filter(p -> p.status() != ShowProposalStatus.ACCEPTED);
    }

    public void acceptProposal(int proposalNumber) {
        ShowProposal proposal = repo.findByProposalNumber(proposalNumber)
                .orElseThrow(() -> new IllegalArgumentException("Proposal not found"));

        proposal.changeProposalStatus(ShowProposalStatus.ACCEPTED);
        repo.save(proposal);
    }

    public void rejectProposal(int proposalNumber, String feedback) {
        ShowProposal proposal = repo.findByProposalNumber(proposalNumber)
                .orElseThrow(() -> new IllegalArgumentException("Proposal not found"));

        proposal.changeProposalStatus(ShowProposalStatus.REJECTED);

        repo.save(proposal);
    }
}
