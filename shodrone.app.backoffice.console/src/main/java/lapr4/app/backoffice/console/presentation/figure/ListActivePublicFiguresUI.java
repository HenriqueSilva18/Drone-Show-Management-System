package lapr4.app.backoffice.console.presentation.figure;

import eapli.framework.presentation.console.AbstractUI;
import lapr4.figureManagement.application.FigureController;
import lapr4.figureManagement.domain.Figure;

public class ListActivePublicFiguresUI extends AbstractUI {

    private final FigureController controller = new FigureController();

    @Override
    protected boolean doShow() {
        System.out.println("\n=== List of Active Public Figures ===");

        try {
            Iterable<Figure> figures = controller.listActivePublicFigures();

            boolean foundAny = false;
            for (Figure f : figures) {
                foundAny = true;
                System.out.printf("ID: %d | Desc: %s | VAT: %s | %s\n",
                        f.identity(),
                        f.description(),
                        f.clientVAT().toString(),
                        f.isExclusive() ? "Exclusive" : "Public");
            }

            if (!foundAny) {
                System.out.println("⚠️  No active public figures found.");
            }

        } catch (Exception e) {
            System.out.println("⚠️  Error while listing figures: " + e.getMessage());
        }

        return false; // volta ao menu principal
    }

    @Override
    public String headline() {
        return "List Active Public Figures";
    }
}