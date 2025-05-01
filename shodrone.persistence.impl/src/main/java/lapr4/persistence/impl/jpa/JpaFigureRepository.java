package lapr4.persistence.impl.jpa;

import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.repositories.FigureRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

public class JpaFigureRepository extends JpaAutoTxRepository<Figure, Long, Long> implements FigureRepository {

    public JpaFigureRepository(String persistenceUnitName) {
        super(persistenceUnitName, "clientVAT");
    }

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Figure save(Figure figure) {
        if (figure.identity() == null) {
            em.persist(figure);
            return figure;
        }
        return em.merge(figure);
    }

    @Override
    public java.util.Optional<Figure> findById(Long id) {
        return java.util.Optional.ofNullable(em.find(Figure.class, id));
    }

    @Override
    public Iterable<Figure> findAll() {
        return em.createQuery("SELECT f FROM Figure f", Figure.class)
                .getResultList();
    }

    @Override
    public Iterable<Figure> findActivePublic() {
        return em.createQuery(
                "SELECT f FROM Figure f WHERE f.isActive = true AND f.isPublic = true",
                Figure.class
        ).getResultList();
    }

}
