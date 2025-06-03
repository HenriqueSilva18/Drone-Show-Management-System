// Generated from DroneOne.g4 by ANTLR 4.13.0
package main.java.drone_plugin.generated_code;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DroneOneParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DroneOneVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DroneOneParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DroneOneParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(DroneOneParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(DroneOneParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#takeoff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTakeoff(DroneOneParser.TakeoffContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#land}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLand(DroneOneParser.LandContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#movePosition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMovePosition(DroneOneParser.MovePositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#moveVector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoveVector(DroneOneParser.MoveVectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#movePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMovePath(DroneOneParser.MovePathContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#hoover}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHoover(DroneOneParser.HooverContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#lightsOn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLightsOn(DroneOneParser.LightsOnContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#lightsOff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLightsOff(DroneOneParser.LightsOffContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#blink}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlink(DroneOneParser.BlinkContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(DroneOneParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(DroneOneParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#position}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPosition(DroneOneParser.PositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#vector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector(DroneOneParser.VectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#positionArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionArray(DroneOneParser.PositionArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneOneParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(DroneOneParser.TypeContext ctx);
}