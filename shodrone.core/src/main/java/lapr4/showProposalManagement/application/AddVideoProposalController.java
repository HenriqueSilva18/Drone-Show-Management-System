package lapr4.showProposalManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.validations.Preconditions;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.domain.ShowProposalStatus;
import lapr4.showProposalManagement.dto.AddVideoProposalDTO;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import lapr4.usermanagement.domain.Roles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@UseCaseController
public class AddVideoProposalController {

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final ShowProposalRepository proposalRepository = PersistenceContext.repositories().showProposals();


    public Iterable<ShowProposalDTO> listProposalsForVideoAddition() {
        authorizationService.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.CRM_COLLABORATOR);

        Iterable<ShowProposal> createdProposals = proposalRepository.findByStatus(ShowProposalStatus.CREATED.name());

        return StreamSupport.stream(createdProposals.spliterator(), false)
                .filter(proposal -> proposal.simulationVideoLink() == null || proposal.simulationVideoLink().isEmpty())
                .map(ShowProposal::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ShowProposalDTO addProposalVideo(final AddVideoProposalDTO proposalDTO) {
        this.authorizationService.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        Preconditions.nonNull(proposalDTO, "Proposal DTO cannot be null.");
        Preconditions.nonNull(proposalDTO.proposalNumber, "Proposal ID cannot be null.");
        Preconditions.nonEmpty(proposalDTO.videoLink, "New video link cannot be empty.");

        Optional<ShowProposal> optionalProposal = this.proposalRepository.findByProposalNumber(proposalDTO.proposalNumber);
        if (optionalProposal.isEmpty()) {
            throw new IllegalArgumentException("Proposal with ID " + proposalDTO.proposalNumber + " not found.");
        }

        ShowProposal proposal = optionalProposal.get();

        proposal.changeVideoTo(proposalDTO.videoLink);
        ShowProposal savedProposal = this.proposalRepository.save(proposal);

        return savedProposal.toDTO();
    }
}