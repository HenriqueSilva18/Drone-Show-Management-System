package lapr4.persistence.impl.inmemory;

import lapr4.droneModelManagement.domain.DroneType;
import lapr4.droneModelManagement.repositories.DroneTypeRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryDroneTypeRepository implements DroneTypeRepository {

    private final Set<DroneType> droneTypes = new HashSet<>();

    @Override
    public DroneType save(DroneType droneType) {
        droneTypes.removeIf(d -> d.identity().equals(droneType.identity()));
        droneTypes.add(droneType);
        return droneType;
    }

    @Override
    public Optional<DroneType> findByName(String name) {
        return droneTypes.stream()
                .filter(d -> d.name().equals(name))
                .findFirst();
    }


    @Override
    public Iterable<DroneType> findAll() {
        return new ArrayList<>(droneTypes);
    }

    @Override
    public Optional<DroneType> ofIdentity(String id) {
        return droneTypes.stream()
                .filter(droneType -> droneType.identity().equals(id))
                .findFirst();
    }

    @Override
    public void delete(DroneType entity) {
        droneTypes.remove(entity);

    }

    @Override
    public void deleteOfIdentity(String entityId) {
        droneTypes.removeIf(droneType -> droneType.identity().equals(entityId));
    }



    @Override
    public long count() {
        return droneTypes.size();
    }
}
