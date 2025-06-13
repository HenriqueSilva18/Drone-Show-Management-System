package lapr4.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.customermanagement.domain.VAT;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.domain.ShowProposalStatus;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;

import java.util.List;
import java.util.Optional;

public class JpaShowProposalRepository extends JpaAutoTxRepository<ShowProposal, Integer, Integer>
        implements ShowProposalRepository {

    public JpaShowProposalRepository(final String puname) {
        super(puname, "number");
    }

    public JpaShowProposalRepository(TransactionalContext tx) {
        super(tx, "number");
    }

    @Override
    public Optional<ShowProposal> findByProposalNumber(int number) {
        final var query = entityManager().createQuery(
                "SELECT p FROM ShowProposal p WHERE p.number = :number",
                ShowProposal.class);
        query.setParameter("number", number);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public Iterable<ShowProposal> findByStatus(String status) {
        final var query = entityManager().createQuery(
                "SELECT p FROM ShowProposal p WHERE p.status = :status",
                ShowProposal.class);
        query.setParameter("status", ShowProposalStatus.valueOf(status));
        return query.getResultList();
    }

    @Override
    public List<ShowProposal> findAll() {
        final var query = entityManager().createQuery(
                "SELECT p FROM ShowProposal p",
                ShowProposal.class);
        return query.getResultList();
    }



    @Override
    public List<ShowProposal> findByCustomerVAT(VAT customerVAT){
        final var query = entityManager().createQuery(
                "SELECT p FROM ShowProposal p WHERE p.customer.vat = :vat", ShowProposal.class);
        return query.getResultList();
    }
} 