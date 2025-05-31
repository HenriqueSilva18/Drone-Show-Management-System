package lapr4.persistence.impl.jpa;

import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.TypedQuery;
import lapr4.customermanagement.domain.VAT;
import lapr4.showRequestManagement.domain.ShowRequest;
import lapr4.showRequestManagement.domain.ShowRequestId;
import lapr4.showRequestManagement.repositories.ShowRequestRepository;
import eapli.framework.domain.repositories.TransactionalContext;

import java.util.Optional;

public class JpaShowRequestRepository
        extends JpaAutoTxRepository<ShowRequest, ShowRequestId, ShowRequestId>
        implements ShowRequestRepository {


    public JpaShowRequestRepository(String persistenceUnitName) {
        super(persistenceUnitName, "showRequestId");
    }

    public JpaShowRequestRepository(TransactionalContext tx) {
        super(tx, "showRequestId");
    }

    @Override
    public Optional<ShowRequest> findById(int showRequestId) {
        final TypedQuery<ShowRequest> query = entityManager().createQuery(
                "SELECT s FROM ShowRequest s WHERE s.showRequestId.value = :id", ShowRequest.class);
        query.setParameter("id", showRequestId);
        return query.getResultStream().findFirst();
    }

    @Override
    public Iterable<ShowRequest> findByClientVAT(String vat) {
        final TypedQuery<ShowRequest> query = entityManager().createQuery(
                "SELECT s FROM ShowRequest s WHERE s.clientVAT.number = :vat ORDER BY s.showRequestId.value", ShowRequest.class);
        query.setParameter("vat", vat);
        return query.getResultList();
    }

    @Override
    public Optional<ShowRequest> findByVATAndId(VAT vat, ShowRequestId id) {
        final TypedQuery<ShowRequest> query = entityManager().createQuery(
                "SELECT s FROM ShowRequest s WHERE s.clientVAT = :vat AND s.showRequestId.value = :id", ShowRequest.class);
        query.setParameter("vat", vat);
        query.setParameter("id", id.value());
        return query.getResultStream().findFirst();
    }
}
