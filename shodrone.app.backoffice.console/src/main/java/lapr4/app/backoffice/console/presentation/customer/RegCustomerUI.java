package lapr4.app.backoffice.console.presentation.customer;

import lapr4.customermanagement.application.RegCustomerController;
import lapr4.customermanagement.application.RegCustomerController.RepresentativeData;
import lapr4.customermanagement.domain.*;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RegCustomerUI extends AbstractUI {

    private final RegCustomerController theController = new RegCustomerController();

    @Override
    protected boolean doShow() {
        System.out.println("=== Customer Registration ===");

        final String vatNumber = Console.readLine("VAT Number:");
        final String name = Console.readLine("Company/Individual Name:");
        final String email = Console.readLine("Email:");
        final String phone = Console.readLine("Phone:");

        System.out.println("\nAddress Information:");
        final String street = Console.readLine("Street:");
        final String city = Console.readLine("City:");
        final String postalCode = Console.readLine("Postal Code:");
        final String country = Console.readLine("Country:");

        System.out.println("\nCustomer Type:");
        final CustomerType customerType = selectCustomerType();
        if (customerType == null) {
            return false;
        }

        List<RepresentativeData> representativesData = new ArrayList<>();
        boolean addMore = true;

        System.out.println("\nRepresentative Information (at least one required):");
        while (addMore) {
            RepresentativeData repData = Utils.collectRepresentativeData();

            if (repData != null) {
                representativesData.add(repData);
                System.out.println("Representative information collected successfully!");

                String response = Console.readLine("\nAdd another representative? (Y/N)");
                addMore = response.equalsIgnoreCase("Y");
            }
        }

        if (representativesData.isEmpty()) {
            System.out.println("Error: At least one representative is required!");
            return false;
        }

        try {
            if (theController.customerExists(vatNumber)) {
                System.out.println("\nError: A customer with VAT " + vatNumber + " already exists in the system!");
                System.out.println("Please try again with a different VAT number.");
                return false;
            }

            Customer customer = this.theController.registerCustomerWithMultipleRepresentatives(
                    vatNumber,
                    name,
                    new Address(street, city, postalCode, country),
                    email,
                    phone,
                    customerType,
                    representativesData);

            System.out.println("\nCustomer registered successfully!");
            System.out.println("Customer VAT: " + customer.identity().toString());
            System.out.println("Number of Representatives: " + customer.representatives().size());

        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            if (e.getMessage().contains("VAT")) {
                System.out.println("Please try again with a different VAT number.");
            } else if (e.getMessage().contains("NIF")) {
                System.out.println("Please try again with different NIFs for the representatives.");
            }
        }

        return false;
    }

    private CustomerType selectCustomerType() {
        final Set<CustomerType> selectedTypes = new HashSet<>();
        boolean validSelection = showCustomerTypes(selectedTypes);

        if (!validSelection || selectedTypes.isEmpty()) {
            System.out.println("No customer type selected!");
            return null;
        }
        return selectedTypes.iterator().next();
    }

    private boolean showCustomerTypes(final Set<CustomerType> selectedTypes) {
        final Menu typeMenu = buildCustomerTypeMenu(selectedTypes);
        final MenuRenderer renderer = new VerticalMenuRenderer(typeMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildCustomerTypeMenu(final Set<CustomerType> selectedTypes) {
        final Menu typeMenu = new Menu();
        int counter = 1;

        for (final CustomerType type : theController.getCustomerTypes()) {
            typeMenu.addItem(MenuItem.of(counter++, type.toString(),
                    () -> {
                        selectedTypes.clear();
                        selectedTypes.add(type);
                        return true;
                    }));
        }
        return typeMenu;
    }

    @Override
    public String headline() {
        return "Register New Customer";
    }
}
