package lapr4.showProposalManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@DTO
@Data
@AllArgsConstructor
public class ShowProposalDTO {

    public int number;
    public String customerVAT;
    public int showRequestID;
    public int totalNumDrones;
    public String simulationVideoLink;
    public double latitude;
    public double longitude;
    public String eventDate;
    public String eventHour;
    public int eventDuration;
    public String status;
    public String simulationStatus;

    // CONSTRUCTOR FOR INITIAL CREATION
    public ShowProposalDTO(final int showRequestID, final int totalNumDrones, final double latitude, final double longitude,
                           final String eventDate, final String eventHour, final int eventDuration) {
        this.showRequestID = showRequestID;
        this.totalNumDrones = totalNumDrones;
        this.latitude = latitude;
        this.longitude = longitude;
        this.eventDate = eventDate;
        this.eventHour = eventHour;
        this.eventDuration = eventDuration;
    }
}