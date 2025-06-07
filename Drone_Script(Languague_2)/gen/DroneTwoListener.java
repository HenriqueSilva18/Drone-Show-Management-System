// Generated from C:/Users/berna/IdeaProjects/sem4pi-2024-2025-sem4pi_2024_2025_g39/Drone_Script(Languague_2)/src/main/resources/DroneTwo.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DroneTwoParser}.
 */
public interface DroneTwoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DroneTwoParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DroneTwoParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DroneTwoParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DroneTwoParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(DroneTwoParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(DroneTwoParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(DroneTwoParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(DroneTwoParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#takeoff}.
	 * @param ctx the parse tree
	 */
	void enterTakeoff(DroneTwoParser.TakeoffContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#takeoff}.
	 * @param ctx the parse tree
	 */
	void exitTakeoff(DroneTwoParser.TakeoffContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#land}.
	 * @param ctx the parse tree
	 */
	void enterLand(DroneTwoParser.LandContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#land}.
	 * @param ctx the parse tree
	 */
	void exitLand(DroneTwoParser.LandContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#movePoint}.
	 * @param ctx the parse tree
	 */
	void enterMovePoint(DroneTwoParser.MovePointContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#movePoint}.
	 * @param ctx the parse tree
	 */
	void exitMovePoint(DroneTwoParser.MovePointContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#moveVector}.
	 * @param ctx the parse tree
	 */
	void enterMoveVector(DroneTwoParser.MoveVectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#moveVector}.
	 * @param ctx the parse tree
	 */
	void exitMoveVector(DroneTwoParser.MoveVectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#movePath}.
	 * @param ctx the parse tree
	 */
	void enterMovePath(DroneTwoParser.MovePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#movePath}.
	 * @param ctx the parse tree
	 */
	void exitMovePath(DroneTwoParser.MovePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#moveCircleAngle}.
	 * @param ctx the parse tree
	 */
	void enterMoveCircleAngle(DroneTwoParser.MoveCircleAngleContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#moveCircleAngle}.
	 * @param ctx the parse tree
	 */
	void exitMoveCircleAngle(DroneTwoParser.MoveCircleAngleContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#moveCircleDuration}.
	 * @param ctx the parse tree
	 */
	void enterMoveCircleDuration(DroneTwoParser.MoveCircleDurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#moveCircleDuration}.
	 * @param ctx the parse tree
	 */
	void exitMoveCircleDuration(DroneTwoParser.MoveCircleDurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#hoover}.
	 * @param ctx the parse tree
	 */
	void enterHoover(DroneTwoParser.HooverContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#hoover}.
	 * @param ctx the parse tree
	 */
	void exitHoover(DroneTwoParser.HooverContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#lightsOn}.
	 * @param ctx the parse tree
	 */
	void enterLightsOn(DroneTwoParser.LightsOnContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#lightsOn}.
	 * @param ctx the parse tree
	 */
	void exitLightsOn(DroneTwoParser.LightsOnContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#lightsOff}.
	 * @param ctx the parse tree
	 */
	void enterLightsOff(DroneTwoParser.LightsOffContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#lightsOff}.
	 * @param ctx the parse tree
	 */
	void exitLightsOff(DroneTwoParser.LightsOffContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(DroneTwoParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(DroneTwoParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(DroneTwoParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(DroneTwoParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#point}.
	 * @param ctx the parse tree
	 */
	void enterPoint(DroneTwoParser.PointContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#point}.
	 * @param ctx the parse tree
	 */
	void exitPoint(DroneTwoParser.PointContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVector(DroneTwoParser.VectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVector(DroneTwoParser.VectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#pointArray}.
	 * @param ctx the parse tree
	 */
	void enterPointArray(DroneTwoParser.PointArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#pointArray}.
	 * @param ctx the parse tree
	 */
	void exitPointArray(DroneTwoParser.PointArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(DroneTwoParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(DroneTwoParser.ColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneTwoParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(DroneTwoParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneTwoParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(DroneTwoParser.TypeContext ctx);
}