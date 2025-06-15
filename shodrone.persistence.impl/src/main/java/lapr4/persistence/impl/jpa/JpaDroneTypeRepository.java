package lapr4.persistence.impl.jpa;

import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.TypedQuery;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.droneModelManagement.repositories.DroneTypeRepository;

import java.util.Optional;

public class JpaDroneTypeRepository extends JpaAutoTxRepository<DroneType, String, String> implements DroneTypeRepository {

    public JpaDroneTypeRepository(String persistenceUnitName) {
        super(persistenceUnitName, "name"); // 'name' é o @Id da tua entidade
    }

    /**
     * Finds a DroneType by its name.
     *
     * @param name the name of the DroneType
     * @return an Optional containing the DroneType if found, or empty if not found
     */
    @Override
    public Optional<DroneType> findByName(String name) {
        final TypedQuery<DroneType> query = entityManager().createQuery(
                "SELECT dt FROM DroneType dt WHERE dt.name = :name", DroneType.class);
        query.setParameter("name", name);
        return query.getResultStream().findFirst();
    }

    @Override
    public DroneType save(DroneType figure) {

        return super.save(figure);
    }



}
