package lapr4.app.backoffice.console.presentation.customer;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;
import lapr4.customermanagement.application.DisableCustomerRepresentativeController;
import lapr4.customermanagement.domain.VAT;

public class DisableCustomerRepresentativeUI extends AbstractUI {
    private final DisableCustomerRepresentativeController controller = new DisableCustomerRepresentativeController();

    @Override
    protected boolean doShow() {
        System.out.println("=== Disable Customer Representative ===");
        final String vat = Console.readLine("Customer VAT:");
        final String repNIF = Console.readLine("Representative NIF to disable:");

        try {
            controller.disableRepresentative(new VAT(vat), repNIF);
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
