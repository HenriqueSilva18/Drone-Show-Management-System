package lapr4.showRequestManagement.domain;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;

@Embeddable
public class ShowRequestId implements Serializable, Comparable<ShowRequestId> {

    @Column(name = "value")
    private int value;

    protected ShowRequestId() {
        // necessário para JPA
    }

    public ShowRequestId(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("ShowRequest ID must be positive");
        }
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public int compareTo(ShowRequestId other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShowRequestId)) return false;
        ShowRequestId that = (ShowRequestId) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
