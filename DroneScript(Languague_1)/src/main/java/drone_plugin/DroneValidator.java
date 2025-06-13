package drone_plugin;

import drone_plugin.generated_code.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class DroneValidator {
	private static class DroneSyntaxListener extends DroneOneBaseListener {
		private final List<String> errors = new ArrayList<>();
		private boolean insideFigure = false;
		private Set<String> declaredCapabilities = new HashSet<>();

		public List<String> getErrors() {
			return errors;
		}

		@Override
		public void enterFigure(DroneOneParser.FigureContext ctx) {
			insideFigure = true;
			declaredCapabilities.clear();
			for (DroneOneParser.CapabilityContext cap : ctx.capabilities().capability()) {
				declaredCapabilities.add(cap.getText());
			}
		}

		@Override
		public void exitFigure(DroneOneParser.FigureContext ctx) {
			insideFigure = false;
			declaredCapabilities.clear();
		}

		@Override
		public void enterCommand(DroneOneParser.CommandContext ctx) {
			if (!insideFigure) {
				errors.add("Line " + ctx.getStart().getLine() + ": Command must be inside a figure block");
				return;
			}

			// Check required capabilities for each command type
			if (ctx.movePosition() != null || ctx.moveVector() != null || ctx.movePath() != null) {
				checkCapability("TRANSLATION", ctx);
			} else if (ctx.hoover() != null) {
				checkCapability("HOVER", ctx);
			} else if (ctx.lightsOn() != null || ctx.lightsOff() != null || ctx.blink() != null) {
				checkCapability("LED", ctx);
			}
		}

		private void checkCapability(String required, ParserRuleContext ctx) {
			if (!declaredCapabilities.contains(required)) {
				errors.add("Line " + ctx.getStart().getLine() + ": Command requires " + required + " capability");
			}
		}

		@Override
		public void enterVariableDeclaration(DroneOneParser.VariableDeclarationContext ctx) {
			String type = ctx.type().getText();
			if (!isValidType(type)) {
				errors.add("Line " + ctx.getStart().getLine() + ": Invalid type '" + type + "'");
			}
		}

		private boolean isValidType(String type) {
			return Arrays.asList("Position", "Vector", "LinearVelocity", "AngularVelocity", "Distance", "Time")
					.contains(type);
		}
	}

	private static class DroneSemanticAnalyzer extends DroneOneBaseVisitor<Void> {
		private final List<String> errors = new ArrayList<>();
		private final Map<String, String> variables = new HashMap<>();
		private final Set<String> figures = new HashSet<>();

		public List<String> getErrors() {
			return errors;
		}

		@Override
		public Void visitFigure(DroneOneParser.FigureContext ctx) {
			String figureName = ctx.ID().getText();
			if (figures.contains(figureName)) {
				errors.add("Line " + ctx.getStart().getLine() + ": Figure '" + figureName + "' is already defined");
			} else {
				figures.add(figureName);
			}
			return visitChildren(ctx);
		}

		@Override
		public Void visitVariableDeclaration(DroneOneParser.VariableDeclarationContext ctx) {
			String id = ctx.ID().getText();
			String type = ctx.type().getText();

			if (variables.containsKey(id)) {
				errors.add("Line " + ctx.getStart().getLine() + ": Variable '" + id + "' is already declared");
			} else {
				variables.put(id, type);
			}

			return visitChildren(ctx);
		}

		@Override
		public Void visitValue(DroneOneParser.ValueContext ctx) {
			if (ctx.ID() != null) {
				String id = ctx.ID().getText();
				if (!variables.containsKey(id)) {
					errors.add("Line " + ctx.getStart().getLine() + ": Variable '" + id + "' is not declared");
				}
			}
			return visitChildren(ctx);
		}
	}

	public static void validate(Path path) throws IOException {
		CharStream input = CharStreams.fromPath(path);
		DroneOneLexer lexer = new DroneOneLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		DroneOneParser parser = new DroneOneParser(tokens);

		// Syntax error handling
		parser.removeErrorListeners();
		parser.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
					int line, int charPositionInLine, String msg, RecognitionException e) {
				throw new RuntimeException("Line " + line + ": " + msg);
			}
		});

		// Parse and get the parse tree
		ParseTree tree = parser.program();

		// Syntax validation
		DroneSyntaxListener syntaxListener = new DroneSyntaxListener();
		ParseTreeWalker.DEFAULT.walk(syntaxListener, tree);

		List<String> syntaxErrors = syntaxListener.getErrors();
		if (!syntaxErrors.isEmpty()) {
			System.err.println("Syntax validation errors:");
			syntaxErrors.forEach(System.err::println);
			throw new RuntimeException("Syntax validation failed");
		}

		// Semantic validation
		DroneSemanticAnalyzer semanticAnalyzer = new DroneSemanticAnalyzer();
		semanticAnalyzer.visit(tree);

		List<String> semanticErrors = semanticAnalyzer.getErrors();
		if (!semanticErrors.isEmpty()) {
			System.err.println("Semantic validation errors:");
			semanticErrors.forEach(System.err::println);
			throw new RuntimeException("Semantic validation failed");
		}

		System.out.println("Script validation successful");
	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("Usage: java DroneValidator <script_file>");
			System.exit(1);
		}
		validate(Path.of(args[0]));
	}
}
