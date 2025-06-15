package lapr4.showProposalManagement.application;

import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showProposalManagement.domain.ShowProposalStatus;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;

import java.util.Objects;
import java.util.Optional;

public class AcceptShowProposalController {

    private final ShowProposalRepository repo;

    // Production constructor
    public AcceptShowProposalController() {
        this(PersistenceContext.repositories().showProposals());
    }

    // Test constructor (mock-friendly)
    public AcceptShowProposalController(ShowProposalRepository repo) {
        this.repo = repo;
    }

    public Iterable<ShowProposalDTO> findAcceptedProposalByCustomer() {
        return repo.findAllDTO().stream()
                .filter(proposal -> Objects.equals(proposal.status(), "ACCEPTED"))
                .toList();
    }

    public void acceptProposal(int proposalNumber) {
        ShowProposal proposal = repo.findByProposalNumber(proposalNumber)
                .orElseThrow(() -> new IllegalArgumentException("Proposal not found"));

        if (proposal.status() == ShowProposalStatus.ACCEPTED) {
            throw new IllegalStateException("Proposal is already accepted.");
        }

        proposal.changeProposalStatus(ShowProposalStatus.ACCEPTED);
        repo.save(proposal);
    }

    public void scheduleProposal(ShowProposalDTO proposalDTO) {
        Optional<ShowProposal> opt = repo.findByProposalNumber(proposalDTO.number);
        if (opt.isEmpty()) {
            throw new IllegalArgumentException("Proposal not found or already ACCEPTED.");
        }

        ShowProposal proposal = opt.get();
        proposal.changeProposalStatus(ShowProposalStatus.SCHEDULED);
        repo.save(proposal);
    }

    public Optional<ShowProposal> findNonAcceptedProposalByNumber(int proposalNumber) {
        return repo.findByProposalNumber(proposalNumber)
                .filter(proposal -> proposal.status() != ShowProposalStatus.ACCEPTED ||
                                    proposal.status() != ShowProposalStatus.SCHEDULED);
    }

}
