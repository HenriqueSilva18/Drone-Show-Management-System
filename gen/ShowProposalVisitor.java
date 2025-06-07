// Generated from C:/Users/berna/IdeaProjects/sem4pi-2024-2025-sem4pi_2024_2025_g39/LPROG/ShowProposal.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ShowProposalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ShowProposalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(ShowProposalParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(ShowProposalParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(ShowProposalParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#closing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosing(ShowProposalParser.ClosingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#attachments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttachments(ShowProposalParser.AttachmentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#recipient_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecipient_block(ShowProposalParser.Recipient_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#recipient_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecipient_name(ShowProposalParser.Recipient_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#company_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompany_name(ShowProposalParser.Company_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#address_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddress_block(ShowProposalParser.Address_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#vat_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVat_number(ShowProposalParser.Vat_numberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#reference_number_date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference_number_date(ShowProposalParser.Reference_number_dateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#additional_recipient_info}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditional_recipient_info(ShowProposalParser.Additional_recipient_infoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#salutation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSalutation(ShowProposalParser.SalutationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#proposal_title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposal_title(ShowProposalParser.Proposal_titleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#paragraph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParagraph(ShowProposalParser.ParagraphContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(ShowProposalParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(ShowProposalParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(ShowProposalParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#duration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration(ShowProposalParser.DurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#list_drones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_drones(ShowProposalParser.List_dronesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#list_figures}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_figures(ShowProposalParser.List_figuresContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#list_drone_items}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_drone_items(ShowProposalParser.List_drone_itemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#list_figure_items}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_figure_items(ShowProposalParser.List_figure_itemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(ShowProposalParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#page_break}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPage_break(ShowProposalParser.Page_breakContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#attachment_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttachment_section(ShowProposalParser.Attachment_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShowProposalParser#attachment_title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttachment_title(ShowProposalParser.Attachment_titleContext ctx);
}