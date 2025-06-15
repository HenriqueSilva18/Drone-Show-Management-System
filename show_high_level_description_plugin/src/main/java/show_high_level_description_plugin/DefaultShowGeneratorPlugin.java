package show_high_level_description_plugin;

import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.domain.FigureInShowProposal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DefaultShowGeneratorPlugin {

    private final String dslVersion;

    public DefaultShowGeneratorPlugin(String dslVersion) {
        this.dslVersion = dslVersion;
    }

    public String generateShowDescription(ShowProposal proposal) {
        StringBuilder sb = new StringBuilder();

        // Adicionar a versão no topo
        sb.append("DSL version ").append(dslVersion).append(";\n\n");

        // Início do bloco do show
        sb.append("show {\n\n");

        for (FigureInShowProposal fig : proposal.figuresList()) {
            String figureDSL = fig.figure().dslCode();

            // Remover eventuais cabeçalhos duplicados de DSL version
            figureDSL = figureDSL.replaceFirst("(?i)DSL version\\s+\\d+(\\.\\d+)*;\\s*", "");

            sb.append(figureDSL.trim()).append("\n\n");
        }

        // Fim do bloco do show
        sb.append("}\n");

        return sb.toString();
    }

    public void writeToFile(String filename, String content) throws Exception {
        Path outputDir = Paths.get("show_high_level_description_plugin/output");
        Files.createDirectories(outputDir);

        Path outputFile = outputDir.resolve(filename);
        Files.writeString(outputFile, content);
    }
}
