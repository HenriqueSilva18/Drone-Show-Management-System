package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.showProposalManagement.application.AcceptShowProposalController;
import lapr4.showProposalManagement.application.GenerateProposalController;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.ProposalTemplateDTO;
import lapr4.showProposalManagement.dto.ShowProposalDTO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class GenerateProposalUI extends AbstractUI {

    private final GenerateProposalController controller = new GenerateProposalController();

    @Override
    protected boolean doShow() {

        int proposalNumber = Console.readInteger("Enter the Show Proposal Number to accept:");

        Optional<ShowProposalDTO> opt = controller.findNonAcceptedProposalByNumberDTO(proposalNumber);

        System.out.println("\nSearching for Show Proposal with number: " + proposalNumber);

        if (opt.isEmpty()) {
            System.out.println("Proposal not found or already ACCEPTED.");
            return false;
        }

        ShowProposalDTO proposalDTO = opt.get();

        System.out.println("Proposal found:" + proposalDTO);

        String proposalTemplate = proposalDTO.templateType;

        System.out.println("Using Proposal Template: " + proposalTemplate);

        String showProposal = "";


        try {
            ProposalTemplateDTO ptDTO = controller.getFilePathProposalTemplate(proposalTemplate);
            if (ptDTO == null) {
                System.out.println("No template found for the proposal type: " + proposalTemplate);
                return false;
            }

            switch (ptDTO.filePath) {
                case "docs/data/Proposta_mod_01.txt":
                    System.out.println("Using Portuguese Template");
                    showProposal = controller.writeProposalPT(proposalDTO);
                    break;
                case "docs/data/Proposta_mod_02.txt":
                    System.out.println("Using English Template");
                    showProposal = controller.writeProposalEN(proposalDTO);
                    break;
                case "docs/data/Proposta_mod_03.txt":
                    System.out.println("Using VIP Template");
                    showProposal = controller.writeProposalVIP(proposalDTO);
                    break;
                default:
                    System.out.println("Template not found, using default template.");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error retrieving template: " + e.getMessage());
            return false;
        }



        try {
            System.out.println("Saving proposal to file...");
            File directory = new File("docs/ShowProposals");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            String filePath = "docs/ShowProposals/proposal_" + proposalNumber + ".txt";
            //input date by date input manually, NOT .NOW
            LocalDate date = null;
            while (date == null) {
                try {
                    String input = Console.readLine("Enter the date sent (YYYY-MM-DD): ");
                    date = LocalDate.parse(input);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please try again using YYYY-MM-DD.");
                }
            }

            controller.setDateAndManagerSent(proposalDTO, date);

            FileWriter writer = new FileWriter(filePath);

            writer.write(showProposal);
            writer.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        public String headline() {
        return "Generate Show Proposal";
    }
}
