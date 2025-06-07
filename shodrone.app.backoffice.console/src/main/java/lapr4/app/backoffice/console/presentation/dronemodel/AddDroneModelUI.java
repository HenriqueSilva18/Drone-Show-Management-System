package lapr4.app.backoffice.console.presentation.dronemodel;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.droneModelManagement.application.DroneModelController;
import lapr4.droneModelManagement.application.DroneTypeController;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.droneModelManagement.domain.Language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddDroneModelUI extends AbstractUI {

    private final DroneModelController controller = new DroneModelController();
    private final DroneTypeController typeController = new DroneTypeController();

    @Override
    protected boolean doShow() {
        final String name = Console.readLine("Nome do modelo:");

        final String languageInput = Console.readLine("Linguagem suportada:");
        Language language;
        try {
            language = Language.valueOf(languageInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Linguagem inválida. Exemplo: JAVA, PYTHON, C");
            return false;
        }

        final String specsInput = Console.readLine("Especificações (separadas por vírgula):");
        List<String> specifications = Arrays.stream(specsInput.split(","))
                .map(String::trim)
                .toList();


        DroneType droneType = chooseOrCreateDroneType();

        try {
            controller.registerDroneModel(name, specifications, language, droneType);
            System.out.println("DroneModel adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return false;
    }


    private DroneType chooseOrCreateDroneType() {
        System.out.println("\n--- Drone Type ---");
        System.out.println("1 - Choose existing drone type");
        System.out.println("2 - Create new drone type");
        System.out.println("0 - Cancel");
        System.out.print("Option: ");
        int option = Console.readOption(1, 2, 0);

        if (option == 1) {
            return selectExistingDroneType();
        } else {
            return createNewDroneType();
        }
    }

    private DroneType selectExistingDroneType() {
        Iterable<DroneType> droneTypes = typeController.listAllTypes();
        List<DroneType> list = new ArrayList<>();
        droneTypes.forEach(list::add);

        if (list.isEmpty()) {
            System.out.println("⚠️ Não existem categorias. Terá de criar uma.");
            return createNewDroneType();
        }

        for (int i = 0; i < list.size(); i++) {
            DroneType type = list.get(i);
            System.out.printf("%d - %s | %s%n", i + 1, type.getName(), type.getDescription());
        }

        System.out.println("0 - Cancelar");
        System.out.print("Escolha uma categoria (1-" + list.size() + "): ");
        int choice = Console.readOption(1, list.size(), 0);
        return list.get(choice - 1);
    }

    private DroneType createNewDroneType() {
        final String name = Console.readLine("Nome da nova categoria:");
        final String description = Console.readLine("Descrição:");
        return typeController.registerDroneType(name, description);
    }



    @Override
    public String headline() {
        return "Adicionar Modelo de Drone";
    }
}
