package lapr4.app.backoffice.console.presentation.figure;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.figureManagement.application.FigureController;
import lapr4.figureManagement.domain.Figure;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DecommissionFigureUI extends AbstractUI {

    private final FigureController controller = new FigureController();

    @Override
    protected boolean doShow() {
        System.out.println("\n=== Decommission Figure ===");

        try {
            Long id = Console.readLong("Enter Figure ID to decommission:");
            Figure fig = controller.findFigureById(id);

            Figure decommissionedFigure = controller.decommissionFigure(fig);

            System.out.printf("✅ Figure %d decommissioned on %s%n",
                    decommissionedFigure.identity(), decommissionedFigure.getDecommissionDate());
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Decommission Figure";
    }
}
