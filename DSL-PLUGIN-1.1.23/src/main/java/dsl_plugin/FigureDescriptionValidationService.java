package dsl_plugin;

import dsl_plugin.generated_code.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

public class FigureDescriptionValidationService {

    public ValidationResult validateFigureDescription(String dslCode) {
        if (dslCode == null || dslCode.trim().isEmpty()) {
            return ValidationResult.invalid("DSL code cannot be empty");
        }

        try {
            DSL_GRAMMARLexer lexer = new DSL_GRAMMARLexer(CharStreams.fromString(dslCode));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            DSL_GRAMMARParser parser = new DSL_GRAMMARParser(tokens);

            ValidationErrorListener errorListener = new ValidationErrorListener();
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);

            DSL_GRAMMARParser.ProgramContext programContext = parser.program();

            if (errorListener.hasErrors()) {
                return ValidationResult.invalid(errorListener.getErrors());
            }

            // Usar DSL_FIGUREBaseListener obrigatoriamente
            DSLValidationListener listener = new DSLValidationListener();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, programContext);

            // Usar DSL_FIGUREBaseVisitor para validações adicionais
            DSLValidationVisitor visitor = new DSLValidationVisitor();
            String parsedVersion = visitor.visit(programContext);

            // Verificar se a versão foi encontrada
            if (parsedVersion == null || parsedVersion.trim().isEmpty()) {
                return ValidationResult.invalid("DSL version not found in the provided code");
            }

            // Validações adicionais podem ser feitas aqui
            List<String> additionalErrors = performAdditionalValidations(listener, visitor);
            if (!additionalErrors.isEmpty()) {
                return ValidationResult.invalid(additionalErrors);
            }

            return ValidationResult.valid(parsedVersion);

        } catch (Exception e) {
            return ValidationResult.invalid("Erro na validação: " + e.getMessage());
        }
    }

    // Método para validações adicionais usando dados coletados
    private List<String> performAdditionalValidations(DSLValidationListener listener, DSLValidationVisitor visitor) {
        List<String> errors = new ArrayList<>();

        // Exemplo: verificar se há pelo menos uma declaração de figura
        if (listener.getFigureDeclarationCount() == 0) {
            errors.add("Nenhuma declaração de figura encontrada");
        }

        // Exemplo: verificar se há ações definidas
        if (listener.getActionCount() == 0) {
            errors.add("Nenhuma ação definida para as figuras");
        }

        return errors;
    }
}

// Listener usando DSL_FIGUREBaseListener obrigatoriamente
class DSLValidationListener extends DSL_GRAMMARBaseListener {
    private String dslVersion;
    private int figureDeclarationCount = 0;
    private int actionCount = 0;
    private List<String> droneTypes = new ArrayList<>();
    private List<String> positions = new ArrayList<>();

    @Override
    public void enterDslVersion(DSL_GRAMMARParser.DslVersionContext ctx) {
        if (ctx.VERSION() != null) {
            this.dslVersion = ctx.VERSION().getText();
        }
    }

    @Override
    public void enterFigureDeclaration(DSL_GRAMMARParser.FigureDeclarationContext ctx) {
        figureDeclarationCount++;
    }

    @Override
    public void enterDroneTypeDeclaration(DSL_GRAMMARParser.DroneTypeDeclarationContext ctx) {
        if (ctx.ID() != null) {
            droneTypes.add(ctx.ID().getText());
        }
    }

    @Override
    public void enterPositionDeclaration(DSL_GRAMMARParser.PositionDeclarationContext ctx) {
        if (ctx.ID() != null) {
            positions.add(ctx.ID().getText());
        }
    }

    @Override
    public void enterLightsOnAction(DSL_GRAMMARParser.LightsOnActionContext ctx) {
        actionCount++;
    }

    @Override
    public void enterLightsOffAction(DSL_GRAMMARParser.LightsOffActionContext ctx) {
        actionCount++;
    }

    @Override
    public void enterMoveAction(DSL_GRAMMARParser.MoveActionContext ctx) {
        actionCount++;
    }

    @Override
    public void enterMovePosAction(DSL_GRAMMARParser.MovePosActionContext ctx) {
        actionCount++;
    }

    @Override
    public void enterRotateAction(DSL_GRAMMARParser.RotateActionContext ctx) {
        actionCount++;
    }

    // Getters
    public String getDslVersion() { return dslVersion; }
    public int getFigureDeclarationCount() { return figureDeclarationCount; }
    public int getActionCount() { return actionCount; }
    public List<String> getDroneTypes() { return new ArrayList<>(droneTypes); }
    public List<String> getPositions() { return new ArrayList<>(positions); }
}

// Visitor usando DSL_FIGUREBaseVisitor obrigatoriamente
class DSLValidationVisitor extends DSL_GRAMMARBaseVisitor<String> {

    @Override
    public String visitProgram(DSL_GRAMMARParser.ProgramContext ctx) {
        if (ctx.dslVersion() != null) {
            return visit(ctx.dslVersion());
        }
        return null;
    }

    @Override
    public String visitDslVersion(DSL_GRAMMARParser.DslVersionContext ctx) {
        if (ctx.VERSION() != null) {
            return ctx.VERSION().getText();
        }
        return null;
    }

    // Validações específicas usando visitor
    @Override
    public String visitFigureDeclaration(DSL_GRAMMARParser.FigureDeclarationContext ctx) {
        // Aqui pode fazer validações específicas de figuras
        // Por exemplo, verificar se os IDs referenciados existem
        return visitChildren(ctx);
    }
}
