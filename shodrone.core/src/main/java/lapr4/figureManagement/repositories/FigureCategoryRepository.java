package lapr4.figureManagement.repositories;

import java.util.Optional;
import eapli.framework.domain.repositories.DomainRepository;
import lapr4.figureManagement.domain.FigureCategory;

public interface FigureCategoryRepository  extends DomainRepository<String, FigureCategory> {
   FigureCategory save(FigureCategory figureCategory);
   Iterable<FigureCategory> findAll();
   Optional<FigureCategory> findByName(String name);
    Iterable<FigureCategory> findAllActive();
}

