package lapr4.app.backoffice.console.presentation.customer;

import lapr4.customermanagement.application.RegCustomerController;
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

/**
 * UI for registering a new customer.
 */
public class RegCustomerUI extends AbstractUI {

    private final RegCustomerController theController = new RegCustomerController();

    @Override
    protected boolean doShow() {
        System.out.println("=== Customer Registration ===");

        // Basic customer information
        final String vatNumber = Console.readLine("VAT Number:");
        final String name = Console.readLine("Company/Individual Name:");
        final String email = Console.readLine("Email:");
        final String phone = Console.readLine("Phone:");

        // Address information
        System.out.println("\nAddress Information:");
        final String street = Console.readLine("Street:");
        final String city = Console.readLine("City:");
        final String postalCode = Console.readLine("Postal Code:");
        final String country = Console.readLine("Country:");

        // Customer type selection
        final CustomerType customerType = selectCustomerType();
        if (customerType == null) {
            return false;
        }

        // Representative information - at least one is required
        List<Representative> representatives = new ArrayList<>();
        boolean addMore = true;

        System.out.println("\nRepresentative Information (at least one required):");
        while (addMore) {
            addRepresentative(representatives);

            if (!representatives.isEmpty()) {
                String response = Console.readLine("\nAdd another representative? (Y/N)");
                addMore = response.equalsIgnoreCase("Y");
            }
        }

        if (representatives.isEmpty()) {
            System.out.println("Error: At least one representative is required!");
            return false;
        }

        try {
            // Using the controller to register the customer with representatives
            Customer customer = this.theController.registerCustomerWithMultipleRepresentatives(
                    vatNumber,
                    name,
                    new Address(street, city, postalCode, country),
                    email,
                    phone,
                    customerType,
                    representatives);

            System.out.println("\nCustomer registered successfully!");
            System.out.println("Customer VAT: " + customer.identity().toString());
            System.out.println("Number of Representatives: " + customer.representatives().size());

        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("Error: That VAT number is already registered.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    private void addRepresentative(List<Representative> representatives) {
        System.out.println("\nRepresentative #" + (representatives.size() + 1));
        final String repName = Console.readLine("Representative Name:");
        final String repEmail = Console.readLine("Representative Email:");
        final String repPosition = Console.readLine("Representative Position:");

        try {
            Representative rep = new Representative(repName, new Email(repEmail), repPosition);
            representatives.add(rep);
            System.out.println("Representative added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding representative: " + e.getMessage());
            System.out.println("Please try again.");
        }
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
        int counter = 0;

        // Add default "no selection" option
        typeMenu.addItem(MenuItem.of(counter++, "Cancel Selection", () -> {
            selectedTypes.clear();
            return true;  // Return true to exit menu
        }));

        // Add all available customer types
        for (final CustomerType type : theController.getCustomerTypes()) {
            typeMenu.addItem(MenuItem.of(counter++, type.toString(),
                    () -> {
                        selectedTypes.clear();
                        selectedTypes.add(type);
                        return true;  // Return true to exit menu after selection
                    }));
        }
        return typeMenu;
    }

    @Override
    public String headline() {
        return "Register New Customer";
    }
}