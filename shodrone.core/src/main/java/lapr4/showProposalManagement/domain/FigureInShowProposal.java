package lapr4.showProposalManagement.domain;

import jakarta.persistence.Entity;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.figureManagement.domain.Figure;
import jakarta.persistence.*;


import java.util.Map;

@Entity
public class FigureInShowProposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Figure figure;

    @ManyToMany
    @MapKeyJoinColumn(name = "drone_type_id") // chave do Map
    @JoinTable(
            name = "figure_drone_mapping",
            joinColumns = @JoinColumn(name = "figure_in_proposal_id"),
            inverseJoinColumns = @JoinColumn(name = "drone_model_id")
    )    private Map<DroneType, DroneModel> relationships;

    public FigureInShowProposal(Figure figure, Map<DroneType, DroneModel> relationship) {
        this.figure = figure;
        this.relationships = relationship;
    }


    public FigureInShowProposal() {
        //for ORM
    }

    public Figure figure() {
        return figure;
    }
    public Map<DroneType, DroneModel> relationships() {
        return relationships;
    }
}
