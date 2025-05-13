package lapr4.app.backoffice.console.presentation.figure;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.figureManagement.application.FigureCategoryController;
import lapr4.figureManagement.domain.FigureCategory;

import java.util.*;



public class EditFigureCategoryUI extends AbstractUI {

    private final FigureCategoryController controller = new FigureCategoryController();


    @Override
    protected boolean doShow() {
        System.out.println("=== Edit Figure Category ===");

        Iterable<FigureCategory> categories = controller.listAll();
        List<FigureCategory> list = new ArrayList<>();
        categories.forEach(list::add);

        if (list.isEmpty()) {
            System.out.println("⚠️ There is not any category available.");
            return false;
        }

        int i = 1;

        for (FigureCategory cat : list) {
            System.out.printf("%d - Name: %s | Description: %s | Last Edition: %s%n",
                    i, cat.name(), cat.description(),
                    cat.lastEditionDate() != null ? cat.lastEditionDate() : "Never Edited");
            i++;
        }

        int option = Console.readInteger("Select a category to edit (1-" + list.size() + "): ");
        FigureCategory selected = list.get(option - 1);

        final String newDesc = Console.readLine("New description for category '" + selected.name() + "': ");

        try {
            FigureCategory updated = controller.editCategoryDescription(selected.name(), newDesc);
            System.out.println("✅ Category Actualized: " + updated.name());
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        return false;

    }

    @Override
    public String headline() {
        return "Edit Figure Category";
    }
}
