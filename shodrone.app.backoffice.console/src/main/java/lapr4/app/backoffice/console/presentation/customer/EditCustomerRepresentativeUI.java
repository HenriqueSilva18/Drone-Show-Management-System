package lapr4.app.backoffice.console.presentation.customer;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;
import lapr4.customermanagement.application.EditCustomerRepresentativeController;
import lapr4.customermanagement.domain.Email;
import lapr4.customermanagement.domain.Phone;
import lapr4.customermanagement.domain.VAT;

public class EditCustomerRepresentativeUI extends AbstractUI {
    private final EditCustomerRepresentativeController controller = new EditCustomerRepresentativeController();

    @Override
    protected boolean doShow() {
        System.out.println("=== Edit Customer Representative ===");
        final String vat = Console.readLine("Customer VAT:");
        final String repNIF = Console.readLine("Representative NIF:");

        final String emailText = Console.readLine("New Email (leave blank to keep current):");
        final String phoneText = Console.readLine("New Phone (leave blank to keep current):");

        Email newEmail = emailText.isBlank() ? null : new Email(emailText);
        Phone newPhone = phoneText.isBlank() ? null : new Phone(phoneText);

        try {
            controller.editRepresentative(
                    new VAT(vat),
                    repNIF,
                    newEmail,
                    newPhone
            );
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
