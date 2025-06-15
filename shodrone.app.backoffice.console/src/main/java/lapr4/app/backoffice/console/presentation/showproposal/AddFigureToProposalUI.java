package lapr4.app.backoffice.console.presentation.showproposal;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.droneModelManagement.domain.dto.DroneModelDTO;
import lapr4.figureManagement.dto.FigureDTO;
import lapr4.showProposalManagement.application.AddFigureToProposalController;
import lapr4.showProposalManagement.dto.ShowProposalDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddFigureToProposalUI extends AbstractUI {

    private final AddFigureToProposalController ctrl = new AddFigureToProposalController();

    @Override
    protected boolean doShow() {
        // 1. Selecionar proposta
        List<ShowProposalDTO> proposals = ctrl.listAllProposals();

        if (proposals.isEmpty()) {
            System.out.println("There are no proposals available.");
            return false;
        }

        System.out.println(":Available Proposals:");
        int index = 1;
        for (ShowProposalDTO dto : proposals) {
            System.out.printf("%d - Proposal #%d, Client: %s, Date: %s%n",
                    index++, dto.number, dto.customerVAT, dto.eventDate);
        }

        int pos = Console.readInteger("Select a proposal (1-" + proposals.size() + "): ");
        ShowProposalDTO selectedProposal = proposals.get(pos - 1);

        List<FigureDTO> figures = ctrl.availableActiveFigures();

        if (figures.isEmpty()) {
            System.out.println("No figure available.");
            return false;
        }

        System.out.println("Available Figures:");
        for (FigureDTO dto : figures) {
            System.out.printf("[%d] %s%n", dto.id, dto.description);
        }

        Long figureId = Console.readLong("Choose Figure ID:");

        // 3. Obter tipos de drone da figure
        List<DroneType> requiredTypes = ctrl.droneTypesOfFigure(figureId);

        // 4. Mostrar modelos disponíveis na proposta
        List<DroneModelDTO> models = ctrl.availableModels(selectedProposal.number);
        if (models.isEmpty()) {
            System.out.println("There are no drone models available for this proposal.");
            return false;
        }

        // ❗ Verificação: figura repetida consecutivamente
        if (ctrl.isLastFigureSameAs(figureId, selectedProposal.number)) {
            System.out.println("❌ Cannot add the same figure in consecutive positions.");
            return false;
        }

        // 5. Mapeamento dos tipos para modelos
        Map<DroneType, DroneModel> droneMapping = new HashMap<>();

        for (DroneType type : requiredTypes) {
            System.out.printf("Drone Type: %s - %s%n", type.name(), type.description());

            for (int i = 0; i < models.size(); i++) {
                DroneModelDTO model = models.get(i);
                System.out.printf("%d - %s%n", i + 1, model.name);
            }

            int option = Console.readInteger("Choose the number of the model:");
            DroneModelDTO selectedModelDTO = models.get(option - 1);

            DroneModel selectedModel = ctrl.getDroneModelByID(selectedProposal.number, selectedModelDTO.id);

            droneMapping.put(type, selectedModel);
        }


        try {
            ctrl.addFigureToProposal(selectedProposal.number, figureId, droneMapping);
            System.out.println("✅ Figure added successfully to the proposal.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Add Figure to Proposal";
    }
}
