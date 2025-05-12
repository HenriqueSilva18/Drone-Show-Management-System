package lapr4.figureManagement.application;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jakarta.transaction.Transactional;
import lapr4.figureManagement.domain.FigureCategory;
import lapr4.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.figureManagement.repositories.FigureCategoryRepository;
import lapr4.usermanagement.domain.Roles;


public class FigureCategoryService {

    private final FigureCategoryRepository repo;
    private final AuthorizationService authz;

    /**
     * Construtor padrão (produção)
     */


    public FigureCategoryService(FigureCategoryRepository repo, AuthorizationService authz) {
        this.repo = repo;
        this.authz = authz;
    }

    public FigureCategoryService() {
        this(PersistenceContext.repositories().figureCategories(),
                AuthzRegistry.authorizationService());
    }

    @Transactional
    public FigureCategory registerCategory(FigureCategory category) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.SHOW_DESIGNER, Roles.ADMIN);
        return repo.save(category);
    }


    @Transactional
    public FigureCategory registerCategory(String name, String description) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.SHOW_DESIGNER, Roles.ADMIN);
        FigureCategory category = new FigureCategory(name, description);
        return repo.save(category);
    }

    public Iterable<FigureCategory> findAll() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.SHOW_DESIGNER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
        return repo.findAll();
    }


    public FigureCategory updateDescription(String name, String newDescription) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.SHOW_DESIGNER, Roles.ADMIN);

        FigureCategory category = repo.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Category not found: " + name));

        category.updateDescription(newDescription);
        return repo.save(category);
    }

    public FigureCategory toggleCategory(String name) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.SHOW_DESIGNER, Roles.ADMIN);

        FigureCategory category = repo.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Category not found: " + name));

        if (category.isActive()) {
            category.deactivate();
        } else {
            category.activate();
        }

        return repo.save(category);
    }

}
