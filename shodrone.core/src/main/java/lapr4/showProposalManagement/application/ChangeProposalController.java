package lapr4.showProposalManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.validations.Preconditions;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.ProposalDTO;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import lapr4.usermanagement.domain.Roles;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UseCaseController
@Component
public class ChangeProposalController {

    private final ShowProposalRepository proposalRepository;
    private final AuthorizationService authorizationService;

    public ChangeProposalController(ShowProposalRepository showProposalRepository, AuthorizationService authorizationService) {
        this.proposalRepository = showProposalRepository;
        this.authorizationService = authorizationService;
    }

    public Iterable<ProposalDTO> allProposals() {
        this.authorizationService.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        Iterable<ShowProposal> proposals = this.proposalRepository.findAll();
        List<ProposalDTO> dtos = new ArrayList<>();
        proposals.forEach(p -> dtos.add(p.toDTO()));
        return dtos;
    }

    @Transactional
    public ProposalDTO changeProposalVideo(final Integer proposalId, final String newVideoLink) {
        this.authorizationService.ensureAuthenticatedUserHasAnyOf(
                Roles.POWER_USER, Roles.CRM_COLLABORATOR);
        Preconditions.nonNull(proposalId, "Proposal ID cannot be null.");
        Preconditions.nonEmpty(newVideoLink, "New video link cannot be empty. Please provide a valid link.");

        Optional<ShowProposal> optionalProposal = this.proposalRepository.findByProposalNumber(proposalId);
        if (optionalProposal.isEmpty()) {
            throw new IllegalArgumentException("Proposal with ID " + proposalId + " not found.");
        }

        ShowProposal proposal = optionalProposal.get();
        proposal.changeVideoTo(newVideoLink);
        ShowProposal savedProposal = this.proposalRepository.save(proposal);

        return savedProposal.toDTO();
    }
}
