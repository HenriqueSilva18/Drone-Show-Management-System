package lapr4.persistence.impl.jpa;

import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.TypedQuery;
import lapr4.figureManagement.domain.FigureCategory;
import lapr4.figureManagement.repositories.FigureCategoryRepository;

import java.util.Optional;


public class JpaFigureCategoryRepository extends JpaAutoTxRepository<FigureCategory, String, String> implements FigureCategoryRepository {


    public JpaFigureCategoryRepository(String persistenceUnitName) {
        super(persistenceUnitName, "name"); // 'name' é o @Id da tua entidade
    }

    @Override
    public Optional<FigureCategory> findByName(String name) {
        final TypedQuery<FigureCategory> query = entityManager().createQuery(
                "SELECT fc FROM FigureCategory fc WHERE fc.name = :name", FigureCategory.class);
        query.setParameter("name", name);
        return query.getResultStream().findFirst();
    }

    @Override
    public FigureCategory save(FigureCategory category) {
        return super.save(category);
    }
}
