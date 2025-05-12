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
        private long currentId = 1L;

        @Override
        public FigureCategory save(FigureCategory category) {
            if (category.identity() == null) {
                category.setIdentity(currentId++);
            } else {
                categories.removeIf(c -> c.identity().equals(category.identity()));
            }
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



    @Test
    void registerCategory_validCategory_shouldCreateAndSave() {
        // Arrange
        FigureCategory category = new FigureCategory("Artistic", "Artistic Description");

        // Act
        FigureCategory result = categoryService.registerCategory(category);

        // Assert
        assertNotNull(result);
        assertEquals("Artistic", result.name());
        assertEquals(1, categoryRepository.count());
    }

    @Test
    void registerCategory_unauthorizedUser_shouldThrowException() {
        // Arrange
        FigureCategory category = new FigureCategory("Artistic", "Artistic Description");
        authService.setAuthenticated(false);

        assertThrows(UnauthenticatedException.class, () -> categoryService.registerCategory(category));
    }

    @Test
    void registerCategory_withNullName_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FigureCategory(null, "Artistic Description");
        });
    }

    @Test
    void registerCategory_withNullDescription_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FigureCategory("Artistic", null);
        });
    }



}
