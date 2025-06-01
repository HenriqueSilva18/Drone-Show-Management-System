package lapr4.figureManagement.application;

import lapr4.figureManagement.domain.ValidationResult;

public class ValidateFigureDescriptionController {

    private final FigureDescriptionValidationService validationService;

    public ValidateFigureDescriptionController() {
        this.validationService = new FigureDescriptionValidationService();
    }

    public ValidationResult validateFigureDescription(String dslCode) {
        return validationService.validateFigureDescription(dslCode);
    }
}
