package lapr4.droneModelManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.droneModelManagement.domain.DroneModel;

import java.util.Optional;

public interface DroneModelRepository extends DomainRepository<Long, DroneModel> {

    // Métodos específicos se precisares, como:
    // Optional<DroneModel> findByName(String name);
}
