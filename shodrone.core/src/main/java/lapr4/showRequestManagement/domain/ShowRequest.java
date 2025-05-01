package lapr4.showRequestManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.VAT;
import lapr4.droneManagement.domain.Drone;
import lapr4.figureManagement.domain.Figure;

import java.util.List;
import java.util.Objects;

@Entity
public class ShowRequest implements AggregateRoot<ShowRequestId> {

    @EmbeddedId
    private ShowRequestId showRequestId;

    private int numDrones;
    private double duration;
    private String showDescription;
    private String dateValue;

    private String status;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;

    @Embedded
    private VAT clientVAT;

    @ManyToMany
    private List<Drone> drones;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Figure> figures;

    // private User user; // futuramente

    protected ShowRequest() {
        // for JPA
    }

    public ShowRequest(int numDrones, double duration, String showDescription, ShowRequestId showRequestId,
                       String dateValue, Customer customer, VAT clientVAT, List<Drone> drones,
                       List<Figure> figures, String status /*, User user */) {
        this.numDrones = numDrones;
        this.duration = duration;
        this.showDescription = showDescription;
        this.showRequestId = showRequestId;
        this.dateValue = dateValue;
        this.customer = customer;
        this.clientVAT = clientVAT;
        this.drones = drones;
        this.figures = figures;
        this.status = status;
        // this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumDrones() {
        return numDrones;
    }

    public void setNumDrones(int numDrones) {
        this.numDrones = numDrones;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getShowDescription() {
        return showDescription;
    }

    public void setShowDescription(String showDescription) {
        this.showDescription = showDescription;
    }

    public ShowRequestId getShowRequestId() {
        return showRequestId;
    }

    public void setShowRequestId(ShowRequestId showRequestId) {
        this.showRequestId = showRequestId;
    }

    public String getDateValue() {
        return dateValue;
    }

    public void setDate(String date) {
        this.dateValue = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public VAT getClientVAT() {
        return clientVAT;
    }

    public List<Drone> getDrones() {
        return drones;
    }

    public List<Figure> getFigures() {
        return figures;
    }

    @Override
    public ShowRequestId identity() {
        return showRequestId;
    }

    @Override
    public boolean hasIdentity(ShowRequestId id) {
        return this.showRequestId != null && this.showRequestId.equals(id);
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        ShowRequest that = (ShowRequest) other;
        return Objects.equals(showRequestId, that.showRequestId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShowRequest)) return false;
        ShowRequest that = (ShowRequest) o;
        return Objects.equals(showRequestId, that.showRequestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showRequestId);
    }
}
