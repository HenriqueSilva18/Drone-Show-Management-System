package lapr4.customermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void testEmailCannotBeNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email("   "));
    }

    @Test
    void testEmailRejectsInvalidFormats() {
        assertThrows(IllegalArgumentException.class, () -> new Email("user.example.com"));
        assertThrows(IllegalArgumentException.class, () -> new Email("user@"));
        assertThrows(IllegalArgumentException.class, () -> new Email("user@example.c"));
    }

    @Test
    void testEmailAcceptsValidFormats() {
        assertDoesNotThrow(() -> new Email("user@example.com"));
        assertDoesNotThrow(() -> new Email("user.name@sub-domain.example.co.uk"));
    }

    @Test
    void valueOf_TrimsAndConvertsToLowerCase() {
        Email email = Email.valueOf("  User@Example.COM  ");
        assertEquals("user@example.com", email.toString());
    }

    @Test
    void testEquals_ReturnsTrueForSameEmail() {
        Email email1 = new Email("user@example.com");
        Email email2 = new Email("user@example.com");
        assertEquals(email1, email2);
    }

    @Test
    void testEquals_ReturnsFalseForDifferentEmails() {
        Email email1 = new Email("user1@example.com");
        Email email2 = new Email("user2@example.com");
        assertNotEquals(email1, email2);
    }

    @Test
    void testHashCode_ConsistentWithEquals() {
        Email email1 = new Email("user@example.com");
        Email email2 = new Email("user@example.com");
        assertEquals(email1.hashCode(), email2.hashCode());
    }

    @Test
    void testToString_ReturnsTrimmedLowerCaseEmail() {
        Email email = new Email("  Test@Example.COM  ");
        assertEquals("test@example.com", email.toString());
    }

    @Test
    void compareTo_IgnoresCase() {
        Email email1 = new Email("user@example.com");
        Email email2 = new Email("USER@EXAMPLE.COM");
        assertEquals(0, email1.compareTo(email2));
    }

    @Test
    void compareTo_OrdersLexicographically() {
        Email email1 = new Email("a@example.com");
        Email email2 = new Email("b@example.com");
        assertTrue(email1.compareTo(email2) < 0);
    }

    @Test
    void testEmailWithSpecialCharacters() {
        assertDoesNotThrow(() -> new Email("user.name+tag@sub-domain.example.com"));
    }

    @Test
    void testConstructorTrimsSpaces() {
        Email email = new Email("  user@example.com  ");
        assertEquals("user@example.com", email.toString());
    }
}