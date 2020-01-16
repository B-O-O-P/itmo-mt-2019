// Generated from D:/GitHub/B-O-O-P/itmo-mt-2019/04-parser-generator/src/main/java/ru/itmo/chizhikov/antlr\Grammar.g4 by ANTLR 4.7.2
package antlr.ru.itmo.chizhikov.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, NON_TERM=14, TERM=15, REGEX=16, 
		STRING=17, CODE=18, PCKG_NAME=19, WS=20;
	public static final int
		RULE_file = 0, RULE_start = 1, RULE_pckg = 2, RULE_rulee = 3, RULE_parserRulee = 4, 
		RULE_inAttrs = 5, RULE_param = 6, RULE_paramType = 7, RULE_paramName = 8, 
		RULE_outAttr = 9, RULE_prods = 10, RULE_prod = 11, RULE_args = 12, RULE_arg = 13, 
		RULE_lexerRulee = 14, RULE_term_value = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "start", "pckg", "rulee", "parserRulee", "inAttrs", "param", 
			"paramType", "paramName", "outAttr", "prods", "prod", "args", "arg", 
			"lexerRulee", "term_value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'|>'", "'+package'", "';'", "':'", "':='", "'|'", "'<'", "','", 
			"'>'", "'('", "')'", "'='", "'=>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "NON_TERM", "TERM", "REGEX", "STRING", "CODE", "PCKG_NAME", 
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public PckgContext pckg() {
			return getRuleContext(PckgContext.class,0);
		}
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public List<RuleeContext> rulee() {
			return getRuleContexts(RuleeContext.class);
		}
		public RuleeContext rulee(int i) {
			return getRuleContext(RuleeContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(32);
				pckg();
				}
			}

			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(35);
				start();
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(36);
					rulee();
					}
					}
					setState(39); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NON_TERM || _la==TERM );
				}
			}

			setState(43);
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

	public static class StartContext extends ParserRuleContext {
		public TerminalNode NON_TERM() { return getToken(GrammarParser.NON_TERM, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__0);
			setState(46);
			match(NON_TERM);
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

	public static class PckgContext extends ParserRuleContext {
		public TerminalNode PCKG_NAME() { return getToken(GrammarParser.PCKG_NAME, 0); }
		public PckgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pckg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPckg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPckg(this);
		}
	}

	public final PckgContext pckg() throws RecognitionException {
		PckgContext _localctx = new PckgContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pckg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__1);
			setState(49);
			match(PCKG_NAME);
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

	public static class RuleeContext extends ParserRuleContext {
		public ParserRuleeContext parserRulee() {
			return getRuleContext(ParserRuleeContext.class,0);
		}
		public LexerRuleeContext lexerRulee() {
			return getRuleContext(LexerRuleeContext.class,0);
		}
		public RuleeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulee; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRulee(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRulee(this);
		}
	}

	public final RuleeContext rulee() throws RecognitionException {
		RuleeContext _localctx = new RuleeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rulee);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_TERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				parserRulee();
				setState(52);
				match(T__2);
				}
				break;
			case TERM:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				lexerRulee();
				setState(55);
				match(T__2);
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

	public static class ParserRuleeContext extends ParserRuleContext {
		public TerminalNode NON_TERM() { return getToken(GrammarParser.NON_TERM, 0); }
		public List<ProdsContext> prods() {
			return getRuleContexts(ProdsContext.class);
		}
		public ProdsContext prods(int i) {
			return getRuleContext(ProdsContext.class,i);
		}
		public InAttrsContext inAttrs() {
			return getRuleContext(InAttrsContext.class,0);
		}
		public OutAttrContext outAttr() {
			return getRuleContext(OutAttrContext.class,0);
		}
		public ParserRuleeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRulee; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParserRulee(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParserRulee(this);
		}
	}

	public final ParserRuleeContext parserRulee() throws RecognitionException {
		ParserRuleeContext _localctx = new ParserRuleeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parserRulee);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(NON_TERM);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(60);
				inAttrs();
				}
			}

			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(63);
				match(T__3);
				setState(64);
				outAttr();
				}
			}

			setState(67);
			match(T__4);
			setState(68);
			prods();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(69);
				match(T__5);
				setState(70);
				prods();
				}
				}
				setState(75);
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

	public static class InAttrsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public InAttrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inAttrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterInAttrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitInAttrs(this);
		}
	}

	public final InAttrsContext inAttrs() throws RecognitionException {
		InAttrsContext _localctx = new InAttrsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_inAttrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__6);
			setState(77);
			param();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(78);
				match(T__7);
				setState(79);
				param();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(T__8);
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

	public static class ParamContext extends ParserRuleContext {
		public ParamNameContext paramName() {
			return getRuleContext(ParamNameContext.class,0);
		}
		public ParamTypeContext paramType() {
			return getRuleContext(ParamTypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			paramName();
			setState(88);
			match(T__3);
			setState(89);
			paramType();
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

	public static class ParamTypeContext extends ParserRuleContext {
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public ParamTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParamType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParamType(this);
		}
	}

	public final ParamTypeContext paramType() throws RecognitionException {
		ParamTypeContext _localctx = new ParamTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_paramType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(TERM);
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

	public static class ParamNameContext extends ParserRuleContext {
		public TerminalNode NON_TERM() { return getToken(GrammarParser.NON_TERM, 0); }
		public ParamNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParamName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParamName(this);
		}
	}

	public final ParamNameContext paramName() throws RecognitionException {
		ParamNameContext _localctx = new ParamNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_paramName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(NON_TERM);
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

	public static class OutAttrContext extends ParserRuleContext {
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public OutAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outAttr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOutAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOutAttr(this);
		}
	}

	public final OutAttrContext outAttr() throws RecognitionException {
		OutAttrContext _localctx = new OutAttrContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_outAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(TERM);
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

	public static class ProdsContext extends ParserRuleContext {
		public List<ProdContext> prod() {
			return getRuleContexts(ProdContext.class);
		}
		public ProdContext prod(int i) {
			return getRuleContext(ProdContext.class,i);
		}
		public ProdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prods; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProds(this);
		}
	}

	public final ProdsContext prods() throws RecognitionException {
		ProdsContext _localctx = new ProdsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_prods);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NON_TERM) | (1L << TERM) | (1L << CODE))) != 0)) {
				{
				{
				setState(97);
				prod();
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

	public static class ProdContext extends ParserRuleContext {
		public TerminalNode NON_TERM() { return getToken(GrammarParser.NON_TERM, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public ProdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProd(this);
		}
	}

	public final ProdContext prod() throws RecognitionException {
		ProdContext _localctx = new ProdContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_prod);
		int _la;
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_TERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(NON_TERM);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(104);
					args();
					}
				}

				}
				break;
			case TERM:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(TERM);
				}
				break;
			case CODE:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				match(CODE);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__9);
			setState(112);
			arg();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(113);
				match(T__7);
				setState(114);
				arg();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
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

	public static class ArgContext extends ParserRuleContext {
		public TerminalNode NON_TERM() { return getToken(GrammarParser.NON_TERM, 0); }
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NON_TERM) | (1L << TERM) | (1L << CODE))) != 0)) ) {
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

	public static class LexerRuleeContext extends ParserRuleContext {
		public LexerRuleeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRulee; }
	 
		public LexerRuleeContext() { }
		public void copyFrom(LexerRuleeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TokenRuleContext extends LexerRuleeContext {
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public Term_valueContext term_value() {
			return getRuleContext(Term_valueContext.class,0);
		}
		public TokenRuleContext(LexerRuleeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTokenRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTokenRule(this);
		}
	}
	public static class SkipRuleContext extends LexerRuleeContext {
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public Term_valueContext term_value() {
			return getRuleContext(Term_valueContext.class,0);
		}
		public SkipRuleContext(LexerRuleeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSkipRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSkipRule(this);
		}
	}

	public final LexerRuleeContext lexerRulee() throws RecognitionException {
		LexerRuleeContext _localctx = new LexerRuleeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_lexerRulee);
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new TokenRuleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(TERM);
				setState(125);
				match(T__11);
				setState(126);
				term_value();
				}
				break;
			case 2:
				_localctx = new SkipRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(TERM);
				setState(128);
				match(T__12);
				setState(129);
				term_value();
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

	public static class Term_valueContext extends ParserRuleContext {
		public TerminalNode REGEX() { return getToken(GrammarParser.REGEX, 0); }
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public Term_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTerm_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTerm_value(this);
		}
	}

	public final Term_valueContext term_value() throws RecognitionException {
		Term_valueContext _localctx = new Term_valueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_term_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !(_la==REGEX || _la==STRING) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u0089\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\5\2"+
		"$\n\2\3\2\3\2\6\2(\n\2\r\2\16\2)\5\2,\n\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5<\n\5\3\6\3\6\5\6@\n\6\3\6\3\6\5\6D\n"+
		"\6\3\6\3\6\3\6\3\6\7\6J\n\6\f\6\16\6M\13\6\3\7\3\7\3\7\3\7\7\7S\n\7\f"+
		"\7\16\7V\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\7"+
		"\fe\n\f\f\f\16\fh\13\f\3\r\3\r\5\rl\n\r\3\r\3\r\5\rp\n\r\3\16\3\16\3\16"+
		"\3\16\7\16v\n\16\f\16\16\16y\13\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u0085\n\20\3\21\3\21\3\21\2\2\22\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \2\4\4\2\20\21\24\24\3\2\22\23\2\u0086\2#\3\2\2"+
		"\2\4/\3\2\2\2\6\62\3\2\2\2\b;\3\2\2\2\n=\3\2\2\2\fN\3\2\2\2\16Y\3\2\2"+
		"\2\20]\3\2\2\2\22_\3\2\2\2\24a\3\2\2\2\26f\3\2\2\2\30o\3\2\2\2\32q\3\2"+
		"\2\2\34|\3\2\2\2\36\u0084\3\2\2\2 \u0086\3\2\2\2\"$\5\6\4\2#\"\3\2\2\2"+
		"#$\3\2\2\2$+\3\2\2\2%\'\5\4\3\2&(\5\b\5\2\'&\3\2\2\2()\3\2\2\2)\'\3\2"+
		"\2\2)*\3\2\2\2*,\3\2\2\2+%\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\2\2\3.\3\3"+
		"\2\2\2/\60\7\3\2\2\60\61\7\20\2\2\61\5\3\2\2\2\62\63\7\4\2\2\63\64\7\25"+
		"\2\2\64\7\3\2\2\2\65\66\5\n\6\2\66\67\7\5\2\2\67<\3\2\2\289\5\36\20\2"+
		"9:\7\5\2\2:<\3\2\2\2;\65\3\2\2\2;8\3\2\2\2<\t\3\2\2\2=?\7\20\2\2>@\5\f"+
		"\7\2?>\3\2\2\2?@\3\2\2\2@C\3\2\2\2AB\7\6\2\2BD\5\24\13\2CA\3\2\2\2CD\3"+
		"\2\2\2DE\3\2\2\2EF\7\7\2\2FK\5\26\f\2GH\7\b\2\2HJ\5\26\f\2IG\3\2\2\2J"+
		"M\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\13\3\2\2\2MK\3\2\2\2NO\7\t\2\2OT\5\16\b"+
		"\2PQ\7\n\2\2QS\5\16\b\2RP\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2"+
		"\2\2VT\3\2\2\2WX\7\13\2\2X\r\3\2\2\2YZ\5\22\n\2Z[\7\6\2\2[\\\5\20\t\2"+
		"\\\17\3\2\2\2]^\7\21\2\2^\21\3\2\2\2_`\7\20\2\2`\23\3\2\2\2ab\7\21\2\2"+
		"b\25\3\2\2\2ce\5\30\r\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\27\3"+
		"\2\2\2hf\3\2\2\2ik\7\20\2\2jl\5\32\16\2kj\3\2\2\2kl\3\2\2\2lp\3\2\2\2"+
		"mp\7\21\2\2np\7\24\2\2oi\3\2\2\2om\3\2\2\2on\3\2\2\2p\31\3\2\2\2qr\7\f"+
		"\2\2rw\5\34\17\2st\7\n\2\2tv\5\34\17\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2w"+
		"x\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7\r\2\2{\33\3\2\2\2|}\t\2\2\2}\35\3\2"+
		"\2\2~\177\7\21\2\2\177\u0080\7\16\2\2\u0080\u0085\5 \21\2\u0081\u0082"+
		"\7\21\2\2\u0082\u0083\7\17\2\2\u0083\u0085\5 \21\2\u0084~\3\2\2\2\u0084"+
		"\u0081\3\2\2\2\u0085\37\3\2\2\2\u0086\u0087\t\3\2\2\u0087!\3\2\2\2\17"+
		"#)+;?CKTfkow\u0084";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}