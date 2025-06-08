// Generated from DSL_FIGURE.g4 by ANTLR 4.13.0
package dsl.generated_code;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DSL_FIGUREParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DSL_FIGUREVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DSL_FIGUREParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#dslVersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslVersion(DSL_FIGUREParser.DslVersionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(DSL_FIGUREParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(DSL_FIGUREParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#droneTypeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDroneTypeDeclaration(DSL_FIGUREParser.DroneTypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#positionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionDeclaration(DSL_FIGUREParser.PositionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#velocityDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVelocityDeclaration(DSL_FIGUREParser.VelocityDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#velocityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVelocityExpr(DSL_FIGUREParser.VelocityExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#distanceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistanceDeclaration(DSL_FIGUREParser.DistanceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#figureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigureDeclaration(DSL_FIGUREParser.FigureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#figureParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigureParam(DSL_FIGUREParser.FigureParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberPiExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberPiExpr(DSL_FIGUREParser.NumberPiExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PiExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPiExpr(DSL_FIGUREParser.PiExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(DSL_FIGUREParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplyExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyExpr(DSL_FIGUREParser.MultiplyExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(DSL_FIGUREParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegativeIdExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeIdExpr(DSL_FIGUREParser.NegativeIdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdPiExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdPiExpr(DSL_FIGUREParser.IdPiExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(DSL_FIGUREParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubtractExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtractExpr(DSL_FIGUREParser.SubtractExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegativeNumberExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeNumberExpr(DSL_FIGUREParser.NegativeNumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(DSL_FIGUREParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivideExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivideExpr(DSL_FIGUREParser.DivideExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(DSL_FIGUREParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DSL_FIGUREParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#beforeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeforeBlock(DSL_FIGUREParser.BeforeBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#afterBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfterBlock(DSL_FIGUREParser.AfterBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#groupBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupBlock(DSL_FIGUREParser.GroupBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#blockContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockContent(DSL_FIGUREParser.BlockContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#singleAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleAction(DSL_FIGUREParser.SingleActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LightsOnAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLightsOnAction(DSL_FIGUREParser.LightsOnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LightsOffAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLightsOffAction(DSL_FIGUREParser.LightsOffActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MoveAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoveAction(DSL_FIGUREParser.MoveActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MovePosAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMovePosAction(DSL_FIGUREParser.MovePosActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RotateAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotateAction(DSL_FIGUREParser.RotateActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#distanceValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistanceValue(DSL_FIGUREParser.DistanceValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#velocityValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVelocityValue(DSL_FIGUREParser.VelocityValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#rotationValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotationValue(DSL_FIGUREParser.RotationValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_FIGUREParser#colorValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorValue(DSL_FIGUREParser.ColorValueContext ctx);
}