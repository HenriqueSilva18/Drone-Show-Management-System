package lapr4.showProposalManagement.application;

import eapli.framework.application.ApplicationService;
import eapli.framework.domain.repositories.IntegrityViolationException;
import jakarta.transaction.Transactional;
import lapr4.showProposalManagement.domain.ProposalStatus;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showRequestManagement.domain.ShowRequest;
import lapr4.showRequestManagement.repositories.ShowRequestRepository;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import lapr4.infrastructure.persistence.PersistenceContext;

import java.util.Optional;

@ApplicationService
public class CreateShowProposalController {
    private final ShowRequestRepository showRequestRepository;
    private final ShowProposalRepository showProposalRepository;

    public CreateShowProposalController() {
        this.showRequestRepository = PersistenceContext.repositories().showRequests();
        this.showProposalRepository = PersistenceContext.repositories().showProposals();
    }

    public Iterable<ShowRequest> listAvailableShowRequests() {
        return showRequestRepository.findAll();
    }

    public String formatShowRequestList() {
        StringBuilder sb = new StringBuilder();
        sb.append("Available Show Requests:\n");
        Iterable<ShowRequest> requests = listAvailableShowRequests();
        int count = 1;
        for (ShowRequest request : requests) {
            sb.append(String.format("%d. Request ID: %s\n", 
                count++, 
                request.identity().value()));
        }
        return sb.toString();
    }

    public boolean validateTotalDrones(int totalDrones) {
        return totalDrones > 0;
    }

    @Transactional
    public ShowProposal createShowProposal(ShowRequest showRequest, int totalNumDrones) 
            throws IntegrityViolationException {
        
        if (showRequest == null) {
            throw new IllegalArgumentException("Show request cannot be null");
        }

        if (!validateTotalDrones(totalNumDrones)) {
            throw new IllegalArgumentException("Total number of drones must be greater than 0");
        }

        // Create new proposal with CREATED status
        ShowProposal showProposal = new ShowProposal(showRequest, totalNumDrones, ProposalStatus.CREATED);
        
        return showProposalRepository.save(showProposal);
    }

    public Optional<ShowRequest> getShowRequestById(int showRequestId) {
        return showRequestRepository.findById(showRequestId);
    }
}
