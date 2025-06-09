package lapr4.figureCategoryManagement.domain;

import lapr4.figureManagement.domain.FigureCategory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FigureCategoryTest {

    @Test
    void constructor_shouldCreateValidCategory() {
        FigureCategory category = new FigureCategory("Artística", "Categoria de estilo artístico");
        assertEquals("Artística", category.name());
        assertEquals("Categoria de estilo artístico", category.description());
        assertTrue(category.isActive());
        assertNotNull(category.creationDate());
        assertNull(category.lastEditionDate());
    }

    @Test
    void constructor_withEmptyName_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new FigureCategory("  ", "Descrição"));
    }

    @Test
    void constructor_withNullName_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new FigureCategory(null, "Descrição"));
    }

    @Test
    void constructor_withEmptyDescription_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new FigureCategory("Nome", " "));
    }

    @Test
    void constructor_withNullDescription_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new FigureCategory("Nome", null));
    }

    @Test
    void updateDescription_shouldChangeDescriptionAndUpdateDate() {
        FigureCategory category = new FigureCategory("Técnica", "Original");
        assertNull(category.lastEditionDate());

        category.updateDescription("Nova descrição");
        assertEquals("Nova descrição", category.description());
        assertNotNull(category.lastEditionDate());
    }

    @Test
    void updateDescription_withEmpty_shouldThrowException() {
        FigureCategory category = new FigureCategory("Técnica", "Original");
        assertThrows(IllegalArgumentException.class, () -> category.updateDescription(" "));
    }

    @Test
    void deactivate_shouldSetInactiveAndUpdateDate() {
        FigureCategory category = new FigureCategory("Exemplo", "Desc");
        category.deactivate();
        assertFalse(category.isActive());
        assertNotNull(category.lastEditionDate());
    }

    @Test
    void deactivate_whenAlreadyInactive_shouldThrowException() {
        FigureCategory category = new FigureCategory("Inativa", "Desc");
        category.deactivate();

        LocalDateTime before = category.lastEditionDate();

        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> category.deactivate());
        assertEquals("Category is already deactivated.", ex.getMessage());
        assertEquals(before, category.lastEditionDate());
    }

    @Test
    void activate_shouldSetActiveAndUpdateDate() {
        FigureCategory category = new FigureCategory("Exemplo", "Desc");
        category.deactivate();
        assertFalse(category.isActive());

        category.activate();
        assertTrue(category.isActive());
        assertNotNull(category.lastEditionDate());
    }

    @Test
    void activate_whenAlreadyActive_shouldThrowException() {
        FigureCategory category = new FigureCategory("Ativa", "Desc");
        assertTrue(category.isActive());

        LocalDateTime before = category.lastEditionDate();

        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> category.activate());
        assertEquals("Category is already active.", ex.getMessage());
        assertEquals(before, category.lastEditionDate());
    }

    @Test
    void identity_shouldReturnName() {
        FigureCategory category = new FigureCategory("Estilo", "Descrição");
        assertEquals("Estilo", category.identity());
    }

    @Test
    void sameAs_shouldReturnTrueForSameName() {
        FigureCategory cat1 = new FigureCategory("Igual", "Descrição A");
        FigureCategory cat2 = new FigureCategory("Igual", "Descrição B");
        assertTrue(cat1.sameAs(cat2));
    }

    @Test
    void sameAs_shouldReturnFalseForDifferentName() {
        FigureCategory cat1 = new FigureCategory("Um", "Descrição");
        FigureCategory cat2 = new FigureCategory("Dois", "Outra");
        assertFalse(cat1.sameAs(cat2));
    }

    @Test
    void toString_shouldReturnName() {
        FigureCategory cat = new FigureCategory("Show", "Descrição");
        assertEquals("Show", cat.name());
    }

    @Test
    void equals_shouldReturnTrueForSameObject() {
        FigureCategory cat = new FigureCategory("Igual", "Descrição");
        assertEquals(cat, cat);
    }

    @Test
    void equals_shouldReturnFalseForDifferentObject() {
        FigureCategory cat1 = new FigureCategory("Um", "Descrição");
        FigureCategory cat2 = new FigureCategory("Dois", "Outra");
        assertNotEquals(cat1, cat2);
    }

    @Test
    void equals_shouldReturnFalseForNull() {
        FigureCategory cat = new FigureCategory("Um", "Descrição");
        assertNotEquals(cat, null);
    }

    @Test
    void equals_shouldReturnFalseForDifferentClass() {
        FigureCategory cat = new FigureCategory("Um", "Descrição");
        String str = "Um";
        assertNotEquals(cat, str);
    }

    @Test
    void hashCode_shouldReturnSameValueForSameObject() {
        FigureCategory cat = new FigureCategory("Igual", "Descrição");
        assertEquals(cat.hashCode(), cat.hashCode());
    }
}
