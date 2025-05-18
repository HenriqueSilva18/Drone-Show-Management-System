package lapr4.showRequestManagement.domain;

import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.VAT;
import lapr4.droneManagement.domain.Drone;
import lapr4.figureManagement.domain.Figure;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShowRequestBuilderTest {

    private final ShowRequestId id = new ShowRequestId(1);
    private final VAT vat = new VAT("PT123456789"); // ✅ Corrigido para o formato válido
    private final Customer customer = new Customer();
    private final List<Drone> drones = Collections.emptyList();
    private final List<Figure> figures = Collections.emptyList();

    @Test
    void testBuildSuccess() {
        ShowRequestBuilder builder = new ShowRequestBuilder()
                .withId(id)
                .withNumDrones(5)
                .withDuration(12.5)
                .withDescription("Espetáculo de luzes")
                .withDate("2025-05-20")
                .withCustomer(customer)
                .withClientVAT(vat)
                .withDrones(drones)
                .withFigures(figures)
                .withStatus("CREATED");

        ShowRequest request = builder.build();

        assertEquals(id, request.getShowRequestId());
        assertEquals(5, request.getNumDrones());
        assertEquals(12.5, request.getDuration());
        assertEquals("Espetáculo de luzes", request.getShowDescription());
        assertEquals("2025-05-20", request.getDateValue());
        assertEquals(customer, request.getCustomer());
        assertEquals(vat, request.getClientVAT());
        assertEquals("CREATED", request.getStatus());
        assertEquals(drones, request.getDrones());
        assertEquals(figures, request.getFigures());
    }

    @Test
    void testBuildFailsWhenMissingMandatoryFields() {
        ShowRequestBuilder builder = new ShowRequestBuilder()
                .withNumDrones(3)
                .withDuration(10.0);

        IllegalStateException exception = assertThrows(IllegalStateException.class, builder::build);
        assertTrue(exception.getMessage().contains("Missing mandatory fields"));
    }

    @Test
    void testBuildFailsWhenMissingVAT() {
        ShowRequestBuilder builder = new ShowRequestBuilder()
                .withId(id)
                .withNumDrones(3)
                .withDuration(10.0)
                .withDescription("Show")
                .withDate("2025-06-01")
                .withCustomer(customer);

        IllegalStateException exception = assertThrows(IllegalStateException.class, builder::build);
        assertTrue(exception.getMessage().contains("Missing mandatory fields"));
    }

    @Test
    void testBuildFailsWhenMissingCustomer() {
        ShowRequestBuilder builder = new ShowRequestBuilder()
                .withId(id)
                .withNumDrones(3)
                .withDuration(10.0)
                .withDescription("Show")
                .withDate("2025-06-01")
                .withClientVAT(vat);

        IllegalStateException exception = assertThrows(IllegalStateException.class, builder::build);
        assertTrue(exception.getMessage().contains("Missing mandatory fields"));
    }
}
