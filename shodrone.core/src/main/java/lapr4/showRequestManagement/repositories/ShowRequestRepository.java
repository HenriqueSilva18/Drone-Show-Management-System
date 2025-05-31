package lapr4.showRequestManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.showRequestManagement.domain.ShowRequest;
import lapr4.showRequestManagement.domain.ShowRequestId;
import lapr4.customermanagement.domain.VAT;

import java.util.Optional;

public interface ShowRequestRepository extends DomainRepository<ShowRequestId, ShowRequest> {
    Iterable<ShowRequest> findByClientVAT(String vat);

    Optional<ShowRequest> findByVATAndId(VAT vat, ShowRequestId id);

    Optional<ShowRequest> findById(int showRequestId);

    /**
     * Returns all show requests in the system
     * @return all show requests
     */
    Iterable<ShowRequest> findAll();

    // Podes adicionar aqui métodos específicos se necessário, por exemplo:
    // Iterable<ShowRequest> findByCustomerVAT(VAT vat);
}
