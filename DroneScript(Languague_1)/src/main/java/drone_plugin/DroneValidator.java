package main.java.drone_plugin;


import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.file.*;

public class DroneValidator {
    public static void validate(Path path) throws IOException {
        CharStream input = CharStreams.fromPath(path);
        drone_plugin.generated_code.DroneOneLexer lexer = new drone_plugin.generated_code.DroneOneLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        drone_plugin.generated_code.DroneOneParser parser = new drone_plugin.generated_code.DroneOneParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                    int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new RuntimeException(" Erro de parsing na linha " + line + ": " + msg);
            }
        });

        parser.program();
        System.out.println(" Script válido segundo a gramática.");
    }

    public static void main(String[] args) throws IOException {
        Path path = Path.of("scripts/drone_script.txt");
        validate(path);
    }
}
