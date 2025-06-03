package main.java.drone_plugin;

import drone_plugin.generated_code.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.file.*;

public class DroneValidator {
    public static void validate(Path path) throws IOException {
        CharStream input = CharStreams.fromPath(path);
        DroneTwoLexer lexer = new DroneTwoLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DroneTwoParser parser = new DroneTwoParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                    int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new RuntimeException("❌ Erro de parsing na linha " + line + ": " + msg);
            }
        });

        parser.program();
        System.out.println("✅ Script válido segundo a gramática DroneTwo.");
    }

    public static void main(String[] args) throws IOException {
        Path path = Path.of("scripts/drone_script.txt");
        validate(path);
    }
}
