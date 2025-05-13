package lapr4.customermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class RepresentativeTest {

    @Mock
    private SystemUser mockSystemUser;

    @Mock
    private Customer mockCustomer;

    private NIF validNif;
    private String validName;
    private Email validEmail;
    private Phone validPhone;
    private String validPosition;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        validNif = new NIF("123456789");
        validName = "John Doe";
        validEmail = new Email("john.doe@example.com");
        validPhone = new Phone("+351912345678");
        validPosition = "Manager";
    }

    @Test
    void testConstructor_WithValidParameters_ShouldCreateRepresentative() {
        Representative rep = new Representative(validNif, validName, validEmail, validPhone, validPosition, mockSystemUser);

        assertNotNull(rep);
        assertEquals(validNif, rep.identity());
        assertEquals(validName, rep.name());
        assertEquals(validEmail, rep.email());
        assertEquals(validPhone, rep.phone());
        assertEquals(validPosition, rep.position());
        assertEquals(mockSystemUser, rep.user());
    }

    @Test
    void testConstructor_WithNullNIF_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Representative(null, validName, validEmail, validPhone, validPosition, mockSystemUser));
    }

    @Test
    void testConstructor_WithNullName_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Representative(validNif, null, validEmail, validPhone, validPosition, mockSystemUser));
    }

    @Test
    void testConstructor_WithNullEmail_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Representative(validNif, validName, null, validPhone, validPosition, mockSystemUser));
    }

    @Test
    void testConstructor_WithNullPosition_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Representative(validNif, validName, validEmail, validPhone, null, mockSystemUser));
    }

    @Test
    void testConstructor_WithNullSystemUser_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Representative(validNif, validName, validEmail, validPhone, validPosition, null));
    }

    @Test
    void testConstructor_WithPhoneNull_ShouldNotThrowException() {
        assertDoesNotThrow(() ->
                new Representative(validNif, validName, validEmail, null, validPosition, mockSystemUser));
    }

    @Test
    void testConstructor_ShouldTrimWhitespace() {
        String nameWithSpaces = "  John Doe  ";
        String positionWithSpaces = "  Manager  ";

        Representative rep = new Representative(validNif, nameWithSpaces, validEmail, validPhone, positionWithSpaces, mockSystemUser);

        assertEquals("John Doe", rep.name());
        assertEquals("Manager", rep.position());
    }

    @Test
    void testAssociateCustomer_WithValidCustomer_ShouldSetCustomer() {
        Representative rep = new Representative(validNif, validName, validEmail, validPhone, validPosition, mockSystemUser);

        rep.associateCustomer(mockCustomer);

        assertEquals(mockCustomer, rep.customer());
    }

    @Test
    void testUpdateContact_WithNewEmailAndPhone_ShouldUpdateBoth() {
        Representative rep = new Representative(validNif, validName, validEmail, validPhone, validPosition, mockSystemUser);
        Email newEmail = new Email("new.email@example.com");
        Phone newPhone = new Phone("+351912345679");

        rep.updateContact(newEmail, newPhone);

        assertEquals(newEmail, rep.email());
        assertEquals(newPhone, rep.phone());
    }

    @Test
    void testUpdateContact_WithOnlyNewEmail_ShouldUpdateOnlyEmail() {
        Representative rep = new Representative(validNif, validName, validEmail, validPhone, validPosition, mockSystemUser);
        Email newEmail = new Email("new.email@example.com");
        Phone originalPhone = rep.phone();

        rep.updateContact(newEmail, null);

        assertEquals(newEmail, rep.email());
        assertEquals(originalPhone, rep.phone());
    }

    @Test
    void testUpdateContact_WithOnlyNewPhone_ShouldUpdateOnlyPhone() {
        Representative rep = new Representative(validNif, validName, validEmail, validPhone, validPosition, mockSystemUser);
        Phone newPhone = new Phone("+351912345679");
        Email originalEmail = rep.email();

        rep.updateContact(null, newPhone);

        assertEquals(originalEmail, rep.email());
        assertEquals(newPhone, rep.phone());
    }

    @Test
    void testUpdateContact_WithBothNull_ShouldThrowException() {
        Representative rep = new Representative(validNif, validName, validEmail, validPhone, validPosition, mockSystemUser);

        assertThrows(IllegalArgumentException.class, () ->
                rep.updateContact(null, null));
    }

    @Test
    void testEquals_WithSameObject_ShouldReturnTrue() {
        Representative rep = new Representative(validNif, validName, validEmail, validPhone, validPosition, mockSystemUser);

        assertEquals(rep, rep);
    }

    @Test
    void testEquals_WithDifferentObjectSameId_ShouldReturnTrue() {
        Representative rep1 = new Representative(validNif, validName, validEmail, validPhone, validPosition, mockSystemUser);
        Representative rep2 = new Representative(validNif, "Different Name", validEmail, validPhone, validPosition, mockSystemUser);

        assertEquals(rep1, rep2);
    }

    @Test
    void testEquals_WithDifferentObjectDifferentId_ShouldReturnFalse() {
        Representative rep1 = new Representative(validNif, validName, validEmail, validPhone, validPosition, mockSystemUser);
        Representative rep2 = new Representative(new NIF("987654321"), validName, validEmail, validPhone, validPosition, mockSystemUser);

        assertNotEquals(rep1, rep2);
    }

    @Test
    void testHashCode_WithSameId_ShouldReturnSameHashCode() {
        Representative rep1 = new Representative(validNif, validName, validEmail, validPhone, validPosition, mockSystemUser);
        Representative rep2 = new Representative(validNif, "Different Name", validEmail, validPhone, validPosition, mockSystemUser);

        assertEquals(rep1.hashCode(), rep2.hashCode());
    }

    @Test
    void testIdentity_ShouldReturnNIF() {
        Representative rep = new Representative(validNif, validName, validEmail, validPhone, validPosition, mockSystemUser);

        assertEquals(validNif, rep.identity());
    }

    @Test
    void testSameAs_WithSameIdentity_ShouldReturnTrue() {
        Representative rep1 = new Representative(validNif, validName, validEmail, validPhone, validPosition, mockSystemUser);
        Representative rep2 = new Representative(validNif, "Different Name", validEmail, validPhone, validPosition, mockSystemUser);

        assertTrue(rep1.sameAs(rep2));
    }

    @Test
    void testSameAs_WithDifferentIdentity_ShouldReturnFalse() {
        Representative rep1 = new Representative(validNif, validName, validEmail, validPhone, validPosition, mockSystemUser);
        Representative rep2 = new Representative(new NIF("987654321"), validName, validEmail, validPhone, validPosition, mockSystemUser);

        assertFalse(rep1.sameAs(rep2));
    }
} 