package lapr4.app.backoffice.console.presentation.dronemodel;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.droneModelManagement.application.DroneTypeController;
import lapr4.droneModelManagement.domain.DroneType;

import java.util.ArrayList;
import java.util.List;

public class EditDroneTypeUI extends AbstractUI {

    private final DroneTypeController controller = new DroneTypeController();

    @Override
    protected boolean doShow() {
        Iterable<DroneType> types = controller.listAllTypes();
        List<DroneType> list = new ArrayList<>();
        types.forEach(list::add);

        if (list.isEmpty()) {
            System.out.println("⚠️ There is not any category available.");
            return false;
        }

        int i = 1;
        for (DroneType type : list) {
            System.out.printf("%d - Name: %s | Description: %s%n", i, type.getName(), type.getDescription());
            i++;
        }
        int option = Console.readInteger("Select a type to edit (1-" + list.size() + "): ");
        DroneType selected = list.get(option - 1);
        final String newDesc = Console.readLine("New description for type '" + selected.getName() + "': ");
        try {
            DroneType updated = controller.editDroneTypeDescription(selected.identity(), newDesc);
            System.out.println("✅ Type Updated: " + updated.getDescription());
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Edit Drone Type";
    }
}
