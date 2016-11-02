lexer grammar BasicLexer;

//operators
PLUS: '+' ;
MINUS: '-' ;
MULT: '*' ;
DIV: '/' ;
MOD: '%' ;
GT: '>' ;
GTE: '>=' ;
LT: '<' ;
LTE: '<=' ;
EQ: '==' ;
NEQ: '!=' ;
AND: '&&' ;
OR: '||' ;

//Unary operator
NOT: '!' ;
NEG: '-' ;
LEN: 'len' ;
ORD: 'ord' ;
CHR: 'chr' ;

//identifier
IDENT: ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')* ; 

//brackets
OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;
OPEN_SQPARENTHESES : '[' ;
CLOSE_SQPARENTHESES : ']' ;


//numbers
fragment DIGIT : '0'..'9' ; 

INTEGER: DIGIT+ ;

//character
fragment LETTER : ('a'..'z'|'A'..'Z'|'_'| ' ') ;
fragment ESCCHAR : ('\u0000' | '\b' | '\t' | '\n' | '\f' | '\r' | '\"' | '\'' | '\\');

CHAR: ('\'' (LETTER) '\''| (ESCCHAR) ) ;
STRING:'"' (LETTER)* '"' ;

//boolean
BOOL: ('true' | 'false') ;

//pair
PAIRLITER: 'null' ;

