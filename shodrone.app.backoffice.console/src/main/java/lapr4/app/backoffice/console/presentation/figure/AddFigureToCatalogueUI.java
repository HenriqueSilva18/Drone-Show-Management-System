package lapr4.app.backoffice.console.presentation.figure;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.customermanagement.domain.VAT;
import lapr4.figureManagement.application.FigureController;
import lapr4.figureManagement.domain.FigureCategory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AddFigureToCatalogueUI extends AbstractUI {

    private final FigureController controller = new FigureController();

    @Override
    protected boolean doShow() {
        System.out.println("\n=== Add Figure to Catalogue ===");

        try {
            final String description = Console.readLine("Description:");

            final String categoryName = Console.readLine("Category:");
            final FigureCategory category = new FigureCategory(categoryName);

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

    @Override
    public String headline() {
        return "Add Figure to Catalogue";
    }
}