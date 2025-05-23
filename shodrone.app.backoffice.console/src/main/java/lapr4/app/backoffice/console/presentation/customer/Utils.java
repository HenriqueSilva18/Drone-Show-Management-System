package lapr4.app.backoffice.console.presentation.customer;

import eapli.framework.io.util.Console;
import lapr4.customermanagement.application.RegCustomerController.RepresentativeData;

public class Utils {
	public static RepresentativeData collectRepresentativeData() {
        try {
            System.out.println("\nRepresentative Information:");
            final String firstName = Console.readLine("First Name:");
            final String lastName = Console.readLine("Last Name:");
            final String nif = Console.readLine("Representative NIF:");
            final String email = Console.readLine("Representative Email:");
            final String phone = Console.readLine("Representative Phone:");
            final String position = Console.readLine("Representative Position:");

            System.out.println("\nSystem User Information:");
            final String username = Console.readLine("Username:");
            final String password = Console.readLine("Password:");


            if (email.isBlank() || position.isBlank() || nif.isBlank() || phone.isBlank() ||
                    username.isBlank() || password.isBlank() || firstName.isBlank() || lastName.isBlank()) {
                System.out.println("Error: All fields are required!");
                return null;
            }

            return new RepresentativeData(firstName+" "+lastName, nif, email, phone, position, username, password, firstName, lastName);

        } catch (IllegalArgumentException e) {
            System.out.println("Error adding representative: " + e.getMessage());
            System.out.println("Please try again with a different NIF or contact support if you believe this is an error.");
            return null;
        }
    }
}
