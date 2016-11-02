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
		NEQ=11, AND=12, OR=13, OPEN_PARENTHESES=14, CLOSE_PARENTHESES=15, INTEGER=16, 
		CHAR=17, STRING=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'"
	};
	public static final String[] ruleNames = {
		"PLUS", "MINUS", "MULT", "DIV", "MOD", "GT", "GTE", "LT", "LTE", "EQ", 
		"NEQ", "AND", "OR", "OPEN_PARENTHESES", "CLOSE_PARENTHESES", "DIGIT", 
		"INTEGER", "LETTER", "ESCCHAR", "CHAR", "STRING"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24l\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\6\22U\n\22\r\22\16\22V\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\5"+
		"\25b\n\25\3\26\3\26\7\26f\n\26\f\26\16\26i\13\26\3\26\3\26\2\2\27\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\2#\22%\2\'\2)\23+\24\3\2\4\5\2C\\aac|\b\2\2\2\n\f\16\17$$))^^k\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2#\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\61\3\2\2\2\t\63\3\2\2\2\13\65\3\2\2"+
		"\2\r\67\3\2\2\2\179\3\2\2\2\21<\3\2\2\2\23>\3\2\2\2\25A\3\2\2\2\27D\3"+
		"\2\2\2\31G\3\2\2\2\33J\3\2\2\2\35M\3\2\2\2\37O\3\2\2\2!Q\3\2\2\2#T\3\2"+
		"\2\2%X\3\2\2\2\'Z\3\2\2\2)a\3\2\2\2+c\3\2\2\2-.\7-\2\2.\4\3\2\2\2/\60"+
		"\7/\2\2\60\6\3\2\2\2\61\62\7,\2\2\62\b\3\2\2\2\63\64\7\61\2\2\64\n\3\2"+
		"\2\2\65\66\7\'\2\2\66\f\3\2\2\2\678\7@\2\28\16\3\2\2\29:\7@\2\2:;\7?\2"+
		"\2;\20\3\2\2\2<=\7>\2\2=\22\3\2\2\2>?\7>\2\2?@\7?\2\2@\24\3\2\2\2AB\7"+
		"?\2\2BC\7?\2\2C\26\3\2\2\2DE\7#\2\2EF\7?\2\2F\30\3\2\2\2GH\7(\2\2HI\7"+
		"(\2\2I\32\3\2\2\2JK\7~\2\2KL\7~\2\2L\34\3\2\2\2MN\7*\2\2N\36\3\2\2\2O"+
		"P\7+\2\2P \3\2\2\2QR\4\62;\2R\"\3\2\2\2SU\5!\21\2TS\3\2\2\2UV\3\2\2\2"+
		"VT\3\2\2\2VW\3\2\2\2W$\3\2\2\2XY\t\2\2\2Y&\3\2\2\2Z[\t\3\2\2[(\3\2\2\2"+
		"\\]\7)\2\2]^\5%\23\2^_\7)\2\2_b\3\2\2\2`b\5\'\24\2a\\\3\2\2\2a`\3\2\2"+
		"\2b*\3\2\2\2cg\7$\2\2df\5%\23\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2"+
		"\2hj\3\2\2\2ig\3\2\2\2jk\7$\2\2k,\3\2\2\2\6\2Vag\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}