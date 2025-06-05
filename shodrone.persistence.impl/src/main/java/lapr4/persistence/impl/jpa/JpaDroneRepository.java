package lapr4.persistence.impl.jpa;

import jakarta.persistence.TypedQuery;
import lapr4.droneManagement.domain.Drone;
import lapr4.droneManagement.domain.SerialNumber;
import lapr4.droneManagement.repositories.DroneRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaDroneRepository extends JpaAutoTxRepository<Drone, SerialNumber, SerialNumber>
        implements DroneRepository {

    public JpaDroneRepository(final String persistenceUnitName) {
        super(persistenceUnitName, "serialNumber");
    }

    @Override
    public int countAvailableOfModelById(Long modelId) {
        final TypedQuery<Long> query = entityManager().createQuery(
                "SELECT COUNT(d) FROM Drone d WHERE d.model.id = :modelId", Long.class);
        query.setParameter("modelId", modelId);
        return query.getSingleResult().intValue();
    }
}
