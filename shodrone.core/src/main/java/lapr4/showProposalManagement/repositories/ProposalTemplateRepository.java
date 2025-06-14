package lapr4.showProposalManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.showProposalManagement.domain.ProposalTemplate;

import java.util.List;

public interface ProposalTemplateRepository extends DomainRepository<String, ProposalTemplate> {

    List<ProposalTemplate> findAll();
}
