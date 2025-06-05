// Generated from DSL_GRAMMAR.g4 by ANTLR 4.13.0
package dsl_plugin.generated_code;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DSL_GRAMMARParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DSL_GRAMMARVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DSL_GRAMMARParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#figure_standalone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigure_standalone(DSL_GRAMMARParser.Figure_standaloneContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#show_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_definition(DSL_GRAMMARParser.Show_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#drones_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrones_section(DSL_GRAMMARParser.Drones_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#sequence_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence_section(DSL_GRAMMARParser.Sequence_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#figure_in_show}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigure_in_show(DSL_GRAMMARParser.Figure_in_showContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#mapping_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapping_section(DSL_GRAMMARParser.Mapping_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#dslVersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslVersion(DSL_GRAMMARParser.DslVersionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(DSL_GRAMMARParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(DSL_GRAMMARParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#droneTypeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDroneTypeDeclaration(DSL_GRAMMARParser.DroneTypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#positionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionDeclaration(DSL_GRAMMARParser.PositionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#velocityDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVelocityDeclaration(DSL_GRAMMARParser.VelocityDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#velocityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVelocityExpr(DSL_GRAMMARParser.VelocityExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#distanceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistanceDeclaration(DSL_GRAMMARParser.DistanceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#figureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigureDeclaration(DSL_GRAMMARParser.FigureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#figureParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFigureParam(DSL_GRAMMARParser.FigureParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberPiExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberPiExpr(DSL_GRAMMARParser.NumberPiExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PiExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPiExpr(DSL_GRAMMARParser.PiExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(DSL_GRAMMARParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplyExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyExpr(DSL_GRAMMARParser.MultiplyExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(DSL_GRAMMARParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegativeIdExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeIdExpr(DSL_GRAMMARParser.NegativeIdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdPiExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdPiExpr(DSL_GRAMMARParser.IdPiExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(DSL_GRAMMARParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubtractExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtractExpr(DSL_GRAMMARParser.SubtractExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegativeNumberExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeNumberExpr(DSL_GRAMMARParser.NegativeNumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(DSL_GRAMMARParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivideExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivideExpr(DSL_GRAMMARParser.DivideExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(DSL_GRAMMARParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DSL_GRAMMARParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#beforeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeforeBlock(DSL_GRAMMARParser.BeforeBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#afterBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfterBlock(DSL_GRAMMARParser.AfterBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#groupBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupBlock(DSL_GRAMMARParser.GroupBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#blockContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockContent(DSL_GRAMMARParser.BlockContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#singleAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleAction(DSL_GRAMMARParser.SingleActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LightsOnAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLightsOnAction(DSL_GRAMMARParser.LightsOnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LightsOffAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLightsOffAction(DSL_GRAMMARParser.LightsOffActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MoveAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoveAction(DSL_GRAMMARParser.MoveActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MovePosAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMovePosAction(DSL_GRAMMARParser.MovePosActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RotateAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotateAction(DSL_GRAMMARParser.RotateActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#distanceValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistanceValue(DSL_GRAMMARParser.DistanceValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#velocityValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVelocityValue(DSL_GRAMMARParser.VelocityValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#rotationValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotationValue(DSL_GRAMMARParser.RotationValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSL_GRAMMARParser#colorValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorValue(DSL_GRAMMARParser.ColorValueContext ctx);
}