package lapr4.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.droneModelManagement.repositories.DroneModelRepository;

public class InMemoryDroneModelRepository
        extends InMemoryDomainRepository<DroneModel, Long>
        implements DroneModelRepository {
}
