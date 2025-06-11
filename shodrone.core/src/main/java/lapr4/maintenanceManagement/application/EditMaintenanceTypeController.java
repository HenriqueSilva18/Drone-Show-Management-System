package lapr4.maintenanceManagement.application;

import jakarta.transaction.Transactional;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.maintenanceManagement.domain.MaintenanceType;
import lapr4.maintenanceManagement.repositories.MaintenanceTypeRepository;
import lapr4.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class EditMaintenanceTypeController {

	private final AuthorizationService authz = AuthzRegistry.authorizationService();
	private final MaintenanceTypeRepository repo = PersistenceContext.repositories().maintenanceTypes();

	@Transactional
	public MaintenanceType edit(Long id, String newName, String newDescription) {
		authz.ensureAuthenticatedUserHasAnyOf(Roles.ADMIN, Roles.POWER_USER, Roles.CRM_COLLABORATOR, Roles.DRONE_TECH);

		MaintenanceType type = repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Tipo de manutenção não encontrado com ID: " + id));

		type.update(newName, newDescription);
		return repo.save(type);
	}
}
