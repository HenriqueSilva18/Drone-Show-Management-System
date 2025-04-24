package lapr4.app.backoffice.console.presentation.customer;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.customermanagement.application.AddCustomerRepresentativeController;
import lapr4.customermanagement.domain.Email;
import lapr4.customermanagement.domain.VAT;

public class AddCustomerRepresentativeUI extends AbstractUI {
    private final AddCustomerRepresentativeController controller = new AddCustomerRepresentativeController();

    @Override
    protected boolean doShow() {
        String vat = Console.readLine("Customer VAT:");
        String name = Console.readLine("Representative Name:");
        String email = Console.readLine("Representative Email:");
        String position = Console.readLine("Position:");
        SystemUser user = AuthzRegistry.authorizationService().session().get().authenticatedUser();


        controller.addRepresentative(new VAT(vat), name, new Email(email), position, user);

        System.out.println("Representative added.");
        return true;
    }

    @Override
    public String headline() {
        return "Add Customer Representative";
    }
}