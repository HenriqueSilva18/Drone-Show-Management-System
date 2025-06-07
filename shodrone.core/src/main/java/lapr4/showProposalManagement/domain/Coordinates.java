package lapr4.showProposalManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Coordinates implements ValueObject {

    private static final long serialVersionUID = 1L;

    private double latitude;
    private double longitude;

    public Coordinates(double latitude, double longitude) {
        Preconditions.ensure(latitude >= -90 && latitude <= 90, "Latitude must be between -90 and 90");
        Preconditions.ensure(longitude >= -180 && longitude <= 180, "Longitude must be between -180 and 180");

        this.latitude = latitude;
        this.longitude = longitude;
    }

    protected Coordinates() {
        // for ORM
    }

    public double latitude() {
        return latitude;
    }

    public double longitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}