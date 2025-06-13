package lapr4.showProposalManagement.application;

import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.droneModelManagement.domain.dto.DroneModelDTO;
import lapr4.droneModelManagement.repositories.DroneModelRepository;
import lapr4.droneManagement.repositories.DroneRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.PopulateProposalDTO;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PopulateModelListController {

    private final ShowProposalRepository proposalRepo;
    private final DroneModelRepository modelRepo;
    private final DroneRepository droneRepo;

    // Constructor for production use
    public PopulateModelListController() {
        this(
                PersistenceContext.repositories().showProposals(),
                PersistenceContext.repositories().droneModels(),
                PersistenceContext.repositories().drones()
        );
    }

    // Constructor for testing (allows mock injection)
    public PopulateModelListController(ShowProposalRepository proposalRepo,
                                       DroneModelRepository modelRepo,
                                       DroneRepository droneRepo) {
        this.proposalRepo = proposalRepo;
        this.modelRepo = modelRepo;
        this.droneRepo = droneRepo;
    }

    public List<PopulateProposalDTO> listUnassignedShowProposals() {
        List<PopulateProposalDTO> dtos = new ArrayList<>();
        for (ShowProposal p : proposalRepo.findAll()) {
            int assigned = (int) p.modelList().stream().filter(m -> m != null).count();
            if (assigned < p.totalNumDrones()) {
                dtos.add(new PopulateProposalDTO(p.identity(), p.totalNumDrones(), assigned));
            }
        }
        return dtos;
    }

    public PopulateProposalDTO getProposalByNumber(int proposalNumber) {
        Optional<ShowProposal> opt = proposalRepo.findByProposalNumber(proposalNumber);
        if (opt.isEmpty()) return null;
        ShowProposal p = opt.get();
        int assigned = (int) p.modelList().stream().filter(m -> m != null).count();
        return new PopulateProposalDTO(p.identity(), p.totalNumDrones(), assigned);
    }

    public List<DroneModelDTO> listAvailableDroneModels() {
        List<DroneModelDTO> dtos = new ArrayList<>();
        modelRepo.findAll().forEach(m -> dtos.add(new DroneModelDTO(m.identity(), m.name())));
        return dtos;
    }

    public int countAvailableOfModel(Long modelId) {
        return droneRepo.countAvailableOfModelById(modelId);
    }

    public void assignModelToProposal(int proposalNumber, Long modelId, int quantity) {
        ShowProposal proposal = proposalRepo.findByProposalNumber(proposalNumber)
                .orElseThrow(() -> new IllegalArgumentException("Proposal not found"));
        DroneModel model = modelRepo.ofIdentity(modelId)
                .orElseThrow(() -> new IllegalArgumentException("Drone model not found"));

        int assigned = 0;
        List<DroneModel> list = proposal.modelList();
        for (int i = 0; i < list.size() && assigned < quantity; i++) {
            if (list.get(i) == null) {
                list.set(i, model);
                assigned++;
            }
        }
        proposal.calculateInsuranceValue();
        proposal.rebuildModelCountMapFromModelList();
        proposalRepo.save(proposal);
    }

}
