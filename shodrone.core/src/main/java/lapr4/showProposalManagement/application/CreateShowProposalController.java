package lapr4.showProposalManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jakarta.transaction.Transactional;
import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.showProposalManagement.domain.Coordinates;
import lapr4.showProposalManagement.domain.ProposalTemplate;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import lapr4.showProposalManagement.repositories.ProposalTemplateRepository;
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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@UseCaseController
public class CreateShowProposalController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();
    private final ShowRequestRepository showRequestRepository = PersistenceContext.repositories().showRequests();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final ProposalTemplateRepository proposalTemplateRepository = PersistenceContext.repositories().templates();

    @Transactional
    public ShowProposalDTO createShowProposal(final ShowProposalDTO dto) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.CRM_COLLABORATOR);

        final ShowRequest showRequest = showRequestRepository.findById(dto.showRequestID)
                .orElseThrow(() -> new IllegalArgumentException("ShowRequest with ID " + dto.showRequestID + " not found."));

        final ProposalTemplate template = proposalTemplateRepository.ofIdentity(dto.templateType)
                .orElseThrow(() -> new IllegalArgumentException("Proposal Template not found: " + dto.templateType));

        final Coordinates eventLocation = new Coordinates(dto.latitude, dto.longitude);
        final LocalDate datePart = LocalDate.parse(dto.eventDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        final LocalTime timePart = LocalTime.parse(dto.eventHour, DateTimeFormatter.ofPattern("HH:mm"));
        final LocalDateTime eventDateTime = LocalDateTime.of(datePart, timePart);

        final ShowProposal newProposal = new ShowProposal(
                showRequest,
                dto.totalNumDrones,
                eventLocation,
                eventDateTime,
                dto.eventDuration,
                template
        );

        showRequest.markAsProposalDone();
        showRequestRepository.save(showRequest);

        return showProposalRepository.save(newProposal).toDTO();
    }

    public String getTemplateTypeForCustomer(String customerVAT) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        Customer customer = customerRepository.findByVAT(customerVAT)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        if ("VIP".equalsIgnoreCase(customer.customerType().toString())) {
            return "VIP";
        } else if ("Portugal".equalsIgnoreCase(customer.address().country())) {
            return "PT";
        } else {
            return "EN";
        }
    }

    public Iterable<ShowRequestDTO> listShowRequests() {
        final Iterable<ShowRequest> showRequests = this.showRequestRepository.findAll();

        return StreamSupport.stream(showRequests.spliterator(), false)
                .map(ShowRequest::toDTO)
                .collect(Collectors.toList());
    }
}