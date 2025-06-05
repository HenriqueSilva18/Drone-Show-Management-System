// Generated from DSL_GRAMMAR.g4 by ANTLR 4.13.0
package dsl_plugin.generated_code;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class DSL_GRAMMARParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, PAUSE_STATEMENT=37, 
		RED=38, GREEN=39, BLUE=40, YELLOW=41, PI=42, PI_DIV_EXPR=43, DECIMAL_LIT=44, 
		COORDINATE=45, LPAREN=46, RPAREN=47, SEMICOLON=48, COMMA=49, NUMBER=50, 
		VERSION=51, ID=52, WHITESPACE=53, COMMENT=54;
	public static final int
		RULE_program = 0, RULE_figure_standalone = 1, RULE_show_definition = 2, 
		RULE_drones_section = 3, RULE_sequence_section = 4, RULE_figure_in_show = 5, 
		RULE_mapping_section = 6, RULE_dslVersion = 7, RULE_declarations = 8, 
		RULE_declaration = 9, RULE_droneTypeDeclaration = 10, RULE_positionDeclaration = 11, 
		RULE_velocityDeclaration = 12, RULE_velocityExpr = 13, RULE_distanceDeclaration = 14, 
		RULE_figureDeclaration = 15, RULE_figureParam = 16, RULE_expression = 17, 
		RULE_statements = 18, RULE_statement = 19, RULE_beforeBlock = 20, RULE_afterBlock = 21, 
		RULE_groupBlock = 22, RULE_blockContent = 23, RULE_singleAction = 24, 
		RULE_figureAction = 25, RULE_distanceValue = 26, RULE_velocityValue = 27, 
		RULE_rotationValue = 28, RULE_colorValue = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "figure_standalone", "show_definition", "drones_section", 
			"sequence_section", "figure_in_show", "mapping_section", "dslVersion", 
			"declarations", "declaration", "droneTypeDeclaration", "positionDeclaration", 
			"velocityDeclaration", "velocityExpr", "distanceDeclaration", "figureDeclaration", 
			"figureParam", "expression", "statements", "statement", "beforeBlock", 
			"afterBlock", "groupBlock", "blockContent", "singleAction", "figureAction", 
			"distanceValue", "velocityValue", "rotationValue", "colorValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Show'", "'{'", "'}'", "'Drones'", "':'", "'Sequence'", "'Figure'", 
			"'Map'", "'->'", "'DSL'", "'version'", "'DroneType'", "'Position'", "'='", 
			"'Velocity'", "'Distance'", "'Line'", "'Rectangle'", "'Circle'", "'Circumference'", 
			"'-'", "'*'", "'/'", "'+'", "'before'", "'endbefore'", "'after'", "'endafter'", 
			"'group'", "'endgroup'", "'.'", "'lightsOn'", "'lightsOff'", "'move'", 
			"'movePos'", "'rotate'", null, "'RED'", "'GREEN'", "'BLUE'", "'YELLOW'", 
			"'PI'", null, null, null, "'('", "')'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "PAUSE_STATEMENT", "RED", "GREEN", "BLUE", "YELLOW", "PI", "PI_DIV_EXPR", 
			"DECIMAL_LIT", "COORDINATE", "LPAREN", "RPAREN", "SEMICOLON", "COMMA", 
			"NUMBER", "VERSION", "ID", "WHITESPACE", "COMMENT"
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
	public String getGrammarFileName() { return "DSL_GRAMMAR.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DSL_GRAMMARParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public DslVersionContext dslVersion() {
			return getRuleContext(DslVersionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DSL_GRAMMARParser.EOF, 0); }
		public Show_definitionContext show_definition() {
			return getRuleContext(Show_definitionContext.class,0);
		}
		public Figure_standaloneContext figure_standalone() {
			return getRuleContext(Figure_standaloneContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			dslVersion();
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(61);
				show_definition();
				}
				break;
			case EOF:
			case T__11:
			case T__12:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__24:
			case T__26:
			case T__28:
			case PAUSE_STATEMENT:
			case ID:
				{
				setState(62);
				figure_standalone();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(65);
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
	public static class Figure_standaloneContext extends ParserRuleContext {
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Figure_standaloneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figure_standalone; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterFigure_standalone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitFigure_standalone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitFigure_standalone(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Figure_standaloneContext figure_standalone() throws RecognitionException {
		Figure_standaloneContext _localctx = new Figure_standaloneContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_figure_standalone);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			declarations();
			setState(68);
			statements();
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
	public static class Show_definitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public Drones_sectionContext drones_section() {
			return getRuleContext(Drones_sectionContext.class,0);
		}
		public Sequence_sectionContext sequence_section() {
			return getRuleContext(Sequence_sectionContext.class,0);
		}
		public Show_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterShow_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitShow_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitShow_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_definitionContext show_definition() throws RecognitionException {
		Show_definitionContext _localctx = new Show_definitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_show_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__0);
			setState(71);
			match(ID);
			setState(72);
			match(T__1);
			setState(73);
			drones_section();
			setState(74);
			sequence_section();
			setState(75);
			match(T__2);
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
	public static class Drones_sectionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(DSL_GRAMMARParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DSL_GRAMMARParser.ID, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(DSL_GRAMMARParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(DSL_GRAMMARParser.NUMBER, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(DSL_GRAMMARParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(DSL_GRAMMARParser.SEMICOLON, i);
		}
		public Drones_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drones_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterDrones_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitDrones_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitDrones_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drones_sectionContext drones_section() throws RecognitionException {
		Drones_sectionContext _localctx = new Drones_sectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_drones_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__3);
			setState(78);
			match(T__1);
			setState(83); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				match(ID);
				setState(80);
				match(T__4);
				setState(81);
				match(NUMBER);
				setState(82);
				match(SEMICOLON);
				}
				}
				setState(85); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(87);
			match(T__2);
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
	public static class Sequence_sectionContext extends ParserRuleContext {
		public List<Figure_in_showContext> figure_in_show() {
			return getRuleContexts(Figure_in_showContext.class);
		}
		public Figure_in_showContext figure_in_show(int i) {
			return getRuleContext(Figure_in_showContext.class,i);
		}
		public Sequence_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterSequence_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitSequence_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitSequence_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sequence_sectionContext sequence_section() throws RecognitionException {
		Sequence_sectionContext _localctx = new Sequence_sectionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sequence_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__5);
			setState(90);
			match(T__1);
			setState(92); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(91);
				figure_in_show();
				}
				}
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 );
			setState(96);
			match(T__2);
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
	public static class Figure_in_showContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public Mapping_sectionContext mapping_section() {
			return getRuleContext(Mapping_sectionContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Figure_in_showContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figure_in_show; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterFigure_in_show(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitFigure_in_show(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitFigure_in_show(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Figure_in_showContext figure_in_show() throws RecognitionException {
		Figure_in_showContext _localctx = new Figure_in_showContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_figure_in_show);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__6);
			setState(99);
			match(ID);
			setState(100);
			match(T__1);
			setState(101);
			mapping_section();
			setState(102);
			declarations();
			setState(103);
			statements();
			setState(104);
			match(T__2);
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
	public static class Mapping_sectionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(DSL_GRAMMARParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DSL_GRAMMARParser.ID, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(DSL_GRAMMARParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(DSL_GRAMMARParser.SEMICOLON, i);
		}
		public Mapping_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterMapping_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitMapping_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitMapping_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mapping_sectionContext mapping_section() throws RecognitionException {
		Mapping_sectionContext _localctx = new Mapping_sectionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mapping_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__7);
			setState(107);
			match(T__1);
			setState(112); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(108);
				match(ID);
				setState(109);
				match(T__8);
				setState(110);
				match(ID);
				setState(111);
				match(SEMICOLON);
				}
				}
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(116);
			match(T__2);
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
	public static class DslVersionContext extends ParserRuleContext {
		public TerminalNode VERSION() { return getToken(DSL_GRAMMARParser.VERSION, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_GRAMMARParser.SEMICOLON, 0); }
		public DslVersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dslVersion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterDslVersion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitDslVersion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitDslVersion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DslVersionContext dslVersion() throws RecognitionException {
		DslVersionContext _localctx = new DslVersionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dslVersion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__9);
			setState(119);
			match(T__10);
			setState(120);
			match(VERSION);
			setState(121);
			match(SEMICOLON);
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
	public static class DeclarationsContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2076672L) != 0)) {
				{
				{
				setState(123);
				declaration();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class DeclarationContext extends ParserRuleContext {
		public DroneTypeDeclarationContext droneTypeDeclaration() {
			return getRuleContext(DroneTypeDeclarationContext.class,0);
		}
		public PositionDeclarationContext positionDeclaration() {
			return getRuleContext(PositionDeclarationContext.class,0);
		}
		public VelocityDeclarationContext velocityDeclaration() {
			return getRuleContext(VelocityDeclarationContext.class,0);
		}
		public DistanceDeclarationContext distanceDeclaration() {
			return getRuleContext(DistanceDeclarationContext.class,0);
		}
		public FigureDeclarationContext figureDeclaration() {
			return getRuleContext(FigureDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declaration);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				droneTypeDeclaration();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				positionDeclaration();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				velocityDeclaration();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				distanceDeclaration();
				}
				break;
			case T__16:
			case T__17:
			case T__18:
			case T__19:
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				figureDeclaration();
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
	public static class DroneTypeDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_GRAMMARParser.SEMICOLON, 0); }
		public DroneTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_droneTypeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterDroneTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitDroneTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitDroneTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DroneTypeDeclarationContext droneTypeDeclaration() throws RecognitionException {
		DroneTypeDeclarationContext _localctx = new DroneTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_droneTypeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__11);
			setState(137);
			match(ID);
			setState(138);
			match(SEMICOLON);
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
	public static class PositionDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public TerminalNode COORDINATE() { return getToken(DSL_GRAMMARParser.COORDINATE, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_GRAMMARParser.SEMICOLON, 0); }
		public PositionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterPositionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitPositionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitPositionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PositionDeclarationContext positionDeclaration() throws RecognitionException {
		PositionDeclarationContext _localctx = new PositionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_positionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__12);
			setState(141);
			match(ID);
			setState(142);
			match(T__13);
			setState(143);
			match(COORDINATE);
			setState(144);
			match(SEMICOLON);
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
	public static class VelocityDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public VelocityExprContext velocityExpr() {
			return getRuleContext(VelocityExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(DSL_GRAMMARParser.SEMICOLON, 0); }
		public VelocityDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_velocityDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterVelocityDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitVelocityDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitVelocityDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VelocityDeclarationContext velocityDeclaration() throws RecognitionException {
		VelocityDeclarationContext _localctx = new VelocityDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_velocityDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__14);
			setState(147);
			match(ID);
			setState(148);
			match(T__13);
			setState(149);
			velocityExpr();
			setState(150);
			match(SEMICOLON);
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
	public static class VelocityExprContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(DSL_GRAMMARParser.NUMBER, 0); }
		public TerminalNode DECIMAL_LIT() { return getToken(DSL_GRAMMARParser.DECIMAL_LIT, 0); }
		public TerminalNode PI_DIV_EXPR() { return getToken(DSL_GRAMMARParser.PI_DIV_EXPR, 0); }
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public VelocityExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_velocityExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterVelocityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitVelocityExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitVelocityExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VelocityExprContext velocityExpr() throws RecognitionException {
		VelocityExprContext _localctx = new VelocityExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_velocityExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 5655887813279744L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class DistanceDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(DSL_GRAMMARParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DSL_GRAMMARParser.ID, i);
		}
		public TerminalNode SEMICOLON() { return getToken(DSL_GRAMMARParser.SEMICOLON, 0); }
		public TerminalNode NUMBER() { return getToken(DSL_GRAMMARParser.NUMBER, 0); }
		public DistanceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_distanceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterDistanceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitDistanceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitDistanceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DistanceDeclarationContext distanceDeclaration() throws RecognitionException {
		DistanceDeclarationContext _localctx = new DistanceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_distanceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__15);
			setState(155);
			match(ID);
			setState(156);
			match(T__13);
			setState(157);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(158);
			match(SEMICOLON);
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
	public static class FigureDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(DSL_GRAMMARParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DSL_GRAMMARParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(DSL_GRAMMARParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DSL_GRAMMARParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DSL_GRAMMARParser.COMMA, i);
		}
		public List<FigureParamContext> figureParam() {
			return getRuleContexts(FigureParamContext.class);
		}
		public FigureParamContext figureParam(int i) {
			return getRuleContext(FigureParamContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(DSL_GRAMMARParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_GRAMMARParser.SEMICOLON, 0); }
		public FigureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figureDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterFigureDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitFigureDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitFigureDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureDeclarationContext figureDeclaration() throws RecognitionException {
		FigureDeclarationContext _localctx = new FigureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_figureDeclaration);
		try {
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(T__16);
				setState(161);
				match(ID);
				setState(162);
				match(LPAREN);
				setState(163);
				match(ID);
				setState(164);
				match(COMMA);
				setState(165);
				figureParam();
				setState(166);
				match(COMMA);
				setState(167);
				match(ID);
				setState(168);
				match(RPAREN);
				setState(169);
				match(SEMICOLON);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(T__17);
				setState(172);
				match(ID);
				setState(173);
				match(LPAREN);
				setState(174);
				match(ID);
				setState(175);
				match(COMMA);
				setState(176);
				figureParam();
				setState(177);
				match(COMMA);
				setState(178);
				figureParam();
				setState(179);
				match(COMMA);
				setState(180);
				match(ID);
				setState(181);
				match(RPAREN);
				setState(182);
				match(SEMICOLON);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				match(T__18);
				setState(185);
				match(ID);
				setState(186);
				match(LPAREN);
				setState(187);
				match(ID);
				setState(188);
				match(COMMA);
				setState(189);
				figureParam();
				setState(190);
				match(COMMA);
				setState(191);
				match(ID);
				setState(192);
				match(RPAREN);
				setState(193);
				match(SEMICOLON);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 4);
				{
				setState(195);
				match(T__19);
				setState(196);
				match(ID);
				setState(197);
				match(LPAREN);
				setState(198);
				match(ID);
				setState(199);
				match(COMMA);
				setState(200);
				figureParam();
				setState(201);
				match(COMMA);
				setState(202);
				match(ID);
				setState(203);
				match(RPAREN);
				setState(204);
				match(SEMICOLON);
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
	public static class FigureParamContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(DSL_GRAMMARParser.NUMBER, 0); }
		public FigureParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figureParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterFigureParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitFigureParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitFigureParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureParamContext figureParam() throws RecognitionException {
		FigureParamContext _localctx = new FigureParamContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_figureParam);
		try {
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				match(NUMBER);
				}
				break;
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
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberPiExprContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(DSL_GRAMMARParser.NUMBER, 0); }
		public TerminalNode PI() { return getToken(DSL_GRAMMARParser.PI, 0); }
		public NumberPiExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterNumberPiExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitNumberPiExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitNumberPiExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PiExprContext extends ExpressionContext {
		public TerminalNode PI() { return getToken(DSL_GRAMMARParser.PI, 0); }
		public PiExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterPiExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitPiExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitPiExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public IdExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplyExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultiplyExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterMultiplyExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitMultiplyExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitMultiplyExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberExprContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(DSL_GRAMMARParser.NUMBER, 0); }
		public NumberExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterNumberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitNumberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitNumberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegativeIdExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public NegativeIdExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterNegativeIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitNegativeIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitNegativeIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdPiExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public TerminalNode PI() { return getToken(DSL_GRAMMARParser.PI, 0); }
		public IdPiExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterIdPiExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitIdPiExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitIdPiExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubtractExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SubtractExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterSubtractExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitSubtractExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitSubtractExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegativeNumberExprContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(DSL_GRAMMARParser.NUMBER, 0); }
		public NegativeNumberExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterNegativeNumberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitNegativeNumberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitNegativeNumberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(DSL_GRAMMARParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DSL_GRAMMARParser.RPAREN, 0); }
		public ParenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivideExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DivideExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterDivideExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitDivideExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitDivideExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new NumberExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(214);
				match(NUMBER);
				}
				break;
			case 2:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				match(ID);
				}
				break;
			case 3:
				{
				_localctx = new PiExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				match(PI);
				}
				break;
			case 4:
				{
				_localctx = new NegativeNumberExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				match(T__20);
				setState(218);
				match(NUMBER);
				}
				break;
			case 5:
				{
				_localctx = new NegativeIdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				match(T__20);
				setState(220);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new NumberPiExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				match(NUMBER);
				setState(222);
				match(T__21);
				setState(223);
				match(PI);
				}
				break;
			case 7:
				{
				_localctx = new IdPiExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				match(ID);
				setState(225);
				match(T__21);
				setState(226);
				match(PI);
				}
				break;
			case 8:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(LPAREN);
				setState(228);
				expression(0);
				setState(229);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(247);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(245);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplyExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(233);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(234);
						match(T__21);
						setState(235);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new DivideExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(236);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(237);
						match(T__22);
						setState(238);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new AddExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(239);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(240);
						match(T__23);
						setState(241);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new SubtractExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(242);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(243);
						match(T__20);
						setState(244);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(249);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503737770967040L) != 0)) {
				{
				{
				setState(250);
				statement();
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class StatementContext extends ParserRuleContext {
		public BeforeBlockContext beforeBlock() {
			return getRuleContext(BeforeBlockContext.class,0);
		}
		public AfterBlockContext afterBlock() {
			return getRuleContext(AfterBlockContext.class,0);
		}
		public GroupBlockContext groupBlock() {
			return getRuleContext(GroupBlockContext.class,0);
		}
		public TerminalNode PAUSE_STATEMENT() { return getToken(DSL_GRAMMARParser.PAUSE_STATEMENT, 0); }
		public SingleActionContext singleAction() {
			return getRuleContext(SingleActionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_statement);
		try {
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				beforeBlock();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				afterBlock();
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 3);
				{
				setState(258);
				groupBlock();
				}
				break;
			case PAUSE_STATEMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(259);
				match(PAUSE_STATEMENT);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(260);
				singleAction();
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
	public static class BeforeBlockContext extends ParserRuleContext {
		public BlockContentContext blockContent() {
			return getRuleContext(BlockContentContext.class,0);
		}
		public BeforeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beforeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterBeforeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitBeforeBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitBeforeBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeforeBlockContext beforeBlock() throws RecognitionException {
		BeforeBlockContext _localctx = new BeforeBlockContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_beforeBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(T__24);
			setState(264);
			blockContent();
			setState(265);
			match(T__25);
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
	public static class AfterBlockContext extends ParserRuleContext {
		public BlockContentContext blockContent() {
			return getRuleContext(BlockContentContext.class,0);
		}
		public AfterBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_afterBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterAfterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitAfterBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitAfterBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AfterBlockContext afterBlock() throws RecognitionException {
		AfterBlockContext _localctx = new AfterBlockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_afterBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(T__26);
			setState(268);
			blockContent();
			setState(269);
			match(T__27);
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
	public static class GroupBlockContext extends ParserRuleContext {
		public BlockContentContext blockContent() {
			return getRuleContext(BlockContentContext.class,0);
		}
		public GroupBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterGroupBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitGroupBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitGroupBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupBlockContext groupBlock() throws RecognitionException {
		GroupBlockContext _localctx = new GroupBlockContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_groupBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(T__28);
			setState(272);
			blockContent();
			setState(273);
			match(T__29);
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
	public static class BlockContentContext extends ParserRuleContext {
		public List<SingleActionContext> singleAction() {
			return getRuleContexts(SingleActionContext.class);
		}
		public SingleActionContext singleAction(int i) {
			return getRuleContext(SingleActionContext.class,i);
		}
		public List<GroupBlockContext> groupBlock() {
			return getRuleContexts(GroupBlockContext.class);
		}
		public GroupBlockContext groupBlock(int i) {
			return getRuleContext(GroupBlockContext.class,i);
		}
		public BlockContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterBlockContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitBlockContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitBlockContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContentContext blockContent() throws RecognitionException {
		BlockContentContext _localctx = new BlockContentContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_blockContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__28 || _la==ID) {
				{
				setState(277);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(275);
					singleAction();
					}
					break;
				case T__28:
					{
					setState(276);
					groupBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class SingleActionContext extends ParserRuleContext {
		public FigureActionContext figureAction() {
			return getRuleContext(FigureActionContext.class,0);
		}
		public SingleActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterSingleAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitSingleAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitSingleAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleActionContext singleAction() throws RecognitionException {
		SingleActionContext _localctx = new SingleActionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_singleAction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			figureAction();
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
	public static class FigureActionContext extends ParserRuleContext {
		public FigureActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figureAction; }
	 
		public FigureActionContext() { }
		public void copyFrom(FigureActionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MoveActionContext extends FigureActionContext {
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(DSL_GRAMMARParser.LPAREN, 0); }
		public TerminalNode COORDINATE() { return getToken(DSL_GRAMMARParser.COORDINATE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DSL_GRAMMARParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DSL_GRAMMARParser.COMMA, i);
		}
		public DistanceValueContext distanceValue() {
			return getRuleContext(DistanceValueContext.class,0);
		}
		public VelocityValueContext velocityValue() {
			return getRuleContext(VelocityValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DSL_GRAMMARParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_GRAMMARParser.SEMICOLON, 0); }
		public MoveActionContext(FigureActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterMoveAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitMoveAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitMoveAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MovePosActionContext extends FigureActionContext {
		public List<TerminalNode> ID() { return getTokens(DSL_GRAMMARParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DSL_GRAMMARParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(DSL_GRAMMARParser.LPAREN, 0); }
		public TerminalNode COMMA() { return getToken(DSL_GRAMMARParser.COMMA, 0); }
		public VelocityValueContext velocityValue() {
			return getRuleContext(VelocityValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DSL_GRAMMARParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_GRAMMARParser.SEMICOLON, 0); }
		public MovePosActionContext(FigureActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterMovePosAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitMovePosAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitMovePosAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RotateActionContext extends FigureActionContext {
		public List<TerminalNode> ID() { return getTokens(DSL_GRAMMARParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DSL_GRAMMARParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(DSL_GRAMMARParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DSL_GRAMMARParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DSL_GRAMMARParser.COMMA, i);
		}
		public RotationValueContext rotationValue() {
			return getRuleContext(RotationValueContext.class,0);
		}
		public VelocityValueContext velocityValue() {
			return getRuleContext(VelocityValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DSL_GRAMMARParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_GRAMMARParser.SEMICOLON, 0); }
		public RotateActionContext(FigureActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterRotateAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitRotateAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitRotateAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LightsOnActionContext extends FigureActionContext {
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(DSL_GRAMMARParser.LPAREN, 0); }
		public ColorValueContext colorValue() {
			return getRuleContext(ColorValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DSL_GRAMMARParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_GRAMMARParser.SEMICOLON, 0); }
		public LightsOnActionContext(FigureActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterLightsOnAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitLightsOnAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitLightsOnAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LightsOffActionContext extends FigureActionContext {
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_GRAMMARParser.SEMICOLON, 0); }
		public LightsOffActionContext(FigureActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterLightsOffAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitLightsOffAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitLightsOffAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureActionContext figureAction() throws RecognitionException {
		FigureActionContext _localctx = new FigureActionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_figureAction);
		try {
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new LightsOnActionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				match(ID);
				setState(285);
				match(T__30);
				setState(286);
				match(T__31);
				setState(287);
				match(LPAREN);
				setState(288);
				colorValue();
				setState(289);
				match(RPAREN);
				setState(290);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new LightsOffActionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				match(ID);
				setState(293);
				match(T__30);
				setState(294);
				match(T__32);
				setState(295);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new MoveActionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(296);
				match(ID);
				setState(297);
				match(T__30);
				setState(298);
				match(T__33);
				setState(299);
				match(LPAREN);
				setState(300);
				match(COORDINATE);
				setState(301);
				match(COMMA);
				setState(302);
				distanceValue();
				setState(303);
				match(COMMA);
				setState(304);
				velocityValue();
				setState(305);
				match(RPAREN);
				setState(306);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new MovePosActionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(308);
				match(ID);
				setState(309);
				match(T__30);
				setState(310);
				match(T__34);
				setState(311);
				match(LPAREN);
				setState(312);
				match(ID);
				setState(313);
				match(COMMA);
				setState(314);
				velocityValue();
				setState(315);
				match(RPAREN);
				setState(316);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new RotateActionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(318);
				match(ID);
				setState(319);
				match(T__30);
				setState(320);
				match(T__35);
				setState(321);
				match(LPAREN);
				setState(322);
				match(ID);
				setState(323);
				match(COMMA);
				setState(324);
				match(ID);
				setState(325);
				match(COMMA);
				setState(326);
				rotationValue();
				setState(327);
				match(COMMA);
				setState(328);
				velocityValue();
				setState(329);
				match(RPAREN);
				setState(330);
				match(SEMICOLON);
				}
				break;
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
	public static class DistanceValueContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(DSL_GRAMMARParser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public DistanceValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_distanceValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterDistanceValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitDistanceValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitDistanceValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DistanceValueContext distanceValue() throws RecognitionException {
		DistanceValueContext _localctx = new DistanceValueContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_distanceValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class VelocityValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public VelocityValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_velocityValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterVelocityValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitVelocityValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitVelocityValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VelocityValueContext velocityValue() throws RecognitionException {
		VelocityValueContext _localctx = new VelocityValueContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_velocityValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(ID);
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
	public static class RotationValueContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(DSL_GRAMMARParser.NUMBER, 0); }
		public TerminalNode PI() { return getToken(DSL_GRAMMARParser.PI, 0); }
		public TerminalNode ID() { return getToken(DSL_GRAMMARParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RotationValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotationValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterRotationValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitRotationValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitRotationValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RotationValueContext rotationValue() throws RecognitionException {
		RotationValueContext _localctx = new RotationValueContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_rotationValue);
		try {
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(338);
				match(NUMBER);
				setState(339);
				match(T__21);
				setState(340);
				match(PI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				match(T__20);
				setState(342);
				match(NUMBER);
				setState(343);
				match(T__21);
				setState(344);
				match(PI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(345);
				match(ID);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(346);
				expression(0);
				}
				break;
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
	public static class ColorValueContext extends ParserRuleContext {
		public TerminalNode RED() { return getToken(DSL_GRAMMARParser.RED, 0); }
		public TerminalNode GREEN() { return getToken(DSL_GRAMMARParser.GREEN, 0); }
		public TerminalNode BLUE() { return getToken(DSL_GRAMMARParser.BLUE, 0); }
		public TerminalNode YELLOW() { return getToken(DSL_GRAMMARParser.YELLOW, 0); }
		public ColorValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colorValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).enterColorValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_GRAMMARListener ) ((DSL_GRAMMARListener)listener).exitColorValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_GRAMMARVisitor ) return ((DSL_GRAMMARVisitor<? extends T>)visitor).visitColorValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorValueContext colorValue() throws RecognitionException {
		ColorValueContext _localctx = new ColorValueContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_colorValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4123168604160L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00016\u0160\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0003\u0000@\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003T\b\u0003\u000b\u0003"+
		"\f\u0003U\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0004\u0004]\b\u0004\u000b\u0004\f\u0004^\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0004\u0006q\b\u0006\u000b\u0006\f\u0006r\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0005\b}\b\b\n\b\f\b\u0080\t\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u0087\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u00cf\b\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00d4\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00e8\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u00f6\b\u0011\n\u0011\f\u0011\u00f9\t\u0011\u0001\u0012\u0005\u0012\u00fc"+
		"\b\u0012\n\u0012\f\u0012\u00ff\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u0106\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0005\u0017\u0116\b\u0017\n\u0017\f\u0017\u0119\t\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0003\u0019\u014d\b\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u015c\b\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0000\u0001\"\u001e\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:\u0000\u0003\u0003\u0000+,2244\u0002\u00002244\u0001\u0000&)\u0168"+
		"\u0000<\u0001\u0000\u0000\u0000\u0002C\u0001\u0000\u0000\u0000\u0004F"+
		"\u0001\u0000\u0000\u0000\u0006M\u0001\u0000\u0000\u0000\bY\u0001\u0000"+
		"\u0000\u0000\nb\u0001\u0000\u0000\u0000\fj\u0001\u0000\u0000\u0000\u000e"+
		"v\u0001\u0000\u0000\u0000\u0010~\u0001\u0000\u0000\u0000\u0012\u0086\u0001"+
		"\u0000\u0000\u0000\u0014\u0088\u0001\u0000\u0000\u0000\u0016\u008c\u0001"+
		"\u0000\u0000\u0000\u0018\u0092\u0001\u0000\u0000\u0000\u001a\u0098\u0001"+
		"\u0000\u0000\u0000\u001c\u009a\u0001\u0000\u0000\u0000\u001e\u00ce\u0001"+
		"\u0000\u0000\u0000 \u00d3\u0001\u0000\u0000\u0000\"\u00e7\u0001\u0000"+
		"\u0000\u0000$\u00fd\u0001\u0000\u0000\u0000&\u0105\u0001\u0000\u0000\u0000"+
		"(\u0107\u0001\u0000\u0000\u0000*\u010b\u0001\u0000\u0000\u0000,\u010f"+
		"\u0001\u0000\u0000\u0000.\u0117\u0001\u0000\u0000\u00000\u011a\u0001\u0000"+
		"\u0000\u00002\u014c\u0001\u0000\u0000\u00004\u014e\u0001\u0000\u0000\u0000"+
		"6\u0150\u0001\u0000\u0000\u00008\u015b\u0001\u0000\u0000\u0000:\u015d"+
		"\u0001\u0000\u0000\u0000<?\u0003\u000e\u0007\u0000=@\u0003\u0004\u0002"+
		"\u0000>@\u0003\u0002\u0001\u0000?=\u0001\u0000\u0000\u0000?>\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0005\u0000\u0000\u0001B\u0001"+
		"\u0001\u0000\u0000\u0000CD\u0003\u0010\b\u0000DE\u0003$\u0012\u0000E\u0003"+
		"\u0001\u0000\u0000\u0000FG\u0005\u0001\u0000\u0000GH\u00054\u0000\u0000"+
		"HI\u0005\u0002\u0000\u0000IJ\u0003\u0006\u0003\u0000JK\u0003\b\u0004\u0000"+
		"KL\u0005\u0003\u0000\u0000L\u0005\u0001\u0000\u0000\u0000MN\u0005\u0004"+
		"\u0000\u0000NS\u0005\u0002\u0000\u0000OP\u00054\u0000\u0000PQ\u0005\u0005"+
		"\u0000\u0000QR\u00052\u0000\u0000RT\u00050\u0000\u0000SO\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000"+
		"\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0005\u0003\u0000\u0000X\u0007"+
		"\u0001\u0000\u0000\u0000YZ\u0005\u0006\u0000\u0000Z\\\u0005\u0002\u0000"+
		"\u0000[]\u0003\n\u0005\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0001"+
		"\u0000\u0000\u0000`a\u0005\u0003\u0000\u0000a\t\u0001\u0000\u0000\u0000"+
		"bc\u0005\u0007\u0000\u0000cd\u00054\u0000\u0000de\u0005\u0002\u0000\u0000"+
		"ef\u0003\f\u0006\u0000fg\u0003\u0010\b\u0000gh\u0003$\u0012\u0000hi\u0005"+
		"\u0003\u0000\u0000i\u000b\u0001\u0000\u0000\u0000jk\u0005\b\u0000\u0000"+
		"kp\u0005\u0002\u0000\u0000lm\u00054\u0000\u0000mn\u0005\t\u0000\u0000"+
		"no\u00054\u0000\u0000oq\u00050\u0000\u0000pl\u0001\u0000\u0000\u0000q"+
		"r\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000tu\u0005\u0003\u0000\u0000u\r\u0001\u0000"+
		"\u0000\u0000vw\u0005\n\u0000\u0000wx\u0005\u000b\u0000\u0000xy\u00053"+
		"\u0000\u0000yz\u00050\u0000\u0000z\u000f\u0001\u0000\u0000\u0000{}\u0003"+
		"\u0012\t\u0000|{\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000"+
		"~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0011"+
		"\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0087\u0003"+
		"\u0014\n\u0000\u0082\u0087\u0003\u0016\u000b\u0000\u0083\u0087\u0003\u0018"+
		"\f\u0000\u0084\u0087\u0003\u001c\u000e\u0000\u0085\u0087\u0003\u001e\u000f"+
		"\u0000\u0086\u0081\u0001\u0000\u0000\u0000\u0086\u0082\u0001\u0000\u0000"+
		"\u0000\u0086\u0083\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000"+
		"\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0013\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0005\f\u0000\u0000\u0089\u008a\u00054\u0000\u0000"+
		"\u008a\u008b\u00050\u0000\u0000\u008b\u0015\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0005\r\u0000\u0000\u008d\u008e\u00054\u0000\u0000\u008e\u008f"+
		"\u0005\u000e\u0000\u0000\u008f\u0090\u0005-\u0000\u0000\u0090\u0091\u0005"+
		"0\u0000\u0000\u0091\u0017\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u000f"+
		"\u0000\u0000\u0093\u0094\u00054\u0000\u0000\u0094\u0095\u0005\u000e\u0000"+
		"\u0000\u0095\u0096\u0003\u001a\r\u0000\u0096\u0097\u00050\u0000\u0000"+
		"\u0097\u0019\u0001\u0000\u0000\u0000\u0098\u0099\u0007\u0000\u0000\u0000"+
		"\u0099\u001b\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0010\u0000\u0000"+
		"\u009b\u009c\u00054\u0000\u0000\u009c\u009d\u0005\u000e\u0000\u0000\u009d"+
		"\u009e\u0007\u0001\u0000\u0000\u009e\u009f\u00050\u0000\u0000\u009f\u001d"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u0011\u0000\u0000\u00a1\u00a2"+
		"\u00054\u0000\u0000\u00a2\u00a3\u0005.\u0000\u0000\u00a3\u00a4\u00054"+
		"\u0000\u0000\u00a4\u00a5\u00051\u0000\u0000\u00a5\u00a6\u0003 \u0010\u0000"+
		"\u00a6\u00a7\u00051\u0000\u0000\u00a7\u00a8\u00054\u0000\u0000\u00a8\u00a9"+
		"\u0005/\u0000\u0000\u00a9\u00aa\u00050\u0000\u0000\u00aa\u00cf\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ac\u0005\u0012\u0000\u0000\u00ac\u00ad\u00054\u0000"+
		"\u0000\u00ad\u00ae\u0005.\u0000\u0000\u00ae\u00af\u00054\u0000\u0000\u00af"+
		"\u00b0\u00051\u0000\u0000\u00b0\u00b1\u0003 \u0010\u0000\u00b1\u00b2\u0005"+
		"1\u0000\u0000\u00b2\u00b3\u0003 \u0010\u0000\u00b3\u00b4\u00051\u0000"+
		"\u0000\u00b4\u00b5\u00054\u0000\u0000\u00b5\u00b6\u0005/\u0000\u0000\u00b6"+
		"\u00b7\u00050\u0000\u0000\u00b7\u00cf\u0001\u0000\u0000\u0000\u00b8\u00b9"+
		"\u0005\u0013\u0000\u0000\u00b9\u00ba\u00054\u0000\u0000\u00ba\u00bb\u0005"+
		".\u0000\u0000\u00bb\u00bc\u00054\u0000\u0000\u00bc\u00bd\u00051\u0000"+
		"\u0000\u00bd\u00be\u0003 \u0010\u0000\u00be\u00bf\u00051\u0000\u0000\u00bf"+
		"\u00c0\u00054\u0000\u0000\u00c0\u00c1\u0005/\u0000\u0000\u00c1\u00c2\u0005"+
		"0\u0000\u0000\u00c2\u00cf\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005\u0014"+
		"\u0000\u0000\u00c4\u00c5\u00054\u0000\u0000\u00c5\u00c6\u0005.\u0000\u0000"+
		"\u00c6\u00c7\u00054\u0000\u0000\u00c7\u00c8\u00051\u0000\u0000\u00c8\u00c9"+
		"\u0003 \u0010\u0000\u00c9\u00ca\u00051\u0000\u0000\u00ca\u00cb\u00054"+
		"\u0000\u0000\u00cb\u00cc\u0005/\u0000\u0000\u00cc\u00cd\u00050\u0000\u0000"+
		"\u00cd\u00cf\u0001\u0000\u0000\u0000\u00ce\u00a0\u0001\u0000\u0000\u0000"+
		"\u00ce\u00ab\u0001\u0000\u0000\u0000\u00ce\u00b8\u0001\u0000\u0000\u0000"+
		"\u00ce\u00c3\u0001\u0000\u0000\u0000\u00cf\u001f\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d4\u0003\"\u0011\u0000\u00d1\u00d4\u00054\u0000\u0000\u00d2"+
		"\u00d4\u00052\u0000\u0000\u00d3\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4!\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0006\u0011\uffff\uffff\u0000\u00d6\u00e8"+
		"\u00052\u0000\u0000\u00d7\u00e8\u00054\u0000\u0000\u00d8\u00e8\u0005*"+
		"\u0000\u0000\u00d9\u00da\u0005\u0015\u0000\u0000\u00da\u00e8\u00052\u0000"+
		"\u0000\u00db\u00dc\u0005\u0015\u0000\u0000\u00dc\u00e8\u00054\u0000\u0000"+
		"\u00dd\u00de\u00052\u0000\u0000\u00de\u00df\u0005\u0016\u0000\u0000\u00df"+
		"\u00e8\u0005*\u0000\u0000\u00e0\u00e1\u00054\u0000\u0000\u00e1\u00e2\u0005"+
		"\u0016\u0000\u0000\u00e2\u00e8\u0005*\u0000\u0000\u00e3\u00e4\u0005.\u0000"+
		"\u0000\u00e4\u00e5\u0003\"\u0011\u0000\u00e5\u00e6\u0005/\u0000\u0000"+
		"\u00e6\u00e8\u0001\u0000\u0000\u0000\u00e7\u00d5\u0001\u0000\u0000\u0000"+
		"\u00e7\u00d7\u0001\u0000\u0000\u0000\u00e7\u00d8\u0001\u0000\u0000\u0000"+
		"\u00e7\u00d9\u0001\u0000\u0000\u0000\u00e7\u00db\u0001\u0000\u0000\u0000"+
		"\u00e7\u00dd\u0001\u0000\u0000\u0000\u00e7\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e3\u0001\u0000\u0000\u0000\u00e8\u00f7\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ea\n\u0007\u0000\u0000\u00ea\u00eb\u0005\u0016\u0000\u0000\u00eb"+
		"\u00f6\u0003\"\u0011\b\u00ec\u00ed\n\u0006\u0000\u0000\u00ed\u00ee\u0005"+
		"\u0017\u0000\u0000\u00ee\u00f6\u0003\"\u0011\u0007\u00ef\u00f0\n\u0005"+
		"\u0000\u0000\u00f0\u00f1\u0005\u0018\u0000\u0000\u00f1\u00f6\u0003\"\u0011"+
		"\u0006\u00f2\u00f3\n\u0004\u0000\u0000\u00f3\u00f4\u0005\u0015\u0000\u0000"+
		"\u00f4\u00f6\u0003\"\u0011\u0005\u00f5\u00e9\u0001\u0000\u0000\u0000\u00f5"+
		"\u00ec\u0001\u0000\u0000\u0000\u00f5\u00ef\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f2\u0001\u0000\u0000\u0000\u00f6\u00f9\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8"+
		"#\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00fa\u00fc"+
		"\u0003&\u0013\u0000\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fc\u00ff\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001"+
		"\u0000\u0000\u0000\u00fe%\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000"+
		"\u0000\u0000\u0100\u0106\u0003(\u0014\u0000\u0101\u0106\u0003*\u0015\u0000"+
		"\u0102\u0106\u0003,\u0016\u0000\u0103\u0106\u0005%\u0000\u0000\u0104\u0106"+
		"\u00030\u0018\u0000\u0105\u0100\u0001\u0000\u0000\u0000\u0105\u0101\u0001"+
		"\u0000\u0000\u0000\u0105\u0102\u0001\u0000\u0000\u0000\u0105\u0103\u0001"+
		"\u0000\u0000\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0106\'\u0001\u0000"+
		"\u0000\u0000\u0107\u0108\u0005\u0019\u0000\u0000\u0108\u0109\u0003.\u0017"+
		"\u0000\u0109\u010a\u0005\u001a\u0000\u0000\u010a)\u0001\u0000\u0000\u0000"+
		"\u010b\u010c\u0005\u001b\u0000\u0000\u010c\u010d\u0003.\u0017\u0000\u010d"+
		"\u010e\u0005\u001c\u0000\u0000\u010e+\u0001\u0000\u0000\u0000\u010f\u0110"+
		"\u0005\u001d\u0000\u0000\u0110\u0111\u0003.\u0017\u0000\u0111\u0112\u0005"+
		"\u001e\u0000\u0000\u0112-\u0001\u0000\u0000\u0000\u0113\u0116\u00030\u0018"+
		"\u0000\u0114\u0116\u0003,\u0016\u0000\u0115\u0113\u0001\u0000\u0000\u0000"+
		"\u0115\u0114\u0001\u0000\u0000\u0000\u0116\u0119\u0001\u0000\u0000\u0000"+
		"\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000"+
		"\u0118/\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u011a"+
		"\u011b\u00032\u0019\u0000\u011b1\u0001\u0000\u0000\u0000\u011c\u011d\u0005"+
		"4\u0000\u0000\u011d\u011e\u0005\u001f\u0000\u0000\u011e\u011f\u0005 \u0000"+
		"\u0000\u011f\u0120\u0005.\u0000\u0000\u0120\u0121\u0003:\u001d\u0000\u0121"+
		"\u0122\u0005/\u0000\u0000\u0122\u0123\u00050\u0000\u0000\u0123\u014d\u0001"+
		"\u0000\u0000\u0000\u0124\u0125\u00054\u0000\u0000\u0125\u0126\u0005\u001f"+
		"\u0000\u0000\u0126\u0127\u0005!\u0000\u0000\u0127\u014d\u00050\u0000\u0000"+
		"\u0128\u0129\u00054\u0000\u0000\u0129\u012a\u0005\u001f\u0000\u0000\u012a"+
		"\u012b\u0005\"\u0000\u0000\u012b\u012c\u0005.\u0000\u0000\u012c\u012d"+
		"\u0005-\u0000\u0000\u012d\u012e\u00051\u0000\u0000\u012e\u012f\u00034"+
		"\u001a\u0000\u012f\u0130\u00051\u0000\u0000\u0130\u0131\u00036\u001b\u0000"+
		"\u0131\u0132\u0005/\u0000\u0000\u0132\u0133\u00050\u0000\u0000\u0133\u014d"+
		"\u0001\u0000\u0000\u0000\u0134\u0135\u00054\u0000\u0000\u0135\u0136\u0005"+
		"\u001f\u0000\u0000\u0136\u0137\u0005#\u0000\u0000\u0137\u0138\u0005.\u0000"+
		"\u0000\u0138\u0139\u00054\u0000\u0000\u0139\u013a\u00051\u0000\u0000\u013a"+
		"\u013b\u00036\u001b\u0000\u013b\u013c\u0005/\u0000\u0000\u013c\u013d\u0005"+
		"0\u0000\u0000\u013d\u014d\u0001\u0000\u0000\u0000\u013e\u013f\u00054\u0000"+
		"\u0000\u013f\u0140\u0005\u001f\u0000\u0000\u0140\u0141\u0005$\u0000\u0000"+
		"\u0141\u0142\u0005.\u0000\u0000\u0142\u0143\u00054\u0000\u0000\u0143\u0144"+
		"\u00051\u0000\u0000\u0144\u0145\u00054\u0000\u0000\u0145\u0146\u00051"+
		"\u0000\u0000\u0146\u0147\u00038\u001c\u0000\u0147\u0148\u00051\u0000\u0000"+
		"\u0148\u0149\u00036\u001b\u0000\u0149\u014a\u0005/\u0000\u0000\u014a\u014b"+
		"\u00050\u0000\u0000\u014b\u014d\u0001\u0000\u0000\u0000\u014c\u011c\u0001"+
		"\u0000\u0000\u0000\u014c\u0124\u0001\u0000\u0000\u0000\u014c\u0128\u0001"+
		"\u0000\u0000\u0000\u014c\u0134\u0001\u0000\u0000\u0000\u014c\u013e\u0001"+
		"\u0000\u0000\u0000\u014d3\u0001\u0000\u0000\u0000\u014e\u014f\u0007\u0001"+
		"\u0000\u0000\u014f5\u0001\u0000\u0000\u0000\u0150\u0151\u00054\u0000\u0000"+
		"\u01517\u0001\u0000\u0000\u0000\u0152\u0153\u00052\u0000\u0000\u0153\u0154"+
		"\u0005\u0016\u0000\u0000\u0154\u015c\u0005*\u0000\u0000\u0155\u0156\u0005"+
		"\u0015\u0000\u0000\u0156\u0157\u00052\u0000\u0000\u0157\u0158\u0005\u0016"+
		"\u0000\u0000\u0158\u015c\u0005*\u0000\u0000\u0159\u015c\u00054\u0000\u0000"+
		"\u015a\u015c\u0003\"\u0011\u0000\u015b\u0152\u0001\u0000\u0000\u0000\u015b"+
		"\u0155\u0001\u0000\u0000\u0000\u015b\u0159\u0001\u0000\u0000\u0000\u015b"+
		"\u015a\u0001\u0000\u0000\u0000\u015c9\u0001\u0000\u0000\u0000\u015d\u015e"+
		"\u0007\u0002\u0000\u0000\u015e;\u0001\u0000\u0000\u0000\u0011?U^r~\u0086"+
		"\u00ce\u00d3\u00e7\u00f5\u00f7\u00fd\u0105\u0115\u0117\u014c\u015b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}