package lapr4.showRequestManagement.application;

import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.VAT;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.droneManagement.domain.Drone;
import lapr4.figureManagement.domain.Figure;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showRequestManagement.domain.*;

import java.util.Collections;
import java.util.List;

public class RegShowRequestController {

    private final ShowRequestService service = new ShowRequestService();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();

    /**
     * Regista um novo ShowRequest com os campos obrigatórios.
     */
    public ShowRequest registerShowRequest(int numDrones, double duration, String description,
                                           int requestId, String date, String vatStr) {

        VAT vat = new VAT(vatStr);
        Customer customer = customerRepository.findByVAT(vat)
                .orElseThrow(() -> new IllegalArgumentException("No customer found with VAT: " + vatStr));

        ShowRequestId id = new ShowRequestId(requestId);

        // Aqui consideramos drones e figures como vazios (podem ser adicionados depois)
        List<Drone> drones = Collections.emptyList();
        List<Figure> figures = Collections.emptyList();

        // Definir status inicial como "CREATED"
        String status = "CREATED";

        // Usar builder para criar o ShowRequest
        ShowRequest request = new ShowRequestBuilder()
                .withId(id)
                .withNumDrones(numDrones)
                .withDuration(duration)
                .withDescription(description)
                .withDate(date)
                .withCustomer(customer)
                .withClientVAT(vat)
                .withDrones(drones)
                .withFigures(figures)
                .withStatus(status)
                .build();

        return service.registerShowRequest(request);
    }

    /**
     * Lista todos os ShowRequests associados a um VAT (para UI).
     */
    public Iterable<ShowRequest> findShowRequestsByVAT(String vatStr) {
        return service.findByClientVAT(vatStr);
    }

    public void updateShowRequest(String vatStr, int requestId, int numDrones, double duration,
                                  String description, String date, String status) {
        VAT vat = new VAT(vatStr);
        ShowRequestId id = new ShowRequestId(requestId);
        service.updateShowRequest(vat, id, numDrones, duration, description, date, status);
    }

    public ShowRequest findShowRequestByVATAndId(String vatStr, int requestId) {
        VAT vat = new VAT(vatStr);
        ShowRequestId id = new ShowRequestId(requestId);
        return service.findByVATAndId(vat, id)
                .orElseThrow(() -> new IllegalArgumentException("No ShowRequest found for given VAT and ID"));
    }

}
