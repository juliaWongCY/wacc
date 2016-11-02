parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

binaryOper : PLUS | MINUS | MULT | DIV | MOD | GT | GTE | LT | LTE | EQ | NEQ | AND | OR ;
unaryOper : NOT | NEG | LEN | ORD | CHR ;
arrayElem : (IDENT) (OPEN_SQPARENTHESES expr CLOSE_SQPARENTHESES)+ ;
arrayLiter : OPEN_SQPARENTHESES ( expr ( COMMA expr )* )? CLOSE_SQPARENTHESES ;
pairElem : FST expr | SND expr ;
argList : expr ( COMMA expr )* ;
pairElemType : baseType | arrayType | PAIR ;
baseType : INT | BOOL | CHAR | STRING ;
pairType : PAIR OPEN_PARENTHESES pairElemType COMMA pairElemType CLOSE_PARENTHESES ;
arrayType : type OPEN_SQPARENTHESES CLOSE_SQPARENTHESES ;
param : type IDENT;

program: BEGIN (func)* stat END; 

func: type IDENT OPEN_PARENTHESES ( paramList )? CLOSE_PARENTHESES IS stat END;

paramList: param ( COMMA param)*;

stat: SKIP
| type IDENT ASSIGN assignLHS
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

expr: expr binaryOper expr
| INTEGER
| BOOLLITER
| CHARLITER
| STRINGLITER
| PAIRLITER
| IDENT
| arrayElem
| unaryOper expr  
| OPEN_PARENTHESES expr CLOSE_PARENTHESES
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

type: baseType
| type OPEN_SQPARENTHESES CLOSE_SQPARENTHESES 
| pairType
;

// EOF indicates that the program must consume to the end of the input.
prog: (expr)*  EOF ;
