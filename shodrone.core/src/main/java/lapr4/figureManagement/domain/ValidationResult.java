package lapr4.figureManagement.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ValidationResult {
    private final boolean valid;
    private final List<String> errors;
    private final String parsedDslVersion; // <-- New field

    // Updated private constructor
    private ValidationResult(boolean valid, List<String> errors, String parsedDslVersion) {
        this.valid = valid;
        this.errors = errors != null ? Collections.unmodifiableList(errors) : Collections.emptyList();
        this.parsedDslVersion = parsedDslVersion; // Can be null if not valid or version not applicable
    }

    // Updated factory method for valid results
    public static ValidationResult valid(String parsedDslVersion) { // <-- Accepts parsed version
        if (parsedDslVersion == null || parsedDslVersion.trim().isEmpty()) {
            // Or throw an IllegalArgumentException, as a valid DSL should have a version
            // For now, let's allow it but it's a point of design.
            // Alternatively, this could call an internal constructor that sets errors.
            // For simplicity, we'll assume a valid parse will always yield a version.
            throw new IllegalArgumentException("Parsed DSL version cannot be null or empty for a valid result.");
        }
        return new ValidationResult(true, Collections.emptyList(), parsedDslVersion);
    }

    // Factory methods for invalid results (parsedDslVersion will be null)
    public static ValidationResult invalid(List<String> errors) {
        return new ValidationResult(false, errors, null);
    }

    public static ValidationResult invalid(String error) {
        return new ValidationResult(false, Arrays.asList(error), null);
    }

    public boolean isValid() {
        return valid;
    }

    public List<String> getErrors() {
        return errors; // Already unmodifiable from the constructor
    }

    // Getter for the parsed DSL version
    public String getParsedDslVersion() {
        if (!valid) {
            // Or throw an IllegalStateException, or simply return null
            // System.err.println("Warning: Tried to get DSL version from an invalid ValidationResult.");
            return null;
        }
        return parsedDslVersion;
    }
}