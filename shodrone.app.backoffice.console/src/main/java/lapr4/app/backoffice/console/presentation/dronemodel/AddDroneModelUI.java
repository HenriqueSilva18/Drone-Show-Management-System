package lapr4.app.backoffice.console.presentation.dronemodel;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.droneModelManagement.application.DroneModelController;
import lapr4.droneModelManagement.domain.Language;

import java.util.Arrays;
import java.util.List;

public class AddDroneModelUI extends AbstractUI {

    private final DroneModelController controller = new DroneModelController();

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
        final double securePrice;
        try {
            securePrice = Double.parseDouble(Console.readLine("Preço de seguro (€):"));
            if (securePrice < 0) {
                System.out.println("O preço do seguro não pode ser negativo.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Preço inválido. Introduz um número válido.");
            return false;
        }


        try {
            controller.registerDroneModel(name, specifications, language, securePrice);
            System.out.println("DroneModel adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return false;
    }





    @Override
    public String headline() {
        return "Adicionar Modelo de Drone";
    }
}
