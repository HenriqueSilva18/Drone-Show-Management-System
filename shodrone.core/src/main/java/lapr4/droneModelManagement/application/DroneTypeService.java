package lapr4.droneModelManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.droneModelManagement.repositories.DroneTypeRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.usermanagement.domain.Roles;

import java.util.Optional;

public class DroneTypeService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final DroneTypeRepository repo = PersistenceContext.repositories().droneTypes();

    public DroneType registerDroneType(DroneType type) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        return repo.save(type);
    }

    public Iterable<DroneType> findAll() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        return repo.findAll();
    }

    public Optional<DroneType> findByName(String name) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        return repo.findByName(name);
    }

    public Optional<DroneType> findById(Long identity) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        if (identity == null) {
            throw new IllegalArgumentException("Identity cannot be null");
        }
        return repo.findById(identity);
    }

    public DroneType updateDescription(DroneType type) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        if (type == null || type.getDescription() == null || type.getDescription().isEmpty()) {
            throw new IllegalArgumentException("DroneType and its description must not be null or empty");
        }
        return repo.save(type);
    }
}
