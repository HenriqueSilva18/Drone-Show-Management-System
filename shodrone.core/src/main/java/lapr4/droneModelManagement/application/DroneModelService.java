package lapr4.droneModelManagement.application;

import jakarta.transaction.Transactional;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.usermanagement.domain.Roles;
import lapr4.droneModelManagement.repositories.DroneModelRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Optional;

public class DroneModelService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final DroneModelRepository repo = PersistenceContext.repositories().droneModels();

    @Transactional
    public DroneModel registerDroneModel(DroneModel model) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR, Roles.DRONE_TECH);
        return repo.save(model);
    }

    public Optional<DroneModel> findById(Long id) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR, Roles.DRONE_TECH);
        return repo.ofIdentity(id);
    }

    public Iterable<DroneModel> findAll() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR, Roles.DRONE_TECH);
        return repo.findAll();
    }

    @Transactional
    public DroneModel save(DroneModel model) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR, Roles.DRONE_TECH);
        return repo.save(model);
    }

}
