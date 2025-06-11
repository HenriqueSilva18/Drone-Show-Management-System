/* package lapr4.infrastructure.bootstrapers.demo;

import eapli.framework.actions.Action;
import lapr4.droneModelManagement.application.DroneModelService;
import lapr4.droneModelManagement.domain.DroneModel;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.droneModelManagement.domain.Language;


import java.util.Arrays;
import java.util.List;

public class DroneModelBootstraper implements Action {

    private final DroneModelService droneModelService = new DroneModelService();


    @Override
    public boolean execute() {
        System.out.println("Bootstrapping Drone Models...");


        // Criar Languages
        Language javaLanguage = new Language("JAVA");
        Language pythonLanguage = new Language("PYTHON");

        // Criar DroneModels
        List<String> specs1 = Arrays.asList("Peso: 1.5kg", "Autonomia: 30min", "Velocidade Máx: 50km/h");
        droneModelService.registerDroneModel(new DroneModel(specs1, "Phantom 4 Pro", javaLanguage));

        List<String> specs2 = Arrays.asList("Peso: 2.0kg", "Autonomia: 45min", "Velocidade Máx: 80km/h", "Câmara 4K");
        droneModelService.registerDroneModel(new DroneModel(specs2, "Mavic 2 Pro", pythonLanguage));

        List<String> specs3 = Arrays.asList("Peso: 5.0kg", "Autonomia: 60min", "Velocidade Máx: 120km/h", "GPS Avançado");
        droneModelService.registerDroneModel(new DroneModel(specs3, "Inspire 2", javaLanguage));

        System.out.println("Drone Models bootstrapped successfully.");
        return true;
    }
}

 */