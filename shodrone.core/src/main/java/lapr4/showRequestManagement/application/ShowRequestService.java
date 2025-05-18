package lapr4.showRequestManagement.application;

import jakarta.transaction.Transactional;
import lapr4.customermanagement.domain.VAT;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.usermanagement.domain.Roles;
import lapr4.showRequestManagement.repositories.ShowRequestRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.showRequestManagement.domain.ShowRequest;
import lapr4.showRequestManagement.domain.ShowRequestId;

import java.util.Optional;

public class ShowRequestService {

    private final AuthorizationService authz;
    private final ShowRequestRepository repo;

    // ✅ Construtor com injeção para testes e modularidade
    public ShowRequestService(AuthorizationService authz, ShowRequestRepository repo) {
        this.authz = authz;
        this.repo = repo;
    }

    // ✅ Construtor sem argumentos para compatibilidade com código atual
    public ShowRequestService() {
        this(AuthzRegistry.authorizationService(), PersistenceContext.repositories().showRequests());
    }

    @Transactional
    public ShowRequest registerShowRequest(final ShowRequest request) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
        return repo.save(request);
    }

    public Optional<ShowRequest> findById(final ShowRequestId id) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
        return repo.ofIdentity(id);
    }

    public Iterable<ShowRequest> findAll() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
        return repo.findAll();
    }

    public Iterable<ShowRequest> findByClientVAT(String vatStr) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
        return repo.findByClientVAT(vatStr);
    }

    public Optional<ShowRequest> findByVATAndId(VAT vat, ShowRequestId id) {
        return repo.findByVATAndId(vat, id);
    }

    @Transactional
    public void updateShowRequest(VAT vat, ShowRequestId id, int numDrones, double duration,
                                  String description, String date, String status) {

        ShowRequest request = findByVATAndId(vat, id)
                .orElseThrow(() -> new IllegalArgumentException("ShowRequest not found"));

        if ("ShowProposalDone".equalsIgnoreCase(request.getStatus())) {
            throw new IllegalStateException("Cannot edit ShowRequest with status ShowProposalDone.");
        }

        if (numDrones != -1) request.setNumDrones(numDrones);
        if (duration != -1) request.setDuration(duration);
        if (!description.isBlank()) request.setShowDescription(description);
        if (!date.isBlank()) request.setDate(date);
        if (!status.isBlank()) request.setStatus(status);

        repo.save(request);
    }
}
