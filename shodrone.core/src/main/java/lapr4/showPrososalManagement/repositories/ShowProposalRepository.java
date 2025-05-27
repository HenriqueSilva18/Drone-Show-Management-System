package lapr4.showPrososalManagement.repositories;

import lapr4.showPrososalManagement.domain.ShowProposal;
import lapr4.showRequestManagement.domain.ShowRequest;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ShowProposalRepository extends DomainRepository<Integer, ShowProposal> {

    Optional<ShowProposal> findByProposalId(int proposalId);

    Iterable<ShowProposal> findByShowRequest(ShowRequest showRequest);
}
