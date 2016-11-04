// Generated from ./BasicParser.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
<<<<<<< HEAD
		WS=1, ASSIGN=2, SEMICOLON=3, COMMA=4, COMMENT=5, NEWPAIR=6, FST=7, SND=8, 
		CALL=9, PAIR=10, BOOL=11, CHAR=12, STRING=13, INT=14, SKIPPING=15, READ=16, 
		FREE=17, RETURN=18, EXIT=19, PRINT=20, PRINTLN=21, IF=22, THEN=23, ELSE=24, 
		FI=25, WHILE=26, DO=27, DONE=28, BEGIN=29, END=30, IS=31, PLUS=32, MINUS=33, 
		MULT=34, DIV=35, MOD=36, GT=37, GTE=38, LT=39, LTE=40, EQ=41, NEQ=42, 
		AND=43, OR=44, NOT=45, NEG=46, LEN=47, ORD=48, CHR=49, OPEN_PARENTHESES=50, 
		CLOSE_PARENTHESES=51, OPEN_SQPARENTHESES=52, CLOSE_SQPARENTHESES=53, INTEGER=54, 
		CHARLITER=55, STRINGLITER=56, BOOLLITER=57, PAIRLITER=58, IDENT=59;
=======
		PRINT=20, LT=39, NEWPAIR=6, DO=27, CHR=49, STRINGLITER=56, MINUS=33, MULT=34, 
		BOOLLITER=57, SEMICOLON=3, ELSE=24, IF=22, INTEGER=54, DONE=28, FST=7, 
		IS=31, EQ=41, READ=16, NOT=45, AND=43, THEN=23, END=30, LTE=40, EXIT=19, 
		PAIRLITER=58, PLUS=32, CLOSE_PARENTHESES=51, CHARLITER=55, ORD=48, CALL=9, 
		FI=25, PRINTLN=21, OPEN_PARENTHESES=50, SND=8, CHAR=12, BEGIN=29, ASSIGN=2, 
		FREE=17, COMMENT=5, INT=14, RETURN=18, WS=1, COMMA=4, MOD=36, OR=44, GT=37, 
		DIV=35, NEG=46, SKIP_=15, LEN=47, IDENT=59, BOOL=11, OPEN_SQPARENTHESES=52, 
		CLOSE_SQPARENTHESES=53, STRING=13, GTE=38, WHILE=26, NEQ=42, PAIR=10;
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "'='", "';'", "','", "COMMENT", "'newpair'", "'fst'", 
		"'snd'", "'call'", "'pair'", "'bool'", "'char'", "'string'", "'int'", 
		"'skip'", "'read'", "'free'", "'return'", "'exit'", "'print'", "'println'", 
		"'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", "'begin'", 
		"'end'", "'is'", "'+'", "MINUS", "'*'", "'/'", "'%'", "'>'", "'>='", "'<'", 
		"'<='", "'=='", "'!='", "'&&'", "'||'", "'!'", "NEG", "'len'", "'ord'", 
		"'chr'", "'('", "')'", "'['", "']'", "INTEGER", "CHARLITER", "STRINGLITER", 
		"BOOLLITER", "'null'", "IDENT"
	};
	public static final int
<<<<<<< HEAD
		RULE_argList = 0, RULE_arrayLiter = 1, RULE_arrayElem = 2, RULE_pairElem = 3, 
		RULE_binaryOper = 4, RULE_unaryOper = 5, RULE_paramList = 6, RULE_param = 7, 
		RULE_pairType = 8, RULE_pairElemType = 9, RULE_arrayType = 10, RULE_baseType = 11, 
		RULE_program = 12, RULE_func = 13, RULE_stat = 14, RULE_assignRHS = 15, 
		RULE_assignLHS = 16, RULE_expr = 17, RULE_type = 18;
	public static final String[] ruleNames = {
		"argList", "arrayLiter", "arrayElem", "pairElem", "binaryOper", "unaryOper", 
		"paramList", "param", "pairType", "pairElemType", "arrayType", "baseType", 
		"program", "func", "stat", "assignRHS", "assignLHS", "expr", "type"
=======
		RULE_program = 0, RULE_func = 1, RULE_paramList = 2, RULE_param = 3, RULE_stat = 4, 
		RULE_assignLHS = 5, RULE_assignRHS = 6, RULE_argList = 7, RULE_pairElem = 8, 
		RULE_type = 9, RULE_baseType = 10, RULE_arrayType = 11, RULE_pairType = 12, 
		RULE_pairElemType = 13, RULE_expr = 14, RULE_unaryOper = 15, RULE_binaryOper = 16, 
		RULE_arrayElem = 17, RULE_arrayLiter = 18;
	public static final String[] ruleNames = {
		"program", "func", "paramList", "param", "stat", "assignLHS", "assignRHS", 
		"argList", "pairElem", "type", "baseType", "arrayType", "pairType", "pairElemType", 
		"expr", "unaryOper", "binaryOper", "arrayElem", "arrayLiter"
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
	};

	@Override
	public String getGrammarFileName() { return "BasicParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BasicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
<<<<<<< HEAD
	public static class ArgListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArgList(this);
=======
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BasicParser.EOF, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitProgram(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); expr(0);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(39); match(COMMA);
				setState(40); expr(0);
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
=======
	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(38); match(BEGIN);
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(39); func();
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(45); stat(0);
			setState(46); match(END);
			setState(47); match(EOF);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
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

<<<<<<< HEAD
	public static class ArrayLiterContext extends ParserRuleContext {
		public TerminalNode OPEN_SQPARENTHESES() { return getToken(BasicParser.OPEN_SQPARENTHESES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public TerminalNode CLOSE_SQPARENTHESES() { return getToken(BasicParser.CLOSE_SQPARENTHESES, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public ArrayLiterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayLiter(this);
=======
	public static class FuncContext extends ParserRuleContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode IS() { return getToken(BasicParser.IS, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFunc(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final ArrayLiterContext arrayLiter() throws RecognitionException {
		ArrayLiterContext _localctx = new ArrayLiterContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_arrayLiter);
=======
	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(46); match(OPEN_SQPARENTHESES);
			setState(55);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << NEG) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << CHARLITER) | (1L << STRINGLITER) | (1L << BOOLLITER) | (1L << PAIRLITER) | (1L << IDENT))) != 0)) {
				{
				setState(47); expr(0);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(48); match(COMMA);
					setState(49); expr(0);
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(57); match(CLOSE_SQPARENTHESES);
=======
			setState(49); type(0);
			setState(50); match(IDENT);
			setState(51); match(OPEN_PARENTHESES);
			setState(53);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAIR) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				setState(52); paramList();
				}
			}

			setState(55); match(CLOSE_PARENTHESES);
			setState(56); match(IS);
			setState(57); stat(0);
			setState(58); match(END);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
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

<<<<<<< HEAD
	public static class ArrayElemContext extends ParserRuleContext {
		public List<TerminalNode> OPEN_SQPARENTHESES() { return getTokens(BasicParser.OPEN_SQPARENTHESES); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_SQPARENTHESES(int i) {
			return getToken(BasicParser.OPEN_SQPARENTHESES, i);
		}
		public List<TerminalNode> CLOSE_SQPARENTHESES() { return getTokens(BasicParser.CLOSE_SQPARENTHESES); }
		public TerminalNode CLOSE_SQPARENTHESES(int i) {
			return getToken(BasicParser.CLOSE_SQPARENTHESES, i);
		}
		public ArrayElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayElem(this);
=======
	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParamList(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final ArrayElemContext arrayElem() throws RecognitionException {
		ArrayElemContext _localctx = new ArrayElemContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_arrayElem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(59); match(IDENT);
			}
			setState(64); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(60); match(OPEN_SQPARENTHESES);
					setState(61); expr(0);
					setState(62); match(CLOSE_SQPARENTHESES);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(66); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
=======
	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); param();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(61); match(COMMA);
				setState(62); param();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
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

<<<<<<< HEAD
	public static class PairElemContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SND() { return getToken(BasicParser.SND, 0); }
		public TerminalNode FST() { return getToken(BasicParser.FST, 0); }
		public PairElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairElem(this);
=======
	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParam(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final PairElemContext pairElem() throws RecognitionException {
		PairElemContext _localctx = new PairElemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pairElem);
		try {
			setState(72);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(68); match(FST);
				setState(69); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(70); match(SND);
				setState(71); expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
=======
	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); type(0);
			setState(69); match(IDENT);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
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

<<<<<<< HEAD
	public static class BinaryOperContext extends ParserRuleContext {
		public TerminalNode NEQ() { return getToken(BasicParser.NEQ, 0); }
		public TerminalNode MULT() { return getToken(BasicParser.MULT, 0); }
		public TerminalNode GTE() { return getToken(BasicParser.GTE, 0); }
		public TerminalNode LT() { return getToken(BasicParser.LT, 0); }
		public TerminalNode GT() { return getToken(BasicParser.GT, 0); }
		public TerminalNode MOD() { return getToken(BasicParser.MOD, 0); }
		public TerminalNode OR() { return getToken(BasicParser.OR, 0); }
		public TerminalNode LTE() { return getToken(BasicParser.LTE, 0); }
		public TerminalNode AND() { return getToken(BasicParser.AND, 0); }
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode EQ() { return getToken(BasicParser.EQ, 0); }
		public TerminalNode DIV() { return getToken(BasicParser.DIV, 0); }
		public BinaryOperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinaryOper(this);
=======
	public static class StatContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(BasicParser.ELSE, 0); }
		public TerminalNode SEMICOLON() { return getToken(BasicParser.SEMICOLON, 0); }
		public TerminalNode IF() { return getToken(BasicParser.IF, 0); }
		public TerminalNode FREE() { return getToken(BasicParser.FREE, 0); }
		public TerminalNode READ() { return getToken(BasicParser.READ, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode SKIP_() { return getToken(BasicParser.SKIP_, 0); }
		public TerminalNode FI() { return getToken(BasicParser.FI, 0); }
		public TerminalNode DONE() { return getToken(BasicParser.DONE, 0); }
		public TerminalNode RETURN() { return getToken(BasicParser.RETURN, 0); }
		public TerminalNode DO() { return getToken(BasicParser.DO, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(BasicParser.PRINT, 0); }
		public TerminalNode THEN() { return getToken(BasicParser.THEN, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode WHILE() { return getToken(BasicParser.WHILE, 0); }
		public TerminalNode EXIT() { return getToken(BasicParser.EXIT, 0); }
		public AssignRHSContext assignRHS() {
			return getRuleContext(AssignRHSContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(BasicParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINTLN() { return getToken(BasicParser.PRINTLN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public AssignLHSContext assignLHS() {
			return getRuleContext(AssignLHSContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitStat(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final BinaryOperContext binaryOper() throws RecognitionException {
		BinaryOperContext _localctx = new BinaryOperContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_binaryOper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULT) | (1L << DIV) | (1L << MOD) | (1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE) | (1L << EQ) | (1L << NEQ) | (1L << AND) | (1L << OR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class UnaryOperContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(BasicParser.NOT, 0); }
		public TerminalNode NEG() { return getToken(BasicParser.NEG, 0); }
		public TerminalNode ORD() { return getToken(BasicParser.ORD, 0); }
		public TerminalNode LEN() { return getToken(BasicParser.LEN, 0); }
		public TerminalNode CHR() { return getToken(BasicParser.CHR, 0); }
		public UnaryOperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnaryOper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperContext unaryOper() throws RecognitionException {
		UnaryOperContext _localctx = new UnaryOperContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_unaryOper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << NEG) | (1L << LEN) | (1L << ORD) | (1L << CHR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); param();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(79); match(COMMA);
				setState(80); param();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
=======
	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			switch (_input.LA(1)) {
			case SKIP_:
				{
				setState(72); match(SKIP_);
				}
				break;
			case PAIR:
			case BOOL:
			case CHAR:
			case STRING:
			case INT:
				{
				setState(73); type(0);
				setState(74); match(IDENT);
				setState(75); match(ASSIGN);
				setState(76); assignRHS();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				setState(78); assignLHS();
				setState(79); match(ASSIGN);
				setState(80); assignRHS();
				}
				break;
			case READ:
				{
				setState(82); match(READ);
				setState(83); assignLHS();
				}
				break;
			case FREE:
				{
				setState(84); match(FREE);
				setState(85); expr(0);
				}
				break;
			case RETURN:
				{
				setState(86); match(RETURN);
				setState(87); expr(0);
				}
				break;
			case EXIT:
				{
				setState(88); match(EXIT);
				setState(89); expr(0);
				}
				break;
			case PRINT:
				{
				setState(90); match(PRINT);
				setState(91); expr(0);
				}
				break;
			case PRINTLN:
				{
				setState(92); match(PRINTLN);
				setState(93); expr(0);
				}
				break;
			case IF:
				{
				setState(94); match(IF);
				setState(95); expr(0);
				setState(96); match(THEN);
				setState(97); stat(0);
				setState(98); match(ELSE);
				setState(99); stat(0);
				setState(100); match(FI);
				}
				break;
			case WHILE:
				{
				setState(102); match(WHILE);
				setState(103); expr(0);
				setState(104); match(DO);
				setState(105); stat(0);
				setState(106); match(DONE);
				}
				break;
			case BEGIN:
				{
				setState(108); match(BEGIN);
				setState(109); stat(0);
				setState(110); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(114);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(115); match(SEMICOLON);
					setState(116); stat(2);
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
<<<<<<< HEAD
			exitRule();
=======
			unrollRecursionContexts(_parentctx);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
		}
		return _localctx;
	}

<<<<<<< HEAD
	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParam(this);
=======
	public static class AssignLHSContext extends ParserRuleContext {
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public AssignLHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignLHS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignLHS(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); type(0);
			setState(87); match(IDENT);
=======
	public final AssignLHSContext assignLHS() throws RecognitionException {
		AssignLHSContext _localctx = new AssignLHSContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignLHS);
		try {
			setState(125);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123); arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(124); pairElem();
				}
				break;
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
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

<<<<<<< HEAD
	public static class PairTypeContext extends ParserRuleContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public PairElemTypeContext pairElemType(int i) {
			return getRuleContext(PairElemTypeContext.class,i);
		}
		public List<PairElemTypeContext> pairElemType() {
			return getRuleContexts(PairElemTypeContext.class);
		}
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public PairTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairTypeContext pairType() throws RecognitionException {
		PairTypeContext _localctx = new PairTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pairType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); match(PAIR);
			setState(90); match(OPEN_PARENTHESES);
			setState(91); pairElemType();
			setState(92); match(COMMA);
			setState(93); pairElemType();
			setState(94); match(CLOSE_PARENTHESES);
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

	public static class PairElemTypeContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public PairElemTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElemType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairElemType(this);
=======
	public static class AssignRHSContext extends ParserRuleContext {
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode NEWPAIR() { return getToken(BasicParser.NEWPAIR, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayLiterContext arrayLiter() {
			return getRuleContext(ArrayLiterContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode CALL() { return getToken(BasicParser.CALL, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public AssignRHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignRHS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignRHS(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final PairElemTypeContext pairElemType() throws RecognitionException {
		PairElemTypeContext _localctx = new PairElemTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pairElemType);
		try {
			setState(99);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97); arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98); match(PAIR);
				}
				break;
=======
	public final AssignRHSContext assignRHS() throws RecognitionException {
		AssignRHSContext _localctx = new AssignRHSContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignRHS);
		int _la;
		try {
			setState(144);
			switch (_input.LA(1)) {
			case NOT:
			case NEG:
			case LEN:
			case ORD:
			case CHR:
			case OPEN_PARENTHESES:
			case INTEGER:
			case CHARLITER:
			case STRINGLITER:
			case BOOLLITER:
			case PAIRLITER:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(127); expr(0);
				}
				break;
			case OPEN_SQPARENTHESES:
				enterOuterAlt(_localctx, 2);
				{
				setState(128); arrayLiter();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(129); match(NEWPAIR);
				setState(130); match(OPEN_PARENTHESES);
				setState(131); expr(0);
				setState(132); match(COMMA);
				setState(133); expr(0);
				setState(134); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				enterOuterAlt(_localctx, 4);
				{
				setState(136); pairElem();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 5);
				{
				setState(137); match(CALL);
				setState(138); match(IDENT);
				setState(139); match(OPEN_PARENTHESES);
				setState(141);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << NEG) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << CHARLITER) | (1L << STRINGLITER) | (1L << BOOLLITER) | (1L << PAIRLITER) | (1L << IDENT))) != 0)) {
					{
					setState(140); argList();
					}
				}

				setState(143); match(CLOSE_PARENTHESES);
				}
				break;
			default:
				throw new NoViableAltException(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
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

<<<<<<< HEAD
	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode OPEN_SQPARENTHESES() { return getToken(BasicParser.OPEN_SQPARENTHESES, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CLOSE_SQPARENTHESES() { return getToken(BasicParser.CLOSE_SQPARENTHESES, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayType(this);
=======
	public static class ArgListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArgList(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); type(0);
			setState(102); match(OPEN_SQPARENTHESES);
			setState(103); match(CLOSE_SQPARENTHESES);
=======
	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); expr(0);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(147); match(COMMA);
				setState(148); expr(0);
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
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

<<<<<<< HEAD
	public static class BaseTypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(BasicParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(BasicParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(BasicParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(BasicParser.INT, 0); }
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBaseType(this);
=======
	public static class PairElemContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SND() { return getToken(BasicParser.SND, 0); }
		public TerminalNode FST() { return getToken(BasicParser.FST, 0); }
		public PairElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairElem(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << INT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
=======
	public final PairElemContext pairElem() throws RecognitionException {
		PairElemContext _localctx = new PairElemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pairElem);
		try {
			setState(158);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(154); match(FST);
				setState(155); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(156); match(SND);
				setState(157); expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
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

<<<<<<< HEAD
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BasicParser.EOF, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitProgram(this);
=======
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode OPEN_SQPARENTHESES() { return getToken(BasicParser.OPEN_SQPARENTHESES, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public PairTypeContext pairType() {
			return getRuleContext(PairTypeContext.class,0);
		}
		public TerminalNode CLOSE_SQPARENTHESES() { return getToken(BasicParser.CLOSE_SQPARENTHESES, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitType(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_program);
=======
	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_type, _p);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(107); match(BEGIN);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(108); func();
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(114); stat(0);
			setState(115); match(END);
			setState(116); match(EOF);
=======
			setState(163);
			switch (_input.LA(1)) {
			case BOOL:
			case CHAR:
			case STRING:
			case INT:
				{
				setState(161); baseType();
				}
				break;
			case PAIR:
				{
				setState(162); pairType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(165);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(166); match(OPEN_SQPARENTHESES);
					setState(167); match(CLOSE_SQPARENTHESES);
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
<<<<<<< HEAD
			exitRule();
=======
			unrollRecursionContexts(_parentctx);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
		}
		return _localctx;
	}

<<<<<<< HEAD
	public static class FuncContext extends ParserRuleContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode IS() { return getToken(BasicParser.IS, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFunc(this);
=======
	public static class BaseTypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(BasicParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(BasicParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(BasicParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(BasicParser.INT, 0); }
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBaseType(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_func);
=======
	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_baseType);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(118); type(0);
			setState(119); match(IDENT);
			setState(120); match(OPEN_PARENTHESES);
			setState(122);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAIR) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				setState(121); paramList();
				}
			}

			setState(124); match(CLOSE_PARENTHESES);
			setState(125); match(IS);
			setState(126); stat(0);
			setState(127); match(END);
=======
			setState(173);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << INT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
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

<<<<<<< HEAD
	public static class StatContext extends ParserRuleContext {
		public TerminalNode SKIPPING() { return getToken(BasicParser.SKIPPING, 0); }
		public TerminalNode ELSE() { return getToken(BasicParser.ELSE, 0); }
		public TerminalNode SEMICOLON() { return getToken(BasicParser.SEMICOLON, 0); }
		public TerminalNode IF() { return getToken(BasicParser.IF, 0); }
		public TerminalNode FREE() { return getToken(BasicParser.FREE, 0); }
		public TerminalNode READ() { return getToken(BasicParser.READ, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode FI() { return getToken(BasicParser.FI, 0); }
		public TerminalNode DONE() { return getToken(BasicParser.DONE, 0); }
		public TerminalNode RETURN() { return getToken(BasicParser.RETURN, 0); }
		public TerminalNode DO() { return getToken(BasicParser.DO, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(BasicParser.PRINT, 0); }
		public TerminalNode THEN() { return getToken(BasicParser.THEN, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode WHILE() { return getToken(BasicParser.WHILE, 0); }
		public TerminalNode EXIT() { return getToken(BasicParser.EXIT, 0); }
		public AssignRHSContext assignRHS() {
			return getRuleContext(AssignRHSContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(BasicParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINTLN() { return getToken(BasicParser.PRINTLN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public AssignLHSContext assignLHS() {
			return getRuleContext(AssignLHSContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitStat(this);
=======
	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode OPEN_SQPARENTHESES() { return getToken(BasicParser.OPEN_SQPARENTHESES, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CLOSE_SQPARENTHESES() { return getToken(BasicParser.CLOSE_SQPARENTHESES, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayType(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			switch (_input.LA(1)) {
			case SKIPPING:
				{
				setState(130); match(SKIPPING);
				}
				break;
			case PAIR:
			case BOOL:
			case CHAR:
			case STRING:
			case INT:
				{
				setState(131); type(0);
				setState(132); match(IDENT);
				setState(133); match(ASSIGN);
				setState(134); assignRHS();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				setState(136); assignLHS();
				setState(137); match(ASSIGN);
				setState(138); assignRHS();
				}
				break;
			case READ:
				{
				setState(140); match(READ);
				setState(141); assignLHS();
				}
				break;
			case FREE:
				{
				setState(142); match(FREE);
				setState(143); expr(0);
				}
				break;
			case RETURN:
				{
				setState(144); match(RETURN);
				setState(145); expr(0);
				}
				break;
			case EXIT:
				{
				setState(146); match(EXIT);
				setState(147); expr(0);
				}
				break;
			case PRINT:
				{
				setState(148); match(PRINT);
				setState(149); expr(0);
				}
				break;
			case PRINTLN:
				{
				setState(150); match(PRINTLN);
				setState(151); expr(0);
				}
				break;
			case IF:
				{
				setState(152); match(IF);
				setState(153); expr(0);
				setState(154); match(THEN);
				setState(155); stat(0);
				setState(156); match(ELSE);
				setState(157); stat(0);
				setState(158); match(FI);
				}
				break;
			case WHILE:
				{
				setState(160); match(WHILE);
				setState(161); expr(0);
				setState(162); match(DO);
				setState(163); stat(0);
				setState(164); match(DONE);
				}
				break;
			case BEGIN:
				{
				setState(166); match(BEGIN);
				setState(167); stat(0);
				setState(168); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(172);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(173); match(SEMICOLON);
					setState(174); stat(2);
					}
					} 
				}
				setState(179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
=======
	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175); type(0);
			setState(176); match(OPEN_SQPARENTHESES);
			setState(177); match(CLOSE_SQPARENTHESES);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
<<<<<<< HEAD
			unrollRecursionContexts(_parentctx);
=======
			exitRule();
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
		}
		return _localctx;
	}

<<<<<<< HEAD
	public static class AssignRHSContext extends ParserRuleContext {
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode NEWPAIR() { return getToken(BasicParser.NEWPAIR, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayLiterContext arrayLiter() {
			return getRuleContext(ArrayLiterContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode CALL() { return getToken(BasicParser.CALL, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public AssignRHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignRHS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignRHS(this);
=======
	public static class PairTypeContext extends ParserRuleContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public PairElemTypeContext pairElemType(int i) {
			return getRuleContext(PairElemTypeContext.class,i);
		}
		public List<PairElemTypeContext> pairElemType() {
			return getRuleContexts(PairElemTypeContext.class);
		}
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public PairTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairType(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final AssignRHSContext assignRHS() throws RecognitionException {
		AssignRHSContext _localctx = new AssignRHSContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_assignRHS);
		int _la;
		try {
			setState(197);
			switch (_input.LA(1)) {
			case NOT:
			case NEG:
			case LEN:
			case ORD:
			case CHR:
			case OPEN_PARENTHESES:
			case INTEGER:
			case CHARLITER:
			case STRINGLITER:
			case BOOLLITER:
			case PAIRLITER:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(180); expr(0);
				}
				break;
			case OPEN_SQPARENTHESES:
				enterOuterAlt(_localctx, 2);
				{
				setState(181); arrayLiter();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(182); match(NEWPAIR);
				setState(183); match(OPEN_PARENTHESES);
				setState(184); expr(0);
				setState(185); match(COMMA);
				setState(186); expr(0);
				setState(187); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				enterOuterAlt(_localctx, 4);
				{
				setState(189); pairElem();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 5);
				{
				setState(190); match(CALL);
				setState(191); match(IDENT);
				setState(192); match(OPEN_PARENTHESES);
				setState(194);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << NEG) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << CHARLITER) | (1L << STRINGLITER) | (1L << BOOLLITER) | (1L << PAIRLITER) | (1L << IDENT))) != 0)) {
					{
					setState(193); argList();
					}
				}

				setState(196); match(CLOSE_PARENTHESES);
				}
				break;
			default:
				throw new NoViableAltException(this);
=======
	public final PairTypeContext pairType() throws RecognitionException {
		PairTypeContext _localctx = new PairTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pairType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); match(PAIR);
			setState(180); match(OPEN_PARENTHESES);
			setState(181); pairElemType();
			setState(182); match(COMMA);
			setState(183); pairElemType();
			setState(184); match(CLOSE_PARENTHESES);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
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

<<<<<<< HEAD
	public static class AssignLHSContext extends ParserRuleContext {
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public AssignLHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignLHS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignLHS(this);
=======
	public static class PairElemTypeContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public PairElemTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElemType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairElemType(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final AssignLHSContext assignLHS() throws RecognitionException {
		AssignLHSContext _localctx = new AssignLHSContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_assignLHS);
		try {
			setState(202);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199); match(IDENT);
=======
	public final PairElemTypeContext pairElemType() throws RecognitionException {
		PairElemTypeContext _localctx = new PairElemTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pairElemType);
		try {
			setState(189);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186); baseType();
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< HEAD
				setState(200); arrayElem();
=======
				setState(187); arrayType();
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
<<<<<<< HEAD
				setState(201); pairElem();
=======
				setState(188); match(PAIR);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
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

	public static class ExprContext extends ParserRuleContext {
		public UnaryOperContext unaryOper() {
			return getRuleContext(UnaryOperContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(BasicParser.INTEGER, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public BinaryOperContext binaryOper() {
			return getRuleContext(BinaryOperContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode CHARLITER() { return getToken(BasicParser.CHARLITER, 0); }
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode STRINGLITER() { return getToken(BasicParser.STRINGLITER, 0); }
		public TerminalNode BOOLLITER() { return getToken(BasicParser.BOOLLITER, 0); }
		public TerminalNode PAIRLITER() { return getToken(BasicParser.PAIRLITER, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
<<<<<<< HEAD
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
=======
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(219);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(205); unaryOper();
				setState(206); expr(3);
=======
			setState(206);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(192); unaryOper();
				setState(193); expr(3);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
				}
				break;
			case 2:
				{
<<<<<<< HEAD
				setState(208); match(INTEGER);
=======
				setState(195); match(INTEGER);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
				}
				break;
			case 3:
				{
<<<<<<< HEAD
				setState(209); match(BOOLLITER);
=======
				setState(196); match(BOOLLITER);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
				}
				break;
			case 4:
				{
<<<<<<< HEAD
				setState(210); match(CHARLITER);
=======
				setState(197); match(CHARLITER);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
				}
				break;
			case 5:
				{
<<<<<<< HEAD
				setState(211); match(STRINGLITER);
=======
				setState(198); match(STRINGLITER);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
				}
				break;
			case 6:
				{
<<<<<<< HEAD
				setState(212); match(PAIRLITER);
=======
				setState(199); match(PAIRLITER);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
				}
				break;
			case 7:
				{
<<<<<<< HEAD
				setState(213); match(IDENT);
=======
				setState(200); match(IDENT);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
				}
				break;
			case 8:
				{
<<<<<<< HEAD
				setState(214); arrayElem();
=======
				setState(201); arrayElem();
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
				}
				break;
			case 9:
				{
<<<<<<< HEAD
				setState(215); match(OPEN_PARENTHESES);
				setState(216); expr(0);
				setState(217); match(CLOSE_PARENTHESES);
=======
				setState(202); match(OPEN_PARENTHESES);
				setState(203); expr(0);
				setState(204); match(CLOSE_PARENTHESES);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
<<<<<<< HEAD
			setState(227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
=======
			setState(214);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
<<<<<<< HEAD
					setState(221);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(222); binaryOper();
					setState(223); expr(3);
					}
					} 
				}
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
=======
					setState(208);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(209); binaryOper();
					setState(210); expr(3);
					}
					} 
				}
				setState(216);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
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

<<<<<<< HEAD
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode OPEN_SQPARENTHESES() { return getToken(BasicParser.OPEN_SQPARENTHESES, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public PairTypeContext pairType() {
			return getRuleContext(PairTypeContext.class,0);
		}
		public TerminalNode CLOSE_SQPARENTHESES() { return getToken(BasicParser.CLOSE_SQPARENTHESES, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitType(this);
=======
	public static class UnaryOperContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(BasicParser.NOT, 0); }
		public TerminalNode NEG() { return getToken(BasicParser.NEG, 0); }
		public TerminalNode ORD() { return getToken(BasicParser.ORD, 0); }
		public TerminalNode LEN() { return getToken(BasicParser.LEN, 0); }
		public TerminalNode CHR() { return getToken(BasicParser.CHR, 0); }
		public UnaryOperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnaryOper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperContext unaryOper() throws RecognitionException {
		UnaryOperContext _localctx = new UnaryOperContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unaryOper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << NEG) | (1L << LEN) | (1L << ORD) | (1L << CHR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class BinaryOperContext extends ParserRuleContext {
		public TerminalNode NEQ() { return getToken(BasicParser.NEQ, 0); }
		public TerminalNode MULT() { return getToken(BasicParser.MULT, 0); }
		public TerminalNode GTE() { return getToken(BasicParser.GTE, 0); }
		public TerminalNode LT() { return getToken(BasicParser.LT, 0); }
		public TerminalNode GT() { return getToken(BasicParser.GT, 0); }
		public TerminalNode MOD() { return getToken(BasicParser.MOD, 0); }
		public TerminalNode OR() { return getToken(BasicParser.OR, 0); }
		public TerminalNode LTE() { return getToken(BasicParser.LTE, 0); }
		public TerminalNode AND() { return getToken(BasicParser.AND, 0); }
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode EQ() { return getToken(BasicParser.EQ, 0); }
		public TerminalNode DIV() { return getToken(BasicParser.DIV, 0); }
		public BinaryOperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinaryOper(this);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			else return visitor.visitChildren(this);
		}
	}

<<<<<<< HEAD
	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_type, _p);
=======
	public final BinaryOperContext binaryOper() throws RecognitionException {
		BinaryOperContext _localctx = new BinaryOperContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_binaryOper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULT) | (1L << DIV) | (1L << MOD) | (1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE) | (1L << EQ) | (1L << NEQ) | (1L << AND) | (1L << OR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ArrayElemContext extends ParserRuleContext {
		public List<TerminalNode> OPEN_SQPARENTHESES() { return getTokens(BasicParser.OPEN_SQPARENTHESES); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_SQPARENTHESES(int i) {
			return getToken(BasicParser.OPEN_SQPARENTHESES, i);
		}
		public List<TerminalNode> CLOSE_SQPARENTHESES() { return getTokens(BasicParser.CLOSE_SQPARENTHESES); }
		public TerminalNode CLOSE_SQPARENTHESES(int i) {
			return getToken(BasicParser.CLOSE_SQPARENTHESES, i);
		}
		public ArrayElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayElemContext arrayElem() throws RecognitionException {
		ArrayElemContext _localctx = new ArrayElemContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arrayElem);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(233);
			switch (_input.LA(1)) {
			case BOOL:
			case CHAR:
			case STRING:
			case INT:
				{
				setState(231); baseType();
				}
				break;
			case PAIR:
				{
				setState(232); pairType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(235);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(236); match(OPEN_SQPARENTHESES);
					setState(237); match(CLOSE_SQPARENTHESES);
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
=======
			{
			setState(221); match(IDENT);
			}
			setState(226); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(222); match(OPEN_SQPARENTHESES);
					setState(223); expr(0);
					setState(224); match(CLOSE_SQPARENTHESES);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(228); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ArrayLiterContext extends ParserRuleContext {
		public TerminalNode OPEN_SQPARENTHESES() { return getToken(BasicParser.OPEN_SQPARENTHESES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public TerminalNode CLOSE_SQPARENTHESES() { return getToken(BasicParser.CLOSE_SQPARENTHESES, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public ArrayLiterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayLiter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiterContext arrayLiter() throws RecognitionException {
		ArrayLiterContext _localctx = new ArrayLiterContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arrayLiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); match(OPEN_SQPARENTHESES);
			setState(239);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << NEG) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << CHARLITER) | (1L << STRINGLITER) | (1L << BOOLLITER) | (1L << PAIRLITER) | (1L << IDENT))) != 0)) {
				{
				setState(231); expr(0);
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(232); match(COMMA);
					setState(233); expr(0);
					}
					}
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(241); match(CLOSE_SQPARENTHESES);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
<<<<<<< HEAD
			unrollRecursionContexts(_parentctx);
=======
			exitRule();
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
<<<<<<< HEAD
		case 14: return stat_sempred((StatContext)_localctx, predIndex);
		case 17: return expr_sempred((ExprContext)_localctx, predIndex);
		case 18: return type_sempred((TypeContext)_localctx, predIndex);
=======
		case 4: return stat_sempred((StatContext)_localctx, predIndex);
		case 9: return type_sempred((TypeContext)_localctx, predIndex);
		case 14: return expr_sempred((ExprContext)_localctx, predIndex);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
<<<<<<< HEAD
		case 1: return precpred(_ctx, 2);
=======
		case 2: return precpred(_ctx, 2);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
<<<<<<< HEAD
		case 2: return precpred(_ctx, 2);
=======
		case 1: return precpred(_ctx, 2);
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3=\u00f6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
<<<<<<< HEAD
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\3\3\3\3\3\3"+
		"\3\7\3\65\n\3\f\3\16\38\13\3\5\3:\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\6\4"+
		"C\n\4\r\4\16\4D\3\5\3\5\3\5\3\5\5\5K\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\7"+
		"\bT\n\b\f\b\16\bW\13\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\5\13f\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\7\16p\n\16\f\16"+
		"\16\16s\13\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17}\n\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u00ad\n\20\3\20\3\20\3\20\7\20\u00b2\n\20\f\20\16"+
		"\20\u00b5\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u00c5\n\21\3\21\5\21\u00c8\n\21\3\22\3\22\3\22\5"+
		"\22\u00cd\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00de\n\23\3\23\3\23\3\23\3\23\7\23\u00e4\n"+
		"\23\f\23\16\23\u00e7\13\23\3\24\3\24\3\24\5\24\u00ec\n\24\3\24\3\24\3"+
		"\24\7\24\u00f1\n\24\f\24\16\24\u00f4\13\24\3\24\2\5\36$&\25\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&\2\5\3\2\".\3\2/\63\3\2\r\20\u010a\2"+
		"(\3\2\2\2\4\60\3\2\2\2\6=\3\2\2\2\bJ\3\2\2\2\nL\3\2\2\2\fN\3\2\2\2\16"+
		"P\3\2\2\2\20X\3\2\2\2\22[\3\2\2\2\24e\3\2\2\2\26g\3\2\2\2\30k\3\2\2\2"+
		"\32m\3\2\2\2\34x\3\2\2\2\36\u00ac\3\2\2\2 \u00c7\3\2\2\2\"\u00cc\3\2\2"+
		"\2$\u00dd\3\2\2\2&\u00eb\3\2\2\2(-\5$\23\2)*\7\6\2\2*,\5$\23\2+)\3\2\2"+
		"\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\3\3\2\2\2/-\3\2\2\2\609\7\66\2\2\61"+
		"\66\5$\23\2\62\63\7\6\2\2\63\65\5$\23\2\64\62\3\2\2\2\658\3\2\2\2\66\64"+
		"\3\2\2\2\66\67\3\2\2\2\67:\3\2\2\28\66\3\2\2\29\61\3\2\2\29:\3\2\2\2:"+
		";\3\2\2\2;<\7\67\2\2<\5\3\2\2\2=B\7=\2\2>?\7\66\2\2?@\5$\23\2@A\7\67\2"+
		"\2AC\3\2\2\2B>\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\7\3\2\2\2FG\7\t"+
		"\2\2GK\5$\23\2HI\7\n\2\2IK\5$\23\2JF\3\2\2\2JH\3\2\2\2K\t\3\2\2\2LM\t"+
		"\2\2\2M\13\3\2\2\2NO\t\3\2\2O\r\3\2\2\2PU\5\20\t\2QR\7\6\2\2RT\5\20\t"+
		"\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\17\3\2\2\2WU\3\2\2\2XY\5&"+
		"\24\2YZ\7=\2\2Z\21\3\2\2\2[\\\7\f\2\2\\]\7\64\2\2]^\5\24\13\2^_\7\6\2"+
		"\2_`\5\24\13\2`a\7\65\2\2a\23\3\2\2\2bf\5\30\r\2cf\5\26\f\2df\7\f\2\2"+
		"eb\3\2\2\2ec\3\2\2\2ed\3\2\2\2f\25\3\2\2\2gh\5&\24\2hi\7\66\2\2ij\7\67"+
		"\2\2j\27\3\2\2\2kl\t\4\2\2l\31\3\2\2\2mq\7\37\2\2np\5\34\17\2on\3\2\2"+
		"\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\5\36\20\2uv\7 "+
		"\2\2vw\7\2\2\3w\33\3\2\2\2xy\5&\24\2yz\7=\2\2z|\7\64\2\2{}\5\16\b\2|{"+
		"\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\7\65\2\2\177\u0080\7!\2\2\u0080\u0081"+
		"\5\36\20\2\u0081\u0082\7 \2\2\u0082\35\3\2\2\2\u0083\u0084\b\20\1\2\u0084"+
		"\u00ad\7\21\2\2\u0085\u0086\5&\24\2\u0086\u0087\7=\2\2\u0087\u0088\7\4"+
		"\2\2\u0088\u0089\5 \21\2\u0089\u00ad\3\2\2\2\u008a\u008b\5\"\22\2\u008b"+
		"\u008c\7\4\2\2\u008c\u008d\5 \21\2\u008d\u00ad\3\2\2\2\u008e\u008f\7\22"+
		"\2\2\u008f\u00ad\5\"\22\2\u0090\u0091\7\23\2\2\u0091\u00ad\5$\23\2\u0092"+
		"\u0093\7\24\2\2\u0093\u00ad\5$\23\2\u0094\u0095\7\25\2\2\u0095\u00ad\5"+
		"$\23\2\u0096\u0097\7\26\2\2\u0097\u00ad\5$\23\2\u0098\u0099\7\27\2\2\u0099"+
		"\u00ad\5$\23\2\u009a\u009b\7\30\2\2\u009b\u009c\5$\23\2\u009c\u009d\7"+
		"\31\2\2\u009d\u009e\5\36\20\2\u009e\u009f\7\32\2\2\u009f\u00a0\5\36\20"+
		"\2\u00a0\u00a1\7\33\2\2\u00a1\u00ad\3\2\2\2\u00a2\u00a3\7\34\2\2\u00a3"+
		"\u00a4\5$\23\2\u00a4\u00a5\7\35\2\2\u00a5\u00a6\5\36\20\2\u00a6\u00a7"+
		"\7\36\2\2\u00a7\u00ad\3\2\2\2\u00a8\u00a9\7\37\2\2\u00a9\u00aa\5\36\20"+
		"\2\u00aa\u00ab\7 \2\2\u00ab\u00ad\3\2\2\2\u00ac\u0083\3\2\2\2\u00ac\u0085"+
		"\3\2\2\2\u00ac\u008a\3\2\2\2\u00ac\u008e\3\2\2\2\u00ac\u0090\3\2\2\2\u00ac"+
		"\u0092\3\2\2\2\u00ac\u0094\3\2\2\2\u00ac\u0096\3\2\2\2\u00ac\u0098\3\2"+
		"\2\2\u00ac\u009a\3\2\2\2\u00ac\u00a2\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ad"+
		"\u00b3\3\2\2\2\u00ae\u00af\f\3\2\2\u00af\u00b0\7\5\2\2\u00b0\u00b2\5\36"+
		"\20\4\u00b1\u00ae\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\37\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00c8\5$\23"+
		"\2\u00b7\u00c8\5\4\3\2\u00b8\u00b9\7\b\2\2\u00b9\u00ba\7\64\2\2\u00ba"+
		"\u00bb\5$\23\2\u00bb\u00bc\7\6\2\2\u00bc\u00bd\5$\23\2\u00bd\u00be\7\65"+
		"\2\2\u00be\u00c8\3\2\2\2\u00bf\u00c8\5\b\5\2\u00c0\u00c1\7\13\2\2\u00c1"+
		"\u00c2\7=\2\2\u00c2\u00c4\7\64\2\2\u00c3\u00c5\5\2\2\2\u00c4\u00c3\3\2"+
		"\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\7\65\2\2\u00c7"+
		"\u00b6\3\2\2\2\u00c7\u00b7\3\2\2\2\u00c7\u00b8\3\2\2\2\u00c7\u00bf\3\2"+
		"\2\2\u00c7\u00c0\3\2\2\2\u00c8!\3\2\2\2\u00c9\u00cd\7=\2\2\u00ca\u00cd"+
		"\5\6\4\2\u00cb\u00cd\5\b\5\2\u00cc\u00c9\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc"+
		"\u00cb\3\2\2\2\u00cd#\3\2\2\2\u00ce\u00cf\b\23\1\2\u00cf\u00d0\5\f\7\2"+
		"\u00d0\u00d1\5$\23\5\u00d1\u00de\3\2\2\2\u00d2\u00de\78\2\2\u00d3\u00de"+
		"\7;\2\2\u00d4\u00de\79\2\2\u00d5\u00de\7:\2\2\u00d6\u00de\7<\2\2\u00d7"+
		"\u00de\7=\2\2\u00d8\u00de\5\6\4\2\u00d9\u00da\7\64\2\2\u00da\u00db\5$"+
		"\23\2\u00db\u00dc\7\65\2\2\u00dc\u00de\3\2\2\2\u00dd\u00ce\3\2\2\2\u00dd"+
		"\u00d2\3\2\2\2\u00dd\u00d3\3\2\2\2\u00dd\u00d4\3\2\2\2\u00dd\u00d5\3\2"+
		"\2\2\u00dd\u00d6\3\2\2\2\u00dd\u00d7\3\2\2\2\u00dd\u00d8\3\2\2\2\u00dd"+
		"\u00d9\3\2\2\2\u00de\u00e5\3\2\2\2\u00df\u00e0\f\4\2\2\u00e0\u00e1\5\n"+
		"\6\2\u00e1\u00e2\5$\23\5\u00e2\u00e4\3\2\2\2\u00e3\u00df\3\2\2\2\u00e4"+
		"\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6%\3\2\2\2"+
		"\u00e7\u00e5\3\2\2\2\u00e8\u00e9\b\24\1\2\u00e9\u00ec\5\30\r\2\u00ea\u00ec"+
		"\5\22\n\2\u00eb\u00e8\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00f2\3\2\2\2"+
		"\u00ed\u00ee\f\4\2\2\u00ee\u00ef\7\66\2\2\u00ef\u00f1\7\67\2\2\u00f0\u00ed"+
		"\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\'\3\2\2\2\u00f4\u00f2\3\2\2\2\24-\669DJUeq|\u00ac\u00b3\u00c4\u00c7\u00cc"+
		"\u00dd\u00e5\u00eb\u00f2";
=======
		"\4\23\t\23\4\24\t\24\3\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\5\38\n\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4B\n\4\f\4\16"+
		"\4E\13\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6s\n\6\3\6\3\6\3\6\7\6"+
		"x\n\6\f\6\16\6{\13\6\3\7\3\7\3\7\5\7\u0080\n\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0090\n\b\3\b\5\b\u0093\n\b\3\t\3"+
		"\t\3\t\7\t\u0098\n\t\f\t\16\t\u009b\13\t\3\n\3\n\3\n\3\n\5\n\u00a1\n\n"+
		"\3\13\3\13\3\13\5\13\u00a6\n\13\3\13\3\13\3\13\7\13\u00ab\n\13\f\13\16"+
		"\13\u00ae\13\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\5\17\u00c0\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00d1\n\20\3\20\3\20\3\20"+
		"\3\20\7\20\u00d7\n\20\f\20\16\20\u00da\13\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\6\23\u00e5\n\23\r\23\16\23\u00e6\3\24\3\24\3\24\3"+
		"\24\7\24\u00ed\n\24\f\24\16\24\u00f0\13\24\5\24\u00f2\n\24\3\24\3\24\3"+
		"\24\2\5\n\24\36\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\5\3\2"+
		"\r\20\3\2/\63\3\2\".\u010a\2(\3\2\2\2\4\63\3\2\2\2\6>\3\2\2\2\bF\3\2\2"+
		"\2\nr\3\2\2\2\f\177\3\2\2\2\16\u0092\3\2\2\2\20\u0094\3\2\2\2\22\u00a0"+
		"\3\2\2\2\24\u00a5\3\2\2\2\26\u00af\3\2\2\2\30\u00b1\3\2\2\2\32\u00b5\3"+
		"\2\2\2\34\u00bf\3\2\2\2\36\u00d0\3\2\2\2 \u00db\3\2\2\2\"\u00dd\3\2\2"+
		"\2$\u00df\3\2\2\2&\u00e8\3\2\2\2(,\7\37\2\2)+\5\4\3\2*)\3\2\2\2+.\3\2"+
		"\2\2,*\3\2\2\2,-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\5\n\6\2\60\61\7 \2\2"+
		"\61\62\7\2\2\3\62\3\3\2\2\2\63\64\5\24\13\2\64\65\7=\2\2\65\67\7\64\2"+
		"\2\668\5\6\4\2\67\66\3\2\2\2\678\3\2\2\289\3\2\2\29:\7\65\2\2:;\7!\2\2"+
		";<\5\n\6\2<=\7 \2\2=\5\3\2\2\2>C\5\b\5\2?@\7\6\2\2@B\5\b\5\2A?\3\2\2\2"+
		"BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\7\3\2\2\2EC\3\2\2\2FG\5\24\13\2GH\7=\2"+
		"\2H\t\3\2\2\2IJ\b\6\1\2Js\7\21\2\2KL\5\24\13\2LM\7=\2\2MN\7\4\2\2NO\5"+
		"\16\b\2Os\3\2\2\2PQ\5\f\7\2QR\7\4\2\2RS\5\16\b\2Ss\3\2\2\2TU\7\22\2\2"+
		"Us\5\f\7\2VW\7\23\2\2Ws\5\36\20\2XY\7\24\2\2Ys\5\36\20\2Z[\7\25\2\2[s"+
		"\5\36\20\2\\]\7\26\2\2]s\5\36\20\2^_\7\27\2\2_s\5\36\20\2`a\7\30\2\2a"+
		"b\5\36\20\2bc\7\31\2\2cd\5\n\6\2de\7\32\2\2ef\5\n\6\2fg\7\33\2\2gs\3\2"+
		"\2\2hi\7\34\2\2ij\5\36\20\2jk\7\35\2\2kl\5\n\6\2lm\7\36\2\2ms\3\2\2\2"+
		"no\7\37\2\2op\5\n\6\2pq\7 \2\2qs\3\2\2\2rI\3\2\2\2rK\3\2\2\2rP\3\2\2\2"+
		"rT\3\2\2\2rV\3\2\2\2rX\3\2\2\2rZ\3\2\2\2r\\\3\2\2\2r^\3\2\2\2r`\3\2\2"+
		"\2rh\3\2\2\2rn\3\2\2\2sy\3\2\2\2tu\f\3\2\2uv\7\5\2\2vx\5\n\6\4wt\3\2\2"+
		"\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\13\3\2\2\2{y\3\2\2\2|\u0080\7=\2\2}"+
		"\u0080\5$\23\2~\u0080\5\22\n\2\177|\3\2\2\2\177}\3\2\2\2\177~\3\2\2\2"+
		"\u0080\r\3\2\2\2\u0081\u0093\5\36\20\2\u0082\u0093\5&\24\2\u0083\u0084"+
		"\7\b\2\2\u0084\u0085\7\64\2\2\u0085\u0086\5\36\20\2\u0086\u0087\7\6\2"+
		"\2\u0087\u0088\5\36\20\2\u0088\u0089\7\65\2\2\u0089\u0093\3\2\2\2\u008a"+
		"\u0093\5\22\n\2\u008b\u008c\7\13\2\2\u008c\u008d\7=\2\2\u008d\u008f\7"+
		"\64\2\2\u008e\u0090\5\20\t\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0093\7\65\2\2\u0092\u0081\3\2\2\2\u0092\u0082\3"+
		"\2\2\2\u0092\u0083\3\2\2\2\u0092\u008a\3\2\2\2\u0092\u008b\3\2\2\2\u0093"+
		"\17\3\2\2\2\u0094\u0099\5\36\20\2\u0095\u0096\7\6\2\2\u0096\u0098\5\36"+
		"\20\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\21\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7\t\2"+
		"\2\u009d\u00a1\5\36\20\2\u009e\u009f\7\n\2\2\u009f\u00a1\5\36\20\2\u00a0"+
		"\u009c\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\23\3\2\2\2\u00a2\u00a3\b\13\1"+
		"\2\u00a3\u00a6\5\26\f\2\u00a4\u00a6\5\32\16\2\u00a5\u00a2\3\2\2\2\u00a5"+
		"\u00a4\3\2\2\2\u00a6\u00ac\3\2\2\2\u00a7\u00a8\f\4\2\2\u00a8\u00a9\7\66"+
		"\2\2\u00a9\u00ab\7\67\2\2\u00aa\u00a7\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\25\3\2\2\2\u00ae\u00ac\3\2\2"+
		"\2\u00af\u00b0\t\2\2\2\u00b0\27\3\2\2\2\u00b1\u00b2\5\24\13\2\u00b2\u00b3"+
		"\7\66\2\2\u00b3\u00b4\7\67\2\2\u00b4\31\3\2\2\2\u00b5\u00b6\7\f\2\2\u00b6"+
		"\u00b7\7\64\2\2\u00b7\u00b8\5\34\17\2\u00b8\u00b9\7\6\2\2\u00b9\u00ba"+
		"\5\34\17\2\u00ba\u00bb\7\65\2\2\u00bb\33\3\2\2\2\u00bc\u00c0\5\26\f\2"+
		"\u00bd\u00c0\5\30\r\2\u00be\u00c0\7\f\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00bd"+
		"\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\35\3\2\2\2\u00c1\u00c2\b\20\1\2\u00c2"+
		"\u00c3\5 \21\2\u00c3\u00c4\5\36\20\5\u00c4\u00d1\3\2\2\2\u00c5\u00d1\7"+
		"8\2\2\u00c6\u00d1\7;\2\2\u00c7\u00d1\79\2\2\u00c8\u00d1\7:\2\2\u00c9\u00d1"+
		"\7<\2\2\u00ca\u00d1\7=\2\2\u00cb\u00d1\5$\23\2\u00cc\u00cd\7\64\2\2\u00cd"+
		"\u00ce\5\36\20\2\u00ce\u00cf\7\65\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00c1"+
		"\3\2\2\2\u00d0\u00c5\3\2\2\2\u00d0\u00c6\3\2\2\2\u00d0\u00c7\3\2\2\2\u00d0"+
		"\u00c8\3\2\2\2\u00d0\u00c9\3\2\2\2\u00d0\u00ca\3\2\2\2\u00d0\u00cb\3\2"+
		"\2\2\u00d0\u00cc\3\2\2\2\u00d1\u00d8\3\2\2\2\u00d2\u00d3\f\4\2\2\u00d3"+
		"\u00d4\5\"\22\2\u00d4\u00d5\5\36\20\5\u00d5\u00d7\3\2\2\2\u00d6\u00d2"+
		"\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\37\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\t\3\2\2\u00dc!\3\2\2\2\u00dd"+
		"\u00de\t\4\2\2\u00de#\3\2\2\2\u00df\u00e4\7=\2\2\u00e0\u00e1\7\66\2\2"+
		"\u00e1\u00e2\5\36\20\2\u00e2\u00e3\7\67\2\2\u00e3\u00e5\3\2\2\2\u00e4"+
		"\u00e0\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7%\3\2\2\2\u00e8\u00f1\7\66\2\2\u00e9\u00ee\5\36\20\2\u00ea\u00eb"+
		"\7\6\2\2\u00eb\u00ed\5\36\20\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2"+
		"\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee"+
		"\3\2\2\2\u00f1\u00e9\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\u00f4\7\67\2\2\u00f4\'\3\2\2\2\24,\67Cry\177\u008f\u0092\u0099\u00a0"+
		"\u00a5\u00ac\u00bf\u00d0\u00d8\u00e6\u00ee\u00f1";
>>>>>>> ac474cf50140765b8b19d343378bb32812e111ac
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}