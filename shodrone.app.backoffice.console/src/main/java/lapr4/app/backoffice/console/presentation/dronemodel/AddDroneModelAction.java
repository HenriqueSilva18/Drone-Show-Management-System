package lapr4.app.backoffice.console.presentation.dronemodel;

import eapli.framework.actions.Action;

public class AddDroneModelAction implements Action {
    @Override
    public boolean execute() {
        return new AddDroneModelUI().show();
    }
}
