package lapr4.showProposalManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import lapr4.customermanagement.domain.VAT;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.ShowProposalDTO;

import java.util.List;
import java.util.Optional;

public interface ShowProposalRepository extends DomainRepository<Integer, ShowProposal> {
    
    Optional<ShowProposal> findByProposalNumber(int proposalNumber);
    
    Iterable<ShowProposal> findByStatus(String status);
    
    List<ShowProposal> findAll();

    List<ShowProposalDTO> findAllDTO();

    List<ShowProposal> findByCustomerVAT(VAT customerVAT);

    List<ShowProposal> findAllProposalsToSend();

    List<ShowProposalDTO> findAllProposalsToSendDTO();
}
