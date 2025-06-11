package lapr4.infrastructure.bootstrapers.demo;

import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showRequestManagement.application.RegShowRequestController;
import lapr4.showRequestManagement.application.ShowRequestService;
import lapr4.customermanagement.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShowRequestBootstrapper implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShowRequestBootstrapper.class);
    private final RegShowRequestController controller;

    public ShowRequestBootstrapper() {
        ShowRequestService service = new ShowRequestService();
        CustomerRepository customerRepository = PersistenceContext.repositories().customers();
        this.controller = new RegShowRequestController(service, customerRepository);
    }

    @Override
    public boolean execute() {
        registerShowRequest(5, 30.0, "Show of Logo",
            100, "2024-06-15", "PT123456789");
        registerShowRequest(3, 20.0, "Show of Logo",
            101, "2024-07-01", "PT987654321");
        registerShowRequest(8, 45.0, "Show of Logo",
            102, "2024-08-15", "PT987654321");

        updateShowRequestStatus("PT987654321", 102, "ShowProposalDone");
        
        return true;
    }

    private void registerShowRequest(int numDrones, double duration, String description, 
            int requestId, String date, String customerVat) {
        try {
            controller.registerShowRequest(numDrones, duration, description, requestId,
                date, customerVat);
                
            LOGGER.debug("»»» Created show request with ID: {}", requestId);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            LOGGER.warn("Assuming show request {} already exists (activate trace log for details)", requestId);
            LOGGER.trace("Assuming existing record", e);
        } catch (final IllegalArgumentException e) {
            LOGGER.warn("Failed to create show request: {}", e.getMessage());
        }
    }

    private void updateShowRequestStatus(String vatStr, int requestId, String newStatus) {
        try {
            controller.updateShowRequest(vatStr, requestId, -1, -1, "", "", newStatus);
            LOGGER.debug("»»» Updated show request {} status to {}", requestId, newStatus);
        } catch (Exception e) {
            LOGGER.warn("Failed to update show request {} status: {}", requestId, e.getMessage());
        }
    }
} 