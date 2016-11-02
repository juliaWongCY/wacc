parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}


argList : expr ( COMMA expr )* ;

arrayLiter : OPEN_SQPARENTHESES ( expr ( COMMA expr )* )? CLOSE_SQPARENTHESES ;


arrayElem : (IDENT) (OPEN_SQPARENTHESES expr CLOSE_SQPARENTHESES)+ ;

pairElem : FST expr | SND expr ;


binaryOper : PLUS | MINUS | MULT | DIV | MOD | GT | GTE | LT | LTE | EQ | NEQ | AND | OR ;

unaryOper : NOT | NEG | LEN | ORD | CHR ;

paramList: param ( COMMA param)*;

param : type IDENT;

pairType : PAIR OPEN_PARENTHESES pairElemType COMMA pairElemType CLOSE_PARENTHESES ;

pairElemType : baseType | arrayType | PAIR ;

arrayType : type OPEN_SQPARENTHESES CLOSE_SQPARENTHESES ;

baseType : INT | BOOL | CHAR | STRING ;






program: BEGIN (func)* stat END;

func: type IDENT OPEN_PARENTHESES ( paramList )? CLOSE_PARENTHESES IS stat END;

stat: SKIP
| type IDENT ASSIGN assignRHS
| assignLHS ASSIGN assignRHS
| READ assignLHS
| FREE expr
| RETURN expr
| EXIT expr
| PRINT expr
| PRINTLN expr
| IF expr THEN stat ELSE stat FI
| WHILE expr DO stat DONE
| BEGIN stat END
| stat SEMICOLON stat
;

assignRHS: expr
| arrayLiter
| NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
| pairElem
| CALL IDENT OPEN_PARENTHESES (argList)? CLOSE_PARENTHESES
;

assignLHS: IDENT
| arrayElem
| pairElem
;

expr: INTEGER
| BOOLLITER
| CHARLITER
| STRINGLITER
| PAIRLITER
| IDENT
| arrayElem
| unaryOper expr
| expr binaryOper expr
| OPEN_PARENTHESES expr CLOSE_PARENTHESES
;

type: baseType
| type OPEN_SQPARENTHESES CLOSE_SQPARENTHESES
| pairType
;

comment: COMMENTSYM ~(EOL)* EOL ;

// EOF indicates that the program must consume to the end of the input.
prog: (expr)*  EOF ;
