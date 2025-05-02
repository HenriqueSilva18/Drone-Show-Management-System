package lapr4.app.backoffice.console.presentation.figure;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.figureManagement.application.FigureController;
import lapr4.figureManagement.domain.Figure;

public class SearchFigureCatalogueUI extends AbstractUI {

    private final FigureController controller = new FigureController();

    public SearchFigureCatalogueUI() {}

    @Override
    protected boolean doShow() {
        System.out.println("\n=== Search Figure Catalogue ===\n");

        String searchTerm = Console.readLine("Enter category or keyword to search: ");

        Iterable<Figure> results = controller.search(searchTerm);

        int count = 0;
        System.out.println("\n=== Search Results ===\n");

        for (Figure figure : results) {
            count++;
            System.out.printf("%d. %s\n", count, figure.description());
            System.out.printf("   Category: %s\n", figure.category().toString());
            System.out.printf("   Exclusive: %s\n", figure.isExclusive() ? "Yes" : "No");
            System.out.println();
        }

        if (count == 0) {
            System.out.println("No figures found matching the search criteria.");
        } else {
            System.out.printf("Found %d figure(s) matching the search criteria.\n", count);
        }

        return false;
    }

    @Override
    public String headline() {
        return "Search Figure Catalogue";
    }
}