package drone_plugin;

import drone_plugin.generated_code.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class DroneValidator {
	private static class DroneSyntaxListener extends DroneTwoBaseListener {
		private final List<String> syntaxErrors = new ArrayList<>();

		@Override
		public void enterFigureDeclaration(DroneTwoParser.FigureDeclarationContext ctx) {
			// Check if figure has a valid name
			if (ctx.ID() == null) {
				syntaxErrors.add("Figure must have a name");
			}
		}

		@Override
		public void enterCommand(DroneTwoParser.CommandContext ctx) {
			// Additional syntax checks can be added here
		}

		public List<String> getSyntaxErrors() {
			return syntaxErrors;
		}
	}

	private static class DroneSemanticAnalyzer extends DroneTwoBaseVisitor<Void> {
		private final Map<String, Set<String>> figureCapabilities = new HashMap<>();
		private final Map<String, String> variables = new HashMap<>();
		private final List<String> errors = new ArrayList<>();
		private String currentFigure = null;

		@Override
		public Void visitFigureDeclaration(DroneTwoParser.FigureDeclarationContext ctx) {
			currentFigure = ctx.ID().getText();
			figureCapabilities.put(currentFigure, new HashSet<>());

			if (ctx.droneCapabilities() != null) {
				for (DroneTwoParser.CapabilityContext cap : ctx.droneCapabilities().capability()) {
					figureCapabilities.get(currentFigure).add(cap.getText());
				}
			}

			visitChildren(ctx);
			currentFigure = null;
			return null;
		}

		@Override
		public Void visitVariableDeclaration(DroneTwoParser.VariableDeclarationContext ctx) {
			String type = ctx.type().getText();
			String name = ctx.ID().getText();

			if (variables.containsKey(name)) {
				errors.add("Variable " + name + " already declared");
			}
			variables.put(name, type);

			return visitChildren(ctx);
		}

		@Override
		public Void visitCommand(DroneTwoParser.CommandContext ctx) {
			if (currentFigure == null) {
				errors.add("Commands must be inside a figure declaration");
				return null;
			}

			// Validate command capabilities
			if (ctx.lightsOn() != null || ctx.lightsOff() != null) {
				validateCapability("LED");
			} else if (ctx.moveCircleAngle() != null || ctx.moveCircleDuration() != null) {
				validateCapability("ROTATION");
			} else if (ctx.movePoint() != null || ctx.moveVector() != null || ctx.movePath() != null) {
				validateCapability("TRANSLATION");
			} else if (ctx.hoover() != null) {
				validateCapability("HOVER");
			}

			return visitChildren(ctx);
		}

		private void validateCapability(String capability) {
			if (!figureCapabilities.get(currentFigure).contains(capability)) {
				errors.add("Figure " + currentFigure + " requires " + capability + " capability");
			}
		}

		public List<String> getErrors() {
			return errors;
		}
	}

	public static void validate(Path path) throws IOException {
		CharStream input = CharStreams.fromPath(path);
		DroneTwoLexer lexer = new DroneTwoLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		DroneTwoParser parser = new DroneTwoParser(tokens);

		// Syntax validation using both error listener and syntax listener
		parser.removeErrorListeners();
		parser.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
					int line, int charPositionInLine, String msg, RecognitionException e) {
				throw new RuntimeException("❌ Syntax error at line " + line + ": " + msg);
			}
		});

		ParseTree tree = parser.program();

		// Additional syntax validation using listener
		ParseTreeWalker walker = new ParseTreeWalker();
		DroneSyntaxListener syntaxListener = new DroneSyntaxListener();
		walker.walk(syntaxListener, tree);

		List<String> syntaxErrors = syntaxListener.getSyntaxErrors();
		if (!syntaxErrors.isEmpty()) {
			System.out.println("❌ Syntax errors found:");
			for (String error : syntaxErrors) {
				System.out.println("  - " + error);
			}
			throw new RuntimeException("Syntax validation failed");
		}

		// Semantic validation using visitor
		DroneSemanticAnalyzer analyzer = new DroneSemanticAnalyzer();
		analyzer.visit(tree);

		List<String> semanticErrors = analyzer.getErrors();
		if (!semanticErrors.isEmpty()) {
			System.out.println("❌ Semantic errors found:");
			for (String error : semanticErrors) {
				System.out.println("  - " + error);
			}
			throw new RuntimeException("Semantic validation failed");
		}

		System.out.println("✅ Script is valid according to DroneTwo grammar and semantics.");
	}

	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.out.println("Usage: DroneValidator <script_path>");
			System.exit(1);
		}
		Path path = Path.of(args[0]);
		validate(path);
	}
}
