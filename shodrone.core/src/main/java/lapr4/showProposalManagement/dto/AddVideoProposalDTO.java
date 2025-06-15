package lapr4.showProposalManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@DTO
@Data
@AllArgsConstructor
public class AddVideoProposalDTO {
    public int proposalNumber;
    public String videoLink;
}