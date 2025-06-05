// Generated from DSL_GRAMMAR.g4 by ANTLR 4.13.0
package dsl_plugin.generated_code;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DSL_GRAMMARParser}.
 */
public interface DSL_GRAMMARListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DSL_GRAMMARParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DSL_GRAMMARParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#figure_standalone}.
	 * @param ctx the parse tree
	 */
	void enterFigure_standalone(DSL_GRAMMARParser.Figure_standaloneContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#figure_standalone}.
	 * @param ctx the parse tree
	 */
	void exitFigure_standalone(DSL_GRAMMARParser.Figure_standaloneContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#show_definition}.
	 * @param ctx the parse tree
	 */
	void enterShow_definition(DSL_GRAMMARParser.Show_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#show_definition}.
	 * @param ctx the parse tree
	 */
	void exitShow_definition(DSL_GRAMMARParser.Show_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#drones_section}.
	 * @param ctx the parse tree
	 */
	void enterDrones_section(DSL_GRAMMARParser.Drones_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#drones_section}.
	 * @param ctx the parse tree
	 */
	void exitDrones_section(DSL_GRAMMARParser.Drones_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#sequence_section}.
	 * @param ctx the parse tree
	 */
	void enterSequence_section(DSL_GRAMMARParser.Sequence_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#sequence_section}.
	 * @param ctx the parse tree
	 */
	void exitSequence_section(DSL_GRAMMARParser.Sequence_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#figure_in_show}.
	 * @param ctx the parse tree
	 */
	void enterFigure_in_show(DSL_GRAMMARParser.Figure_in_showContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#figure_in_show}.
	 * @param ctx the parse tree
	 */
	void exitFigure_in_show(DSL_GRAMMARParser.Figure_in_showContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#mapping_section}.
	 * @param ctx the parse tree
	 */
	void enterMapping_section(DSL_GRAMMARParser.Mapping_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#mapping_section}.
	 * @param ctx the parse tree
	 */
	void exitMapping_section(DSL_GRAMMARParser.Mapping_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#dslVersion}.
	 * @param ctx the parse tree
	 */
	void enterDslVersion(DSL_GRAMMARParser.DslVersionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#dslVersion}.
	 * @param ctx the parse tree
	 */
	void exitDslVersion(DSL_GRAMMARParser.DslVersionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(DSL_GRAMMARParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(DSL_GRAMMARParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(DSL_GRAMMARParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(DSL_GRAMMARParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#droneTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterDroneTypeDeclaration(DSL_GRAMMARParser.DroneTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#droneTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitDroneTypeDeclaration(DSL_GRAMMARParser.DroneTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#positionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPositionDeclaration(DSL_GRAMMARParser.PositionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#positionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPositionDeclaration(DSL_GRAMMARParser.PositionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#velocityDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVelocityDeclaration(DSL_GRAMMARParser.VelocityDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#velocityDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVelocityDeclaration(DSL_GRAMMARParser.VelocityDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#velocityExpr}.
	 * @param ctx the parse tree
	 */
	void enterVelocityExpr(DSL_GRAMMARParser.VelocityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#velocityExpr}.
	 * @param ctx the parse tree
	 */
	void exitVelocityExpr(DSL_GRAMMARParser.VelocityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#distanceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterDistanceDeclaration(DSL_GRAMMARParser.DistanceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#distanceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitDistanceDeclaration(DSL_GRAMMARParser.DistanceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#figureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFigureDeclaration(DSL_GRAMMARParser.FigureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#figureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFigureDeclaration(DSL_GRAMMARParser.FigureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#figureParam}.
	 * @param ctx the parse tree
	 */
	void enterFigureParam(DSL_GRAMMARParser.FigureParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#figureParam}.
	 * @param ctx the parse tree
	 */
	void exitFigureParam(DSL_GRAMMARParser.FigureParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberPiExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberPiExpr(DSL_GRAMMARParser.NumberPiExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberPiExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberPiExpr(DSL_GRAMMARParser.NumberPiExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PiExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPiExpr(DSL_GRAMMARParser.PiExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PiExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPiExpr(DSL_GRAMMARParser.PiExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(DSL_GRAMMARParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(DSL_GRAMMARParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplyExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExpr(DSL_GRAMMARParser.MultiplyExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplyExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExpr(DSL_GRAMMARParser.MultiplyExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(DSL_GRAMMARParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(DSL_GRAMMARParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegativeIdExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegativeIdExpr(DSL_GRAMMARParser.NegativeIdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegativeIdExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegativeIdExpr(DSL_GRAMMARParser.NegativeIdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdPiExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdPiExpr(DSL_GRAMMARParser.IdPiExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdPiExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdPiExpr(DSL_GRAMMARParser.IdPiExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(DSL_GRAMMARParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(DSL_GRAMMARParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubtractExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtractExpr(DSL_GRAMMARParser.SubtractExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubtractExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtractExpr(DSL_GRAMMARParser.SubtractExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegativeNumberExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegativeNumberExpr(DSL_GRAMMARParser.NegativeNumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegativeNumberExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegativeNumberExpr(DSL_GRAMMARParser.NegativeNumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(DSL_GRAMMARParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(DSL_GRAMMARParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivideExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivideExpr(DSL_GRAMMARParser.DivideExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivideExpr}
	 * labeled alternative in {@link DSL_GRAMMARParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivideExpr(DSL_GRAMMARParser.DivideExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(DSL_GRAMMARParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(DSL_GRAMMARParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DSL_GRAMMARParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DSL_GRAMMARParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#beforeBlock}.
	 * @param ctx the parse tree
	 */
	void enterBeforeBlock(DSL_GRAMMARParser.BeforeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#beforeBlock}.
	 * @param ctx the parse tree
	 */
	void exitBeforeBlock(DSL_GRAMMARParser.BeforeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#afterBlock}.
	 * @param ctx the parse tree
	 */
	void enterAfterBlock(DSL_GRAMMARParser.AfterBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#afterBlock}.
	 * @param ctx the parse tree
	 */
	void exitAfterBlock(DSL_GRAMMARParser.AfterBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#groupBlock}.
	 * @param ctx the parse tree
	 */
	void enterGroupBlock(DSL_GRAMMARParser.GroupBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#groupBlock}.
	 * @param ctx the parse tree
	 */
	void exitGroupBlock(DSL_GRAMMARParser.GroupBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#blockContent}.
	 * @param ctx the parse tree
	 */
	void enterBlockContent(DSL_GRAMMARParser.BlockContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#blockContent}.
	 * @param ctx the parse tree
	 */
	void exitBlockContent(DSL_GRAMMARParser.BlockContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#singleAction}.
	 * @param ctx the parse tree
	 */
	void enterSingleAction(DSL_GRAMMARParser.SingleActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#singleAction}.
	 * @param ctx the parse tree
	 */
	void exitSingleAction(DSL_GRAMMARParser.SingleActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LightsOnAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void enterLightsOnAction(DSL_GRAMMARParser.LightsOnActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LightsOnAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void exitLightsOnAction(DSL_GRAMMARParser.LightsOnActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LightsOffAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void enterLightsOffAction(DSL_GRAMMARParser.LightsOffActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LightsOffAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void exitLightsOffAction(DSL_GRAMMARParser.LightsOffActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MoveAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void enterMoveAction(DSL_GRAMMARParser.MoveActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MoveAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void exitMoveAction(DSL_GRAMMARParser.MoveActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MovePosAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void enterMovePosAction(DSL_GRAMMARParser.MovePosActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MovePosAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void exitMovePosAction(DSL_GRAMMARParser.MovePosActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RotateAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void enterRotateAction(DSL_GRAMMARParser.RotateActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RotateAction}
	 * labeled alternative in {@link DSL_GRAMMARParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void exitRotateAction(DSL_GRAMMARParser.RotateActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#distanceValue}.
	 * @param ctx the parse tree
	 */
	void enterDistanceValue(DSL_GRAMMARParser.DistanceValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#distanceValue}.
	 * @param ctx the parse tree
	 */
	void exitDistanceValue(DSL_GRAMMARParser.DistanceValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#velocityValue}.
	 * @param ctx the parse tree
	 */
	void enterVelocityValue(DSL_GRAMMARParser.VelocityValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#velocityValue}.
	 * @param ctx the parse tree
	 */
	void exitVelocityValue(DSL_GRAMMARParser.VelocityValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#rotationValue}.
	 * @param ctx the parse tree
	 */
	void enterRotationValue(DSL_GRAMMARParser.RotationValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#rotationValue}.
	 * @param ctx the parse tree
	 */
	void exitRotationValue(DSL_GRAMMARParser.RotationValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_GRAMMARParser#colorValue}.
	 * @param ctx the parse tree
	 */
	void enterColorValue(DSL_GRAMMARParser.ColorValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_GRAMMARParser#colorValue}.
	 * @param ctx the parse tree
	 */
	void exitColorValue(DSL_GRAMMARParser.ColorValueContext ctx);
}