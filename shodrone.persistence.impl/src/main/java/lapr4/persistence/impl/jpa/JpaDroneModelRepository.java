package lapr4.persistence.impl.jpa;

import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.droneModelManagement.repositories.DroneModelRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaDroneModelRepository extends JpaAutoTxRepository<DroneModel, Long, Long>
		implements DroneModelRepository {

	public JpaDroneModelRepository(String persistenceUnitName) {
		super(persistenceUnitName, "id");
	}
}
