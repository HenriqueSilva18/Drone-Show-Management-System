package lapr4.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;

import java.util.List;
import java.util.Optional;

public class JpaShowProposalRepository extends JpaAutoTxRepository<ShowProposal, Integer, Integer>
        implements ShowProposalRepository {

    public JpaShowProposalRepository(final String puname) {
        super(puname, "proposalNumber");
    }

    public JpaShowProposalRepository(TransactionalContext tx) {
        super(tx, "proposalNumber");
    }

    @Override
    public Optional<ShowProposal> findByProposalNumber(int proposalNumber) {
        final var query = entityManager().createQuery(
                "SELECT p FROM ShowProposal p WHERE p.proposalNumber = :proposalNumber",
                ShowProposal.class);
        query.setParameter("proposalNumber", proposalNumber);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public Iterable<ShowProposal> findByStatus(String status) {
        final var query = entityManager().createQuery(
                "SELECT p FROM ShowProposal p WHERE p.proposalStatus = :status",
                ShowProposal.class);
        query.setParameter("status", lapr4.showProposalManagement.domain.ProposalStatus.valueOf(status));
        return query.getResultList();
    }

    @Override
    public List<ShowProposal> findAll() {
        final var query = entityManager().createQuery(
                "SELECT p FROM ShowProposal p",
                ShowProposal.class);
        return query.getResultList();
    }
} 