package lapr4.persistence.impl.jpa;

import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.figureManagement.domain.FigureCategory;
import lapr4.figureManagement.repositories.FigureCategoryRepository;

import java.util.Optional;

public class JpaFigureCategoryRepository extends JpaAutoTxRepository<FigureCategory, String, String> implements FigureCategoryRepository {


    public JpaFigureCategoryRepository(String persistenceUnitName) {
        super(persistenceUnitName, "name"); // 'name' é o @Id da tua entidade
    }

    @Override
    public FigureCategory save(FigureCategory category) {
        return save(category);
    }


}
