package lapr4.figureManagement.dto;

public class FigureDTO {
    public final Long id;
    public final String description;

    public FigureDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s", id, description);
    }
}
