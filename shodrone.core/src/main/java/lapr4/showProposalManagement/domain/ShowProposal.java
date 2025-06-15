package lapr4.showProposalManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.infrastructure.authz.domain.model.Name;
import jakarta.xml.bind.annotation.XmlElement;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.VAT;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.figureManagement.domain.Figure;
import lapr4.showRequestManagement.domain.ShowRequest;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import eapli.framework.representations.dto.DTOable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@XmlRootElement
@Entity
@Table(name = "SHOW_PROPOSAL")
public class ShowProposal implements AggregateRoot<Integer>, DTOable<ShowProposalDTO> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue
    private int number;

    @XmlElement
    @JsonProperty
    @ManyToOne(optional = false)
    private Customer customer;

    @XmlElement
    @JsonProperty
    @ManyToOne(optional = false)
    private ShowRequest showRequest;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private int totalNumDrones;

    @XmlElement
    @JsonProperty
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProposalTemplate template;

    @XmlElement
    @JsonProperty
    @Column
    private String simulationVideoLink;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private double insuranceValue;


    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private Coordinates eventLocation;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private LocalDateTime eventDateTime;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private int eventDuration;

    @XmlElement
    @JsonProperty
    @Enumerated(EnumType.STRING)
    private ShowProposalStatus status;

    @XmlElement
    @JsonProperty
    @Enumerated(EnumType.STRING)
    private SimulationStatus simulationStatus;

    @XmlElement
    @JsonProperty
    @OneToMany(cascade = CascadeType.ALL)
    private List<DroneModel> modelList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<FigureInShowProposal> figuresList;

    @ElementCollection
    @CollectionTable(name = "SHOW_PROPOSAL_MODEL_COUNTS", joinColumns = @JoinColumn(name = "show_proposal_id"))
    @MapKeyJoinColumn(name = "drone_model_id")
    @Column(name = "quantity", nullable = false)
    private Map<DroneModel, Integer> modelCountMap = new HashMap<>();

    @XmlElement
    @JsonProperty
    @Column(nullable = true, columnDefinition="CLOB")
    private String proposalText;

    @XmlElement
    @JsonProperty
    @Column(nullable = true)
    private LocalDate sentDate;

    @XmlElement
    @JsonProperty
    @Column(nullable = true)
    private Name sentBy;

    // TODO SHOW DESCRIPTION

    public ShowProposal(final ShowRequest showRequest, final int totalNumDrones, final Coordinates eventLocation,
                        final LocalDateTime eventDateTime, final int eventDuration, final ProposalTemplate template) {
        Preconditions.noneNull(showRequest, totalNumDrones, eventLocation, eventDateTime, eventDuration, template);
        Preconditions.isPositive(totalNumDrones, "Total number of drones must be positive.");


        this.customer = showRequest.getCustomer();
        this.showRequest = showRequest;
        this.totalNumDrones = totalNumDrones;
        this.eventLocation = eventLocation;
        this.eventDateTime = eventDateTime;
        this.eventDuration = eventDuration;
        this.status = ShowProposalStatus.CREATED;
        this.simulationStatus = SimulationStatus.UNTESTED;
        this.template = template;
        this.modelList = new ArrayList<>();
    }

    protected ShowProposal() {
        // for ORM
    }

    public void changeVideoTo(String newVideoLink) {
        Preconditions.nonEmpty(newVideoLink, "Video link cannot be empty.");
        this.simulationVideoLink = newVideoLink;
    }

    public void changeProposalStatus(ShowProposalStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Proposal status cannot be null");
        }
        this.status = status;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof ShowProposal)) {
            return false;
        }

        final var that = (ShowProposal) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity())
                && this.customer.equals(that.customer)
                && this.showRequest.equals(that.showRequest)
                && this.totalNumDrones == that.totalNumDrones
                && this.eventLocation.equals(that.eventLocation)
                && this.eventDateTime.equals(that.eventDateTime)
                && this.eventDuration == that.eventDuration;
    }

    @Override
    public Integer identity() {
        return this.number;
    }

    public Customer customer() {return this.customer;}

    public ShowProposalStatus status() {
        return this.status;
    }

    public String simulationVideoLink() {
        return this.simulationVideoLink;
    }

    public int totalNumDrones() {
        return this.totalNumDrones;
    }

    public List<DroneModel> modelList() {
        return this.modelList;
    }

    public List<FigureInShowProposal> figuresList() {
        return this.figuresList;
    }

    @Override
    public ShowProposalDTO toDTO() {
        return new ShowProposalDTO(
                this.number,
                this.customer.identity().toString(),
                this.showRequest.identity().value(),
                this.totalNumDrones,
                this.simulationVideoLink,
                this.eventLocation.latitude(),
                this.eventLocation.longitude(),
                this.eventDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                this.eventDateTime.format(DateTimeFormatter.ofPattern("HH:mm")),
                this.eventDuration,
                this.status.name(),
                this.simulationStatus.name(),
                this.insuranceValue,
                this.template.identity()
        );
    }

    private List<DroneModel> initializeEmptyModelList(int totalNumDrones) {
        List<DroneModel> models = new ArrayList<>();
        for (int i = 0; i < totalNumDrones; i++) {
            models.add(null); // espaço reservado para cada drone
        }
        return models;
    }


    public void addFigure(Figure figure, Map<DroneType, DroneModel> droneMapping) {
        Preconditions.nonNull(figure, "Figure cannot be null");
        Preconditions.nonNull(droneMapping, "Drone mapping cannot be null");

        for (FigureInShowProposal fig : figuresList) {
            if (fig.figure().sameAs(figure)) {
                throw new IllegalArgumentException("Figure already exists in the proposal.");
            }
        }

        FigureInShowProposal figureInProposal = new FigureInShowProposal(figure, droneMapping);
        figuresList.add(figureInProposal);
    }

    public void calculateInsuranceValue() {
        if (modelList == null || modelList.isEmpty())
            throw new IllegalStateException("Model list is empty, cannot calculate insurance.");

        this.insuranceValue = modelList.stream()
                .mapToDouble(DroneModel::securePrice)
                .sum();
    }

    public double insuranceValue() {
        return insuranceValue;
    }

    public void rebuildModelCountMapFromModelList() {
        modelCountMap.clear();
        for (DroneModel model : modelList) {
            if (model != null) {
                modelCountMap.merge(model, 1, Integer::sum);
            }
        }
        calculateInsuranceValue(); // atualiza o seguro com base no novo mapa
    }

    public LocalDateTime eventDateTime() {return this.eventDateTime;}

    public VAT CustomerVAT(){
        return customer.identity();
    }

    public Coordinates coordinates () {
        return this.eventLocation;
    }

    public int eventDuration() {
        return this.eventDuration;
    }

    public Map<String, Integer> modelCountMap() {
        return modelCountMap.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().name(),
                        Map.Entry::getValue
                ));
    }

    public void changeSentDate(LocalDate sentDate) {
        this.sentDate = sentDate;
    }

    public void changeSentBy(Name sentBy) {
        this.sentBy = sentBy;
    }

    public SimulationStatus simulationStatus() {
        return this.simulationStatus;
    }

    public void changeSimulationStatus(SimulationStatus simulationStatus) {
        if (simulationStatus == null) {
            throw new IllegalArgumentException("Simulation status cannot be null");
        }
        this.simulationStatus = simulationStatus;
    }

    public void changeProposalText(String proposalText) {
        Preconditions.nonEmpty(proposalText, "Proposal text cannot be empty.");
        this.proposalText = proposalText;
    }

    public static ShowProposal createFakeProposalWithFigures(List<FigureInShowProposal> figures) {
        return new ShowProposal() {
            @Override
            public List<FigureInShowProposal> figuresList() {
                return figures;
            }
        };
    }

    public static ShowProposal from(VAT customerVAT, List<FigureInShowProposal> figures) {
        if (customerVAT == null || figures == null) {
            throw new IllegalArgumentException("VAT e lista de figuras não podem ser nulos.");
        }

        ShowProposal fakeProposal = new ShowProposal() {
            private final List<FigureInShowProposal> internalFigures = figures;

            @Override
            public List<FigureInShowProposal> figuresList() {
                return internalFigures;
            }
        };

        return fakeProposal;
    }



}