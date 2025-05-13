package lapr4.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Email implements ValueObject, Comparable<Email> {

    private static final long serialVersionUID = 1L;

    private String email;

    public Email(final String email) {
        validateEmail(email);
        this.email = email.trim().toLowerCase();
    }

    protected Email() {
        // for ORM
    }

    private void validateEmail(String email) {
        if (StringPredicates.isNullOrEmpty(email)) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        String trimmed = email.trim();
        if (!trimmed.matches("^[\\w.+\\-]+@[\\w.\\-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    public static Email valueOf(final String email) {
        return new Email(email);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;

        final Email that = (Email) o;
        return this.email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return email;
    }

    @Override
    public int compareTo(final Email other) {
        return this.email.compareToIgnoreCase(other.email);
    }
}
