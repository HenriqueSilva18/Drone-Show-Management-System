package lapr4.figureCategoryManagement.application;

import lapr4.figureManagement.application.FigureCategoryService;
import lapr4.figureManagement.domain.FigureCategory;
import lapr4.figureManagement.repositories.FigureCategoryRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.exceptions.UnauthenticatedException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FigureCategoryServiceTest {

    static class StubFigureCategoryRepository implements FigureCategoryRepository {
        private final List<FigureCategory> categories = new ArrayList<>();

        @Override
        public FigureCategory save(FigureCategory category) {
            categories.removeIf(c -> c.identity().equals(category.identity()));
            categories.add(category);
            return category;
        }

        @Override
        public Iterable<FigureCategory> findAll() {
            return new ArrayList<>(categories);
        }

        @Override
        public Optional<FigureCategory> findByName(String name) {
            return categories.stream()
                    .filter(c -> c.name().equals(name))
                    .findFirst();
        }

        @Override
        public Optional<FigureCategory> ofIdentity(String id) {
            return categories.stream()
                    .filter(c -> c.identity().equals(id))
                    .findFirst();
        }

        @Override
        public long count() {
            return categories.size();
        }

        @Override
        public void delete(FigureCategory entity) {
            categories.remove(entity);
        }

        @Override
        public void deleteOfIdentity(String entityId) {

        }
    }

    static class StubAuthorizationService extends AuthorizationService {
        private boolean authenticated = false;

        @Override
        public void ensureAuthenticatedUserHasAnyOf(Role... roles) {
            if (!authenticated) {
                throw new UnauthenticatedException();
            }
        }

        public void setAuthenticated(boolean authenticated) {
            this.authenticated = authenticated;
        }
    }

    private StubFigureCategoryRepository categoryRepository;
    private StubAuthorizationService authService;
    private FigureCategoryService categoryService;

    @BeforeEach
    void setUp() {
        categoryRepository = new StubFigureCategoryRepository();
        authService = new StubAuthorizationService();
        authService.setAuthenticated(true);
        categoryService = new FigureCategoryService(categoryRepository, authService);
    }

    /*
        * Test case: Register a valid category
     */

    @Test
    void registerCategory_authorizedUser_shouldCreateAndSave() {
        FigureCategory category = new FigureCategory("Artistic", "Artistic Description");

        FigureCategory result = categoryService.registerCategory(category);

        assertNotNull(result);
        assertEquals("Artistic", result.name());
        assertEquals(1, categoryRepository.count());
    }

    @Test
    void registerCategory_unauthorizedUser_shouldThrowException() {
        authService.setAuthenticated(false);
        FigureCategory category = new FigureCategory("Artistic", "Artistic Description");

        assertThrows(UnauthenticatedException.class, () -> categoryService.registerCategory(category));
    }

    @Test
    void registerCategory_withEmptyName_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new FigureCategory("  ", "Some description"));
    }

    @Test
    void registerCategory_withEmptyDescription_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                new FigureCategory("Name", ""));
    }

    @Test
    void updateDescription_authorizedUser_shouldEditAndSave() {
        FigureCategory category = new FigureCategory("Tecnica", "Original");
        categoryRepository.save(category);

        categoryService.updateDescription("Tecnica", "Nova descrição");

        FigureCategory updated = categoryRepository.findByName("Tecnica").orElseThrow();
        assertEquals("Nova descrição", updated.description());
        assertNotNull(updated.lastEditionDate());
    }

    @Test
    void updateDescription_unauthorizedUser_shouldThrowException() {
        FigureCategory category = new FigureCategory("Tecnica", "Original");
        categoryRepository.save(category);
        authService.setAuthenticated(false);

        assertThrows(UnauthenticatedException.class, () ->
                categoryService.updateDescription("Tecnica", "Nova descrição"));
    }

    @Test
    void updateDescription_withEmptyDescription_shouldThrowException() {
        FigureCategory category = new FigureCategory("Tecnica", "Original");
        categoryRepository.save(category);

        assertThrows(IllegalArgumentException.class, () ->
                categoryService.updateDescription("Tecnica", "  "));
    }

    @Test
    void toggleCategory_authorizedUser_shouldToggleAndSave() {
        FigureCategory category = new FigureCategory("Formação", "Categoria ativa");
        categoryRepository.save(category);

        assertTrue(category.isActive());

        categoryService.toggleCategory("Formação");

        FigureCategory updated = categoryRepository.findByName("Formação").orElseThrow();
        assertFalse(updated.isActive());
        assertNotNull(updated.lastEditionDate());
    }

    @Test
    void toggleCategory_unauthorizedUser_shouldThrowException() {
        FigureCategory category = new FigureCategory("Formação", "Categoria ativa");
        categoryRepository.save(category);
        authService.setAuthenticated(false);

        assertThrows(UnauthenticatedException.class, () ->
                categoryService.toggleCategory("Formação"));
    }

    @Test
    void deactivateAlreadyInactive_shouldThrowException() {
        FigureCategory category = new FigureCategory("Especial", "Inativa");
        category.deactivate();
        categoryRepository.save(category);

        assertThrows(IllegalStateException.class, () ->
                categoryService.deactivateCategory("Especial"));
    }

    @Test
    void activateAlreadyActive_shouldThrowException() {
        FigureCategory category = new FigureCategory("Treino", "Já ativa");
        categoryRepository.save(category);

        assertThrows(IllegalStateException.class, () ->
                categoryService.activateCategory("Treino"));
    }

    @Test
    void listCategories_shouldReturnAllSavedCategories() {
        // Arrange
        FigureCategory cat1 = new FigureCategory("Acrobática", "Categoria para acrobacias");
        FigureCategory cat2 = new FigureCategory("Técnica", "Categoria técnica");

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);

        // Act
        Iterable<FigureCategory> result = categoryService.findAll();

        // Assert
        List<FigureCategory> resultList = new ArrayList<>();
        result.forEach(resultList::add);

        assertEquals(2, resultList.size());
        assertTrue(resultList.contains(cat1));
        assertTrue(resultList.contains(cat2));
    }

    @Test
    void listCategories_withNoCategories_shouldReturnEmptyList() {
        // Arrange — nenhum save feito

        // Act
        Iterable<FigureCategory> result = categoryService.findAll();

        // Assert
        assertNotNull(result);
        assertFalse(result.iterator().hasNext());
    }

    @Test
    void listCategories_shouldOverwriteCategoryWithSameName() {
        // Arrange
        FigureCategory original = new FigureCategory("Estilo Livre", "Descrição antiga");
        categoryRepository.save(original);

        FigureCategory updated = new FigureCategory("Estilo Livre", "Descrição nova");
        categoryRepository.save(updated);

        // Act
        Iterable<FigureCategory> result = categoryService.findAll();

        // Assert
        List<FigureCategory> list = new ArrayList<>();
        result.forEach(list::add);

        assertEquals(1, list.size());
        assertEquals("Descrição nova", list.get(0).description());
    }

    @Test
    void listCategories_shouldIncludeInactiveCategories() {
        // Arrange
        FigureCategory ativa = new FigureCategory("Ativa", "Em uso");
        FigureCategory inativa = new FigureCategory("Inativa", "Obsoleta");
        inativa.deactivate();

        categoryRepository.save(ativa);
        categoryRepository.save(inativa);

        // Act
        Iterable<FigureCategory> result = categoryService.findAll();

        // Assert
        List<FigureCategory> list = new ArrayList<>();
        result.forEach(list::add);

        assertEquals(2, list.size());
        assertTrue(list.stream().anyMatch(FigureCategory::isActive));
        assertTrue(list.stream().anyMatch(c -> !c.isActive()));
    }

    @Test
    void listCategories_withSpecialCharacters_shouldBeHandledCorrectly() {
        // Arrange
        FigureCategory cat1 = new FigureCategory("Espaço Livre", "Com espaço");
        FigureCategory cat2 = new FigureCategory("Árbitros", "Com acento");
        categoryRepository.save(cat1);
        categoryRepository.save(cat2);

        // Act
        Iterable<FigureCategory> result = categoryService.findAll();

        // Assert
        List<FigureCategory> list = new ArrayList<>();
        result.forEach(list::add);

        assertEquals(2, list.size());
        assertTrue(list.stream().anyMatch(c -> c.name().equals("Espaço Livre")));
        assertTrue(list.stream().anyMatch(c -> c.name().equals("Árbitros")));
    }

    @Test
    void listCategories_shouldNotDuplicateSameCategory() {
        // Arrange
        FigureCategory cat = new FigureCategory("Única", "Única descrição");
        categoryRepository.save(cat);
        categoryRepository.save(cat); // guardar novamente

        // Act
        List<FigureCategory> list = new ArrayList<>();
        categoryService.findAll().forEach(list::add);

        // Assert
        assertEquals(1, list.size());
    }



}
