package lapr4.maintenanceManagement.repositories;

import lapr4.maintenanceManagement.domain.MaintenanceType;

import java.util.List;
import java.util.Optional;

public interface MaintenanceTypeRepository {
    boolean existsByNameIgnoreCase(String name);
    Optional<MaintenanceType> findByNameIgnoreCase(String name);
    Optional<MaintenanceType> findById(Long id);
    MaintenanceType save(MaintenanceType type);
    List<MaintenanceType> findAll();
    void delete(MaintenanceType entity);
    void deleteById(Long id);
    long count();
}
