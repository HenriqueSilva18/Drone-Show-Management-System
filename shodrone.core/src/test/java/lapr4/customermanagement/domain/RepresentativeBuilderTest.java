package lapr4.customermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class RepresentativeBuilderTest {

    @Mock
    private SystemUser mockSystemUser;

    private String validNifString;
    private String validName;
    private String validEmail;
    private String validPhone;
    private String validPosition;
    private NIF validNif;
    private Email validEmailObj;
    private Phone validPhoneObj;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        validNifString = "123456789";
        validName = "John Doe";
        validEmail = "john.doe@example.com";
        validPhone = "+351912345678";
        validPosition = "Manager";

        validNif = new NIF(validNifString);
        validEmailObj = new Email(validEmail);
        validPhoneObj = new Phone(validPhone);
    }

    @Test
    void testBuild_WithAllValidParameters_ShouldCreateRepresentative() {
        Representative rep = new RepresentativeBuilder()
                .withNIF(validNifString)
                .withName(validName)
                .withEmail(validEmail)
                .withPhone(validPhone)
                .withPosition(validPosition)
                .withSystemUser(mockSystemUser)
                .build();

        assertNotNull(rep);
        assertEquals(validNif, rep.identity());
        assertEquals(validName, rep.name());
        assertEquals(validEmailObj, rep.email());
        assertEquals(validPhoneObj, rep.phone());
        assertEquals(validPosition, rep.position());
        assertEquals(mockSystemUser, rep.user());
    }

    @Test
    void testBuild_WithObjectParameters_ShouldCreateRepresentative() {
        Representative rep = new RepresentativeBuilder()
                .withNIF(validNif)
                .withName(validName)
                .withEmail(validEmailObj)
                .withPhone(validPhoneObj)
                .withPosition(validPosition)
                .withSystemUser(mockSystemUser)
                .build();

        assertNotNull(rep);
        assertEquals(validNif, rep.identity());
        assertEquals(validName, rep.name());
        assertEquals(validEmailObj, rep.email());
        assertEquals(validPhoneObj, rep.phone());
        assertEquals(validPosition, rep.position());
        assertEquals(mockSystemUser, rep.user());
    }

    @Test
    void testBuild_WithoutPhone_ShouldCreateRepresentative() {
        Representative rep = new RepresentativeBuilder()
                .withNIF(validNifString)
                .withName(validName)
                .withEmail(validEmail)
                .withPosition(validPosition)
                .withSystemUser(mockSystemUser)
                .build();

        assertNotNull(rep);
        assertEquals(validNif, rep.identity());
        assertEquals(validName, rep.name());
        assertEquals(validEmailObj, rep.email());
        assertNull(rep.phone());
        assertEquals(validPosition, rep.position());
        assertEquals(mockSystemUser, rep.user());
    }

    @Test
    void testBuild_WithoutNIF_ShouldThrowException() {
        assertThrows(IllegalStateException.class, () ->
                new RepresentativeBuilder()
                        .withName(validName)
                        .withEmail(validEmail)
                        .withPhone(validPhone)
                        .withPosition(validPosition)
                        .withSystemUser(mockSystemUser)
                        .build()
        );
    }

    @Test
    void testBuild_WithoutName_ShouldThrowException() {
        assertThrows(IllegalStateException.class, () ->
                new RepresentativeBuilder()
                        .withNIF(validNifString)
                        .withEmail(validEmail)
                        .withPhone(validPhone)
                        .withPosition(validPosition)
                        .withSystemUser(mockSystemUser)
                        .build()
        );
    }

    @Test
    void testBuild_WithoutEmail_ShouldThrowException() {
        assertThrows(IllegalStateException.class, () ->
                new RepresentativeBuilder()
                        .withNIF(validNifString)
                        .withName(validName)
                        .withPhone(validPhone)
                        .withPosition(validPosition)
                        .withSystemUser(mockSystemUser)
                        .build()
        );
    }

    @Test
    void testBuild_WithoutPosition_ShouldThrowException() {
        assertThrows(IllegalStateException.class, () ->
                new RepresentativeBuilder()
                        .withNIF(validNifString)
                        .withName(validName)
                        .withEmail(validEmail)
                        .withPhone(validPhone)
                        .withSystemUser(mockSystemUser)
                        .build()
        );
    }

    @Test
    void testBuild_WithoutSystemUser_ShouldThrowException() {
        assertThrows(IllegalStateException.class, () ->
                new RepresentativeBuilder()
                        .withNIF(validNifString)
                        .withName(validName)
                        .withEmail(validEmail)
                        .withPhone(validPhone)
                        .withPosition(validPosition)
                        .build()
        );
    }

    @Test
    void testInvalidEmailFormat_ShouldPropagateException() {
        String invalidEmail = "invalid-email";

        assertThrows(IllegalArgumentException.class, () ->
                new RepresentativeBuilder()
                        .withNIF(validNifString)
                        .withName(validName)
                        .withEmail(invalidEmail)
                        .withPhone(validPhone)
                        .withPosition(validPosition)
                        .withSystemUser(mockSystemUser)
                        .build()
        );
    }

    @Test
    void testInvalidNIFFormat_ShouldPropagateException() {
        String invalidNIF = "123";

        assertThrows(IllegalArgumentException.class, () ->
                new RepresentativeBuilder()
                        .withNIF(invalidNIF)
                        .withName(validName)
                        .withEmail(validEmail)
                        .withPhone(validPhone)
                        .withPosition(validPosition)
                        .withSystemUser(mockSystemUser)
                        .build()
        );
    }

    @Test
    void testInvalidPhoneFormat_ShouldPropagateException() {
        String invalidPhone = "123ABC456";

        assertThrows(IllegalArgumentException.class, () ->
                new RepresentativeBuilder()
                        .withNIF(validNifString)
                        .withName(validName)
                        .withEmail(validEmail)
                        .withPhone(invalidPhone)
                        .withPosition(validPosition)
                        .withSystemUser(mockSystemUser)
                        .build()
        );
    }
} 