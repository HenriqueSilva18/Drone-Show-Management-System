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

            controller.addFigure(description, true, category, vat);
            System.out.println("✅ Figure added successfully.");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        return false; // volta ao menu anterior
    }

    private FigureCategory chooseOrCreateCategory() {
        System.out.println("\n--- Category ---");
        System.out.println("1 - Choose existing category");
        System.out.println("2 - Create new category");
        System.out.println("0 - Cancel");
        System.out.print("Option: ");
        int option = Console.readOption(1, 2, 0);

        if (option == 1) {
            return selectExistingCategory();
        } else if (option == 2) {
            return createNewCategory();
        } else if (option == 0) {
            return null; // Cancel
        } else {
            throw new IllegalArgumentException("Invalid option");
        }
    }

    private FigureCategory selectExistingCategory() {
        Iterable<FigureCategory> categories = categoryController.listAllActive();
        List<FigureCategory> list = new ArrayList<>();
        categories.forEach(list::add);

        if (list.isEmpty()) {
            System.out.println("⚠️ There are not any categories available. You must create one first.");
            return createNewCategory();
        }

        for (int i = 0; i < list.size(); i++) {
            FigureCategory cat = list.get(i);
            System.out.printf("%d - %s | %s%n", i + 1, cat.name(), cat.description());
        }

        System.out.println("0 - Cancel");
        System.out.print("Choose a category  (1-" + list.size() + "): ");
        int choice = Console.readOption(1, list.size(), 0);
        return list.get(choice - 1);
    }

    private FigureCategory createNewCategory() {
        final String name = Console.readLine("New category name:");
        final String description = Console.readLine("Description:");
        return categoryController.addFigureCategory(name, description);
    }




    @Override
    public String headline() {
        return "Add Figure to Catalogue";
    }
}
