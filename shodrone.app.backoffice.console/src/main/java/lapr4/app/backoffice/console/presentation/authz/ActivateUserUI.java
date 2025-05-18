package lapr4.app.backoffice.console.presentation.authz;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.usermanagement.application.ActivateUserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("squid:S106")
public class ActivateUserUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivateUserUI.class);
    private static final String CUSTOMER_REPRESENTATIVE_ROLE = "CUSTOMER_REPRESENTATIVE";

    private final ActivateUserController theController = new ActivateUserController();

    @Override
    protected boolean doShow() {
        final List<SystemUser> list = new ArrayList<>();
        final Iterable<SystemUser> iterable = this.theController.deactiveUsers();
        if (!iterable.iterator().hasNext()) {
            System.out.println("There is no registered User");
        } else {
            int cont = 1;
            System.out.println("SELECT User to activate\n");
            System.out.printf("%-6s%-15s%-30s%-30s%n", "Nº:", "Username", "Firstname", "Lastname");
            for (final SystemUser user : iterable) {
                if (isRepresentative(user)) {
                    continue;
                }
                list.add(user);
                System.out.printf("%-6d%-15s%-30s%-30s%n", cont, user.username(), user.name().firstName(),
                        user.name().lastName());
                cont++;
            }
            if (list.isEmpty()) {
                System.out.println("There are no users available to activate");
                return false;
            }
            final int option = Console.readInteger("Enter user nº to activate or 0 to finish ");
            if (option == 0) {
                System.out.println("No user selected");
            } else if (option < 1 || option > list.size()) {
                System.out.println("Invalid user number selected");
            } else {
                try {
                    this.theController.activateUser(list.get(option - 1));
                } catch (IntegrityViolationException | ConcurrencyException ex) {
                    LOGGER.error("Error performing the operation", ex);
                    System.out.println(
                            "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
                }
            }
        }
        return true;
    }

    private boolean isRepresentative(SystemUser user) {
        for (Role role : user.roleTypes()) {
            if (role.toString().equals(CUSTOMER_REPRESENTATIVE_ROLE)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "Activate User";
    }
}


