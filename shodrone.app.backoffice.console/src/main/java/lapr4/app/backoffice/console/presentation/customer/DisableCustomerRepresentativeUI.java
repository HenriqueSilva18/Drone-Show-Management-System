package lapr4.app.backoffice.console.presentation.customer;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.customermanagement.application.DisableCustomerRepresentativeController;
import lapr4.customermanagement.domain.Representative;
import lapr4.customermanagement.domain.VAT;
import lapr4.customermanagement.application.ListCustomerRepresentativesController;

import java.util.List;

public class DisableCustomerRepresentativeUI extends AbstractUI {

    private final DisableCustomerRepresentativeController controller = new DisableCustomerRepresentativeController();
    private final ListCustomerRepresentativesController listController = new ListCustomerRepresentativesController();

    @Override
    protected boolean doShow() {
        System.out.println("=== Disable Customer Representative ===");
        final String vatStr = Console.readLine("Customer VAT:");
        final VAT vat = new VAT(vatStr);

        try {
            List<Representative> reps = listController.listRepresentatives(vat).stream()
                    .filter(rep -> rep.user().isActive())
                    .toList();

            if (reps.isEmpty()) {
                System.out.println("No active representatives found.");
                return false;
            }

            for (Representative rep : reps) {
                System.out.printf("[%d] %s | Email: %s%n", rep.identity(), rep.name(), rep.email());
            }

            final int repId = Console.readInteger("Enter Representative ID to disable: ");
            controller.disableRepresentative(vat, repId);
            System.out.println("Representative account disabled successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return true;
    }

    @Override
    public String headline() {
        return "Disable Customer Representative";
    }
}
