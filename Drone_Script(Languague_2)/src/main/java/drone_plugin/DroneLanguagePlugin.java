package drone_plugin;

import drone_plugin.generated_code.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class DroneLanguagePlugin {
	private final Map<String, Set<String>> droneModelCapabilities = new HashMap<>();

	public DroneLanguagePlugin() {
		// Initialize with some example drone models and their capabilities
		// In a real implementation, this would be loaded from configuration
		Set<String> basicCapabilities = new HashSet<>(Arrays.asList("TRANSLATION", "HOVER"));
		Set<String> advancedCapabilities = new HashSet<>(Arrays.asList("TRANSLATION", "HOVER", "ROTATION", "LED"));

		droneModelCapabilities.put("BASIC_DRONE", basicCapabilities);
		droneModelCapabilities.put("ADVANCED_DRONE", advancedCapabilities);
	}

	public void registerDroneModel(String model, Set<String> capabilities) {
		droneModelCapabilities.put(model, new HashSet<>(capabilities));
	}

	public boolean validateScript(Path scriptPath) throws IOException {
		try {
			DroneValidator.validate(scriptPath);
			return true;
		} catch (RuntimeException e) {
			System.err.println("Validation failed: " + e.getMessage());
			return false;
		}
	}

	public String generateCode(Path scriptPath, String droneModel) throws IOException {
		if (!droneModelCapabilities.containsKey(droneModel)) {
			throw new IllegalArgumentException("Unknown drone model: " + droneModel);
		}

		CharStream input = CharStreams.fromPath(scriptPath);
		DroneTwoLexer lexer = new DroneTwoLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		DroneTwoParser parser = new DroneTwoParser(tokens);

		ParseTree tree = parser.program();
		return DroneCodeGenerator.generate(tree, droneModel);
	}

	public Set<String> getDroneModelCapabilities(String model) {
		return droneModelCapabilities.getOrDefault(model, Collections.emptySet());
	}

	public Set<String> getRegisteredDroneModels() {
		return droneModelCapabilities.keySet();
	}

	public boolean isDroneModelSupported(String model) {
		return droneModelCapabilities.containsKey(model);
	}

	public void validateDroneCapabilities(String model, Set<String> requiredCapabilities) {
		if (!droneModelCapabilities.containsKey(model)) {
			throw new IllegalArgumentException("Unknown drone model: " + model);
		}

		Set<String> missingCapabilities = new HashSet<>(requiredCapabilities);
		missingCapabilities.removeAll(droneModelCapabilities.get(model));

		if (!missingCapabilities.isEmpty()) {
			throw new IllegalArgumentException(
					"Drone model " + model + " lacks required capabilities: " + missingCapabilities);
		}
	}
}
