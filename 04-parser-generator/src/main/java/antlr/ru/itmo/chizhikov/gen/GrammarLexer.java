// Generated from D:/GitHub/B-O-O-P/itmo-mt-2019/04-parser-generator/src/main/java/ru/itmo/chizhikov/antlr\Grammar.g4 by ANTLR 4.7.2
package antlr.ru.itmo.chizhikov.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, NON_TERM=14, TERM=15, REGEX=16, 
		STRING=17, CODE=18, PCKG_NAME=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "NON_TERM", "TERM", "REGEX", "STRING", 
			"CODE", "PCKG_NAME", "WS"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u008f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\7\17R\n\17\f\17"+
		"\16\17U\13\17\3\20\3\20\7\20Y\n\20\f\20\16\20\\\13\20\3\21\3\21\3\21\3"+
		"\21\7\21b\n\21\f\21\16\21e\13\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22m\n"+
		"\22\f\22\16\22p\13\22\3\22\3\22\3\23\3\23\6\23v\n\23\r\23\16\23w\3\23"+
		"\5\23{\n\23\7\23}\n\23\f\23\16\23\u0080\13\23\3\23\3\23\3\24\6\24\u0085"+
		"\n\24\r\24\16\24\u0086\3\25\6\25\u008a\n\25\r\25\16\25\u008b\3\25\3\25"+
		"\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26\3\2\n\3\2c|\5\2\62;C\\c|\3\2C\\\5\2"+
		"\f\f\17\17))\3\2$$\4\2}}\177\177\5\2\60\60\62;c|\5\2\13\f\17\17\"\"\2"+
		"\u0099\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5.\3\2\2\2\7"+
		"\67\3\2\2\2\t9\3\2\2\2\13;\3\2\2\2\r>\3\2\2\2\17@\3\2\2\2\21B\3\2\2\2"+
		"\23D\3\2\2\2\25F\3\2\2\2\27H\3\2\2\2\31J\3\2\2\2\33L\3\2\2\2\35O\3\2\2"+
		"\2\37V\3\2\2\2!]\3\2\2\2#h\3\2\2\2%s\3\2\2\2\'\u0084\3\2\2\2)\u0089\3"+
		"\2\2\2+,\7~\2\2,-\7@\2\2-\4\3\2\2\2./\7-\2\2/\60\7r\2\2\60\61\7c\2\2\61"+
		"\62\7e\2\2\62\63\7m\2\2\63\64\7c\2\2\64\65\7i\2\2\65\66\7g\2\2\66\6\3"+
		"\2\2\2\678\7=\2\28\b\3\2\2\29:\7<\2\2:\n\3\2\2\2;<\7<\2\2<=\7?\2\2=\f"+
		"\3\2\2\2>?\7~\2\2?\16\3\2\2\2@A\7>\2\2A\20\3\2\2\2BC\7.\2\2C\22\3\2\2"+
		"\2DE\7@\2\2E\24\3\2\2\2FG\7*\2\2G\26\3\2\2\2HI\7+\2\2I\30\3\2\2\2JK\7"+
		"?\2\2K\32\3\2\2\2LM\7?\2\2MN\7@\2\2N\34\3\2\2\2OS\t\2\2\2PR\t\3\2\2QP"+
		"\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\36\3\2\2\2US\3\2\2\2VZ\t\4\2\2"+
		"WY\t\3\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[ \3\2\2\2\\Z\3\2\2"+
		"\2]c\7)\2\2^b\n\5\2\2_`\7^\2\2`b\7)\2\2a^\3\2\2\2a_\3\2\2\2be\3\2\2\2"+
		"ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7)\2\2g\"\3\2\2\2hn\7$\2\2"+
		"im\n\6\2\2jk\7^\2\2km\7$\2\2li\3\2\2\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2n"+
		"o\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7$\2\2r$\3\2\2\2s~\7}\2\2tv\n\7\2\2ut"+
		"\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2y{\5%\23\2zy\3\2\2\2z"+
		"{\3\2\2\2{}\3\2\2\2|u\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177"+
		"\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\177\2\2\u0082&\3\2\2\2\u0083"+
		"\u0085\t\b\2\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087(\3\2\2\2\u0088\u008a\t\t\2\2\u0089\u0088"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008e\b\25\2\2\u008e*\3\2\2\2\17\2SZaclnwz~\u0084"+
		"\u0086\u008b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}