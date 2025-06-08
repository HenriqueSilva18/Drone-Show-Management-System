// Generated from ShowProposal.g4 by ANTLR 4.13.1
package show_proposal_plugin.generated_code;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ShowProposalParser}.
 */
public interface ShowProposalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(ShowProposalParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(ShowProposalParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(ShowProposalParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(ShowProposalParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(ShowProposalParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(ShowProposalParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#closing}.
	 * @param ctx the parse tree
	 */
	void enterClosing(ShowProposalParser.ClosingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#closing}.
	 * @param ctx the parse tree
	 */
	void exitClosing(ShowProposalParser.ClosingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#attachments}.
	 * @param ctx the parse tree
	 */
	void enterAttachments(ShowProposalParser.AttachmentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#attachments}.
	 * @param ctx the parse tree
	 */
	void exitAttachments(ShowProposalParser.AttachmentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#recipient_block}.
	 * @param ctx the parse tree
	 */
	void enterRecipient_block(ShowProposalParser.Recipient_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#recipient_block}.
	 * @param ctx the parse tree
	 */
	void exitRecipient_block(ShowProposalParser.Recipient_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#recipient_name}.
	 * @param ctx the parse tree
	 */
	void enterRecipient_name(ShowProposalParser.Recipient_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#recipient_name}.
	 * @param ctx the parse tree
	 */
	void exitRecipient_name(ShowProposalParser.Recipient_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#company_name}.
	 * @param ctx the parse tree
	 */
	void enterCompany_name(ShowProposalParser.Company_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#company_name}.
	 * @param ctx the parse tree
	 */
	void exitCompany_name(ShowProposalParser.Company_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#address_block}.
	 * @param ctx the parse tree
	 */
	void enterAddress_block(ShowProposalParser.Address_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#address_block}.
	 * @param ctx the parse tree
	 */
	void exitAddress_block(ShowProposalParser.Address_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#vat_number}.
	 * @param ctx the parse tree
	 */
	void enterVat_number(ShowProposalParser.Vat_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#vat_number}.
	 * @param ctx the parse tree
	 */
	void exitVat_number(ShowProposalParser.Vat_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#reference_number_date}.
	 * @param ctx the parse tree
	 */
	void enterReference_number_date(ShowProposalParser.Reference_number_dateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#reference_number_date}.
	 * @param ctx the parse tree
	 */
	void exitReference_number_date(ShowProposalParser.Reference_number_dateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#additional_recipient_info}.
	 * @param ctx the parse tree
	 */
	void enterAdditional_recipient_info(ShowProposalParser.Additional_recipient_infoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#additional_recipient_info}.
	 * @param ctx the parse tree
	 */
	void exitAdditional_recipient_info(ShowProposalParser.Additional_recipient_infoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#salutation}.
	 * @param ctx the parse tree
	 */
	void enterSalutation(ShowProposalParser.SalutationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#salutation}.
	 * @param ctx the parse tree
	 */
	void exitSalutation(ShowProposalParser.SalutationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#proposal_title}.
	 * @param ctx the parse tree
	 */
	void enterProposal_title(ShowProposalParser.Proposal_titleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#proposal_title}.
	 * @param ctx the parse tree
	 */
	void exitProposal_title(ShowProposalParser.Proposal_titleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#paragraph}.
	 * @param ctx the parse tree
	 */
	void enterParagraph(ShowProposalParser.ParagraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#paragraph}.
	 * @param ctx the parse tree
	 */
	void exitParagraph(ShowProposalParser.ParagraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(ShowProposalParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(ShowProposalParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(ShowProposalParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(ShowProposalParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(ShowProposalParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(ShowProposalParser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#duration}.
	 * @param ctx the parse tree
	 */
	void enterDuration(ShowProposalParser.DurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#duration}.
	 * @param ctx the parse tree
	 */
	void exitDuration(ShowProposalParser.DurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#list_drones}.
	 * @param ctx the parse tree
	 */
	void enterList_drones(ShowProposalParser.List_dronesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#list_drones}.
	 * @param ctx the parse tree
	 */
	void exitList_drones(ShowProposalParser.List_dronesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#list_figures}.
	 * @param ctx the parse tree
	 */
	void enterList_figures(ShowProposalParser.List_figuresContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#list_figures}.
	 * @param ctx the parse tree
	 */
	void exitList_figures(ShowProposalParser.List_figuresContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#list_drone_items}.
	 * @param ctx the parse tree
	 */
	void enterList_drone_items(ShowProposalParser.List_drone_itemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#list_drone_items}.
	 * @param ctx the parse tree
	 */
	void exitList_drone_items(ShowProposalParser.List_drone_itemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#list_figure_items}.
	 * @param ctx the parse tree
	 */
	void enterList_figure_items(ShowProposalParser.List_figure_itemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#list_figure_items}.
	 * @param ctx the parse tree
	 */
	void exitList_figure_items(ShowProposalParser.List_figure_itemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(ShowProposalParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(ShowProposalParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#page_break}.
	 * @param ctx the parse tree
	 */
	void enterPage_break(ShowProposalParser.Page_breakContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#page_break}.
	 * @param ctx the parse tree
	 */
	void exitPage_break(ShowProposalParser.Page_breakContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#attachment_section}.
	 * @param ctx the parse tree
	 */
	void enterAttachment_section(ShowProposalParser.Attachment_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#attachment_section}.
	 * @param ctx the parse tree
	 */
	void exitAttachment_section(ShowProposalParser.Attachment_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShowProposalParser#attachment_title}.
	 * @param ctx the parse tree
	 */
	void enterAttachment_title(ShowProposalParser.Attachment_titleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShowProposalParser#attachment_title}.
	 * @param ctx the parse tree
	 */
	void exitAttachment_title(ShowProposalParser.Attachment_titleContext ctx);
}