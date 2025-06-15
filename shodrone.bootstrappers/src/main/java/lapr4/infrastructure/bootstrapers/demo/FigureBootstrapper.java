package lapr4.infrastructure.bootstrapers.demo;

import eapli.framework.actions.Action;

import lapr4.customermanagement.domain.VAT;
import lapr4.droneModelManagement.application.DroneTypeController;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.figureManagement.application.FigureCategoryController;
import lapr4.figureManagement.application.FigureController;
import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.domain.FigureCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class FigureBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(FigureBootstrapper.class);

    private final FigureController figureController;
    private final FigureCategoryController figureCategoryController;
    private final DroneTypeController droneTypeController;

    public FigureBootstrapper() {
        this.figureController = new FigureController();
        this.figureCategoryController = new FigureCategoryController();
        this.droneTypeController = new DroneTypeController();
    }

    @Override
    public boolean execute() {
        try {
            // --- Registar categorias sem duplicados ---
            List<FigureCategory> categories = new ArrayList<>();

            categories.add(findOrCreateCategory("Ct1", "Shows para celebrações festiva"));
            categories.add(findOrCreateCategory("Ct2", "Espetáculos para eventos empresarial"));
            categories.add(findOrCreateCategory("Ct3", "Espetáculos com foco artísticos"));

            // --- Registar drone types sem duplicados ---
            DroneType eagleEye = findOrCreateDroneType("Dronet1", "High precision droness");
            DroneType swiftLight = findOrCreateDroneType("Dronet2", "Lightweight and fast droness");
            DroneType skyTracker = findOrCreateDroneType("Dronet3", "Drone with GPS trackings");
            DroneType phantomRay = findOrCreateDroneType("Dronet4", "Stealth drone with advanced feature");
            DroneType falconX = findOrCreateDroneType("Dronet5", "High-performance drone for aerial show");

            List<DroneType> droneTypes = List.of(
                    eagleEye,
                    swiftLight,
                    skyTracker,
                    phantomRay,
                    falconX
            );

            // --- Criar VATs simulados (não verificados para duplicados aqui, pois são objetos simples) ---
            List<VAT> vats = List.of(
                    new VAT("PT123456794"),
                    new VAT("PT987654325"),
                    new VAT("PT192837468"),
                    new VAT("PT564738299"),
                    new VAT("PT111222339")
            );

            // --- Criar e registar 10 figuras, evitando duplicados ---
            for (int i = 1; i <= 10; i++) {
                String description = "Figures " + i;

                // Verifica se a figura já existe para evitar duplicados


                Set<String> keywords = new HashSet<>(Arrays.asList("theme" + i, "effect" + (i + 1)));
                boolean exclusive = (i % 2 == 0);

                FigureCategory category = categories.get(i % categories.size());
                VAT clientVAT = vats.get(i % vats.size());

                String dslCode = "figure_" + i + "() { // animation DSL }";
                String dslVersion = "v1." + i;

                List<DroneType> assignedDrones = new ArrayList<>();
                assignedDrones.add(droneTypes.get(i % droneTypes.size()));
                assignedDrones.add(droneTypes.get((i + 1) % droneTypes.size()));

                findOrCreateFigure(description, keywords, exclusive, clientVAT, category, dslCode, dslVersion, assignedDrones);

                LOGGER.info("Figure '{}' registrada com sucesso.", description);
            }

        } catch (Exception e) {
            LOGGER.error("Erro no bootstrap: {}", e.getMessage(), e);
            return false;
        }

        return true;
    }

    // Método auxiliar para buscar ou criar categoria
    private FigureCategory findOrCreateCategory(String name, String description) {
            return figureCategoryController.findByName(name)
                    .orElseGet(() -> figureCategoryController.addFigureCategory(name, description));
    }


    // Método auxiliar para buscar ou criar drone type
    private DroneType findOrCreateDroneType(String name, String description) {
        try {
            return droneTypeController.findByName(name);
        } catch (IllegalArgumentException e) {
            // Não existe, cria um novo
            DroneType droneType = droneTypeController.registerDroneType(name, description);
            LOGGER.info("DroneType '{}' criado.", name);
            return droneType;
        }

    }

    private Figure findOrCreateFigure(String description, Set<String> keywords, boolean exclusive,
                                      VAT clientVAT, FigureCategory category, String dslCode,
                                      String dslVersion, List<DroneType> assignedDrones) {
        try {
            return figureController.findByDescription(description);
        } catch (IllegalArgumentException e) {
            Figure figure = new Figure(description, keywords, exclusive, clientVAT, category, dslCode, dslVersion, assignedDrones);
            figureController.addFigure(figure);
            LOGGER.info("Figura '{}' criada.", description);
            return figure;
        }
    }

}
