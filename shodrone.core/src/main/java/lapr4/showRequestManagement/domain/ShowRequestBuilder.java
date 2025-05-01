package lapr4.showRequestManagement.domain;

import eapli.framework.domain.model.DomainFactory;
import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.VAT;
import lapr4.droneManagement.domain.Drone;
import lapr4.figureManagement.domain.Figure;

import java.util.List;

public class ShowRequestBuilder implements DomainFactory<ShowRequest> {

    private ShowRequestId showRequestId;
    private int numDrones;
    private double duration;
    private String showDescription;
    private String dateValue;
    private Customer customer;
    private VAT clientVAT;
    private List<Drone> drones;
    private List<Figure> figures;

    private String status;

    public ShowRequestBuilder withId(final ShowRequestId id) {
        this.showRequestId = id;
        return this;
    }

    public ShowRequestBuilder withNumDrones(final int numDrones) {
        this.numDrones = numDrones;
        return this;
    }

    public ShowRequestBuilder withDuration(final double duration) {
        this.duration = duration;
        return this;
    }

    public ShowRequestBuilder withDescription(final String description) {
        this.showDescription = description;
        return this;
    }

    public ShowRequestBuilder withDate(final String dateValue) {
        this.dateValue = dateValue;
        return this;
    }

    public ShowRequestBuilder withCustomer(final Customer customer) {
        this.customer = customer;
        return this;
    }

    public ShowRequestBuilder withClientVAT(final VAT clientVAT) {
        this.clientVAT = clientVAT;
        return this;
    }

    public ShowRequestBuilder withDrones(final List<Drone> drones) {
        this.drones = drones;
        return this;
    }

    public ShowRequestBuilder withFigures(final List<Figure> figures) {
        this.figures = figures;
        return this;
    }

    public ShowRequestBuilder withStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public ShowRequest build() {
        if (showRequestId == null || showDescription == null || dateValue == null || customer == null || clientVAT == null ) {
            throw new IllegalStateException("Missing mandatory fields to build ShowRequest.");
        }

        return new ShowRequest(
                numDrones,
                duration,
                showDescription,
                showRequestId,
                dateValue,
                customer,
                clientVAT,
                drones,
                figures,
                status
        );
    }
}
