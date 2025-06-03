package lapr4.figureManagement.application;

import dsl_plugin.FigureDescriptionValidationService;
import dsl_plugin.ValidationResult;


public class ValidateFigureDescriptionController {

    private final FigureDescriptionValidationService validationService;
    private String lastValidDslCode;
    private String lastValidDslVersion;

    public ValidateFigureDescriptionController() {
        this.validationService = new FigureDescriptionValidationService();
    }

    public ValidationResult validateFigureDescription(String dslCode) {
        ValidationResult result = validationService.validateFigureDescription(dslCode);
        if (result.isValid()) {
            this.lastValidDslCode = dslCode;
            this.lastValidDslVersion = result.getDslVersion();
        }
        return result;
    }

    public String getLastValidDslCode() {
        return lastValidDslCode;
    }

    public String getLastValidDslVersion() {
        return lastValidDslVersion;
    }
}
