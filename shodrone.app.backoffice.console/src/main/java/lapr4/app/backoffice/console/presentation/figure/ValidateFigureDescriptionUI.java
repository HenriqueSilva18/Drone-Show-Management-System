package lapr4.app.backoffice.console.presentation.figure;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.figureManagement.application.ValidateFigureDescriptionController;
import lapr4.figureManagement.domain.ValidationResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ValidateFigureDescriptionUI extends AbstractUI {

    private final ValidateFigureDescriptionController controller = new ValidateFigureDescriptionController();

    private String dslCodeFromFile; // Stores the code read from file
    private String parsedDslVersion; // Stores the version extracted from the DSL content
    private boolean wasLastValidationSuccessful;
    private List<String> lastValidationErrors;
    private boolean dslInputAttemptedAndCompleted;

    public ValidateFigureDescriptionUI() {
        resetValidationState();
    }

    private void resetValidationState() {
        this.dslCodeFromFile = null;
        this.parsedDslVersion = null; // Will be set from parsing result
        this.wasLastValidationSuccessful = false;
        this.lastValidationErrors = Collections.emptyList();
        this.dslInputAttemptedAndCompleted = false;
    }

    public boolean requestAndPerformDslValidation() {
        resetValidationState();

        System.out.println("\n--- Provide Figure DSL for Validation ---");
        final String filePathStr = Console.readLine("Figure DSL Code File Path (or type 'CANCEL' to abort):");

        if (filePathStr.trim().isEmpty() || "CANCEL".equalsIgnoreCase(filePathStr.trim())) {
            System.out.println("❌ DSL file path input aborted or empty.");
            return false;
        }

        try {
            this.dslCodeFromFile = Files.readString(Paths.get(filePathStr.trim()));
            if (this.dslCodeFromFile.trim().isEmpty()) {
                System.out.println("❌ The specified DSL file ('" + filePathStr.trim() + "') is empty.");
                return false;
            }
        } catch (InvalidPathException e) {
            System.out.println("❌ The provided file path is invalid: " + filePathStr.trim() + ". " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println("❌ Error reading DSL file ('" + filePathStr.trim() + "'): " + e.getMessage());
            return false;
        }

        this.dslInputAttemptedAndCompleted = true; // File read, so input process is considered completed

        // MODIFIED: Call controller without explicit version
        // The controller/service will parse the version from dslCodeFromFile
        ValidationResult validationResult = controller.validateFigureDescription(this.dslCodeFromFile);

        this.wasLastValidationSuccessful = validationResult.isValid();
        this.lastValidationErrors = validationResult.getErrors();

        if (this.wasLastValidationSuccessful) {
            // Assuming ValidationResult now has a method like getParsedDslVersion()
            this.parsedDslVersion = validationResult.getParsedDslVersion(); // Get version from result
            System.out.println("✅ DSL validation successful (from file: " + filePathStr.trim() + "). Parsed DSL Version: " + this.parsedDslVersion);
        } else {
            System.out.println("❌ Errors in DSL validation (from file: " + filePathStr.trim() + "):");
            for (String error : this.lastValidationErrors) {
                System.out.println("- " + error);
            }
        }
        return true; // Process completed (validation attempted)
    }

    // Getter for the DSL code (read from file)
    public String getDslCode() { return this.dslCodeFromFile; }
    // Getter for the DSL version (parsed from the content)
    public String getDslVersion() { return this.parsedDslVersion; }
    public boolean wasValidationSuccessful() { return this.wasLastValidationSuccessful; }
    public List<String> getValidationErrors() { return this.lastValidationErrors; }
    public boolean wasDslInputAttemptedAndCompleted() { return this.dslInputAttemptedAndCompleted; }


    @Override
    protected boolean doShow() {
        System.out.println(headline());
        requestAndPerformDslValidation();
        if (wasDslInputAttemptedAndCompleted()) {
            if (wasValidationSuccessful()) {
                System.out.println("\nStandalone Validation Result: DSL from file is valid. Parsed Version: " + getDslVersion());
            } else {
                System.out.println("\nStandalone Validation Result: DSL from file is invalid.");
            }
        } else {
            System.out.println("\nStandalone Validation Result: DSL input from file was not completed, was cancelled, or a file error occurred.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Validate Figure Description (DSL from File)";
    }
}