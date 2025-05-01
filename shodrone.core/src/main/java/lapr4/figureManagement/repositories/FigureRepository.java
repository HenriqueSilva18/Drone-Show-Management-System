package lapr4.figureManagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.figureManagement.domain.Figure;

public interface FigureRepository extends DomainRepository<Long, Figure> {
    // Exemplos de métodos adicionais:
    // Iterable<Figure> findByClientVAT(VAT vat);
}
