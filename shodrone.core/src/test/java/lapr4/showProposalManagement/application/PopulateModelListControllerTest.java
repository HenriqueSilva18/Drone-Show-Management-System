package lapr4.showProposalManagement.application;

import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.droneModelManagement.repositories.DroneModelRepository;
import lapr4.droneManagement.repositories.DroneRepository;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.PopulateProposalDTO;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PopulateModelListControllerTest {

    private PopulateModelListController controller;
    private ShowProposalRepository mockProposalRepo;
    private DroneModelRepository mockModelRepo;
    private DroneRepository mockDroneRepo;

    @BeforeEach
    void setUp() {
        mockProposalRepo = mock(ShowProposalRepository.class);
        mockModelRepo = mock(DroneModelRepository.class);
        mockDroneRepo = mock(DroneRepository.class);

        controller = new PopulateModelListController(mockProposalRepo, mockModelRepo, mockDroneRepo);
    }

    @Test
    void testListUnassignedShowProposalsReturnsExpectedDTO() {
        ShowProposal p = mock(ShowProposal.class);
        when(p.identity()).thenReturn(1);
        when(p.totalNumDrones()).thenReturn(3);
        when(p.modelList()).thenReturn(Arrays.asList(null, null, mock(DroneModel.class)));

        when(mockProposalRepo.findAll()).thenReturn(List.of(p));

        List<PopulateProposalDTO> result = controller.listUnassignedShowProposals();
        assertEquals(1, result.size());
        assertEquals(2, result.get(0).totalDrones - result.get(0).dronesAssigned);
    }

    @Test
    void testAssignModelToProposalAssignsCorrectly() {
        ShowProposal proposal = mock(ShowProposal.class);
        DroneModel model = mock(DroneModel.class);
        List<DroneModel> modelList = Arrays.asList(null, null, null);

        when(proposal.modelList()).thenReturn(modelList);
        when(mockProposalRepo.findByProposalNumber(1)).thenReturn(Optional.of(proposal));
        when(mockModelRepo.ofIdentity(10L)).thenReturn(Optional.of(model));

        controller.assignModelToProposal(1, 10L, 2);

        verify(mockProposalRepo).save(proposal);
    }

    @Test
    void testCountAvailableOfModelDelegatesToRepo() {
        when(mockDroneRepo.countAvailableOfModelById(5L)).thenReturn(7);
        int count = controller.countAvailableOfModel(5L);
        assertEquals(7, count);
    }

    @Test
    void testGetProposalByNumberReturnsNullIfNotFound() {
        when(mockProposalRepo.findByProposalNumber(99)).thenReturn(Optional.empty());
        assertNull(controller.getProposalByNumber(99));
    }
}

