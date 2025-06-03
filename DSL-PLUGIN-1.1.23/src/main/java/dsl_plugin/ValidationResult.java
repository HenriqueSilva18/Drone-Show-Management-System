package dsl_plugin;

import java.util.Collections;
import java.util.List;

public class ValidationResult {
    private final boolean valid;
    private final List<String> errors;
    private final String dslVersion;

    private ValidationResult(boolean valid, List<String> errors, String dslVersion) {
        this.valid = valid;
        this.errors = errors;
        this.dslVersion = dslVersion;
    }

    public static ValidationResult valid(String dslVersion) {
        return new ValidationResult(true, Collections.emptyList(), dslVersion);
    }

    public static ValidationResult invalid(String error) {
        return new ValidationResult(false, Collections.singletonList(error), null);
    }

    public static ValidationResult invalid(List<String> errors) {
        return new ValidationResult(false, errors, null);
    }

    public boolean isValid() {
        return valid;
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public String getDslVersion() {
        return dslVersion;
    }

    public String getParsedDslVersion() {
        return dslVersion;
    }
}