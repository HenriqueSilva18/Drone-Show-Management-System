package lapr4.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Phone implements ValueObject, Comparable<Phone> {

    private static final long serialVersionUID = 1L;

    private String phoneNumber;

    public Phone(final String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber.trim();
    }

    protected Phone() {
        // for ORM
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (StringPredicates.isNullOrEmpty(phoneNumber)) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        String trimmed = phoneNumber.trim();
        if (!trimmed.matches("^[+]?[0-9\\s-]+$")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }

    public static Phone valueOf(final String phoneNumber) {
        return new Phone(phoneNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;

        final Phone that = (Phone) o;
        return this.phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return phoneNumber;
    }

    @Override
    public int compareTo(final Phone other) {
        return this.phoneNumber.compareTo(other.phoneNumber);
    }
}
