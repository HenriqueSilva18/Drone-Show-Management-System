// Generated from C:/Users/berna/IdeaProjects/sem4pi-2024-2025-sem4pi_2024_2025_g39/Drone_Script(Languague_2)/src/main/resources/DroneTwo.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DroneTwoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DroneTwoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DroneTwoParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DroneTwoParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(DroneTwoParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(DroneTwoParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#takeoff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTakeoff(DroneTwoParser.TakeoffContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#land}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLand(DroneTwoParser.LandContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#movePoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMovePoint(DroneTwoParser.MovePointContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#moveVector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoveVector(DroneTwoParser.MoveVectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#movePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMovePath(DroneTwoParser.MovePathContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#moveCircleAngle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoveCircleAngle(DroneTwoParser.MoveCircleAngleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#moveCircleDuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoveCircleDuration(DroneTwoParser.MoveCircleDurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#hoover}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHoover(DroneTwoParser.HooverContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#lightsOn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLightsOn(DroneTwoParser.LightsOnContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#lightsOff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLightsOff(DroneTwoParser.LightsOffContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(DroneTwoParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(DroneTwoParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#point}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoint(DroneTwoParser.PointContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#vector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector(DroneTwoParser.VectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#pointArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointArray(DroneTwoParser.PointArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(DroneTwoParser.ColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroneTwoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(DroneTwoParser.TypeContext ctx);
}