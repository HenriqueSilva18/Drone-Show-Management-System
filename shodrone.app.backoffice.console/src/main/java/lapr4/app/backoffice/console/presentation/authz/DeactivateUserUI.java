/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package lapr4.app.backoffice.console.presentation.authz;

import lapr4.usermanagement.application.DeactivateUserController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
@SuppressWarnings("squid:S106")
public class DeactivateUserUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeactivateUserUI.class);
    private static final String CUSTOMER_REPRESENTATIVE_ROLE = "CUSTOMER_REPRESENTATIVE";

    private final DeactivateUserController theController = new DeactivateUserController();

    @Override
    protected boolean doShow() {
        final List<SystemUser> list = new ArrayList<>();
        final Iterable<SystemUser> iterable = this.theController.activeUsers();
        if (!iterable.iterator().hasNext()) {
            System.out.println("There is no registered User");
        } else {
            int cont = 1;
            System.out.println("SELECT User to deactivate\n");
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
                System.out.println("There are no users available to deactivate");
                return false;
            }
            final int option = Console.readInteger("Enter user nº to deactivate or 0 to finish ");
            if (option == 0) {
                System.out.println("No user selected");
            } else if (option < 1 || option > list.size()) {
                System.out.println("Invalid user number selected");
            } else {
                try {
                    this.theController.deactivateUser(list.get(option - 1));
                } catch (IntegrityViolationException | ConcurrencyException ex) {
                    LOGGER.error("Error performing the operation", ex);
                    System.out.println(
                            "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
                } catch (IllegalStateException ex) {
                    System.out.println(ex.getMessage());
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
        return "Deactivate User";
    }
}
