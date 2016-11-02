parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}


argList : expr ( COMMA expr )* ;
pairElem : FST expr | SND expr ;


baseType : INT | BOOL | CHAR | STRING ;

arrayType : type OPEN_SQPARENTHESES CLOSE_SQPARENTHESES ;

pairType : PAIR OPEN_PARENTHESES pairElemType COMMA pairElemType CLOSE_PARENTHESES ;

pairElemType : baseType | arrayType | PAIR ;


unaryOper : NOT | NEG | LEN | ORD | CHR ;

binaryOper : PLUS | MINUS | MULT | DIV | MOD | GT | GTE | LT | LTE | EQ | NEQ | AND | OR ;

arrayElem : (IDENT) (OPEN_SQPARENTHESES expr CLOSE_SQPARENTHESES)+ ;

arrayLiter : OPEN_SQPARENTHESES ( expr ( COMMA expr )* )? CLOSE_SQPARENTHESES ;



func: type IDENT OPEN_PARENTHESES ( paramList )? CLOSE_PARENTHESES IS stat END;

program: BEGIN (func)* stat END;



paramList: param ( COMMA param)*;

param : type IDENT;

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

assignLHS: IDENT
| arrayElem
| pairElem
;

assignRHS: expr
| arrayLiter
| NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
| pairElem
| CALL IDENT OPEN_PARENTHESES (argList)? CLOSE_PARENTHESES
;

type: baseType
| type OPEN_SQPARENTHESES CLOSE_SQPARENTHESES
| pairType
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

comment: COMMENTSYM ~(EOL)* EOL ;

// EOF indicates that the program must consume to the end of the input.
prog: (expr)*  EOF ;
