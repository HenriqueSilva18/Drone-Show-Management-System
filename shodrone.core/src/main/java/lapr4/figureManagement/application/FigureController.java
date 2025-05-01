package lapr4.figureManagement.application;

import jakarta.transaction.Transactional;
import lapr4.customermanagement.domain.VAT;
import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.application.FigureService;

public class FigureController {

    private final FigureService figureService = new FigureService();

    @Transactional
    public Figure registerFigure(String description, boolean exclusive, VAT clientVAT) {
        Figure figure = new Figure(description, exclusive, clientVAT);
        return figureService.registerFigure(figure);
    }

    public Iterable<Figure> listAllFigures() {
        return figureService.findAll();
    }

    public Figure findFigureById(Long id) {
        return figureService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Figure not found with ID: " + id));
    }

    public Iterable<Figure> listActivePublicFigures() {
        return figureService.findActivePublic();
    }
}
