package lapr4.app.backoffice.console.presentation.figure;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.figureManagement.application.FigureCategoryController;
import lapr4.figureManagement.domain.FigureCategory;

public class ListFigureCategoriesUI extends AbstractUI {

    private final FigureCategoryController controller = new FigureCategoryController();

    @Override
    protected boolean doShow() {
        System.out.println("=== List Figure Category ===");

        Iterable<FigureCategory> categories = controller.listAll();

        if (!categories.iterator().hasNext()) {
            System.out.println("⚠️ Nenhuma categoria encontrada.");
        } else {
            for (FigureCategory cat : categories) {
                System.out.println("• " + cat.toString());
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "";
    }

}
