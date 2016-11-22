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
		RULE_binaryOper_CompareLower = 7, RULE_sign = 8, RULE_intliter = 9, RULE_paramList = 10, 
		RULE_param = 11, RULE_pairType = 12, RULE_pairElemType = 13, RULE_arrayType = 14, 
		RULE_baseType = 15, RULE_program = 16, RULE_func = 17, RULE_statList = 18, 
		RULE_stat = 19, RULE_assignRHS = 20, RULE_assignLHS = 21, RULE_expr = 22, 
		RULE_unaryOper = 23, RULE_type = 24;
	public static final String[] ruleNames = {
		"argList", "arrayLiter", "arrayElem", "pairElem", "binaryOper_IntHigher", 
		"binaryOper_IntLower", "binaryOper_CompareHigher", "binaryOper_CompareLower", 
		"sign", "intliter", "paramList", "param", "pairType", "pairElemType", 
		"arrayType", "baseType", "program", "func", "statList", "stat", "assignRHS", 
		"assignLHS", "expr", "unaryOper", "type"
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
			setState(50); expr(0);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(51); match(COMMA);
				setState(52); expr(0);
				}
				}
				setState(57);
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
			setState(58); match(OPEN_SQPARENTHESES);
			setState(67);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << CHARLITER) | (1L << STRINGLITER) | (1L << BOOLLITER) | (1L << PAIRLITER) | (1L << IDENT))) != 0)) {
				{
				setState(59); expr(0);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(60); match(COMMA);
					setState(61); expr(0);
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(69); match(CLOSE_SQPARENTHESES);
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
			setState(71); ((ArrayElemContext)_localctx).name = match(IDENT);
			setState(76); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(72); match(OPEN_SQPARENTHESES);
					setState(73); expr(0);
					setState(74); match(CLOSE_SQPARENTHESES);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(78); 
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
			setState(84);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(80); match(FST);
				setState(81); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(82); match(SND);
				setState(83); expr(0);
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
			setState(86);
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
			setState(88);
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
			setState(90);
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
			setState(92);
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

	public static class SignContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitSign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
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

	public static class IntliterContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(BasicParser.INTEGER, 0); }
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public IntliterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intliter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIntliter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntliterContext intliter() throws RecognitionException {
		IntliterContext _localctx = new IntliterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_intliter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(96); sign();
				}
			}

			setState(99); match(INTEGER);
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
		enterRule(_localctx, 20, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); param();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(102); match(COMMA);
				setState(103); param();
				}
				}
				setState(108);
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
		enterRule(_localctx, 22, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109); type();
			setState(110); match(IDENT);
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
		enterRule(_localctx, 24, RULE_pairType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); match(PAIR);
			setState(113); match(OPEN_PARENTHESES);
			setState(114); pairElemType();
			setState(115); match(COMMA);
			setState(116); pairElemType();
			setState(117); match(CLOSE_PARENTHESES);
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
		enterRule(_localctx, 26, RULE_pairElemType);
		try {
			setState(122);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120); arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121); match(PAIR);
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
		enterRule(_localctx, 28, RULE_arrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			switch (_input.LA(1)) {
			case BOOL:
			case CHAR:
			case STRING:
			case INT:
				{
				setState(124); baseType();
				}
				break;
			case PAIR:
				{
				setState(125); pairType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(128); match(OPEN_SQPARENTHESES);
				setState(129); match(CLOSE_SQPARENTHESES);
				}
				}
				setState(132); 
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
		enterRule(_localctx, 30, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
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
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
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
		enterRule(_localctx, 32, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(136); match(BEGIN);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(137); func();
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(143); statList();
			setState(144); match(END);
			setState(145); match(EOF);
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
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
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
		enterRule(_localctx, 34, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); type();
			setState(148); match(IDENT);
			setState(149); match(OPEN_PARENTHESES);
			setState(151);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAIR) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				setState(150); paramList();
				}
			}

			setState(153); match(CLOSE_PARENTHESES);
			setState(154); match(IS);
			setState(155); statList();
			setState(156); match(END);
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

	public static class StatListContext extends ParserRuleContext {
		public List<TerminalNode> SEMICOLON() { return getTokens(BasicParser.SEMICOLON); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode SEMICOLON(int i) {
			return getToken(BasicParser.SEMICOLON, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitStatList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatListContext statList() throws RecognitionException {
		StatListContext _localctx = new StatListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_statList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); stat();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(159); match(SEMICOLON);
				setState(160); stat();
				}
				}
				setState(165);
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
	public static class Scope_statContext extends StatContext {
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public Scope_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitScope_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class While_statContext extends StatContext {
		public TerminalNode DONE() { return getToken(BasicParser.DONE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(BasicParser.DO, 0); }
		public TerminalNode WHILE() { return getToken(BasicParser.WHILE, 0); }
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public While_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitWhile_stat(this);
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
	public static class If_statContext extends StatContext {
		public StatListContext statList(int i) {
			return getRuleContext(StatListContext.class,i);
		}
		public TerminalNode FI() { return getToken(BasicParser.FI, 0); }
		public TerminalNode ELSE() { return getToken(BasicParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(BasicParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(BasicParser.THEN, 0); }
		public List<StatListContext> statList() {
			return getRuleContexts(StatListContext.class);
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

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_stat);
		try {
			setState(206);
			switch (_input.LA(1)) {
			case SKIP_:
				_localctx = new Skip_statContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166); match(SKIP_);
				}
				break;
			case PAIR:
			case BOOL:
			case CHAR:
			case STRING:
			case INT:
				_localctx = new Declare_statContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(167); type();
				setState(168); match(IDENT);
				setState(169); match(ASSIGN);
				setState(170); assignRHS();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				_localctx = new Assign_statContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(172); assignLHS();
				setState(173); match(ASSIGN);
				setState(174); assignRHS();
				}
				break;
			case READ:
				_localctx = new Read_statContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(176); match(READ);
				setState(177); assignLHS();
				}
				break;
			case FREE:
				_localctx = new Free_statContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(178); match(FREE);
				setState(179); expr(0);
				}
				break;
			case RETURN:
				_localctx = new Return_statContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(180); match(RETURN);
				setState(181); expr(0);
				}
				break;
			case EXIT:
				_localctx = new Exit_statContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(182); match(EXIT);
				setState(183); expr(0);
				}
				break;
			case PRINT:
				_localctx = new Print_statContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(184); match(PRINT);
				setState(185); expr(0);
				}
				break;
			case PRINTLN:
				_localctx = new Println_statContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(186); match(PRINTLN);
				setState(187); expr(0);
				}
				break;
			case IF:
				_localctx = new If_statContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(188); match(IF);
				setState(189); expr(0);
				setState(190); match(THEN);
				setState(191); statList();
				setState(192); match(ELSE);
				setState(193); statList();
				setState(194); match(FI);
				}
				break;
			case WHILE:
				_localctx = new While_statContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(196); match(WHILE);
				setState(197); expr(0);
				setState(198); match(DO);
				setState(199); statList();
				setState(200); match(DONE);
				}
				break;
			case BEGIN:
				_localctx = new Scope_statContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(202); match(BEGIN);
				setState(203); statList();
				setState(204); match(END);
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
		enterRule(_localctx, 40, RULE_assignRHS);
		int _la;
		try {
			setState(225);
			switch (_input.LA(1)) {
			case PLUS:
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
				setState(208); expr(0);
				}
				break;
			case OPEN_SQPARENTHESES:
				_localctx = new Assignr_arrayliterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(209); arrayLiter();
				}
				break;
			case NEWPAIR:
				_localctx = new Assignr_newpairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(210); match(NEWPAIR);
				setState(211); match(OPEN_PARENTHESES);
				setState(212); expr(0);
				setState(213); match(COMMA);
				setState(214); expr(0);
				setState(215); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				_localctx = new Assignr_pairelemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(217); pairElem();
				}
				break;
			case CALL:
				_localctx = new Assignr_callContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(218); match(CALL);
				setState(219); match(IDENT);
				setState(220); match(OPEN_PARENTHESES);
				setState(222);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << CHARLITER) | (1L << STRINGLITER) | (1L << BOOLLITER) | (1L << PAIRLITER) | (1L << IDENT))) != 0)) {
					{
					setState(221); argList();
					}
				}

				setState(224); match(CLOSE_PARENTHESES);
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
		enterRule(_localctx, 42, RULE_assignLHS);
		try {
			setState(230);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new Assignl_idContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(227); match(IDENT);
				}
				break;
			case 2:
				_localctx = new Assignl_arrayelemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(228); arrayElem();
				}
				break;
			case 3:
				_localctx = new Assignl_pairelemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(229); pairElem();
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
		public IntliterContext intliter() {
			return getRuleContext(IntliterContext.class,0);
		}
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new Int_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(233); intliter();
				}
				break;
			case 2:
				{
				_localctx = new Bool_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234); match(BOOLLITER);
				}
				break;
			case 3:
				{
				_localctx = new Char_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235); match(CHARLITER);
				}
				break;
			case 4:
				{
				_localctx = new String_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236); match(STRINGLITER);
				}
				break;
			case 5:
				{
				_localctx = new Pair_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237); match(PAIRLITER);
				}
				break;
			case 6:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238); match(IDENT);
				}
				break;
			case 7:
				{
				_localctx = new ArrayElem_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239); arrayElem();
				}
				break;
			case 8:
				{
				_localctx = new Unary_opContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240); unaryOper();
				}
				break;
			case 9:
				{
				_localctx = new Paren_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241); match(OPEN_PARENTHESES);
				setState(242); expr(0);
				setState(243); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(269);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new Binary_opIntHigherContext(new ExprContext(_parentctx, _parentState));
						((Binary_opIntHigherContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(247);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(248); binaryOper_IntHigher();
						setState(249); ((Binary_opIntHigherContext)_localctx).exprR = expr(8);
						}
						break;
					case 2:
						{
						_localctx = new Binary_opIntLowerContext(new ExprContext(_parentctx, _parentState));
						((Binary_opIntLowerContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(252); binaryOper_IntLower();
						setState(253); ((Binary_opIntLowerContext)_localctx).exprR = expr(7);
						}
						break;
					case 3:
						{
						_localctx = new Binary_opCompareHigherContext(new ExprContext(_parentctx, _parentState));
						((Binary_opCompareHigherContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(255);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(256); binaryOper_CompareHigher();
						setState(257); ((Binary_opCompareHigherContext)_localctx).exprR = expr(6);
						}
						break;
					case 4:
						{
						_localctx = new Binary_opCompareLowerContext(new ExprContext(_parentctx, _parentState));
						((Binary_opCompareLowerContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(259);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(260); binaryOper_CompareLower();
						setState(261); ((Binary_opCompareLowerContext)_localctx).exprR = expr(5);
						}
						break;
					case 5:
						{
						_localctx = new Binary_opAndContext(new ExprContext(_parentctx, _parentState));
						((Binary_opAndContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(263);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(264); match(AND);
						setState(265); ((Binary_opAndContext)_localctx).exprR = expr(4);
						}
						break;
					case 6:
						{
						_localctx = new Binary_opOrContext(new ExprContext(_parentctx, _parentState));
						((Binary_opOrContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(266);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(267); match(OR);
						setState(268); ((Binary_opOrContext)_localctx).exprR = expr(3);
						}
						break;
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		enterRule(_localctx, 46, RULE_unaryOper);
		try {
			setState(284);
			switch (_input.LA(1)) {
			case NOT:
				_localctx = new Uary_opNotContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(274); match(NOT);
				setState(275); expr(0);
				}
				break;
			case MINUS:
				_localctx = new Unary_opNegContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(276); match(MINUS);
				setState(277); expr(0);
				}
				break;
			case LEN:
				_localctx = new Unary_opLenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(278); match(LEN);
				setState(279); expr(0);
				}
				break;
			case ORD:
				_localctx = new Unary_opOrdContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(280); match(ORD);
				setState(281); expr(0);
				}
				break;
			case CHR:
				_localctx = new Unary_opChrContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(282); match(CHR);
				setState(283); expr(0);
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
		enterRule(_localctx, 48, RULE_type);
		try {
			setState(289);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287); arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(288); pairType();
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
		case 22: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 7);
		case 1: return precpred(_ctx, 6);
		case 2: return precpred(_ctx, 5);
		case 3: return precpred(_ctx, 4);
		case 4: return precpred(_ctx, 3);
		case 5: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u0126\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\7\28\n\2\f\2\16\2;\13\2\3\3\3\3\3\3\3\3\7\3A\n"+
		"\3\f\3\16\3D\13\3\5\3F\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\6\4O\n\4\r\4\16"+
		"\4P\3\5\3\5\3\5\3\5\5\5W\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\5\13d\n\13\3\13\3\13\3\f\3\f\3\f\7\fk\n\f\f\f\16\fn\13\f\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17}\n\17\3\20\3"+
		"\20\5\20\u0081\n\20\3\20\3\20\6\20\u0085\n\20\r\20\16\20\u0086\3\21\3"+
		"\21\3\22\3\22\7\22\u008d\n\22\f\22\16\22\u0090\13\22\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\5\23\u009a\n\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\7\24\u00a4\n\24\f\24\16\24\u00a7\13\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00d1\n\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00e1\n\26"+
		"\3\26\5\26\u00e4\n\26\3\27\3\27\3\27\5\27\u00e9\n\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00f8\n\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0110\n\30\f\30\16\30\u0113\13"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u011f\n\31"+
		"\3\32\3\32\3\32\5\32\u0124\n\32\3\32\2\3.\33\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\2\7\3\2$&\3\2\"#\3\2\'*\3\2+,\3\2\r\20\u0140"+
		"\2\64\3\2\2\2\4<\3\2\2\2\6I\3\2\2\2\bV\3\2\2\2\nX\3\2\2\2\fZ\3\2\2\2\16"+
		"\\\3\2\2\2\20^\3\2\2\2\22`\3\2\2\2\24c\3\2\2\2\26g\3\2\2\2\30o\3\2\2\2"+
		"\32r\3\2\2\2\34|\3\2\2\2\36\u0080\3\2\2\2 \u0088\3\2\2\2\"\u008a\3\2\2"+
		"\2$\u0095\3\2\2\2&\u00a0\3\2\2\2(\u00d0\3\2\2\2*\u00e3\3\2\2\2,\u00e8"+
		"\3\2\2\2.\u00f7\3\2\2\2\60\u011e\3\2\2\2\62\u0123\3\2\2\2\649\5.\30\2"+
		"\65\66\7\6\2\2\668\5.\30\2\67\65\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2"+
		"\2:\3\3\2\2\2;9\3\2\2\2<E\7\65\2\2=B\5.\30\2>?\7\6\2\2?A\5.\30\2@>\3\2"+
		"\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CF\3\2\2\2DB\3\2\2\2E=\3\2\2\2EF\3\2"+
		"\2\2FG\3\2\2\2GH\7\66\2\2H\5\3\2\2\2IN\7<\2\2JK\7\65\2\2KL\5.\30\2LM\7"+
		"\66\2\2MO\3\2\2\2NJ\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\7\3\2\2\2R"+
		"S\7\t\2\2SW\5.\30\2TU\7\n\2\2UW\5.\30\2VR\3\2\2\2VT\3\2\2\2W\t\3\2\2\2"+
		"XY\t\2\2\2Y\13\3\2\2\2Z[\t\3\2\2[\r\3\2\2\2\\]\t\4\2\2]\17\3\2\2\2^_\t"+
		"\5\2\2_\21\3\2\2\2`a\t\3\2\2a\23\3\2\2\2bd\5\22\n\2cb\3\2\2\2cd\3\2\2"+
		"\2de\3\2\2\2ef\7\67\2\2f\25\3\2\2\2gl\5\30\r\2hi\7\6\2\2ik\5\30\r\2jh"+
		"\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\27\3\2\2\2nl\3\2\2\2op\5\62\32"+
		"\2pq\7<\2\2q\31\3\2\2\2rs\7\f\2\2st\7\63\2\2tu\5\34\17\2uv\7\6\2\2vw\5"+
		"\34\17\2wx\7\64\2\2x\33\3\2\2\2y}\5 \21\2z}\5\36\20\2{}\7\f\2\2|y\3\2"+
		"\2\2|z\3\2\2\2|{\3\2\2\2}\35\3\2\2\2~\u0081\5 \21\2\177\u0081\5\32\16"+
		"\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0083\7"+
		"\65\2\2\u0083\u0085\7\66\2\2\u0084\u0082\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\37\3\2\2\2\u0088\u0089\t\6\2"+
		"\2\u0089!\3\2\2\2\u008a\u008e\7\37\2\2\u008b\u008d\5$\23\2\u008c\u008b"+
		"\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\5&\24\2\u0092\u0093\7 "+
		"\2\2\u0093\u0094\7\2\2\3\u0094#\3\2\2\2\u0095\u0096\5\62\32\2\u0096\u0097"+
		"\7<\2\2\u0097\u0099\7\63\2\2\u0098\u009a\5\26\f\2\u0099\u0098\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\7\64\2\2\u009c\u009d"+
		"\7!\2\2\u009d\u009e\5&\24\2\u009e\u009f\7 \2\2\u009f%\3\2\2\2\u00a0\u00a5"+
		"\5(\25\2\u00a1\u00a2\7\5\2\2\u00a2\u00a4\5(\25\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\'\3\2\2\2"+
		"\u00a7\u00a5\3\2\2\2\u00a8\u00d1\7\21\2\2\u00a9\u00aa\5\62\32\2\u00aa"+
		"\u00ab\7<\2\2\u00ab\u00ac\7\4\2\2\u00ac\u00ad\5*\26\2\u00ad\u00d1\3\2"+
		"\2\2\u00ae\u00af\5,\27\2\u00af\u00b0\7\4\2\2\u00b0\u00b1\5*\26\2\u00b1"+
		"\u00d1\3\2\2\2\u00b2\u00b3\7\22\2\2\u00b3\u00d1\5,\27\2\u00b4\u00b5\7"+
		"\23\2\2\u00b5\u00d1\5.\30\2\u00b6\u00b7\7\24\2\2\u00b7\u00d1\5.\30\2\u00b8"+
		"\u00b9\7\25\2\2\u00b9\u00d1\5.\30\2\u00ba\u00bb\7\26\2\2\u00bb\u00d1\5"+
		".\30\2\u00bc\u00bd\7\27\2\2\u00bd\u00d1\5.\30\2\u00be\u00bf\7\30\2\2\u00bf"+
		"\u00c0\5.\30\2\u00c0\u00c1\7\31\2\2\u00c1\u00c2\5&\24\2\u00c2\u00c3\7"+
		"\32\2\2\u00c3\u00c4\5&\24\2\u00c4\u00c5\7\33\2\2\u00c5\u00d1\3\2\2\2\u00c6"+
		"\u00c7\7\34\2\2\u00c7\u00c8\5.\30\2\u00c8\u00c9\7\35\2\2\u00c9\u00ca\5"+
		"&\24\2\u00ca\u00cb\7\36\2\2\u00cb\u00d1\3\2\2\2\u00cc\u00cd\7\37\2\2\u00cd"+
		"\u00ce\5&\24\2\u00ce\u00cf\7 \2\2\u00cf\u00d1\3\2\2\2\u00d0\u00a8\3\2"+
		"\2\2\u00d0\u00a9\3\2\2\2\u00d0\u00ae\3\2\2\2\u00d0\u00b2\3\2\2\2\u00d0"+
		"\u00b4\3\2\2\2\u00d0\u00b6\3\2\2\2\u00d0\u00b8\3\2\2\2\u00d0\u00ba\3\2"+
		"\2\2\u00d0\u00bc\3\2\2\2\u00d0\u00be\3\2\2\2\u00d0\u00c6\3\2\2\2\u00d0"+
		"\u00cc\3\2\2\2\u00d1)\3\2\2\2\u00d2\u00e4\5.\30\2\u00d3\u00e4\5\4\3\2"+
		"\u00d4\u00d5\7\b\2\2\u00d5\u00d6\7\63\2\2\u00d6\u00d7\5.\30\2\u00d7\u00d8"+
		"\7\6\2\2\u00d8\u00d9\5.\30\2\u00d9\u00da\7\64\2\2\u00da\u00e4\3\2\2\2"+
		"\u00db\u00e4\5\b\5\2\u00dc\u00dd\7\13\2\2\u00dd\u00de\7<\2\2\u00de\u00e0"+
		"\7\63\2\2\u00df\u00e1\5\2\2\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2"+
		"\u00e1\u00e2\3\2\2\2\u00e2\u00e4\7\64\2\2\u00e3\u00d2\3\2\2\2\u00e3\u00d3"+
		"\3\2\2\2\u00e3\u00d4\3\2\2\2\u00e3\u00db\3\2\2\2\u00e3\u00dc\3\2\2\2\u00e4"+
		"+\3\2\2\2\u00e5\u00e9\7<\2\2\u00e6\u00e9\5\6\4\2\u00e7\u00e9\5\b\5\2\u00e8"+
		"\u00e5\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9-\3\2\2\2"+
		"\u00ea\u00eb\b\30\1\2\u00eb\u00f8\5\24\13\2\u00ec\u00f8\7:\2\2\u00ed\u00f8"+
		"\78\2\2\u00ee\u00f8\79\2\2\u00ef\u00f8\7;\2\2\u00f0\u00f8\7<\2\2\u00f1"+
		"\u00f8\5\6\4\2\u00f2\u00f8\5\60\31\2\u00f3\u00f4\7\63\2\2\u00f4\u00f5"+
		"\5.\30\2\u00f5\u00f6\7\64\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00ea\3\2\2\2"+
		"\u00f7\u00ec\3\2\2\2\u00f7\u00ed\3\2\2\2\u00f7\u00ee\3\2\2\2\u00f7\u00ef"+
		"\3\2\2\2\u00f7\u00f0\3\2\2\2\u00f7\u00f1\3\2\2\2\u00f7\u00f2\3\2\2\2\u00f7"+
		"\u00f3\3\2\2\2\u00f8\u0111\3\2\2\2\u00f9\u00fa\f\t\2\2\u00fa\u00fb\5\n"+
		"\6\2\u00fb\u00fc\5.\30\n\u00fc\u0110\3\2\2\2\u00fd\u00fe\f\b\2\2\u00fe"+
		"\u00ff\5\f\7\2\u00ff\u0100\5.\30\t\u0100\u0110\3\2\2\2\u0101\u0102\f\7"+
		"\2\2\u0102\u0103\5\16\b\2\u0103\u0104\5.\30\b\u0104\u0110\3\2\2\2\u0105"+
		"\u0106\f\6\2\2\u0106\u0107\5\20\t\2\u0107\u0108\5.\30\7\u0108\u0110\3"+
		"\2\2\2\u0109\u010a\f\5\2\2\u010a\u010b\7-\2\2\u010b\u0110\5.\30\6\u010c"+
		"\u010d\f\4\2\2\u010d\u010e\7.\2\2\u010e\u0110\5.\30\5\u010f\u00f9\3\2"+
		"\2\2\u010f\u00fd\3\2\2\2\u010f\u0101\3\2\2\2\u010f\u0105\3\2\2\2\u010f"+
		"\u0109\3\2\2\2\u010f\u010c\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2"+
		"\2\2\u0111\u0112\3\2\2\2\u0112/\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115"+
		"\7/\2\2\u0115\u011f\5.\30\2\u0116\u0117\7#\2\2\u0117\u011f\5.\30\2\u0118"+
		"\u0119\7\60\2\2\u0119\u011f\5.\30\2\u011a\u011b\7\61\2\2\u011b\u011f\5"+
		".\30\2\u011c\u011d\7\62\2\2\u011d\u011f\5.\30\2\u011e\u0114\3\2\2\2\u011e"+
		"\u0116\3\2\2\2\u011e\u0118\3\2\2\2\u011e\u011a\3\2\2\2\u011e\u011c\3\2"+
		"\2\2\u011f\61\3\2\2\2\u0120\u0124\5 \21\2\u0121\u0124\5\36\20\2\u0122"+
		"\u0124\5\32\16\2\u0123\u0120\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0122\3"+
		"\2\2\2\u0124\63\3\2\2\2\309BEPVcl|\u0080\u0086\u008e\u0099\u00a5\u00d0"+
		"\u00e0\u00e3\u00e8\u00f7\u010f\u0111\u011e\u0123";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}