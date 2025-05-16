package lapr4.figureManagement.domain;

import lapr4.customermanagement.domain.VAT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FigureTest {

    private VAT vat;
    private FigureCategory category;
    private Figure figure;

    @BeforeEach
    void setUp() {
        vat = new VAT("PT123456789");
        category = new FigureCategory("Natureza", "África");
        Set<String> keywords = new HashSet<>();
        keywords.add("arte");
        keywords.add("paisagem");
        figure = new Figure("Test Figure", keywords, true, vat, category);
        figure.setIdentity(1L); // for test purposes only
    }

    @Test
    void testBlankConstructor() {
        Figure test = new Figure();
        assertNotNull(test);
    }

    @Test
    void createFigure_shouldThrowException_descriptionNullorBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Figure(null, null, false, null, null));
        assertThrows(IllegalArgumentException.class, () -> new Figure(null, false, null, null));
        assertThrows(IllegalArgumentException.class, () -> new Figure(" ", null, false, null, null));
        assertThrows(IllegalArgumentException.class, () -> new Figure(" ", false, null, null));
    }


    @Test
    void createFigure_shouldThrowException_clientVATNull() {
        assertThrows(IllegalArgumentException.class, () -> new Figure("car", null, false, null, null));
        assertThrows(IllegalArgumentException.class, () -> new Figure("car",  false, null, null));
    }

    @Test
    void createFigure_shouldThrowException_categoryNull() {
        assertThrows(IllegalArgumentException.class, () -> new Figure ("Car", null, false, new VAT("PT123457896"), null));
        assertThrows(IllegalArgumentException.class, () -> new Figure ("Car",  false, new VAT("PT123457896"), null));
    }

    @Test
    void description() {
        assertEquals("Test Figure", figure.description());
    }

    @Test
    void isExclusive() {
        assertTrue(figure.isExclusive());
    }

    @Test
    void clientVAT() {
        assertEquals(vat, figure.clientVAT());
    }

    @Test
    void identity() {
        assertEquals(1L, figure.identity());
    }

    @Test
    void hasIdentity() {
        assertTrue(figure.hasIdentity(1L));
        assertFalse(figure.hasIdentity(2L));
    }

    @Test
    void nullIdentityShouldReturnFalse() {
        Figure test = new Figure();
        // Não precisamos definir o id (fica null por default)
        assertFalse(test.hasIdentity(null));
    }

    @Test
    void sameAs() {
        Figure other = new Figure("Another", true, vat, category);
        other.setIdentity(1L);
        assertTrue(figure.sameAs(other));

        Figure different = new Figure("Different", false, vat, category);
        different.setIdentity(2L);
        assertFalse(figure.sameAs(different));
        assertTrue(other.sameAs(other));
        Figure isNull = null;
        assertFalse(other.sameAs(isNull));

        FigureCategory fc = new FigureCategory();

        assertFalse(other.sameAs(fc));

    }

    @Test
    void testEquals() {
        Figure other = new Figure("Copy", true, vat, category);
        other.setIdentity(1L);
        assertEquals(figure, other);
    }

    @Test
    void testHashCode() {
        Figure other = new Figure("Copy", true, vat, category);
        other.setIdentity(1L);
        assertEquals(figure.hashCode(), other.hashCode());
    }

    @Test
    void isActive() {
        assertTrue(figure.isActive());
    }

    @Test
    void setActive() {
        figure.setActive(false);
        assertFalse(figure.isActive());
    }

    @Test
    void category() {
        assertEquals(category, figure.category());
    }

    @Test
    void setCategory() {
        FigureCategory newCategory = new FigureCategory("Carro", "Moderno");
        figure.setCategory(newCategory);
        assertEquals(newCategory, figure.category());
    }

    @Test
    void keywords() {
        assertTrue(figure.keywords().contains("arte"));
        assertTrue(figure.keywords().contains("paisagem"));
    }

    @Test
    void setKeywords() {
        Set<String> newKeywords = Set.of("azul", "vermelho");
        figure.setKeywords(newKeywords);
        assertTrue(figure.keywords().containsAll(newKeywords));
    }

    @Test
    void addKeyword() {
        figure.addKeyword("novo");
        assertTrue(figure.hasKeyword("novo"));

    }

    @Test
    void addNulLOrBlankKeyword() {
        assertThrows(IllegalArgumentException.class, () -> figure.addKeyword(null));
        assertThrows(IllegalArgumentException.class, () -> figure.addKeyword(" "));
    }

    @Test
    void removeNullOrBlankKeyword() {
        assertThrows(IllegalArgumentException.class, () -> figure.removeKeyword(null));
        assertThrows(IllegalArgumentException.class, () -> figure.removeKeyword(" "));
    }

    @Test
    void checkIfHasNullOrBlankKeyword() {
        assertThrows(IllegalArgumentException.class, () -> figure.hasKeyword(null));
        assertThrows(IllegalArgumentException.class, () -> figure.hasKeyword(" "));
    }

    @Test
    void setNullOrBlankDescription() {
        assertThrows(IllegalArgumentException.class, () -> figure.setDescription(null));
        assertThrows(IllegalArgumentException.class, () -> figure.setDescription(" "));
    }

    @Test
    void removeKeyword() {
        figure.removeKeyword("arte");
        assertFalse(figure.hasKeyword("arte"));
    }

    @Test
    void hasKeyword() {
        assertTrue(figure.hasKeyword("arte"));
        assertFalse(figure.hasKeyword("inexistente"));
    }

    @Test
    void setDescription() {
        figure.setDescription("Nova descrição");
        assertEquals("Nova descrição", figure.description());
    }

    @Test
    void setNullKeywords() {
        assertThrows(IllegalArgumentException.class, () -> figure.setKeywords(null));
    }

    @Test
    void setExclusive() {
        figure.setExclusive(false);
        assertFalse(figure.isExclusive());
    }

    @Test
    void getDecommissionDate() {
        assertNull(figure.getDecommissionDate());
    }

    @Test
    void setDecommissionDate() {
        LocalDateTime date = LocalDateTime.now();
        figure.setDecommissionDate(date);
        assertEquals(date, figure.getDecommissionDate());
    }

    @Test
    void testToString() {
        String expected = String.format(
                "Figure ID: 1 | Description: Test Figure | Keywords: [arte, paisagem] | Category: %s | Private to %s | Active: Yes",
                category.name(), vat
        );

        Figure figure2 = new Figure("Test Figure", false, vat, category);
        figure2.setActive(false);

        String expected2 = String.format(
                "Figure ID: 2 | Description: Test Figure | Keywords: [arte, paisagem] | Category: %s | Public | Active: No",
                category.name()
        );

        String actual = figure.toString();
        assertTrue(actual.contains("Figure ID: 1"));
        assertTrue(actual.contains("Description: Test Figure"));
        assertTrue(actual.contains("arte"));
        assertTrue(actual.contains("paisagem"));
        assertTrue(actual.contains(category.name()));
        assertTrue(actual.contains(vat.toString()));

        String actual2 = figure2.toString();
        assertTrue(actual2.contains("No"));
        assertTrue(actual2.contains("Public"));
    }

    @Test
    void setIdentity() {
        figure.setIdentity(123L);
        assertEquals(123L, figure.identity());

        assertThrows(IllegalArgumentException.class, () -> figure.setIdentity(0L));
    }

    @Test
    void equalFigures_true() {
        vat = new VAT("PT123456789");
        category = new FigureCategory("Natureza", "África");
        Set<String> keywords = new HashSet<>();
        keywords.add("arte");
        keywords.add("paisagem");
        Figure figure2 = new Figure("Test Figure", keywords, true, vat, category);
        figure2.setIdentity(1L);
        assertEquals(figure, figure2);
    }

    @Test
    void equalFigures_false() {
        Figure figure2 = new Figure("Different than 1", false, new VAT("PT324234322"), new FigureCategory());

        assertNotEquals(figure, figure2);
    }

    @Test
    void testSameFigure() {
        assertEquals(figure, figure);
    }

    @Test
    void testEqualsWithDifferentObjectType() {
        Figure figure = new Figure("Paisagem", true, new VAT("PT123456789"), new FigureCategory("Arte", "Quadro"));
        Object other = "Not a Figure";

        assertNotEquals(figure, other);
    }



}
