package lapr4.showProposalManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import jakarta.persistence.*;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.showRequestManagement.domain.ShowRequest;
import lapr4.showProposalManagement.dto.CreateProposalDTO;
import eapli.framework.representations.dto.DTOable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShowProposal implements AggregateRoot<Integer>, DTOable<CreateProposalDTO> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int proposalNumber;

    @ManyToOne
    private ShowRequest showRequest;

    @Column(nullable = false)
    private int totalNumDrones;

    @Column(nullable = false)
    private int durationMinutes;

    @Column(nullable = false)
    private LocalDate proposalDate;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column
    private String simulationVideoLink;

    @Enumerated(EnumType.STRING)
    private SimulationStatus simulationStatus;

    @Enumerated(EnumType.STRING)
    private ProposalStatus proposalStatus;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DroneModel> modelList;


    // TEMPLATE TYPE -> VIP

    // LIST DRONES
    // LIST FIGURES

    // VALOR SEGURO (POR DRONE MODEL E QUANTITY)

    // DATA & HOURS -> SHOW REQUEST?
    // PROPOSAL SENT DATE
    // GPS COORDINATES -> SHOW REQUEST?
    // DURATION -> SHOW REQUEST?

    public ShowProposal(ShowRequest showRequest, int totalNumDrones, int durationMinutes, 
                       LocalDate proposalDate, double latitude, double longitude, 
                       ProposalStatus proposalStatus) {
        if (showRequest == null || proposalStatus == null) {
            throw new IllegalArgumentException("Show request and proposal status cannot be null");
        }
        if (totalNumDrones <= 0) {
            throw new IllegalArgumentException("Total number of drones must be greater than 0");
        }
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0");
        }
        if (proposalDate == null) {
            throw new IllegalArgumentException("Proposal date cannot be null");
        }
        if (proposalDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Proposal date must be in the future");
        }
        
        this.showRequest = showRequest;
        this.totalNumDrones = totalNumDrones;
        this.durationMinutes = durationMinutes;
        this.proposalDate = proposalDate;
        this.latitude = latitude;
        this.longitude = longitude;
        this.proposalStatus = ProposalStatus.CREATED;
        this.simulationStatus = SimulationStatus.Untested;
        this.modelList = initializeEmptyModelList(totalNumDrones);
    }

    protected ShowProposal() {
        // for ORM
    }

    public int proposalNumber() {
        return proposalNumber;
    }


    @Override
    public Integer identity() {
        return proposalNumber;
    }


    public ProposalStatus getStatus() {
        return proposalStatus;
    }

    public void setProposalStatus(ProposalStatus proposalStatus) {
        if (proposalStatus == null) {
            throw new IllegalArgumentException("Proposal status cannot be null");
        }
        this.proposalStatus = proposalStatus;
    }

    public void setSimulationStatus(SimulationStatus simulationStatus) {
        if (simulationStatus == null) {
            throw new IllegalArgumentException("Simulation status cannot be null");
        }
        this.simulationStatus = simulationStatus;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof ShowProposal)) {
            return false;
        }

        final ShowProposal that = (ShowProposal) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public CreateProposalDTO toDTO() {
        return new CreateProposalDTO(
            showRequest.identity().value(),
            totalNumDrones,
            durationMinutes,
            proposalDate,
            latitude,
            longitude
        );
    }

    public int totalNumDrones() {
        return totalNumDrones;
    }

    public List<DroneModel> modelList() {
        return modelList;
    }



    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public String toString() {
        return "ShowProposal{" +
                "proposalNumber=" + proposalNumber +
                ", totalNumDrones=" + totalNumDrones +
                ", durationMinutes=" + durationMinutes +
                ", proposalDate=" + proposalDate +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", status=" + proposalStatus +
                '}';
    }

    private List<DroneModel> initializeEmptyModelList(int totalNumDrones) {
        List<DroneModel> models = new ArrayList<>();
        for (int i = 0; i < totalNumDrones; i++) {
            models.add(null); // espaço reservado para cada drone
        }
        return models;
    }

}