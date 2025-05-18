package lapr4.app.backoffice.console.presentation.showrequest;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showRequestManagement.application.RegShowRequestController;
import lapr4.showRequestManagement.application.ShowRequestService;
import lapr4.showRequestManagement.domain.ShowRequest;

public class EditShowRequestUI extends AbstractUI {

    // ✅ Usamos o novo construtor e passamos as dependências necessárias
    private final RegShowRequestController controller;

    public EditShowRequestUI() {
        ShowRequestService service = new ShowRequestService(); // usa o construtor compatível
        CustomerRepository customerRepo = PersistenceContext.repositories().customers();
        this.controller = new RegShowRequestController(service, customerRepo);
    }

    @Override
    protected boolean doShow() {
        System.out.println("\n=== Edit Show Request ===");

        final String vat = Console.readLine("Enter Customer VAT:");
        final int id = Console.readInteger("Enter ShowRequest ID:");

        try {
            ShowRequest request = controller.findShowRequestByVATAndId(vat, id);

            if ("ShowProposalDone".equalsIgnoreCase(request.getStatus())) {
                System.out.println("⚠️  This ShowRequest cannot be edited (Status = ShowProposalDone).");
                return false;
            }

            System.out.println("Leave blank or insert -1 to keep current value.");

            final int numDrones = Console.readInteger("New number of drones:");
            final double duration = Console.readDouble("New duration (minutes):");
            final String description = Console.readLine("New show description:");
            final String date = Console.readLine("New date (YYYY-MM-DD):");
            final String status = Console.readLine("New status:");

            controller.updateShowRequest(vat, id, numDrones, duration, description, date, status);
            System.out.println("✅ ShowRequest updated successfully.");

        } catch (Exception e) {
            System.out.println("⚠️  Error: " + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Edit Show Request";
    }
}
