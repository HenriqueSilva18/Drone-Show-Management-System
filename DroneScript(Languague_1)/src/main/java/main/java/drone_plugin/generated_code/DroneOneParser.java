// Generated from DroneOne.g4 by ANTLR 4.13.0
package main.java.drone_plugin.generated_code;
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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, ID=23, FLOAT=24, INT=25, 
		NEWLINE=26, WS=27;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_variableDeclaration = 2, RULE_command = 3, 
		RULE_takeoff = 4, RULE_land = 5, RULE_movePosition = 6, RULE_moveVector = 7, 
		RULE_movePath = 8, RULE_hoover = 9, RULE_lightsOn = 10, RULE_lightsOff = 11, 
		RULE_blink = 12, RULE_expression = 13, RULE_value = 14, RULE_position = 15, 
		RULE_vector = 16, RULE_positionArray = 17, RULE_type = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "variableDeclaration", "command", "takeoff", 
			"land", "movePosition", "moveVector", "movePath", "hoover", "lightsOn", 
			"lightsOff", "blink", "expression", "value", "position", "vector", "positionArray", 
			"type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'takeOff'", "'('", "','", "')'", "'land'", "'move'", 
			"'movePath'", "'hoover'", "'lightsOn'", "'lightsOff'", "'blink'", "'-'", 
			"'+'", "'PI'", "'Position'", "'Vector'", "'LinearVelocity'", "'AngularVelocity'", 
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
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8273800L) != 0)) {
				{
				{
				setState(38);
				statement();
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(39);
					match(NEWLINE);
					}
				}

				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
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
			setState(51);
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
				setState(49);
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
				setState(50);
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
		enterRule(_localctx, 4, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			type();
			setState(54);
			match(ID);
			setState(55);
			match(T__0);
			setState(56);
			expression();
			setState(57);
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
		enterRule(_localctx, 6, RULE_command);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				takeoff();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				land();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				movePosition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				moveVector();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				movePath();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				hoover();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(65);
				lightsOn();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(66);
				lightsOff();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(67);
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
		enterRule(_localctx, 8, RULE_takeoff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__2);
			setState(71);
			match(T__3);
			setState(72);
			match(FLOAT);
			setState(73);
			match(T__4);
			setState(74);
			match(FLOAT);
			setState(75);
			match(T__5);
			setState(76);
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
		enterRule(_localctx, 10, RULE_land);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__6);
			setState(79);
			match(T__3);
			setState(80);
			match(FLOAT);
			setState(81);
			match(T__5);
			setState(82);
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
		enterRule(_localctx, 12, RULE_movePosition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__7);
			setState(85);
			match(T__3);
			setState(86);
			position();
			setState(87);
			match(T__4);
			setState(88);
			match(FLOAT);
			setState(89);
			match(T__5);
			setState(90);
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
		enterRule(_localctx, 14, RULE_moveVector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__7);
			setState(93);
			match(T__3);
			setState(94);
			vector();
			setState(95);
			match(T__4);
			setState(96);
			match(FLOAT);
			setState(97);
			match(T__4);
			setState(98);
			match(INT);
			setState(99);
			match(T__5);
			setState(100);
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
		enterRule(_localctx, 16, RULE_movePath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__8);
			setState(103);
			match(T__3);
			setState(104);
			positionArray();
			setState(105);
			match(T__4);
			setState(106);
			match(FLOAT);
			setState(107);
			match(T__5);
			setState(108);
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
		enterRule(_localctx, 18, RULE_hoover);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__9);
			setState(111);
			match(T__3);
			setState(112);
			match(INT);
			setState(113);
			match(T__5);
			setState(114);
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
		enterRule(_localctx, 20, RULE_lightsOn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__10);
			setState(117);
			match(T__3);
			setState(118);
			match(T__5);
			setState(119);
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
		enterRule(_localctx, 22, RULE_lightsOff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__11);
			setState(122);
			match(T__3);
			setState(123);
			match(T__5);
			setState(124);
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
		enterRule(_localctx, 24, RULE_blink);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__12);
			setState(127);
			match(T__3);
			setState(128);
			match(INT);
			setState(129);
			match(T__5);
			setState(130);
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
		enterRule(_localctx, 26, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			value();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13 || _la==T__14) {
				{
				{
				setState(133);
				_la = _input.LA(1);
				if ( !(_la==T__13 || _la==T__14) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(134);
				value();
				}
				}
				setState(139);
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
		enterRule(_localctx, 28, RULE_value);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				position();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				vector();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(FLOAT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(INT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				match(ID);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(145);
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
		enterRule(_localctx, 30, RULE_position);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__3);
			setState(149);
			match(FLOAT);
			setState(150);
			match(T__4);
			setState(151);
			match(FLOAT);
			setState(152);
			match(T__4);
			setState(153);
			match(FLOAT);
			setState(154);
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
		enterRule(_localctx, 32, RULE_vector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__3);
			setState(157);
			match(FLOAT);
			setState(158);
			match(T__4);
			setState(159);
			match(FLOAT);
			setState(160);
			match(T__4);
			setState(161);
			match(FLOAT);
			setState(162);
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
		enterRule(_localctx, 34, RULE_positionArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(T__3);
			setState(165);
			position();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(166);
				match(T__4);
				setState(167);
				position();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173);
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
		enterRule(_localctx, 36, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
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
		"\u0004\u0001\u001b\u00b2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0001\u0000\u0001\u0000\u0003\u0000)\b\u0000\u0005\u0000+\b\u0000"+
		"\n\u0000\f\u0000.\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0003\u00014\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"E\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\r\u0005\r\u0088\b\r\n\r\f\r\u008b\t\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0093\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00a9\b\u0011\n"+
		"\u0011\f\u0011\u00ac\t\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0000\u0000\u0013\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$\u0000\u0002\u0001"+
		"\u0000\u000e\u000f\u0001\u0000\u0011\u0016\u00b0\u0000,\u0001\u0000\u0000"+
		"\u0000\u00023\u0001\u0000\u0000\u0000\u00045\u0001\u0000\u0000\u0000\u0006"+
		"D\u0001\u0000\u0000\u0000\bF\u0001\u0000\u0000\u0000\nN\u0001\u0000\u0000"+
		"\u0000\fT\u0001\u0000\u0000\u0000\u000e\\\u0001\u0000\u0000\u0000\u0010"+
		"f\u0001\u0000\u0000\u0000\u0012n\u0001\u0000\u0000\u0000\u0014t\u0001"+
		"\u0000\u0000\u0000\u0016y\u0001\u0000\u0000\u0000\u0018~\u0001\u0000\u0000"+
		"\u0000\u001a\u0084\u0001\u0000\u0000\u0000\u001c\u0092\u0001\u0000\u0000"+
		"\u0000\u001e\u0094\u0001\u0000\u0000\u0000 \u009c\u0001\u0000\u0000\u0000"+
		"\"\u00a4\u0001\u0000\u0000\u0000$\u00af\u0001\u0000\u0000\u0000&(\u0003"+
		"\u0002\u0001\u0000\')\u0005\u001a\u0000\u0000(\'\u0001\u0000\u0000\u0000"+
		"()\u0001\u0000\u0000\u0000)+\u0001\u0000\u0000\u0000*&\u0001\u0000\u0000"+
		"\u0000+.\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000"+
		"\u0000\u0000-/\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000/0\u0005"+
		"\u0000\u0000\u00010\u0001\u0001\u0000\u0000\u000014\u0003\u0004\u0002"+
		"\u000024\u0003\u0006\u0003\u000031\u0001\u0000\u0000\u000032\u0001\u0000"+
		"\u0000\u00004\u0003\u0001\u0000\u0000\u000056\u0003$\u0012\u000067\u0005"+
		"\u0017\u0000\u000078\u0005\u0001\u0000\u000089\u0003\u001a\r\u00009:\u0005"+
		"\u0002\u0000\u0000:\u0005\u0001\u0000\u0000\u0000;E\u0003\b\u0004\u0000"+
		"<E\u0003\n\u0005\u0000=E\u0003\f\u0006\u0000>E\u0003\u000e\u0007\u0000"+
		"?E\u0003\u0010\b\u0000@E\u0003\u0012\t\u0000AE\u0003\u0014\n\u0000BE\u0003"+
		"\u0016\u000b\u0000CE\u0003\u0018\f\u0000D;\u0001\u0000\u0000\u0000D<\u0001"+
		"\u0000\u0000\u0000D=\u0001\u0000\u0000\u0000D>\u0001\u0000\u0000\u0000"+
		"D?\u0001\u0000\u0000\u0000D@\u0001\u0000\u0000\u0000DA\u0001\u0000\u0000"+
		"\u0000DB\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000E\u0007\u0001"+
		"\u0000\u0000\u0000FG\u0005\u0003\u0000\u0000GH\u0005\u0004\u0000\u0000"+
		"HI\u0005\u0018\u0000\u0000IJ\u0005\u0005\u0000\u0000JK\u0005\u0018\u0000"+
		"\u0000KL\u0005\u0006\u0000\u0000LM\u0005\u0002\u0000\u0000M\t\u0001\u0000"+
		"\u0000\u0000NO\u0005\u0007\u0000\u0000OP\u0005\u0004\u0000\u0000PQ\u0005"+
		"\u0018\u0000\u0000QR\u0005\u0006\u0000\u0000RS\u0005\u0002\u0000\u0000"+
		"S\u000b\u0001\u0000\u0000\u0000TU\u0005\b\u0000\u0000UV\u0005\u0004\u0000"+
		"\u0000VW\u0003\u001e\u000f\u0000WX\u0005\u0005\u0000\u0000XY\u0005\u0018"+
		"\u0000\u0000YZ\u0005\u0006\u0000\u0000Z[\u0005\u0002\u0000\u0000[\r\u0001"+
		"\u0000\u0000\u0000\\]\u0005\b\u0000\u0000]^\u0005\u0004\u0000\u0000^_"+
		"\u0003 \u0010\u0000_`\u0005\u0005\u0000\u0000`a\u0005\u0018\u0000\u0000"+
		"ab\u0005\u0005\u0000\u0000bc\u0005\u0019\u0000\u0000cd\u0005\u0006\u0000"+
		"\u0000de\u0005\u0002\u0000\u0000e\u000f\u0001\u0000\u0000\u0000fg\u0005"+
		"\t\u0000\u0000gh\u0005\u0004\u0000\u0000hi\u0003\"\u0011\u0000ij\u0005"+
		"\u0005\u0000\u0000jk\u0005\u0018\u0000\u0000kl\u0005\u0006\u0000\u0000"+
		"lm\u0005\u0002\u0000\u0000m\u0011\u0001\u0000\u0000\u0000no\u0005\n\u0000"+
		"\u0000op\u0005\u0004\u0000\u0000pq\u0005\u0019\u0000\u0000qr\u0005\u0006"+
		"\u0000\u0000rs\u0005\u0002\u0000\u0000s\u0013\u0001\u0000\u0000\u0000"+
		"tu\u0005\u000b\u0000\u0000uv\u0005\u0004\u0000\u0000vw\u0005\u0006\u0000"+
		"\u0000wx\u0005\u0002\u0000\u0000x\u0015\u0001\u0000\u0000\u0000yz\u0005"+
		"\f\u0000\u0000z{\u0005\u0004\u0000\u0000{|\u0005\u0006\u0000\u0000|}\u0005"+
		"\u0002\u0000\u0000}\u0017\u0001\u0000\u0000\u0000~\u007f\u0005\r\u0000"+
		"\u0000\u007f\u0080\u0005\u0004\u0000\u0000\u0080\u0081\u0005\u0019\u0000"+
		"\u0000\u0081\u0082\u0005\u0006\u0000\u0000\u0082\u0083\u0005\u0002\u0000"+
		"\u0000\u0083\u0019\u0001\u0000\u0000\u0000\u0084\u0089\u0003\u001c\u000e"+
		"\u0000\u0085\u0086\u0007\u0000\u0000\u0000\u0086\u0088\u0003\u001c\u000e"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u008b\u0001\u0000\u0000"+
		"\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000"+
		"\u0000\u008a\u001b\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000"+
		"\u0000\u008c\u0093\u0003\u001e\u000f\u0000\u008d\u0093\u0003 \u0010\u0000"+
		"\u008e\u0093\u0005\u0018\u0000\u0000\u008f\u0093\u0005\u0019\u0000\u0000"+
		"\u0090\u0093\u0005\u0017\u0000\u0000\u0091\u0093\u0005\u0010\u0000\u0000"+
		"\u0092\u008c\u0001\u0000\u0000\u0000\u0092\u008d\u0001\u0000\u0000\u0000"+
		"\u0092\u008e\u0001\u0000\u0000\u0000\u0092\u008f\u0001\u0000\u0000\u0000"+
		"\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000"+
		"\u0093\u001d\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u0004\u0000\u0000"+
		"\u0095\u0096\u0005\u0018\u0000\u0000\u0096\u0097\u0005\u0005\u0000\u0000"+
		"\u0097\u0098\u0005\u0018\u0000\u0000\u0098\u0099\u0005\u0005\u0000\u0000"+
		"\u0099\u009a\u0005\u0018\u0000\u0000\u009a\u009b\u0005\u0006\u0000\u0000"+
		"\u009b\u001f\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u0004\u0000\u0000"+
		"\u009d\u009e\u0005\u0018\u0000\u0000\u009e\u009f\u0005\u0005\u0000\u0000"+
		"\u009f\u00a0\u0005\u0018\u0000\u0000\u00a0\u00a1\u0005\u0005\u0000\u0000"+
		"\u00a1\u00a2\u0005\u0018\u0000\u0000\u00a2\u00a3\u0005\u0006\u0000\u0000"+
		"\u00a3!\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005\u0004\u0000\u0000\u00a5"+
		"\u00aa\u0003\u001e\u000f\u0000\u00a6\u00a7\u0005\u0005\u0000\u0000\u00a7"+
		"\u00a9\u0003\u001e\u000f\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0006\u0000\u0000\u00ae"+
		"#\u0001\u0000\u0000\u0000\u00af\u00b0\u0007\u0001\u0000\u0000\u00b0%\u0001"+
		"\u0000\u0000\u0000\u0007(,3D\u0089\u0092\u00aa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}