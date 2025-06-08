// Generated from ShowProposal.g4 by ANTLR 4.13.1
package show_proposal_plugin.generated_code;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ShowProposalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DATE_SEPARATOR=1, PAGE_BREAK=2, SEPARATOR_LINE=3, DOTS=4, NUMBER=5, TEXT=6, 
		NEWLINE=7, WS=8;
	public static final int
		RULE_document = 0, RULE_header = 1, RULE_body = 2, RULE_closing = 3, RULE_attachments = 4, 
		RULE_recipient_block = 5, RULE_recipient_name = 6, RULE_company_name = 7, 
		RULE_address_block = 8, RULE_vat_number = 9, RULE_reference_number_date = 10, 
		RULE_additional_recipient_info = 11, RULE_salutation = 12, RULE_proposal_title = 13, 
		RULE_paragraph = 14, RULE_location = 15, RULE_date = 16, RULE_time = 17, 
		RULE_duration = 18, RULE_list_drones = 19, RULE_list_figures = 20, RULE_list_drone_items = 21, 
		RULE_list_figure_items = 22, RULE_title = 23, RULE_page_break = 24, RULE_attachment_section = 25, 
		RULE_attachment_title = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "header", "body", "closing", "attachments", "recipient_block", 
			"recipient_name", "company_name", "address_block", "vat_number", "reference_number_date", 
			"additional_recipient_info", "salutation", "proposal_title", "paragraph", 
			"location", "date", "time", "duration", "list_drones", "list_figures", 
			"list_drone_items", "list_figure_items", "title", "page_break", "attachment_section", 
			"attachment_title"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'[page break]'", null, "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DATE_SEPARATOR", "PAGE_BREAK", "SEPARATOR_LINE", "DOTS", "NUMBER", 
			"TEXT", "NEWLINE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ShowProposal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ShowProposalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public AttachmentsContext attachments() {
			return getRuleContext(AttachmentsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ShowProposalParser.EOF, 0); }
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			header();
			setState(55);
			body();
			setState(56);
			attachments();
			setState(57);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderContext extends ParserRuleContext {
		public SalutationContext salutation() {
			return getRuleContext(SalutationContext.class,0);
		}
		public Recipient_blockContext recipient_block() {
			return getRuleContext(Recipient_blockContext.class,0);
		}
		public Reference_number_dateContext reference_number_date() {
			return getRuleContext(Reference_number_dateContext.class,0);
		}
		public Proposal_titleContext proposal_title() {
			return getRuleContext(Proposal_titleContext.class,0);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			salutation();
			setState(60);
			recipient_block();
			setState(61);
			reference_number_date();
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(62);
				proposal_title();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public ClosingContext closing() {
			return getRuleContext(ClosingContext.class,0);
		}
		public List<ParagraphContext> paragraph() {
			return getRuleContexts(ParagraphContext.class);
		}
		public ParagraphContext paragraph(int i) {
			return getRuleContext(ParagraphContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_body);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(66); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(65);
					paragraph();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(68); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			setState(70);
			closing();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClosingContext extends ParserRuleContext {
		public List<ParagraphContext> paragraph() {
			return getRuleContexts(ParagraphContext.class);
		}
		public ParagraphContext paragraph(int i) {
			return getRuleContext(ParagraphContext.class,i);
		}
		public ClosingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterClosing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitClosing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitClosing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosingContext closing() throws RecognitionException {
		ClosingContext _localctx = new ClosingContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_closing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			paragraph();
			setState(73);
			paragraph();
			setState(74);
			paragraph();
			setState(75);
			paragraph();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttachmentsContext extends ParserRuleContext {
		public Page_breakContext page_break() {
			return getRuleContext(Page_breakContext.class,0);
		}
		public Attachment_sectionContext attachment_section() {
			return getRuleContext(Attachment_sectionContext.class,0);
		}
		public AttachmentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attachments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterAttachments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitAttachments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitAttachments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttachmentsContext attachments() throws RecognitionException {
		AttachmentsContext _localctx = new AttachmentsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attachments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			page_break();
			setState(78);
			attachment_section();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Recipient_blockContext extends ParserRuleContext {
		public Company_nameContext company_name() {
			return getRuleContext(Company_nameContext.class,0);
		}
		public Address_blockContext address_block() {
			return getRuleContext(Address_blockContext.class,0);
		}
		public Vat_numberContext vat_number() {
			return getRuleContext(Vat_numberContext.class,0);
		}
		public Recipient_nameContext recipient_name() {
			return getRuleContext(Recipient_nameContext.class,0);
		}
		public Additional_recipient_infoContext additional_recipient_info() {
			return getRuleContext(Additional_recipient_infoContext.class,0);
		}
		public Recipient_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recipient_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterRecipient_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitRecipient_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitRecipient_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Recipient_blockContext recipient_block() throws RecognitionException {
		Recipient_blockContext _localctx = new Recipient_blockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_recipient_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(80);
				recipient_name();
				}
				break;
			}
			setState(83);
			company_name();
			setState(84);
			address_block();
			setState(85);
			vat_number();
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(86);
				additional_recipient_info();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Recipient_nameContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public TerminalNode NEWLINE() { return getToken(ShowProposalParser.NEWLINE, 0); }
		public Recipient_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recipient_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterRecipient_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitRecipient_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitRecipient_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Recipient_nameContext recipient_name() throws RecognitionException {
		Recipient_nameContext _localctx = new Recipient_nameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_recipient_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(TEXT);
			setState(90);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Company_nameContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public TerminalNode NEWLINE() { return getToken(ShowProposalParser.NEWLINE, 0); }
		public Company_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_company_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterCompany_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitCompany_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitCompany_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Company_nameContext company_name() throws RecognitionException {
		Company_nameContext _localctx = new Company_nameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_company_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(TEXT);
			setState(93);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Address_blockContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public TerminalNode NEWLINE() { return getToken(ShowProposalParser.NEWLINE, 0); }
		public Address_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_address_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterAddress_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitAddress_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitAddress_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Address_blockContext address_block() throws RecognitionException {
		Address_blockContext _localctx = new Address_blockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_address_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(TEXT);
			setState(96);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Vat_numberContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public Vat_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vat_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterVat_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitVat_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitVat_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vat_numberContext vat_number() throws RecognitionException {
		Vat_numberContext _localctx = new Vat_numberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_vat_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(TEXT);
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(99);
				match(NEWLINE);
				}
				}
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Reference_number_dateContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public TerminalNode NEWLINE() { return getToken(ShowProposalParser.NEWLINE, 0); }
		public Reference_number_dateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference_number_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterReference_number_date(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitReference_number_date(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitReference_number_date(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Reference_number_dateContext reference_number_date() throws RecognitionException {
		Reference_number_dateContext _localctx = new Reference_number_dateContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_reference_number_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(TEXT);
			setState(105);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Additional_recipient_infoContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public TerminalNode NEWLINE() { return getToken(ShowProposalParser.NEWLINE, 0); }
		public Additional_recipient_infoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additional_recipient_info; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterAdditional_recipient_info(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitAdditional_recipient_info(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitAdditional_recipient_info(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Additional_recipient_infoContext additional_recipient_info() throws RecognitionException {
		Additional_recipient_infoContext _localctx = new Additional_recipient_infoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_additional_recipient_info);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(TEXT);
			setState(108);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SalutationContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public TerminalNode NEWLINE() { return getToken(ShowProposalParser.NEWLINE, 0); }
		public SalutationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_salutation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterSalutation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitSalutation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitSalutation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SalutationContext salutation() throws RecognitionException {
		SalutationContext _localctx = new SalutationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_salutation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(TEXT);
			setState(111);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Proposal_titleContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public Proposal_titleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposal_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterProposal_title(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitProposal_title(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitProposal_title(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Proposal_titleContext proposal_title() throws RecognitionException {
		Proposal_titleContext _localctx = new Proposal_titleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_proposal_title);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(TEXT);
			setState(114);
			match(NEWLINE);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(115);
				match(NEWLINE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParagraphContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public ParagraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paragraph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterParagraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitParagraph(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitParagraph(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParagraphContext paragraph() throws RecognitionException {
		ParagraphContext _localctx = new ParagraphContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_paragraph);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(TEXT);
			setState(119);
			match(NEWLINE);
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(120);
				match(NEWLINE);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocationContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_location);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(TEXT);
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				match(NEWLINE);
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DateContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_date);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(TEXT);
			setState(131); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(130);
				match(NEWLINE);
				}
				}
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimeContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_time);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(TEXT);
			setState(137); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(136);
				match(NEWLINE);
				}
				}
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DurationContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public DurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitDuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitDuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DurationContext duration() throws RecognitionException {
		DurationContext _localctx = new DurationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_duration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(TEXT);
			setState(143); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(142);
				match(NEWLINE);
				}
				}
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_dronesContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public List_drone_itemsContext list_drone_items() {
			return getRuleContext(List_drone_itemsContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public List_dronesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_drones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterList_drones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitList_drones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitList_drones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_dronesContext list_drones() throws RecognitionException {
		List_dronesContext _localctx = new List_dronesContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_list_drones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			title();
			setState(148);
			list_drone_items();
			setState(150); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(149);
				match(NEWLINE);
				}
				}
				setState(152); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_figuresContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public List_figure_itemsContext list_figure_items() {
			return getRuleContext(List_figure_itemsContext.class,0);
		}
		public List_figuresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_figures; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterList_figures(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitList_figures(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitList_figures(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_figuresContext list_figures() throws RecognitionException {
		List_figuresContext _localctx = new List_figuresContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_list_figures);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			title();
			setState(155);
			list_figure_items();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_drone_itemsContext extends ParserRuleContext {
		public TerminalNode DOTS() { return getToken(ShowProposalParser.DOTS, 0); }
		public List<TerminalNode> TEXT() { return getTokens(ShowProposalParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(ShowProposalParser.TEXT, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public List_drone_itemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_drone_items; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterList_drone_items(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitList_drone_items(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitList_drone_items(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_drone_itemsContext list_drone_items() throws RecognitionException {
		List_drone_itemsContext _localctx = new List_drone_itemsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_list_drone_items);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(157);
				match(TEXT);
				setState(158);
				match(NEWLINE);
				}
				}
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TEXT );
			setState(163);
			match(DOTS);
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(164);
				match(NEWLINE);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_figure_itemsContext extends ParserRuleContext {
		public TerminalNode DOTS() { return getToken(ShowProposalParser.DOTS, 0); }
		public List<TerminalNode> TEXT() { return getTokens(ShowProposalParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(ShowProposalParser.TEXT, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public List_figure_itemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_figure_items; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterList_figure_items(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitList_figure_items(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitList_figure_items(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_figure_itemsContext list_figure_items() throws RecognitionException {
		List_figure_itemsContext _localctx = new List_figure_itemsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_list_figure_items);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(167);
				match(TEXT);
				setState(168);
				match(NEWLINE);
				}
				}
				setState(171); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TEXT );
			setState(173);
			match(DOTS);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(174);
				match(NEWLINE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TitleContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_title);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(TEXT);
			setState(179); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(178);
				match(NEWLINE);
				}
				}
				setState(181); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Page_breakContext extends ParserRuleContext {
		public TerminalNode PAGE_BREAK() { return getToken(ShowProposalParser.PAGE_BREAK, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public TerminalNode SEPARATOR_LINE() { return getToken(ShowProposalParser.SEPARATOR_LINE, 0); }
		public Page_breakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_page_break; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterPage_break(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitPage_break(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitPage_break(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Page_breakContext page_break() throws RecognitionException {
		Page_breakContext _localctx = new Page_breakContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_page_break);
		int _la;
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PAGE_BREAK:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(PAGE_BREAK);
				setState(185); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(184);
					match(NEWLINE);
					}
					}
					setState(187); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			case SEPARATOR_LINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(SEPARATOR_LINE);
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(190);
					match(NEWLINE);
					}
					}
					setState(193); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 3);
				{
				setState(196); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(195);
					match(NEWLINE);
					}
					}
					setState(198); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Attachment_sectionContext extends ParserRuleContext {
		public Attachment_titleContext attachment_title() {
			return getRuleContext(Attachment_titleContext.class,0);
		}
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public List_dronesContext list_drones() {
			return getRuleContext(List_dronesContext.class,0);
		}
		public List_figuresContext list_figures() {
			return getRuleContext(List_figuresContext.class,0);
		}
		public Attachment_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attachment_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterAttachment_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitAttachment_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitAttachment_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attachment_sectionContext attachment_section() throws RecognitionException {
		Attachment_sectionContext _localctx = new Attachment_sectionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_attachment_section);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			attachment_title();
			setState(203);
			location();
			setState(204);
			date();
			setState(205);
			time();
			setState(206);
			duration();
			setState(207);
			list_drones();
			setState(208);
			list_figures();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Attachment_titleContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(ShowProposalParser.TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ShowProposalParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShowProposalParser.NEWLINE, i);
		}
		public Attachment_titleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attachment_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).enterAttachment_title(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShowProposalListener ) ((ShowProposalListener)listener).exitAttachment_title(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShowProposalVisitor ) return ((ShowProposalVisitor<? extends T>)visitor).visitAttachment_title(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attachment_titleContext attachment_title() throws RecognitionException {
		Attachment_titleContext _localctx = new Attachment_titleContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_attachment_title);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(TEXT);
			setState(212); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(211);
				match(NEWLINE);
				}
				}
				setState(214); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\b\u00d9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001@\b\u0001\u0001\u0002\u0004\u0002C\b\u0002\u000b"+
		"\u0002\f\u0002D\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0003\u0005R\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005X\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0004\te\b\t\u000b\t\f\tf\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0003\ru"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000ez\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0004\u000f~\b\u000f\u000b\u000f\f\u000f\u007f\u0001\u0010"+
		"\u0001\u0010\u0004\u0010\u0084\b\u0010\u000b\u0010\f\u0010\u0085\u0001"+
		"\u0011\u0001\u0011\u0004\u0011\u008a\b\u0011\u000b\u0011\f\u0011\u008b"+
		"\u0001\u0012\u0001\u0012\u0004\u0012\u0090\b\u0012\u000b\u0012\f\u0012"+
		"\u0091\u0001\u0013\u0001\u0013\u0001\u0013\u0004\u0013\u0097\b\u0013\u000b"+
		"\u0013\f\u0013\u0098\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0004\u0015\u00a0\b\u0015\u000b\u0015\f\u0015\u00a1\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u00a6\b\u0015\u0001\u0016\u0001\u0016\u0004\u0016"+
		"\u00aa\b\u0016\u000b\u0016\f\u0016\u00ab\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u00b0\b\u0016\u0001\u0017\u0001\u0017\u0004\u0017\u00b4\b\u0017"+
		"\u000b\u0017\f\u0017\u00b5\u0001\u0018\u0001\u0018\u0004\u0018\u00ba\b"+
		"\u0018\u000b\u0018\f\u0018\u00bb\u0001\u0018\u0001\u0018\u0004\u0018\u00c0"+
		"\b\u0018\u000b\u0018\f\u0018\u00c1\u0001\u0018\u0004\u0018\u00c5\b\u0018"+
		"\u000b\u0018\f\u0018\u00c6\u0003\u0018\u00c9\b\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0004\u001a\u00d5\b\u001a\u000b\u001a\f"+
		"\u001a\u00d6\u0001\u001a\u0000\u0000\u001b\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.024\u0000"+
		"\u0000\u00d4\u00006\u0001\u0000\u0000\u0000\u0002;\u0001\u0000\u0000\u0000"+
		"\u0004B\u0001\u0000\u0000\u0000\u0006H\u0001\u0000\u0000\u0000\bM\u0001"+
		"\u0000\u0000\u0000\nQ\u0001\u0000\u0000\u0000\fY\u0001\u0000\u0000\u0000"+
		"\u000e\\\u0001\u0000\u0000\u0000\u0010_\u0001\u0000\u0000\u0000\u0012"+
		"b\u0001\u0000\u0000\u0000\u0014h\u0001\u0000\u0000\u0000\u0016k\u0001"+
		"\u0000\u0000\u0000\u0018n\u0001\u0000\u0000\u0000\u001aq\u0001\u0000\u0000"+
		"\u0000\u001cv\u0001\u0000\u0000\u0000\u001e{\u0001\u0000\u0000\u0000 "+
		"\u0081\u0001\u0000\u0000\u0000\"\u0087\u0001\u0000\u0000\u0000$\u008d"+
		"\u0001\u0000\u0000\u0000&\u0093\u0001\u0000\u0000\u0000(\u009a\u0001\u0000"+
		"\u0000\u0000*\u009f\u0001\u0000\u0000\u0000,\u00a9\u0001\u0000\u0000\u0000"+
		".\u00b1\u0001\u0000\u0000\u00000\u00c8\u0001\u0000\u0000\u00002\u00ca"+
		"\u0001\u0000\u0000\u00004\u00d2\u0001\u0000\u0000\u000067\u0003\u0002"+
		"\u0001\u000078\u0003\u0004\u0002\u000089\u0003\b\u0004\u00009:\u0005\u0000"+
		"\u0000\u0001:\u0001\u0001\u0000\u0000\u0000;<\u0003\u0018\f\u0000<=\u0003"+
		"\n\u0005\u0000=?\u0003\u0014\n\u0000>@\u0003\u001a\r\u0000?>\u0001\u0000"+
		"\u0000\u0000?@\u0001\u0000\u0000\u0000@\u0003\u0001\u0000\u0000\u0000"+
		"AC\u0003\u001c\u000e\u0000BA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FG\u0003\u0006\u0003\u0000G\u0005\u0001\u0000\u0000\u0000"+
		"HI\u0003\u001c\u000e\u0000IJ\u0003\u001c\u000e\u0000JK\u0003\u001c\u000e"+
		"\u0000KL\u0003\u001c\u000e\u0000L\u0007\u0001\u0000\u0000\u0000MN\u0003"+
		"0\u0018\u0000NO\u00032\u0019\u0000O\t\u0001\u0000\u0000\u0000PR\u0003"+
		"\f\u0006\u0000QP\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0001"+
		"\u0000\u0000\u0000ST\u0003\u000e\u0007\u0000TU\u0003\u0010\b\u0000UW\u0003"+
		"\u0012\t\u0000VX\u0003\u0016\u000b\u0000WV\u0001\u0000\u0000\u0000WX\u0001"+
		"\u0000\u0000\u0000X\u000b\u0001\u0000\u0000\u0000YZ\u0005\u0006\u0000"+
		"\u0000Z[\u0005\u0007\u0000\u0000[\r\u0001\u0000\u0000\u0000\\]\u0005\u0006"+
		"\u0000\u0000]^\u0005\u0007\u0000\u0000^\u000f\u0001\u0000\u0000\u0000"+
		"_`\u0005\u0006\u0000\u0000`a\u0005\u0007\u0000\u0000a\u0011\u0001\u0000"+
		"\u0000\u0000bd\u0005\u0006\u0000\u0000ce\u0005\u0007\u0000\u0000dc\u0001"+
		"\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"fg\u0001\u0000\u0000\u0000g\u0013\u0001\u0000\u0000\u0000hi\u0005\u0006"+
		"\u0000\u0000ij\u0005\u0007\u0000\u0000j\u0015\u0001\u0000\u0000\u0000"+
		"kl\u0005\u0006\u0000\u0000lm\u0005\u0007\u0000\u0000m\u0017\u0001\u0000"+
		"\u0000\u0000no\u0005\u0006\u0000\u0000op\u0005\u0007\u0000\u0000p\u0019"+
		"\u0001\u0000\u0000\u0000qr\u0005\u0006\u0000\u0000rt\u0005\u0007\u0000"+
		"\u0000su\u0005\u0007\u0000\u0000ts\u0001\u0000\u0000\u0000tu\u0001\u0000"+
		"\u0000\u0000u\u001b\u0001\u0000\u0000\u0000vw\u0005\u0006\u0000\u0000"+
		"wy\u0005\u0007\u0000\u0000xz\u0005\u0007\u0000\u0000yx\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000z\u001d\u0001\u0000\u0000\u0000{}\u0005"+
		"\u0006\u0000\u0000|~\u0005\u0007\u0000\u0000}|\u0001\u0000\u0000\u0000"+
		"~\u007f\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\u001f\u0001\u0000\u0000\u0000\u0081\u0083"+
		"\u0005\u0006\u0000\u0000\u0082\u0084\u0005\u0007\u0000\u0000\u0083\u0082"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0083"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086!\u0001"+
		"\u0000\u0000\u0000\u0087\u0089\u0005\u0006\u0000\u0000\u0088\u008a\u0005"+
		"\u0007\u0000\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001"+
		"\u0000\u0000\u0000\u008c#\u0001\u0000\u0000\u0000\u008d\u008f\u0005\u0006"+
		"\u0000\u0000\u008e\u0090\u0005\u0007\u0000\u0000\u008f\u008e\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092%\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0003.\u0017\u0000\u0094\u0096\u0003*\u0015\u0000\u0095"+
		"\u0097\u0005\u0007\u0000\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097"+
		"\u0098\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0001\u0000\u0000\u0000\u0099\'\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0003.\u0017\u0000\u009b\u009c\u0003,\u0016\u0000\u009c)\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0005\u0006\u0000\u0000\u009e\u00a0\u0005\u0007"+
		"\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a5\u0005\u0004"+
		"\u0000\u0000\u00a4\u00a6\u0005\u0007\u0000\u0000\u00a5\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6+\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a8\u0005\u0006\u0000\u0000\u00a8\u00aa\u0005\u0007\u0000"+
		"\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00af\u0005\u0004\u0000"+
		"\u0000\u00ae\u00b0\u0005\u0007\u0000\u0000\u00af\u00ae\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0-\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b3\u0005\u0006\u0000\u0000\u00b2\u00b4\u0005\u0007\u0000\u0000"+
		"\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b6/\u0001\u0000\u0000\u0000\u00b7\u00b9\u0005\u0002\u0000\u0000\u00b8"+
		"\u00ba\u0005\u0007\u0000\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bc\u00c9\u0001\u0000\u0000\u0000\u00bd"+
		"\u00bf\u0005\u0003\u0000\u0000\u00be\u00c0\u0005\u0007\u0000\u0000\u00bf"+
		"\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c9\u0001\u0000\u0000\u0000\u00c3\u00c5\u0005\u0007\u0000\u0000\u00c4"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c9\u0001\u0000\u0000\u0000\u00c8\u00b7\u0001\u0000\u0000\u0000\u00c8"+
		"\u00bd\u0001\u0000\u0000\u0000\u00c8\u00c4\u0001\u0000\u0000\u0000\u00c9"+
		"1\u0001\u0000\u0000\u0000\u00ca\u00cb\u00034\u001a\u0000\u00cb\u00cc\u0003"+
		"\u001e\u000f\u0000\u00cc\u00cd\u0003 \u0010\u0000\u00cd\u00ce\u0003\""+
		"\u0011\u0000\u00ce\u00cf\u0003$\u0012\u0000\u00cf\u00d0\u0003&\u0013\u0000"+
		"\u00d0\u00d1\u0003(\u0014\u0000\u00d13\u0001\u0000\u0000\u0000\u00d2\u00d4"+
		"\u0005\u0006\u0000\u0000\u00d3\u00d5\u0005\u0007\u0000\u0000\u00d4\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d75\u0001"+
		"\u0000\u0000\u0000\u0016?DQWfty\u007f\u0085\u008b\u0091\u0098\u00a1\u00a5"+
		"\u00ab\u00af\u00b5\u00bb\u00c1\u00c6\u00c8\u00d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}