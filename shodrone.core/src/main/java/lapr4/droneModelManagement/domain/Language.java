package lapr4.droneModelManagement.domain;
public class Language {

    private String value;

    public Language(String value) {
        this.value = value;
    }

    // Getter e Setter
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
