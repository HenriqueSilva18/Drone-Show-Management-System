package lapr4.showProposalManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import lapr4.showProposalManagement.domain.ShowProposal;

import java.util.List;
import java.util.Optional;

public interface ShowProposalRepository extends DomainRepository<Integer, ShowProposal> {
    
    Optional<ShowProposal> findByProposalNumber(int proposalNumber);
    
    Iterable<ShowProposal> findByStatus(String status);
    
    List<ShowProposal> findAll();
}
