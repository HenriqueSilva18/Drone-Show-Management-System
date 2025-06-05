package lapr4.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.maintenanceManagement.domain.MaintenanceType;
import lapr4.maintenanceManagement.repositories.MaintenanceTypeRepository;

import java.util.List;
import java.util.Optional;

public class JpaMaintenanceTypeRepository
        extends JpaAutoTxRepository<MaintenanceType, Long, Long>
        implements MaintenanceTypeRepository {

    public JpaMaintenanceTypeRepository(final String persistenceUnitName) {
        super(persistenceUnitName, "id");
    }

    public JpaMaintenanceTypeRepository(final TransactionalContext tx) {
        super(tx, "id");
    }

    @Override
    public Optional<MaintenanceType> findById(Long id) {
        return ofIdentity(id);
    }

    @Override
    public Optional<MaintenanceType> findByNameIgnoreCase(String name) {
        final var query = entityManager().createQuery(
                "SELECT m FROM MaintenanceType m WHERE LOWER(m.name) = LOWER(:name)",
                MaintenanceType.class
        );
        query.setParameter("name", name);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return findByNameIgnoreCase(name).isPresent();
    }

    @Override
    public MaintenanceType save(MaintenanceType type) {
        return super.save(type);
    }

    @Override
    public List<MaintenanceType> findAll() {
        final var query = entityManager().createQuery(
                "SELECT m FROM MaintenanceType m", MaintenanceType.class
        );
        return query.getResultList();
    }

    @Override
    public void delete(MaintenanceType entity) {
        entityManager().remove(entityManager().merge(entity));
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(this::delete);
    }

    @Override
    public long count() {
        final var query = entityManager().createQuery("SELECT COUNT(m) FROM MaintenanceType m", Long.class);
        return query.getSingleResult();
    }
}
