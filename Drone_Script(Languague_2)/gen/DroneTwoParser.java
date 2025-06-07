// Generated from C:/Users/berna/IdeaProjects/sem4pi-2024-2025-sem4pi_2024_2025_g39/Drone_Script(Languague_2)/src/main/resources/DroneTwo.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class DroneTwoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, ID=23, FLOAT=24, INT=25, 
		NEWLINE=26, WS=27;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_variableDeclaration = 2, RULE_command = 3, 
		RULE_takeoff = 4, RULE_land = 5, RULE_movePoint = 6, RULE_moveVector = 7, 
		RULE_movePath = 8, RULE_moveCircleAngle = 9, RULE_moveCircleDuration = 10, 
		RULE_hoover = 11, RULE_lightsOn = 12, RULE_lightsOff = 13, RULE_expression = 14, 
		RULE_value = 15, RULE_point = 16, RULE_vector = 17, RULE_pointArray = 18, 
		RULE_color = 19, RULE_type = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "variableDeclaration", "command", "takeoff", 
			"land", "movePoint", "moveVector", "movePath", "moveCircleAngle", "moveCircleDuration", 
			"hoover", "lightsOn", "lightsOff", "expression", "value", "point", "vector", 
			"pointArray", "color", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'takeOff'", "'('", "','", "')'", "'land'", "'move'", 
			"'movePath'", "'moveCircle'", "'hoover'", "'lightsOn'", "'lightsOff'", 
			"'-'", "'+'", "'PI'", "'Point'", "'Vector'", "'LinearVelocity'", "'AngularVelocity'", 
			"'Distance'", "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "ID", 
			"FLOAT", "INT", "NEWLINE", "WS"
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
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8273800L) != 0)) {
				{
				{
				setState(42);
				statement();
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(43);
					match(NEWLINE);
					}
				}

				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class StatementContext extends ParserRuleContext {
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
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				variableDeclaration();
				}
				break;
			case T__2:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
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
		enterRule(_localctx, 4, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			type();
			setState(58);
			match(ID);
			setState(59);
			match(T__0);
			setState(60);
			expression();
			setState(61);
			match(T__1);
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
		enterRule(_localctx, 6, RULE_command);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				takeoff();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				land();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				movePoint();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				moveVector();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				movePath();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(68);
				moveCircleAngle();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(69);
				moveCircleDuration();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(70);
				hoover();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(71);
				lightsOn();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(72);
				lightsOff();
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
		enterRule(_localctx, 8, RULE_takeoff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__2);
			setState(76);
			match(T__3);
			setState(77);
			match(FLOAT);
			setState(78);
			match(T__4);
			setState(79);
			match(FLOAT);
			setState(80);
			match(T__5);
			setState(81);
			match(T__1);
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
		enterRule(_localctx, 10, RULE_land);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__6);
			setState(84);
			match(T__3);
			setState(85);
			match(FLOAT);
			setState(86);
			match(T__5);
			setState(87);
			match(T__1);
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
		enterRule(_localctx, 12, RULE_movePoint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__7);
			setState(90);
			match(T__3);
			setState(91);
			point();
			setState(92);
			match(T__4);
			setState(93);
			match(FLOAT);
			setState(94);
			match(T__5);
			setState(95);
			match(T__1);
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
		enterRule(_localctx, 14, RULE_moveVector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__7);
			setState(98);
			match(T__3);
			setState(99);
			vector();
			setState(100);
			match(T__4);
			setState(101);
			match(FLOAT);
			setState(102);
			match(T__4);
			setState(103);
			match(INT);
			setState(104);
			match(T__5);
			setState(105);
			match(T__1);
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
		enterRule(_localctx, 16, RULE_movePath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__8);
			setState(108);
			match(T__3);
			setState(109);
			pointArray();
			setState(110);
			match(T__4);
			setState(111);
			match(FLOAT);
			setState(112);
			match(T__5);
			setState(113);
			match(T__1);
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
		enterRule(_localctx, 18, RULE_moveCircleAngle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__9);
			setState(116);
			match(T__3);
			setState(117);
			point();
			setState(118);
			match(T__4);
			setState(119);
			match(FLOAT);
			setState(120);
			match(T__4);
			setState(121);
			match(FLOAT);
			setState(122);
			match(T__5);
			setState(123);
			match(T__1);
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
		enterRule(_localctx, 20, RULE_moveCircleDuration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__9);
			setState(126);
			match(T__3);
			setState(127);
			point();
			setState(128);
			match(T__4);
			setState(129);
			match(INT);
			setState(130);
			match(T__4);
			setState(131);
			match(FLOAT);
			setState(132);
			match(T__5);
			setState(133);
			match(T__1);
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
		enterRule(_localctx, 22, RULE_hoover);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__10);
			setState(136);
			match(T__3);
			setState(137);
			match(INT);
			setState(138);
			match(T__5);
			setState(139);
			match(T__1);
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
		enterRule(_localctx, 24, RULE_lightsOn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__11);
			setState(142);
			match(T__3);
			setState(143);
			color();
			setState(144);
			match(T__5);
			setState(145);
			match(T__1);
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
		enterRule(_localctx, 26, RULE_lightsOff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__12);
			setState(148);
			match(T__3);
			setState(149);
			match(T__5);
			setState(150);
			match(T__1);
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
		enterRule(_localctx, 28, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			value();
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13 || _la==T__14) {
				{
				{
				setState(153);
				_la = _input.LA(1);
				if ( !(_la==T__13 || _la==T__14) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(154);
				value();
				}
				}
				setState(159);
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
		enterRule(_localctx, 30, RULE_value);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				point();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				vector();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				match(FLOAT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				match(INT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(164);
				match(ID);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(165);
				match(T__15);
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
		enterRule(_localctx, 32, RULE_point);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(T__3);
			setState(169);
			match(FLOAT);
			setState(170);
			match(T__4);
			setState(171);
			match(FLOAT);
			setState(172);
			match(T__4);
			setState(173);
			match(FLOAT);
			setState(174);
			match(T__5);
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
		enterRule(_localctx, 34, RULE_vector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(T__3);
			setState(177);
			match(FLOAT);
			setState(178);
			match(T__4);
			setState(179);
			match(FLOAT);
			setState(180);
			match(T__4);
			setState(181);
			match(FLOAT);
			setState(182);
			match(T__5);
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
		enterRule(_localctx, 36, RULE_pointArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(T__3);
			setState(185);
			point();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(186);
				match(T__4);
				setState(187);
				point();
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193);
			match(T__5);
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
		enterRule(_localctx, 38, RULE_color);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
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
		enterRule(_localctx, 40, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8257536L) != 0)) ) {
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
		"\u0004\u0001\u001b\u00c8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0001"+
		"\u0000\u0003\u0000-\b\u0000\u0005\u0000/\b\u0000\n\u0000\f\u00002\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u00018\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003J\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u009c\b\u000e\n\u000e\f\u000e\u009f\t\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00a7\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00bd\b\u0012\n"+
		"\u0012\f\u0012\u00c0\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0000\u0000\u0015\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(\u0000\u0002\u0001\u0000\u000e\u000f\u0001\u0000\u0011\u0016\u00c5"+
		"\u00000\u0001\u0000\u0000\u0000\u00027\u0001\u0000\u0000\u0000\u00049"+
		"\u0001\u0000\u0000\u0000\u0006I\u0001\u0000\u0000\u0000\bK\u0001\u0000"+
		"\u0000\u0000\nS\u0001\u0000\u0000\u0000\fY\u0001\u0000\u0000\u0000\u000e"+
		"a\u0001\u0000\u0000\u0000\u0010k\u0001\u0000\u0000\u0000\u0012s\u0001"+
		"\u0000\u0000\u0000\u0014}\u0001\u0000\u0000\u0000\u0016\u0087\u0001\u0000"+
		"\u0000\u0000\u0018\u008d\u0001\u0000\u0000\u0000\u001a\u0093\u0001\u0000"+
		"\u0000\u0000\u001c\u0098\u0001\u0000\u0000\u0000\u001e\u00a6\u0001\u0000"+
		"\u0000\u0000 \u00a8\u0001\u0000\u0000\u0000\"\u00b0\u0001\u0000\u0000"+
		"\u0000$\u00b8\u0001\u0000\u0000\u0000&\u00c3\u0001\u0000\u0000\u0000("+
		"\u00c5\u0001\u0000\u0000\u0000*,\u0003\u0002\u0001\u0000+-\u0005\u001a"+
		"\u0000\u0000,+\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-/\u0001"+
		"\u0000\u0000\u0000.*\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u0000"+
		"0.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000013\u0001\u0000\u0000"+
		"\u000020\u0001\u0000\u0000\u000034\u0005\u0000\u0000\u00014\u0001\u0001"+
		"\u0000\u0000\u000058\u0003\u0004\u0002\u000068\u0003\u0006\u0003\u0000"+
		"75\u0001\u0000\u0000\u000076\u0001\u0000\u0000\u00008\u0003\u0001\u0000"+
		"\u0000\u00009:\u0003(\u0014\u0000:;\u0005\u0017\u0000\u0000;<\u0005\u0001"+
		"\u0000\u0000<=\u0003\u001c\u000e\u0000=>\u0005\u0002\u0000\u0000>\u0005"+
		"\u0001\u0000\u0000\u0000?J\u0003\b\u0004\u0000@J\u0003\n\u0005\u0000A"+
		"J\u0003\f\u0006\u0000BJ\u0003\u000e\u0007\u0000CJ\u0003\u0010\b\u0000"+
		"DJ\u0003\u0012\t\u0000EJ\u0003\u0014\n\u0000FJ\u0003\u0016\u000b\u0000"+
		"GJ\u0003\u0018\f\u0000HJ\u0003\u001a\r\u0000I?\u0001\u0000\u0000\u0000"+
		"I@\u0001\u0000\u0000\u0000IA\u0001\u0000\u0000\u0000IB\u0001\u0000\u0000"+
		"\u0000IC\u0001\u0000\u0000\u0000ID\u0001\u0000\u0000\u0000IE\u0001\u0000"+
		"\u0000\u0000IF\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IH\u0001"+
		"\u0000\u0000\u0000J\u0007\u0001\u0000\u0000\u0000KL\u0005\u0003\u0000"+
		"\u0000LM\u0005\u0004\u0000\u0000MN\u0005\u0018\u0000\u0000NO\u0005\u0005"+
		"\u0000\u0000OP\u0005\u0018\u0000\u0000PQ\u0005\u0006\u0000\u0000QR\u0005"+
		"\u0002\u0000\u0000R\t\u0001\u0000\u0000\u0000ST\u0005\u0007\u0000\u0000"+
		"TU\u0005\u0004\u0000\u0000UV\u0005\u0018\u0000\u0000VW\u0005\u0006\u0000"+
		"\u0000WX\u0005\u0002\u0000\u0000X\u000b\u0001\u0000\u0000\u0000YZ\u0005"+
		"\b\u0000\u0000Z[\u0005\u0004\u0000\u0000[\\\u0003 \u0010\u0000\\]\u0005"+
		"\u0005\u0000\u0000]^\u0005\u0018\u0000\u0000^_\u0005\u0006\u0000\u0000"+
		"_`\u0005\u0002\u0000\u0000`\r\u0001\u0000\u0000\u0000ab\u0005\b\u0000"+
		"\u0000bc\u0005\u0004\u0000\u0000cd\u0003\"\u0011\u0000de\u0005\u0005\u0000"+
		"\u0000ef\u0005\u0018\u0000\u0000fg\u0005\u0005\u0000\u0000gh\u0005\u0019"+
		"\u0000\u0000hi\u0005\u0006\u0000\u0000ij\u0005\u0002\u0000\u0000j\u000f"+
		"\u0001\u0000\u0000\u0000kl\u0005\t\u0000\u0000lm\u0005\u0004\u0000\u0000"+
		"mn\u0003$\u0012\u0000no\u0005\u0005\u0000\u0000op\u0005\u0018\u0000\u0000"+
		"pq\u0005\u0006\u0000\u0000qr\u0005\u0002\u0000\u0000r\u0011\u0001\u0000"+
		"\u0000\u0000st\u0005\n\u0000\u0000tu\u0005\u0004\u0000\u0000uv\u0003 "+
		"\u0010\u0000vw\u0005\u0005\u0000\u0000wx\u0005\u0018\u0000\u0000xy\u0005"+
		"\u0005\u0000\u0000yz\u0005\u0018\u0000\u0000z{\u0005\u0006\u0000\u0000"+
		"{|\u0005\u0002\u0000\u0000|\u0013\u0001\u0000\u0000\u0000}~\u0005\n\u0000"+
		"\u0000~\u007f\u0005\u0004\u0000\u0000\u007f\u0080\u0003 \u0010\u0000\u0080"+
		"\u0081\u0005\u0005\u0000\u0000\u0081\u0082\u0005\u0019\u0000\u0000\u0082"+
		"\u0083\u0005\u0005\u0000\u0000\u0083\u0084\u0005\u0018\u0000\u0000\u0084"+
		"\u0085\u0005\u0006\u0000\u0000\u0085\u0086\u0005\u0002\u0000\u0000\u0086"+
		"\u0015\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u000b\u0000\u0000\u0088"+
		"\u0089\u0005\u0004\u0000\u0000\u0089\u008a\u0005\u0019\u0000\u0000\u008a"+
		"\u008b\u0005\u0006\u0000\u0000\u008b\u008c\u0005\u0002\u0000\u0000\u008c"+
		"\u0017\u0001\u0000\u0000\u0000\u008d\u008e\u0005\f\u0000\u0000\u008e\u008f"+
		"\u0005\u0004\u0000\u0000\u008f\u0090\u0003&\u0013\u0000\u0090\u0091\u0005"+
		"\u0006\u0000\u0000\u0091\u0092\u0005\u0002\u0000\u0000\u0092\u0019\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0005\r\u0000\u0000\u0094\u0095\u0005\u0004"+
		"\u0000\u0000\u0095\u0096\u0005\u0006\u0000\u0000\u0096\u0097\u0005\u0002"+
		"\u0000\u0000\u0097\u001b\u0001\u0000\u0000\u0000\u0098\u009d\u0003\u001e"+
		"\u000f\u0000\u0099\u009a\u0007\u0000\u0000\u0000\u009a\u009c\u0003\u001e"+
		"\u000f\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u009f\u0001\u0000"+
		"\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000"+
		"\u0000\u0000\u009e\u001d\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a7\u0003 \u0010\u0000\u00a1\u00a7\u0003\"\u0011"+
		"\u0000\u00a2\u00a7\u0005\u0018\u0000\u0000\u00a3\u00a7\u0005\u0019\u0000"+
		"\u0000\u00a4\u00a7\u0005\u0017\u0000\u0000\u00a5\u00a7\u0005\u0010\u0000"+
		"\u0000\u00a6\u00a0\u0001\u0000\u0000\u0000\u00a6\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a2\u0001\u0000\u0000\u0000\u00a6\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a7\u001f\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\u0004\u0000"+
		"\u0000\u00a9\u00aa\u0005\u0018\u0000\u0000\u00aa\u00ab\u0005\u0005\u0000"+
		"\u0000\u00ab\u00ac\u0005\u0018\u0000\u0000\u00ac\u00ad\u0005\u0005\u0000"+
		"\u0000\u00ad\u00ae\u0005\u0018\u0000\u0000\u00ae\u00af\u0005\u0006\u0000"+
		"\u0000\u00af!\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u0004\u0000\u0000"+
		"\u00b1\u00b2\u0005\u0018\u0000\u0000\u00b2\u00b3\u0005\u0005\u0000\u0000"+
		"\u00b3\u00b4\u0005\u0018\u0000\u0000\u00b4\u00b5\u0005\u0005\u0000\u0000"+
		"\u00b5\u00b6\u0005\u0018\u0000\u0000\u00b6\u00b7\u0005\u0006\u0000\u0000"+
		"\u00b7#\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\u0004\u0000\u0000\u00b9"+
		"\u00be\u0003 \u0010\u0000\u00ba\u00bb\u0005\u0005\u0000\u0000\u00bb\u00bd"+
		"\u0003 \u0010\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001"+
		"\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00be\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0005\u0006\u0000\u0000\u00c2%\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c4\u0005\u0017\u0000\u0000\u00c4\'\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0007\u0001\u0000\u0000\u00c6)\u0001\u0000\u0000\u0000"+
		"\u0007,07I\u009d\u00a6\u00be";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}