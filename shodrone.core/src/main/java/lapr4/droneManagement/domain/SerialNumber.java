package lapr4.droneManagement.domain;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SerialNumber implements Serializable, Comparable<SerialNumber> {

    private String value;

    protected SerialNumber() {
        // for JPA
    }

    public SerialNumber(String value) {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Serial number cannot be null or blank.");
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public int compareTo(SerialNumber other) {
        return this.value.compareTo(other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SerialNumber)) return false;
        SerialNumber that = (SerialNumber) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
