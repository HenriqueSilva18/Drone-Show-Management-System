package lapr4.showRequestManagement.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShowRequestIdTest {

    @Test
    void testValidConstruction() {
        ShowRequestId id = new ShowRequestId(5);
        assertEquals(5, id.value());
    }

    @Test
    void testInvalidConstructionThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new ShowRequestId(0));
        assertThrows(IllegalArgumentException.class, () -> new ShowRequestId(-3));
    }

    @Test
    void testEqualsAndHashCode() {
        ShowRequestId id1 = new ShowRequestId(10);
        ShowRequestId id2 = new ShowRequestId(10);
        ShowRequestId id3 = new ShowRequestId(20);

        assertEquals(id1, id2);
        assertEquals(id1.hashCode(), id2.hashCode());
        assertNotEquals(id1, id3);
    }

    @Test
    void testCompareTo() {
        ShowRequestId id1 = new ShowRequestId(5);
        ShowRequestId id2 = new ShowRequestId(10);
        ShowRequestId id3 = new ShowRequestId(5);

        assertTrue(id1.compareTo(id2) < 0);
        assertTrue(id2.compareTo(id1) > 0);
        assertEquals(0, id1.compareTo(id3));
    }

    @Test
    void testToStringReturnsValue() {
        ShowRequestId id = new ShowRequestId(42);
        assertEquals("42", id.toString());
    }
}
