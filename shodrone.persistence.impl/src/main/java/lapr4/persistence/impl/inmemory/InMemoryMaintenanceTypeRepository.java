// InMemoryMaintenanceTypeRepository.java
package lapr4.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.maintenanceManagement.domain.MaintenanceType;
import lapr4.maintenanceManagement.repositories.MaintenanceTypeRepository;

import java.util.*;

public class InMemoryMaintenanceTypeRepository
        extends InMemoryDomainRepository<MaintenanceType, Long>
        implements MaintenanceTypeRepository {

    private final List<MaintenanceType> store = new ArrayList<>();

    static {
        InMemoryInitializer.init();
    }

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return store.stream().anyMatch(mt -> mt.name().equalsIgnoreCase(name));
    }

    @Override
    public Optional<MaintenanceType> findByNameIgnoreCase(String name) {
        return store.stream().filter(mt -> mt.name().equalsIgnoreCase(name)).findFirst();
    }

    @Override
    public Optional<MaintenanceType> findById(Long id) {
        return store.stream().filter(mt -> mt.identity().equals(id)).findFirst();
    }

    @Override
    public MaintenanceType save(MaintenanceType type) {
        store.removeIf(mt -> mt.identity().equals(type.identity()));
        store.add(type);
        return type;
    }

    @Override
    public List<MaintenanceType> findAll() {
        return new ArrayList<>(store);
    }

    @Override
    public void delete(MaintenanceType entity) {
        store.remove(entity);
    }

    @Override
    public void deleteById(Long id) {
        store.removeIf(mt -> mt.identity().equals(id));
    }

    @Override
    public long count() {
        return store.size();
    }
}
