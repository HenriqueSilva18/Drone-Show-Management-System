package lapr4.persistence.impl.jpa;

import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.TypedQuery;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.droneModelManagement.repositories.DroneTypeRepository;

import java.util.Optional;

public class JpaDroneTypeRepository extends JpaAutoTxRepository<DroneType, Long, Long> implements DroneTypeRepository {

    public JpaDroneTypeRepository(String persistenceUnitName) {
        super(persistenceUnitName, "id"); // Certifique-se de que 'id' é o nome correto do campo de identidade
    }

    @Override
    public DroneType save(DroneType droneType) {
        return super.save(droneType);
    }

    @Override
    public Iterable<DroneType> findAll() {
        return null;
    }

    @Override
    public Optional<DroneType> findByName(String name) {
        final TypedQuery<DroneType> query = entityManager().createQuery(
                "SELECT dc FROM DroneType dc WHERE dc.name = :name", DroneType.class);
        query.setParameter("name", name);
        return query.getResultStream().findFirst();
    }

    @Override
    public Optional<DroneType> findById(Long identity) {
        return ofIdentity(identity);
    }
}
