package lapr4.persistence.impl.jpa;

import lapr4.Application;
import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.droneManagement.repositories.DroneRepository;
import lapr4.droneModelManagement.repositories.DroneModelRepository;
import lapr4.figureManagement.repositories.FigureCategoryRepository;
import lapr4.figureManagement.repositories.FigureRepository;
import lapr4.infrastructure.persistence.RepositoryFactory;
import lapr4.showRequestManagement.repositories.ShowRequestRepository;
import lapr4.utentemanagement.repositories.SignupRequestRepository;
import lapr4.utentemanagement.repositories.UtenteRepository;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.jpa.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaRepositoryFactory implements RepositoryFactory {

    private static final String PERSISTENCE_UNIT_NAME = Application.settings().getPersistenceUnitName();

    // =====================
    // Transaction Context
    // =====================
    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(
                PERSISTENCE_UNIT_NAME,
                Application.settings().getExtendedPersistenceProperties());
    }

    // =====================
    // Users
    // =====================
    @Override
    public UserRepository users(TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(PERSISTENCE_UNIT_NAME,
                Application.settings().getExtendedPersistenceProperties());
    }

    // =====================
    // Utentes
    // =====================
    @Override
    public UtenteRepository utentes(TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public UtenteRepository utentes() {
        return new JpaClientUserRepository(PERSISTENCE_UNIT_NAME);
    }

    // =====================
    // Customers
    // =====================
    @Override
    public CustomerRepository customers(TransactionalContext autoTx) {
        return new JpaCustomerRepository(autoTx);
    }

    @Override
    public CustomerRepository customers() {
        return new JpaCustomerRepository(PERSISTENCE_UNIT_NAME);
    }

    // =====================
    // Signup Requests
    // =====================
    @Override
    public SignupRequestRepository signupRequests(TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(PERSISTENCE_UNIT_NAME);
    }

    // =====================
    // Show Requests
    // =====================
    @Override
    public ShowRequestRepository showRequests(TransactionalContext autoTx) {
        return new JpaShowRequestRepository(autoTx);
    }

    @Override
    public ShowRequestRepository showRequests() {
        return new JpaShowRequestRepository(PERSISTENCE_UNIT_NAME);
    }

    // =====================
    // Show Proposals
    // =====================
    @Override
    public ShowProposalRepository showProposals(TransactionalContext autoTx) {
        return new JpaShowProposalRepository(autoTx);
    }

    @Override
    public ShowProposalRepository showProposals() {
        return new JpaShowProposalRepository(PERSISTENCE_UNIT_NAME);
    }

    // =====================
    // Drones
    // =====================
    @Override
    public DroneRepository drones() {
        return new JpaDroneRepository(PERSISTENCE_UNIT_NAME);
    }

    // =====================
    // Drone Models
    // =====================
    @Override
    public DroneModelRepository droneModels() {
        return new JpaDroneModelRepository(PERSISTENCE_UNIT_NAME);
    }

    // =====================
    // Figures
    // =====================
    @Override
    public FigureRepository figures() {
        return new JpaFigureRepository(PERSISTENCE_UNIT_NAME);
    }

    @Override
    public FigureCategoryRepository figureCategories() {
        return new JpaFigureCategoryRepository(PERSISTENCE_UNIT_NAME);
    }
}
