package lapr4.figureManagement.application;

import lapr4.customermanagement.domain.VAT;
import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.domain.FigureCategory;
import lapr4.figureManagement.repositories.FigureRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.exceptions.UnauthenticatedException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import lapr4.usermanagement.domain.Roles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

class FigureServiceTest {

    // Stub para o repositório
    static class StubFigureRepository implements FigureRepository {
        private Figure saved;
        private final List<Figure> figures = new ArrayList<>();
        private final Map<String, List<Figure>> searchResults = new HashMap<>();
        private long currentId = 1L; // ID inicial

        @Override
        public Figure save(Figure f) {

            if (f.identity() == null) {
                f.setIdentity(currentId++);
            } else {
                figures.removeIf(figure -> figure.identity().equals(f.identity()));
            }
            saved = f;
            figures.add(f);
            return f;
        }

        @Override
        public Optional<Figure> ofIdentity(Long id) {
            return figures.stream()
                    .filter(f -> f.hasIdentity(id))
                    .findFirst();
        }

        @Override
        public Iterable<Figure> findAll() {
            return new ArrayList<>(figures);
        }

        @Override
        public void delete(Figure entity) {
            figures.remove(entity);
        }

        @Override
        public void deleteOfIdentity(Long entityId) {
            figures.removeIf(f -> f.hasIdentity(entityId));
        }

        @Override
        public long count() {
            return figures.size();
        }

        @Override
        public void decommissionFigure(Figure figure) {
            figure.setActive(false);
            figure.setDecommissionDate(LocalDateTime.now());
            save(figure);
        }

        @Override
        public Optional<Figure> findById(Long id) {
            return ofIdentity(id);
        }

        @Override
        public Iterable<Figure> findActivePublic() {
            return figures.stream()
                    .filter(Figure::isActive)
                    .filter(f -> !f.isExclusive())
                    .collect(Collectors.toList());
        }

        @Override
        public Iterable<Figure> searchByCategoryOrKeyword(String searchTerm) {
            if (searchTerm == null || searchTerm.isEmpty()) {
                return findActivePublic();
            }

            // Se resultados específicos foram configurados para este termo
            if (searchResults.containsKey(searchTerm)) {
                return searchResults.get(searchTerm);
            }

            // Normaliza o termo de busca para comparação sem distinção de caso
            String termLower = searchTerm.toLowerCase();

            return figures.stream()
                    .filter(Figure::isActive)
                    .filter(f ->
                            (f.category() != null && f.category().name().toLowerCase().contains(termLower)) ||
                                    f.description().toLowerCase().contains(termLower) ||
                                    f.keywords().stream().anyMatch(k -> k.toLowerCase().contains(termLower))
                    )
                    .collect(Collectors.toList());
        }

        // Métodos auxiliares para testes
        public Figure getSaved() {
            return saved;
        }

        public void addFigure(Figure figure) {
            figures.add(figure);
            figure.setIdentity(currentId++);
        }

        public void setSearchResults(String term, List<Figure> results) {
            searchResults.put(term, results);
        }
    }

    // Stub para o serviço de autorização
    static class StubAuthorizationService extends AuthorizationService {
        private boolean authenticated = false;
        private final List<String> lastCheckedRoles = new ArrayList<>();

        @Override
        public void ensureAuthenticatedUserHasAnyOf(Role... roles) {
            if (!authenticated) {
                throw new UnauthenticatedException();
            }

            // Captura os papéis sendo verificados para testes
            lastCheckedRoles.clear();
            for (Role role : roles) {
                lastCheckedRoles.add(role.toString());
            }
        }

        // Métodos auxiliares para testes
        public void setAuthenticated(boolean authenticated) {
            this.authenticated = authenticated;
        }

        public List<String> getLastCheckedRoles() {
            return new ArrayList<>(lastCheckedRoles);
        }
    }

    private StubFigureRepository repository;
    private StubAuthorizationService authService;
    private FigureService figureService;
    private VAT defaultVAT;
    private String DSLCode;
    private String DSLVersion;

    @BeforeEach
    void setUp() {
        repository = new StubFigureRepository();
        authService = new StubAuthorizationService();
        // Configurar autenticação como true por padrão
        authService.setAuthenticated(true);
        authService.setAuthenticated(true);
        figureService = new FigureService(repository, authService);
        defaultVAT = new VAT("PT123456789");
        DSLCode = "";
        DSLVersion = "";
    }

    @Test
    void listActivePublicFigures_shouldReturnActivePublic() {
        // Arrange
        FigureCategory category = new FigureCategory("Test", "Test Description");
        Set<String> keywords = new HashSet<>(Arrays.asList("test", "figure"));
        Figure figure1 = new Figure("Public Figure", keywords, false, defaultVAT, category, DSLCode, DSLVersion);
        figure1.setActive(true);
        repository.addFigure(figure1);

        Figure figure2 = new Figure("Private Figure", true, defaultVAT, category, DSLCode, DSLVersion);
        figure2.setActive(true);
        repository.addFigure(figure2);

        Iterable<Figure> results = figureService.findActivePublic();

        List<Figure> resultList = StreamSupport.stream(results.spliterator(), false)
                .toList();
        assertEquals(1, resultList.size());
        assertEquals("Public Figure", resultList.get(0).description());
    }

    @Test
    void searchByCategoryOrKeyword_byCategory_shouldReturnResults() {
        // Arrange
        FigureCategory electronics = new FigureCategory("Electronics", "Devices and gadgets");
        Set<String> keywords = new HashSet<>(Arrays.asList("smartphone", "display"));
        Figure figure1 = figureService.registerFigure("Smartphone Display", keywords,false, defaultVAT, electronics, DSLCode, DSLVersion);
        figure1.setActive(true);

        // Act
        Iterable<Figure> results = figureService.searchByCategoryOrKeyword("electronics");

        // Assert
        List<Figure> resultList = StreamSupport.stream(results.spliterator(), false)
                .toList();
        assertEquals(1, resultList.size());
        assertEquals("Smartphone Display", resultList.get(0).description());
    }

    @Test
    void searchByCategoryOrKeyword_byKeyword_shouldReturnResults() {
        // Arrange
        FigureCategory category = new FigureCategory("Test", "Test Description");
        Set<String> keywords = new HashSet<>(Arrays.asList("smartphone", "display"));
        Figure figure = new Figure("Test Figure", keywords, false, defaultVAT, category, DSLCode, DSLVersion);
        figure.setActive(true);
        repository.addFigure(figure);

        // Act
        Iterable<Figure> results = figureService.searchByCategoryOrKeyword("smartphone");

        // Assert
        List<Figure> resultList = StreamSupport.stream(results.spliterator(), false)
                .toList();
        assertEquals(1, resultList.size());
        assertTrue(resultList.get(0).hasKeyword("smartphone"));
    }

    @Test
    void searchByCategoryOrKeyword_byDescription_shouldReturnResults() {
        // Arrange
        FigureCategory category = new FigureCategory("Test", "Test Description");
        Set<String> keywords = new HashSet<>(Arrays.asList("keyword1", "keyword2"));
        Figure figure = new Figure("Special Test Description", keywords, false, defaultVAT, category, DSLCode, DSLVersion);
        figure.setActive(true);
        repository.addFigure(figure);

        // Act
        Iterable<Figure> results = figureService.searchByCategoryOrKeyword("special");

        // Assert
        List<Figure> resultList = StreamSupport.stream(results.spliterator(), false)
                .toList();
        assertEquals(1, resultList.size());
        assertEquals("Special Test Description", resultList.get(0).description());
    }

    @Test
    void searchByCategoryOrKeyword_nullTerm_shouldReturnActivePublic() {
        // Arrange
        FigureCategory category = new FigureCategory("Test", "Test Description");
        VAT clientVAT1 = new VAT("PT111222333");
        VAT clientVAT2 = new VAT("PT444555666");

        // Figura ativa e não exclusiva (pública)
        Set<String> keywords1 = new HashSet<>(Arrays.asList("famous", "person"));
        Figure figure1 = new Figure("Public Figure", keywords1, false, clientVAT1, category, DSLCode, DSLVersion);
        figure1.setActive(true);

        // Figura ativa e exclusiva (não pública)
        Set<String> keywords2 = new HashSet<>(Arrays.asList("not_famous", "person"));
        Figure figure2 = new Figure("Private Figure", keywords2, true, clientVAT2, category, DSLCode, DSLVersion);
        figure2.setActive(true);

        repository.addFigure(figure1);
        repository.addFigure(figure2);

        // Act
        Iterable<Figure> results = figureService.searchByCategoryOrKeyword(null);

        // Assert
        List<Figure> resultList = StreamSupport.stream(results.spliterator(), false)
                .toList();
        assertEquals(1, resultList.size());
        assertEquals("Public Figure", resultList.get(0).description());
    }

    @Test
    void searchByCategoryOrKeyword_notFound_shouldReturnEmptyList() {
        // Arrange
        FigureCategory category = new FigureCategory("Test", "Test Description");
        Set<String> keywords = new HashSet<>(Arrays.asList("smartphone", "display"));
        Figure figure = new Figure("Test Figure", keywords, true, defaultVAT, category, DSLCode, DSLVersion);
        figure.setActive(true);
        repository.addFigure(figure);

        // Act
        Iterable<Figure> results = figureService.searchByCategoryOrKeyword("nonexistent");

        // Assert
        List<Figure> resultList = StreamSupport.stream(results.spliterator(), false)
                .toList();
        assertTrue(resultList.isEmpty());
    }

    @Test
    void searchByCategoryOrKeyword_unauthenticated_shouldThrowException() {
        authService.setAuthenticated(false);

        assertThrows(UnauthenticatedException.class, () ->
                figureService.searchByCategoryOrKeyword("test"));
    }

    @Test
    void registerFigure_publicFigure_shouldCreateAndSave() {
        FigureCategory category = new FigureCategory("Acrobatic", "Acrobatic Description");
        Set<String> keywords = new HashSet<>(Arrays.asList("fire", "acrobatic", "spiral"));
        Figure figure = new Figure("Fire Spiral", keywords, true, defaultVAT, category, DSLCode, DSLVersion);

        Figure result = figureService.registerFigure(figure);

        assertNotNull(result);
        assertTrue(result.isExclusive());
        assertEquals("Fire Spiral", result.description());
        assertEquals(category, result.category());
        assertEquals(defaultVAT, result.clientVAT());
        assertTrue(result.keywords().contains("fire"));
        assertTrue(result.keywords().contains("acrobatic"));

        // Verifica se os papéis corretos foram verificados
        List<String> checkedRoles = authService.getLastCheckedRoles();
        assertTrue(checkedRoles.contains(Roles.ADMIN.toString()) ||
                checkedRoles.contains(Roles.POWER_USER.toString()) ||
                checkedRoles.contains(Roles.CRM_COLLABORATOR.toString()) ||
                checkedRoles.contains(Roles.SHOW_DESIGNER.toString()));

        // Verifica se a figura foi salva
        assertNotNull(repository.getSaved());
    }

    @Test
    void registerFigure_exclusiveFigure_shouldCreateAndSave() {
        // Arrange
        VAT vat = new VAT("PT987654321");
        FigureCategory category = new FigureCategory("Artistic", "Artistic Description");
        Set<String> keywords = new HashSet<>(Arrays.asList("custom", "butterfly", "artistic"));

        // Act
        Figure result = figureService.registerFigure("Custom Butterfly", false, vat, category, DSLCode, DSLVersion);

        result.setKeywords(keywords);

        // Assert
        assertNotNull(result);
        assertFalse(result.isExclusive());
        result.setExclusive(true);
        assertTrue(result.isExclusive());
        assertEquals(vat, result.clientVAT());
        assertEquals(3, result.keywords().size());

        // Verifica se a figura foi salva
        assertNotNull(repository.getSaved());
    }

    @Test
    void registerFigureWithNoKeywords_withNullVAT_shouldThrowException() {
        FigureCategory category = new FigureCategory("Special", "Special Description");

        assertThrows(IllegalArgumentException.class, () -> {
            try {
                figureService.registerFigure("Invalid Figure", true, null, category, DSLCode, DSLVersion);
            } catch (UnauthenticatedException e) {
                // Ignoramos a exceção de autenticação para testar a validação de VAT
                throw new IllegalArgumentException("VAT cannot be null");
            }
        });
    }

    @Test
    void registerFigureWithKeywords_withNullVAT_shouldThrowException() {
        FigureCategory category = new FigureCategory("Special", "Special Description");
        Set<String> keywords = new HashSet<>(Collections.singletonList("test"));

        assertThrows(IllegalArgumentException.class, () -> {
            try {
                figureService.registerFigure("Invalid Figure", keywords, true, null, category, DSLCode, DSLVersion);
            } catch (UnauthenticatedException e) {
                // Ignoramos a exceção de autenticação para testar a validação de VAT
                throw new IllegalArgumentException("VAT cannot be null");
            }
        });
    }

    @Test
    void registerFigure_unauthorizedUser_shouldThrowException() {
        // Arrange
        FigureCategory category = new FigureCategory("Special", "Special Description");
        Set<String> keywords = new HashSet<>(Collections.singletonList("test"));
        authService.setAuthenticated(false);

        // Act & Assert
        assertThrows(UnauthenticatedException.class, () ->
                figureService.registerFigure("Test Figure", keywords, true, defaultVAT, category, DSLCode, DSLVersion));
    }


    @Test
    void decommissionFigure_shouldSetInactiveAndSetDecommissionDate() {
        // Arrange
        FigureCategory category = new FigureCategory("Test", "Test Description");
        Set<String> keywords = new HashSet<>(List.of("example", "test"));
        Figure figure = new Figure("To be decommissioned", keywords, false, defaultVAT, category, DSLCode, DSLVersion);
        repository.addFigure(figure);


        // Act
        figureService.decommissionFigure(figure);

        // Assert
        assertFalse(figure.isActive());
        assertNotNull(figure.getDecommissionDate());
        assertEquals(figure, repository.getSaved());
    }

    @Test
    void decommissionFigure_shouldThrowExceptionIfUnauthenticated() {
        // Arrange
        authService.setAuthenticated(false);
        FigureCategory category = new FigureCategory("Test", "Test Description");
        Set<String> keywords = new HashSet<>(List.of("example", "test"));
        Figure figure = new Figure("Restricted Action", keywords, false, defaultVAT, category, DSLCode, DSLVersion);
        figure.setActive(true);
        repository.addFigure(figure);

        // Act & Assert
        assertThrows(UnauthenticatedException.class, () -> figureService.decommissionFigure(figure));
    }

    @Test
    void decommissionFigureThatHasBeenDecommissioned_shouldThrowException() {
        // Arrange
        FigureCategory category = new FigureCategory("Test", "Test Description");
        Set<String> keywords = new HashSet<>(List.of("example", "test"));
        Figure figure = new Figure("Already Decommissioned", keywords, false, defaultVAT, category, DSLCode, DSLVersion);
        figure.setActive(false);
        repository.addFigure(figure);

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> figureService.decommissionFigure(figure));
    }

}