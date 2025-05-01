package lapr4.persistence.impl.inmemory;

import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.repositories.FigureRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryFigureRepository
        extends InMemoryDomainRepository<Figure, Long>
        implements FigureRepository {
}
