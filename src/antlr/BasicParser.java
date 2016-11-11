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
		RULE_baseType = 15, RULE_program = 16, RULE_func = 17, RULE_stat = 18, 
		RULE_assignRHS = 19, RULE_assignLHS = 20, RULE_expr = 21, RULE_unaryOper = 22, 
		RULE_type = 23;
	public static final String[] ruleNames = {
		"argList", "arrayLiter", "arrayElem", "pairElem", "binaryOper_IntHigher", 
		"binaryOper_IntLower", "binaryOper_CompareHigher", "binaryOper_CompareLower", 
		"sign", "intliter", "paramList", "param", "pairType", "pairElemType", 
		"arrayType", "baseType", "program", "func", "stat", "assignRHS", "assignLHS", 
		"expr", "unaryOper", "type"
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
			setState(48); expr(0);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(49); match(COMMA);
				setState(50); expr(0);
				}
				}
				setState(55);
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
			setState(56); match(OPEN_SQPARENTHESES);
			setState(65);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << CHARLITER) | (1L << STRINGLITER) | (1L << BOOLLITER) | (1L << PAIRLITER) | (1L << IDENT))) != 0)) {
				{
				setState(57); expr(0);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(58); match(COMMA);
					setState(59); expr(0);
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(67); match(CLOSE_SQPARENTHESES);
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
			setState(69); ((ArrayElemContext)_localctx).name = match(IDENT);
			setState(74); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(70); match(OPEN_SQPARENTHESES);
					setState(71); expr(0);
					setState(72); match(CLOSE_SQPARENTHESES);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(76); 
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
			setState(82);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(78); match(FST);
				setState(79); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(80); match(SND);
				setState(81); expr(0);
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
			setState(84);
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
			setState(86);
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
			setState(88);
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
			setState(90);
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
			setState(92);
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
			setState(95);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(94); sign();
				}
			}

			setState(97); match(INTEGER);
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
			setState(99); param();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(100); match(COMMA);
				setState(101); param();
				}
				}
				setState(106);
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
			setState(107); type();
			setState(108); match(IDENT);
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
			setState(110); match(PAIR);
			setState(111); match(OPEN_PARENTHESES);
			setState(112); pairElemType();
			setState(113); match(COMMA);
			setState(114); pairElemType();
			setState(115); match(CLOSE_PARENTHESES);
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
			setState(120);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118); arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(119); match(PAIR);
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
			setState(124);
			switch (_input.LA(1)) {
			case BOOL:
			case CHAR:
			case STRING:
			case INT:
				{
				setState(122); baseType();
				}
				break;
			case PAIR:
				{
				setState(123); pairType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(126); match(OPEN_SQPARENTHESES);
				setState(127); match(CLOSE_SQPARENTHESES);
				}
				}
				setState(130); 
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
			setState(132);
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
		enterRule(_localctx, 32, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(134); match(BEGIN);
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(135); func();
					}
					} 
				}
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(141); stat(0);
			setState(142); match(END);
			setState(143); match(EOF);
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
		enterRule(_localctx, 34, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); type();
			setState(146); match(IDENT);
			setState(147); match(OPEN_PARENTHESES);
			setState(149);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAIR) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				setState(148); paramList();
				}
			}

			setState(151); match(CLOSE_PARENTHESES);
			setState(152); match(IS);
			setState(153); stat(0);
			setState(154); match(END);
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			switch (_input.LA(1)) {
			case SKIP_:
				{
				_localctx = new Skip_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(157); match(SKIP_);
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
				setState(158); type();
				setState(159); match(IDENT);
				setState(160); match(ASSIGN);
				setState(161); assignRHS();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				_localctx = new Assign_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163); assignLHS();
				setState(164); match(ASSIGN);
				setState(165); assignRHS();
				}
				break;
			case READ:
				{
				_localctx = new Read_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167); match(READ);
				setState(168); assignLHS();
				}
				break;
			case FREE:
				{
				_localctx = new Free_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169); match(FREE);
				setState(170); expr(0);
				}
				break;
			case RETURN:
				{
				_localctx = new Return_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171); match(RETURN);
				setState(172); expr(0);
				}
				break;
			case EXIT:
				{
				_localctx = new Exit_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173); match(EXIT);
				setState(174); expr(0);
				}
				break;
			case PRINT:
				{
				_localctx = new Print_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175); match(PRINT);
				setState(176); expr(0);
				}
				break;
			case PRINTLN:
				{
				_localctx = new Println_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177); match(PRINTLN);
				setState(178); expr(0);
				}
				break;
			case IF:
				{
				_localctx = new If_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179); match(IF);
				setState(180); expr(0);
				setState(181); match(THEN);
				setState(182); stat(0);
				setState(183); match(ELSE);
				setState(184); stat(0);
				setState(185); match(FI);
				}
				break;
			case WHILE:
				{
				_localctx = new While_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187); match(WHILE);
				setState(188); expr(0);
				setState(189); match(DO);
				setState(190); stat(0);
				setState(191); match(DONE);
				}
				break;
			case BEGIN:
				{
				_localctx = new Scope_statContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193); match(BEGIN);
				setState(194); stat(0);
				setState(195); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Sequential_statContext(new StatContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(199);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(200); match(SEMICOLON);
					setState(201); stat(2);
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		enterRule(_localctx, 38, RULE_assignRHS);
		int _la;
		try {
			setState(224);
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
				setState(207); expr(0);
				}
				break;
			case OPEN_SQPARENTHESES:
				_localctx = new Assignr_arrayliterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(208); arrayLiter();
				}
				break;
			case NEWPAIR:
				_localctx = new Assignr_newpairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(209); match(NEWPAIR);
				setState(210); match(OPEN_PARENTHESES);
				setState(211); expr(0);
				setState(212); match(COMMA);
				setState(213); expr(0);
				setState(214); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				_localctx = new Assignr_pairelemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(216); pairElem();
				}
				break;
			case CALL:
				_localctx = new Assignr_callContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(217); match(CALL);
				setState(218); match(IDENT);
				setState(219); match(OPEN_PARENTHESES);
				setState(221);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << CHARLITER) | (1L << STRINGLITER) | (1L << BOOLLITER) | (1L << PAIRLITER) | (1L << IDENT))) != 0)) {
					{
					setState(220); argList();
					}
				}

				setState(223); match(CLOSE_PARENTHESES);
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
		enterRule(_localctx, 40, RULE_assignLHS);
		try {
			setState(229);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new Assignl_idContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(226); match(IDENT);
				}
				break;
			case 2:
				_localctx = new Assignl_arrayelemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(227); arrayElem();
				}
				break;
			case 3:
				_localctx = new Assignl_pairelemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(228); pairElem();
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new Int_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(232); intliter();
				}
				break;
			case 2:
				{
				_localctx = new Bool_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(233); match(BOOLLITER);
				}
				break;
			case 3:
				{
				_localctx = new Char_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234); match(CHARLITER);
				}
				break;
			case 4:
				{
				_localctx = new String_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235); match(STRINGLITER);
				}
				break;
			case 5:
				{
				_localctx = new Pair_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236); match(PAIRLITER);
				}
				break;
			case 6:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237); match(IDENT);
				}
				break;
			case 7:
				{
				_localctx = new ArrayElem_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238); arrayElem();
				}
				break;
			case 8:
				{
				_localctx = new Unary_opContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239); unaryOper();
				}
				break;
			case 9:
				{
				_localctx = new Paren_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240); match(OPEN_PARENTHESES);
				setState(241); expr(0);
				setState(242); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(270);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(268);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new Binary_opIntHigherContext(new ExprContext(_parentctx, _parentState));
						((Binary_opIntHigherContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(246);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(247); binaryOper_IntHigher();
						setState(248); ((Binary_opIntHigherContext)_localctx).exprR = expr(8);
						}
						break;
					case 2:
						{
						_localctx = new Binary_opIntLowerContext(new ExprContext(_parentctx, _parentState));
						((Binary_opIntLowerContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(251); binaryOper_IntLower();
						setState(252); ((Binary_opIntLowerContext)_localctx).exprR = expr(7);
						}
						break;
					case 3:
						{
						_localctx = new Binary_opCompareHigherContext(new ExprContext(_parentctx, _parentState));
						((Binary_opCompareHigherContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(255); binaryOper_CompareHigher();
						setState(256); ((Binary_opCompareHigherContext)_localctx).exprR = expr(6);
						}
						break;
					case 4:
						{
						_localctx = new Binary_opCompareLowerContext(new ExprContext(_parentctx, _parentState));
						((Binary_opCompareLowerContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(258);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(259); binaryOper_CompareLower();
						setState(260); ((Binary_opCompareLowerContext)_localctx).exprR = expr(5);
						}
						break;
					case 5:
						{
						_localctx = new Binary_opAndContext(new ExprContext(_parentctx, _parentState));
						((Binary_opAndContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(262);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(263); match(AND);
						setState(264); ((Binary_opAndContext)_localctx).exprR = expr(4);
						}
						break;
					case 6:
						{
						_localctx = new Binary_opOrContext(new ExprContext(_parentctx, _parentState));
						((Binary_opOrContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(265);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(266); match(OR);
						setState(267); ((Binary_opOrContext)_localctx).exprR = expr(3);
						}
						break;
					}
					} 
				}
				setState(272);
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
		enterRule(_localctx, 44, RULE_unaryOper);
		try {
			setState(283);
			switch (_input.LA(1)) {
			case NOT:
				_localctx = new Uary_opNotContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(273); match(NOT);
				setState(274); expr(0);
				}
				break;
			case MINUS:
				_localctx = new Unary_opNegContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(275); match(MINUS);
				setState(276); expr(0);
				}
				break;
			case LEN:
				_localctx = new Unary_opLenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(277); match(LEN);
				setState(278); expr(0);
				}
				break;
			case ORD:
				_localctx = new Unary_opOrdContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(279); match(ORD);
				setState(280); expr(0);
				}
				break;
			case CHR:
				_localctx = new Unary_opChrContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(281); match(CHR);
				setState(282); expr(0);
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
		enterRule(_localctx, 46, RULE_type);
		try {
			setState(288);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(285); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(286); arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(287); pairType();
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
		case 18: return stat_sempred((StatContext)_localctx, predIndex);
		case 21: return expr_sempred((ExprContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u0125\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\7\2\66\n\2\f\2\16\29\13\2\3\3\3\3\3\3\3\3\7\3?\n\3\f\3\16"+
		"\3B\13\3\5\3D\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\6\4M\n\4\r\4\16\4N\3\5\3"+
		"\5\3\5\3\5\5\5U\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\5\13"+
		"b\n\13\3\13\3\13\3\f\3\f\3\f\7\fi\n\f\f\f\16\fl\13\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17{\n\17\3\20\3\20\5\20"+
		"\177\n\20\3\20\3\20\6\20\u0083\n\20\r\20\16\20\u0084\3\21\3\21\3\22\3"+
		"\22\7\22\u008b\n\22\f\22\16\22\u008e\13\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\5\23\u0098\n\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00c8\n\24\3\24"+
		"\3\24\3\24\7\24\u00cd\n\24\f\24\16\24\u00d0\13\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00e0\n\25\3\25"+
		"\5\25\u00e3\n\25\3\26\3\26\3\26\5\26\u00e8\n\26\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00f7\n\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u010f\n\27\f\27\16\27\u0112\13\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u011e\n\30\3\31"+
		"\3\31\3\31\5\31\u0123\n\31\3\31\2\4&,\32\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\2\7\3\2$&\3\2\"#\3\2\'*\3\2+,\3\2\r\20\u0140\2\62"+
		"\3\2\2\2\4:\3\2\2\2\6G\3\2\2\2\bT\3\2\2\2\nV\3\2\2\2\fX\3\2\2\2\16Z\3"+
		"\2\2\2\20\\\3\2\2\2\22^\3\2\2\2\24a\3\2\2\2\26e\3\2\2\2\30m\3\2\2\2\32"+
		"p\3\2\2\2\34z\3\2\2\2\36~\3\2\2\2 \u0086\3\2\2\2\"\u0088\3\2\2\2$\u0093"+
		"\3\2\2\2&\u00c7\3\2\2\2(\u00e2\3\2\2\2*\u00e7\3\2\2\2,\u00f6\3\2\2\2."+
		"\u011d\3\2\2\2\60\u0122\3\2\2\2\62\67\5,\27\2\63\64\7\6\2\2\64\66\5,\27"+
		"\2\65\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\3\3\2\2\29\67"+
		"\3\2\2\2:C\7\65\2\2;@\5,\27\2<=\7\6\2\2=?\5,\27\2><\3\2\2\2?B\3\2\2\2"+
		"@>\3\2\2\2@A\3\2\2\2AD\3\2\2\2B@\3\2\2\2C;\3\2\2\2CD\3\2\2\2DE\3\2\2\2"+
		"EF\7\66\2\2F\5\3\2\2\2GL\7<\2\2HI\7\65\2\2IJ\5,\27\2JK\7\66\2\2KM\3\2"+
		"\2\2LH\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\7\3\2\2\2PQ\7\t\2\2QU\5"+
		",\27\2RS\7\n\2\2SU\5,\27\2TP\3\2\2\2TR\3\2\2\2U\t\3\2\2\2VW\t\2\2\2W\13"+
		"\3\2\2\2XY\t\3\2\2Y\r\3\2\2\2Z[\t\4\2\2[\17\3\2\2\2\\]\t\5\2\2]\21\3\2"+
		"\2\2^_\t\3\2\2_\23\3\2\2\2`b\5\22\n\2a`\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd"+
		"\7\67\2\2d\25\3\2\2\2ej\5\30\r\2fg\7\6\2\2gi\5\30\r\2hf\3\2\2\2il\3\2"+
		"\2\2jh\3\2\2\2jk\3\2\2\2k\27\3\2\2\2lj\3\2\2\2mn\5\60\31\2no\7<\2\2o\31"+
		"\3\2\2\2pq\7\f\2\2qr\7\63\2\2rs\5\34\17\2st\7\6\2\2tu\5\34\17\2uv\7\64"+
		"\2\2v\33\3\2\2\2w{\5 \21\2x{\5\36\20\2y{\7\f\2\2zw\3\2\2\2zx\3\2\2\2z"+
		"y\3\2\2\2{\35\3\2\2\2|\177\5 \21\2}\177\5\32\16\2~|\3\2\2\2~}\3\2\2\2"+
		"\177\u0082\3\2\2\2\u0080\u0081\7\65\2\2\u0081\u0083\7\66\2\2\u0082\u0080"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\37\3\2\2\2\u0086\u0087\t\6\2\2\u0087!\3\2\2\2\u0088\u008c\7\37\2\2\u0089"+
		"\u008b\5$\23\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f"+
		"\u0090\5&\24\2\u0090\u0091\7 \2\2\u0091\u0092\7\2\2\3\u0092#\3\2\2\2\u0093"+
		"\u0094\5\60\31\2\u0094\u0095\7<\2\2\u0095\u0097\7\63\2\2\u0096\u0098\5"+
		"\26\f\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009a\7\64\2\2\u009a\u009b\7!\2\2\u009b\u009c\5&\24\2\u009c\u009d\7 "+
		"\2\2\u009d%\3\2\2\2\u009e\u009f\b\24\1\2\u009f\u00c8\7\21\2\2\u00a0\u00a1"+
		"\5\60\31\2\u00a1\u00a2\7<\2\2\u00a2\u00a3\7\4\2\2\u00a3\u00a4\5(\25\2"+
		"\u00a4\u00c8\3\2\2\2\u00a5\u00a6\5*\26\2\u00a6\u00a7\7\4\2\2\u00a7\u00a8"+
		"\5(\25\2\u00a8\u00c8\3\2\2\2\u00a9\u00aa\7\22\2\2\u00aa\u00c8\5*\26\2"+
		"\u00ab\u00ac\7\23\2\2\u00ac\u00c8\5,\27\2\u00ad\u00ae\7\24\2\2\u00ae\u00c8"+
		"\5,\27\2\u00af\u00b0\7\25\2\2\u00b0\u00c8\5,\27\2\u00b1\u00b2\7\26\2\2"+
		"\u00b2\u00c8\5,\27\2\u00b3\u00b4\7\27\2\2\u00b4\u00c8\5,\27\2\u00b5\u00b6"+
		"\7\30\2\2\u00b6\u00b7\5,\27\2\u00b7\u00b8\7\31\2\2\u00b8\u00b9\5&\24\2"+
		"\u00b9\u00ba\7\32\2\2\u00ba\u00bb\5&\24\2\u00bb\u00bc\7\33\2\2\u00bc\u00c8"+
		"\3\2\2\2\u00bd\u00be\7\34\2\2\u00be\u00bf\5,\27\2\u00bf\u00c0\7\35\2\2"+
		"\u00c0\u00c1\5&\24\2\u00c1\u00c2\7\36\2\2\u00c2\u00c8\3\2\2\2\u00c3\u00c4"+
		"\7\37\2\2\u00c4\u00c5\5&\24\2\u00c5\u00c6\7 \2\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u009e\3\2\2\2\u00c7\u00a0\3\2\2\2\u00c7\u00a5\3\2\2\2\u00c7\u00a9\3\2"+
		"\2\2\u00c7\u00ab\3\2\2\2\u00c7\u00ad\3\2\2\2\u00c7\u00af\3\2\2\2\u00c7"+
		"\u00b1\3\2\2\2\u00c7\u00b3\3\2\2\2\u00c7\u00b5\3\2\2\2\u00c7\u00bd\3\2"+
		"\2\2\u00c7\u00c3\3\2\2\2\u00c8\u00ce\3\2\2\2\u00c9\u00ca\f\3\2\2\u00ca"+
		"\u00cb\7\5\2\2\u00cb\u00cd\5&\24\4\u00cc\u00c9\3\2\2\2\u00cd\u00d0\3\2"+
		"\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\'\3\2\2\2\u00d0\u00ce"+
		"\3\2\2\2\u00d1\u00e3\5,\27\2\u00d2\u00e3\5\4\3\2\u00d3\u00d4\7\b\2\2\u00d4"+
		"\u00d5\7\63\2\2\u00d5\u00d6\5,\27\2\u00d6\u00d7\7\6\2\2\u00d7\u00d8\5"+
		",\27\2\u00d8\u00d9\7\64\2\2\u00d9\u00e3\3\2\2\2\u00da\u00e3\5\b\5\2\u00db"+
		"\u00dc\7\13\2\2\u00dc\u00dd\7<\2\2\u00dd\u00df\7\63\2\2\u00de\u00e0\5"+
		"\2\2\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e3\7\64\2\2\u00e2\u00d1\3\2\2\2\u00e2\u00d2\3\2\2\2\u00e2\u00d3\3"+
		"\2\2\2\u00e2\u00da\3\2\2\2\u00e2\u00db\3\2\2\2\u00e3)\3\2\2\2\u00e4\u00e8"+
		"\7<\2\2\u00e5\u00e8\5\6\4\2\u00e6\u00e8\5\b\5\2\u00e7\u00e4\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8+\3\2\2\2\u00e9\u00ea\b\27\1\2"+
		"\u00ea\u00f7\5\24\13\2\u00eb\u00f7\7:\2\2\u00ec\u00f7\78\2\2\u00ed\u00f7"+
		"\79\2\2\u00ee\u00f7\7;\2\2\u00ef\u00f7\7<\2\2\u00f0\u00f7\5\6\4\2\u00f1"+
		"\u00f7\5.\30\2\u00f2\u00f3\7\63\2\2\u00f3\u00f4\5,\27\2\u00f4\u00f5\7"+
		"\64\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00e9\3\2\2\2\u00f6\u00eb\3\2\2\2\u00f6"+
		"\u00ec\3\2\2\2\u00f6\u00ed\3\2\2\2\u00f6\u00ee\3\2\2\2\u00f6\u00ef\3\2"+
		"\2\2\u00f6\u00f0\3\2\2\2\u00f6\u00f1\3\2\2\2\u00f6\u00f2\3\2\2\2\u00f7"+
		"\u0110\3\2\2\2\u00f8\u00f9\f\t\2\2\u00f9\u00fa\5\n\6\2\u00fa\u00fb\5,"+
		"\27\n\u00fb\u010f\3\2\2\2\u00fc\u00fd\f\b\2\2\u00fd\u00fe\5\f\7\2\u00fe"+
		"\u00ff\5,\27\t\u00ff\u010f\3\2\2\2\u0100\u0101\f\7\2\2\u0101\u0102\5\16"+
		"\b\2\u0102\u0103\5,\27\b\u0103\u010f\3\2\2\2\u0104\u0105\f\6\2\2\u0105"+
		"\u0106\5\20\t\2\u0106\u0107\5,\27\7\u0107\u010f\3\2\2\2\u0108\u0109\f"+
		"\5\2\2\u0109\u010a\7-\2\2\u010a\u010f\5,\27\6\u010b\u010c\f\4\2\2\u010c"+
		"\u010d\7.\2\2\u010d\u010f\5,\27\5\u010e\u00f8\3\2\2\2\u010e\u00fc\3\2"+
		"\2\2\u010e\u0100\3\2\2\2\u010e\u0104\3\2\2\2\u010e\u0108\3\2\2\2\u010e"+
		"\u010b\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2"+
		"\2\2\u0111-\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0114\7/\2\2\u0114\u011e"+
		"\5,\27\2\u0115\u0116\7#\2\2\u0116\u011e\5,\27\2\u0117\u0118\7\60\2\2\u0118"+
		"\u011e\5,\27\2\u0119\u011a\7\61\2\2\u011a\u011e\5,\27\2\u011b\u011c\7"+
		"\62\2\2\u011c\u011e\5,\27\2\u011d\u0113\3\2\2\2\u011d\u0115\3\2\2\2\u011d"+
		"\u0117\3\2\2\2\u011d\u0119\3\2\2\2\u011d\u011b\3\2\2\2\u011e/\3\2\2\2"+
		"\u011f\u0123\5 \21\2\u0120\u0123\5\36\20\2\u0121\u0123\5\32\16\2\u0122"+
		"\u011f\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0121\3\2\2\2\u0123\61\3\2\2"+
		"\2\30\67@CNTajz~\u0084\u008c\u0097\u00c7\u00ce\u00df\u00e2\u00e7\u00f6"+
		"\u010e\u0110\u011d\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}