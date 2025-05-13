package lapr4.persistence.impl.jpa;

import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.TypedQuery;
import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.repositories.FigureRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

public class JpaFigureRepository extends JpaAutoTxRepository<Figure, Long, Long> implements FigureRepository {

    public JpaFigureRepository(String persistenceUnitName) {
        super(persistenceUnitName, "id"); // Certifique-se de que 'id' é o nome correto do campo de identidade
    }

    @Override
    public Figure save(Figure figure) {
        return save(figure);
    }

    @Override
    public Optional<Figure> findById(Long id) {
        return ofIdentity(id);
    }

    @Override
    public Iterable<Figure> findAll() {
        return findAll();
    }

    @Override
    public Iterable<Figure> findActivePublic() {
        try {
            final TypedQuery<Figure> query = entityManager().createQuery(
                    "SELECT f FROM Figure f WHERE f.isActive = true AND f.exclusive = false",
                    Figure.class);

            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Error in findActivePublic: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Iterable<Figure> searchByCategoryOrKeyword(String searchTerm) {
        try {
            if (searchTerm == null || searchTerm.trim().isEmpty()) {
                return findActivePublic();
            }

            String normalizedTerm = searchTerm.toLowerCase();

            final TypedQuery<Figure> query = entityManager().createQuery(
                    "SELECT f FROM Figure f WHERE " +
                            "(LOWER(f.category.name) LIKE :searchTerm OR " +
                            "LOWER(f.description) LIKE :searchTerm) AND " +
                            "f.isActive = true",
                    Figure.class);

            query.setParameter("searchTerm", "%" + normalizedTerm + "%");

            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Error in searchByCategoryOrKeyword: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void decommissionFigure(Figure figure) {
        try {
            figure.setActive(false);
            figure.setDecommissionDate(LocalDateTime.now());
            save(figure);
        } catch (Exception e) {
            System.err.println("Error in decommissionFigure: " + e.getMessage());
            e.printStackTrace();
        }
    }
}