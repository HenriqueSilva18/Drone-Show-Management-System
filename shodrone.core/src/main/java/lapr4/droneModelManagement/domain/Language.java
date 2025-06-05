package lapr4.droneModelManagement.domain;

public class Language {

    private String value;

    public Language(String value) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("Language cannot be blank.");
        this.value = value.trim().toUpperCase();
    }

    public static Language valueOf(String input) {
        return new Language(input); // cria nova instância, não enum
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
