package lapr4.figureManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.figureManagement.domain.Figure;

import java.util.Optional;

public interface FigureRepository extends DomainRepository<Long, Figure> {
    Figure save(Figure figure);
    Optional<Figure> findById(Long id);
    Iterable<Figure> findAll();

    /** Retorna apenas figuras com isActive=true e isPublic=true */
    Iterable<Figure> findActivePublic();
}
