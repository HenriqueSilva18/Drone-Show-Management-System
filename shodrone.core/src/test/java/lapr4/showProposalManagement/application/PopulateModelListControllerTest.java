package lapr4.showProposalManagement.application;

import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.droneModelManagement.domain.dto.DroneModelDTO;
import lapr4.droneModelManagement.repositories.DroneModelRepository;
import lapr4.droneManagement.repositories.DroneRepository;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PopulateModelListControllerTest {

    private ShowProposalRepository proposalRepo;
    private DroneModelRepository modelRepo;
    private DroneRepository droneRepo;

    private PopulateModelListController controller;

    @BeforeEach
    void setUp() {
        proposalRepo = mock(ShowProposalRepository.class);
        modelRepo = mock(DroneModelRepository.class);
        droneRepo = mock(DroneRepository.class);
        controller = new PopulateModelListController(proposalRepo, modelRepo, droneRepo);
    }

    @Test
    void testListUnassignedShowProposalsReturnsExpectedDTO() {
        ShowProposal proposal = mock(ShowProposal.class);
        when(proposal.identity()).thenReturn(1);
        when(proposal.totalNumDrones()).thenReturn(3);
        when(proposal.modelList()).thenReturn(Arrays.asList(null, null, mock(DroneModel.class)));

        when(proposalRepo.findAll()).thenReturn(List.of(proposal));

        var result = controller.listUnassignedShowProposals();

        assertEquals(1, result.size());
        assertEquals(3, result.get(0).totalDrones);
        assertEquals(1, result.get(0).dronesAssigned);
    }

    @Test
    void testGetProposalByNumberReturnsNullIfNotFound() {
        when(proposalRepo.findByProposalNumber(10)).thenReturn(Optional.empty());
        assertNull(controller.getProposalByNumber(10));
    }

    @Test
    void testCountAvailableOfModelDelegatesToRepo() {
        when(droneRepo.countAvailableOfModelById(5L)).thenReturn(7);
        int count = controller.countAvailableOfModel(5L);
        assertEquals(7, count);
    }

    @Test
    void testAssignModelToProposalAssignsCorrectly() {
        ShowProposal proposal = mock(ShowProposal.class);
        List<DroneModel> models = new ArrayList<>(Arrays.asList(null, null, null));
        when(proposal.modelList()).thenReturn(models);
        when(proposalRepo.findByProposalNumber(1)).thenReturn(Optional.of(proposal));

        DroneModel model = mock(DroneModel.class);
        when(modelRepo.ofIdentity(100L)).thenReturn(Optional.of(model));

        controller.assignModelToProposal(1, 100L, 2);

        assertEquals(model, models.get(0));
        assertEquals(model, models.get(1));
        verify(proposalRepo).save(proposal);
    }
}
