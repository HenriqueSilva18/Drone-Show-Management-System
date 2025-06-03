// Generated from DroneOne.g4 by ANTLR 4.13.0
package main.java.drone_plugin.generated_code;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DroneOneParser}.
 */
public interface DroneOneListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DroneOneParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DroneOneParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DroneOneParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DroneOneParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(DroneOneParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(DroneOneParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(DroneOneParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(DroneOneParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#takeoff}.
	 * @param ctx the parse tree
	 */
	void enterTakeoff(DroneOneParser.TakeoffContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#takeoff}.
	 * @param ctx the parse tree
	 */
	void exitTakeoff(DroneOneParser.TakeoffContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#land}.
	 * @param ctx the parse tree
	 */
	void enterLand(DroneOneParser.LandContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#land}.
	 * @param ctx the parse tree
	 */
	void exitLand(DroneOneParser.LandContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#movePosition}.
	 * @param ctx the parse tree
	 */
	void enterMovePosition(DroneOneParser.MovePositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#movePosition}.
	 * @param ctx the parse tree
	 */
	void exitMovePosition(DroneOneParser.MovePositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#moveVector}.
	 * @param ctx the parse tree
	 */
	void enterMoveVector(DroneOneParser.MoveVectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#moveVector}.
	 * @param ctx the parse tree
	 */
	void exitMoveVector(DroneOneParser.MoveVectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#movePath}.
	 * @param ctx the parse tree
	 */
	void enterMovePath(DroneOneParser.MovePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#movePath}.
	 * @param ctx the parse tree
	 */
	void exitMovePath(DroneOneParser.MovePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#hoover}.
	 * @param ctx the parse tree
	 */
	void enterHoover(DroneOneParser.HooverContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#hoover}.
	 * @param ctx the parse tree
	 */
	void exitHoover(DroneOneParser.HooverContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#lightsOn}.
	 * @param ctx the parse tree
	 */
	void enterLightsOn(DroneOneParser.LightsOnContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#lightsOn}.
	 * @param ctx the parse tree
	 */
	void exitLightsOn(DroneOneParser.LightsOnContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#lightsOff}.
	 * @param ctx the parse tree
	 */
	void enterLightsOff(DroneOneParser.LightsOffContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#lightsOff}.
	 * @param ctx the parse tree
	 */
	void exitLightsOff(DroneOneParser.LightsOffContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#blink}.
	 * @param ctx the parse tree
	 */
	void enterBlink(DroneOneParser.BlinkContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#blink}.
	 * @param ctx the parse tree
	 */
	void exitBlink(DroneOneParser.BlinkContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(DroneOneParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(DroneOneParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(DroneOneParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(DroneOneParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#position}.
	 * @param ctx the parse tree
	 */
	void enterPosition(DroneOneParser.PositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#position}.
	 * @param ctx the parse tree
	 */
	void exitPosition(DroneOneParser.PositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVector(DroneOneParser.VectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVector(DroneOneParser.VectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#positionArray}.
	 * @param ctx the parse tree
	 */
	void enterPositionArray(DroneOneParser.PositionArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#positionArray}.
	 * @param ctx the parse tree
	 */
	void exitPositionArray(DroneOneParser.PositionArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link DroneOneParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(DroneOneParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DroneOneParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(DroneOneParser.TypeContext ctx);
}