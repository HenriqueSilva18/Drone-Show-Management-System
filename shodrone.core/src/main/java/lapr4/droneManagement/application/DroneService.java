package lapr4.droneManagement.application;

import jakarta.transaction.Transactional;
import lapr4.droneManagement.domain.Drone;
import lapr4.droneManagement.domain.SerialNumber;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.usermanagement.domain.Roles;
import lapr4.droneManagement.repositories.DroneRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Optional;

public class DroneService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final DroneRepository repo = PersistenceContext.repositories().drones();

    @Transactional
    public Drone registerDrone(final Drone drone) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
        return repo.save(drone);
    }

    public Optional<Drone> findById(final SerialNumber id) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
        return repo.ofIdentity(id);
    }

    public Iterable<Drone> findAll() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN, Roles.CRM_COLLABORATOR);
        return repo.findAll();
    }
}

