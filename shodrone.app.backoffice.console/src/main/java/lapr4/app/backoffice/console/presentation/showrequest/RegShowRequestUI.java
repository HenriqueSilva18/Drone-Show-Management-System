package lapr4.app.backoffice.console.presentation.showrequest;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;
import lapr4.showRequestManagement.application.RegShowRequestController;
import lapr4.showRequestManagement.domain.ShowRequest;

public class RegShowRequestUI extends AbstractUI {

    private final RegShowRequestController controller = new RegShowRequestController();

    @Override
    protected boolean doShow() {
        System.out.println("\n=== Register Show Request ===");

        try {
            final int numDrones = Console.readInteger("Number of drones:");
            final double duration = Console.readDouble("Duration (in minutes):");
            final String description = Console.readLine("Show description:");
            final int requestId = Console.readInteger("Show Request ID:");
            final String date = Console.readLine("Date (YYYY-MM-DD):");
            final String clientVAT = Console.readLine("Client VAT:");

            ShowRequest request = controller.registerShowRequest(
                    numDrones,
                    duration,
                    description,
                    requestId,
                    date,
                    clientVAT
            );

            System.out.println("\n✅ Show Request registered successfully!");
            System.out.println("ID: " + request.getShowRequestId());

        } catch (final Exception e) {
            System.out.println("⚠️  Error: " + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Register Show Request";
    }
}
