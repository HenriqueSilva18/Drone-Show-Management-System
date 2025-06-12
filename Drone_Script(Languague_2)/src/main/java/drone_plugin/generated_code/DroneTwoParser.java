// Generated from DroneTwo.g4 by ANTLR 4.13.0
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
public class DroneTwoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, ID=42, INT=43, FLOAT=44, NEWLINE=45, WS=46, 
		COMMENT=47;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_figureDeclaration = 2, RULE_droneCapabilities = 3, 
		RULE_capability = 4, RULE_variableDeclaration = 5, RULE_command = 6, RULE_takeoff = 7, 
		RULE_land = 8, RULE_movePoint = 9, RULE_moveVector = 10, RULE_movePath = 11, 
		RULE_moveCircleAngle = 12, RULE_moveCircleDuration = 13, RULE_hoover = 14, 
		RULE_lightsOn = 15, RULE_lightsOff = 16, RULE_waitCommand = 17, RULE_environmentCheck = 18, 
		RULE_condition = 19, RULE_environmentCondition = 20, RULE_timeCondition = 21, 
		RULE_positionCondition = 22, RULE_comparison = 23, RULE_expression = 24, 
		RULE_value = 25, RULE_point = 26, RULE_vector = 27, RULE_pointArray = 28, 
		RULE_color = 29, RULE_type = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "figureDeclaration", "droneCapabilities", "capability", 
			"variableDeclaration", "command", "takeoff", "land", "movePoint", "moveVector", 
			"movePath", "moveCircleAngle", "moveCircleDuration", "hoover", "lightsOn", 
			"lightsOff", "waitCommand", "environmentCheck", "condition", "environmentCondition", 
			"timeCondition", "positionCondition", "comparison", "expression", "value", 
			"point", "vector", "pointArray", "color", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'figure'", "'{'", "'}'", "'requires'", "','", "'LED'", "'ROTATION'", 
			"'TRANSLATION'", "'HOVER'", "'='", "';'", "'takeOff'", "'('", "')'", 
			"'when'", "'land'", "'move'", "'movePath'", "'moveCircle'", "'hoover'", 
			"'lightsOn'", "'lightsOff'", "'wait'", "'checkWind'", "'wind'", "'time'", 
			"'position'", "'<'", "'>'", "'=='", "'<='", "'>='", "'-'", "'+'", "'PI'", 
			"'Point'", "'Vector'", "'LinearVelocity'", "'AngularVelocity'", "'Distance'", 
			"'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "ID", "INT", "FLOAT", "NEWLINE", 
			"WS", "COMMENT"
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
	public String getGrammarFileName() { return "DroneTwo.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DroneTwoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(DroneTwoParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(DroneTwoParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(DroneTwoParser.NEWLINE, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4329360527362L) != 0)) {
				{
				{
				setState(62);
				statement();
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(63);
					match(NEWLINE);
					}
				}

				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
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
		public FigureDeclarationContext figureDeclaration() {
			return getRuleContext(FigureDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				figureDeclaration();
				}
				break;
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				variableDeclaration();
				}
				break;
			case T__11:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				command();
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
	public static class FigureDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DroneTwoParser.ID, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DroneCapabilitiesContext droneCapabilities() {
			return getRuleContext(DroneCapabilitiesContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(DroneTwoParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(DroneTwoParser.NEWLINE, i);
		}
		public FigureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figureDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterFigureDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitFigureDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitFigureDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureDeclarationContext figureDeclaration() throws RecognitionException {
		FigureDeclarationContext _localctx = new FigureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_figureDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__0);
			setState(79);
			match(ID);
			setState(80);
			match(T__1);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4329360527362L) != 0)) {
				{
				{
				setState(81);
				statement();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(82);
					match(NEWLINE);
					}
				}

				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			match(T__2);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(91);
				match(T__3);
				setState(92);
				droneCapabilities();
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
	public static class DroneCapabilitiesContext extends ParserRuleContext {
		public List<CapabilityContext> capability() {
			return getRuleContexts(CapabilityContext.class);
		}
		public CapabilityContext capability(int i) {
			return getRuleContext(CapabilityContext.class,i);
		}
		public DroneCapabilitiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_droneCapabilities; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterDroneCapabilities(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitDroneCapabilities(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitDroneCapabilities(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DroneCapabilitiesContext droneCapabilities() throws RecognitionException {
		DroneCapabilitiesContext _localctx = new DroneCapabilitiesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_droneCapabilities);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			capability();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(96);
				match(T__4);
				setState(97);
				capability();
				}
				}
				setState(102);
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
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterCapability(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitCapability(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitCapability(this);
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
			setState(103);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 960L) != 0)) ) {
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
		public TerminalNode ID() { return getToken(DroneTwoParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			type();
			setState(106);
			match(ID);
			setState(107);
			match(T__9);
			setState(108);
			expression();
			setState(109);
			match(T__10);
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
		public MovePointContext movePoint() {
			return getRuleContext(MovePointContext.class,0);
		}
		public MoveVectorContext moveVector() {
			return getRuleContext(MoveVectorContext.class,0);
		}
		public MovePathContext movePath() {
			return getRuleContext(MovePathContext.class,0);
		}
		public MoveCircleAngleContext moveCircleAngle() {
			return getRuleContext(MoveCircleAngleContext.class,0);
		}
		public MoveCircleDurationContext moveCircleDuration() {
			return getRuleContext(MoveCircleDurationContext.class,0);
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
		public WaitCommandContext waitCommand() {
			return getRuleContext(WaitCommandContext.class,0);
		}
		public EnvironmentCheckContext environmentCheck() {
			return getRuleContext(EnvironmentCheckContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_command);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				takeoff();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				land();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				movePoint();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				moveVector();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				movePath();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(116);
				moveCircleAngle();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(117);
				moveCircleDuration();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(118);
				hoover();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(119);
				lightsOn();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(120);
				lightsOff();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(121);
				waitCommand();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(122);
				environmentCheck();
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
		public List<TerminalNode> FLOAT() { return getTokens(DroneTwoParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(DroneTwoParser.FLOAT, i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TakeoffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_takeoff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterTakeoff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitTakeoff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitTakeoff(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TakeoffContext takeoff() throws RecognitionException {
		TakeoffContext _localctx = new TakeoffContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_takeoff);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__11);
			setState(126);
			match(T__12);
			setState(127);
			match(FLOAT);
			setState(128);
			match(T__4);
			setState(129);
			match(FLOAT);
			setState(130);
			match(T__13);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(131);
				match(T__14);
				setState(132);
				condition();
				}
			}

			setState(135);
			match(T__10);
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
		public TerminalNode FLOAT() { return getToken(DroneTwoParser.FLOAT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public LandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_land; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterLand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitLand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitLand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LandContext land() throws RecognitionException {
		LandContext _localctx = new LandContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_land);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(T__15);
			setState(138);
			match(T__12);
			setState(139);
			match(FLOAT);
			setState(140);
			match(T__13);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(141);
				match(T__14);
				setState(142);
				condition();
				}
			}

			setState(145);
			match(T__10);
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
	public static class MovePointContext extends ParserRuleContext {
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(DroneTwoParser.FLOAT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public MovePointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_movePoint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterMovePoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitMovePoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitMovePoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MovePointContext movePoint() throws RecognitionException {
		MovePointContext _localctx = new MovePointContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_movePoint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__16);
			setState(148);
			match(T__12);
			setState(149);
			point();
			setState(150);
			match(T__4);
			setState(151);
			match(FLOAT);
			setState(152);
			match(T__13);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(153);
				match(T__14);
				setState(154);
				condition();
				}
			}

			setState(157);
			match(T__10);
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
		public TerminalNode FLOAT() { return getToken(DroneTwoParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(DroneTwoParser.INT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public MoveVectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moveVector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterMoveVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitMoveVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitMoveVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoveVectorContext moveVector() throws RecognitionException {
		MoveVectorContext _localctx = new MoveVectorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_moveVector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__16);
			setState(160);
			match(T__12);
			setState(161);
			vector();
			setState(162);
			match(T__4);
			setState(163);
			match(FLOAT);
			setState(164);
			match(T__4);
			setState(165);
			match(INT);
			setState(166);
			match(T__13);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(167);
				match(T__14);
				setState(168);
				condition();
				}
			}

			setState(171);
			match(T__10);
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
		public PointArrayContext pointArray() {
			return getRuleContext(PointArrayContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(DroneTwoParser.FLOAT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public MovePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_movePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterMovePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitMovePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitMovePath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MovePathContext movePath() throws RecognitionException {
		MovePathContext _localctx = new MovePathContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_movePath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__17);
			setState(174);
			match(T__12);
			setState(175);
			pointArray();
			setState(176);
			match(T__4);
			setState(177);
			match(FLOAT);
			setState(178);
			match(T__13);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(179);
				match(T__14);
				setState(180);
				condition();
				}
			}

			setState(183);
			match(T__10);
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
	public static class MoveCircleAngleContext extends ParserRuleContext {
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public List<TerminalNode> FLOAT() { return getTokens(DroneTwoParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(DroneTwoParser.FLOAT, i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public MoveCircleAngleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moveCircleAngle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterMoveCircleAngle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitMoveCircleAngle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitMoveCircleAngle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoveCircleAngleContext moveCircleAngle() throws RecognitionException {
		MoveCircleAngleContext _localctx = new MoveCircleAngleContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_moveCircleAngle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__18);
			setState(186);
			match(T__12);
			setState(187);
			point();
			setState(188);
			match(T__4);
			setState(189);
			match(FLOAT);
			setState(190);
			match(T__4);
			setState(191);
			match(FLOAT);
			setState(192);
			match(T__13);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(193);
				match(T__14);
				setState(194);
				condition();
				}
			}

			setState(197);
			match(T__10);
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
	public static class MoveCircleDurationContext extends ParserRuleContext {
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public TerminalNode INT() { return getToken(DroneTwoParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(DroneTwoParser.FLOAT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public MoveCircleDurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moveCircleDuration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterMoveCircleDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitMoveCircleDuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitMoveCircleDuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoveCircleDurationContext moveCircleDuration() throws RecognitionException {
		MoveCircleDurationContext _localctx = new MoveCircleDurationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_moveCircleDuration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(T__18);
			setState(200);
			match(T__12);
			setState(201);
			point();
			setState(202);
			match(T__4);
			setState(203);
			match(INT);
			setState(204);
			match(T__4);
			setState(205);
			match(FLOAT);
			setState(206);
			match(T__13);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(207);
				match(T__14);
				setState(208);
				condition();
				}
			}

			setState(211);
			match(T__10);
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
		public TerminalNode INT() { return getToken(DroneTwoParser.INT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public HooverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hoover; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterHoover(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitHoover(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitHoover(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HooverContext hoover() throws RecognitionException {
		HooverContext _localctx = new HooverContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_hoover);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(T__19);
			setState(214);
			match(T__12);
			setState(215);
			match(INT);
			setState(216);
			match(T__13);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(217);
				match(T__14);
				setState(218);
				condition();
				}
			}

			setState(221);
			match(T__10);
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
		public ColorContext color() {
			return getRuleContext(ColorContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public LightsOnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lightsOn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterLightsOn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitLightsOn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitLightsOn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LightsOnContext lightsOn() throws RecognitionException {
		LightsOnContext _localctx = new LightsOnContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_lightsOn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__20);
			setState(224);
			match(T__12);
			setState(225);
			color();
			setState(226);
			match(T__13);
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(227);
				match(T__14);
				setState(228);
				condition();
				}
			}

			setState(231);
			match(T__10);
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
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public LightsOffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lightsOff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterLightsOff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitLightsOff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitLightsOff(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LightsOffContext lightsOff() throws RecognitionException {
		LightsOffContext _localctx = new LightsOffContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_lightsOff);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(T__21);
			setState(234);
			match(T__12);
			setState(235);
			match(T__13);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(236);
				match(T__14);
				setState(237);
				condition();
				}
			}

			setState(240);
			match(T__10);
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
	public static class WaitCommandContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(DroneTwoParser.INT, 0); }
		public WaitCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_waitCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterWaitCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitWaitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitWaitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WaitCommandContext waitCommand() throws RecognitionException {
		WaitCommandContext _localctx = new WaitCommandContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_waitCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(T__22);
			setState(243);
			match(T__12);
			setState(244);
			match(INT);
			setState(245);
			match(T__13);
			setState(246);
			match(T__10);
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
	public static class EnvironmentCheckContext extends ParserRuleContext {
		public List<TerminalNode> FLOAT() { return getTokens(DroneTwoParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(DroneTwoParser.FLOAT, i);
		}
		public EnvironmentCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_environmentCheck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterEnvironmentCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitEnvironmentCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitEnvironmentCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvironmentCheckContext environmentCheck() throws RecognitionException {
		EnvironmentCheckContext _localctx = new EnvironmentCheckContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_environmentCheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(T__23);
			setState(249);
			match(T__12);
			setState(250);
			match(FLOAT);
			setState(251);
			match(T__4);
			setState(252);
			match(FLOAT);
			setState(253);
			match(T__4);
			setState(254);
			match(FLOAT);
			setState(255);
			match(T__13);
			setState(256);
			match(T__10);
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
	public static class ConditionContext extends ParserRuleContext {
		public EnvironmentConditionContext environmentCondition() {
			return getRuleContext(EnvironmentConditionContext.class,0);
		}
		public TimeConditionContext timeCondition() {
			return getRuleContext(TimeConditionContext.class,0);
		}
		public PositionConditionContext positionCondition() {
			return getRuleContext(PositionConditionContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_condition);
		try {
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				environmentCondition();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				timeCondition();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				positionCondition();
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
	public static class EnvironmentConditionContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(DroneTwoParser.FLOAT, 0); }
		public EnvironmentConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_environmentCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterEnvironmentCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitEnvironmentCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitEnvironmentCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvironmentConditionContext environmentCondition() throws RecognitionException {
		EnvironmentConditionContext _localctx = new EnvironmentConditionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_environmentCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(T__24);
			setState(264);
			comparison();
			setState(265);
			match(FLOAT);
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
	public static class TimeConditionContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode INT() { return getToken(DroneTwoParser.INT, 0); }
		public TimeConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterTimeCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitTimeCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitTimeCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeConditionContext timeCondition() throws RecognitionException {
		TimeConditionContext _localctx = new TimeConditionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_timeCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(T__25);
			setState(268);
			comparison();
			setState(269);
			match(INT);
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
	public static class PositionConditionContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public PositionConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positionCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterPositionCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitPositionCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitPositionCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PositionConditionContext positionCondition() throws RecognitionException {
		PositionConditionContext _localctx = new PositionConditionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_positionCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(T__26);
			setState(272);
			comparison();
			setState(273);
			point();
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
	public static class ComparisonContext extends ParserRuleContext {
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8321499136L) != 0)) ) {
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
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			value();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__32 || _la==T__33) {
				{
				{
				setState(278);
				_la = _input.LA(1);
				if ( !(_la==T__32 || _la==T__33) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(279);
				value();
				}
				}
				setState(284);
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
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(DroneTwoParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(DroneTwoParser.INT, 0); }
		public TerminalNode ID() { return getToken(DroneTwoParser.ID, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_value);
		try {
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				point();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				vector();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(287);
				match(FLOAT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(288);
				match(INT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(289);
				match(ID);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(290);
				match(T__34);
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
	public static class PointContext extends ParserRuleContext {
		public List<TerminalNode> FLOAT() { return getTokens(DroneTwoParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(DroneTwoParser.FLOAT, i);
		}
		public PointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_point; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitPoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitPoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointContext point() throws RecognitionException {
		PointContext _localctx = new PointContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_point);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(T__12);
			setState(294);
			match(FLOAT);
			setState(295);
			match(T__4);
			setState(296);
			match(FLOAT);
			setState(297);
			match(T__4);
			setState(298);
			match(FLOAT);
			setState(299);
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
		public List<TerminalNode> FLOAT() { return getTokens(DroneTwoParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(DroneTwoParser.FLOAT, i);
		}
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_vector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(T__12);
			setState(302);
			match(FLOAT);
			setState(303);
			match(T__4);
			setState(304);
			match(FLOAT);
			setState(305);
			match(T__4);
			setState(306);
			match(FLOAT);
			setState(307);
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
	public static class PointArrayContext extends ParserRuleContext {
		public List<PointContext> point() {
			return getRuleContexts(PointContext.class);
		}
		public PointContext point(int i) {
			return getRuleContext(PointContext.class,i);
		}
		public PointArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterPointArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitPointArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitPointArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointArrayContext pointArray() throws RecognitionException {
		PointArrayContext _localctx = new PointArrayContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_pointArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(T__12);
			setState(310);
			point();
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(311);
				match(T__4);
				setState(312);
				point();
				}
				}
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(318);
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
	public static class ColorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DroneTwoParser.ID, 0); }
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitColor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_color);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
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
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DroneTwoListener ) ((DroneTwoListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DroneTwoVisitor ) return ((DroneTwoVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4329327034368L) != 0)) ) {
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
		"\u0004\u0001/\u0145\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0001\u0000\u0001\u0000\u0003\u0000A\b\u0000\u0005\u0000C\b\u0000\n\u0000"+
		"\f\u0000F\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001M\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002T\b\u0002\u0005\u0002V\b\u0002\n\u0002\f"+
		"\u0002Y\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002^\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003c\b\u0003\n\u0003\f\u0003"+
		"f\t\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006|\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u0086\b\u0007\u0001\u0007\u0001\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0090\b\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u009c\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00aa\b\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00b6\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u00c4\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00d2\b\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00dc\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00e6\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00ef\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u0106\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0005\u0018\u0119\b\u0018\n\u0018\f\u0018\u011c\t\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003"+
		"\u0019\u0124\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u013a\b\u001c\n"+
		"\u001c\f\u001c\u013d\t\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0000\u0000\u001f\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<\u0000\u0004\u0001\u0000\u0006\t\u0001\u0000\u001c \u0001"+
		"\u0000!\"\u0001\u0000$)\u014b\u0000D\u0001\u0000\u0000\u0000\u0002L\u0001"+
		"\u0000\u0000\u0000\u0004N\u0001\u0000\u0000\u0000\u0006_\u0001\u0000\u0000"+
		"\u0000\bg\u0001\u0000\u0000\u0000\ni\u0001\u0000\u0000\u0000\f{\u0001"+
		"\u0000\u0000\u0000\u000e}\u0001\u0000\u0000\u0000\u0010\u0089\u0001\u0000"+
		"\u0000\u0000\u0012\u0093\u0001\u0000\u0000\u0000\u0014\u009f\u0001\u0000"+
		"\u0000\u0000\u0016\u00ad\u0001\u0000\u0000\u0000\u0018\u00b9\u0001\u0000"+
		"\u0000\u0000\u001a\u00c7\u0001\u0000\u0000\u0000\u001c\u00d5\u0001\u0000"+
		"\u0000\u0000\u001e\u00df\u0001\u0000\u0000\u0000 \u00e9\u0001\u0000\u0000"+
		"\u0000\"\u00f2\u0001\u0000\u0000\u0000$\u00f8\u0001\u0000\u0000\u0000"+
		"&\u0105\u0001\u0000\u0000\u0000(\u0107\u0001\u0000\u0000\u0000*\u010b"+
		"\u0001\u0000\u0000\u0000,\u010f\u0001\u0000\u0000\u0000.\u0113\u0001\u0000"+
		"\u0000\u00000\u0115\u0001\u0000\u0000\u00002\u0123\u0001\u0000\u0000\u0000"+
		"4\u0125\u0001\u0000\u0000\u00006\u012d\u0001\u0000\u0000\u00008\u0135"+
		"\u0001\u0000\u0000\u0000:\u0140\u0001\u0000\u0000\u0000<\u0142\u0001\u0000"+
		"\u0000\u0000>@\u0003\u0002\u0001\u0000?A\u0005-\u0000\u0000@?\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000B>\u0001"+
		"\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000"+
		"DE\u0001\u0000\u0000\u0000EG\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000"+
		"\u0000GH\u0005\u0000\u0000\u0001H\u0001\u0001\u0000\u0000\u0000IM\u0003"+
		"\u0004\u0002\u0000JM\u0003\n\u0005\u0000KM\u0003\f\u0006\u0000LI\u0001"+
		"\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LK\u0001\u0000\u0000\u0000"+
		"M\u0003\u0001\u0000\u0000\u0000NO\u0005\u0001\u0000\u0000OP\u0005*\u0000"+
		"\u0000PW\u0005\u0002\u0000\u0000QS\u0003\u0002\u0001\u0000RT\u0005-\u0000"+
		"\u0000SR\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000"+
		"\u0000\u0000UQ\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001"+
		"\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XZ\u0001\u0000\u0000\u0000"+
		"YW\u0001\u0000\u0000\u0000Z]\u0005\u0003\u0000\u0000[\\\u0005\u0004\u0000"+
		"\u0000\\^\u0003\u0006\u0003\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^\u0005\u0001\u0000\u0000\u0000_d\u0003\b\u0004\u0000`a\u0005"+
		"\u0005\u0000\u0000ac\u0003\b\u0004\u0000b`\u0001\u0000\u0000\u0000cf\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000"+
		"e\u0007\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000gh\u0007\u0000"+
		"\u0000\u0000h\t\u0001\u0000\u0000\u0000ij\u0003<\u001e\u0000jk\u0005*"+
		"\u0000\u0000kl\u0005\n\u0000\u0000lm\u00030\u0018\u0000mn\u0005\u000b"+
		"\u0000\u0000n\u000b\u0001\u0000\u0000\u0000o|\u0003\u000e\u0007\u0000"+
		"p|\u0003\u0010\b\u0000q|\u0003\u0012\t\u0000r|\u0003\u0014\n\u0000s|\u0003"+
		"\u0016\u000b\u0000t|\u0003\u0018\f\u0000u|\u0003\u001a\r\u0000v|\u0003"+
		"\u001c\u000e\u0000w|\u0003\u001e\u000f\u0000x|\u0003 \u0010\u0000y|\u0003"+
		"\"\u0011\u0000z|\u0003$\u0012\u0000{o\u0001\u0000\u0000\u0000{p\u0001"+
		"\u0000\u0000\u0000{q\u0001\u0000\u0000\u0000{r\u0001\u0000\u0000\u0000"+
		"{s\u0001\u0000\u0000\u0000{t\u0001\u0000\u0000\u0000{u\u0001\u0000\u0000"+
		"\u0000{v\u0001\u0000\u0000\u0000{w\u0001\u0000\u0000\u0000{x\u0001\u0000"+
		"\u0000\u0000{y\u0001\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000|\r\u0001"+
		"\u0000\u0000\u0000}~\u0005\f\u0000\u0000~\u007f\u0005\r\u0000\u0000\u007f"+
		"\u0080\u0005,\u0000\u0000\u0080\u0081\u0005\u0005\u0000\u0000\u0081\u0082"+
		"\u0005,\u0000\u0000\u0082\u0085\u0005\u000e\u0000\u0000\u0083\u0084\u0005"+
		"\u000f\u0000\u0000\u0084\u0086\u0003&\u0013\u0000\u0085\u0083\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0005\u000b\u0000\u0000\u0088\u000f\u0001\u0000"+
		"\u0000\u0000\u0089\u008a\u0005\u0010\u0000\u0000\u008a\u008b\u0005\r\u0000"+
		"\u0000\u008b\u008c\u0005,\u0000\u0000\u008c\u008f\u0005\u000e\u0000\u0000"+
		"\u008d\u008e\u0005\u000f\u0000\u0000\u008e\u0090\u0003&\u0013\u0000\u008f"+
		"\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u000b\u0000\u0000\u0092"+
		"\u0011\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u0011\u0000\u0000\u0094"+
		"\u0095\u0005\r\u0000\u0000\u0095\u0096\u00034\u001a\u0000\u0096\u0097"+
		"\u0005\u0005\u0000\u0000\u0097\u0098\u0005,\u0000\u0000\u0098\u009b\u0005"+
		"\u000e\u0000\u0000\u0099\u009a\u0005\u000f\u0000\u0000\u009a\u009c\u0003"+
		"&\u0013\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000"+
		"\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e\u0005\u000b"+
		"\u0000\u0000\u009e\u0013\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u0011"+
		"\u0000\u0000\u00a0\u00a1\u0005\r\u0000\u0000\u00a1\u00a2\u00036\u001b"+
		"\u0000\u00a2\u00a3\u0005\u0005\u0000\u0000\u00a3\u00a4\u0005,\u0000\u0000"+
		"\u00a4\u00a5\u0005\u0005\u0000\u0000\u00a5\u00a6\u0005+\u0000\u0000\u00a6"+
		"\u00a9\u0005\u000e\u0000\u0000\u00a7\u00a8\u0005\u000f\u0000\u0000\u00a8"+
		"\u00aa\u0003&\u0013\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0005\u000b\u0000\u0000\u00ac\u0015\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0005\u0012\u0000\u0000\u00ae\u00af\u0005\r\u0000\u0000\u00af\u00b0\u0003"+
		"8\u001c\u0000\u00b0\u00b1\u0005\u0005\u0000\u0000\u00b1\u00b2\u0005,\u0000"+
		"\u0000\u00b2\u00b5\u0005\u000e\u0000\u0000\u00b3\u00b4\u0005\u000f\u0000"+
		"\u0000\u00b4\u00b6\u0003&\u0013\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0005\u000b\u0000\u0000\u00b8\u0017\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0005\u0013\u0000\u0000\u00ba\u00bb\u0005\r\u0000\u0000\u00bb"+
		"\u00bc\u00034\u001a\u0000\u00bc\u00bd\u0005\u0005\u0000\u0000\u00bd\u00be"+
		"\u0005,\u0000\u0000\u00be\u00bf\u0005\u0005\u0000\u0000\u00bf\u00c0\u0005"+
		",\u0000\u0000\u00c0\u00c3\u0005\u000e\u0000\u0000\u00c1\u00c2\u0005\u000f"+
		"\u0000\u0000\u00c2\u00c4\u0003&\u0013\u0000\u00c3\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0005\u000b\u0000\u0000\u00c6\u0019\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c8\u0005\u0013\u0000\u0000\u00c8\u00c9\u0005\r\u0000\u0000"+
		"\u00c9\u00ca\u00034\u001a\u0000\u00ca\u00cb\u0005\u0005\u0000\u0000\u00cb"+
		"\u00cc\u0005+\u0000\u0000\u00cc\u00cd\u0005\u0005\u0000\u0000\u00cd\u00ce"+
		"\u0005,\u0000\u0000\u00ce\u00d1\u0005\u000e\u0000\u0000\u00cf\u00d0\u0005"+
		"\u000f\u0000\u0000\u00d0\u00d2\u0003&\u0013\u0000\u00d1\u00cf\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u0005\u000b\u0000\u0000\u00d4\u001b\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d6\u0005\u0014\u0000\u0000\u00d6\u00d7\u0005\r\u0000"+
		"\u0000\u00d7\u00d8\u0005+\u0000\u0000\u00d8\u00db\u0005\u000e\u0000\u0000"+
		"\u00d9\u00da\u0005\u000f\u0000\u0000\u00da\u00dc\u0003&\u0013\u0000\u00db"+
		"\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0001\u0000\u0000\u0000\u00dd\u00de\u0005\u000b\u0000\u0000\u00de"+
		"\u001d\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u0015\u0000\u0000\u00e0"+
		"\u00e1\u0005\r\u0000\u0000\u00e1\u00e2\u0003:\u001d\u0000\u00e2\u00e5"+
		"\u0005\u000e\u0000\u0000\u00e3\u00e4\u0005\u000f\u0000\u0000\u00e4\u00e6"+
		"\u0003&\u0013\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e8\u0005"+
		"\u000b\u0000\u0000\u00e8\u001f\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005"+
		"\u0016\u0000\u0000\u00ea\u00eb\u0005\r\u0000\u0000\u00eb\u00ee\u0005\u000e"+
		"\u0000\u0000\u00ec\u00ed\u0005\u000f\u0000\u0000\u00ed\u00ef\u0003&\u0013"+
		"\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005\u000b\u0000"+
		"\u0000\u00f1!\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\u0017\u0000\u0000"+
		"\u00f3\u00f4\u0005\r\u0000\u0000\u00f4\u00f5\u0005+\u0000\u0000\u00f5"+
		"\u00f6\u0005\u000e\u0000\u0000\u00f6\u00f7\u0005\u000b\u0000\u0000\u00f7"+
		"#\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005\u0018\u0000\u0000\u00f9\u00fa"+
		"\u0005\r\u0000\u0000\u00fa\u00fb\u0005,\u0000\u0000\u00fb\u00fc\u0005"+
		"\u0005\u0000\u0000\u00fc\u00fd\u0005,\u0000\u0000\u00fd\u00fe\u0005\u0005"+
		"\u0000\u0000\u00fe\u00ff\u0005,\u0000\u0000\u00ff\u0100\u0005\u000e\u0000"+
		"\u0000\u0100\u0101\u0005\u000b\u0000\u0000\u0101%\u0001\u0000\u0000\u0000"+
		"\u0102\u0106\u0003(\u0014\u0000\u0103\u0106\u0003*\u0015\u0000\u0104\u0106"+
		"\u0003,\u0016\u0000\u0105\u0102\u0001\u0000\u0000\u0000\u0105\u0103\u0001"+
		"\u0000\u0000\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0106\'\u0001\u0000"+
		"\u0000\u0000\u0107\u0108\u0005\u0019\u0000\u0000\u0108\u0109\u0003.\u0017"+
		"\u0000\u0109\u010a\u0005,\u0000\u0000\u010a)\u0001\u0000\u0000\u0000\u010b"+
		"\u010c\u0005\u001a\u0000\u0000\u010c\u010d\u0003.\u0017\u0000\u010d\u010e"+
		"\u0005+\u0000\u0000\u010e+\u0001\u0000\u0000\u0000\u010f\u0110\u0005\u001b"+
		"\u0000\u0000\u0110\u0111\u0003.\u0017\u0000\u0111\u0112\u00034\u001a\u0000"+
		"\u0112-\u0001\u0000\u0000\u0000\u0113\u0114\u0007\u0001\u0000\u0000\u0114"+
		"/\u0001\u0000\u0000\u0000\u0115\u011a\u00032\u0019\u0000\u0116\u0117\u0007"+
		"\u0002\u0000\u0000\u0117\u0119\u00032\u0019\u0000\u0118\u0116\u0001\u0000"+
		"\u0000\u0000\u0119\u011c\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000"+
		"\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b1\u0001\u0000\u0000"+
		"\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011d\u0124\u00034\u001a\u0000"+
		"\u011e\u0124\u00036\u001b\u0000\u011f\u0124\u0005,\u0000\u0000\u0120\u0124"+
		"\u0005+\u0000\u0000\u0121\u0124\u0005*\u0000\u0000\u0122\u0124\u0005#"+
		"\u0000\u0000\u0123\u011d\u0001\u0000\u0000\u0000\u0123\u011e\u0001\u0000"+
		"\u0000\u0000\u0123\u011f\u0001\u0000\u0000\u0000\u0123\u0120\u0001\u0000"+
		"\u0000\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0123\u0122\u0001\u0000"+
		"\u0000\u0000\u01243\u0001\u0000\u0000\u0000\u0125\u0126\u0005\r\u0000"+
		"\u0000\u0126\u0127\u0005,\u0000\u0000\u0127\u0128\u0005\u0005\u0000\u0000"+
		"\u0128\u0129\u0005,\u0000\u0000\u0129\u012a\u0005\u0005\u0000\u0000\u012a"+
		"\u012b\u0005,\u0000\u0000\u012b\u012c\u0005\u000e\u0000\u0000\u012c5\u0001"+
		"\u0000\u0000\u0000\u012d\u012e\u0005\r\u0000\u0000\u012e\u012f\u0005,"+
		"\u0000\u0000\u012f\u0130\u0005\u0005\u0000\u0000\u0130\u0131\u0005,\u0000"+
		"\u0000\u0131\u0132\u0005\u0005\u0000\u0000\u0132\u0133\u0005,\u0000\u0000"+
		"\u0133\u0134\u0005\u000e\u0000\u0000\u01347\u0001\u0000\u0000\u0000\u0135"+
		"\u0136\u0005\r\u0000\u0000\u0136\u013b\u00034\u001a\u0000\u0137\u0138"+
		"\u0005\u0005\u0000\u0000\u0138\u013a\u00034\u001a\u0000\u0139\u0137\u0001"+
		"\u0000\u0000\u0000\u013a\u013d\u0001\u0000\u0000\u0000\u013b\u0139\u0001"+
		"\u0000\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000\u013c\u013e\u0001"+
		"\u0000\u0000\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013e\u013f\u0005"+
		"\u000e\u0000\u0000\u013f9\u0001\u0000\u0000\u0000\u0140\u0141\u0005*\u0000"+
		"\u0000\u0141;\u0001\u0000\u0000\u0000\u0142\u0143\u0007\u0003\u0000\u0000"+
		"\u0143=\u0001\u0000\u0000\u0000\u0016@DLSW]d{\u0085\u008f\u009b\u00a9"+
		"\u00b5\u00c3\u00d1\u00db\u00e5\u00ee\u0105\u011a\u0123\u013b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}