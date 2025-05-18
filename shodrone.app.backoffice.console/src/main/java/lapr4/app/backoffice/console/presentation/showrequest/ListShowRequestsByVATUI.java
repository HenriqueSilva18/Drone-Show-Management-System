package lapr4.app.backoffice.console.presentation.showrequest;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.io.util.Console;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showRequestManagement.application.RegShowRequestController;
import lapr4.showRequestManagement.application.ShowRequestService;
import lapr4.showRequestManagement.domain.ShowRequest;

public class ListShowRequestsByVATUI extends AbstractUI {

    private final RegShowRequestController controller;

    public ListShowRequestsByVATUI() {
        ShowRequestService service = new ShowRequestService();
        CustomerRepository customerRepo = PersistenceContext.repositories().customers();
        this.controller = new RegShowRequestController(service, customerRepo);
    }

    @Override
    protected boolean doShow() {
        System.out.println("\n=== Show Requests by Customer VAT ===");
        String vat = Console.readLine("Enter Customer VAT:");

        Iterable<ShowRequest> requests = controller.findShowRequestsByVAT(vat);

        boolean found = false;
        for (ShowRequest req : requests) {
            System.out.printf("ID: %s | Status: %s%n", req.getShowRequestId(), req.getStatus());
            found = true;
        }

        if (!found) {
            System.out.println("⚠️  No Show Requests found for VAT: " + vat);
        }

        return false;
    }

    @Override
    public String headline() {
        return "List Show Requests by Customer VAT";
    }
}
