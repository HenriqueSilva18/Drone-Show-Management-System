package lapr4.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.showProposalManagement.domain.ProposalTemplate;
import lapr4.showProposalManagement.repositories.ProposalTemplateRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class InMemoryProposalTemplateRepository extends InMemoryDomainRepository<ProposalTemplate, String>
        implements ProposalTemplateRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public List<ProposalTemplate> findAll() {
        return StreamSupport.stream(super.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
