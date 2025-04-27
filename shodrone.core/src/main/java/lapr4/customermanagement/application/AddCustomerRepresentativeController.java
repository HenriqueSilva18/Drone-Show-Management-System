package lapr4.customermanagement.application;

import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.customermanagement.application.RegCustomerController.RepresentativeData;
import lapr4.customermanagement.domain.*;
import lapr4.usermanagement.application.AddUserController;
import jakarta.transaction.Transactional;
import eapli.framework.application.ApplicationService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@ApplicationService
public class AddCustomerRepresentativeController {
	private final CustomerService customerService;
	private final AddUserController userController;

	public AddCustomerRepresentativeController() {
		this.customerService = new CustomerService();
		this.userController = new AddUserController();
	}

	public Customer findCustomerByVAT(String vatNumber) {
		Optional<Customer> customer = customerService.findCustomerByVAT(vatNumber);
		return customer.orElse(null);
	}

	@Transactional
	public void addRepresentative(String customerVAT, RepresentativeData repData) {
		Customer customer = customerService.findCustomerByVAT(customerVAT)
				.orElseThrow(
						() -> new IllegalArgumentException("Can't find customer with this VAT number: " + customerVAT));

		Set<Role> roles = new HashSet<>();
		roles.add(Role.valueOf("CUSTOMER_REPRESENTATIVE"));

		SystemUser systemUser = userController.addUser(
				repData.username,
				repData.password,
				repData.firstName,
				repData.lastName,
				repData.email,
				roles);

		Representative representative = new RepresentativeBuilder()
				.withName(repData.name)
				.withEmail(repData.email)
				.withPosition(repData.position)
				.withSystemUser(systemUser)
				.build();

		customer.addRepresentative(representative);

		customerService.registerCustomer(customer);
	}
}
