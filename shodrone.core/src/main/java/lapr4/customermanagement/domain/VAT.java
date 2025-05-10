package lapr4.customermanagement.domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import jakarta.persistence.Embeddable;

@Embeddable
public class VAT implements ValueObject, Comparable<VAT> {

    private static final long serialVersionUID = 1L;

    private String number;

    public VAT(final String vatNumber) {
        String processed = processInput(vatNumber);
        validateVAT(processed);
        this.number = processed;
    }

    protected VAT() {
        // for ORM
    }

    private String processInput(String vatNumber) {
        if (vatNumber == null) {
            return null;
        }
        return vatNumber.trim().toUpperCase();
    }

    private void validateVAT(String processedVatNumber) {
        if (StringPredicates.isNullOrEmpty(processedVatNumber)) {
            throw new IllegalArgumentException("VAT number cannot be null or empty");
        }
        if (!processedVatNumber.matches("^[A-Z]{2}[A-Z0-9]{2,13}$")) {
            throw new IllegalArgumentException(
                    "Invalid VAT format. Expected 2 letters followed by 2-13 alphanumerics (e.g., PT123456).");
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