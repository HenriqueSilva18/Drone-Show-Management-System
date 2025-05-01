package lapr4.persistence.impl.inmemory;

import lapr4.droneManagement.domain.Drone;
import lapr4.droneManagement.domain.SerialNumber;
import lapr4.droneManagement.repositories.DroneRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryDroneRepository
        extends InMemoryDomainRepository<Drone, SerialNumber>
        implements DroneRepository {
}
