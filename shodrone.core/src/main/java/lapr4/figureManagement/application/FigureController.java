package lapr4.figureManagement.application;

import jakarta.transaction.Transactional;
import lapr4.customermanagement.domain.VAT;
import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.application.FigureService;
import lapr4.figureManagement.domain.FigureCategory;
import lapr4.figureManagement.repositories.FigureRepository;

import java.util.Collections;
import java.util.Set;

public class FigureController {

    private final FigureService figureService = new FigureService();

    @Transactional
    public Figure registerFigure(String description, boolean exclusive, VAT clientVAT, FigureCategory category) {
        Figure figure = new Figure(description, exclusive, clientVAT, category);
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

    public Iterable<Figure> search(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return listActivePublicFigures();
        }

        try {

            return figureService.searchByCategoryOrKeyword(searchTerm);
        } catch (Exception e) {
            System.err.println("Error searching figures: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Figure addFigure(String description, boolean exclusive, FigureCategory category, VAT clientVAT) {
        return figureService.registerFigure(description, exclusive, clientVAT, category);
    }

    public Figure addFigure(String description, Set<String> keywords, boolean exclusive, FigureCategory category, VAT clientVAT) {
        return figureService.registerFigure(description, keywords, exclusive, clientVAT, category);
    }

    public Figure decommissionFigure(Figure figure) {
        return figureService.decommissionFigure(figure);
    }

}
