// Generated from DSL_FIGURE.g4 by ANTLR 4.13.0
package dsl_plugin.generated_code;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DSL_FIGUREParser}.
 */
public interface DSL_FIGUREListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DSL_FIGUREParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DSL_FIGUREParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#dslVersion}.
	 * @param ctx the parse tree
	 */
	void enterDslVersion(DSL_FIGUREParser.DslVersionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#dslVersion}.
	 * @param ctx the parse tree
	 */
	void exitDslVersion(DSL_FIGUREParser.DslVersionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(DSL_FIGUREParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(DSL_FIGUREParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(DSL_FIGUREParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(DSL_FIGUREParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#droneTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterDroneTypeDeclaration(DSL_FIGUREParser.DroneTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#droneTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitDroneTypeDeclaration(DSL_FIGUREParser.DroneTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#positionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPositionDeclaration(DSL_FIGUREParser.PositionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#positionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPositionDeclaration(DSL_FIGUREParser.PositionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#velocityDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVelocityDeclaration(DSL_FIGUREParser.VelocityDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#velocityDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVelocityDeclaration(DSL_FIGUREParser.VelocityDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#velocityExpr}.
	 * @param ctx the parse tree
	 */
	void enterVelocityExpr(DSL_FIGUREParser.VelocityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#velocityExpr}.
	 * @param ctx the parse tree
	 */
	void exitVelocityExpr(DSL_FIGUREParser.VelocityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#distanceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterDistanceDeclaration(DSL_FIGUREParser.DistanceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#distanceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitDistanceDeclaration(DSL_FIGUREParser.DistanceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#figureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFigureDeclaration(DSL_FIGUREParser.FigureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#figureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFigureDeclaration(DSL_FIGUREParser.FigureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#figureParam}.
	 * @param ctx the parse tree
	 */
	void enterFigureParam(DSL_FIGUREParser.FigureParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#figureParam}.
	 * @param ctx the parse tree
	 */
	void exitFigureParam(DSL_FIGUREParser.FigureParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberPiExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberPiExpr(DSL_FIGUREParser.NumberPiExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberPiExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberPiExpr(DSL_FIGUREParser.NumberPiExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PiExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPiExpr(DSL_FIGUREParser.PiExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PiExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPiExpr(DSL_FIGUREParser.PiExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(DSL_FIGUREParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(DSL_FIGUREParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplyExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExpr(DSL_FIGUREParser.MultiplyExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplyExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExpr(DSL_FIGUREParser.MultiplyExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(DSL_FIGUREParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(DSL_FIGUREParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegativeIdExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegativeIdExpr(DSL_FIGUREParser.NegativeIdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegativeIdExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegativeIdExpr(DSL_FIGUREParser.NegativeIdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdPiExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdPiExpr(DSL_FIGUREParser.IdPiExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdPiExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdPiExpr(DSL_FIGUREParser.IdPiExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(DSL_FIGUREParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(DSL_FIGUREParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubtractExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtractExpr(DSL_FIGUREParser.SubtractExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubtractExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtractExpr(DSL_FIGUREParser.SubtractExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegativeNumberExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegativeNumberExpr(DSL_FIGUREParser.NegativeNumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegativeNumberExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegativeNumberExpr(DSL_FIGUREParser.NegativeNumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(DSL_FIGUREParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(DSL_FIGUREParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivideExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivideExpr(DSL_FIGUREParser.DivideExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivideExpr}
	 * labeled alternative in {@link DSL_FIGUREParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivideExpr(DSL_FIGUREParser.DivideExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(DSL_FIGUREParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(DSL_FIGUREParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DSL_FIGUREParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DSL_FIGUREParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#beforeBlock}.
	 * @param ctx the parse tree
	 */
	void enterBeforeBlock(DSL_FIGUREParser.BeforeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#beforeBlock}.
	 * @param ctx the parse tree
	 */
	void exitBeforeBlock(DSL_FIGUREParser.BeforeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#afterBlock}.
	 * @param ctx the parse tree
	 */
	void enterAfterBlock(DSL_FIGUREParser.AfterBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#afterBlock}.
	 * @param ctx the parse tree
	 */
	void exitAfterBlock(DSL_FIGUREParser.AfterBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#groupBlock}.
	 * @param ctx the parse tree
	 */
	void enterGroupBlock(DSL_FIGUREParser.GroupBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#groupBlock}.
	 * @param ctx the parse tree
	 */
	void exitGroupBlock(DSL_FIGUREParser.GroupBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#blockContent}.
	 * @param ctx the parse tree
	 */
	void enterBlockContent(DSL_FIGUREParser.BlockContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#blockContent}.
	 * @param ctx the parse tree
	 */
	void exitBlockContent(DSL_FIGUREParser.BlockContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#singleAction}.
	 * @param ctx the parse tree
	 */
	void enterSingleAction(DSL_FIGUREParser.SingleActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#singleAction}.
	 * @param ctx the parse tree
	 */
	void exitSingleAction(DSL_FIGUREParser.SingleActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LightsOnAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void enterLightsOnAction(DSL_FIGUREParser.LightsOnActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LightsOnAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void exitLightsOnAction(DSL_FIGUREParser.LightsOnActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LightsOffAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void enterLightsOffAction(DSL_FIGUREParser.LightsOffActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LightsOffAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void exitLightsOffAction(DSL_FIGUREParser.LightsOffActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MoveAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void enterMoveAction(DSL_FIGUREParser.MoveActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MoveAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void exitMoveAction(DSL_FIGUREParser.MoveActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MovePosAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void enterMovePosAction(DSL_FIGUREParser.MovePosActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MovePosAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void exitMovePosAction(DSL_FIGUREParser.MovePosActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RotateAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void enterRotateAction(DSL_FIGUREParser.RotateActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RotateAction}
	 * labeled alternative in {@link DSL_FIGUREParser#figureAction}.
	 * @param ctx the parse tree
	 */
	void exitRotateAction(DSL_FIGUREParser.RotateActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#distanceValue}.
	 * @param ctx the parse tree
	 */
	void enterDistanceValue(DSL_FIGUREParser.DistanceValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#distanceValue}.
	 * @param ctx the parse tree
	 */
	void exitDistanceValue(DSL_FIGUREParser.DistanceValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#velocityValue}.
	 * @param ctx the parse tree
	 */
	void enterVelocityValue(DSL_FIGUREParser.VelocityValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#velocityValue}.
	 * @param ctx the parse tree
	 */
	void exitVelocityValue(DSL_FIGUREParser.VelocityValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#rotationValue}.
	 * @param ctx the parse tree
	 */
	void enterRotationValue(DSL_FIGUREParser.RotationValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#rotationValue}.
	 * @param ctx the parse tree
	 */
	void exitRotationValue(DSL_FIGUREParser.RotationValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSL_FIGUREParser#colorValue}.
	 * @param ctx the parse tree
	 */
	void enterColorValue(DSL_FIGUREParser.ColorValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSL_FIGUREParser#colorValue}.
	 * @param ctx the parse tree
	 */
	void exitColorValue(DSL_FIGUREParser.ColorValueContext ctx);
}