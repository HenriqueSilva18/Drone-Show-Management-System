package lapr4.showRequestManagement.domain;

import lapr4.customermanagement.domain.Customer;
import lapr4.customermanagement.domain.VAT;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ShowRequestTest {

    private final ShowRequestId id = new ShowRequestId(1);
    private final VAT vat = new VAT("PT123456789"); // ✅ Corrigido para formato válido
    private final Customer customer = new Customer();

    private ShowRequest buildShowRequest() {
        return new ShowRequest(
                5,
                10.0,
                "Descrição do espetáculo",
                id,
                "2025-05-20",
                customer,
                vat,
                Collections.emptyList(),
                Collections.emptyList(),
                "CREATED"
        );
    }

    @Test
    void testConstructorAndGetters() {
        ShowRequest request = buildShowRequest();

        assertEquals(5, request.getNumDrones());
        assertEquals(10.0, request.getDuration());
        assertEquals("Descrição do espetáculo", request.getShowDescription());
        assertEquals(id, request.getShowRequestId());
        assertEquals("2025-05-20", request.getDateValue());
        assertEquals(customer, request.getCustomer());
        assertEquals(vat, request.getClientVAT());
        assertEquals("CREATED", request.getStatus());
        assertTrue(request.getDrones().isEmpty());
        assertTrue(request.getFigures().isEmpty());
    }

    @Test
    void testSetters() {
        ShowRequest request = buildShowRequest();

        request.setNumDrones(7);
        request.setDuration(15.0);
        request.setShowDescription("Nova descrição");
        request.setDate("2025-06-01");
        request.setStatus("CONFIRMED");

        assertEquals(7, request.getNumDrones());
        assertEquals(15.0, request.getDuration());
        assertEquals("Nova descrição", request.getShowDescription());
        assertEquals("2025-06-01", request.getDateValue());
        assertEquals("CONFIRMED", request.getStatus());
    }

    @Test
    void testIdentityAndHasIdentity() {
        ShowRequest request = buildShowRequest();
        assertEquals(id, request.identity());
        assertTrue(request.hasIdentity(new ShowRequestId(1)));
        assertFalse(request.hasIdentity(new ShowRequestId(2)));
    }

    @Test
    void testSameAs() {
        ShowRequest request1 = buildShowRequest();
        ShowRequest request2 = buildShowRequest();
        ShowRequest differentRequest = new ShowRequest(
                1,
                5.0,
                "Outro",
                new ShowRequestId(2),
                "2025-06-01",
                customer,
                vat,
                Collections.emptyList(),
                Collections.emptyList(),
                "CREATED"
        );

        assertTrue(request1.sameAs(request2));
        assertFalse(request1.sameAs(differentRequest));
        assertFalse(request1.sameAs(null));
        assertFalse(request1.sameAs("string qualquer"));
    }

    @Test
    void testEqualsAndHashCode() {
        ShowRequest request1 = buildShowRequest();
        ShowRequest request2 = buildShowRequest();
        ShowRequest different = new ShowRequest(
                1,
                5.0,
                "Outro",
                new ShowRequestId(2),
                "2025-06-01",
                customer,
                vat,
                Collections.emptyList(),
                Collections.emptyList(),
                "CREATED"
        );

        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());

        assertNotEquals(request1, different);
        assertNotEquals(request1.hashCode(), different.hashCode());
    }
}
