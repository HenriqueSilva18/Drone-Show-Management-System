package lapr4.figureManagement.application;

import jakarta.transaction.Transactional;
import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.repositories.FigureRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Optional;

public class FigureService {

    private final FigureRepository repo;
    private final AuthorizationService authz;

    /**
     * Construtor padrão (produção)
     */
    public FigureService() {
        this(PersistenceContext.repositories().figures(),
                AuthzRegistry.authorizationService());
    }

    /**
     * Construtor para testes
     */
    public FigureService(FigureRepository repo, AuthorizationService authz) {
        this.repo  = repo;
        this.authz = authz;
    }
    @Transactional
    public Figure registerFigure(Figure figure) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        return repo.save(figure);
    }

    public Optional<Figure> findById(Long id) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        return repo.ofIdentity(id);
    }

    public Iterable<Figure> findAll() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        return repo.findAll();
    }

    /** US231: só figuras ativas e públicas */
    public Iterable<Figure> findActivePublic() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        return repo.findActivePublic();
    }

    /** US232: search for category and/or keyword */
    public Iterable<Figure> searchByCategoryOrKeyword(String searchTerm) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        return repo.searchByCategoryOrKeyword(searchTerm);
    }

}
