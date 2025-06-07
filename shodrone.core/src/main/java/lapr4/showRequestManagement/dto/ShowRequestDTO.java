package lapr4.showRequestManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowRequestDTO {

    public int id;
    public String customerVat;
    public String showDescription;
    public int numDrones;
    public double duration;
    public String dateValue;
    public String status;

    @Override
    public String toString() {
        return String.format(
                "ID: %d | Customer: %s | Status: %s | Drones: %d | Duration: %.1f min | Date: %s",
                id,
                customerVat,
                status,
                numDrones,
                duration,
                dateValue
        );
    }
}