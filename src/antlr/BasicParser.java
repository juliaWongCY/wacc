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
		AND=43, OR=44, INCREMENT=45, DECREMENT=46, NOT=47, LEN=48, ORD=49, CHR=50, 
		OPEN_PARENTHESES=51, CLOSE_PARENTHESES=52, OPEN_SQPARENTHESES=53, CLOSE_SQPARENTHESES=54, 
		INTEGER=55, CHARLITER=56, STRINGLITER=57, BOOLLITER=58, PAIRLITER=59, 
		IDENT=60;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "'='", "';'", "','", "COMMENT", "'newpair'", "'fst'", 
		"'snd'", "'call'", "'pair'", "'bool'", "'char'", "'string'", "'int'", 
		"'skip'", "'read'", "'free'", "'return'", "'exit'", "'print'", "'println'", 
		"'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", "'begin'", 
		"'end'", "'is'", "'+'", "'-'", "'*'", "'/'", "'%'", "'>'", "'>='", "'<'", 
		"'<='", "'=='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'!'", "'len'", 
		"'ord'", "'chr'", "'('", "')'", "'['", "']'", "INTEGER", "CHARLITER", 
		"STRINGLITER", "BOOLLITER", "'null'", "IDENT"
	};
	public static final int
		RULE_argList = 0, RULE_arrayLiter = 1, RULE_arrayElem = 2, RULE_pairElem = 3, 
		RULE_binaryOper_IntHigher = 4, RULE_binaryOper_IntLower = 5, RULE_binaryOper_CompareHigher = 6, 
		RULE_binaryOper_CompareLower = 7, RULE_sideeffecting = 8, RULE_sign = 9, 
		RULE_intliter = 10, RULE_paramList = 11, RULE_param = 12, RULE_pairType = 13, 
		RULE_pairElemType = 14, RULE_arrayType = 15, RULE_baseType = 16, RULE_program = 17, 
		RULE_func = 18, RULE_statList = 19, RULE_stat = 20, RULE_assignRHS = 21, 
		RULE_assignLHS = 22, RULE_expr = 23, RULE_unaryOper = 24, RULE_type = 25;
	public static final String[] ruleNames = {
		"argList", "arrayLiter", "arrayElem", "pairElem", "binaryOper_IntHigher", 
		"binaryOper_IntLower", "binaryOper_CompareHigher", "binaryOper_CompareLower", 
		"sideeffecting", "sign", "intliter", "paramList", "param", "pairType", 
		"pairElemType", "arrayType", "baseType", "program", "func", "statList", 
		"stat", "assignRHS", "assignLHS", "expr", "unaryOper", "type"
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
			setState(52); expr(0);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(53); match(COMMA);
				setState(54); expr(0);
				}
				}
				setState(59);
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
			setState(60); match(OPEN_SQPARENTHESES);
			setState(69);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << CHARLITER) | (1L << STRINGLITER) | (1L << BOOLLITER) | (1L << PAIRLITER) | (1L << IDENT))) != 0)) {
				{
				setState(61); expr(0);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(62); match(COMMA);
					setState(63); expr(0);
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(71); match(CLOSE_SQPARENTHESES);
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
			setState(73); ((ArrayElemContext)_localctx).name = match(IDENT);
			setState(78); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(74); match(OPEN_SQPARENTHESES);
					setState(75); expr(0);
					setState(76); match(CLOSE_SQPARENTHESES);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(80); 
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
			setState(86);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(82); match(FST);
				setState(83); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(84); match(SND);
				setState(85); expr(0);
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
			setState(88);
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
			setState(90);
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
			setState(92);
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
			setState(94);
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

	public static class SideeffectingContext extends ParserRuleContext {
		public TerminalNode INCREMENT() { return getToken(BasicParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(BasicParser.DECREMENT, 0); }
		public SideeffectingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sideeffecting; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitSideeffecting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SideeffectingContext sideeffecting() throws RecognitionException {
		SideeffectingContext _localctx = new SideeffectingContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sideeffecting);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_la = _input.LA(1);
			if ( !(_la==INCREMENT || _la==DECREMENT) ) {
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
		enterRule(_localctx, 18, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
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
		enterRule(_localctx, 20, RULE_intliter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(100); sign();
				}
			}

			setState(103); match(INTEGER);
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
		enterRule(_localctx, 22, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); param();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(106); match(COMMA);
				setState(107); param();
				}
				}
				setState(112);
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
		enterRule(_localctx, 24, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); type();
			setState(114); match(IDENT);
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
		enterRule(_localctx, 26, RULE_pairType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(PAIR);
			setState(117); match(OPEN_PARENTHESES);
			setState(118); pairElemType();
			setState(119); match(COMMA);
			setState(120); pairElemType();
			setState(121); match(CLOSE_PARENTHESES);
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
		enterRule(_localctx, 28, RULE_pairElemType);
		try {
			setState(126);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124); arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125); match(PAIR);
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
		enterRule(_localctx, 30, RULE_arrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			switch (_input.LA(1)) {
			case BOOL:
			case CHAR:
			case STRING:
			case INT:
				{
				setState(128); baseType();
				}
				break;
			case PAIR:
				{
				setState(129); pairType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(132); match(OPEN_SQPARENTHESES);
				setState(133); match(CLOSE_SQPARENTHESES);
				}
				}
				setState(136); 
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
		enterRule(_localctx, 32, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
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
		enterRule(_localctx, 34, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(140); match(BEGIN);
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(141); func();
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(147); statList();
			setState(148); match(END);
			setState(149); match(EOF);
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
		enterRule(_localctx, 36, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); type();
			setState(152); match(IDENT);
			setState(153); match(OPEN_PARENTHESES);
			setState(155);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PAIR) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				setState(154); paramList();
				}
			}

			setState(157); match(CLOSE_PARENTHESES);
			setState(158); match(IS);
			setState(159); statList();
			setState(160); match(END);
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
		enterRule(_localctx, 38, RULE_statList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); stat();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(163); match(SEMICOLON);
				setState(164); stat();
				}
				}
				setState(169);
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
	public static class Sideeffect_statContext extends StatContext {
		public SideeffectingContext sideeffecting() {
			return getRuleContext(SideeffectingContext.class,0);
		}
		public AssignLHSContext assignLHS() {
			return getRuleContext(AssignLHSContext.class,0);
		}
		public Sideeffect_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitSideeffect_stat(this);
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

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stat);
		try {
			setState(213);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new Skip_statContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(170); match(SKIP_);
				}
				break;
			case 2:
				_localctx = new Declare_statContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(171); type();
				setState(172); match(IDENT);
				setState(173); match(ASSIGN);
				setState(174); assignRHS();
				}
				break;
			case 3:
				_localctx = new Sideeffect_statContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(176); assignLHS();
				setState(177); sideeffecting();
				}
				break;
			case 4:
				_localctx = new Assign_statContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(179); assignLHS();
				setState(180); match(ASSIGN);
				setState(181); assignRHS();
				}
				break;
			case 5:
				_localctx = new Read_statContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(183); match(READ);
				setState(184); assignLHS();
				}
				break;
			case 6:
				_localctx = new Free_statContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(185); match(FREE);
				setState(186); expr(0);
				}
				break;
			case 7:
				_localctx = new Return_statContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(187); match(RETURN);
				setState(188); expr(0);
				}
				break;
			case 8:
				_localctx = new Exit_statContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(189); match(EXIT);
				setState(190); expr(0);
				}
				break;
			case 9:
				_localctx = new Print_statContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(191); match(PRINT);
				setState(192); expr(0);
				}
				break;
			case 10:
				_localctx = new Println_statContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(193); match(PRINTLN);
				setState(194); expr(0);
				}
				break;
			case 11:
				_localctx = new If_statContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(195); match(IF);
				setState(196); expr(0);
				setState(197); match(THEN);
				setState(198); statList();
				setState(199); match(ELSE);
				setState(200); statList();
				setState(201); match(FI);
				}
				break;
			case 12:
				_localctx = new While_statContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(203); match(WHILE);
				setState(204); expr(0);
				setState(205); match(DO);
				setState(206); statList();
				setState(207); match(DONE);
				}
				break;
			case 13:
				_localctx = new Scope_statContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(209); match(BEGIN);
				setState(210); statList();
				setState(211); match(END);
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
		enterRule(_localctx, 42, RULE_assignRHS);
		int _la;
		try {
			setState(232);
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
				setState(215); expr(0);
				}
				break;
			case OPEN_SQPARENTHESES:
				_localctx = new Assignr_arrayliterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(216); arrayLiter();
				}
				break;
			case NEWPAIR:
				_localctx = new Assignr_newpairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(217); match(NEWPAIR);
				setState(218); match(OPEN_PARENTHESES);
				setState(219); expr(0);
				setState(220); match(COMMA);
				setState(221); expr(0);
				setState(222); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				_localctx = new Assignr_pairelemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(224); pairElem();
				}
				break;
			case CALL:
				_localctx = new Assignr_callContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(225); match(CALL);
				setState(226); match(IDENT);
				setState(227); match(OPEN_PARENTHESES);
				setState(229);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << CHARLITER) | (1L << STRINGLITER) | (1L << BOOLLITER) | (1L << PAIRLITER) | (1L << IDENT))) != 0)) {
					{
					setState(228); argList();
					}
				}

				setState(231); match(CLOSE_PARENTHESES);
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
		enterRule(_localctx, 44, RULE_assignLHS);
		try {
			setState(237);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new Assignl_idContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(234); match(IDENT);
				}
				break;
			case 2:
				_localctx = new Assignl_arrayelemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(235); arrayElem();
				}
				break;
			case 3:
				_localctx = new Assignl_pairelemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(236); pairElem();
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new Int_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(240); intliter();
				}
				break;
			case 2:
				{
				_localctx = new Bool_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241); match(BOOLLITER);
				}
				break;
			case 3:
				{
				_localctx = new Char_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242); match(CHARLITER);
				}
				break;
			case 4:
				{
				_localctx = new String_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(243); match(STRINGLITER);
				}
				break;
			case 5:
				{
				_localctx = new Pair_literContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244); match(PAIRLITER);
				}
				break;
			case 6:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(245); match(IDENT);
				}
				break;
			case 7:
				{
				_localctx = new ArrayElem_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(246); arrayElem();
				}
				break;
			case 8:
				{
				_localctx = new Unary_opContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(247); unaryOper();
				}
				break;
			case 9:
				{
				_localctx = new Paren_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(248); match(OPEN_PARENTHESES);
				setState(249); expr(0);
				setState(250); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(278);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(276);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new Binary_opIntHigherContext(new ExprContext(_parentctx, _parentState));
						((Binary_opIntHigherContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(255); binaryOper_IntHigher();
						setState(256); ((Binary_opIntHigherContext)_localctx).exprR = expr(8);
						}
						break;
					case 2:
						{
						_localctx = new Binary_opIntLowerContext(new ExprContext(_parentctx, _parentState));
						((Binary_opIntLowerContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(258);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(259); binaryOper_IntLower();
						setState(260); ((Binary_opIntLowerContext)_localctx).exprR = expr(7);
						}
						break;
					case 3:
						{
						_localctx = new Binary_opCompareHigherContext(new ExprContext(_parentctx, _parentState));
						((Binary_opCompareHigherContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(262);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(263); binaryOper_CompareHigher();
						setState(264); ((Binary_opCompareHigherContext)_localctx).exprR = expr(6);
						}
						break;
					case 4:
						{
						_localctx = new Binary_opCompareLowerContext(new ExprContext(_parentctx, _parentState));
						((Binary_opCompareLowerContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(266);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(267); binaryOper_CompareLower();
						setState(268); ((Binary_opCompareLowerContext)_localctx).exprR = expr(5);
						}
						break;
					case 5:
						{
						_localctx = new Binary_opAndContext(new ExprContext(_parentctx, _parentState));
						((Binary_opAndContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(270);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(271); match(AND);
						setState(272); ((Binary_opAndContext)_localctx).exprR = expr(4);
						}
						break;
					case 6:
						{
						_localctx = new Binary_opOrContext(new ExprContext(_parentctx, _parentState));
						((Binary_opOrContext)_localctx).exprL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(273);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(274); match(OR);
						setState(275); ((Binary_opOrContext)_localctx).exprR = expr(3);
						}
						break;
					}
					} 
				}
				setState(280);
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
		enterRule(_localctx, 48, RULE_unaryOper);
		try {
			setState(291);
			switch (_input.LA(1)) {
			case NOT:
				_localctx = new Uary_opNotContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(281); match(NOT);
				setState(282); expr(0);
				}
				break;
			case MINUS:
				_localctx = new Unary_opNegContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(283); match(MINUS);
				setState(284); expr(0);
				}
				break;
			case LEN:
				_localctx = new Unary_opLenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(285); match(LEN);
				setState(286); expr(0);
				}
				break;
			case ORD:
				_localctx = new Unary_opOrdContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(287); match(ORD);
				setState(288); expr(0);
				}
				break;
			case CHR:
				_localctx = new Unary_opChrContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(289); match(CHR);
				setState(290); expr(0);
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
		enterRule(_localctx, 50, RULE_type);
		try {
			setState(296);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(293); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(294); arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(295); pairType();
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
		case 23: return expr_sempred((ExprContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3>\u012d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\7\2:\n\2\f\2\16\2=\13\2\3\3\3\3\3\3\3"+
		"\3\7\3C\n\3\f\3\16\3F\13\3\5\3H\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\6\4Q\n"+
		"\4\r\4\16\4R\3\5\3\5\3\5\3\5\5\5Y\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\f\5\fh\n\f\3\f\3\f\3\r\3\r\3\r\7\ro\n\r\f\r\16\r"+
		"r\13\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\5\20\u0081\n\20\3\21\3\21\5\21\u0085\n\21\3\21\3\21\6\21\u0089\n\21\r"+
		"\21\16\21\u008a\3\22\3\22\3\23\3\23\7\23\u0091\n\23\f\23\16\23\u0094\13"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u009e\n\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\7\25\u00a8\n\25\f\25\16\25\u00ab\13\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u00d8\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u00e8\n\27\3\27\5\27\u00eb\n\27\3\30\3\30\3"+
		"\30\5\30\u00f0\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u00ff\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\7\31\u0117\n\31\f\31\16\31\u011a\13\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\5\32\u0126\n\32\3\33\3\33\3\33\5\33\u012b\n\33\3"+
		"\33\2\3\60\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\2\b\3\2$&\3\2\"#\3\2\'*\3\2+,\3\2/\60\3\2\r\20\u0147\2\66\3\2\2\2\4>"+
		"\3\2\2\2\6K\3\2\2\2\bX\3\2\2\2\nZ\3\2\2\2\f\\\3\2\2\2\16^\3\2\2\2\20`"+
		"\3\2\2\2\22b\3\2\2\2\24d\3\2\2\2\26g\3\2\2\2\30k\3\2\2\2\32s\3\2\2\2\34"+
		"v\3\2\2\2\36\u0080\3\2\2\2 \u0084\3\2\2\2\"\u008c\3\2\2\2$\u008e\3\2\2"+
		"\2&\u0099\3\2\2\2(\u00a4\3\2\2\2*\u00d7\3\2\2\2,\u00ea\3\2\2\2.\u00ef"+
		"\3\2\2\2\60\u00fe\3\2\2\2\62\u0125\3\2\2\2\64\u012a\3\2\2\2\66;\5\60\31"+
		"\2\678\7\6\2\28:\5\60\31\29\67\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<"+
		"\3\3\2\2\2=;\3\2\2\2>G\7\67\2\2?D\5\60\31\2@A\7\6\2\2AC\5\60\31\2B@\3"+
		"\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EH\3\2\2\2FD\3\2\2\2G?\3\2\2\2GH\3"+
		"\2\2\2HI\3\2\2\2IJ\78\2\2J\5\3\2\2\2KP\7>\2\2LM\7\67\2\2MN\5\60\31\2N"+
		"O\78\2\2OQ\3\2\2\2PL\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\7\3\2\2\2"+
		"TU\7\t\2\2UY\5\60\31\2VW\7\n\2\2WY\5\60\31\2XT\3\2\2\2XV\3\2\2\2Y\t\3"+
		"\2\2\2Z[\t\2\2\2[\13\3\2\2\2\\]\t\3\2\2]\r\3\2\2\2^_\t\4\2\2_\17\3\2\2"+
		"\2`a\t\5\2\2a\21\3\2\2\2bc\t\6\2\2c\23\3\2\2\2de\t\3\2\2e\25\3\2\2\2f"+
		"h\5\24\13\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2ij\79\2\2j\27\3\2\2\2kp\5\32"+
		"\16\2lm\7\6\2\2mo\5\32\16\2nl\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\31"+
		"\3\2\2\2rp\3\2\2\2st\5\64\33\2tu\7>\2\2u\33\3\2\2\2vw\7\f\2\2wx\7\65\2"+
		"\2xy\5\36\20\2yz\7\6\2\2z{\5\36\20\2{|\7\66\2\2|\35\3\2\2\2}\u0081\5\""+
		"\22\2~\u0081\5 \21\2\177\u0081\7\f\2\2\u0080}\3\2\2\2\u0080~\3\2\2\2\u0080"+
		"\177\3\2\2\2\u0081\37\3\2\2\2\u0082\u0085\5\"\22\2\u0083\u0085\5\34\17"+
		"\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0087"+
		"\7\67\2\2\u0087\u0089\78\2\2\u0088\u0086\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b!\3\2\2\2\u008c\u008d\t\7\2\2"+
		"\u008d#\3\2\2\2\u008e\u0092\7\37\2\2\u008f\u0091\5&\24\2\u0090\u008f\3"+
		"\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\5(\25\2\u0096\u0097\7 "+
		"\2\2\u0097\u0098\7\2\2\3\u0098%\3\2\2\2\u0099\u009a\5\64\33\2\u009a\u009b"+
		"\7>\2\2\u009b\u009d\7\65\2\2\u009c\u009e\5\30\r\2\u009d\u009c\3\2\2\2"+
		"\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\7\66\2\2\u00a0\u00a1"+
		"\7!\2\2\u00a1\u00a2\5(\25\2\u00a2\u00a3\7 \2\2\u00a3\'\3\2\2\2\u00a4\u00a9"+
		"\5*\26\2\u00a5\u00a6\7\5\2\2\u00a6\u00a8\5*\26\2\u00a7\u00a5\3\2\2\2\u00a8"+
		"\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa)\3\2\2\2"+
		"\u00ab\u00a9\3\2\2\2\u00ac\u00d8\7\21\2\2\u00ad\u00ae\5\64\33\2\u00ae"+
		"\u00af\7>\2\2\u00af\u00b0\7\4\2\2\u00b0\u00b1\5,\27\2\u00b1\u00d8\3\2"+
		"\2\2\u00b2\u00b3\5.\30\2\u00b3\u00b4\5\22\n\2\u00b4\u00d8\3\2\2\2\u00b5"+
		"\u00b6\5.\30\2\u00b6\u00b7\7\4\2\2\u00b7\u00b8\5,\27\2\u00b8\u00d8\3\2"+
		"\2\2\u00b9\u00ba\7\22\2\2\u00ba\u00d8\5.\30\2\u00bb\u00bc\7\23\2\2\u00bc"+
		"\u00d8\5\60\31\2\u00bd\u00be\7\24\2\2\u00be\u00d8\5\60\31\2\u00bf\u00c0"+
		"\7\25\2\2\u00c0\u00d8\5\60\31\2\u00c1\u00c2\7\26\2\2\u00c2\u00d8\5\60"+
		"\31\2\u00c3\u00c4\7\27\2\2\u00c4\u00d8\5\60\31\2\u00c5\u00c6\7\30\2\2"+
		"\u00c6\u00c7\5\60\31\2\u00c7\u00c8\7\31\2\2\u00c8\u00c9\5(\25\2\u00c9"+
		"\u00ca\7\32\2\2\u00ca\u00cb\5(\25\2\u00cb\u00cc\7\33\2\2\u00cc\u00d8\3"+
		"\2\2\2\u00cd\u00ce\7\34\2\2\u00ce\u00cf\5\60\31\2\u00cf\u00d0\7\35\2\2"+
		"\u00d0\u00d1\5(\25\2\u00d1\u00d2\7\36\2\2\u00d2\u00d8\3\2\2\2\u00d3\u00d4"+
		"\7\37\2\2\u00d4\u00d5\5(\25\2\u00d5\u00d6\7 \2\2\u00d6\u00d8\3\2\2\2\u00d7"+
		"\u00ac\3\2\2\2\u00d7\u00ad\3\2\2\2\u00d7\u00b2\3\2\2\2\u00d7\u00b5\3\2"+
		"\2\2\u00d7\u00b9\3\2\2\2\u00d7\u00bb\3\2\2\2\u00d7\u00bd\3\2\2\2\u00d7"+
		"\u00bf\3\2\2\2\u00d7\u00c1\3\2\2\2\u00d7\u00c3\3\2\2\2\u00d7\u00c5\3\2"+
		"\2\2\u00d7\u00cd\3\2\2\2\u00d7\u00d3\3\2\2\2\u00d8+\3\2\2\2\u00d9\u00eb"+
		"\5\60\31\2\u00da\u00eb\5\4\3\2\u00db\u00dc\7\b\2\2\u00dc\u00dd\7\65\2"+
		"\2\u00dd\u00de\5\60\31\2\u00de\u00df\7\6\2\2\u00df\u00e0\5\60\31\2\u00e0"+
		"\u00e1\7\66\2\2\u00e1\u00eb\3\2\2\2\u00e2\u00eb\5\b\5\2\u00e3\u00e4\7"+
		"\13\2\2\u00e4\u00e5\7>\2\2\u00e5\u00e7\7\65\2\2\u00e6\u00e8\5\2\2\2\u00e7"+
		"\u00e6\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\7\66"+
		"\2\2\u00ea\u00d9\3\2\2\2\u00ea\u00da\3\2\2\2\u00ea\u00db\3\2\2\2\u00ea"+
		"\u00e2\3\2\2\2\u00ea\u00e3\3\2\2\2\u00eb-\3\2\2\2\u00ec\u00f0\7>\2\2\u00ed"+
		"\u00f0\5\6\4\2\u00ee\u00f0\5\b\5\2\u00ef\u00ec\3\2\2\2\u00ef\u00ed\3\2"+
		"\2\2\u00ef\u00ee\3\2\2\2\u00f0/\3\2\2\2\u00f1\u00f2\b\31\1\2\u00f2\u00ff"+
		"\5\26\f\2\u00f3\u00ff\7<\2\2\u00f4\u00ff\7:\2\2\u00f5\u00ff\7;\2\2\u00f6"+
		"\u00ff\7=\2\2\u00f7\u00ff\7>\2\2\u00f8\u00ff\5\6\4\2\u00f9\u00ff\5\62"+
		"\32\2\u00fa\u00fb\7\65\2\2\u00fb\u00fc\5\60\31\2\u00fc\u00fd\7\66\2\2"+
		"\u00fd\u00ff\3\2\2\2\u00fe\u00f1\3\2\2\2\u00fe\u00f3\3\2\2\2\u00fe\u00f4"+
		"\3\2\2\2\u00fe\u00f5\3\2\2\2\u00fe\u00f6\3\2\2\2\u00fe\u00f7\3\2\2\2\u00fe"+
		"\u00f8\3\2\2\2\u00fe\u00f9\3\2\2\2\u00fe\u00fa\3\2\2\2\u00ff\u0118\3\2"+
		"\2\2\u0100\u0101\f\t\2\2\u0101\u0102\5\n\6\2\u0102\u0103\5\60\31\n\u0103"+
		"\u0117\3\2\2\2\u0104\u0105\f\b\2\2\u0105\u0106\5\f\7\2\u0106\u0107\5\60"+
		"\31\t\u0107\u0117\3\2\2\2\u0108\u0109\f\7\2\2\u0109\u010a\5\16\b\2\u010a"+
		"\u010b\5\60\31\b\u010b\u0117\3\2\2\2\u010c\u010d\f\6\2\2\u010d\u010e\5"+
		"\20\t\2\u010e\u010f\5\60\31\7\u010f\u0117\3\2\2\2\u0110\u0111\f\5\2\2"+
		"\u0111\u0112\7-\2\2\u0112\u0117\5\60\31\6\u0113\u0114\f\4\2\2\u0114\u0115"+
		"\7.\2\2\u0115\u0117\5\60\31\5\u0116\u0100\3\2\2\2\u0116\u0104\3\2\2\2"+
		"\u0116\u0108\3\2\2\2\u0116\u010c\3\2\2\2\u0116\u0110\3\2\2\2\u0116\u0113"+
		"\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\61\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c\7\61\2\2\u011c\u0126\5\60"+
		"\31\2\u011d\u011e\7#\2\2\u011e\u0126\5\60\31\2\u011f\u0120\7\62\2\2\u0120"+
		"\u0126\5\60\31\2\u0121\u0122\7\63\2\2\u0122\u0126\5\60\31\2\u0123\u0124"+
		"\7\64\2\2\u0124\u0126\5\60\31\2\u0125\u011b\3\2\2\2\u0125\u011d\3\2\2"+
		"\2\u0125\u011f\3\2\2\2\u0125\u0121\3\2\2\2\u0125\u0123\3\2\2\2\u0126\63"+
		"\3\2\2\2\u0127\u012b\5\"\22\2\u0128\u012b\5 \21\2\u0129\u012b\5\34\17"+
		"\2\u012a\u0127\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u0129\3\2\2\2\u012b\65"+
		"\3\2\2\2\30;DGRXgp\u0080\u0084\u008a\u0092\u009d\u00a9\u00d7\u00e7\u00ea"+
		"\u00ef\u00fe\u0116\u0118\u0125\u012a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}