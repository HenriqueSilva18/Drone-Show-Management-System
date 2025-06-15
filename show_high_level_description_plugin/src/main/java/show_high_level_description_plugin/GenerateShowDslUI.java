package show_high_level_description_plugin;

import lapr4.customermanagement.domain.VAT;
import lapr4.figureManagement.domain.Figure;
import lapr4.figureManagement.domain.FigureCategory;
import lapr4.showProposalManagement.domain.FigureInShowProposal;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.droneModelManagement.domain.DroneType;
import lapr4.droneModelManagement.domain.DroneModel;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class GenerateShowDslUI {

    private static final String BASE_PATH = "docs/data/";
    private static final String OUTPUT_PATH = "output/show_description.dsl";

    public void show() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduz o nome do ficheiro da show proposal (ex: Proposta_mod_01.txt): ");
        String filename = sc.nextLine().trim();

        List<String> figureNames;
        try {
            figureNames = extractFigureNames(BASE_PATH + filename);
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro da show proposal: " + e.getMessage());
            return;
        }

        if (figureNames.isEmpty()) {
            System.out.println("Nenhuma figura encontrada na proposta.");
            return;
        }

        List<FigureInShowProposal> figures = new ArrayList<>();
        String dslVersion = null;

        for (String name : figureNames) {
            String number = name.replaceAll("[^0-9]", "");
            String samplePath = BASE_PATH + "sample_DSL_figure_" + number + ".txt";

            try {
                List<String> lines = Files.readAllLines(Path.of(samplePath));
                String dslLine = lines.get(0).trim();

                if (!dslLine.toLowerCase().startsWith("dsl version")) {
                    System.out.println("Primeira linha inválida no ficheiro: " + samplePath);
                    continue;
                }

                String version = dslLine.split(" ")[2].replace(";", "").trim();
                String dslCode = String.join("\n", lines);

                VAT vat = new VAT("PT999999");
                FigureCategory dummyCategory = new FigureCategory("TEMP", "Temporary category");
                List<DroneType> dummyTypes = new ArrayList<>();
                Figure fig = new Figure("Figura nº " + number, false, vat, dummyCategory, dslCode, version, dummyTypes);

                Map<DroneType, DroneModel> dummyMap = new HashMap<>();
                figures.add(new FigureInShowProposal(fig, dummyMap));

                if (dslVersion == null) dslVersion = version;

            } catch (Exception e) {
                System.out.println("Erro ao ler " + samplePath + ": " + e.getMessage());
            }
        }

        if (figures.isEmpty()) {
            System.out.println("Nenhuma figura válida foi criada.");
            return;
        }

        if (dslVersion == null) {
            System.out.println("Não foi possível extrair a versão DSL.");
            return;
        }

        try {
            ShowProposal proposal = ShowProposal.from(new VAT("PT999999"), figures);
            String output = new DefaultShowGeneratorPlugin(dslVersion).generateShowDescription(proposal);

            Files.createDirectories(Paths.get("output"));
            Files.writeString(Path.of(OUTPUT_PATH), output);

            System.out.println("DSL gerado com sucesso em: " + OUTPUT_PATH);

        } catch (Exception e) {
            System.out.println("Erro ao gerar o DSL: " + e.getMessage());
        }
    }

    private static List<String> extractFigureNames(String filePath) throws IOException {
        List<String> figureNames = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        boolean found = false;

        for (String line : lines) {
            if (line.trim().startsWith("#Lista de figuras")) {
                found = true;
                continue;
            }

            if (found && line.matches("\\d+\\s*[-–:]\\s*\\w+")) {
                String[] parts = line.split("[-–:]");
                if (parts.length > 1) {
                    figureNames.add(parts[1].trim());
                }
            } else if (found && line.trim().isEmpty()) {
                break;
            }
        }

        return figureNames;
    }
}
