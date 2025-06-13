// Generated from DroneOne.g4 by ANTLR 4.13.0
package drone_plugin.generated_code;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class DroneOneParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, ID=31, FLOAT=32, 
		INT=33, NEWLINE=34, WS=35;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_figure = 2, RULE_capabilities = 3, 
		RULE_capability = 4, RULE_variableDeclaration = 5, RULE_command = 6, RULE_takeoff = 7, 
		RULE_land = 8, RULE_movePosition = 9, RULE_moveVector = 10, RULE_movePath = 11, 
		RULE_hoover = 12, RULE_lightsOn = 13, RULE_lightsOff = 14, RULE_blink = 15, 
		RULE_expression = 16, RULE_value = 17, RULE_position = 18, RULE_vector = 19, 
		RULE_positionArray = 20, RULE_type = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "figure", "capabilities", "capability", "variableDeclaration", 
			"command", "takeoff", "land", "movePosition", "moveVector", "movePath", 
			"hoover", "lightsOn", "lightsOff", "blink", "expression", "value", "position", 
			"vector", "positionArray", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'figure'", "'requires'", "'{'", "'}'", "';'", "','", "'TRANSLATION'", 
			"'ROTATION'", "'HOVER'", "'LED'", "'='", "'takeOff'", "'('", "')'", "'land'", 
			"'move'", "'movePath'", "'hoover'", "'lightsOn'", "'lightsOff'", "'blink'", 
			"'-'", "'+'", "'PI'", "'Position'", "'Vector'", "'LinearVelocity'", "'AngularVelocity'", 
			"'Distance'", "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "ID", "FLOAT", "INT", "NEWLINE", 
			"WS"
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
	public String getGrammarFileName() { return "DroneOne.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DroneOneParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(DroneOneParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(DroneOneParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(DroneOneParser.NEWLINE, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2113929218L) != 0)) {
				{
				{
				setState(44);
				statement();
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(45);
					match(NEWLINE);
					}
				}

				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
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
	public static class StatementContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public FigureContext figure() {
			return getRuleContext(FigureContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				variableDeclaration();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				figure();
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
	public static class FigureContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DroneOneParser.ID, 0); }
		public CapabilitiesContext capabilities() {
			return getRuleContext(CapabilitiesContext.class,0);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(DroneOneParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(DroneOneParser.NEWLINE, i);
		}
		public FigureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterFigure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitFigure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitFigure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureContext figure() throws RecognitionException {
		FigureContext _localctx = new FigureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_figure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__0);
			setState(60);
			match(ID);
			setState(61);
			match(T__1);
			setState(62);
			capabilities();
			setState(63);
			match(T__2);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4165632L) != 0)) {
				{
				{
				setState(64);
				command();
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(65);
					match(NEWLINE);
					}
				}

				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			match(T__3);
			setState(74);
			match(T__4);
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
	public static class CapabilitiesContext extends ParserRuleContext {
		public List<CapabilityContext> capability() {
			return getRuleContexts(CapabilityContext.class);
		}
		public CapabilityContext capability(int i) {
			return getRuleContext(CapabilityContext.class,i);
		}
		public CapabilitiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capabilities; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterCapabilities(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitCapabilities(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitCapabilities(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CapabilitiesContext capabilities() throws RecognitionException {
		CapabilitiesContext _localctx = new CapabilitiesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_capabilities);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			capability();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(77);
				match(T__5);
				setState(78);
				capability();
				}
				}
				setState(83);
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
	public static class CapabilityContext extends ParserRuleContext {
		public CapabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capability; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterCapability(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitCapability(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitCapability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CapabilityContext capability() throws RecognitionException {
		CapabilityContext _localctx = new CapabilityContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_capability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) ) {
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
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(DroneOneParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			type();
			setState(87);
			match(ID);
			setState(88);
			match(T__10);
			setState(89);
			expression();
			setState(90);
			match(T__4);
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
	public static class CommandContext extends ParserRuleContext {
		public TakeoffContext takeoff() {
			return getRuleContext(TakeoffContext.class,0);
		}
		public LandContext land() {
			return getRuleContext(LandContext.class,0);
		}
		public MovePositionContext movePosition() {
			return getRuleContext(MovePositionContext.class,0);
		}
		public MoveVectorContext moveVector() {
			return getRuleContext(MoveVectorContext.class,0);
		}
		public MovePathContext movePath() {
			return getRuleContext(MovePathContext.class,0);
		}
		public HooverContext hoover() {
			return getRuleContext(HooverContext.class,0);
		}
		public LightsOnContext lightsOn() {
			return getRuleContext(LightsOnContext.class,0);
		}
		public LightsOffContext lightsOff() {
			return getRuleContext(LightsOffContext.class,0);
		}
		public BlinkContext blink() {
			return getRuleContext(BlinkContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_command);
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				takeoff();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				land();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				movePosition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(95);
				moveVector();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(96);
				movePath();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(97);
				hoover();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(98);
				lightsOn();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(99);
				lightsOff();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(100);
				blink();
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
	public static class TakeoffContext extends ParserRuleContext {
		public List<TerminalNode> FLOAT() { return getTokens(DroneOneParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(DroneOneParser.FLOAT, i);
		}
		public TakeoffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_takeoff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterTakeoff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitTakeoff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitTakeoff(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TakeoffContext takeoff() throws RecognitionException {
		TakeoffContext _localctx = new TakeoffContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_takeoff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__11);
			setState(104);
			match(T__12);
			setState(105);
			match(FLOAT);
			setState(106);
			match(T__5);
			setState(107);
			match(FLOAT);
			setState(108);
			match(T__13);
			setState(109);
			match(T__4);
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
	public static class LandContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(DroneOneParser.FLOAT, 0); }
		public LandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_land; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterLand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitLand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitLand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LandContext land() throws RecognitionException {
		LandContext _localctx = new LandContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_land);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__14);
			setState(112);
			match(T__12);
			setState(113);
			match(FLOAT);
			setState(114);
			match(T__13);
			setState(115);
			match(T__4);
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
	public static class MovePositionContext extends ParserRuleContext {
		public PositionContext position() {
			return getRuleContext(PositionContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(DroneOneParser.FLOAT, 0); }
		public MovePositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_movePosition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterMovePosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitMovePosition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitMovePosition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MovePositionContext movePosition() throws RecognitionException {
		MovePositionContext _localctx = new MovePositionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_movePosition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__15);
			setState(118);
			match(T__12);
			setState(119);
			position();
			setState(120);
			match(T__5);
			setState(121);
			match(FLOAT);
			setState(122);
			match(T__13);
			setState(123);
			match(T__4);
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
	public static class MoveVectorContext extends ParserRuleContext {
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(DroneOneParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(DroneOneParser.INT, 0); }
		public MoveVectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moveVector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterMoveVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitMoveVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitMoveVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoveVectorContext moveVector() throws RecognitionException {
		MoveVectorContext _localctx = new MoveVectorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_moveVector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__15);
			setState(126);
			match(T__12);
			setState(127);
			vector();
			setState(128);
			match(T__5);
			setState(129);
			match(FLOAT);
			setState(130);
			match(T__5);
			setState(131);
			match(INT);
			setState(132);
			match(T__13);
			setState(133);
			match(T__4);
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
	public static class MovePathContext extends ParserRuleContext {
		public PositionArrayContext positionArray() {
			return getRuleContext(PositionArrayContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(DroneOneParser.FLOAT, 0); }
		public MovePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_movePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterMovePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitMovePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitMovePath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MovePathContext movePath() throws RecognitionException {
		MovePathContext _localctx = new MovePathContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_movePath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__16);
			setState(136);
			match(T__12);
			setState(137);
			positionArray();
			setState(138);
			match(T__5);
			setState(139);
			match(FLOAT);
			setState(140);
			match(T__13);
			setState(141);
			match(T__4);
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
	public static class HooverContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(DroneOneParser.INT, 0); }
		public HooverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hoover; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterHoover(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitHoover(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitHoover(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HooverContext hoover() throws RecognitionException {
		HooverContext _localctx = new HooverContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_hoover);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__17);
			setState(144);
			match(T__12);
			setState(145);
			match(INT);
			setState(146);
			match(T__13);
			setState(147);
			match(T__4);
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
	public static class LightsOnContext extends ParserRuleContext {
		public LightsOnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lightsOn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterLightsOn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitLightsOn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitLightsOn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LightsOnContext lightsOn() throws RecognitionException {
		LightsOnContext _localctx = new LightsOnContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lightsOn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__18);
			setState(150);
			match(T__12);
			setState(151);
			match(T__13);
			setState(152);
			match(T__4);
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
	public static class LightsOffContext extends ParserRuleContext {
		public LightsOffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lightsOff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterLightsOff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitLightsOff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitLightsOff(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LightsOffContext lightsOff() throws RecognitionException {
		LightsOffContext _localctx = new LightsOffContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_lightsOff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__19);
			setState(155);
			match(T__12);
			setState(156);
			match(T__13);
			setState(157);
			match(T__4);
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
	public static class BlinkContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(DroneOneParser.INT, 0); }
		public BlinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blink; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterBlink(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitBlink(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitBlink(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlinkContext blink() throws RecognitionException {
		BlinkContext _localctx = new BlinkContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_blink);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__20);
			setState(160);
			match(T__12);
			setState(161);
			match(INT);
			setState(162);
			match(T__13);
			setState(163);
			match(T__4);
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
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			value();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21 || _la==T__22) {
				{
				{
				setState(166);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(167);
				value();
				}
				}
				setState(172);
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
	public static class ValueContext extends ParserRuleContext {
		public PositionContext position() {
			return getRuleContext(PositionContext.class,0);
		}
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(DroneOneParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(DroneOneParser.INT, 0); }
		public TerminalNode ID() { return getToken(DroneOneParser.ID, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_value);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				position();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				vector();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(175);
				match(FLOAT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(176);
				match(INT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(177);
				match(ID);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(178);
				match(T__23);
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
	public static class PositionContext extends ParserRuleContext {
		public List<TerminalNode> FLOAT() { return getTokens(DroneOneParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(DroneOneParser.FLOAT, i);
		}
		public PositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_position; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitPosition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitPosition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PositionContext position() throws RecognitionException {
		PositionContext _localctx = new PositionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_position);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(T__12);
			setState(182);
			match(FLOAT);
			setState(183);
			match(T__5);
			setState(184);
			match(FLOAT);
			setState(185);
			match(T__5);
			setState(186);
			match(FLOAT);
			setState(187);
			match(T__13);
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
	public static class VectorContext extends ParserRuleContext {
		public List<TerminalNode> FLOAT() { return getTokens(DroneOneParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(DroneOneParser.FLOAT, i);
		}
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_vector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__12);
			setState(190);
			match(FLOAT);
			setState(191);
			match(T__5);
			setState(192);
			match(FLOAT);
			setState(193);
			match(T__5);
			setState(194);
			match(FLOAT);
			setState(195);
			match(T__13);
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
	public static class PositionArrayContext extends ParserRuleContext {
		public List<PositionContext> position() {
			return getRuleContexts(PositionContext.class);
		}
		public PositionContext position(int i) {
			return getRuleContext(PositionContext.class,i);
		}
		public PositionArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positionArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterPositionArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitPositionArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitPositionArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PositionArrayContext positionArray() throws RecognitionException {
		PositionArrayContext _localctx = new PositionArrayContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_positionArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__12);
			setState(198);
			position();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(199);
				match(T__5);
				setState(200);
				position();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
			match(T__13);
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
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneOneListener ) ((DroneOneListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneOneVisitor ) return ((DroneOneVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2113929216L) != 0)) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001#\u00d3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0001\u0000\u0003\u0000/\b\u0000\u0005\u00001\b\u0000\n\u0000"+
		"\f\u00004\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003"+
		"\u0001:\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002C\b\u0002\u0005\u0002E\b\u0002"+
		"\n\u0002\f\u0002H\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003P\b\u0003\n\u0003\f\u0003S\t\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"f\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u00a9\b\u0010\n\u0010\f\u0010\u00ac\t\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00b4"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00ca\b\u0014\n\u0014\f\u0014"+
		"\u00cd\t\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0000\u0000\u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*\u0000\u0003\u0001\u0000\u0007\n"+
		"\u0001\u0000\u0016\u0017\u0001\u0000\u0019\u001e\u00d1\u00002\u0001\u0000"+
		"\u0000\u0000\u00029\u0001\u0000\u0000\u0000\u0004;\u0001\u0000\u0000\u0000"+
		"\u0006L\u0001\u0000\u0000\u0000\bT\u0001\u0000\u0000\u0000\nV\u0001\u0000"+
		"\u0000\u0000\fe\u0001\u0000\u0000\u0000\u000eg\u0001\u0000\u0000\u0000"+
		"\u0010o\u0001\u0000\u0000\u0000\u0012u\u0001\u0000\u0000\u0000\u0014}"+
		"\u0001\u0000\u0000\u0000\u0016\u0087\u0001\u0000\u0000\u0000\u0018\u008f"+
		"\u0001\u0000\u0000\u0000\u001a\u0095\u0001\u0000\u0000\u0000\u001c\u009a"+
		"\u0001\u0000\u0000\u0000\u001e\u009f\u0001\u0000\u0000\u0000 \u00a5\u0001"+
		"\u0000\u0000\u0000\"\u00b3\u0001\u0000\u0000\u0000$\u00b5\u0001\u0000"+
		"\u0000\u0000&\u00bd\u0001\u0000\u0000\u0000(\u00c5\u0001\u0000\u0000\u0000"+
		"*\u00d0\u0001\u0000\u0000\u0000,.\u0003\u0002\u0001\u0000-/\u0005\"\u0000"+
		"\u0000.-\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/1\u0001\u0000"+
		"\u0000\u00000,\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001"+
		"\u0000\u0000\u000023\u0001\u0000\u0000\u000035\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000056\u0005\u0000\u0000\u00016\u0001\u0001\u0000"+
		"\u0000\u00007:\u0003\n\u0005\u00008:\u0003\u0004\u0002\u000097\u0001\u0000"+
		"\u0000\u000098\u0001\u0000\u0000\u0000:\u0003\u0001\u0000\u0000\u0000"+
		";<\u0005\u0001\u0000\u0000<=\u0005\u001f\u0000\u0000=>\u0005\u0002\u0000"+
		"\u0000>?\u0003\u0006\u0003\u0000?F\u0005\u0003\u0000\u0000@B\u0003\f\u0006"+
		"\u0000AC\u0005\"\u0000\u0000BA\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000"+
		"\u0000CE\u0001\u0000\u0000\u0000D@\u0001\u0000\u0000\u0000EH\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GI\u0001"+
		"\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0005\u0004\u0000\u0000"+
		"JK\u0005\u0005\u0000\u0000K\u0005\u0001\u0000\u0000\u0000LQ\u0003\b\u0004"+
		"\u0000MN\u0005\u0006\u0000\u0000NP\u0003\b\u0004\u0000OM\u0001\u0000\u0000"+
		"\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000"+
		"\u0000\u0000R\u0007\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000"+
		"TU\u0007\u0000\u0000\u0000U\t\u0001\u0000\u0000\u0000VW\u0003*\u0015\u0000"+
		"WX\u0005\u001f\u0000\u0000XY\u0005\u000b\u0000\u0000YZ\u0003 \u0010\u0000"+
		"Z[\u0005\u0005\u0000\u0000[\u000b\u0001\u0000\u0000\u0000\\f\u0003\u000e"+
		"\u0007\u0000]f\u0003\u0010\b\u0000^f\u0003\u0012\t\u0000_f\u0003\u0014"+
		"\n\u0000`f\u0003\u0016\u000b\u0000af\u0003\u0018\f\u0000bf\u0003\u001a"+
		"\r\u0000cf\u0003\u001c\u000e\u0000df\u0003\u001e\u000f\u0000e\\\u0001"+
		"\u0000\u0000\u0000e]\u0001\u0000\u0000\u0000e^\u0001\u0000\u0000\u0000"+
		"e_\u0001\u0000\u0000\u0000e`\u0001\u0000\u0000\u0000ea\u0001\u0000\u0000"+
		"\u0000eb\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ed\u0001\u0000"+
		"\u0000\u0000f\r\u0001\u0000\u0000\u0000gh\u0005\f\u0000\u0000hi\u0005"+
		"\r\u0000\u0000ij\u0005 \u0000\u0000jk\u0005\u0006\u0000\u0000kl\u0005"+
		" \u0000\u0000lm\u0005\u000e\u0000\u0000mn\u0005\u0005\u0000\u0000n\u000f"+
		"\u0001\u0000\u0000\u0000op\u0005\u000f\u0000\u0000pq\u0005\r\u0000\u0000"+
		"qr\u0005 \u0000\u0000rs\u0005\u000e\u0000\u0000st\u0005\u0005\u0000\u0000"+
		"t\u0011\u0001\u0000\u0000\u0000uv\u0005\u0010\u0000\u0000vw\u0005\r\u0000"+
		"\u0000wx\u0003$\u0012\u0000xy\u0005\u0006\u0000\u0000yz\u0005 \u0000\u0000"+
		"z{\u0005\u000e\u0000\u0000{|\u0005\u0005\u0000\u0000|\u0013\u0001\u0000"+
		"\u0000\u0000}~\u0005\u0010\u0000\u0000~\u007f\u0005\r\u0000\u0000\u007f"+
		"\u0080\u0003&\u0013\u0000\u0080\u0081\u0005\u0006\u0000\u0000\u0081\u0082"+
		"\u0005 \u0000\u0000\u0082\u0083\u0005\u0006\u0000\u0000\u0083\u0084\u0005"+
		"!\u0000\u0000\u0084\u0085\u0005\u000e\u0000\u0000\u0085\u0086\u0005\u0005"+
		"\u0000\u0000\u0086\u0015\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0011"+
		"\u0000\u0000\u0088\u0089\u0005\r\u0000\u0000\u0089\u008a\u0003(\u0014"+
		"\u0000\u008a\u008b\u0005\u0006\u0000\u0000\u008b\u008c\u0005 \u0000\u0000"+
		"\u008c\u008d\u0005\u000e\u0000\u0000\u008d\u008e\u0005\u0005\u0000\u0000"+
		"\u008e\u0017\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u0012\u0000\u0000"+
		"\u0090\u0091\u0005\r\u0000\u0000\u0091\u0092\u0005!\u0000\u0000\u0092"+
		"\u0093\u0005\u000e\u0000\u0000\u0093\u0094\u0005\u0005\u0000\u0000\u0094"+
		"\u0019\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u0013\u0000\u0000\u0096"+
		"\u0097\u0005\r\u0000\u0000\u0097\u0098\u0005\u000e\u0000\u0000\u0098\u0099"+
		"\u0005\u0005\u0000\u0000\u0099\u001b\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0005\u0014\u0000\u0000\u009b\u009c\u0005\r\u0000\u0000\u009c\u009d\u0005"+
		"\u000e\u0000\u0000\u009d\u009e\u0005\u0005\u0000\u0000\u009e\u001d\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0005\u0015\u0000\u0000\u00a0\u00a1\u0005"+
		"\r\u0000\u0000\u00a1\u00a2\u0005!\u0000\u0000\u00a2\u00a3\u0005\u000e"+
		"\u0000\u0000\u00a3\u00a4\u0005\u0005\u0000\u0000\u00a4\u001f\u0001\u0000"+
		"\u0000\u0000\u00a5\u00aa\u0003\"\u0011\u0000\u00a6\u00a7\u0007\u0001\u0000"+
		"\u0000\u00a7\u00a9\u0003\"\u0011\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab!\u0001\u0000\u0000\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ad\u00b4\u0003$\u0012\u0000\u00ae\u00b4"+
		"\u0003&\u0013\u0000\u00af\u00b4\u0005 \u0000\u0000\u00b0\u00b4\u0005!"+
		"\u0000\u0000\u00b1\u00b4\u0005\u001f\u0000\u0000\u00b2\u00b4\u0005\u0018"+
		"\u0000\u0000\u00b3\u00ad\u0001\u0000\u0000\u0000\u00b3\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b3\u00af\u0001\u0000\u0000\u0000\u00b3\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b4#\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005\r\u0000"+
		"\u0000\u00b6\u00b7\u0005 \u0000\u0000\u00b7\u00b8\u0005\u0006\u0000\u0000"+
		"\u00b8\u00b9\u0005 \u0000\u0000\u00b9\u00ba\u0005\u0006\u0000\u0000\u00ba"+
		"\u00bb\u0005 \u0000\u0000\u00bb\u00bc\u0005\u000e\u0000\u0000\u00bc%\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0005\r\u0000\u0000\u00be\u00bf\u0005 "+
		"\u0000\u0000\u00bf\u00c0\u0005\u0006\u0000\u0000\u00c0\u00c1\u0005 \u0000"+
		"\u0000\u00c1\u00c2\u0005\u0006\u0000\u0000\u00c2\u00c3\u0005 \u0000\u0000"+
		"\u00c3\u00c4\u0005\u000e\u0000\u0000\u00c4\'\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0005\r\u0000\u0000\u00c6\u00cb\u0003$\u0012\u0000\u00c7\u00c8"+
		"\u0005\u0006\u0000\u0000\u00c8\u00ca\u0003$\u0012\u0000\u00c9\u00c7\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001"+
		"\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce\u0001"+
		"\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005"+
		"\u000e\u0000\u0000\u00cf)\u0001\u0000\u0000\u0000\u00d0\u00d1\u0007\u0002"+
		"\u0000\u0000\u00d1+\u0001\u0000\u0000\u0000\n.29BFQe\u00aa\u00b3\u00cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}