package lapr4.showPrososalManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lapr4.showRequestManagement.domain.ShowRequest;

@Entity
public class ShowProposal implements AggregateRoot<Integer> {

    @Id
    @GeneratedValue
    private int proposalId;

    @OneToOne
    private ShowRequest showRequest;

    @Enumerated
    private ApprovalStatus approvalStatus;

    @Column
    private int totalDrones;

    public ShowProposal(ShowRequest showRequest, int totalDrones, ApprovalStatus approvalStatus) {
        if (showRequest == null || approvalStatus == null) {
            throw new IllegalArgumentException();
        }
        this.showRequest = showRequest;
        this.totalDrones = totalDrones;
        this.approvalStatus = approvalStatus;
    }

    protected ShowProposal() {
        // for ORM
    }

    public int proposalId() {
        return proposalId;
    }

    public ShowRequest showRequest() {
        return showRequest;
    }

    public int totalDrones() {
        return totalDrones;
    }

    public ApprovalStatus approvalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        if (approvalStatus == null) throw new IllegalArgumentException();
        this.approvalStatus = approvalStatus;
    }

    @Override
    public Integer identity() {
        return proposalId;
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        ShowProposal that = (ShowProposal) other;
        return proposalId == that.proposalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShowProposal)) return false;
        ShowProposal that = (ShowProposal) o;
        return proposalId == that.proposalId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(proposalId);
    }
}
