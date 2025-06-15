package lapr4.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.showProposalManagement.domain.ProposalTemplate;
import lapr4.showProposalManagement.repositories.ProposalTemplateRepository;

import java.util.List;

public class JpaProposalTemplateRepository extends JpaAutoTxRepository<ProposalTemplate, String, String>
        implements ProposalTemplateRepository {

    public JpaProposalTemplateRepository(final TransactionalContext autoTx) {
        super(autoTx, "name");
    }

    public JpaProposalTemplateRepository(final String pun) {
        super(pun, "name");
    }

    @Override
    public List<ProposalTemplate> findAll() {
        return this.createQuery("SELECT e FROM ProposalTemplate e", ProposalTemplate.class).getResultList();
    }

    @Override
    public ProposalTemplate findByName(String name) {
        return this.createQuery("SELECT e FROM ProposalTemplate e WHERE e.name = :name", ProposalTemplate.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
