package lapr4.droneManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.droneManagement.domain.Drone;
import lapr4.droneManagement.domain.SerialNumber;

public interface DroneRepository extends DomainRepository<SerialNumber, Drone> {

    // Exemplo de método específico se precisares futuramente:
    // Optional<Drone> findByModelName(String modelName);
}
