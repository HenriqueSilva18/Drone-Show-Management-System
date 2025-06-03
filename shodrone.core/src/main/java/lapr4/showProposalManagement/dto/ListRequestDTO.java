package lapr4.showProposalManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRequestDTO {
    private int requestId;
    private int numDrones;
    private double duration;
    private String showDescription;
    private String dateValue;
    private String status;
    private String clientVAT;
} 