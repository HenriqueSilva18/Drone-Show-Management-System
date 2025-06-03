package dsl_plugin;

import dsl_plugin.generated_code.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class FigureDescriptionValidationService {

    public ValidationResult validateFigureDescription(String dslCode) {
        if (dslCode == null || dslCode.trim().isEmpty()) {
            return ValidationResult.invalid("DSL code cannot be empty");
        }

        try {
            DSL_FIGURELexer lexer = new DSL_FIGURELexer(CharStreams.fromString(dslCode));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            DSL_FIGUREParser parser = new DSL_FIGUREParser(tokens);

            ValidationErrorListener errorListener = new ValidationErrorListener();
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);

            DSL_FIGUREParser.ProgramContext programContext = parser.program();

            if (errorListener.hasErrors()) {
                return ValidationResult.invalid(errorListener.getErrors());
            }

            String parsedVersion = null;
            if (programContext.dslVersion() != null && programContext.dslVersion().VERSION() != null) {
                parsedVersion = programContext.dslVersion().VERSION().getText();
            }

            if (parsedVersion == null || parsedVersion.trim().isEmpty()) {
                return ValidationResult.invalid("DSL version not found or invalid in the provided code");
            }

            return ValidationResult.valid(parsedVersion);

        } catch (Exception e) {
            return ValidationResult.invalid("Validation error: " + e.getMessage());
        }
    }
}
