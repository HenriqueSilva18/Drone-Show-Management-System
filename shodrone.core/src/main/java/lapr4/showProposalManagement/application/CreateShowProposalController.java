package lapr4.showProposalManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jakarta.transaction.Transactional;
import lapr4.showProposalManagement.domain.Coordinates;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import lapr4.showRequestManagement.domain.ShowRequest;
import lapr4.showRequestManagement.dto.ShowRequestDTO;
import lapr4.showRequestManagement.repositories.ShowRequestRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.usermanagement.domain.Roles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@UseCaseController
public class CreateShowProposalController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();
    private final ShowRequestRepository showRequestRepository = PersistenceContext.repositories().showRequests();

    @Transactional
    public ShowProposalDTO createShowProposal(final ShowProposalDTO dto) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.CRM_COLLABORATOR);

        final ShowRequest showRequest = showRequestRepository.findById(dto.showRequestID)
                .orElseThrow(() -> new IllegalArgumentException("ShowRequest with ID " + dto.showRequestID + " not found."));

        final Coordinates eventLocation = new Coordinates(dto.latitude, dto.longitude);

        final LocalDate datePart = LocalDate.parse(dto.eventDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        final LocalTime timePart = LocalTime.parse(dto.eventHour, DateTimeFormatter.ofPattern("HH:mm"));
        final LocalDateTime eventDateTime = LocalDateTime.of(datePart, timePart);

        final ShowProposal newProposal = new ShowProposal(
                showRequest,
                dto.totalNumDrones,
                eventLocation,
                eventDateTime,
                dto.eventDuration
        );

        return showProposalRepository.save(newProposal).toDTO();
    }

    public Iterable<ShowRequestDTO> listShowRequests() {
        final Iterable<ShowRequest> showRequests = this.showRequestRepository.findAll();

        return StreamSupport.stream(showRequests.spliterator(), false)
                .map(ShowRequest::toDTO)
                .collect(Collectors.toList());
    }
}