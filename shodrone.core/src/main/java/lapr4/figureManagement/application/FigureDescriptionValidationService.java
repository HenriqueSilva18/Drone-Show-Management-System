package lapr4.figureManagement.application;

import dsl.generated_code.DSL_FIGURELexer;
import dsl.generated_code.DSL_FIGUREParser;
import dsl.validation.ValidationErrorListener;
import lapr4.figureManagement.domain.ValidationResult;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.stereotype.Service;

@Service
public class FigureDescriptionValidationService {

    public ValidationResult validateFigureDescription(String dslCode) {
        if (dslCode == null || dslCode.trim().isEmpty()) {
            return ValidationResult.invalid("Código DSL não pode estar vazio");
        }

        try {
            ANTLRInputStream input = new ANTLRInputStream(dslCode);
            DSL_FIGURELexer lexer = new DSL_FIGURELexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            DSL_FIGUREParser parser = new DSL_FIGUREParser(tokens);

            ValidationErrorListener errorListener = new ValidationErrorListener();
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);

            // Parse the description and get the context of the entry rule
            DSL_FIGUREParser.ProgramContext programContext = parser.program(); // Store the context

            if (errorListener.hasErrors()) {
                return ValidationResult.invalid(errorListener.getErrors());
            }

            // If no syntax errors, extract the DSL version
            // The exact way to access this depends on your DSL_FIGURE.g4 grammar structure.
            // This is a common way if 'dslVersion' is a rule and 'VERSION' is a token within it.
            String parsedVersion = null;
            if (programContext.dslVersion() != null && programContext.dslVersion().VERSION() != null) {
                parsedVersion = programContext.dslVersion().VERSION().getText();
            } else {
                // This case should ideally not happen if your grammar mandates a version
                // and the syntax is correct up to this point.
                // If version is optional, handle accordingly. If mandatory, this indicates a grammar issue
                // or an unexpected parse tree structure not caught by the error listener.
                return ValidationResult.invalid("DSL version not found in the provided code, although syntax seems valid.");
            }

            if (parsedVersion == null || parsedVersion.trim().isEmpty()){
                return ValidationResult.invalid("Extracted DSL version is empty or null.");
            }

            return ValidationResult.valid(parsedVersion); // <-- Pass the extracted version

        } catch (Exception e) {
            // Consider logging the exception e.printStackTrace();
            return ValidationResult.invalid("Erro na validação: " + e.getMessage());
        }
    }
}
