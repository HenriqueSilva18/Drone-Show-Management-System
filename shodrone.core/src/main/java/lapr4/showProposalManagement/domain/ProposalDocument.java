package lapr4.showProposalManagement.domain;

import jakarta.persistence.*;

@Embeddable
public class ProposalDocument {

    @Id
    private Number proposalNumber;

    @Column(columnDefinition="CLOB")
    private String proposalText;

}
