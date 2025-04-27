package lapr4.app.backoffice.console.presentation.customer;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.customermanagement.application.*;
import lapr4.customermanagement.application.RegCustomerController.RepresentativeData;

public class AddCustomerRepresentativeUI extends AbstractUI {
	private final AddCustomerRepresentativeController controller = new AddCustomerRepresentativeController();

	@Override
	protected boolean doShow() {
		System.out.println("=== Customer Representative Registration ===");
		final String customerVAT = Console.readLine("Customer VAT:");
		RepresentativeData repData = Utils.collectRepresentativeData();
		try {
			controller.addRepresentative(customerVAT, repData);
			System.out.println("Customer Representative added successfully!");
		} catch (Exception e) {
			System.out.printf("Error: %s", e.getMessage());
		}
		return false;
	}

	@Override
	public String headline() {
		return "Add Customer Representative";
	}
}
