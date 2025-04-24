package lapr4.app.backoffice.console.presentation.customer;


import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.io.util.Console;
import lapr4.customermanagement.application.*;
import lapr4.customermanagement.domain.*;
import lapr4.infrastructure.authz.AuthenticationCredentialHandler;


import java.util.List;

class CustomerRepresentativeUI {

    public static class AddCustomerRepresentativeUI extends AbstractUI {
        private final AddCustomerRepresentativeController controller = new AddCustomerRepresentativeController();

        @Override
        protected boolean doShow() {
            final String vat = Console.readLine("Customer VAT:");
            final String name = Console.readLine("Representative Name:");
            final String email = Console.readLine("Representative Email:");
            final String position = Console.readLine("Representative Position:");

            SystemUser user = AuthzRegistry.authorizationService().session().get().authenticatedUser();


            controller.addRepresentative(new VAT(vat), name, new Email(email), position, user);
            System.out.println("Representative added successfully.");
            return true;
        }

        @Override
        public String headline() {
            return "Add Customer Representative";
        }
    }

    public static class ListCustomerRepresentativesUI extends AbstractUI {
        private final ListCustomerRepresentativesController controller = new ListCustomerRepresentativesController();

        @Override
        protected boolean doShow() {
            final String vat = Console.readLine("Customer VAT:");
            final List<Representative> reps = (List<Representative>) controller.listRepresentatives(new VAT(vat));

            if (reps.isEmpty()) {
                System.out.println("No representatives found.");
            } else {
                reps.forEach(rep -> System.out.printf("[%d] %s (%s)%n", rep.identity(), rep.name(), rep.email()));
            }
            return true;
        }

        @Override
        public String headline() {
            return "List Customer Representatives";
        }
    }

    public static class EditCustomerRepresentativeUI extends AbstractUI {
        private final EditCustomerRepresentativeController controller = new EditCustomerRepresentativeController();

        @Override
        protected boolean doShow() {
            final String vat = Console.readLine("Customer VAT:");
            final int id = Console.readInteger("Representative ID:");
            final String newEmail = Console.readLine("New Email:");
            final String newPosition = Console.readLine("New Position:");

            controller.editRepresentative(new VAT(vat), id, new Email(newEmail), newPosition);
            System.out.println("Representative updated.");
            return true;
        }

        @Override
        public String headline() {
            return "Edit Customer Representative";
        }
    }

    public static class DisableCustomerRepresentativeUI extends AbstractUI {
        private final DisableCustomerRepresentativeController controller = new DisableCustomerRepresentativeController();

        @Override
        protected boolean doShow() {
            final String vat = Console.readLine("Customer VAT:");
            final int id = Console.readInteger("Representative ID to disable:");

            controller.disableRepresentative(new VAT(vat), id);
            System.out.println("Representative disabled.");
            return true;
        }

        @Override
        public String headline() {
            return "Disable Customer Representative";
        }
    }
}
