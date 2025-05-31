package lapr4.showProposalManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lapr4.showRequestManagement.domain.ShowRequest;

@Entity
public class ShowProposal implements AggregateRoot<Integer> {

    @Id
    @GeneratedValue
    private int proposalNumber;

    @ManyToOne
    private ShowRequest showRequest;

    @Column
    private int totalNumDrones;

    @Column
    private String simulationVideoLink;

    @Enumerated(EnumType.STRING)
    private SimulationStatus simulationStatus;

    @Enumerated(EnumType.STRING)
    private ProposalStatus proposalStatus;

    // TEMPLATE TYPE

    // LIST DRONES
    // LIST FIGURES

    // VALOR SEGURO (POR DRONE MODEL E QUANTITY)

    // DATA & HOURS -> SHOW REQUEST?
    // GPS COORDINATES -> SHOW REQUEST?
    // DURATION -> SHOW REQUEST?

    public ShowProposal(ShowRequest showRequest, int totalNumDrones, ProposalStatus proposalStatus) {
        if (showRequest == null || proposalStatus == null) {
            throw new IllegalArgumentException();
        }
        this.showRequest = showRequest;
        this.totalNumDrones = totalNumDrones;
        this.proposalStatus = proposalStatus;
    }

    protected ShowProposal() {
        // for ORM
    }

    public int proposalNumber() {
        return proposalNumber;
    }

    public ShowRequest showRequest() {
        return showRequest;
    }

    public int totalNumDrones() {
        return totalNumDrones;
    }

    public ProposalStatus proposalStatus() {
        return proposalStatus;
    }

    public void setProposalStatus(ProposalStatus proposalStatus) {
        if (proposalStatus == null) throw new IllegalArgumentException();
        this.proposalStatus = proposalStatus;
    }

    @Override
    public Integer identity() {
        return proposalNumber;
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        ShowProposal that = (ShowProposal) other;
        return proposalNumber == that.proposalNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShowProposal)) return false;
        ShowProposal that = (ShowProposal) o;
        return proposalNumber == that.proposalNumber;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(proposalNumber);
    }
}