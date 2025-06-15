package lapr4.persistence.impl.inmemory;

import lapr4.customermanagement.repositories.CustomerRepository;
import lapr4.droneManagement.repositories.DroneRepository;
import lapr4.droneModelManagement.repositories.DroneModelRepository;
import lapr4.droneModelManagement.repositories.DroneTypeRepository;
import lapr4.figureManagement.repositories.FigureCategoryRepository;
import lapr4.figureManagement.repositories.FigureRepository;
import lapr4.infrastructure.persistence.RepositoryFactory;
import lapr4.maintenanceManagement.repositories.MaintenanceTypeRepository;
import lapr4.showProposalManagement.repositories.ProposalTemplateRepository;
import lapr4.showRequestManagement.repositories.ShowRequestRepository;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import lapr4.usermanagement.domain.Roles;
import lapr4.usermanagement.domain.UserBuilderHelper;
import lapr4.utentemanagement.repositories.SignupRequestRepository;
import lapr4.utentemanagement.repositories.UtenteRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.inmemory.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

	static {
		InMemoryInitializer.init();
	}

	@Override
	public UserRepository users(final TransactionalContext tx) {
		final var repo = new InMemoryUserRepository();
		// ensure we have at least a power user to be able to use the application
		final var userBuilder = UserBuilderHelper.builder();
		userBuilder.withUsername("poweruser").withPassword("Password1").withName("joe", "power")
				.withEmail("joe@email.org").withRoles(Roles.POWER_USER);
		final var newUser = userBuilder.build();
		repo.save(newUser);
		return repo;
	}

	@Override
	public UserRepository users() {
		return users(null);
	}

	@Override
	public UtenteRepository utentes(final TransactionalContext tx) {
		return new InMemoryUtenteRepository();
	}

	@Override
	public UtenteRepository utentes() {
		return utentes(null);
	}

	@Override
	public CustomerRepository customers(final TransactionalContext tx) {
		return new InMemoryCustomerRepository();
	}

	@Override
	public CustomerRepository customers() {
		return customers(null);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return signupRequests(null);
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext tx) {
		return new InMemorySignupRequestRepository();
	}

	@Override
	public TransactionalContext newTransactionalContext() {
		// in memory does not support transactions...
		return null;
	}

	@Override
	public FigureRepository figures() {
		// Implementando o método figures(). Retorna uma instância de um repositório de figuras.
		return new InMemoryFigureRepository();  // Aqui, você precisa ter a implementação de FigureRepository
	}

	@Override
	public ShowRequestRepository showRequests() {
		return new InMemoryShowRequestRepository();
	}

	@Override
	public ShowRequestRepository showRequests(TransactionalContext tx) {
		return new InMemoryShowRequestRepository();
	}

	@Override
	public DroneRepository drones() {
		return new InMemoryDroneRepository();
	}

	@Override
	public DroneModelRepository droneModels() {
		return new InMemoryDroneModelRepository();
	}

	@Override
	public FigureCategoryRepository figureCategories() {
		return new InMemoryFigureCategoryRepository();
	}

	@Override
	public ShowProposalRepository showProposals() {
		return new InMemoryShowProposalRepository();
	}

	@Override
	public MaintenanceTypeRepository maintenanceTypes() {
		return null;
	}

	@Override
	public ShowProposalRepository showProposals(TransactionalContext tx) {
		return new InMemoryShowProposalRepository();
	}

	@Override
	public ProposalTemplateRepository templates(TransactionalContext tx) {
		return new InMemoryProposalTemplateRepository();
	}

	@Override
	public DroneTypeRepository droneTypes() {
		return new InMemoryDroneTypeRepository();
	}

	@Override
	public ProposalTemplateRepository templates() {
		return new InMemoryProposalTemplateRepository();
	}

}
