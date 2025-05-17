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
        public Iterable<FigureCategory> findAllActive() {
            return categories.stream()
                    .filter(FigureCategory::isActive)
                    .toList();
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

        List<FigureCategory> list = new ArrayList<>();
        categoryService.findAll().forEach(list::add);
        assertEquals(1, list.size());
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
                categoryService.registerCategory(new FigureCategory("  ", "Some description")));
    }

    @Test
    void registerCategory_withEmptyDescription_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                categoryService.registerCategory(new FigureCategory("Name", "")));
    }

    @Test
    void updateDescription_authorizedUser_shouldEditAndSave() {
        categoryService.registerCategory(new FigureCategory("Tecnica", "Original"));

        categoryService.updateDescription("Tecnica", "Nova descrição");

        List<FigureCategory> list = new ArrayList<>();
        categoryService.findAll().forEach(list::add);
        FigureCategory updated = list.get(0);

        assertEquals("Nova descrição", updated.description());
        assertNotNull(updated.lastEditionDate());
    }

    @Test
    void updateDescription_unauthorizedUser_shouldThrowException() {
        categoryService.registerCategory(new FigureCategory("Tecnica", "Original"));
        authService.setAuthenticated(false);

        assertThrows(UnauthenticatedException.class, () ->
                categoryService.updateDescription("Tecnica", "Nova descrição"));
    }

    @Test
    void updateDescription_withEmptyDescription_shouldThrowException() {
        categoryService.registerCategory(new FigureCategory("Tecnica", "Original"));

        assertThrows(IllegalArgumentException.class, () ->
                categoryService.updateDescription("Tecnica", "  "));
    }

    @Test
    void toggleCategory_authorizedUser_shouldToggleAndSave() {
        categoryService.registerCategory(new FigureCategory("Formação", "Categoria ativa"));

        categoryService.toggleCategory("Formação");

        List<FigureCategory> list = new ArrayList<>();
        categoryService.findAll().forEach(list::add);
        FigureCategory updated = list.get(0);

        assertFalse(updated.isActive());
        assertNotNull(updated.lastEditionDate());
    }

    @Test
    void toggleCategory_unauthorizedUser_shouldThrowException() {
        categoryService.registerCategory(new FigureCategory("Formação", "Categoria ativa"));
        authService.setAuthenticated(false);

        assertThrows(UnauthenticatedException.class, () ->
                categoryService.toggleCategory("Formação"));
    }

    @Test
    void deactivateAlreadyInactive_shouldThrowException() {
        FigureCategory category = new FigureCategory("Especial", "Inativa");
        category.deactivate();
        categoryService.registerCategory(category);

        assertThrows(IllegalStateException.class, () ->
                categoryService.deactivateCategory("Especial"));
    }

    @Test
    void activateAlreadyActive_shouldThrowException() {
        categoryService.registerCategory(new FigureCategory("Treino", "Já ativa"));

        assertThrows(IllegalStateException.class, () ->
                categoryService.activateCategory("Treino"));
    }

    @Test
    void listCategories_shouldReturnAllSavedCategories() {
        categoryService.registerCategory(new FigureCategory("Acrobática", "Categoria para acrobacias"));
        categoryService.registerCategory(new FigureCategory("Técnica", "Categoria técnica"));

        Iterable<FigureCategory> result = categoryService.findAll();

        List<FigureCategory> resultList = new ArrayList<>();
        result.forEach(resultList::add);

        assertEquals(2, resultList.size());
        assertTrue(resultList.stream().anyMatch(c -> c.name().equals("Acrobática")));
        assertTrue(resultList.stream().anyMatch(c -> c.name().equals("Técnica")));
    }

    @Test
    void listCategories_withNoCategories_shouldReturnEmptyList() {
        Iterable<FigureCategory> result = categoryService.findAll();
        assertNotNull(result);
        assertFalse(result.iterator().hasNext());
    }

    @Test
    void listCategories_shouldOverwriteCategoryWithSameName() {
        categoryService.registerCategory(new FigureCategory("Estilo Livre", "Descrição antiga"));
        categoryService.registerCategory(new FigureCategory("Estilo Livre", "Descrição nova"));

        List<FigureCategory> list = new ArrayList<>();
        categoryService.findAll().forEach(list::add);

        assertEquals(1, list.size());
        assertEquals("Descrição nova", list.get(0).description());
    }

    @Test
    void listCategories_shouldIncludeInactiveCategories() {
        FigureCategory ativa = new FigureCategory("Ativa", "Em uso");
        FigureCategory inativa = new FigureCategory("Inativa", "Obsoleta");
        inativa.deactivate();

        categoryService.registerCategory(ativa);
        categoryService.registerCategory(inativa);

        List<FigureCategory> list = new ArrayList<>();
        categoryService.findAll().forEach(list::add);

        assertEquals(2, list.size());
        assertTrue(list.stream().anyMatch(FigureCategory::isActive));
        assertTrue(list.stream().anyMatch(c -> !c.isActive()));
    }

    @Test
    void listCategories_withSpecialCharacters_shouldBeHandledCorrectly() {
        categoryService.registerCategory(new FigureCategory("Espaço Livre", "Com espaço"));
        categoryService.registerCategory(new FigureCategory("Árbitros", "Com acento"));

        List<FigureCategory> list = new ArrayList<>();
        categoryService.findAll().forEach(list::add);

        assertEquals(2, list.size());
        assertTrue(list.stream().anyMatch(c -> c.name().equals("Espaço Livre")));
        assertTrue(list.stream().anyMatch(c -> c.name().equals("Árbitros")));
    }

    @Test
    void listCategories_shouldNotDuplicateSameCategory() {
        FigureCategory cat = new FigureCategory("Única", "Única descrição");
        categoryService.registerCategory(cat);
        categoryService.registerCategory(cat); // guardar novamente

        List<FigureCategory> list = new ArrayList<>();
        categoryService.findAll().forEach(list::add);

        assertEquals(1, list.size());
    }



}
