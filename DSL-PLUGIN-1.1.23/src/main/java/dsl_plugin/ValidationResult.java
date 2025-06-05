package dsl_plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ValidationResult {
    private final boolean valid;
    private final List<String> errors;
    private final String parsedDslVersion; // Nova propriedade

    private ValidationResult(boolean valid, List<String> errors, String parsedDslVersion) {
        this.valid = valid;
        this.errors = errors != null ? new ArrayList<>(errors) : new ArrayList<>();
        this.parsedDslVersion = parsedDslVersion;
    }

    // Método estático para resultado válido COM versão
    public static ValidationResult valid(String parsedDslVersion) {
        return new ValidationResult(true, Collections.emptyList(), parsedDslVersion);
    }

    // Método estático para resultado inválido
    public static ValidationResult invalid(String error) {
        return new ValidationResult(false, Arrays.asList(error), null);
    }

    public static ValidationResult invalid(List<String> errors) {
        return new ValidationResult(false, errors, null);
    }

    // Getters
    public boolean isValid() {
        return valid;
    }

    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }

    // Métodos para compatibilidade com a UI
    public String getParsedDslVersion() {
        return parsedDslVersion;
    }

    public String getDslVersion() {
        return parsedDslVersion;
    }
}