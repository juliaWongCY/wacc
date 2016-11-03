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
		WS=1, ASSIGN=2, SEMICOLON=3, COMMA=4, COMMENT=5, NEWPAIR=6, FST=7, SND=8, 
		CALL=9, PAIR=10, BOOL=11, CHAR=12, STRING=13, INT=14, SKIP=15, READ=16, 
		FREE=17, RETURN=18, EXIT=19, PRINT=20, PRINTLN=21, IF=22, THEN=23, ELSE=24, 
		FI=25, WHILE=26, DO=27, DONE=28, BEGIN=29, END=30, IS=31, PLUS=32, MINUS=33, 
		MULT=34, DIV=35, MOD=36, GT=37, GTE=38, LT=39, LTE=40, EQ=41, NEQ=42, 
		AND=43, OR=44, NOT=45, NEG=46, LEN=47, ORD=48, CHR=49, OPEN_PARENTHESES=50, 
		CLOSE_PARENTHESES=51, OPEN_SQPARENTHESES=52, CLOSE_SQPARENTHESES=53, INTEGER=54, 
		CHARLITER=55, STRINGLITER=56, BOOLLITER=57, PAIRLITER=58, IDENT=59;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'"
	};
	public static final String[] ruleNames = {
		"WS", "ASSIGN", "SEMICOLON", "COMMA", "EOL", "COMMENTSYM", "COMMENT", 
		"NEWPAIR", "FST", "SND", "CALL", "PAIR", "BOOL", "CHAR", "STRING", "INT", 
		"SKIP", "READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", "IF", "THEN", 
		"ELSE", "FI", "WHILE", "DO", "DONE", "BEGIN", "END", "IS", "PLUS", "MINUS", 
		"MULT", "DIV", "MOD", "GT", "GTE", "LT", "LTE", "EQ", "NEQ", "AND", "OR", 
		"NOT", "NEG", "LEN", "ORD", "CHR", "OPEN_PARENTHESES", "CLOSE_PARENTHESES", 
		"OPEN_SQPARENTHESES", "CLOSE_SQPARENTHESES", "DIGIT", "SIGN", "INTEGER", 
		"LETTER", "ESCCHAR", "CHARLITER", "STRINGLITER", "BOOLLITER", "PAIRLITER", 
		"IDENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2=\u0192\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\6\2\u0087\n\2\r\2\16\2\u0088\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\6\b\u0099\n\b\r\b\16"+
		"\b\u009a\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3"+
		"\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3+\3+\3+\3"+
		",\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62"+
		"\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67"+
		"\3\67\38\38\39\39\3:\3:\3;\5;\u0161\n;\3;\6;\u0164\n;\r;\16;\u0165\3<"+
		"\3<\3=\3=\3>\3>\3>\3>\3>\5>\u0171\n>\3?\3?\7?\u0175\n?\f?\16?\u0178\13"+
		"?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3@\5@\u0185\n@\3A\3A\3A\3A\3A\3B\3B\7"+
		"B\u018e\nB\fB\16B\u0191\13B\3\u009a\2C\3\3\5\4\7\5\t\6\13\2\r\2\17\7\21"+
		"\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26"+
		"/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A C!E\"G#I$K%M&O\'Q(S)U*W"+
		"+Y,[-]._/a\60c\61e\62g\63i\64k\65m\66o\67q\2s\2u8w\2y\2{9}:\177;\u0081"+
		"<\u0083=\3\2\t\5\2\13\f\17\17\"\"\4\2\f\f\17\17\4\2--//\6\2\"\"C\\aac"+
		"|\b\2\2\2\n\f\16\17$$))^^\5\2C\\aac|\6\2\62;C\\aac|\u0193\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3"+
		"\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2"+
		"\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2u\3\2\2\2\2{\3\2\2\2\2"+
		"}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\3\u0086\3\2\2"+
		"\2\5\u008c\3\2\2\2\7\u008e\3\2\2\2\t\u0090\3\2\2\2\13\u0092\3\2\2\2\r"+
		"\u0094\3\2\2\2\17\u0096\3\2\2\2\21\u00a0\3\2\2\2\23\u00a8\3\2\2\2\25\u00ac"+
		"\3\2\2\2\27\u00b0\3\2\2\2\31\u00b5\3\2\2\2\33\u00ba\3\2\2\2\35\u00bf\3"+
		"\2\2\2\37\u00c4\3\2\2\2!\u00cb\3\2\2\2#\u00cf\3\2\2\2%\u00d4\3\2\2\2\'"+
		"\u00d9\3\2\2\2)\u00de\3\2\2\2+\u00e5\3\2\2\2-\u00ea\3\2\2\2/\u00f0\3\2"+
		"\2\2\61\u00f8\3\2\2\2\63\u00fb\3\2\2\2\65\u0100\3\2\2\2\67\u0105\3\2\2"+
		"\29\u0108\3\2\2\2;\u010e\3\2\2\2=\u0111\3\2\2\2?\u0116\3\2\2\2A\u011c"+
		"\3\2\2\2C\u0120\3\2\2\2E\u0123\3\2\2\2G\u0125\3\2\2\2I\u0127\3\2\2\2K"+
		"\u0129\3\2\2\2M\u012b\3\2\2\2O\u012d\3\2\2\2Q\u012f\3\2\2\2S\u0132\3\2"+
		"\2\2U\u0134\3\2\2\2W\u0137\3\2\2\2Y\u013a\3\2\2\2[\u013d\3\2\2\2]\u0140"+
		"\3\2\2\2_\u0143\3\2\2\2a\u0145\3\2\2\2c\u0147\3\2\2\2e\u014b\3\2\2\2g"+
		"\u014f\3\2\2\2i\u0153\3\2\2\2k\u0155\3\2\2\2m\u0157\3\2\2\2o\u0159\3\2"+
		"\2\2q\u015b\3\2\2\2s\u015d\3\2\2\2u\u0160\3\2\2\2w\u0167\3\2\2\2y\u0169"+
		"\3\2\2\2{\u0170\3\2\2\2}\u0172\3\2\2\2\177\u0184\3\2\2\2\u0081\u0186\3"+
		"\2\2\2\u0083\u018b\3\2\2\2\u0085\u0087\t\2\2\2\u0086\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a\u008b\b\2\2\2\u008b\4\3\2\2\2\u008c\u008d\7?\2\2\u008d\6\3"+
		"\2\2\2\u008e\u008f\7=\2\2\u008f\b\3\2\2\2\u0090\u0091\7.\2\2\u0091\n\3"+
		"\2\2\2\u0092\u0093\t\3\2\2\u0093\f\3\2\2\2\u0094\u0095\7%\2\2\u0095\16"+
		"\3\2\2\2\u0096\u0098\5\r\7\2\u0097\u0099\13\2\2\2\u0098\u0097\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\u009d\5\13\6\2\u009d\u009e\3\2\2\2\u009e\u009f\b\b\2\2"+
		"\u009f\20\3\2\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7"+
		"y\2\2\u00a3\u00a4\7r\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7"+
		"\7t\2\2\u00a7\22\3\2\2\2\u00a8\u00a9\7h\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab"+
		"\7v\2\2\u00ab\24\3\2\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af"+
		"\7f\2\2\u00af\26\3\2\2\2\u00b0\u00b1\7e\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3"+
		"\7n\2\2\u00b3\u00b4\7n\2\2\u00b4\30\3\2\2\2\u00b5\u00b6\7r\2\2\u00b6\u00b7"+
		"\7c\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7t\2\2\u00b9\32\3\2\2\2\u00ba\u00bb"+
		"\7d\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7q\2\2\u00bd\u00be\7n\2\2\u00be"+
		"\34\3\2\2\2\u00bf\u00c0\7e\2\2\u00c0\u00c1\7j\2\2\u00c1\u00c2\7c\2\2\u00c2"+
		"\u00c3\7t\2\2\u00c3\36\3\2\2\2\u00c4\u00c5\7u\2\2\u00c5\u00c6\7v\2\2\u00c6"+
		"\u00c7\7t\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7p\2\2\u00c9\u00ca\7i\2\2"+
		"\u00ca \3\2\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7p\2\2\u00cd\u00ce\7v\2"+
		"\2\u00ce\"\3\2\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7m\2\2\u00d1\u00d2\7"+
		"k\2\2\u00d2\u00d3\7r\2\2\u00d3$\3\2\2\2\u00d4\u00d5\7t\2\2\u00d5\u00d6"+
		"\7g\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7f\2\2\u00d8&\3\2\2\2\u00d9\u00da"+
		"\7h\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7g\2\2\u00dd"+
		"(\3\2\2\2\u00de\u00df\7t\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7v\2\2\u00e1"+
		"\u00e2\7w\2\2\u00e2\u00e3\7t\2\2\u00e3\u00e4\7p\2\2\u00e4*\3\2\2\2\u00e5"+
		"\u00e6\7g\2\2\u00e6\u00e7\7z\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9\7v\2\2"+
		"\u00e9,\3\2\2\2\u00ea\u00eb\7r\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed\7k\2"+
		"\2\u00ed\u00ee\7p\2\2\u00ee\u00ef\7v\2\2\u00ef.\3\2\2\2\u00f0\u00f1\7"+
		"r\2\2\u00f1\u00f2\7t\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5"+
		"\7v\2\2\u00f5\u00f6\7n\2\2\u00f6\u00f7\7p\2\2\u00f7\60\3\2\2\2\u00f8\u00f9"+
		"\7k\2\2\u00f9\u00fa\7h\2\2\u00fa\62\3\2\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd"+
		"\7j\2\2\u00fd\u00fe\7g\2\2\u00fe\u00ff\7p\2\2\u00ff\64\3\2\2\2\u0100\u0101"+
		"\7g\2\2\u0101\u0102\7n\2\2\u0102\u0103\7u\2\2\u0103\u0104\7g\2\2\u0104"+
		"\66\3\2\2\2\u0105\u0106\7h\2\2\u0106\u0107\7k\2\2\u01078\3\2\2\2\u0108"+
		"\u0109\7y\2\2\u0109\u010a\7j\2\2\u010a\u010b\7k\2\2\u010b\u010c\7n\2\2"+
		"\u010c\u010d\7g\2\2\u010d:\3\2\2\2\u010e\u010f\7f\2\2\u010f\u0110\7q\2"+
		"\2\u0110<\3\2\2\2\u0111\u0112\7f\2\2\u0112\u0113\7q\2\2\u0113\u0114\7"+
		"p\2\2\u0114\u0115\7g\2\2\u0115>\3\2\2\2\u0116\u0117\7d\2\2\u0117\u0118"+
		"\7g\2\2\u0118\u0119\7i\2\2\u0119\u011a\7k\2\2\u011a\u011b\7p\2\2\u011b"+
		"@\3\2\2\2\u011c\u011d\7g\2\2\u011d\u011e\7p\2\2\u011e\u011f\7f\2\2\u011f"+
		"B\3\2\2\2\u0120\u0121\7k\2\2\u0121\u0122\7u\2\2\u0122D\3\2\2\2\u0123\u0124"+
		"\7-\2\2\u0124F\3\2\2\2\u0125\u0126\7/\2\2\u0126H\3\2\2\2\u0127\u0128\7"+
		",\2\2\u0128J\3\2\2\2\u0129\u012a\7\61\2\2\u012aL\3\2\2\2\u012b\u012c\7"+
		"\'\2\2\u012cN\3\2\2\2\u012d\u012e\7@\2\2\u012eP\3\2\2\2\u012f\u0130\7"+
		"@\2\2\u0130\u0131\7?\2\2\u0131R\3\2\2\2\u0132\u0133\7>\2\2\u0133T\3\2"+
		"\2\2\u0134\u0135\7>\2\2\u0135\u0136\7?\2\2\u0136V\3\2\2\2\u0137\u0138"+
		"\7?\2\2\u0138\u0139\7?\2\2\u0139X\3\2\2\2\u013a\u013b\7#\2\2\u013b\u013c"+
		"\7?\2\2\u013cZ\3\2\2\2\u013d\u013e\7(\2\2\u013e\u013f\7(\2\2\u013f\\\3"+
		"\2\2\2\u0140\u0141\7~\2\2\u0141\u0142\7~\2\2\u0142^\3\2\2\2\u0143\u0144"+
		"\7#\2\2\u0144`\3\2\2\2\u0145\u0146\7/\2\2\u0146b\3\2\2\2\u0147\u0148\7"+
		"n\2\2\u0148\u0149\7g\2\2\u0149\u014a\7p\2\2\u014ad\3\2\2\2\u014b\u014c"+
		"\7q\2\2\u014c\u014d\7t\2\2\u014d\u014e\7f\2\2\u014ef\3\2\2\2\u014f\u0150"+
		"\7e\2\2\u0150\u0151\7j\2\2\u0151\u0152\7t\2\2\u0152h\3\2\2\2\u0153\u0154"+
		"\7*\2\2\u0154j\3\2\2\2\u0155\u0156\7+\2\2\u0156l\3\2\2\2\u0157\u0158\7"+
		"]\2\2\u0158n\3\2\2\2\u0159\u015a\7_\2\2\u015ap\3\2\2\2\u015b\u015c\4\62"+
		";\2\u015cr\3\2\2\2\u015d\u015e\t\4\2\2\u015et\3\2\2\2\u015f\u0161\5s:"+
		"\2\u0160\u015f\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0163\3\2\2\2\u0162\u0164"+
		"\5q9\2\u0163\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0163\3\2\2\2\u0165"+
		"\u0166\3\2\2\2\u0166v\3\2\2\2\u0167\u0168\t\5\2\2\u0168x\3\2\2\2\u0169"+
		"\u016a\t\6\2\2\u016az\3\2\2\2\u016b\u016c\7)\2\2\u016c\u016d\5w<\2\u016d"+
		"\u016e\7)\2\2\u016e\u0171\3\2\2\2\u016f\u0171\5y=\2\u0170\u016b\3\2\2"+
		"\2\u0170\u016f\3\2\2\2\u0171|\3\2\2\2\u0172\u0176\7$\2\2\u0173\u0175\5"+
		"w<\2\u0174\u0173\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u0179\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u017a\7$"+
		"\2\2\u017a~\3\2\2\2\u017b\u017c\7v\2\2\u017c\u017d\7t\2\2\u017d\u017e"+
		"\7w\2\2\u017e\u0185\7g\2\2\u017f\u0180\7h\2\2\u0180\u0181\7c\2\2\u0181"+
		"\u0182\7n\2\2\u0182\u0183\7u\2\2\u0183\u0185\7g\2\2\u0184\u017b\3\2\2"+
		"\2\u0184\u017f\3\2\2\2\u0185\u0080\3\2\2\2\u0186\u0187\7p\2\2\u0187\u0188"+
		"\7w\2\2\u0188\u0189\7n\2\2\u0189\u018a\7n\2\2\u018a\u0082\3\2\2\2\u018b"+
		"\u018f\t\7\2\2\u018c\u018e\t\b\2\2\u018d\u018c\3\2\2\2\u018e\u0191\3\2"+
		"\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0084\3\2\2\2\u0191"+
		"\u018f\3\2\2\2\13\2\u0088\u009a\u0160\u0165\u0170\u0176\u0184\u018f\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}