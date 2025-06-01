// Generated from DSL_FIGURE.g4 by ANTLR 4.13.0
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
public class DSL_FIGUREParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, PAUSE_STATEMENT=28, RED=29, GREEN=30, BLUE=31, 
		YELLOW=32, PI=33, PI_DIV_EXPR=34, DECIMAL_LIT=35, COORDINATE=36, LPAREN=37, 
		RPAREN=38, SEMICOLON=39, COMMA=40, NUMBER=41, VERSION=42, ID=43, WHITESPACE=44, 
		COMMENT=45;
	public static final int
		RULE_program = 0, RULE_dslVersion = 1, RULE_declarations = 2, RULE_declaration = 3, 
		RULE_droneTypeDeclaration = 4, RULE_positionDeclaration = 5, RULE_velocityDeclaration = 6, 
		RULE_velocityExpr = 7, RULE_distanceDeclaration = 8, RULE_figureDeclaration = 9, 
		RULE_figureParam = 10, RULE_expression = 11, RULE_statements = 12, RULE_statement = 13, 
		RULE_beforeBlock = 14, RULE_afterBlock = 15, RULE_groupBlock = 16, RULE_blockContent = 17, 
		RULE_singleAction = 18, RULE_figureAction = 19, RULE_distanceValue = 20, 
		RULE_velocityValue = 21, RULE_rotationValue = 22, RULE_colorValue = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dslVersion", "declarations", "declaration", "droneTypeDeclaration", 
			"positionDeclaration", "velocityDeclaration", "velocityExpr", "distanceDeclaration", 
			"figureDeclaration", "figureParam", "expression", "statements", "statement", 
			"beforeBlock", "afterBlock", "groupBlock", "blockContent", "singleAction", 
			"figureAction", "distanceValue", "velocityValue", "rotationValue", "colorValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'DSL'", "'version'", "'DroneType'", "'Position'", "'='", "'Velocity'", 
			"'Distance'", "'Line'", "'Rectangle'", "'Circle'", "'Circumference'", 
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
			null, null, null, null, "PAUSE_STATEMENT", "RED", "GREEN", "BLUE", "YELLOW", 
			"PI", "PI_DIV_EXPR", "DECIMAL_LIT", "COORDINATE", "LPAREN", "RPAREN", 
			"SEMICOLON", "COMMA", "NUMBER", "VERSION", "ID", "WHITESPACE", "COMMENT"
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
	public String getGrammarFileName() { return "DSL_FIGURE.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DSL_FIGUREParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public DslVersionContext dslVersion() {
			return getRuleContext(DslVersionContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DSL_FIGUREParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			dslVersion();
			setState(49);
			declarations();
			setState(50);
			statements();
			setState(51);
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
	public static class DslVersionContext extends ParserRuleContext {
		public TerminalNode VERSION() { return getToken(DSL_FIGUREParser.VERSION, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_FIGUREParser.SEMICOLON, 0); }
		public DslVersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dslVersion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterDslVersion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitDslVersion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitDslVersion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DslVersionContext dslVersion() throws RecognitionException {
		DslVersionContext _localctx = new DslVersionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dslVersion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__0);
			setState(54);
			match(T__1);
			setState(55);
			match(VERSION);
			setState(56);
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
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4056L) != 0)) {
				{
				{
				setState(58);
				declaration();
				}
				}
				setState(63);
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
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				droneTypeDeclaration();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				positionDeclaration();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				velocityDeclaration();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				distanceDeclaration();
				}
				break;
			case T__7:
			case T__8:
			case T__9:
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
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
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_FIGUREParser.SEMICOLON, 0); }
		public DroneTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_droneTypeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterDroneTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitDroneTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitDroneTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DroneTypeDeclarationContext droneTypeDeclaration() throws RecognitionException {
		DroneTypeDeclarationContext _localctx = new DroneTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_droneTypeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__2);
			setState(72);
			match(ID);
			setState(73);
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
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public TerminalNode COORDINATE() { return getToken(DSL_FIGUREParser.COORDINATE, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_FIGUREParser.SEMICOLON, 0); }
		public PositionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterPositionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitPositionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitPositionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PositionDeclarationContext positionDeclaration() throws RecognitionException {
		PositionDeclarationContext _localctx = new PositionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_positionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__3);
			setState(76);
			match(ID);
			setState(77);
			match(T__4);
			setState(78);
			match(COORDINATE);
			setState(79);
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
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public VelocityExprContext velocityExpr() {
			return getRuleContext(VelocityExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(DSL_FIGUREParser.SEMICOLON, 0); }
		public VelocityDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_velocityDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterVelocityDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitVelocityDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitVelocityDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VelocityDeclarationContext velocityDeclaration() throws RecognitionException {
		VelocityDeclarationContext _localctx = new VelocityDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_velocityDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__5);
			setState(82);
			match(ID);
			setState(83);
			match(T__4);
			setState(84);
			velocityExpr();
			setState(85);
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
		public TerminalNode NUMBER() { return getToken(DSL_FIGUREParser.NUMBER, 0); }
		public TerminalNode DECIMAL_LIT() { return getToken(DSL_FIGUREParser.DECIMAL_LIT, 0); }
		public TerminalNode PI_DIV_EXPR() { return getToken(DSL_FIGUREParser.PI_DIV_EXPR, 0); }
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public VelocityExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_velocityExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterVelocityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitVelocityExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitVelocityExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VelocityExprContext velocityExpr() throws RecognitionException {
		VelocityExprContext _localctx = new VelocityExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_velocityExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 11046655885312L) != 0)) ) {
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
		public List<TerminalNode> ID() { return getTokens(DSL_FIGUREParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DSL_FIGUREParser.ID, i);
		}
		public TerminalNode SEMICOLON() { return getToken(DSL_FIGUREParser.SEMICOLON, 0); }
		public TerminalNode NUMBER() { return getToken(DSL_FIGUREParser.NUMBER, 0); }
		public DistanceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_distanceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterDistanceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitDistanceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitDistanceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DistanceDeclarationContext distanceDeclaration() throws RecognitionException {
		DistanceDeclarationContext _localctx = new DistanceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_distanceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__6);
			setState(90);
			match(ID);
			setState(91);
			match(T__4);
			setState(92);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(93);
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
		public List<TerminalNode> ID() { return getTokens(DSL_FIGUREParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DSL_FIGUREParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(DSL_FIGUREParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DSL_FIGUREParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DSL_FIGUREParser.COMMA, i);
		}
		public List<FigureParamContext> figureParam() {
			return getRuleContexts(FigureParamContext.class);
		}
		public FigureParamContext figureParam(int i) {
			return getRuleContext(FigureParamContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(DSL_FIGUREParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_FIGUREParser.SEMICOLON, 0); }
		public FigureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figureDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterFigureDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitFigureDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitFigureDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureDeclarationContext figureDeclaration() throws RecognitionException {
		FigureDeclarationContext _localctx = new FigureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_figureDeclaration);
		try {
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				match(T__7);
				setState(96);
				match(ID);
				setState(97);
				match(LPAREN);
				setState(98);
				match(ID);
				setState(99);
				match(COMMA);
				setState(100);
				figureParam();
				setState(101);
				match(COMMA);
				setState(102);
				match(ID);
				setState(103);
				match(RPAREN);
				setState(104);
				match(SEMICOLON);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(T__8);
				setState(107);
				match(ID);
				setState(108);
				match(LPAREN);
				setState(109);
				match(ID);
				setState(110);
				match(COMMA);
				setState(111);
				figureParam();
				setState(112);
				match(COMMA);
				setState(113);
				figureParam();
				setState(114);
				match(COMMA);
				setState(115);
				match(ID);
				setState(116);
				match(RPAREN);
				setState(117);
				match(SEMICOLON);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				match(T__9);
				setState(120);
				match(ID);
				setState(121);
				match(LPAREN);
				setState(122);
				match(ID);
				setState(123);
				match(COMMA);
				setState(124);
				figureParam();
				setState(125);
				match(COMMA);
				setState(126);
				match(ID);
				setState(127);
				match(RPAREN);
				setState(128);
				match(SEMICOLON);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(T__10);
				setState(131);
				match(ID);
				setState(132);
				match(LPAREN);
				setState(133);
				match(ID);
				setState(134);
				match(COMMA);
				setState(135);
				figureParam();
				setState(136);
				match(COMMA);
				setState(137);
				match(ID);
				setState(138);
				match(RPAREN);
				setState(139);
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
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(DSL_FIGUREParser.NUMBER, 0); }
		public FigureParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figureParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterFigureParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitFigureParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitFigureParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureParamContext figureParam() throws RecognitionException {
		FigureParamContext _localctx = new FigureParamContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_figureParam);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
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
		public TerminalNode NUMBER() { return getToken(DSL_FIGUREParser.NUMBER, 0); }
		public TerminalNode PI() { return getToken(DSL_FIGUREParser.PI, 0); }
		public NumberPiExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterNumberPiExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitNumberPiExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitNumberPiExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PiExprContext extends ExpressionContext {
		public TerminalNode PI() { return getToken(DSL_FIGUREParser.PI, 0); }
		public PiExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterPiExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitPiExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitPiExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public IdExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitIdExpr(this);
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
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterMultiplyExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitMultiplyExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitMultiplyExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberExprContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(DSL_FIGUREParser.NUMBER, 0); }
		public NumberExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterNumberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitNumberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitNumberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegativeIdExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public NegativeIdExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterNegativeIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitNegativeIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitNegativeIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdPiExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public TerminalNode PI() { return getToken(DSL_FIGUREParser.PI, 0); }
		public IdPiExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterIdPiExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitIdPiExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitIdPiExpr(this);
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
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitAddExpr(this);
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
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterSubtractExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitSubtractExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitSubtractExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegativeNumberExprContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(DSL_FIGUREParser.NUMBER, 0); }
		public NegativeNumberExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterNegativeNumberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitNegativeNumberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitNegativeNumberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(DSL_FIGUREParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DSL_FIGUREParser.RPAREN, 0); }
		public ParenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitParenExpr(this);
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
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterDivideExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitDivideExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitDivideExpr(this);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new NumberExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(149);
				match(NUMBER);
				}
				break;
			case 2:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(ID);
				}
				break;
			case 3:
				{
				_localctx = new PiExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				match(PI);
				}
				break;
			case 4:
				{
				_localctx = new NegativeNumberExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				match(T__11);
				setState(153);
				match(NUMBER);
				}
				break;
			case 5:
				{
				_localctx = new NegativeIdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(T__11);
				setState(155);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new NumberPiExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				match(NUMBER);
				setState(157);
				match(T__12);
				setState(158);
				match(PI);
				}
				break;
			case 7:
				{
				_localctx = new IdPiExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(ID);
				setState(160);
				match(T__12);
				setState(161);
				match(PI);
				}
				break;
			case 8:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(LPAREN);
				setState(163);
				expression(0);
				setState(164);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(180);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplyExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(168);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(169);
						match(T__12);
						setState(170);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new DivideExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(171);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(172);
						match(T__13);
						setState(173);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new AddExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(174);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(175);
						match(T__14);
						setState(176);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new SubtractExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(177);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(178);
						match(T__11);
						setState(179);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8796362833920L) != 0)) {
				{
				{
				setState(185);
				statement();
				}
				}
				setState(190);
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
		public TerminalNode PAUSE_STATEMENT() { return getToken(DSL_FIGUREParser.PAUSE_STATEMENT, 0); }
		public SingleActionContext singleAction() {
			return getRuleContext(SingleActionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				beforeBlock();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				afterBlock();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				groupBlock();
				}
				break;
			case PAUSE_STATEMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(194);
				match(PAUSE_STATEMENT);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(195);
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
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterBeforeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitBeforeBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitBeforeBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeforeBlockContext beforeBlock() throws RecognitionException {
		BeforeBlockContext _localctx = new BeforeBlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_beforeBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__15);
			setState(199);
			blockContent();
			setState(200);
			match(T__16);
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
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterAfterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitAfterBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitAfterBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AfterBlockContext afterBlock() throws RecognitionException {
		AfterBlockContext _localctx = new AfterBlockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_afterBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(T__17);
			setState(203);
			blockContent();
			setState(204);
			match(T__18);
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
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterGroupBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitGroupBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitGroupBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupBlockContext groupBlock() throws RecognitionException {
		GroupBlockContext _localctx = new GroupBlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_groupBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__19);
			setState(207);
			blockContent();
			setState(208);
			match(T__20);
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
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterBlockContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitBlockContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitBlockContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContentContext blockContent() throws RecognitionException {
		BlockContentContext _localctx = new BlockContentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_blockContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19 || _la==ID) {
				{
				setState(212);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(210);
					singleAction();
					}
					break;
				case T__19:
					{
					setState(211);
					groupBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(216);
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
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterSingleAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitSingleAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitSingleAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleActionContext singleAction() throws RecognitionException {
		SingleActionContext _localctx = new SingleActionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_singleAction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
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
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(DSL_FIGUREParser.LPAREN, 0); }
		public TerminalNode COORDINATE() { return getToken(DSL_FIGUREParser.COORDINATE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DSL_FIGUREParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DSL_FIGUREParser.COMMA, i);
		}
		public DistanceValueContext distanceValue() {
			return getRuleContext(DistanceValueContext.class,0);
		}
		public VelocityValueContext velocityValue() {
			return getRuleContext(VelocityValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DSL_FIGUREParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_FIGUREParser.SEMICOLON, 0); }
		public MoveActionContext(FigureActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterMoveAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitMoveAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitMoveAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MovePosActionContext extends FigureActionContext {
		public List<TerminalNode> ID() { return getTokens(DSL_FIGUREParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DSL_FIGUREParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(DSL_FIGUREParser.LPAREN, 0); }
		public TerminalNode COMMA() { return getToken(DSL_FIGUREParser.COMMA, 0); }
		public VelocityValueContext velocityValue() {
			return getRuleContext(VelocityValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DSL_FIGUREParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_FIGUREParser.SEMICOLON, 0); }
		public MovePosActionContext(FigureActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterMovePosAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitMovePosAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitMovePosAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RotateActionContext extends FigureActionContext {
		public List<TerminalNode> ID() { return getTokens(DSL_FIGUREParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DSL_FIGUREParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(DSL_FIGUREParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DSL_FIGUREParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DSL_FIGUREParser.COMMA, i);
		}
		public RotationValueContext rotationValue() {
			return getRuleContext(RotationValueContext.class,0);
		}
		public VelocityValueContext velocityValue() {
			return getRuleContext(VelocityValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DSL_FIGUREParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_FIGUREParser.SEMICOLON, 0); }
		public RotateActionContext(FigureActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterRotateAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitRotateAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitRotateAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LightsOnActionContext extends FigureActionContext {
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(DSL_FIGUREParser.LPAREN, 0); }
		public ColorValueContext colorValue() {
			return getRuleContext(ColorValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DSL_FIGUREParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_FIGUREParser.SEMICOLON, 0); }
		public LightsOnActionContext(FigureActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterLightsOnAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitLightsOnAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitLightsOnAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LightsOffActionContext extends FigureActionContext {
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(DSL_FIGUREParser.SEMICOLON, 0); }
		public LightsOffActionContext(FigureActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterLightsOffAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitLightsOffAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitLightsOffAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureActionContext figureAction() throws RecognitionException {
		FigureActionContext _localctx = new FigureActionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_figureAction);
		try {
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new LightsOnActionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(ID);
				setState(220);
				match(T__21);
				setState(221);
				match(T__22);
				setState(222);
				match(LPAREN);
				setState(223);
				colorValue();
				setState(224);
				match(RPAREN);
				setState(225);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new LightsOffActionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				match(ID);
				setState(228);
				match(T__21);
				setState(229);
				match(T__23);
				setState(230);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new MoveActionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(231);
				match(ID);
				setState(232);
				match(T__21);
				setState(233);
				match(T__24);
				setState(234);
				match(LPAREN);
				setState(235);
				match(COORDINATE);
				setState(236);
				match(COMMA);
				setState(237);
				distanceValue();
				setState(238);
				match(COMMA);
				setState(239);
				velocityValue();
				setState(240);
				match(RPAREN);
				setState(241);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new MovePosActionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(243);
				match(ID);
				setState(244);
				match(T__21);
				setState(245);
				match(T__25);
				setState(246);
				match(LPAREN);
				setState(247);
				match(ID);
				setState(248);
				match(COMMA);
				setState(249);
				velocityValue();
				setState(250);
				match(RPAREN);
				setState(251);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new RotateActionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(253);
				match(ID);
				setState(254);
				match(T__21);
				setState(255);
				match(T__26);
				setState(256);
				match(LPAREN);
				setState(257);
				match(ID);
				setState(258);
				match(COMMA);
				setState(259);
				match(ID);
				setState(260);
				match(COMMA);
				setState(261);
				rotationValue();
				setState(262);
				match(COMMA);
				setState(263);
				velocityValue();
				setState(264);
				match(RPAREN);
				setState(265);
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
		public TerminalNode NUMBER() { return getToken(DSL_FIGUREParser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public DistanceValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_distanceValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterDistanceValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitDistanceValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitDistanceValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DistanceValueContext distanceValue() throws RecognitionException {
		DistanceValueContext _localctx = new DistanceValueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_distanceValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
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
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public VelocityValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_velocityValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterVelocityValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitVelocityValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitVelocityValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VelocityValueContext velocityValue() throws RecognitionException {
		VelocityValueContext _localctx = new VelocityValueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_velocityValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
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
		public TerminalNode NUMBER() { return getToken(DSL_FIGUREParser.NUMBER, 0); }
		public TerminalNode PI() { return getToken(DSL_FIGUREParser.PI, 0); }
		public TerminalNode ID() { return getToken(DSL_FIGUREParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RotationValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotationValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterRotationValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitRotationValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitRotationValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RotationValueContext rotationValue() throws RecognitionException {
		RotationValueContext _localctx = new RotationValueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_rotationValue);
		try {
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				match(NUMBER);
				setState(274);
				match(T__12);
				setState(275);
				match(PI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				match(T__11);
				setState(277);
				match(NUMBER);
				setState(278);
				match(T__12);
				setState(279);
				match(PI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
				match(ID);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(281);
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
		public TerminalNode RED() { return getToken(DSL_FIGUREParser.RED, 0); }
		public TerminalNode GREEN() { return getToken(DSL_FIGUREParser.GREEN, 0); }
		public TerminalNode BLUE() { return getToken(DSL_FIGUREParser.BLUE, 0); }
		public TerminalNode YELLOW() { return getToken(DSL_FIGUREParser.YELLOW, 0); }
		public ColorValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colorValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).enterColorValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSL_FIGUREListener ) ((DSL_FIGUREListener)listener).exitColorValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSL_FIGUREVisitor ) return ((DSL_FIGUREVisitor<? extends T>)visitor).visitColorValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorValueContext colorValue() throws RecognitionException {
		ColorValueContext _localctx = new ColorValueContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_colorValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8053063680L) != 0)) ) {
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
		case 11:
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
		"\u0004\u0001-\u011f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u0002<\b\u0002\n\u0002\f\u0002"+
		"?\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003F\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u008e\b\t\u0001\n\u0001\n\u0001\n\u0003\n\u0093\b\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00a7\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u00b5\b\u000b\n\u000b\f\u000b\u00b8"+
		"\t\u000b\u0001\f\u0005\f\u00bb\b\f\n\f\f\f\u00be\t\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u00c5\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u00d5\b\u0011\n\u0011\f\u0011\u00d8\t\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u010c\b\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u011b\b\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0000\u0001\u0016\u0018\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.\u0000"+
		"\u0003\u0003\u0000\"#))++\u0002\u0000))++\u0001\u0000\u001d \u0129\u0000"+
		"0\u0001\u0000\u0000\u0000\u00025\u0001\u0000\u0000\u0000\u0004=\u0001"+
		"\u0000\u0000\u0000\u0006E\u0001\u0000\u0000\u0000\bG\u0001\u0000\u0000"+
		"\u0000\nK\u0001\u0000\u0000\u0000\fQ\u0001\u0000\u0000\u0000\u000eW\u0001"+
		"\u0000\u0000\u0000\u0010Y\u0001\u0000\u0000\u0000\u0012\u008d\u0001\u0000"+
		"\u0000\u0000\u0014\u0092\u0001\u0000\u0000\u0000\u0016\u00a6\u0001\u0000"+
		"\u0000\u0000\u0018\u00bc\u0001\u0000\u0000\u0000\u001a\u00c4\u0001\u0000"+
		"\u0000\u0000\u001c\u00c6\u0001\u0000\u0000\u0000\u001e\u00ca\u0001\u0000"+
		"\u0000\u0000 \u00ce\u0001\u0000\u0000\u0000\"\u00d6\u0001\u0000\u0000"+
		"\u0000$\u00d9\u0001\u0000\u0000\u0000&\u010b\u0001\u0000\u0000\u0000("+
		"\u010d\u0001\u0000\u0000\u0000*\u010f\u0001\u0000\u0000\u0000,\u011a\u0001"+
		"\u0000\u0000\u0000.\u011c\u0001\u0000\u0000\u000001\u0003\u0002\u0001"+
		"\u000012\u0003\u0004\u0002\u000023\u0003\u0018\f\u000034\u0005\u0000\u0000"+
		"\u00014\u0001\u0001\u0000\u0000\u000056\u0005\u0001\u0000\u000067\u0005"+
		"\u0002\u0000\u000078\u0005*\u0000\u000089\u0005\'\u0000\u00009\u0003\u0001"+
		"\u0000\u0000\u0000:<\u0003\u0006\u0003\u0000;:\u0001\u0000\u0000\u0000"+
		"<?\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000"+
		"\u0000>\u0005\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@F\u0003"+
		"\b\u0004\u0000AF\u0003\n\u0005\u0000BF\u0003\f\u0006\u0000CF\u0003\u0010"+
		"\b\u0000DF\u0003\u0012\t\u0000E@\u0001\u0000\u0000\u0000EA\u0001\u0000"+
		"\u0000\u0000EB\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000ED\u0001"+
		"\u0000\u0000\u0000F\u0007\u0001\u0000\u0000\u0000GH\u0005\u0003\u0000"+
		"\u0000HI\u0005+\u0000\u0000IJ\u0005\'\u0000\u0000J\t\u0001\u0000\u0000"+
		"\u0000KL\u0005\u0004\u0000\u0000LM\u0005+\u0000\u0000MN\u0005\u0005\u0000"+
		"\u0000NO\u0005$\u0000\u0000OP\u0005\'\u0000\u0000P\u000b\u0001\u0000\u0000"+
		"\u0000QR\u0005\u0006\u0000\u0000RS\u0005+\u0000\u0000ST\u0005\u0005\u0000"+
		"\u0000TU\u0003\u000e\u0007\u0000UV\u0005\'\u0000\u0000V\r\u0001\u0000"+
		"\u0000\u0000WX\u0007\u0000\u0000\u0000X\u000f\u0001\u0000\u0000\u0000"+
		"YZ\u0005\u0007\u0000\u0000Z[\u0005+\u0000\u0000[\\\u0005\u0005\u0000\u0000"+
		"\\]\u0007\u0001\u0000\u0000]^\u0005\'\u0000\u0000^\u0011\u0001\u0000\u0000"+
		"\u0000_`\u0005\b\u0000\u0000`a\u0005+\u0000\u0000ab\u0005%\u0000\u0000"+
		"bc\u0005+\u0000\u0000cd\u0005(\u0000\u0000de\u0003\u0014\n\u0000ef\u0005"+
		"(\u0000\u0000fg\u0005+\u0000\u0000gh\u0005&\u0000\u0000hi\u0005\'\u0000"+
		"\u0000i\u008e\u0001\u0000\u0000\u0000jk\u0005\t\u0000\u0000kl\u0005+\u0000"+
		"\u0000lm\u0005%\u0000\u0000mn\u0005+\u0000\u0000no\u0005(\u0000\u0000"+
		"op\u0003\u0014\n\u0000pq\u0005(\u0000\u0000qr\u0003\u0014\n\u0000rs\u0005"+
		"(\u0000\u0000st\u0005+\u0000\u0000tu\u0005&\u0000\u0000uv\u0005\'\u0000"+
		"\u0000v\u008e\u0001\u0000\u0000\u0000wx\u0005\n\u0000\u0000xy\u0005+\u0000"+
		"\u0000yz\u0005%\u0000\u0000z{\u0005+\u0000\u0000{|\u0005(\u0000\u0000"+
		"|}\u0003\u0014\n\u0000}~\u0005(\u0000\u0000~\u007f\u0005+\u0000\u0000"+
		"\u007f\u0080\u0005&\u0000\u0000\u0080\u0081\u0005\'\u0000\u0000\u0081"+
		"\u008e\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u000b\u0000\u0000\u0083"+
		"\u0084\u0005+\u0000\u0000\u0084\u0085\u0005%\u0000\u0000\u0085\u0086\u0005"+
		"+\u0000\u0000\u0086\u0087\u0005(\u0000\u0000\u0087\u0088\u0003\u0014\n"+
		"\u0000\u0088\u0089\u0005(\u0000\u0000\u0089\u008a\u0005+\u0000\u0000\u008a"+
		"\u008b\u0005&\u0000\u0000\u008b\u008c\u0005\'\u0000\u0000\u008c\u008e"+
		"\u0001\u0000\u0000\u0000\u008d_\u0001\u0000\u0000\u0000\u008dj\u0001\u0000"+
		"\u0000\u0000\u008dw\u0001\u0000\u0000\u0000\u008d\u0082\u0001\u0000\u0000"+
		"\u0000\u008e\u0013\u0001\u0000\u0000\u0000\u008f\u0093\u0003\u0016\u000b"+
		"\u0000\u0090\u0093\u0005+\u0000\u0000\u0091\u0093\u0005)\u0000\u0000\u0092"+
		"\u008f\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092"+
		"\u0091\u0001\u0000\u0000\u0000\u0093\u0015\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0006\u000b\uffff\uffff\u0000\u0095\u00a7\u0005)\u0000\u0000\u0096"+
		"\u00a7\u0005+\u0000\u0000\u0097\u00a7\u0005!\u0000\u0000\u0098\u0099\u0005"+
		"\f\u0000\u0000\u0099\u00a7\u0005)\u0000\u0000\u009a\u009b\u0005\f\u0000"+
		"\u0000\u009b\u00a7\u0005+\u0000\u0000\u009c\u009d\u0005)\u0000\u0000\u009d"+
		"\u009e\u0005\r\u0000\u0000\u009e\u00a7\u0005!\u0000\u0000\u009f\u00a0"+
		"\u0005+\u0000\u0000\u00a0\u00a1\u0005\r\u0000\u0000\u00a1\u00a7\u0005"+
		"!\u0000\u0000\u00a2\u00a3\u0005%\u0000\u0000\u00a3\u00a4\u0003\u0016\u000b"+
		"\u0000\u00a4\u00a5\u0005&\u0000\u0000\u00a5\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a6\u0094\u0001\u0000\u0000\u0000\u00a6\u0096\u0001\u0000\u0000\u0000"+
		"\u00a6\u0097\u0001\u0000\u0000\u0000\u00a6\u0098\u0001\u0000\u0000\u0000"+
		"\u00a6\u009a\u0001\u0000\u0000\u0000\u00a6\u009c\u0001\u0000\u0000\u0000"+
		"\u00a6\u009f\u0001\u0000\u0000\u0000\u00a6\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a7\u00b6\u0001\u0000\u0000\u0000\u00a8\u00a9\n\u0007\u0000\u0000\u00a9"+
		"\u00aa\u0005\r\u0000\u0000\u00aa\u00b5\u0003\u0016\u000b\b\u00ab\u00ac"+
		"\n\u0006\u0000\u0000\u00ac\u00ad\u0005\u000e\u0000\u0000\u00ad\u00b5\u0003"+
		"\u0016\u000b\u0007\u00ae\u00af\n\u0005\u0000\u0000\u00af\u00b0\u0005\u000f"+
		"\u0000\u0000\u00b0\u00b5\u0003\u0016\u000b\u0006\u00b1\u00b2\n\u0004\u0000"+
		"\u0000\u00b2\u00b3\u0005\f\u0000\u0000\u00b3\u00b5\u0003\u0016\u000b\u0005"+
		"\u00b4\u00a8\u0001\u0000\u0000\u0000\u00b4\u00ab\u0001\u0000\u0000\u0000"+
		"\u00b4\u00ae\u0001\u0000\u0000\u0000\u00b4\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u0017\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bb\u0003\u001a\r\u0000\u00ba"+
		"\u00b9\u0001\u0000\u0000\u0000\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc"+
		"\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd"+
		"\u0019\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c5\u0003\u001c\u000e\u0000\u00c0\u00c5\u0003\u001e\u000f\u0000\u00c1"+
		"\u00c5\u0003 \u0010\u0000\u00c2\u00c5\u0005\u001c\u0000\u0000\u00c3\u00c5"+
		"\u0003$\u0012\u0000\u00c4\u00bf\u0001\u0000\u0000\u0000\u00c4\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u001b\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u0005\u0010\u0000\u0000\u00c7\u00c8\u0003"+
		"\"\u0011\u0000\u00c8\u00c9\u0005\u0011\u0000\u0000\u00c9\u001d\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cb\u0005\u0012\u0000\u0000\u00cb\u00cc\u0003\"\u0011"+
		"\u0000\u00cc\u00cd\u0005\u0013\u0000\u0000\u00cd\u001f\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0005\u0014\u0000\u0000\u00cf\u00d0\u0003\"\u0011\u0000"+
		"\u00d0\u00d1\u0005\u0015\u0000\u0000\u00d1!\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d5\u0003$\u0012\u0000\u00d3\u00d5\u0003 \u0010\u0000\u00d4\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d7#\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0003&\u0013\u0000\u00da%\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0005+\u0000\u0000\u00dc\u00dd\u0005\u0016\u0000\u0000\u00dd"+
		"\u00de\u0005\u0017\u0000\u0000\u00de\u00df\u0005%\u0000\u0000\u00df\u00e0"+
		"\u0003.\u0017\u0000\u00e0\u00e1\u0005&\u0000\u0000\u00e1\u00e2\u0005\'"+
		"\u0000\u0000\u00e2\u010c\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005+\u0000"+
		"\u0000\u00e4\u00e5\u0005\u0016\u0000\u0000\u00e5\u00e6\u0005\u0018\u0000"+
		"\u0000\u00e6\u010c\u0005\'\u0000\u0000\u00e7\u00e8\u0005+\u0000\u0000"+
		"\u00e8\u00e9\u0005\u0016\u0000\u0000\u00e9\u00ea\u0005\u0019\u0000\u0000"+
		"\u00ea\u00eb\u0005%\u0000\u0000\u00eb\u00ec\u0005$\u0000\u0000\u00ec\u00ed"+
		"\u0005(\u0000\u0000\u00ed\u00ee\u0003(\u0014\u0000\u00ee\u00ef\u0005("+
		"\u0000\u0000\u00ef\u00f0\u0003*\u0015\u0000\u00f0\u00f1\u0005&\u0000\u0000"+
		"\u00f1\u00f2\u0005\'\u0000\u0000\u00f2\u010c\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f4\u0005+\u0000\u0000\u00f4\u00f5\u0005\u0016\u0000\u0000\u00f5\u00f6"+
		"\u0005\u001a\u0000\u0000\u00f6\u00f7\u0005%\u0000\u0000\u00f7\u00f8\u0005"+
		"+\u0000\u0000\u00f8\u00f9\u0005(\u0000\u0000\u00f9\u00fa\u0003*\u0015"+
		"\u0000\u00fa\u00fb\u0005&\u0000\u0000\u00fb\u00fc\u0005\'\u0000\u0000"+
		"\u00fc\u010c\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005+\u0000\u0000\u00fe"+
		"\u00ff\u0005\u0016\u0000\u0000\u00ff\u0100\u0005\u001b\u0000\u0000\u0100"+
		"\u0101\u0005%\u0000\u0000\u0101\u0102\u0005+\u0000\u0000\u0102\u0103\u0005"+
		"(\u0000\u0000\u0103\u0104\u0005+\u0000\u0000\u0104\u0105\u0005(\u0000"+
		"\u0000\u0105\u0106\u0003,\u0016\u0000\u0106\u0107\u0005(\u0000\u0000\u0107"+
		"\u0108\u0003*\u0015\u0000\u0108\u0109\u0005&\u0000\u0000\u0109\u010a\u0005"+
		"\'\u0000\u0000\u010a\u010c\u0001\u0000\u0000\u0000\u010b\u00db\u0001\u0000"+
		"\u0000\u0000\u010b\u00e3\u0001\u0000\u0000\u0000\u010b\u00e7\u0001\u0000"+
		"\u0000\u0000\u010b\u00f3\u0001\u0000\u0000\u0000\u010b\u00fd\u0001\u0000"+
		"\u0000\u0000\u010c\'\u0001\u0000\u0000\u0000\u010d\u010e\u0007\u0001\u0000"+
		"\u0000\u010e)\u0001\u0000\u0000\u0000\u010f\u0110\u0005+\u0000\u0000\u0110"+
		"+\u0001\u0000\u0000\u0000\u0111\u0112\u0005)\u0000\u0000\u0112\u0113\u0005"+
		"\r\u0000\u0000\u0113\u011b\u0005!\u0000\u0000\u0114\u0115\u0005\f\u0000"+
		"\u0000\u0115\u0116\u0005)\u0000\u0000\u0116\u0117\u0005\r\u0000\u0000"+
		"\u0117\u011b\u0005!\u0000\u0000\u0118\u011b\u0005+\u0000\u0000\u0119\u011b"+
		"\u0003\u0016\u000b\u0000\u011a\u0111\u0001\u0000\u0000\u0000\u011a\u0114"+
		"\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011a\u0119"+
		"\u0001\u0000\u0000\u0000\u011b-\u0001\u0000\u0000\u0000\u011c\u011d\u0007"+
		"\u0002\u0000\u0000\u011d/\u0001\u0000\u0000\u0000\r=E\u008d\u0092\u00a6"+
		"\u00b4\u00b6\u00bc\u00c4\u00d4\u00d6\u010b\u011a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}