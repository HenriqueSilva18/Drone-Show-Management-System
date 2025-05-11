package lapr4.figureManagement.application;

import jakarta.transaction.Transactional;
import lapr4.customermanagement.domain.VAT;
import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.application.FigureCategoryService;
import lapr4.figureManagement.domain.FigureCategory;
import lapr4.figureManagement.repositories.FigureRepository;

import java.util.Collections;
import java.util.Set;


public class FigureCategoryController {

    private final FigureCategoryService service = new FigureCategoryService();

    public FigureCategory addFigureCategory(String name, String description) {
        return service.registerCategory(name, description);
    }
}
