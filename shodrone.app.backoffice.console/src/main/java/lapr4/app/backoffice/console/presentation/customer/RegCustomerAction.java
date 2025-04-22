package lapr4.app.backoffice.console.presentation.customer;

import eapli.framework.actions.Action;

public class RegCustomerAction implements Action {
    @Override
    public boolean execute() {
        return new RegCustomerUI().show();
    }
}
