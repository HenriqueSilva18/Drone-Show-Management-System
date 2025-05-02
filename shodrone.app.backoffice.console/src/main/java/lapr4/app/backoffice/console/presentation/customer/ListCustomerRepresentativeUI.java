// ListCustomerRepresentativesUI.java
package lapr4.app.backoffice.console.presentation.customer;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;
import lapr4.customermanagement.application.*;
import lapr4.customermanagement.domain.*;

import java.util.List;

public class ListCustomerRepresentativeUI extends AbstractUI {
    private final ListCustomerRepresentativesController controller = new ListCustomerRepresentativesController();

    @Override
    protected boolean doShow() {
        System.out.println("=== List Active Customer Representatives ===");
        final String vat = Console.readLine("Customer VAT:");

        try {
            final List<Representative> reps = controller.listRepresentatives(new VAT(vat));
            if (reps.isEmpty()) {
                System.out.println("No active representatives found.");
            } else {
                reps.forEach(rep -> System.out.printf("[%d] %s | Email: %s %n",
                        rep.identity(), rep.name(), rep.email()));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "List Customer Representatives";
    }
}
