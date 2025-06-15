package lapr4.droneModelManagement.application;

import java.util.List;
import jakarta.transaction.Transactional;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.droneModelManagement.repositories.DroneTypeRepository;
import lapr4.infrastructure.persistence.PersistenceContext;

public class DroneTypeService {

    private final DroneTypeRepository repo = PersistenceContext.repositories().droneTypes();


    @Transactional
    public DroneType registerDroneType(String name, String description) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("DroneType name cannot be null or blank");
        // Verificar se já existe
        if (repo.findByName(name).isPresent()) {
            throw new IllegalArgumentException("DroneType with name '" + name + "' already exists");
        }
        DroneType droneType = new DroneType(name, description);
        return repo.save(droneType);
    }

    public DroneType findByName(String name) {
        return repo.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("DroneType not found: " + name));
    }

    public Iterable<DroneType> findAll() {
        return repo.findAll();
    }
}
