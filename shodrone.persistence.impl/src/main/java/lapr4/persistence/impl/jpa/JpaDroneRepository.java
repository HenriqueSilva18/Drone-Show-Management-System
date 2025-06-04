package lapr4.persistence.impl.jpa;

import lapr4.droneManagement.domain.Drone;
import lapr4.droneManagement.domain.SerialNumber;
import lapr4.droneManagement.repositories.DroneRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaDroneRepository extends JpaAutoTxRepository<Drone, SerialNumber, SerialNumber>
        implements DroneRepository {

    public JpaDroneRepository(final String persistenceUnitName) {
        super(persistenceUnitName, "serialNumber");
    }
}
