package lapr4.showProposalManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import lapr4.customermanagement.domain.Customer;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.showRequestManagement.domain.ShowRequest;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import eapli.framework.representations.dto.DTOable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShowProposal implements AggregateRoot<Integer>, DTOable<ShowProposalDTO> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue
    private int number;

    @ManyToOne(optional = false)
    private Customer customer;

    @ManyToOne(optional = false)
    private ShowRequest showRequest;

    @Column(nullable = false)
    private int totalNumDrones;

    // TODO TEMPLATE

    @Column
    private String simulationVideoLink;

    // TODO INSURANCE VALUE

    @Column(nullable = false)
    private Coordinates eventLocation;

    @Column(nullable = false)
    private LocalDateTime eventDateTime;

    @Column(nullable = false)
    private int eventDuration;

    @Enumerated(EnumType.STRING)
    private ShowProposalStatus status;

    @Enumerated(EnumType.STRING)
    private SimulationStatus simulationStatus;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DroneModel> modelList;

    // TODO LIST FIGURES

    // TODO SENT DATE & SENT BY MANAGER

    // TODO SHOW DESCRIPTION

    public ShowProposal(final ShowRequest showRequest, final int totalNumDrones, final Coordinates eventLocation,
                        final LocalDateTime eventDateTime, final int eventDuration) {
        Preconditions.noneNull(showRequest, totalNumDrones, eventLocation, eventDateTime, eventDuration);

        this.customer = showRequest.getCustomer();
        this.showRequest = showRequest;
        this.totalNumDrones = totalNumDrones;
        this.eventLocation = eventLocation;
        this.eventDateTime = eventDateTime;
        this.eventDuration = eventDuration;
        this.status = ShowProposalStatus.CREATED;
        this.simulationStatus = SimulationStatus.UNTESTED;
    }

    protected ShowProposal() {
        // for ORM
    }

    public void changeVideoTo(String newVideoLink) {
        Preconditions.nonEmpty(newVideoLink, "Video link cannot be empty.");
        this.simulationVideoLink = newVideoLink;
    }

    public void changeProposalStatus(ShowProposalStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Proposal status cannot be null");
        }
        this.status = status;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof ShowProposal)) {
            return false;
        }

        final var that = (ShowProposal) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity())
                && this.customer.equals(that.customer)
                && this.showRequest.equals(that.showRequest)
                && this.totalNumDrones == that.totalNumDrones
                && this.eventLocation.equals(that.eventLocation)
                && this.eventDateTime.equals(that.eventDateTime)
                && this.eventDuration == that.eventDuration;
    }

    @Override
    public Integer identity() {
        return this.number;
    }

    public ShowProposalStatus status() {
        return this.status;
    }

    public int totalNumDrones() {
        return this.totalNumDrones;
    }

    public List<DroneModel> modelList() {
        return this.modelList;
    }

    @Override
    public ShowProposalDTO toDTO() {
        return new ShowProposalDTO(
                this.number,
                this.customer.identity().toString(),
                this.showRequest.identity().value(),
                this.totalNumDrones,
                this.simulationVideoLink,
                this.eventLocation.latitude(),
                this.eventLocation.longitude(),
                this.eventDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                this.eventDateTime.format(DateTimeFormatter.ofPattern("HH:mm")),
                this.eventDuration,
                this.status.name(),
                this.simulationStatus.name()
        );
    }

    private List<DroneModel> initializeEmptyModelList(int totalNumDrones) {
        List<DroneModel> models = new ArrayList<>();
        for (int i = 0; i < totalNumDrones; i++) {
            models.add(null); // espaço reservado para cada drone
        }
        return models;
    }


}