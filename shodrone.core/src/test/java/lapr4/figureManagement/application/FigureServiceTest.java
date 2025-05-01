package lapr4.figureManagement.application;

import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.repositories.FigureRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.exceptions.UnauthenticatedException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import lapr4.usermanagement.domain.Roles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FigureServiceTest {

    private FigureService service;
    private FakeAuthzService authz;
    private FakeRepo repo;

    @BeforeEach
    void setUp() {
        authz = new FakeAuthzService(false);
        repo  = new FakeRepo();
        service = new FigureService(repo, authz);
    }

    @Test
    void findActivePublic_devolveListaCorreta() {
        // prepara figuras
        Figure f1 = new Figure("Desc A", false, new DummyVAT());
        Figure f2 = new Figure("Desc B", false, new DummyVAT());
        repo.setFigures(Arrays.asList(f1, f2));

        Iterable<Figure> resultado = service.findActivePublic();
        List<Figure> lista = (List<Figure>) resultado;

        // verifica que chamou o authz e deu o resultado certo
        assertTrue(authz.checkCalled, "Deve chamar ensureAuthenticatedUserHasAnyOf");
        assertEquals(2, lista.size());
        assertTrue(lista.containsAll(Arrays.asList(f1, f2)),
                "Deve retornar exactamente as figuras do repositório");
    }

    @Test
    void findActivePublic_semPermissao_lançaUnauthenticatedException() {
        authz = new FakeAuthzService(true);
        service = new FigureService(repo, authz);

        assertThrows(UnauthenticatedException.class,
                () -> service.findActivePublic(),
                "Deve lançar UnauthenticatedException se o utilizador não tiver permissão");
        assertFalse(repo.checkCalled,
                "Deve falhar antes de invocar repo.findActivePublic()");
    }


    //----------------------------------------------------------------------------
    // Stub para AuthorizationService com a assinatura correta
    //----------------------------------------------------------------------------
    private static class FakeAuthzService extends AuthorizationService {
        private final boolean alwaysDeny;
        boolean checkCalled = false;

        FakeAuthzService(boolean alwaysDeny) {
            this.alwaysDeny = alwaysDeny;
        }

        @Override
        public void ensureAuthenticatedUserHasAnyOf(Role... roles) {
            checkCalled = true;
            if (alwaysDeny) {
                throw new UnauthenticatedException("sem permissão");
            }
        }

        public String authenticatedUserName() {
            return "test-user";
        }

        public Iterable<Role> authenticatedUserRoles() {
            // devolve pelo menos um Role para não disparar outra exception
            return List.of((Role) lapr4.usermanagement.domain.Roles.CRM_COLLABORATOR);
        }
    }



    //----------------------------------------------------------------------------
    // Stub para FigureRepository que também verifica se não foi chamado
    //----------------------------------------------------------------------------
    private static class FakeRepo implements FigureRepository {
        private List<Figure> figures = List.of();
        boolean checkCalled = false;

        void setFigures(List<Figure> figs) {
            this.figures = figs;
        }

        @Override
        public Figure save(Figure figure) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Optional<Figure> findById(Long id) {
            return Optional.empty();
        }

        @Override
        public java.util.Optional<Figure> ofIdentity(Long id) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void delete(Figure entity) {

        }

        @Override
        public void deleteOfIdentity(Long entityId) {

        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public Iterable<Figure> findAll() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterable<Figure> findActivePublic() {
            checkCalled = true;
            return figures;
        }
    }

    //----------------------------------------------------------------------------
    // Dummy VAT para o construtor de Figure
    //----------------------------------------------------------------------------
    private static class DummyVAT extends lapr4.customermanagement.domain.VAT {
        DummyVAT() { super("PT123456789"); }
    }
}