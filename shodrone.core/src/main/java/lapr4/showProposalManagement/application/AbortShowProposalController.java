package lapr4.showProposalManagement.application;

import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showProposalManagement.domain.ShowProposalStatus;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;

import java.util.Objects;
import java.util.Optional;

public class AbortShowProposalController {

    private final ShowProposalRepository repo;

    // Production constructor
    public AbortShowProposalController() {
        this(PersistenceContext.repositories().showProposals());
    }

    // Test constructor (mock-friendly)
    public AbortShowProposalController(ShowProposalRepository repo) {
        this.repo = repo;
    }

    public Iterable<ShowProposalDTO> findAcceptedProposalByCustomer() {
        return repo.findAllDTO().stream()
                .filter(proposal -> Objects.equals(proposal.status(), "ACCEPTED"))
                .toList();
    }

    public void abortProposal(ShowProposalDTO proposalDTO) {
        ShowProposal proposal = repo.findByProposalNumber(proposalDTO.number)
                .orElseThrow(() -> new IllegalArgumentException("Proposal not found"));

        if (proposal.status() == ShowProposalStatus.ABORTED) {
            throw new IllegalStateException("Proposal is already aborted.");
        }

        proposal.changeProposalStatus(ShowProposalStatus.ABORTED);
        repo.save(proposal);
    }

    public Optional<ShowProposal> findNonAcceptedProposalByNumber(int proposalNumber) {
        return repo.findByProposalNumber(proposalNumber)
                .filter(proposal -> proposal.status() != ShowProposalStatus.ACCEPTED ||
                        proposal.status() != ShowProposalStatus.SCHEDULED);
    }

}
