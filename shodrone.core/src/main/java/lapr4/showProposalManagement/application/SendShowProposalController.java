package lapr4.showProposalManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.domain.ShowProposalStatus;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import lapr4.usermanagement.domain.Roles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class SendShowProposalController {

    private final ShowProposalRepository repo;
    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    // Production constructor
    public SendShowProposalController() {
        this.repo = PersistenceContext.repositories().showProposals();
    }

    // Test constructor (mock-friendly)
    public SendShowProposalController(ShowProposalRepository repo) {
        this.repo = repo;
    }

    public Iterable<ShowProposalDTO> getAllProposalsToSend() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);

        return repo.findAllProposalsToSendDTO();
    }

    public void sendProposal(ShowProposalDTO proposalDTO) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);

        int proposalNumber = proposalDTO.getNumber();

        if (proposalDTO == null || proposalNumber <= 0) {
            throw new IllegalArgumentException("Invalid proposal to send.");
        }

        Optional<ShowProposal> opt = repo.findByProposalNumber(proposalNumber);
        if (opt.isEmpty()) {
            System.out.println("Proposal not found or without passed simulation.");
            return;
        }

        ShowProposal proposal = opt.get();

        String filePath = "docs/ShowProposals/proposal_" + proposalNumber + ".txt";

        Path path = Paths.get(filePath);

        try {
            String proposalText = Files.readString(path);
            proposal.changeProposalText(proposalText);
            proposal.changeProposalStatus(ShowProposalStatus.PENDENT);
            repo.save(proposal);
            System.out.println("Sending proposal with number: " + proposalNumber);
        } catch (IOException e) {
            System.err.println("Erro ao ler o ficheiro: " + e.getMessage());
        }



    }

}
