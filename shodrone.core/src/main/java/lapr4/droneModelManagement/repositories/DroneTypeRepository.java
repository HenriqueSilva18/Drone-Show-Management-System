package lapr4.droneModelManagement.repositories;

import lapr4.droneModelManagement.domain.DroneType;

import java.util.Optional;

public interface DroneTypeRepository {
    DroneType save(DroneType type);

    Iterable<DroneType> findAll();

    Optional<DroneType> findByName(String name);

    Optional<DroneType> findById(Long identity);
}
