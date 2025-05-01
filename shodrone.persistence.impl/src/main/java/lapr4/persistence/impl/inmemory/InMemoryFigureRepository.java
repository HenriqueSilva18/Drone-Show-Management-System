package lapr4.persistence.impl.inmemory;

import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.repositories.FigureRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class InMemoryFigureRepository extends InMemoryDomainRepository<Figure, Long> implements FigureRepository {

    private final Set<Figure> figures = new HashSet<>();

    @Override
    public Figure save(Figure figure) {
        figures.removeIf(f -> f.identity().equals(figure.identity()));
        figures.add(figure);
        return figure;
    }

    @Override
    public java.util.Optional<Figure> findById(Long id) {
        return figures.stream()
                .filter(f -> f.hasIdentity(id))
                .findFirst();
    }

    @Override
    public Iterable<Figure> findAll() {
        return new HashSet<>(figures);
    }

    @Override
    public Iterable<Figure> findActivePublic() {
        return figures.stream()
                .filter(f -> f.isActive() && f.isPublic())
                .collect(Collectors.toList());
    }


}
