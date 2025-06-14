package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.showProposalManagement.application.ConfigureProposalTemplateController;
import lapr4.showProposalManagement.dto.ProposalTemplateDTO;

import java.util.List;

public class ConfigureProposalTemplateUI extends AbstractUI {

    private final ConfigureProposalTemplateController theController = new ConfigureProposalTemplateController();

    @Override
    protected boolean doShow() {
        try {
            // 1. Listar os templates existentes
            final List<ProposalTemplateDTO> templates = this.theController.listProposalTemplates();

            if (templates.isEmpty()) {
                System.out.println("There are no proposal templates registered in the system to configure.");
                return false;
            }

            // 2. Permitir a seleção de um template
            final SelectWidget<ProposalTemplateDTO> selector = new SelectWidget<>("Select the Proposal Template to configure:", templates);
            selector.show();

            final ProposalTemplateDTO selectedTemplate = selector.selectedElement();

            // 3. Pedir o novo caminho e atualizar se um template for selecionado
            if (selectedTemplate != null) {
                final String newFilePath = Console.readLine("Enter the new file path for the template '" + selectedTemplate.name + "':");

                if (newFilePath.isBlank()) {
                    System.out.println("File path cannot be empty. Operation cancelled.");
                } else {
                    ProposalTemplateDTO updatedTemplate = theController.updateTemplateFilePath(selectedTemplate, newFilePath);
                    System.out.println("\nTemplate updated successfully!");
                    System.out.println("   " + updatedTemplate);
                }
            } else {
                System.out.println("\nNo template selected. Operation cancelled.");
            }

        } catch (final Exception e) {
            System.err.println("An error occurred during the configuration: " + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Configure an Existing Proposal Template";
    }
}