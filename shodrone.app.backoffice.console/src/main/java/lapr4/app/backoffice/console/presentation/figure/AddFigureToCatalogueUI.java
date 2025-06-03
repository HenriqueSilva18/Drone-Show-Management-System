package lapr4.app.backoffice.console.presentation.figure;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.customermanagement.domain.VAT;
import lapr4.figureManagement.application.FigureCategoryController;
import lapr4.figureManagement.application.FigureController;
import lapr4.figureManagement.domain.FigureCategory;

import java.util.*;

public class AddFigureToCatalogueUI extends AbstractUI {

    private final FigureController controller = new FigureController();
    private final FigureCategoryController categoryController = new FigureCategoryController();
    private final ValidateFigureDescriptionUI validateDslUI = new ValidateFigureDescriptionUI();

    @Override
    protected boolean doShow() {
        System.out.println("\n=== Add Figure to Catalogue ===");

        try {
            final String description = Console.readLine("Description:");

            final FigureCategory category = chooseOrCreateCategory();

            final String keywordsLine = Console.readLine("Keywords (comma-separated):");
            final Set<String> keywords = new HashSet<>(Arrays.asList(
                    keywordsLine.split("\\s*,\\s*")));

            final String vatStr = Console.readLine("Customer VAT (leave empty if public):");
            final VAT vat = vatStr.isBlank() ? null : new VAT(vatStr);

            boolean dslProcessAttempted = validateDslUI.requestAndPerformDslValidation();

            if (!dslProcessAttempted || !validateDslUI.wasDslInputAttemptedAndCompleted()) {
                // Message about cancellation/incompletion already printed by validateDslUI
                System.out.println("Figure addition cancelled due to incomplete DSL information.");
                return false;
            }

            if (!validateDslUI.wasValidationSuccessful()) {
                // Errors already printed by validateDslUI
                System.out.println("Figure addition cancelled due to invalid DSL.");
                return false;
            }
            // --- End of DSL Validation ---

            // DSL is valid, retrieve the code and version
            String dslCode = validateDslUI.getDslCode();
            String dslVersion = validateDslUI.getDslVersion();

            controller.addFigure(description, keywords,true, category, vat, dslCode, dslVersion);
            System.out.println("✅ Figure added successfully.");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        return false; // volta ao menu anterior
    }

    private FigureCategory chooseOrCreateCategory() {
        System.out.println("\n--- Categoria ---");
        System.out.println("1 - Escolher categoria existente");
        System.out.println("2 - Criar nova categoria");
        System.out.println("0 - Cancelar");
        System.out.print("Opção: ");
        int option = Console.readOption(1, 2, 0);

        if (option == 1) {
            return selectExistingCategory();
        } else {
            return createNewCategory();
        }
    }

    private FigureCategory selectExistingCategory() {
        Iterable<FigureCategory> categories = categoryController.listAllActive();
        List<FigureCategory> list = new ArrayList<>();
        categories.forEach(list::add);

        if (list.isEmpty()) {
            System.out.println("⚠️ Não existem categorias. Terá de criar uma.");
            return createNewCategory();
        }

        for (int i = 0; i < list.size(); i++) {
            FigureCategory cat = list.get(i);
            System.out.printf("%d - %s | %s%n", i + 1, cat.name(), cat.description());
        }

        System.out.println("0 - Cancelar");
        System.out.print("Escolha uma categoria (1-" + list.size() + "): ");
        int choice = Console.readOption(1, list.size(), 0);
        return list.get(choice - 1);
    }

    private FigureCategory createNewCategory() {
        final String name = Console.readLine("Nome da nova categoria:");
        final String description = Console.readLine("Descrição:");
        return categoryController.addFigureCategory(name, description);
    }




    @Override
    public String headline() {
        return "Add Figure to Catalogue";
    }

}
