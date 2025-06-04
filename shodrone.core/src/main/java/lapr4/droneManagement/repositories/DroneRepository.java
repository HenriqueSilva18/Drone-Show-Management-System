package lapr4.droneManagement.repositories;

import lapr4.droneManagement.domain.Drone;
import lapr4.droneManagement.domain.SerialNumber;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import eapli.framework.domain.repositories.DomainRepository;

public interface DroneRepository extends DomainRepository<SerialNumber, Drone> {

    @Query("SELECT COUNT(d) FROM Drone d WHERE d.model.id = :modelId")
    int countAvailableOfModelById(@Param("modelId") Long modelId);
}
