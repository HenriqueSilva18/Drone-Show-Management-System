package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.presentation.console.AbstractUI;
import lapr4.app.backoffice.console.presentation.utils.ReadValidations;
import lapr4.showProposalManagement.application.ConfigureProposalTemplateController;

import java.util.List;

public class ConfigureProposalTemplateUI extends AbstractUI {

    private final ConfigureProposalTemplateController theController = new ConfigureProposalTemplateController();

    @Override
    protected boolean doShow() {
        System.out.println("Available Proposal Templates:");
        List<String> templates = this.theController.listAvailableTemplates();

        if (templates.isEmpty()) {
            System.out.println("No proposal templates found in 'docs/data/'.");
            return false;
        }

        int index = 1;
        for (String templateName : templates) {
            System.out.printf("%d. %s\n", index++, templateName);
        }

        int choice = ReadValidations.readValidInteger("\nPlease select a template to set as active (or 0 to cancel):", 0);

        if (choice > 0 && choice <= templates.size()) {
            String selectedTemplate = templates.get(choice - 1);
            if (this.theController.setProposalTemplate(selectedTemplate)) {
                System.out.println("\nSuccessfully configured '" + selectedTemplate + "' as the active proposal template.");
            } else {
                System.out.println("\nFailed to configure the template. Please check file permissions or logs.");
            }
        } else {
            System.out.println("\nOperation cancelled.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Configure Proposal Template";
    }
}
