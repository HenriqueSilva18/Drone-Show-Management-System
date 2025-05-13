package lapr4.app.backoffice.console.presentation.figure;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import lapr4.figureManagement.application.FigureCategoryController;
import lapr4.figureManagement.domain.FigureCategory;
import java.time.LocalDateTime;


public class AddFigureCategoryToCatalogueUI extends AbstractUI {

    private final FigureCategoryController controller = new FigureCategoryController();


    @Override
    protected boolean doShow() {
        System.out.println("=== Add Figure Category to Catalogue ===");

        try {
            final String name = Console.readLine("Name:");

            final String description = Console.readLine("Description:");

            controller.addFigureCategory(name, description);
            System.out.println("✅ Figure added successfully.");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Add Figure Category to Catalogue";
    }
}
