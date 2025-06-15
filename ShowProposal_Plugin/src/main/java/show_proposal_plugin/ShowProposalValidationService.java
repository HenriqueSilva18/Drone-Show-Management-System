package show_proposal_plugin;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import show_proposal_plugin.generated_code.ShowProposalBaseListener;
import show_proposal_plugin.generated_code.ShowProposalBaseVisitor;
import show_proposal_plugin.generated_code.ShowProposalLexer;
import show_proposal_plugin.generated_code.ShowProposalParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Serviço responsável por validar a semântica e as regras de negócio
 * de um documento de Proposta de Espetáculo.
 */
public class ShowProposalValidationService {

    /**
     * Método principal que executa a validação da proposta.
     *
     * @param proposalText O texto completo da proposta a ser validada.
     * @return Uma lista de erros de validação. Se a lista estiver vazia, a proposta é válida.
     */
    public List<String> validate(String proposalText) {
        // Lista para acumular os erros encontrados
        List<String> errors = new ArrayList<>();

        // 1. Criar a árvore de parsing a partir do texto
        ShowProposalParser parser = createParser(proposalText);
        ParseTree tree = parser.document();

        // 2. Usar o Listener para validações de regras simples e contextuais
        ShowProposalValidationListener listener = new ShowProposalValidationListener(errors);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        // 3. Usar o Visitor para validações que podem necessitar de retorno ou lógica complexa
        ShowProposalValidationVisitor visitor = new ShowProposalValidationVisitor(errors);
        visitor.visit(tree);

        return errors;
    }

    public List<String> validateFilePath(String filePath) throws IOException {

        Path path = Paths.get(filePath);
        String template = Files.readString(path);

        List<String> errors = validate(template);

        return errors;
    }

    private ShowProposalParser createParser(String text) {
        ShowProposalLexer lexer = new ShowProposalLexer(CharStreams.fromString(text));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new ShowProposalParser(tokens);
    }

    /**
     * Inner class: Listener para validações semânticas.
     * Percorre a árvore e verifica regras à medida que "entra" em cada nó.
     */
    private static class ShowProposalValidationListener extends ShowProposalBaseListener {
        private final List<String> errors;

        public ShowProposalValidationListener(List<String> errors) {
            this.errors = errors;
        }

        @Override
        public void enterProposal_title(ShowProposalParser.Proposal_titleContext ctx) {
            if (ctx.getText().trim().isEmpty()) {
                errors.add("Erro de Validação (Listener): O título da proposta não pode estar vazio.");
            }
        }

        @Override
        public void enterList_drones(ShowProposalParser.List_dronesContext ctx) {
            if (ctx.list_drone_items() == null || ctx.list_drone_items().isEmpty()) {
                errors.add("Erro de Validação (Listener): A lista de drones no anexo não pode estar vazia.");
            }
        }
    }

    /**
     * Inner class: Visitor para validações mais complexas.
     * Permite controlar o percurso e retornar valores.
     */
    private static class ShowProposalValidationVisitor extends ShowProposalBaseVisitor<Object> {
        private final List<String> errors;

        public ShowProposalValidationVisitor(List<String> errors) {
            this.errors = errors;
        }

        @Override
        public Object visitVat_number(ShowProposalParser.Vat_numberContext ctx) {
            String vat = ctx.getText().trim();



            if (vat.equals("[VAT Number]")) {
                return super.visitVat_number(ctx);
            }

            if (!vat.toUpperCase().startsWith("PT")) {
                errors.add("Erro de Validação (Visitor): O VAT number deve ser um número de contribuinte português (iniciar com 'PT').");
            }
            return super.visitVat_number(ctx);
        }
    }
}