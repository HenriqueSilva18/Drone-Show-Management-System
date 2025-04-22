package lapr4.customermanagement.domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import jakarta.persistence.Embeddable;

@Embeddable
public class VAT implements ValueObject, Comparable<VAT> {

    private static final long serialVersionUID = 1L;

    private String number;

    public VAT(final String vatNumber) {
        validateVAT(vatNumber);
        this.number = vatNumber.trim().toUpperCase();
    }

    protected VAT() {
        // for ORM
    }

    private void validateVAT(String vatNumber) {
        if (StringPredicates.isNullOrEmpty(vatNumber)) {
            throw new IllegalArgumentException("VAT number cannot be null or empty");
        }
        String trimmed = vatNumber.trim();
        if (!trimmed.matches("^[A-Z]{2}[A-Z0-9]{2,13}$")) {
            throw new IllegalArgumentException(
                    "Invalid VAT number format. Expected format 2 letter country code followed by 2-13 alphanumeric characters)");
        }
    }

    public static VAT valueOf(final String vatNumber) {
        return new VAT(vatNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VAT)) {
            return false;
        }

        final VAT that = (VAT) o;
        return this.number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return this.number.hashCode();
    }

    @Override
    public String toString() {
        return this.number;
    }

    @Override
    public int compareTo(final VAT other) {
        return number.compareTo(other.number);
    }
}