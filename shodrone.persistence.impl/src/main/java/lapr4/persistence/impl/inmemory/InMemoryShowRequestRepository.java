package lapr4.persistence.impl.inmemory;

import lapr4.showRequestManagement.domain.ShowRequest;
import lapr4.showRequestManagement.domain.ShowRequestId;
import lapr4.showRequestManagement.repositories.ShowRequestRepository;
import lapr4.customermanagement.domain.VAT;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryShowRequestRepository implements ShowRequestRepository {

    private final List<ShowRequest> showRequests;

    public InMemoryShowRequestRepository() {
        this.showRequests = new ArrayList<>();
    }

    @Override
    public Optional<ShowRequest> ofIdentity(ShowRequestId id) {
        return showRequests.stream()
                .filter(showRequest -> showRequest.identity().equals(id))
                .findFirst();
    }

    @Override
    public List<ShowRequest> findAll() {
        return new ArrayList<>(showRequests);
    }

    @Override
    public ShowRequest save(ShowRequest entity) {
        showRequests.removeIf(existing -> existing.identity().equals(entity.identity()));
        showRequests.add(entity);
        return entity;
    }

    @Override
    public Optional<ShowRequest> findByVATAndId(VAT vat, ShowRequestId id) {
        return showRequests.stream()
                .filter(showRequest -> showRequest.getClientVAT().equals(vat) && showRequest.identity().equals(id))
                .findFirst();
    }

    @Override
    public List<ShowRequest> findByClientVAT(String vatStr) {
        return showRequests.stream()
                .filter(showRequest -> showRequest.getClientVAT().toString().equals(vatStr))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(ShowRequest entity) {
        showRequests.remove(entity);
    }

    @Override
    public void deleteOfIdentity(ShowRequestId id) {
        showRequests.removeIf(showRequest -> showRequest.identity().equals(id));
    }

    // Implementação do método count() exigido pela interface DomainRepository
    @Override
    public long count() {
        return showRequests.size();
    }
}
