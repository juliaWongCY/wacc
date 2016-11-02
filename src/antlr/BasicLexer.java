// Generated from ./BasicLexer.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MINUS=2, MULT=3, DIV=4, MOD=5, GT=6, GTE=7, LT=8, LTE=9, EQ=10, 
		NEQ=11, AND=12, OR=13, NOT=14, NEG=15, LEN=16, ORD=17, CHR=18, IDENT=19, 
		OPEN_PARENTHESES=20, CLOSE_PARENTHESES=21, OPEN_SQPARENTHESES=22, CLOSE_SQPARENTHESES=23, 
		INTEGER=24, CHAR=25, STRING=26, BOOL=27, PAIRLITER=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'"
	};
	public static final String[] ruleNames = {
		"PLUS", "MINUS", "MULT", "DIV", "MOD", "GT", "GTE", "LT", "LTE", "EQ", 
		"NEQ", "AND", "OR", "NOT", "NEG", "LEN", "ORD", "CHR", "IDENT", "OPEN_PARENTHESES", 
		"CLOSE_PARENTHESES", "OPEN_SQPARENTHESES", "CLOSE_SQPARENTHESES", "DIGIT", 
		"INTEGER", "LETTER", "ESCCHAR", "CHAR", "STRING", "BOOL", "PAIRLITER"
	};


	public BasicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BasicLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00ab\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\7\24t\n\24\f\24\16\24w\13\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\6\32\u0084\n\32\r\32\16\32\u0085\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\5\35\u0091\n\35\3\36\3\36\7\36"+
		"\u0095\n\36\f\36\16\36\u0098\13\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\5\37\u00a5\n\37\3 \3 \3 \3 \3 \2\2!\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\2\63\32\65\2\67\29\33;\34=\35?\36\3\2\6\5"+
		"\2C\\aac|\6\2\62;C\\aac|\6\2\"\"C\\aac|\b\2\2\2\n\f\16\17$$))^^\u00ac"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\63\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2"+
		"\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK\3\2\2\2\17M\3\2\2\2\21"+
		"P\3\2\2\2\23R\3\2\2\2\25U\3\2\2\2\27X\3\2\2\2\31[\3\2\2\2\33^\3\2\2\2"+
		"\35a\3\2\2\2\37c\3\2\2\2!e\3\2\2\2#i\3\2\2\2%m\3\2\2\2\'q\3\2\2\2)x\3"+
		"\2\2\2+z\3\2\2\2-|\3\2\2\2/~\3\2\2\2\61\u0080\3\2\2\2\63\u0083\3\2\2\2"+
		"\65\u0087\3\2\2\2\67\u0089\3\2\2\29\u0090\3\2\2\2;\u0092\3\2\2\2=\u00a4"+
		"\3\2\2\2?\u00a6\3\2\2\2AB\7-\2\2B\4\3\2\2\2CD\7/\2\2D\6\3\2\2\2EF\7,\2"+
		"\2F\b\3\2\2\2GH\7\61\2\2H\n\3\2\2\2IJ\7\'\2\2J\f\3\2\2\2KL\7@\2\2L\16"+
		"\3\2\2\2MN\7@\2\2NO\7?\2\2O\20\3\2\2\2PQ\7>\2\2Q\22\3\2\2\2RS\7>\2\2S"+
		"T\7?\2\2T\24\3\2\2\2UV\7?\2\2VW\7?\2\2W\26\3\2\2\2XY\7#\2\2YZ\7?\2\2Z"+
		"\30\3\2\2\2[\\\7(\2\2\\]\7(\2\2]\32\3\2\2\2^_\7~\2\2_`\7~\2\2`\34\3\2"+
		"\2\2ab\7#\2\2b\36\3\2\2\2cd\7/\2\2d \3\2\2\2ef\7n\2\2fg\7g\2\2gh\7p\2"+
		"\2h\"\3\2\2\2ij\7q\2\2jk\7t\2\2kl\7f\2\2l$\3\2\2\2mn\7e\2\2no\7j\2\2o"+
		"p\7t\2\2p&\3\2\2\2qu\t\2\2\2rt\t\3\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2u"+
		"v\3\2\2\2v(\3\2\2\2wu\3\2\2\2xy\7*\2\2y*\3\2\2\2z{\7+\2\2{,\3\2\2\2|}"+
		"\7]\2\2}.\3\2\2\2~\177\7_\2\2\177\60\3\2\2\2\u0080\u0081\4\62;\2\u0081"+
		"\62\3\2\2\2\u0082\u0084\5\61\31\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\64\3\2\2\2\u0087\u0088"+
		"\t\4\2\2\u0088\66\3\2\2\2\u0089\u008a\t\5\2\2\u008a8\3\2\2\2\u008b\u008c"+
		"\7)\2\2\u008c\u008d\5\65\33\2\u008d\u008e\7)\2\2\u008e\u0091\3\2\2\2\u008f"+
		"\u0091\5\67\34\2\u0090\u008b\3\2\2\2\u0090\u008f\3\2\2\2\u0091:\3\2\2"+
		"\2\u0092\u0096\7$\2\2\u0093\u0095\5\65\33\2\u0094\u0093\3\2\2\2\u0095"+
		"\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7$\2\2\u009a<\3\2\2\2\u009b\u009c"+
		"\7v\2\2\u009c\u009d\7t\2\2\u009d\u009e\7w\2\2\u009e\u00a5\7g\2\2\u009f"+
		"\u00a0\7h\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a3\7u\2\2"+
		"\u00a3\u00a5\7g\2\2\u00a4\u009b\3\2\2\2\u00a4\u009f\3\2\2\2\u00a5>\3\2"+
		"\2\2\u00a6\u00a7\7p\2\2\u00a7\u00a8\7w\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa"+
		"\7n\2\2\u00aa@\3\2\2\2\b\2u\u0085\u0090\u0096\u00a4\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}