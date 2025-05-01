package lapr4.showRequestManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.showRequestManagement.domain.ShowRequest;
import lapr4.showRequestManagement.domain.ShowRequestId;
import lapr4.customermanagement.domain.VAT;
import lapr4.showRequestManagement.domain.ShowRequestId;

import java.util.Optional;

public interface ShowRequestRepository extends DomainRepository<ShowRequestId, ShowRequest> {
    Iterable<ShowRequest> findByClientVAT(String vat);

    Optional<ShowRequest> findByVATAndId(VAT vat, ShowRequestId id);

    // Podes adicionar aqui métodos específicos se necessário, por exemplo:
    // Iterable<ShowRequest> findByCustomerVAT(VAT vat);
}
