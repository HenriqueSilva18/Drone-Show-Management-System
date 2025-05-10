package lapr4.customermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void testPhoneNumberCannotBeNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Phone(null));
        assertThrows(IllegalArgumentException.class, () -> new Phone("   "));
    }

    @Test
    void testPhoneNumberAcceptsValidFormats() {
        assertDoesNotThrow(() -> new Phone("+351912345678"));
        assertDoesNotThrow(() -> new Phone("912 345 678"));
        assertDoesNotThrow(() -> new Phone("123-456-7890"));
        assertDoesNotThrow(() -> new Phone("  987654321  "));
    }

    @Test
    void testPhoneNumberRejectsInvalidCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Phone("12A34-5678"));
        assertThrows(IllegalArgumentException.class, () -> new Phone("(123)456-7890"));
        assertThrows(IllegalArgumentException.class, () -> new Phone("++123456789"));
    }

    @Test
    void valueOf_TrimsSpacesAndCreatesValidPhone() {
        Phone phone = Phone.valueOf("  123 456-789  ");
        assertEquals("123 456-789", phone.toString());
    }

    @Test
    void testEquals_ReturnsTrueForSamePhoneNumber() {
        Phone phone1 = new Phone("912345678");
        Phone phone2 = new Phone("912345678");
        assertEquals(phone1, phone2);
    }

    @Test
    void testEquals_ReturnsFalseForDifferentPhoneNumbers() {
        Phone phone1 = new Phone("912345678");
        Phone phone2 = new Phone("987654321");
        assertNotEquals(phone1, phone2);
    }

    @Test
    void testHashCode_ConsistentWithEquals() {
        Phone phone1 = new Phone("912345678");
        Phone phone2 = new Phone("912345678");
        assertEquals(phone1.hashCode(), phone2.hashCode());
    }

    @Test
    void testToString_ReturnsTrimmedPhoneNumber() {
        Phone phone = new Phone("  912 345 678  ");
        assertEquals("912 345 678", phone.toString());
    }

    @Test
    void compareTo_OrdersLexicographically() {
        Phone phone1 = new Phone("111111111");
        Phone phone2 = new Phone("222222222");
        assertTrue(phone1.compareTo(phone2) < 0);
    }

    @Test
    void compareTo_IgnoresLeadingSpaces() {
        Phone phone1 = new Phone("123456789");
        Phone phone2 = new Phone("  123456789");
        assertEquals(0, phone1.compareTo(phone2));
    }

    @Test
    void testPhoneNumberWithOnlyDigits() {
        assertDoesNotThrow(() -> new Phone("000000000"));
    }

    @Test
    void testPhoneNumberWithMixedSeparators() {
        assertDoesNotThrow(() -> new Phone("+351 912-345 678"));
    }
}