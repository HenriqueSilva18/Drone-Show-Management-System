package lapr4.showProposalManagement.domain;

import lapr4.showProposalManagement.dto.ProposalTemplateDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProposalTemplateTest {

    // Valid test data
    private String validName;
    private String validFilePath;

    // The subject under test
    private ProposalTemplate subject;

    @BeforeEach
    void setUp() {
        // Initializing valid data for tests
        validName = "Standard Proposal Template";
        validFilePath = "/templates/standard_template.docx";

        // Creating a new instance of ProposalTemplate for each test
        subject = new ProposalTemplate(validName);
    }

    @Test
    void ensureCanBuildValidProposalTemplate() {
        assertNotNull(subject);
    }

    @Test
    void ensureMustHaveName() {
        assertThrows(IllegalArgumentException.class, () ->
                new ProposalTemplate(null)
        );
    }

    @Test
    void ensureNameCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new ProposalTemplate("")
        );
    }

    @Test
    void ensureNameCannotBeBlank() {
        assertThrows(IllegalArgumentException.class, () ->
                new ProposalTemplate("   ")
        );
    }

    @Test
    void ensureCanChangeFilePath() {
        String newFilePath = "/templates/new_template.docx";
        subject.changeFilePath(newFilePath);

        ProposalTemplateDTO dto = subject.toDTO();
        assertEquals(newFilePath, dto.filePath());
    }

    @Test
    void ensureCanChangeFilePathToNull() {
        subject.changeFilePath(null);

        ProposalTemplateDTO dto = subject.toDTO();
        assertNull(dto.filePath());
    }

    @Test
    void ensureIdentityReturnsName() {
        assertEquals(validName, subject.identity());
    }

    @Test
    void ensureToDTOWorks() {
        subject.changeFilePath(validFilePath);

        ProposalTemplateDTO dto = subject.toDTO();
        assertEquals(validName, dto.name());
        assertEquals(validFilePath, dto.filePath());
    }

    @Test
    void ensureEqualsSameObject() {
        assertTrue(subject.equals(subject));
    }

    @Test
    void ensureEqualsNull() {
        assertFalse(subject.equals(null));
    }

    @Test
    void ensureEqualsDifferentClass() {
        assertFalse(subject.equals("string"));
    }

    @Test
    void ensureEqualsWithSameName() {
        ProposalTemplate other = new ProposalTemplate(validName);
        assertTrue(subject.equals(other));
    }

    @Test
    void ensureEqualsWithDifferentName() {
        ProposalTemplate other = new ProposalTemplate("Different Template");
        assertFalse(subject.equals(other));
    }

    @Test
    void ensureHashCodeConsistency() {
        ProposalTemplate other = new ProposalTemplate(validName);
        assertEquals(subject.hashCode(), other.hashCode());
    }

    @Test
    void ensureHashCodeDifferentForDifferentNames() {
        ProposalTemplate other = new ProposalTemplate("Different Template");
        assertNotEquals(subject.hashCode(), other.hashCode());
    }

    @Test
    void ensureSameAsSameObject() {
        assertTrue(subject.sameAs(subject));
    }

    @Test
    void ensureSameAsNull() {
        assertFalse(subject.sameAs(null));
    }

    @Test
    void ensureSameAsDifferentClass() {
        assertFalse(subject.sameAs("string"));
    }

    @Test
    void ensureSameAsWithSameName() {
        ProposalTemplate other = new ProposalTemplate(validName);
        assertTrue(subject.sameAs(other));
    }

    @Test
    void ensureSameAsWithDifferentName() {
        ProposalTemplate other = new ProposalTemplate("Different Template");
        assertFalse(subject.sameAs(other));
    }
}