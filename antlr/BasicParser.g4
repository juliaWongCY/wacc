parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

binaryOper : PLUS | MINUS | MULT | DIV | MOD | GT | GTE | LT | LTE | EQ | NEQ | AND | OR ;
unaryOper : NOT | NEG | LEN | ORD | CHR ;
arrayElem : (IDENT) (OPEN_SQPARENTHESES expr CLOSE_SQPARENTHESES)+ ;

expr: expr binaryOper expr
| INTEGER
| BOOL
| CHAR
| STRING
| PAIRLITER
| IDENT
| arrayElem
| unaryOper expr  
| OPEN_PARENTHESES expr CLOSE_PARENTHESES
;

// EOF indicates that the program must consume to the end of the input.
prog: (expr)*  EOF ;
