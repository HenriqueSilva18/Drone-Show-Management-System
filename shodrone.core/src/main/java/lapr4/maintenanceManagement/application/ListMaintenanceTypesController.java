package lapr4.maintenanceManagement.application;

import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.maintenanceManagement.domain.MaintenanceType;
import lapr4.maintenanceManagement.repositories.MaintenanceTypeRepository;
import lapr4.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ListMaintenanceTypesController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final MaintenanceTypeRepository repo = PersistenceContext.repositories().maintenanceTypes();

    public Iterable<MaintenanceType> listAll() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        return repo.findAll();
    }

    public MaintenanceType findById(Long id) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tipo de manutenção não encontrado com ID: " + id));
    }
}
