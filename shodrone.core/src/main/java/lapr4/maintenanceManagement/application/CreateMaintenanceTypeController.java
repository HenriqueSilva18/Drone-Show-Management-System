package lapr4.maintenanceManagement.application;

import jakarta.transaction.Transactional;
import lapr4.maintenanceManagement.domain.MaintenanceType;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.maintenanceManagement.repositories.MaintenanceTypeRepository;
import lapr4.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class CreateMaintenanceTypeController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final MaintenanceTypeRepository repo = PersistenceContext.repositories().maintenanceTypes();

    @Transactional
    public MaintenanceType create(String name, String description) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR);

        if (repo.existsByNameIgnoreCase(name)) {
            throw new IllegalArgumentException("Tipo de manutenção já existe.");
        }

        MaintenanceType type = new MaintenanceType(name, description);
        return repo.save(type);
    }
}
