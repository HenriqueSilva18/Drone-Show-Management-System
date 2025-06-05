package lapr4.showProposalManagement.dto;

public class PopulateProposalDTO {
    public int proposalNumber;
    public int totalDrones;
    public int dronesAssigned;

    public PopulateProposalDTO(int proposalNumber, int totalDrones, int dronesAssigned) {
        this.proposalNumber = proposalNumber;
        this.totalDrones = totalDrones;
        this.dronesAssigned = dronesAssigned;
    }
}