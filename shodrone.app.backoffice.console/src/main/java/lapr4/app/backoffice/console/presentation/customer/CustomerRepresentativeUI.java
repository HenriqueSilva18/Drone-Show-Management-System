package lapr4.app.backoffice.console.presentation.customer;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;
import lapr4.customermanagement.application.*;
import lapr4.customermanagement.domain.*;
import lapr4.customermanagement.application.RegCustomerController.RepresentativeData;

import java.util.List;

class CustomerRepresentativeUI {

    public static class AddCustomerRepresentativeUI extends AbstractUI {
        private final AddCustomerRepresentativeController controller = new AddCustomerRepresentativeController();

        @Override
        protected boolean doShow() {
            System.out.println("=== Add Customer Representative ===");
            final String customerVAT = Console.readLine("Customer VAT:");

            RepresentativeData repData = Utils.collectRepresentativeData();

            try {
                controller.addRepresentative(customerVAT, repData);
                System.out.println("Representative added successfully.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
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
            System.out.println("=== List Active Customer Representatives ===");
            final String vat = Console.readLine("Customer VAT:");

            try {
                final List<Representative> reps = controller.listRepresentatives(new VAT(vat));
                if (reps.isEmpty()) {
                    System.out.println("No active representatives found.");
                } else {
                    reps.forEach(rep -> System.out.printf("[%d] %s | Email: %s ",
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

    public static class EditCustomerRepresentativeUI extends AbstractUI {
        private final EditCustomerRepresentativeController controller = new EditCustomerRepresentativeController();

        @Override
        protected boolean doShow() {
            System.out.println("=== Edit Customer Representative ===");
            final String vat = Console.readLine("Customer VAT:");
            final Integer repId = Console.readInteger("Representative ID:");

            final String newEmail = Console.readLine("New Email:");
            final String newPosition = Console.readLine("New Position:");

            try {
                controller.editRepresentative(new VAT(vat), repId, new Email(newEmail) , newPosition);
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


    public static class DisableCustomerRepresentativeUI extends AbstractUI {
        private final DisableCustomerRepresentativeController controller = new DisableCustomerRepresentativeController();

        @Override
        protected boolean doShow() {
            System.out.println("=== Disable Customer Representative ===");
            final String vat = Console.readLine("Customer VAT:");
            final Integer repId = Console.readInteger("Representative ID to disable:");

            try {
                controller.disableRepresentative(new VAT(vat), repId);
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
}
