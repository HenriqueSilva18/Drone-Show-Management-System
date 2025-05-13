package lapr4.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import jakarta.persistence.Embeddable;

@Embeddable
public class NIF implements ValueObject, Comparable<NIF> {

    private static final long serialVersionUID = 1L;

    private String nif;

    public NIF(final String nif) {
        validateNIF(nif);
        this.nif = nif.trim();
    }

    protected NIF() {
        // for ORM
    }

    private void validateNIF(String nif) {
        if (StringPredicates.isNullOrEmpty(nif)) {
            throw new IllegalArgumentException("NIF cannot be null or empty");
        }
        String trimmed = nif.trim();
        if (!trimmed.matches("^\\d{9}$")) {
            throw new IllegalArgumentException(
                    "Invalid NIF format. Expected exactly 9 digits.");
        }
    }

    public static NIF valueOf(final String nif) {
        return new NIF(nif);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NIF)) {
            return false;
        }

        final NIF that = (NIF) o;
        return this.nif.equals(that.nif);
    }

    @Override
    public int hashCode() {
        return this.nif.hashCode();
    }

    @Override
    public String toString() {
        return this.nif;
    }

    @Override
    public int compareTo(final NIF other) {
        return nif.compareTo(other.nif);
    }
}