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
		AND=43, OR=44, NOT=45, NEG=46, LEN=47, ORD=48, CHR=49, OPEN_PARENTHESES=50, 
		CLOSE_PARENTHESES=51, OPEN_SQPARENTHESES=52, CLOSE_SQPARENTHESES=53, INTEGER=54, 
		CHARLITER=55, STRINGLITER=56, BOOLLITER=57, PAIRLITER=58, IDENT=59;
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
		RULE_argList = 0, RULE_arrayLiter = 1, RULE_arrayElem = 2, RULE_pairElem = 3, 
		RULE_binaryOper = 4, RULE_unaryOper = 5, RULE_paramList = 6, RULE_param = 7, 
		RULE_pairType = 8, RULE_pairElemType = 9, RULE_arrayType = 10, RULE_baseType = 11, 
		RULE_program = 12, RULE_func = 13, RULE_stat = 14, RULE_assignRHS = 15, 
		RULE_assignLHS = 16, RULE_expr = 17, RULE_type = 18;
	public static final String[] ruleNames = {
		"argList", "arrayLiter", "arrayElem", "pairElem", "binaryOper", "unaryOper", 
		"paramList", "param", "pairType", "pairElemType", "arrayType", "baseType", 
		"program", "func", "stat", "assignRHS", "assignLHS", "expr", "type"
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
			setState(59); ((ArrayElemContext)_localctx).name = match(IDENT);
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
			else return visitor.visitChildren(this);
		}
	}

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
		enterRule(_localctx, 14, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); type();
			setState(87); match(IDENT);
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
			else return visitor.visitChildren(this);
		}
	}

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
		enterRule(_localctx, 20, RULE_arrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			switch (_input.LA(1)) {
			case BOOL:
			case CHAR:
			case STRING:
			case INT:
				{
				setState(101); baseType();
				}
				break;
			case PAIR:
				{
				setState(102); pairType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(105); match(OPEN_SQPARENTHESES);
				setState(106); match(CLOSE_SQPARENTHESES);
				}
				}
				setState(109); 
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
		enterRule(_localctx, 22, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
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
		enterRule(_localctx, 24, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113); match(BEGIN);
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(114); func();
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(120); stat(0);
			setState(121); match(END);
			setState(122); match(EOF);
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
		enterRule(_localctx, 26, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124); type();
			setState(125); match(IDENT);
			setState(126); match(OPEN_PARENTHESES);
			setState(128);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAIR) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				setState(127); paramList();
				}
			}

			setState(130); match(CLOSE_PARENTHESES);
			setState(131); match(IS);
			setState(132); stat(0);
			setState(133); match(END);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			switch (_input.LA(1)) {
			case SKIP_:
				{
				_localctx = new Skip_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(136); match(SKIP_);
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
				setState(137); type();
				setState(138); match(IDENT);
				setState(139); match(ASSIGN);
				setState(140); assignRHS();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				_localctx = new Assign_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142); assignLHS();
				setState(143); match(ASSIGN);
				setState(144); assignRHS();
				}
				break;
			case READ:
				{
				_localctx = new Read_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146); match(READ);
				setState(147); assignLHS();
				}
				break;
			case FREE:
				{
				_localctx = new Free_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148); match(FREE);
				setState(149); expr(0);
				}
				break;
			case RETURN:
				{
				_localctx = new Return_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150); match(RETURN);
				setState(151); expr(0);
				}
				break;
			case EXIT:
				{
				_localctx = new Exit_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152); match(EXIT);
				setState(153); expr(0);
				}
				break;
			case PRINT:
				{
				_localctx = new Print_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154); match(PRINT);
				setState(155); expr(0);
				}
				break;
			case PRINTLN:
				{
				_localctx = new Println_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156); match(PRINTLN);
				setState(157); expr(0);
				}
				break;
			case IF:
				{
				_localctx = new If_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158); match(IF);
				setState(159); expr(0);
				setState(160); match(THEN);
				setState(161); stat(0);
				setState(162); match(ELSE);
				setState(163); stat(0);
				setState(164); match(FI);
				}
				break;
			case WHILE:
				{
				_localctx = new While_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166); match(WHILE);
				setState(167); expr(0);
				setState(168); match(DO);
				setState(169); stat(0);
				setState(170); match(DONE);
				}
				break;
			case BEGIN:
				{
				_localctx = new Scope_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172); match(BEGIN);
				setState(173); stat(0);
				setState(174); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(183);
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
					setState(178);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(179); match(SEMICOLON);
					setState(180); stat(2);
					}
					} 
				}
				setState(185);
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
		enterRule(_localctx, 30, RULE_assignRHS);
		int _la;
		try {
			setState(203);
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
				_localctx = new Assignr_exprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(186); expr(0);
				}
				break;
			case OPEN_SQPARENTHESES:
				_localctx = new Assignr_arrayliterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(187); arrayLiter();
				}
				break;
			case NEWPAIR:
				_localctx = new Assignr_newpairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(188); match(NEWPAIR);
				setState(189); match(OPEN_PARENTHESES);
				setState(190); expr(0);
				setState(191); match(COMMA);
				setState(192); expr(0);
				setState(193); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				_localctx = new Assignr_pairelemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(195); pairElem();
				}
				break;
			case CALL:
				_localctx = new Assignr_callContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(196); match(CALL);
				setState(197); match(IDENT);
				setState(198); match(OPEN_PARENTHESES);
				setState(200);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << NEG) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << CHARLITER) | (1L << STRINGLITER) | (1L << BOOLLITER) | (1L << PAIRLITER) | (1L << IDENT))) != 0)) {
					{
					setState(199); argList();
					}
				}

				setState(202); match(CLOSE_PARENTHESES);
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
		enterRule(_localctx, 32, RULE_assignLHS);
		try {
			setState(208);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new Assignl_idContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(205); match(IDENT);
				}
				break;
			case 2:
				_localctx = new Assignl_arrayelemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(206); arrayElem();
				}
				break;
			case 3:
				_localctx = new Assignl_pairelemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(207); pairElem();
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
	public static class Int_literContext extends ExprContext {
		public TerminalNode INTEGER() { return getToken(BasicParser.INTEGER, 0); }
		public Int_literContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitInt_liter(this);
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
	public static class IdentContext extends ExprContext {
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public IdentContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIdent(this);
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
	public static class Unary_opContext extends ExprContext {
		public UnaryOperContext unaryOper() {
			return getRuleContext(UnaryOperContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Unary_opContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnary_op(this);
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
	public static class Binary_opContext extends ExprContext {
		public ExprContext exprL;
		public ExprContext exprR;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryOperContext binaryOper() {
			return getRuleContext(BinaryOperContext.class,0);
		}
		public Binary_opContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinary_op(this);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new Unary_opContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(211); unaryOper();
				setState(212); expr(3);
				}
				break;
			case 2:
				{
				_localctx = new Int_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214); match(INTEGER);
				}
				break;
			case 3:
				{
				_localctx = new Bool_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215); match(BOOLLITER);
				}
				break;
			case 4:
				{
				_localctx = new Char_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216); match(CHARLITER);
				}
				break;
			case 5:
				{
				_localctx = new String_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217); match(STRINGLITER);
				}
				break;
			case 6:
				{
				_localctx = new Pair_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218); match(PAIRLITER);
				}
				break;
			case 7:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219); match(IDENT);
				}
				break;
			case 8:
				{
				_localctx = new ArrayElem_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220); arrayElem();
				}
				break;
			case 9:
				{
				_localctx = new Paren_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221); match(OPEN_PARENTHESES);
				setState(222); expr(0);
				setState(223); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Binary_opContext(new ExprContext(_parentctx, _parentState));
					((Binary_opContext)_localctx).exprL = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(227);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(228); binaryOper();
					setState(229); ((Binary_opContext)_localctx).exprR = expr(3);
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		enterRule(_localctx, 36, RULE_type);
		try {
			setState(239);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237); arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(238); pairType();
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
		case 14: return stat_sempred((StatContext)_localctx, predIndex);
		case 17: return expr_sempred((ExprContext)_localctx, predIndex);
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
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3=\u00f4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\3\3\3\3\3\3"+
		"\3\7\3\65\n\3\f\3\16\38\13\3\5\3:\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\6\4"+
		"C\n\4\r\4\16\4D\3\5\3\5\3\5\3\5\5\5K\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\7"+
		"\bT\n\b\f\b\16\bW\13\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\5\13f\n\13\3\f\3\f\5\fj\n\f\3\f\3\f\6\fn\n\f\r\f\16\fo\3\r\3"+
		"\r\3\16\3\16\7\16v\n\16\f\16\16\16y\13\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\5\17\u0083\n\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00b3\n\20\3\20\3\20"+
		"\3\20\7\20\u00b8\n\20\f\20\16\20\u00bb\13\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00cb\n\21\3\21\5\21"+
		"\u00ce\n\21\3\22\3\22\3\22\5\22\u00d3\n\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00e4\n\23\3\23"+
		"\3\23\3\23\3\23\7\23\u00ea\n\23\f\23\16\23\u00ed\13\23\3\24\3\24\3\24"+
		"\5\24\u00f2\n\24\3\24\2\4\36$\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&\2\5\3\2\".\3\2/\63\3\2\r\20\u010a\2(\3\2\2\2\4\60\3\2\2\2\6=\3\2"+
		"\2\2\bJ\3\2\2\2\nL\3\2\2\2\fN\3\2\2\2\16P\3\2\2\2\20X\3\2\2\2\22[\3\2"+
		"\2\2\24e\3\2\2\2\26i\3\2\2\2\30q\3\2\2\2\32s\3\2\2\2\34~\3\2\2\2\36\u00b2"+
		"\3\2\2\2 \u00cd\3\2\2\2\"\u00d2\3\2\2\2$\u00e3\3\2\2\2&\u00f1\3\2\2\2"+
		"(-\5$\23\2)*\7\6\2\2*,\5$\23\2+)\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2"+
		".\3\3\2\2\2/-\3\2\2\2\609\7\66\2\2\61\66\5$\23\2\62\63\7\6\2\2\63\65\5"+
		"$\23\2\64\62\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67:\3\2\2"+
		"\28\66\3\2\2\29\61\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\7\67\2\2<\5\3\2\2\2="+
		"B\7=\2\2>?\7\66\2\2?@\5$\23\2@A\7\67\2\2AC\3\2\2\2B>\3\2\2\2CD\3\2\2\2"+
		"DB\3\2\2\2DE\3\2\2\2E\7\3\2\2\2FG\7\t\2\2GK\5$\23\2HI\7\n\2\2IK\5$\23"+
		"\2JF\3\2\2\2JH\3\2\2\2K\t\3\2\2\2LM\t\2\2\2M\13\3\2\2\2NO\t\3\2\2O\r\3"+
		"\2\2\2PU\5\20\t\2QR\7\6\2\2RT\5\20\t\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2\2U"+
		"V\3\2\2\2V\17\3\2\2\2WU\3\2\2\2XY\5&\24\2YZ\7=\2\2Z\21\3\2\2\2[\\\7\f"+
		"\2\2\\]\7\64\2\2]^\5\24\13\2^_\7\6\2\2_`\5\24\13\2`a\7\65\2\2a\23\3\2"+
		"\2\2bf\5\30\r\2cf\5\26\f\2df\7\f\2\2eb\3\2\2\2ec\3\2\2\2ed\3\2\2\2f\25"+
		"\3\2\2\2gj\5\30\r\2hj\5\22\n\2ig\3\2\2\2ih\3\2\2\2jm\3\2\2\2kl\7\66\2"+
		"\2ln\7\67\2\2mk\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2p\27\3\2\2\2qr\t"+
		"\4\2\2r\31\3\2\2\2sw\7\37\2\2tv\5\34\17\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2"+
		"\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\5\36\20\2{|\7 \2\2|}\7\2\2\3}\33\3"+
		"\2\2\2~\177\5&\24\2\177\u0080\7=\2\2\u0080\u0082\7\64\2\2\u0081\u0083"+
		"\5\16\b\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2"+
		"\u0084\u0085\7\65\2\2\u0085\u0086\7!\2\2\u0086\u0087\5\36\20\2\u0087\u0088"+
		"\7 \2\2\u0088\35\3\2\2\2\u0089\u008a\b\20\1\2\u008a\u00b3\7\21\2\2\u008b"+
		"\u008c\5&\24\2\u008c\u008d\7=\2\2\u008d\u008e\7\4\2\2\u008e\u008f\5 \21"+
		"\2\u008f\u00b3\3\2\2\2\u0090\u0091\5\"\22\2\u0091\u0092\7\4\2\2\u0092"+
		"\u0093\5 \21\2\u0093\u00b3\3\2\2\2\u0094\u0095\7\22\2\2\u0095\u00b3\5"+
		"\"\22\2\u0096\u0097\7\23\2\2\u0097\u00b3\5$\23\2\u0098\u0099\7\24\2\2"+
		"\u0099\u00b3\5$\23\2\u009a\u009b\7\25\2\2\u009b\u00b3\5$\23\2\u009c\u009d"+
		"\7\26\2\2\u009d\u00b3\5$\23\2\u009e\u009f\7\27\2\2\u009f\u00b3\5$\23\2"+
		"\u00a0\u00a1\7\30\2\2\u00a1\u00a2\5$\23\2\u00a2\u00a3\7\31\2\2\u00a3\u00a4"+
		"\5\36\20\2\u00a4\u00a5\7\32\2\2\u00a5\u00a6\5\36\20\2\u00a6\u00a7\7\33"+
		"\2\2\u00a7\u00b3\3\2\2\2\u00a8\u00a9\7\34\2\2\u00a9\u00aa\5$\23\2\u00aa"+
		"\u00ab\7\35\2\2\u00ab\u00ac\5\36\20\2\u00ac\u00ad\7\36\2\2\u00ad\u00b3"+
		"\3\2\2\2\u00ae\u00af\7\37\2\2\u00af\u00b0\5\36\20\2\u00b0\u00b1\7 \2\2"+
		"\u00b1\u00b3\3\2\2\2\u00b2\u0089\3\2\2\2\u00b2\u008b\3\2\2\2\u00b2\u0090"+
		"\3\2\2\2\u00b2\u0094\3\2\2\2\u00b2\u0096\3\2\2\2\u00b2\u0098\3\2\2\2\u00b2"+
		"\u009a\3\2\2\2\u00b2\u009c\3\2\2\2\u00b2\u009e\3\2\2\2\u00b2\u00a0\3\2"+
		"\2\2\u00b2\u00a8\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b3\u00b9\3\2\2\2\u00b4"+
		"\u00b5\f\3\2\2\u00b5\u00b6\7\5\2\2\u00b6\u00b8\5\36\20\4\u00b7\u00b4\3"+
		"\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\37\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00ce\5$\23\2\u00bd\u00ce\5\4\3"+
		"\2\u00be\u00bf\7\b\2\2\u00bf\u00c0\7\64\2\2\u00c0\u00c1\5$\23\2\u00c1"+
		"\u00c2\7\6\2\2\u00c2\u00c3\5$\23\2\u00c3\u00c4\7\65\2\2\u00c4\u00ce\3"+
		"\2\2\2\u00c5\u00ce\5\b\5\2\u00c6\u00c7\7\13\2\2\u00c7\u00c8\7=\2\2\u00c8"+
		"\u00ca\7\64\2\2\u00c9\u00cb\5\2\2\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3"+
		"\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\7\65\2\2\u00cd\u00bc\3\2\2\2\u00cd"+
		"\u00bd\3\2\2\2\u00cd\u00be\3\2\2\2\u00cd\u00c5\3\2\2\2\u00cd\u00c6\3\2"+
		"\2\2\u00ce!\3\2\2\2\u00cf\u00d3\7=\2\2\u00d0\u00d3\5\6\4\2\u00d1\u00d3"+
		"\5\b\5\2\u00d2\u00cf\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3"+
		"#\3\2\2\2\u00d4\u00d5\b\23\1\2\u00d5\u00d6\5\f\7\2\u00d6\u00d7\5$\23\5"+
		"\u00d7\u00e4\3\2\2\2\u00d8\u00e4\78\2\2\u00d9\u00e4\7;\2\2\u00da\u00e4"+
		"\79\2\2\u00db\u00e4\7:\2\2\u00dc\u00e4\7<\2\2\u00dd\u00e4\7=\2\2\u00de"+
		"\u00e4\5\6\4\2\u00df\u00e0\7\64\2\2\u00e0\u00e1\5$\23\2\u00e1\u00e2\7"+
		"\65\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00d4\3\2\2\2\u00e3\u00d8\3\2\2\2\u00e3"+
		"\u00d9\3\2\2\2\u00e3\u00da\3\2\2\2\u00e3\u00db\3\2\2\2\u00e3\u00dc\3\2"+
		"\2\2\u00e3\u00dd\3\2\2\2\u00e3\u00de\3\2\2\2\u00e3\u00df\3\2\2\2\u00e4"+
		"\u00eb\3\2\2\2\u00e5\u00e6\f\4\2\2\u00e6\u00e7\5\n\6\2\u00e7\u00e8\5$"+
		"\23\5\u00e8\u00ea\3\2\2\2\u00e9\u00e5\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec%\3\2\2\2\u00ed\u00eb\3\2\2\2"+
		"\u00ee\u00f2\5\30\r\2\u00ef\u00f2\5\26\f\2\u00f0\u00f2\5\22\n\2\u00f1"+
		"\u00ee\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\'\3\2\2\2"+
		"\25-\669DJUeiow\u0082\u00b2\u00b9\u00ca\u00cd\u00d2\u00e3\u00eb\u00f1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}