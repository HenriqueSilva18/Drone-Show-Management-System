package lapr4.showProposalManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("java:S1068")
public class ProposalDTO {
    private int showRequestID;
    private int totalNumDrones;
    private int durationMinutes;
    private LocalDate proposalDate;
    private String eventHour;
    private double latitude;
    private double longitude;
    private String simulationVideoLink;
    private String status;
}
