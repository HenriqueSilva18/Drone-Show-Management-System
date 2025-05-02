package lapr4.app.backoffice.console.presentation.customer;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;
import lapr4.customermanagement.application.EditCustomerRepresentativeController;
import lapr4.customermanagement.domain.Email;
import lapr4.customermanagement.domain.VAT;

public class EditCustomerRepresentativeUI extends AbstractUI {
    private final EditCustomerRepresentativeController controller = new EditCustomerRepresentativeController();

    @Override
    protected boolean doShow() {
        System.out.println("=== Edit Customer Representative ===");
        final String vat = Console.readLine("Customer VAT:");
        final Integer repId = Console.readInteger("Representative ID:");

        final String newEmail = Console.readLine("New Email:");
        final String newPosition = Console.readLine("New Position:");

        try {
            controller.editRepresentative(new VAT(vat), repId, new Email(newEmail), newPosition);
            System.out.println("Representative contact information updated successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Edit Customer Representative";
    }
}
