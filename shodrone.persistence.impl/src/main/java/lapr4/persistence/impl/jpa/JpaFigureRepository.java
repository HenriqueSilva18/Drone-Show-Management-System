package lapr4.persistence.impl.jpa;

import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.repositories.FigureRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaFigureRepository extends JpaAutoTxRepository<Figure, Long, Long> implements FigureRepository {

    public JpaFigureRepository(String persistenceUnitName) {
        super(persistenceUnitName, "clientVAT");
    }
}
