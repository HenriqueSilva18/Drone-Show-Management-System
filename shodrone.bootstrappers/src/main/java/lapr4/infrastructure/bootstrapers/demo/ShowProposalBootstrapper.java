package lapr4.infrastructure.bootstrapers.demo;

import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showProposalManagement.application.ConfigureProposalTemplateController;
import lapr4.showProposalManagement.domain.ProposalTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShowProposalBootstrapper implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShowProposalBootstrapper.class);
    private final ConfigureProposalTemplateController controller;

    public ShowProposalBootstrapper() {
        this.controller = new ConfigureProposalTemplateController();
    }

    @Override
    public boolean execute() {
        // Template PT
        registerProposalTemplate("PT");
        // Template EN
        registerProposalTemplate("EN");
        // Template VIP
        registerProposalTemplate("VIP");
        return true;
    }

    private void registerProposalTemplate(String name) {
        try {
            controller.addProposalTemplate(name);
            LOGGER.info("Bootstrapped Proposal Template: {}", name);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring bootstrap debug problems
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", name);
            LOGGER.trace("Assuming existing record", e);
        }
    }
}