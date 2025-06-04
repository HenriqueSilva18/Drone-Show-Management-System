package lapr4.showProposalManagement.application;

import lapr4.usermanagement.domain.Roles;
import org.springframework.transaction.annotation.Transactional;

import lapr4.showProposalManagement.dto.ProposalDTO;
import lapr4.showProposalManagement.dto.ListRequestDTO;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import lapr4.showRequestManagement.repositories.ShowRequestRepository;
import lapr4.showRequestManagement.domain.ShowRequest;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CreateProposalController {
    private final ShowProposalRepository showProposalRepository;
    private final ShowRequestRepository showRequestRepository;
    private final AuthorizationService authorizationService;

    public CreateProposalController(
        ShowProposalRepository showProposalRepository,
        ShowRequestRepository showRequestRepository,
        AuthorizationService authorizationService
    ) {
        this.showProposalRepository = showProposalRepository;
        this.showRequestRepository = showRequestRepository;
        this.authorizationService = authorizationService;
    }

    public List<ListRequestDTO> listAvailableShowRequests() {
        authorizationService.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        
        List<ListRequestDTO> dtos = new ArrayList<>();
        Iterable<ShowRequest> requests = showRequestRepository.findAll();
        
        for (ShowRequest request : requests) {
            dtos.add(new ListRequestDTO(
                request.identity().value(),
                request.getNumDrones(),
                request.getDuration(),
                request.getShowDescription(),
                request.getDateValue(),
                request.getStatus(),
                request.getClientVAT().toString()
            ));
        }
        return dtos;
    }

    public Optional<ListRequestDTO> getShowRequestById(int requestId) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        
        Optional<ShowRequest> request = showRequestRepository.findById(requestId);
        if (request.isEmpty()) {
            return Optional.empty();
        }

        ShowRequest req = request.get();
        return Optional.of(new ListRequestDTO(
            req.identity().value(),
            req.getNumDrones(),
            req.getDuration(),
            req.getShowDescription(),
            req.getDateValue(),
            req.getStatus(),
            req.getClientVAT().toString()
        ));
    }

    public boolean validateTotalDrones(int totalDrones) {
        return totalDrones > 0;
    }

    public boolean validateDuration(int durationMinutes) {
        return durationMinutes > 0;
    }

    public boolean validateDate(LocalDate date) {
        return date != null && date.isAfter(LocalDate.now());
    }

    public boolean validateCoordinates(double latitude, double longitude) {
        return latitude >= -90 && latitude <= 90 && longitude >= -180 && longitude <= 180;
    }

    public boolean validateEventHour(String eventHour) {
        if (eventHour == null || eventHour.trim().isEmpty()) {
            return false;
        }
        return eventHour.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
    }

    @Transactional
    public ProposalDTO createProposal(final ProposalDTO dto) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);

        if (dto == null) {
            throw new IllegalArgumentException("Proposal data cannot be null");
        }

        Optional<ShowRequest> request = showRequestRepository.findById(dto.getShowRequestID());
        
        if (request.isEmpty()) {
            throw new IllegalArgumentException("Show request not found");
        }

        if (!validateTotalDrones(dto.getTotalNumDrones())) {
            throw new IllegalArgumentException("Total number of drones must be greater than 0");
        }

        if (!validateDuration(dto.getDurationMinutes())) {
            throw new IllegalArgumentException("Duration must be greater than 0");
        }

        if (!validateDate(dto.getProposalDate())) {
            throw new IllegalArgumentException("Invalid proposal date");
        }

        if (!validateEventHour(dto.getEventHour())) {
            throw new IllegalArgumentException("Invalid event hour format. Use HH:mm (24-hour format)");
        }

        if (!validateCoordinates(dto.getLatitude(), dto.getLongitude())) {
            throw new IllegalArgumentException("Invalid coordinates");
        }

        ShowProposal showProposal = new ShowProposal(
            request.get(), 
            dto.getTotalNumDrones(),
            dto.getDurationMinutes(),
            dto.getProposalDate(),
            dto.getEventHour(),
            dto.getLatitude(),
            dto.getLongitude()
        );

        ShowProposal saved = showProposalRepository.save(showProposal);
        
        return saved.toDTO();
    }
}
