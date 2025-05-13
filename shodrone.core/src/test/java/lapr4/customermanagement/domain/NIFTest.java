package lapr4.customermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NIFTest {

    @Test
    void testNIFCannotBeNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new NIF(null));
        assertThrows(IllegalArgumentException.class, () -> new NIF("   "));
    }

    @Test
    void testNIFMustBeExactly9Digits() {
        assertThrows(IllegalArgumentException.class, () -> new NIF("12345678"));
        assertThrows(IllegalArgumentException.class, () -> new NIF("1234567890"));
        assertDoesNotThrow(() -> new NIF("123456789"));
    }

    @Test
    void testNIFRejectsNonDigitCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new NIF("123A56789"));
        assertThrows(IllegalArgumentException.class, () -> new NIF("123-56789"));
    }

    @Test
    void testNIFTrimsSpaces() {
        NIF nif = new NIF("  123456789  ");
        assertEquals("123456789", nif.toString());
    }

    @Test
    void valueOf_CreatesValidNIF() {
        NIF nif = NIF.valueOf("987654321");
        assertNotNull(nif);
        assertEquals("987654321", nif.toString());
    }

    @Test
    void testEquals_ReturnsTrueForSameNIF() {
        NIF nif1 = new NIF("123456789");
        NIF nif2 = new NIF("123456789");
        assertEquals(nif1, nif2);
    }

    @Test
    void testEquals_ReturnsFalseForDifferentNIF() {
        NIF nif1 = new NIF("111111111");
        NIF nif2 = new NIF("222222222");
        assertNotEquals(nif1, nif2);
    }

    @Test
    void testHashCode_ConsistentWithEquals() {
        NIF nif1 = new NIF("123456789");
        NIF nif2 = new NIF("123456789");
        assertEquals(nif1.hashCode(), nif2.hashCode());
    }

    @Test
    void testToString_ReturnsTrimmedNIF() {
        NIF nif = new NIF("  987654321  ");
        assertEquals("987654321", nif.toString());
    }

    @Test
    void compareTo_OrdersLexicographically() {
        NIF nif1 = new NIF("111111111");
        NIF nif2 = new NIF("222222222");
        assertTrue(nif1.compareTo(nif2) < 0);
    }

    @Test
    void compareTo_ReturnsZeroForEqualNIFs() {
        NIF nif1 = new NIF("123456789");
        NIF nif2 = new NIF("123456789");
        assertEquals(0, nif1.compareTo(nif2));
    }

    @Test
    void testLeadingZerosAreAllowed() {
        assertDoesNotThrow(() -> new NIF("000000000"));
    }

    @Test
    void testAllDigitsAllowed() {
        assertDoesNotThrow(() -> new NIF("999999999"));
    }
}