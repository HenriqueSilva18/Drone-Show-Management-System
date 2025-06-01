package lapr4.figureManagement.application;

import jakarta.transaction.Transactional;
import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.repositories.FigureRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.figureManagement.domain.FigureCategory;
import lapr4.customermanagement.domain.VAT;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

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
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR, Roles.CRM_MANAGER);
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

    @Transactional
    public Figure registerFigure(String description, Set<String> keywords, boolean exclusive, VAT clientVAT, FigureCategory category, String DSLCode, String DSLVersion) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.SHOW_DESIGNER);

        if (clientVAT == null) {
            throw new IllegalArgumentException("A figure must have a client VAT associated.");
        }

        Figure figure = new Figure(description, keywords, exclusive, clientVAT, category, DSLCode, DSLVersion);

        return repo.save(figure);
    }

    public Figure registerFigure(String description, boolean exclusive, VAT clientVAT, FigureCategory category, String DSLCode, String DSLVersion) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.SHOW_DESIGNER);

        if (clientVAT == null) {
            throw new IllegalArgumentException("A figure must have a client VAT associated.");
        }

        Figure figure = new Figure(description, exclusive, clientVAT, category, DSLCode, DSLVersion);

        return repo.save(figure);
    }

    @Transactional
    public Figure decommissionFigure(Figure figure) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_MANAGER);
        Figure fig = repo.ofIdentity(figure.identity())
                .orElseThrow(() -> new IllegalArgumentException("Figure not found: " + figure.identity()));

        if (!fig.isActive()) {
            throw new IllegalStateException("Figure already decommissioned: " + figure.identity());
        }

        fig.setActive(false);
        fig.setDecommissionDate(LocalDateTime.now());

        return repo.save(fig);
    }
}
