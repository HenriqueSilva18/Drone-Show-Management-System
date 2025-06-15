
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

    // Controle de entidades já criadas para evitar duplicações
    private final Set<String> createdCategories = new HashSet<>();
    private final Set<String> createdDroneTypes = new HashSet<>();
    private final Set<String> createdFigures = new HashSet<>();

    public FigureBootstrapper() {
        this.figureController = new FigureController();
        this.figureCategoryController = new FigureCategoryController();
        this.droneTypeController = new DroneTypeController();
    }

    @Override
    public boolean execute() {
        try {
            LOGGER.info("Iniciando bootstrap das entidades...");

            // 1. Criar categorias únicas
            List<FigureCategory> categories = createUniqueCategories();

            // 2. Criar drone types únicos
            List<DroneType> droneTypes = createUniqueDroneTypes();

            // 3. Criar VATs únicos
            List<VAT> vats = createUniqueVATs();

            // 4. Criar figuras únicas
            createUniqueFigures(categories, droneTypes, vats);

            LOGGER.info("Bootstrap concluído com sucesso!");
            return true;

        } catch (Exception e) {
            LOGGER.error("Erro durante o bootstrap: {}", e.getMessage(), e);
            return false;
        }
    }

    private List<FigureCategory> createUniqueCategories() {
        List<FigureCategory> categories = new ArrayList<>();

        String[][] categoryData = {
                {"Celebrações", "Shows para celebrações festivas"},
                {"Empresarial", "Espetáculos para eventos empresariais"},
                {"Artístico", "Espetáculos com foco artístico"}
        };

        for (String[] data : categoryData) {
            String name = data[0];
            String description = data[1];

            if (!createdCategories.contains(name)) {
                FigureCategory category = findOrCreateCategory(name, description);
                if (category != null) {
                    categories.add(category);
                    createdCategories.add(name);
                    LOGGER.info("Categoria '{}' processada.", name);
                }
            } else {
                LOGGER.debug("Categoria '{}' já existe, pulando...", name);
            }
        }

        return categories;
    }

    private List<DroneType> createUniqueDroneTypes() {
        List<DroneType> droneTypes = new ArrayList<>();

        String[][] droneData = {
                {"EagleEye", "Drone de alta precisão para capturas detalhadas"},
                {"SwiftLight", "Drone leve e rápido para manobras ágeis"},
                {"SkyTracker", "Drone com sistema GPS avançado"},
                {"PhantomRay", "Drone stealth com recursos avançados"}
        };

        for (String[] data : droneData) {
            String name = data[0];
            String description = data[1];

            if (!createdDroneTypes.contains(name)) {
                DroneType droneType = findOrCreateDroneType(name, description);
                if (droneType != null) {
                    droneTypes.add(droneType);
                    createdDroneTypes.add(name);
                    LOGGER.info("DroneType '{}' processado.", name);
                } else {
                    LOGGER.warn("Falha ao processar DroneType '{}'", name);
                }

            } else {
                LOGGER.debug("DroneType '{}' já existe, pulando...", name);
            }
        }
        return droneTypes;
    }


private List<VAT> createUniqueVATs() {
    String[] vatNumbers = {
            "PT123456789",
            "PT987654321",
            "PT192837465"
    };

    List<VAT> vats = new ArrayList<>();
    for (String vatNumber : vatNumbers) {
        vats.add(new VAT(vatNumber));
    }

    return vats;
}

private void createUniqueFigures(List<FigureCategory> categories,
                                 List<DroneType> droneTypes,
                                 List<VAT> vats) {

    String[] figureDescriptions = {
            "Formação em V clássica",
            "Espiral ascendente luminosa",
            "Coreografia circular sincronizada"
    };

    for (int i = 0; i < figureDescriptions.length; i++) {
        String description = figureDescriptions[i];

        if (!createdFigures.contains(description)) {
            Set<String> keywords = createKeywords(i);
            boolean exclusive = (i % 2 == 0);

            FigureCategory category = categories.get(i % categories.size());
            VAT clientVAT = vats.get(i % vats.size());

            String dslCode = generateDSLCode(description, i);
            String dslVersion = "v1." + (i + 1);

            List<DroneType> assignedDrones = selectDronesForFigure(droneTypes, i);

            Figure figure = findOrCreateFigure(description, keywords, exclusive,
                    clientVAT, category, dslCode, dslVersion, assignedDrones);

            if (figure != null) {
                createdFigures.add(description);
                LOGGER.info("Figura '{}' processada com sucesso.", description);
            }
        } else {
            LOGGER.debug("Figura '{}' já existe, pulando...", description);
        }
    }
}

private Set<String> createKeywords(int index) {
    Set<String> keywords = new HashSet<>();
    keywords.add("aerial");
    keywords.add("synchronized");

    switch (index) {
        case 0:
            keywords.add("formation");
            keywords.add("classic");
            break;
        case 1:
            keywords.add("spiral");
            keywords.add("luminous");
            break;
        case 2:
            keywords.add("circular");
            keywords.add("choreography");
            break;
    }

    return keywords;
}

private String generateDSLCode(String description, int index) {
    return String.format("figure_%d() {\n    // %s animation DSL\n    sequence: [move, rotate, illuminate]\n}",
            index + 1, description.toLowerCase().replace(" ", "_"));
}

private List<DroneType> selectDronesForFigure(List<DroneType> availableDrones, int figureIndex) {
    List<DroneType> selected = new ArrayList<>();
    Set<String> selectedNames = new HashSet<>();

    // Seleciona drones únicos para cada figura
    if (!availableDrones.isEmpty()) {
        // Primeiro drone
        DroneType firstDrone = availableDrones.get(figureIndex % availableDrones.size());
        selected.add(firstDrone);
        selectedNames.add(firstDrone.name());

        // Segundo drone (diferente do primeiro)
        if (availableDrones.size() > 1) {
            for (int i = 1; i < availableDrones.size(); i++) {
                DroneType candidate = availableDrones.get((figureIndex + i) % availableDrones.size());
                if (!selectedNames.contains(candidate.name())) {
                    selected.add(candidate);
                    break;
                }
            }
        }
    }

    return selected;
}

// Métodos auxiliares melhorados com melhor tratamento de erros
private FigureCategory findOrCreateCategory(String name, String description) {
    try {
        Optional<FigureCategory> existing = figureCategoryController.findByName(name);
        if (existing.isPresent()) {
            LOGGER.debug("Categoria '{}' já existe.", name);
            return existing.get();
        } else {
            FigureCategory category = figureCategoryController.addFigureCategory(name, description);
            LOGGER.info("Categoria '{}' criada.", name);
            return category;
        }
    } catch (Exception e) {
        LOGGER.error("Erro ao processar categoria '{}': {}", name, e.getMessage());
        return null;
    }
}

private DroneType findOrCreateDroneType(String name, String description) {
    try {
        DroneType existing = droneTypeController.findByName(name);
        LOGGER.debug("DroneType '{}' já existe.", name);
        return existing;
    } catch (IllegalArgumentException e) {
        try {
            DroneType droneType = droneTypeController.registerDroneType(name, description);
            LOGGER.info("DroneType '{}' criado.", name);
            return droneType;
        } catch (Exception ex) {
            LOGGER.error("Erro ao criar DroneType '{}': {}", name, ex.getMessage());
            return null;
        }
    }
}

private Figure findOrCreateFigure(String description, Set<String> keywords, boolean exclusive,
                                  VAT clientVAT, FigureCategory category, String dslCode,
                                  String dslVersion, List<DroneType> assignedDrones) {
    try {
        Figure existing = figureController.findByDescription(description);
        LOGGER.debug("Figura '{}' já existe.", description);
        return existing;
    } catch (IllegalArgumentException e) {
        try {
            // Verifica se há drones duplicados na lista antes de criar a figura
            Set<String> droneNames = new HashSet<>();
            List<DroneType> uniqueDrones = new ArrayList<>();

            for (DroneType drone : assignedDrones) {
                if (drone != null && !droneNames.contains(drone.name())) {
                    uniqueDrones.add(drone);
                    droneNames.add(drone.name());
                }
            }

            if (uniqueDrones.isEmpty()) {
                LOGGER.warn("Nenhum drone válido encontrado para a figura '{}'", description);
                return null;
            }

            Figure figure = new Figure(description, keywords, exclusive, clientVAT,
                    category, dslCode, dslVersion, uniqueDrones);
            figureController.addFigure(figure);
            LOGGER.info("Figura '{}' criada com {} drones únicos.", description, uniqueDrones.size());
            return figure;
        } catch (Exception ex) {
            LOGGER.error("Erro ao criar figura '{}': {}", description, ex.getMessage());
            return null;
        }
    }
}
    }

