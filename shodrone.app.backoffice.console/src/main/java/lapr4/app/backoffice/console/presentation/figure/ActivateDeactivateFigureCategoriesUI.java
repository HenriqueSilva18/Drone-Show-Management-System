package lapr4.app.backoffice.console.presentation.figure;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.figureManagement.application.FigureCategoryController;
import lapr4.figureManagement.domain.FigureCategory;

import java.util.ArrayList;
import java.util.List;

public class ActivateDeactivateFigureCategoriesUI extends AbstractUI {

    private final FigureCategoryController controller = new FigureCategoryController();

    @Override
    protected boolean doShow() {
        System.out.println("\n=== Activate / Deactivate Category ===");

        Iterable<FigureCategory> categories = controller.listAll();
        List<FigureCategory> list = new ArrayList<>();
        categories.forEach(list::add);

        if (list.isEmpty()) {
            System.out.println("⚠️ There is not any category available.");
            return false;
        }

        int i = 1;
        for (FigureCategory cat : list) {
            String estado = cat.isActive() ? "Active" : "Inactive";
            System.out.printf("%d - %s | State: %s%n", i, cat.name(), estado);
            i++;
        }

        int option = Console.readInteger("Select a category to change state (1-" + list.size() + "): ");
        FigureCategory selected = list.get(option - 1);

        try {
            FigureCategory updated = controller.toggleCategory(selected.name());
            String novoEstado = updated.isActive() ? "Ativa" : "Inativa";
            System.out.printf("✅ Estado alterado. Nova situação: %s. Última edição: %s%n",
                    novoEstado,
                    updated.lastEditionDate() != null ? updated.lastEditionDate() : "Desconhecida");
        } catch (Exception e) {
            System.out.println("❌ Erro: " + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "";
    }
}
