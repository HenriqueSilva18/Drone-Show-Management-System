package lapr4.customermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VATTest {

    @Test
    void testVATCannotBeNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new VAT(null));
        assertThrows(IllegalArgumentException.class, () -> new VAT("   "));
    }

    @Test
    void testVATStartsWithTwoUpperCaseLetters() {
        assertDoesNotThrow(() -> new VAT("pt123456789"));
        assertThrows(IllegalArgumentException.class, () -> new VAT("12abc"));
        assertThrows(IllegalArgumentException.class, () -> new VAT("A1bc"));
        assertThrows(IllegalArgumentException.class, () -> new VAT("123456"));
    }

    @Test
    void testVATLengthRequirement() {
        assertDoesNotThrow(() -> new VAT("PT12"));
        assertDoesNotThrow(() -> new VAT("DE1234567890123"));
        assertThrows(IllegalArgumentException.class, () -> new VAT("PT1"));
        assertThrows(IllegalArgumentException.class, () -> new VAT("ES12345678901234"));
    }

    @Test
    void testVATRejectsSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new VAT("PT12$456"));
    }

    @Test
    void testTrimAndUpperCaseConversion() {
        VAT vat = new VAT("  pt123  ");
        assertEquals("PT123", vat.toString());
    }

    @Test
    void valueOf_TrimsAndConvertsToUpperCase() {
        VAT vat = VAT.valueOf("  fr9876  ");
        assertEquals("FR9876", vat.toString());
    }

    @Test
    void testEquals_ReturnsTrueForSameVAT() {
        VAT vat1 = new VAT("IT123");
        VAT vat2 = new VAT("IT123");
        assertEquals(vat1, vat2);
    }

    @Test
    void testEquals_ReturnsFalseForDifferentVAT() {
        VAT vat1 = new VAT("NL456");
        VAT vat2 = new VAT("BE789");
        assertNotEquals(vat1, vat2);
    }

    @Test
    void testHashCode_ConsistentWithEquals() {
        VAT vat1 = new VAT("ES111");
        VAT vat2 = new VAT("ES111");
        assertEquals(vat1.hashCode(), vat2.hashCode());
    }

    @Test
    void testToString_ReturnsTrimmedUpperCaseVAT() {
        VAT vat = new VAT("  gr1234abc  ");
        assertEquals("GR1234ABC", vat.toString());
    }

    @Test
    void compareTo_OrdersLexicographically() {
        VAT vat1 = new VAT("AA100");
        VAT vat2 = new VAT("BB200");
        assertTrue(vat1.compareTo(vat2) < 0);
    }

    @Test
    void compareTo_CaseInsensitiveComparison() {
        VAT vat1 = new VAT("PT123");
        VAT vat2 = new VAT("pt123");
        assertEquals(0, vat1.compareTo(vat2));
    }

    @Test
    void testMinimumValidVAT() {
        assertDoesNotThrow(() -> new VAT("AB12"));
    }

    @Test
    void testMaximumValidVAT() {
        assertDoesNotThrow(() -> new VAT("CD1234567890123"));
    }
}