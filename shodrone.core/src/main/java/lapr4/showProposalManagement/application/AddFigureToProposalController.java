package lapr4.showProposalManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.droneModelManagement.domain.dto.DroneModelDTO;
import lapr4.droneModelManagement.repositories.DroneModelRepository;
import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.dto.FigureDTO;
import lapr4.figureManagement.repositories.FigureRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showProposalManagement.domain.FigureInShowProposal;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import lapr4.usermanagement.domain.Roles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AddFigureToProposalController {

    private final ShowProposalRepository proposalRepository = PersistenceContext.repositories().showProposals();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final FigureRepository figureRepository = PersistenceContext.repositories().figures();


    public List<FigureDTO> availableFigures() {
        authorizationService.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.CRM_COLLABORATOR);

        List<Figure> figures = new ArrayList<>();
        figureRepository.findAll().forEach(figures::add);
        List<FigureDTO> dtos = new ArrayList<>();

        for (Figure f : figures) {
            new FigureDTO(f.identity(),f.description());

        }
        return dtos;
    }

    public List<DroneModelDTO> availableModels(int proposalId) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        ShowProposal proposal = proposalRepository.findByProposalNumber(proposalId)
                .orElseThrow(() -> new IllegalArgumentException("Proposal not found with ID: " + proposalId));
        List<DroneModel> models = proposal.modelList();
        List<DroneModelDTO> dtos = new ArrayList<>();
        for (DroneModel model : models) {
            dtos.add(new DroneModelDTO(model.identity(), model.name()));
        }
        return dtos;
    }


    public List<ShowProposalDTO> listAllProposals() {
        authorizationService.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        List<ShowProposal> proposals = new ArrayList<>();
        proposalRepository.findAll().forEach(proposals::add);

        List<ShowProposalDTO> dtos = new ArrayList<>();
        for (ShowProposal p : proposals) {
            ShowProposalDTO dto = p.toDTO();
            dtos.add(dto);
        }
        return dtos;
    }

    public List<DroneType> droneTypesOfFigure(Long figureId) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        Figure figure = figureRepository.findById(figureId)
                .orElseThrow(() -> new IllegalArgumentException("Figure not found with ID: " + figureId));
        return figure.droneTypes();
    }


    public DroneModel getDroneModelByID(int number, Long id) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        ShowProposal proposal = proposalRepository.findByProposalNumber(number)
                .orElseThrow(() -> new IllegalArgumentException("Proposal not found with ID: " + number));
        return proposal.modelList().stream()
                .filter(model -> model.identity().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Drone model not found with ID: " + id));

    }

    public void addFigureToProposal(int number, Long figureId, Map<DroneType, DroneModel> droneMapping) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        ShowProposal proposal = proposalRepository.findByProposalNumber(number)
                .orElseThrow(() -> new IllegalArgumentException("Proposal not found with ID: " + number));
        Figure figure = figureRepository.findById(figureId)
                .orElseThrow(() -> new IllegalArgumentException("Figure not found with ID: " + figureId));

        proposal.addFigure(figure, droneMapping);
        proposalRepository.save(proposal);
    }

    public boolean isLastFigureSameAs(Long figureId, int proposalId) {
        Optional<ShowProposal> proposal = proposalRepository.findByProposalNumber(proposalId);
        if (proposal.isEmpty()) return false;

        List<FigureInShowProposal> figs = proposal.get().figuresList();
        if (figs.isEmpty()) return false;

        Figure last = figs.get(figs.size() - 1).figure();
        return last.identity().equals(figureId);
    }

}
