package lapr4.persistence.impl.inmemory;

import lapr4.figureManagement.domain.FigureCategory;
import lapr4.figureManagement.repositories.FigureCategoryRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryFigureCategoryRepository implements FigureCategoryRepository {

    private final Set<FigureCategory> categories = new HashSet<>();

    @Override
    public FigureCategory save(FigureCategory category) {
        categories.removeIf(f -> f.identity().equals(category.identity()));
        categories.add(category);
        return category;
    }


    @Override
    public Iterable<FigureCategory> findAll() {
        return categories;
    }

    @Override
    public Optional<FigureCategory> findByName(String name) {
        return ofIdentity(name);
    }

    @Override
    public Optional<FigureCategory> ofIdentity(String id) {
        return categories.stream()
                .filter(category -> category.identity().equals(id))
                .findFirst();
    }

    @Override
    public void delete(FigureCategory category) {
        categories.remove(category);
    }


    @Override
    public void deleteOfIdentity(String name) {
        categories.removeIf(category -> category.identity().equals(name));
    }

    @Override
    public long count() {
        return categories.size();
    }
}
