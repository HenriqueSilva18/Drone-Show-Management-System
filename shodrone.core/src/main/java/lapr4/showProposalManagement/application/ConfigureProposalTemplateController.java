package lapr4.showProposalManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showProposalManagement.domain.ProposalTemplate;
import lapr4.showProposalManagement.dto.ProposalTemplateDTO;
import lapr4.showProposalManagement.repositories.ProposalTemplateRepository;
import lapr4.usermanagement.domain.Roles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UseCaseController
public class ConfigureProposalTemplateController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TransactionalContext tx = PersistenceContext.repositories().newTransactionalContext();
    private final ProposalTemplateRepository repo = PersistenceContext.repositories().templates();

    public List<ProposalTemplateDTO> listProposalTemplates() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_MANAGER);
        final List<ProposalTemplateDTO> dtoList = new ArrayList<>();
        final Iterable<ProposalTemplate> templates = this.repo.findAll();
        templates.forEach(template -> dtoList.add(template.toDTO()));
        return dtoList;
    }

    public ProposalTemplateDTO updateTemplateFilePath(ProposalTemplateDTO templateDTO, String newFilePath) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_MANAGER);

        tx.beginTransaction();
        final Optional<ProposalTemplate> optTemplate = this.repo.ofIdentity(templateDTO.name);

        if (optTemplate.isEmpty()) {
            tx.rollback();
            throw new IllegalArgumentException("Template with name '" + templateDTO.name + "' not found.");
        }

        final ProposalTemplate template = optTemplate.get();
        template.changeFilePath(newFilePath);
        final ProposalTemplate savedTemplate = this.repo.save(template);
        tx.commit();

        return savedTemplate.toDTO();
    }

    public void addProposalTemplate(String name) {
        final ProposalTemplate newTemplate = new ProposalTemplate(name);
        this.repo.save(newTemplate);
    }
}