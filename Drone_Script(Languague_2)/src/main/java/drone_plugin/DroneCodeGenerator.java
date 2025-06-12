package drone_plugin;

import drone_plugin.generated_code.*;
import org.antlr.v4.runtime.tree.*;

import java.util.*;

public class DroneCodeGenerator extends DroneTwoBaseVisitor<String> {
	private final StringBuilder code = new StringBuilder();
	private final Map<String, String> variables = new HashMap<>();
	private final String droneModel;
	private int indentLevel = 0;

	public DroneCodeGenerator(String droneModel) {
		this.droneModel = droneModel;
	}

	@Override
	public String visitProgram(DroneTwoParser.ProgramContext ctx) {
		code.append("// Generated code for drone model: ").append(droneModel).append("\n\n");
		visitChildren(ctx);
		return code.toString();
	}

	@Override
	public String visitFigureDeclaration(DroneTwoParser.FigureDeclarationContext ctx) {
		String figureName = ctx.ID().getText();
		code.append("function ").append(figureName).append("() {\n");
		indentLevel++;

		// Add safety checks based on drone model capabilities
		if (ctx.droneCapabilities() != null) {
			for (DroneTwoParser.CapabilityContext cap : ctx.droneCapabilities().capability()) {
				code.append(indent()).append("if (!drone.hasCapability('")
						.append(cap.getText()).append("')) {\n");
				code.append(indent()).append("    throw new Error('Drone model ")
						.append(droneModel).append(" lacks required capability: ")
						.append(cap.getText()).append("');\n");
				code.append(indent()).append("}\n");
			}
		}

		visitChildren(ctx);

		indentLevel--;
		code.append("}\n\n");
		return null;
	}

	@Override
	public String visitCommand(DroneTwoParser.CommandContext ctx) {
		if (ctx.takeoff() != null) {
			visitTakeoff(ctx.takeoff());
		} else if (ctx.land() != null) {
			visitLand(ctx.land());
		} else if (ctx.movePoint() != null) {
			visitMovePoint(ctx.movePoint());
		} else if (ctx.moveVector() != null) {
			visitMoveVector(ctx.moveVector());
		} else if (ctx.movePath() != null) {
			visitMovePath(ctx.movePath());
		} else if (ctx.moveCircleAngle() != null) {
			visitMoveCircleAngle(ctx.moveCircleAngle());
		} else if (ctx.moveCircleDuration() != null) {
			visitMoveCircleDuration(ctx.moveCircleDuration());
		} else if (ctx.hoover() != null) {
			visitHoover(ctx.hoover());
		} else if (ctx.lightsOn() != null) {
			visitLightsOn(ctx.lightsOn());
		} else if (ctx.lightsOff() != null) {
			visitLightsOff(ctx.lightsOff());
		} else if (ctx.waitCommand() != null) {
			visitWaitCommand(ctx.waitCommand());
		} else if (ctx.environmentCheck() != null) {
			visitEnvironmentCheck(ctx.environmentCheck());
		}
		return null;
	}

	@Override
	public String visitTakeoff(DroneTwoParser.TakeoffContext ctx) {
		String command = String.format("drone.takeoff(%s, %s)",
				ctx.FLOAT(0).getText(), ctx.FLOAT(1).getText());
		appendCommandWithCondition(command, ctx.condition());
		return null;
	}

	@Override
	public String visitLand(DroneTwoParser.LandContext ctx) {
		String command = String.format("drone.land(%s)", ctx.FLOAT().getText());
		appendCommandWithCondition(command, ctx.condition());
		return null;
	}

	private void appendCommandWithCondition(String command, DroneTwoParser.ConditionContext condition) {
		if (condition != null) {
			code.append(indent()).append("if (").append(generateCondition(condition)).append(") {\n");
			indentLevel++;
			code.append(indent()).append(command).append(";\n");
			indentLevel--;
			code.append(indent()).append("}\n");
		} else {
			code.append(indent()).append(command).append(";\n");
		}
	}

	private String generateCondition(DroneTwoParser.ConditionContext ctx) {
		if (ctx.environmentCondition() != null) {
			return String.format("drone.getWindSpeed() %s %s",
					ctx.environmentCondition().comparison().getText(),
					ctx.environmentCondition().FLOAT().getText());
		} else if (ctx.timeCondition() != null) {
			return String.format("drone.getFlightTime() %s %s",
					ctx.timeCondition().comparison().getText(),
					ctx.timeCondition().INT().getText());
		} else if (ctx.positionCondition() != null) {
			DroneTwoParser.PointContext point = ctx.positionCondition().point();
			return String.format("drone.isNearPosition(%s, %s, %s, 0.1)",
					point.FLOAT(0).getText(),
					point.FLOAT(1).getText(),
					point.FLOAT(2).getText());
		}
		return "true";
	}

	private String indent() {
		return "    ".repeat(indentLevel);
	}

	public static String generate(ParseTree tree, String droneModel) {
		DroneCodeGenerator generator = new DroneCodeGenerator(droneModel);
		generator.visit(tree);
		return generator.code.toString();
	}
}
