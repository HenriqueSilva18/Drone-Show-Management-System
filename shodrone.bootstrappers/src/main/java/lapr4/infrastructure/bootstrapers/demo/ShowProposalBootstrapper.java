package lapr4.infrastructure.bootstrapers.demo;

import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import lapr4.showProposalManagement.application.AddVideoProposalController;
import lapr4.showProposalManagement.application.ConfigureProposalTemplateController;
import lapr4.showProposalManagement.application.CreateShowProposalController;
import lapr4.showProposalManagement.dto.AddVideoProposalDTO;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShowProposalBootstrapper implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShowProposalBootstrapper.class);
    private final ConfigureProposalTemplateController controller;
    private final CreateShowProposalController createController;
    private final AddVideoProposalController addVideoProposalController;

    public ShowProposalBootstrapper() {
        this.controller = new ConfigureProposalTemplateController();
        this.createController = new CreateShowProposalController();
        this.addVideoProposalController = new AddVideoProposalController();
    }

    @Override
    public boolean execute() {
        registerProposalTemplate("PT");
        registerProposalTemplate("EN");
        registerProposalTemplate("VIP");

        ShowProposalDTO proposal1 = registerShowProposal(100, 5, 41.14961, -8.61099, "2026-07-20", "15:00", 30, "EN");
        ShowProposalDTO proposal2 = registerShowProposal(101, 3, 38.722252, -9.139337, "2026-08-10", "21:00", 20, "PT");
        ShowProposalDTO proposal3 = registerShowProposal(102, 8, 52.520008, 13.404954, "2026-09-01", "20:30", 45, "VIP");

        if (proposal1 != null) {
            addVideo(proposal1.number, "www.shodrone.com/video_proposal_1.mp4");
        }
        if (proposal2 != null) {
            addVideo(proposal2.number, "www.shodrone.com/video_proposal_2.mp4");
        }
        if (proposal3 != null) {
            addVideo(proposal3.number, "www.shodrone.com/video_proposal_3.mp4");
        }

        return true;
    }

    private void registerProposalTemplate(String name) {
        try {
            controller.addProposalTemplate(name);
            LOGGER.info("Bootstrapped Proposal Template: {}", name);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            LOGGER.warn("Assuming template {} already exists", name);
            LOGGER.trace("Assuming existing record", e);
        }
    }

    private ShowProposalDTO registerShowProposal(int showRequestID, int totalDrones, double lat, double lon, String date, String hour, int duration, String templateType) {
        try {
            ShowProposalDTO dto = new ShowProposalDTO(0, null, showRequestID, totalDrones, null, lat, lon, date, hour, duration, null, null, 0, templateType);
            ShowProposalDTO createdProposal = createController.createShowProposal(dto);
            LOGGER.info("Created ShowProposal for ShowRequest ID: {}", showRequestID);

            return createdProposal;
        } catch (final Exception e) {
            LOGGER.error("Error creating ShowProposal for ShowRequest ID {}: {}", showRequestID, e.getMessage());
        }
        return null;
    }

    private void addVideo(int proposalNumber, String videoLink) {
        try {
            AddVideoProposalDTO videoDto = new AddVideoProposalDTO(proposalNumber, videoLink);
            addVideoProposalController.addProposalVideo(videoDto);
            LOGGER.info("Added video to proposal #{}", proposalNumber);
        } catch (final Exception e) {
            LOGGER.error("Error adding video to proposal #{}: {}", proposalNumber, e.getMessage());
        }
    }
}