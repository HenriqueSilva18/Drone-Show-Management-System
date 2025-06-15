package lapr4.showProposalManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.droneModelManagement.domain.Language;
import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.repositories.FigureRepository;
import lapr4.showProposalManagement.domain.Coordinates;
import lapr4.showProposalManagement.domain.FigureInShowProposal;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class AddFigureToProposalControllerTest {

    private AddFigureToProposalController controller;
    private ShowProposalRepository proposalRepo;
    private FigureRepository figureRepo;
    private AuthorizationService authz;


    private Figure sampleFigure;
    private ShowProposal sampleProposal;


    @BeforeEach
    void setUp() {
        proposalRepo = mock(ShowProposalRepository.class);
        figureRepo = mock(FigureRepository.class);
        authz = mock(AuthorizationService.class);
        controller = new AddFigureToProposalController(proposalRepo, figureRepo, authz);

        // Setup fake data
        sampleFigure = mock(Figure.class);
        when(sampleFigure.identity()).thenReturn(1L);
        when(sampleFigure.description()).thenReturn("Test Figure");

        sampleProposal = mock(ShowProposal.class);
        when(sampleProposal.modelList()).thenReturn(new ArrayList<>());

    }

    @Test
    void addFigureToProposal_successfulAdd_shouldSaveProposal() {
        // Arrange
        int proposalId = 1;
        Long figureId = 10L;

        ShowProposal proposal = mock(ShowProposal.class);
        Figure figure = mock(Figure.class);
        Map<DroneType, DroneModel> mapping = new HashMap<>();

        when(proposalRepo.findByProposalNumber(proposalId)).thenReturn(Optional.of(proposal));
        when(figureRepo.findById(figureId)).thenReturn(Optional.of(figure));

        // Act
        controller.addFigureToProposal(proposalId, figureId, mapping);

        // Assert
        verify(proposal).addFigure(figure, mapping);
        verify(proposalRepo).save(proposal);
    }

    @Test
    void addFigureToProposal_invalidProposal_shouldThrowException() {
        // Arrange
        int invalidId = 999;
        when(proposalRepo.findByProposalNumber(invalidId)).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () ->
                controller.addFigureToProposal(invalidId, 1L, new HashMap<>()));
    }

    @Test
    void addFigureToProposal_invalidFigure_shouldThrowException() {
        // Arrange
        int proposalId = 1;
        long invalidFigureId = 999L;

        when(proposalRepo.findByProposalNumber(proposalId)).thenReturn(Optional.of(mock(ShowProposal.class)));
        when(figureRepo.findById(invalidFigureId)).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () ->
                controller.addFigureToProposal(proposalId, invalidFigureId, new HashMap<>()));
    }

    @Test
    void isLastFigureSameAs_shouldReturnTrueIfSame() {
        // Arrange
        int proposalId = 1;
        long figureId = 100L;

        Figure lastFigure = mock(Figure.class);
        when(lastFigure.identity()).thenReturn(figureId);

        ShowProposal proposal = mock(ShowProposal.class);
        when(proposalRepo.findByProposalNumber(proposalId)).thenReturn(Optional.of(proposal));

        FigureInShowProposal last = mock(FigureInShowProposal.class);
        when(last.figure()).thenReturn(lastFigure);
        when(proposal.figuresList()).thenReturn(List.of(last));

        // Act
        boolean result = controller.isLastFigureSameAs(figureId, proposalId);

        // Assert
        assertTrue(result);
    }

    @Test
    void isLastFigureSameAs_shouldReturnFalseIfEmpty() {
        // Arrange
        int proposalId = 1;
        when(proposalRepo.findByProposalNumber(proposalId))
                .thenReturn(Optional.of(mock(ShowProposal.class)));

        when(proposalRepo.findByProposalNumber(proposalId).get().figuresList())
                .thenReturn(Collections.emptyList());

        // Act
        boolean result = controller.isLastFigureSameAs(99L, proposalId);

        // Assert
        assertFalse(result);
    }


    @Test
    void addFigureToProposal_shouldSucceedWithValidInputs() {
        // Arrange
        int proposalId = 100;
        Long figureId = 1L;

        Map<DroneType, DroneModel> droneMapping = new HashMap<>();

        when(proposalRepo.findByProposalNumber(proposalId)).thenReturn(Optional.of(sampleProposal));
        when(figureRepo.findById(figureId)).thenReturn(Optional.of(sampleFigure));

        // Act
        assertDoesNotThrow(() -> controller.addFigureToProposal(proposalId, figureId, droneMapping));

        // Assert
        verify(sampleProposal).addFigure(sampleFigure, droneMapping);
        verify(proposalRepo).save(sampleProposal);
    }

    @Test
    void addFigureToProposal_shouldThrowIfFigureNotFound() {
        // Arrange
        int proposalId = 100;
        Long figureId = 999L;

        when(proposalRepo.findByProposalNumber(proposalId)).thenReturn(Optional.of(sampleProposal));
        when(figureRepo.findById(figureId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                controller.addFigureToProposal(proposalId, figureId, new HashMap<>()));
    }

    @Test
    void getDroneModelByID_shouldReturnCorrectModel() {
        // Arrange
        int proposalId = 1;
        DroneModel model = mock(DroneModel.class);
        when(model.identity()).thenReturn(1L);

        when(proposalRepo.findByProposalNumber(proposalId)).thenReturn(Optional.of(sampleProposal));
        when(sampleProposal.modelList()).thenReturn(List.of(model));

        // Act
        DroneModel result = controller.getDroneModelByID(proposalId, 1L);

        // Assert
        assertEquals(model, result);
    }

    @Test
    void getDroneModelByID_shouldThrowIfNotFound() {
        // Arrange
        int proposalId = 1;
        when(proposalRepo.findByProposalNumber(proposalId)).thenReturn(Optional.of(sampleProposal));
        when(sampleProposal.modelList()).thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> controller.getDroneModelByID(proposalId, 999L));
    }

    @Test
    void getDroneModelByID_shouldReturnModelIfExists() {
        // Arrange
        DroneModel model = mock(DroneModel.class);
        ShowProposal proposal = mock(ShowProposal.class);
        when(proposal.modelList()).thenReturn(List.of(model));
        when(proposalRepo.findByProposalNumber(1)).thenReturn(Optional.of(proposal));

        // Act
        DroneModel result = controller.getDroneModelByID(1, model.identity());

        // Assert
        assertEquals(model, result);
    }

    @Test
    void getDroneModelByID_shouldThrowIfModelNotFound() {
        // Arrange
        ShowProposal proposal = mock(ShowProposal.class);
        when(proposal.modelList()).thenReturn(List.of());
        when(proposalRepo.findByProposalNumber(1)).thenReturn(Optional.of(proposal));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                controller.getDroneModelByID(1, 999L));
    }

    @Test
    void listAllProposals_shouldReturnList() {
        // Arrange
        ShowProposal proposal = mock(ShowProposal.class);
        when(proposal.identity()).thenReturn(1);
        when(proposal.totalNumDrones()).thenReturn(3);
        when(proposal.modelList()).thenReturn(Arrays.asList(mock(DroneModel.class), mock(DroneModel.class), mock(DroneModel.class)));
        when(proposalRepo.findAll()).thenReturn(List.of(proposal));

        // Act
        List<ShowProposalDTO> result = controller.listAllProposals();

        // Assert
        assertEquals(1, result.size());
    }



}
