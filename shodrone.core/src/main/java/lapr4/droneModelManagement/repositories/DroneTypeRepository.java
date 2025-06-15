package lapr4.droneModelManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.droneModelManagement.domain.DroneType;

import java.util.Optional;

public interface DroneTypeRepository extends DomainRepository<String, DroneType> {

    /**
     * Finds a DroneType by its name.
     *
     * @param name the name of the DroneType
     * @return an Optional containing the DroneType if found, or empty if not found
     */
    Optional<DroneType> findByName(String name);

    /**
     * Retrieves all DroneTypes.
     *
     * @return an iterable collection of all DroneTypes
     */
    Iterable<DroneType> findAll();
}
