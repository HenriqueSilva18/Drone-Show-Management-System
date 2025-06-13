package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.showProposalManagement.application.AcceptShowProposalController;
import lapr4.showProposalManagement.application.GenerateProposalController;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.dto.ShowProposalDTO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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

        //print showproposal details
        System.out.println("Proposal found:" + proposalDTO);

        String proposalTemplate = controller.readProposalTemplate();

        System.out.println("Using Proposal Template: " + proposalTemplate);

        String showProposal = "";

        switch (proposalTemplate) {
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

        try {
            System.out.println("Saving proposal to file...");
            File directory = new File("docs/ShowProposals");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            String filePath = "docs/ShowProposals/proposal_" + proposalNumber + ".txt";
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
