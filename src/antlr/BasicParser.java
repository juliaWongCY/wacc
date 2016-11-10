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
		WS=1, ASSIGN=2, SEMICOLON=3, COMMA=4, COMMENT=5, NEWPAIR=6, FST=7, SND=8, 
		CALL=9, PAIR=10, BOOL=11, CHAR=12, STRING=13, INT=14, SKIP_=15, READ=16, 
		FREE=17, RETURN=18, EXIT=19, PRINT=20, PRINTLN=21, IF=22, THEN=23, ELSE=24, 
		FI=25, WHILE=26, DO=27, DONE=28, BEGIN=29, END=30, IS=31, PLUS=32, MINUS=33, 
		MULT=34, DIV=35, MOD=36, GT=37, GTE=38, LT=39, LTE=40, EQ=41, NEQ=42, 
		AND=43, OR=44, NOT=45, LEN=46, ORD=47, CHR=48, OPEN_PARENTHESES=49, CLOSE_PARENTHESES=50, 
		OPEN_SQPARENTHESES=51, CLOSE_SQPARENTHESES=52, INTEGER=53, CHARLITER=54, 
		STRINGLITER=55, BOOLLITER=56, PAIRLITER=57, IDENT=58;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "'='", "';'", "','", "COMMENT", "'newpair'", "'fst'", 
		"'snd'", "'call'", "'pair'", "'bool'", "'char'", "'string'", "'int'", 
		"'skip'", "'read'", "'free'", "'return'", "'exit'", "'print'", "'println'", 
		"'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", "'begin'", 
		"'end'", "'is'", "'+'", "'-'", "'*'", "'/'", "'%'", "'>'", "'>='", "'<'", 
		"'<='", "'=='", "'!='", "'&&'", "'||'", "'!'", "'len'", "'ord'", "'chr'", 
		"'('", "')'", "'['", "']'", "INTEGER", "CHARLITER", "STRINGLITER", "BOOLLITER", 
		"'null'", "IDENT"
	};
	public static final int
		RULE_argList = 0, RULE_arrayLiter = 1, RULE_arrayElem = 2, RULE_pairElem = 3, 
		RULE_binaryOper_IntHigher = 4, RULE_binaryOper_IntLower = 5, RULE_binaryOper_CompareHigher = 6, 
		RULE_binaryOper_CompareLower = 7, RULE_paramList = 8, RULE_param = 9, 
		RULE_pairType = 10, RULE_pairElemType = 11, RULE_arrayType = 12, RULE_baseType = 13, 
		RULE_program = 14, RULE_func = 15, RULE_stat = 16, RULE_assignRHS = 17, 
		RULE_assignLHS = 18, RULE_expr = 19, RULE_unaryOper = 20, RULE_type = 21;
	public static final String[] ruleNames = {
		"argList", "arrayLiter", "arrayElem", "pairElem", "binaryOper_IntHigher", 
		"binaryOper_IntLower", "binaryOper_CompareHigher", "binaryOper_CompareLower", 
		"paramList", "param", "pairType", "pairElemType", "arrayType", "baseType", 
		"program", "func", "stat", "assignRHS", "assignLHS", "expr", "unaryOper", 
		"type"
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
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); expr(0);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(45); match(COMMA);
				setState(46); expr(0);
				}
				}
				setState(51);
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
		enterRule(_localctx, 2, RULE_arrayLiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); match(OPEN_SQPARENTHESES);
			setState(61);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << CHARLITER) | (1L << STRINGLITER) | (1L << BOOLLITER) | (1L << PAIRLITER) | (1L << IDENT))) != 0)) {
				{
				setState(53); expr(0);
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(54); match(COMMA);
					setState(55); expr(0);
					}
					}
					setState(60);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(63); match(CLOSE_SQPARENTHESES);
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
		public Token name;
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
		enterRule(_localctx, 4, RULE_arrayElem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65); ((ArrayElemContext)_localctx).name = match(IDENT);
			setState(70); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(66); match(OPEN_SQPARENTHESES);
					setState(67); expr(0);
					setState(68); match(CLOSE_SQPARENTHESES);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(72); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
			else return visitor.visitChildren(this);
		}
	}

	public final PairElemContext pairElem() throws RecognitionException {
		PairElemContext _localctx = new PairElemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pairElem);
		try {
			setState(78);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(74); match(FST);
				setState(75); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(76); match(SND);
				setState(77); expr(0);
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

	public static class BinaryOper_IntHigherContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(BasicParser.MULT, 0); }
		public TerminalNode MOD() { return getToken(BasicParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(BasicParser.DIV, 0); }
		public BinaryOper_IntHigherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOper_IntHigher; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinaryOper_IntHigher(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOper_IntHigherContext binaryOper_IntHigher() throws RecognitionException {
		BinaryOper_IntHigherContext _localctx = new BinaryOper_IntHigherContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_binaryOper_IntHigher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
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

	public static class BinaryOper_IntLowerContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public BinaryOper_IntLowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOper_IntLower; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinaryOper_IntLower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOper_IntLowerContext binaryOper_IntLower() throws RecognitionException {
		BinaryOper_IntLowerContext _localctx = new BinaryOper_IntLowerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_binaryOper_IntLower);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
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

	public static class BinaryOper_CompareHigherContext extends ParserRuleContext {
		public TerminalNode GTE() { return getToken(BasicParser.GTE, 0); }
		public TerminalNode LT() { return getToken(BasicParser.LT, 0); }
		public TerminalNode GT() { return getToken(BasicParser.GT, 0); }
		public TerminalNode LTE() { return getToken(BasicParser.LTE, 0); }
		public BinaryOper_CompareHigherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOper_CompareHigher; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinaryOper_CompareHigher(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOper_CompareHigherContext binaryOper_CompareHigher() throws RecognitionException {
		BinaryOper_CompareHigherContext _localctx = new BinaryOper_CompareHigherContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_binaryOper_CompareHigher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE))) != 0)) ) {
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

	public static class BinaryOper_CompareLowerContext extends ParserRuleContext {
		public TerminalNode NEQ() { return getToken(BasicParser.NEQ, 0); }
		public TerminalNode EQ() { return getToken(BasicParser.EQ, 0); }
		public BinaryOper_CompareLowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOper_CompareLower; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinaryOper_CompareLower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOper_CompareLowerContext binaryOper_CompareLower() throws RecognitionException {
		BinaryOper_CompareLowerContext _localctx = new BinaryOper_CompareLowerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_binaryOper_CompareLower);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_la = _input.LA(1);
			if ( !(_la==EQ || _la==NEQ) ) {
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
		enterRule(_localctx, 16, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); param();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(89); match(COMMA);
				setState(90); param();
				}
				}
				setState(95);
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
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); type();
			setState(97); match(IDENT);
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
		enterRule(_localctx, 20, RULE_pairType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); match(PAIR);
			setState(100); match(OPEN_PARENTHESES);
			setState(101); pairElemType();
			setState(102); match(COMMA);
			setState(103); pairElemType();
			setState(104); match(CLOSE_PARENTHESES);
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
			else return visitor.visitChildren(this);
		}
	}

	public final PairElemTypeContext pairElemType() throws RecognitionException {
		PairElemTypeContext _localctx = new PairElemTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pairElemType);
		try {
			setState(109);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107); arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(108); match(PAIR);
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

	public static class ArrayTypeContext extends ParserRuleContext {
		public List<TerminalNode> OPEN_SQPARENTHESES() { return getTokens(BasicParser.OPEN_SQPARENTHESES); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public PairTypeContext pairType() {
			return getRuleContext(PairTypeContext.class,0);
		}
		public TerminalNode OPEN_SQPARENTHESES(int i) {
			return getToken(BasicParser.OPEN_SQPARENTHESES, i);
		}
		public List<TerminalNode> CLOSE_SQPARENTHESES() { return getTokens(BasicParser.CLOSE_SQPARENTHESES); }
		public TerminalNode CLOSE_SQPARENTHESES(int i) {
			return getToken(BasicParser.CLOSE_SQPARENTHESES, i);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			switch (_input.LA(1)) {
			case BOOL:
			case CHAR:
			case STRING:
			case INT:
				{
				setState(111); baseType();
				}
				break;
			case PAIR:
				{
				setState(112); pairType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(115); match(OPEN_SQPARENTHESES);
				setState(116); match(CLOSE_SQPARENTHESES);
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPEN_SQPARENTHESES );
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
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << INT))) != 0)) ) {
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
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(BEGIN);
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(124); func();
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(130); stat(0);
			setState(131); match(END);
			setState(132); match(EOF);
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
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); type();
			setState(135); match(IDENT);
			setState(136); match(OPEN_PARENTHESES);
			setState(138);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAIR) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				setState(137); paramList();
				}
			}

			setState(140); match(CLOSE_PARENTHESES);
			setState(141); match(IS);
			setState(142); stat(0);
			setState(143); match(END);
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Print_statContext extends StatContext {
		public TerminalNode PRINT() { return getToken(BasicParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Print_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPrint_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assign_statContext extends StatContext {
		public TerminalNode ASSIGN() { return getToken(BasicParser.ASSIGN, 0); }
		public AssignRHSContext assignRHS() {
			return getRuleContext(AssignRHSContext.class,0);
		}
		public AssignLHSContext assignLHS() {
			return getRuleContext(AssignLHSContext.class,0);
		}
		public Assign_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssign_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Println_statContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINTLN() { return getToken(BasicParser.PRINTLN, 0); }
		public Println_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPrintln_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Sequential_statContext extends StatContext {
		public TerminalNode SEMICOLON() { return getToken(BasicParser.SEMICOLON, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public Sequential_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitSequential_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Scope_statContext extends StatContext {
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Scope_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitScope_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Return_statContext extends StatContext {
		public TerminalNode RETURN() { return getToken(BasicParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitReturn_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exit_statContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EXIT() { return getToken(BasicParser.EXIT, 0); }
		public Exit_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExit_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Skip_statContext extends StatContext {
		public TerminalNode SKIP_() { return getToken(BasicParser.SKIP_, 0); }
		public Skip_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitSkip_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Declare_statContext extends StatContext {
		public TerminalNode ASSIGN() { return getToken(BasicParser.ASSIGN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public AssignRHSContext assignRHS() {
			return getRuleContext(AssignRHSContext.class,0);
		}
		public Declare_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitDeclare_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Free_statContext extends StatContext {
		public TerminalNode FREE() { return getToken(BasicParser.FREE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Free_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFree_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class While_statContext extends StatContext {
		public TerminalNode DONE() { return getToken(BasicParser.DONE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(BasicParser.DO, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(BasicParser.WHILE, 0); }
		public While_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitWhile_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class If_statContext extends StatContext {
		public TerminalNode FI() { return getToken(BasicParser.FI, 0); }
		public TerminalNode ELSE() { return getToken(BasicParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(BasicParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(BasicParser.THEN, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public If_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIf_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Read_statContext extends StatContext {
		public TerminalNode READ() { return getToken(BasicParser.READ, 0); }
		public AssignLHSContext assignLHS() {
			return getRuleContext(AssignLHSContext.class,0);
		}
		public Read_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitRead_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			switch (_input.LA(1)) {
			case SKIP_:
				{
				_localctx = new Skip_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(146); match(SKIP_);
				}
				break;
			case PAIR:
			case BOOL:
			case CHAR:
			case STRING:
			case INT:
				{
				_localctx = new Declare_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147); type();
				setState(148); match(IDENT);
				setState(149); match(ASSIGN);
				setState(150); assignRHS();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				_localctx = new Assign_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152); assignLHS();
				setState(153); match(ASSIGN);
				setState(154); assignRHS();
				}
				break;
			case READ:
				{
				_localctx = new Read_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156); match(READ);
				setState(157); assignLHS();
				}
				break;
			case FREE:
				{
				_localctx = new Free_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158); match(FREE);
				setState(159); expr(0);
				}
				break;
			case RETURN:
				{
				_localctx = new Return_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160); match(RETURN);
				setState(161); expr(0);
				}
				break;
			case EXIT:
				{
				_localctx = new Exit_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162); match(EXIT);
				setState(163); expr(0);
				}
				break;
			case PRINT:
				{
				_localctx = new Print_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164); match(PRINT);
				setState(165); expr(0);
				}
				break;
			case PRINTLN:
				{
				_localctx = new Println_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166); match(PRINTLN);
				setState(167); expr(0);
				}
				break;
			case IF:
				{
				_localctx = new If_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168); match(IF);
				setState(169); expr(0);
				setState(170); match(THEN);
				setState(171); stat(0);
				setState(172); match(ELSE);
				setState(173); stat(0);
				setState(174); match(FI);
				}
				break;
			case WHILE:
				{
				_localctx = new While_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176); match(WHILE);
				setState(177); expr(0);
				setState(178); match(DO);
				setState(179); stat(0);
				setState(180); match(DONE);
				}
				break;
			case BEGIN:
				{
				_localctx = new Scope_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182); match(BEGIN);
				setState(183); stat(0);
				setState(184); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Sequential_statContext(new StatContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(188);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(189); match(SEMICOLON);
					setState(190); stat(2);
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class AssignRHSContext extends ParserRuleContext {
		public AssignRHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignRHS; }
	 
		public AssignRHSContext() { }
		public void copyFrom(AssignRHSContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Assignr_exprContext extends AssignRHSContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assignr_exprContext(AssignRHSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignr_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assignr_callContext extends AssignRHSContext {
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode CALL() { return getToken(BasicParser.CALL, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public Assignr_callContext(AssignRHSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignr_call(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assignr_pairelemContext extends AssignRHSContext {
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public Assignr_pairelemContext(AssignRHSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignr_pairelem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assignr_arrayliterContext extends AssignRHSContext {
		public ArrayLiterContext arrayLiter() {
			return getRuleContext(ArrayLiterContext.class,0);
		}
		public Assignr_arrayliterContext(AssignRHSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignr_arrayliter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assignr_newpairContext extends AssignRHSContext {
		public TerminalNode NEWPAIR() { return getToken(BasicParser.NEWPAIR, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public Assignr_newpairContext(AssignRHSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignr_newpair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignRHSContext assignRHS() throws RecognitionException {
		AssignRHSContext _localctx = new AssignRHSContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_assignRHS);
		int _la;
		try {
			setState(213);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
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
				_localctx = new Assignr_exprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196); expr(0);
				}
				break;
			case OPEN_SQPARENTHESES:
				_localctx = new Assignr_arrayliterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(197); arrayLiter();
				}
				break;
			case NEWPAIR:
				_localctx = new Assignr_newpairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(198); match(NEWPAIR);
				setState(199); match(OPEN_PARENTHESES);
				setState(200); expr(0);
				setState(201); match(COMMA);
				setState(202); expr(0);
				setState(203); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				_localctx = new Assignr_pairelemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(205); pairElem();
				}
				break;
			case CALL:
				_localctx = new Assignr_callContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(206); match(CALL);
				setState(207); match(IDENT);
				setState(208); match(OPEN_PARENTHESES);
				setState(210);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << CHARLITER) | (1L << STRINGLITER) | (1L << BOOLLITER) | (1L << PAIRLITER) | (1L << IDENT))) != 0)) {
					{
					setState(209); argList();
					}
				}

				setState(212); match(CLOSE_PARENTHESES);
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

	public static class AssignLHSContext extends ParserRuleContext {
		public AssignLHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignLHS; }
	 
		public AssignLHSContext() { }
		public void copyFrom(AssignLHSContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Assignl_idContext extends AssignLHSContext {
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public Assignl_idContext(AssignLHSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignl_id(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assignl_arrayelemContext extends AssignLHSContext {
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public Assignl_arrayelemContext(AssignLHSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignl_arrayelem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assignl_pairelemContext extends AssignLHSContext {
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public Assignl_pairelemContext(AssignLHSContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignl_pairelem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignLHSContext assignLHS() throws RecognitionException {
		AssignLHSContext _localctx = new AssignLHSContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignLHS);
		try {
			setState(218);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new Assignl_idContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(215); match(IDENT);
				}
				break;
			case 2:
				_localctx = new Assignl_arrayelemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(216); arrayElem();
				}
				break;
			case 3:
				_localctx = new Assignl_pairelemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(217); pairElem();
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Paren_exprContext extends ExprContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public Paren_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParen_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class String_literContext extends ExprContext {
		public TerminalNode STRINGLITER() { return getToken(BasicParser.STRINGLITER, 0); }
		public String_literContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitString_liter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayElem_exprContext extends ExprContext {
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public ArrayElem_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayElem_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bool_literContext extends ExprContext {
		public TerminalNode BOOLLITER() { return getToken(BasicParser.BOOLLITER, 0); }
		public Bool_literContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBool_liter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Binary_opCompareLowerContext extends ExprContext {
		public ExprContext exprL;
		public ExprContext exprR;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryOper_CompareLowerContext binaryOper_CompareLower() {
			return getRuleContext(BinaryOper_CompareLowerContext.class,0);
		}
		public Binary_opCompareLowerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinary_opCompareLower(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentContext extends ExprContext {
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public IdentContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Unary_opContext extends ExprContext {
		public UnaryOperContext unaryOper() {
			return getRuleContext(UnaryOperContext.class,0);
		}
		public Unary_opContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnary_op(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Binary_opIntLowerContext extends ExprContext {
		public ExprContext exprL;
		public ExprContext exprR;
		public BinaryOper_IntLowerContext binaryOper_IntLower() {
			return getRuleContext(BinaryOper_IntLowerContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Binary_opIntLowerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinary_opIntLower(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Pair_literContext extends ExprContext {
		public TerminalNode PAIRLITER() { return getToken(BasicParser.PAIRLITER, 0); }
		public Pair_literContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPair_liter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Binary_opCompareHigherContext extends ExprContext {
		public ExprContext exprL;
		public ExprContext exprR;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryOper_CompareHigherContext binaryOper_CompareHigher() {
			return getRuleContext(BinaryOper_CompareHigherContext.class,0);
		}
		public Binary_opCompareHigherContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinary_opCompareHigher(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Int_literContext extends ExprContext {
		public TerminalNode INTEGER() { return getToken(BasicParser.INTEGER, 0); }
		public Int_literContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitInt_liter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Binary_opIntHigherContext extends ExprContext {
		public ExprContext exprL;
		public ExprContext exprR;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryOper_IntHigherContext binaryOper_IntHigher() {
			return getRuleContext(BinaryOper_IntHigherContext.class,0);
		}
		public Binary_opIntHigherContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinary_opIntHigher(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Char_literContext extends ExprContext {
		public TerminalNode CHARLITER() { return getToken(BasicParser.CHARLITER, 0); }
		public Char_literContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitChar_liter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Binary_opAndContext extends ExprContext {
		public ExprContext exprL;
		public ExprContext exprR;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(BasicParser.AND, 0); }
		public Binary_opAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinary_opAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Binary_opOrContext extends ExprContext {
		public ExprContext exprL;
		public ExprContext exprR;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(BasicParser.OR, 0); }
		public Binary_opOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinary_opOr(this);
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new Int_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(221); match(INTEGER);
				}
				break;
			case 2:
				{
				_localctx = new Bool_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222); match(BOOLLITER);
				}
				break;
			case 3:
				{
				_localctx = new Char_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223); match(CHARLITER);
				}
				break;
			case 4:
				{
				_localctx = new String_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224); match(STRINGLITER);
				}
				break;
			case 5:
				{
				_localctx = new Pair_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225); match(PAIRLITER);
				}
				break;
			case 6:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226); match(IDENT);
				}
				break;
			case 7:
				{
				_localctx = new ArrayElem_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227); arrayElem();
				}
				break;
			case 8:
				{
				_localctx = new Unary_opContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228); unaryOper();
				}
				break;
			case 9:
				{
				_localctx = new Paren_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229); match(OPEN_PARENTHESES);
				setState(230); expr(0);
				setState(231); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(259);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(257);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new Binary_opIntHigherContext(new ExprContext(_parentctx, _parentState));
						((Binary_opIntHigherContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(235);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(236); binaryOper_IntHigher();
						setState(237); ((Binary_opIntHigherContext)_localctx).exprR = expr(8);
						}
						break;
					case 2:
						{
						_localctx = new Binary_opIntLowerContext(new ExprContext(_parentctx, _parentState));
						((Binary_opIntLowerContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(240); binaryOper_IntLower();
						setState(241); ((Binary_opIntLowerContext)_localctx).exprR = expr(7);
						}
						break;
					case 3:
						{
						_localctx = new Binary_opCompareHigherContext(new ExprContext(_parentctx, _parentState));
						((Binary_opCompareHigherContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(244); binaryOper_CompareHigher();
						setState(245); ((Binary_opCompareHigherContext)_localctx).exprR = expr(6);
						}
						break;
					case 4:
						{
						_localctx = new Binary_opCompareLowerContext(new ExprContext(_parentctx, _parentState));
						((Binary_opCompareLowerContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(247);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(248); binaryOper_CompareLower();
						setState(249); ((Binary_opCompareLowerContext)_localctx).exprR = expr(5);
						}
						break;
					case 5:
						{
						_localctx = new Binary_opAndContext(new ExprContext(_parentctx, _parentState));
						((Binary_opAndContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(252); match(AND);
						setState(253); ((Binary_opAndContext)_localctx).exprR = expr(4);
						}
						break;
					case 6:
						{
						_localctx = new Binary_opOrContext(new ExprContext(_parentctx, _parentState));
						((Binary_opOrContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(255); match(OR);
						setState(256); ((Binary_opOrContext)_localctx).exprR = expr(3);
						}
						break;
					}
					} 
				}
				setState(261);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class UnaryOperContext extends ParserRuleContext {
		public UnaryOperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOper; }
	 
		public UnaryOperContext() { }
		public void copyFrom(UnaryOperContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Unary_opLenContext extends UnaryOperContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LEN() { return getToken(BasicParser.LEN, 0); }
		public Unary_opLenContext(UnaryOperContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnary_opLen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Uary_opNotContext extends UnaryOperContext {
		public TerminalNode NOT() { return getToken(BasicParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Uary_opNotContext(UnaryOperContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUary_opNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Unary_opOrdContext extends UnaryOperContext {
		public TerminalNode ORD() { return getToken(BasicParser.ORD, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Unary_opOrdContext(UnaryOperContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnary_opOrd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Unary_opNegContext extends UnaryOperContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public Unary_opNegContext(UnaryOperContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnary_opNeg(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Unary_opChrContext extends UnaryOperContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CHR() { return getToken(BasicParser.CHR, 0); }
		public Unary_opChrContext(UnaryOperContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnary_opChr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperContext unaryOper() throws RecognitionException {
		UnaryOperContext _localctx = new UnaryOperContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unaryOper);
		try {
			setState(272);
			switch (_input.LA(1)) {
			case NOT:
				_localctx = new Uary_opNotContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(262); match(NOT);
				setState(263); expr(0);
				}
				break;
			case MINUS:
				_localctx = new Unary_opNegContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(264); match(MINUS);
				setState(265); expr(0);
				}
				break;
			case LEN:
				_localctx = new Unary_opLenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(266); match(LEN);
				setState(267); expr(0);
				}
				break;
			case ORD:
				_localctx = new Unary_opOrdContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(268); match(ORD);
				setState(269); expr(0);
				}
				break;
			case CHR:
				_localctx = new Unary_opChrContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(270); match(CHR);
				setState(271); expr(0);
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

	public static class TypeContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public PairTypeContext pairType() {
			return getRuleContext(PairTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_type);
		try {
			setState(277);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(274); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(275); arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(276); pairType();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16: return stat_sempred((StatContext)_localctx, predIndex);
		case 19: return expr_sempred((ExprContext)_localctx, predIndex);
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
		case 1: return precpred(_ctx, 7);
		case 2: return precpred(_ctx, 6);
		case 3: return precpred(_ctx, 5);
		case 4: return precpred(_ctx, 4);
		case 5: return precpred(_ctx, 3);
		case 6: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u011a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\3\3\3\3\3\3\3\7\3;\n\3\f\3\16\3>\13\3\5\3@\n\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\6\4I\n\4\r\4\16\4J\3\5\3\5\3\5\3\5\5\5Q\n"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\7\n^\n\n\f\n\16\na\13\n"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\5\rp\n\r\3\16"+
		"\3\16\5\16t\n\16\3\16\3\16\6\16x\n\16\r\16\16\16y\3\17\3\17\3\20\3\20"+
		"\7\20\u0080\n\20\f\20\16\20\u0083\13\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\5\21\u008d\n\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00bd\n\22\3\22\3\22"+
		"\3\22\7\22\u00c2\n\22\f\22\16\22\u00c5\13\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00d5\n\23\3\23\5\23"+
		"\u00d8\n\23\3\24\3\24\3\24\5\24\u00dd\n\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00ec\n\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\7\25\u0104\n\25\f\25\16\25\u0107\13\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0113\n\26\3\27\3\27"+
		"\3\27\5\27\u0118\n\27\3\27\2\4\"(\30\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,\2\7\3\2$&\3\2\"#\3\2\'*\3\2+,\3\2\r\20\u0136\2.\3\2\2\2"+
		"\4\66\3\2\2\2\6C\3\2\2\2\bP\3\2\2\2\nR\3\2\2\2\fT\3\2\2\2\16V\3\2\2\2"+
		"\20X\3\2\2\2\22Z\3\2\2\2\24b\3\2\2\2\26e\3\2\2\2\30o\3\2\2\2\32s\3\2\2"+
		"\2\34{\3\2\2\2\36}\3\2\2\2 \u0088\3\2\2\2\"\u00bc\3\2\2\2$\u00d7\3\2\2"+
		"\2&\u00dc\3\2\2\2(\u00eb\3\2\2\2*\u0112\3\2\2\2,\u0117\3\2\2\2.\63\5("+
		"\25\2/\60\7\6\2\2\60\62\5(\25\2\61/\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2"+
		"\2\63\64\3\2\2\2\64\3\3\2\2\2\65\63\3\2\2\2\66?\7\65\2\2\67<\5(\25\28"+
		"9\7\6\2\29;\5(\25\2:8\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=@\3\2\2\2"+
		"><\3\2\2\2?\67\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\66\2\2B\5\3\2\2\2CH\7<"+
		"\2\2DE\7\65\2\2EF\5(\25\2FG\7\66\2\2GI\3\2\2\2HD\3\2\2\2IJ\3\2\2\2JH\3"+
		"\2\2\2JK\3\2\2\2K\7\3\2\2\2LM\7\t\2\2MQ\5(\25\2NO\7\n\2\2OQ\5(\25\2PL"+
		"\3\2\2\2PN\3\2\2\2Q\t\3\2\2\2RS\t\2\2\2S\13\3\2\2\2TU\t\3\2\2U\r\3\2\2"+
		"\2VW\t\4\2\2W\17\3\2\2\2XY\t\5\2\2Y\21\3\2\2\2Z_\5\24\13\2[\\\7\6\2\2"+
		"\\^\5\24\13\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\23\3\2\2\2a_\3"+
		"\2\2\2bc\5,\27\2cd\7<\2\2d\25\3\2\2\2ef\7\f\2\2fg\7\63\2\2gh\5\30\r\2"+
		"hi\7\6\2\2ij\5\30\r\2jk\7\64\2\2k\27\3\2\2\2lp\5\34\17\2mp\5\32\16\2n"+
		"p\7\f\2\2ol\3\2\2\2om\3\2\2\2on\3\2\2\2p\31\3\2\2\2qt\5\34\17\2rt\5\26"+
		"\f\2sq\3\2\2\2sr\3\2\2\2tw\3\2\2\2uv\7\65\2\2vx\7\66\2\2wu\3\2\2\2xy\3"+
		"\2\2\2yw\3\2\2\2yz\3\2\2\2z\33\3\2\2\2{|\t\6\2\2|\35\3\2\2\2}\u0081\7"+
		"\37\2\2~\u0080\5 \21\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2"+
		"\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084"+
		"\u0085\5\"\22\2\u0085\u0086\7 \2\2\u0086\u0087\7\2\2\3\u0087\37\3\2\2"+
		"\2\u0088\u0089\5,\27\2\u0089\u008a\7<\2\2\u008a\u008c\7\63\2\2\u008b\u008d"+
		"\5\22\n\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2"+
		"\u008e\u008f\7\64\2\2\u008f\u0090\7!\2\2\u0090\u0091\5\"\22\2\u0091\u0092"+
		"\7 \2\2\u0092!\3\2\2\2\u0093\u0094\b\22\1\2\u0094\u00bd\7\21\2\2\u0095"+
		"\u0096\5,\27\2\u0096\u0097\7<\2\2\u0097\u0098\7\4\2\2\u0098\u0099\5$\23"+
		"\2\u0099\u00bd\3\2\2\2\u009a\u009b\5&\24\2\u009b\u009c\7\4\2\2\u009c\u009d"+
		"\5$\23\2\u009d\u00bd\3\2\2\2\u009e\u009f\7\22\2\2\u009f\u00bd\5&\24\2"+
		"\u00a0\u00a1\7\23\2\2\u00a1\u00bd\5(\25\2\u00a2\u00a3\7\24\2\2\u00a3\u00bd"+
		"\5(\25\2\u00a4\u00a5\7\25\2\2\u00a5\u00bd\5(\25\2\u00a6\u00a7\7\26\2\2"+
		"\u00a7\u00bd\5(\25\2\u00a8\u00a9\7\27\2\2\u00a9\u00bd\5(\25\2\u00aa\u00ab"+
		"\7\30\2\2\u00ab\u00ac\5(\25\2\u00ac\u00ad\7\31\2\2\u00ad\u00ae\5\"\22"+
		"\2\u00ae\u00af\7\32\2\2\u00af\u00b0\5\"\22\2\u00b0\u00b1\7\33\2\2\u00b1"+
		"\u00bd\3\2\2\2\u00b2\u00b3\7\34\2\2\u00b3\u00b4\5(\25\2\u00b4\u00b5\7"+
		"\35\2\2\u00b5\u00b6\5\"\22\2\u00b6\u00b7\7\36\2\2\u00b7\u00bd\3\2\2\2"+
		"\u00b8\u00b9\7\37\2\2\u00b9\u00ba\5\"\22\2\u00ba\u00bb\7 \2\2\u00bb\u00bd"+
		"\3\2\2\2\u00bc\u0093\3\2\2\2\u00bc\u0095\3\2\2\2\u00bc\u009a\3\2\2\2\u00bc"+
		"\u009e\3\2\2\2\u00bc\u00a0\3\2\2\2\u00bc\u00a2\3\2\2\2\u00bc\u00a4\3\2"+
		"\2\2\u00bc\u00a6\3\2\2\2\u00bc\u00a8\3\2\2\2\u00bc\u00aa\3\2\2\2\u00bc"+
		"\u00b2\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bd\u00c3\3\2\2\2\u00be\u00bf\f\3"+
		"\2\2\u00bf\u00c0\7\5\2\2\u00c0\u00c2\5\"\22\4\u00c1\u00be\3\2\2\2\u00c2"+
		"\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4#\3\2\2\2"+
		"\u00c5\u00c3\3\2\2\2\u00c6\u00d8\5(\25\2\u00c7\u00d8\5\4\3\2\u00c8\u00c9"+
		"\7\b\2\2\u00c9\u00ca\7\63\2\2\u00ca\u00cb\5(\25\2\u00cb\u00cc\7\6\2\2"+
		"\u00cc\u00cd\5(\25\2\u00cd\u00ce\7\64\2\2\u00ce\u00d8\3\2\2\2\u00cf\u00d8"+
		"\5\b\5\2\u00d0\u00d1\7\13\2\2\u00d1\u00d2\7<\2\2\u00d2\u00d4\7\63\2\2"+
		"\u00d3\u00d5\5\2\2\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6"+
		"\3\2\2\2\u00d6\u00d8\7\64\2\2\u00d7\u00c6\3\2\2\2\u00d7\u00c7\3\2\2\2"+
		"\u00d7\u00c8\3\2\2\2\u00d7\u00cf\3\2\2\2\u00d7\u00d0\3\2\2\2\u00d8%\3"+
		"\2\2\2\u00d9\u00dd\7<\2\2\u00da\u00dd\5\6\4\2\u00db\u00dd\5\b\5\2\u00dc"+
		"\u00d9\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\'\3\2\2\2"+
		"\u00de\u00df\b\25\1\2\u00df\u00ec\7\67\2\2\u00e0\u00ec\7:\2\2\u00e1\u00ec"+
		"\78\2\2\u00e2\u00ec\79\2\2\u00e3\u00ec\7;\2\2\u00e4\u00ec\7<\2\2\u00e5"+
		"\u00ec\5\6\4\2\u00e6\u00ec\5*\26\2\u00e7\u00e8\7\63\2\2\u00e8\u00e9\5"+
		"(\25\2\u00e9\u00ea\7\64\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00de\3\2\2\2\u00eb"+
		"\u00e0\3\2\2\2\u00eb\u00e1\3\2\2\2\u00eb\u00e2\3\2\2\2\u00eb\u00e3\3\2"+
		"\2\2\u00eb\u00e4\3\2\2\2\u00eb\u00e5\3\2\2\2\u00eb\u00e6\3\2\2\2\u00eb"+
		"\u00e7\3\2\2\2\u00ec\u0105\3\2\2\2\u00ed\u00ee\f\t\2\2\u00ee\u00ef\5\n"+
		"\6\2\u00ef\u00f0\5(\25\n\u00f0\u0104\3\2\2\2\u00f1\u00f2\f\b\2\2\u00f2"+
		"\u00f3\5\f\7\2\u00f3\u00f4\5(\25\t\u00f4\u0104\3\2\2\2\u00f5\u00f6\f\7"+
		"\2\2\u00f6\u00f7\5\16\b\2\u00f7\u00f8\5(\25\b\u00f8\u0104\3\2\2\2\u00f9"+
		"\u00fa\f\6\2\2\u00fa\u00fb\5\20\t\2\u00fb\u00fc\5(\25\7\u00fc\u0104\3"+
		"\2\2\2\u00fd\u00fe\f\5\2\2\u00fe\u00ff\7-\2\2\u00ff\u0104\5(\25\6\u0100"+
		"\u0101\f\4\2\2\u0101\u0102\7.\2\2\u0102\u0104\5(\25\5\u0103\u00ed\3\2"+
		"\2\2\u0103\u00f1\3\2\2\2\u0103\u00f5\3\2\2\2\u0103\u00f9\3\2\2\2\u0103"+
		"\u00fd\3\2\2\2\u0103\u0100\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2"+
		"\2\2\u0105\u0106\3\2\2\2\u0106)\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109"+
		"\7/\2\2\u0109\u0113\5(\25\2\u010a\u010b\7#\2\2\u010b\u0113\5(\25\2\u010c"+
		"\u010d\7\60\2\2\u010d\u0113\5(\25\2\u010e\u010f\7\61\2\2\u010f\u0113\5"+
		"(\25\2\u0110\u0111\7\62\2\2\u0111\u0113\5(\25\2\u0112\u0108\3\2\2\2\u0112"+
		"\u010a\3\2\2\2\u0112\u010c\3\2\2\2\u0112\u010e\3\2\2\2\u0112\u0110\3\2"+
		"\2\2\u0113+\3\2\2\2\u0114\u0118\5\34\17\2\u0115\u0118\5\32\16\2\u0116"+
		"\u0118\5\26\f\2\u0117\u0114\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0116\3"+
		"\2\2\2\u0118-\3\2\2\2\27\63<?JP_osy\u0081\u008c\u00bc\u00c3\u00d4\u00d7"+
		"\u00dc\u00eb\u0103\u0105\u0112\u0117";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}