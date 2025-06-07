package lapr4.persistence.impl.inmemory;

import lapr4.droneModelManagement.domain.DroneType;
import lapr4.droneModelManagement.repositories.DroneTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryDroneTypeRepository implements DroneTypeRepository {

    private final Set<DroneType> droneTypes = new HashSet<>();


    @Override
    public DroneType save(DroneType type) {
        if (type == null) {
            throw new IllegalArgumentException("DroneType cannot be null");
        }
        droneTypes.remove(type); // Remove existing instance if present
        droneTypes.add(type); // Add the new or updated instance
        return type;
    }

    @Override
    public Iterable<DroneType> findAll() {
        return new HashSet<>(droneTypes);
    }

    @Override
    public Optional<DroneType> findByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("DroneType name cannot be null or empty");
        }

        Optional<DroneType> type = droneTypes.stream()
                .filter(droneType -> droneType.getName().equals(name))
                .findFirst();

        if (type.isEmpty()) {
            throw new IllegalArgumentException("DroneType with name '" + name + "' does not exist");
        }

        return type;
    }

    @Override
    public Optional<DroneType> findById(Long identity) {
        if (identity == null) {
            throw new IllegalArgumentException("Identity cannot be null");
        }

        Optional<DroneType> type = droneTypes.stream()
                .filter(droneType -> droneType.identity().equals(identity))
                .findFirst();

        if (type.isEmpty()) {
            throw new IllegalArgumentException("DroneType with identity '" + identity + "' does not exist");
        }

        return type;
    }
}
