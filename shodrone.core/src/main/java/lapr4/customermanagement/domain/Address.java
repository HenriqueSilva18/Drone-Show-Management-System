package lapr4.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Address implements ValueObject, Comparable<Address> {

    private static final long serialVersionUID = 1L;

    private String street;
    private String city;
    private String postalCode;
    private String country;

    public Address(final String street, final String city, final String postalCode, final String country) {
        validateStreet(street);
        validateCity(city);
        validatePostalCode(postalCode);
        validateCountry(country);

        this.street = street.trim();
        this.city = city.trim();
        this.postalCode = postalCode.trim();
        this.country = country.trim();
    }

    protected Address() {
        // for ORM
    }

    private void validateStreet(String street) {
        if (StringPredicates.isNullOrEmpty(street)) {
            throw new IllegalArgumentException("Street cannot be null or empty");
        }
        String trimmed = street.trim();
        if (!trimmed.matches("^[\\p{L}0-9\\s.,'-]+$")) {
            throw new IllegalArgumentException("Street contains invalid characters");
        }
    }

    private void validateCity(String city) {
        if (StringPredicates.isNullOrEmpty(city)) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        String trimmed = city.trim();
        if (!trimmed.matches("^[\\p{L}\\s-]+$")) {
            throw new IllegalArgumentException("City contains invalid characters");
        }
    }

    private void validatePostalCode(String postalCode) {
        if (StringPredicates.isNullOrEmpty(postalCode)) {
            throw new IllegalArgumentException("Postal code cannot be null or empty");
        }
        String trimmed = postalCode.trim();
        if (!trimmed.matches("^[a-zA-Z0-9\\s-]+$")) {
            throw new IllegalArgumentException("Postal code contains invalid characters");
        }
    }

    private void validateCountry(String country) {
        if (StringPredicates.isNullOrEmpty(country)) {
            throw new IllegalArgumentException("Country cannot be null or empty");
        }
        String trimmed = country.trim();
        if (!trimmed.matches("^[\\p{L}\\s-]+$")) {
            throw new IllegalArgumentException("Country contains invalid characters");
        }
    }

    public static Address valueOf(final String street, final String city,
                                  final String postalCode, final String country) {
        return new Address(street, city, postalCode, country);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        final Address that = (Address) o;
        return this.street.equals(that.street) && this.city.equals(that.city)
                && this.postalCode.equals(that.postalCode) && this.country.equals(that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, postalCode, country);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", street, city, postalCode, country);
    }

    @Override
    public int compareTo(final Address other) {
        int result = this.country.compareToIgnoreCase(other.country);
        if (result == 0) {
            result = this.city.compareToIgnoreCase(other.city);
            if (result == 0) {
                result = this.postalCode.compareTo(other.postalCode);
                if (result == 0) {
                    result = this.street.compareToIgnoreCase(other.street);
                }
            }
        }
        return result;
    }
}
