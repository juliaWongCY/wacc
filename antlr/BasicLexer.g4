lexer grammar BasicLexer;


//syntax
WS : (' ' | '\t' | '\r' | '\n')+ -> skip ;
ASSIGN : '=' ;
SEMICOLON : ';' ;
COMMA :  ',' ;
//WS: [ \t\r\n]+ -> skip ;
COMMENTSYM : '#' ;
EOL : ('\r' | '\n') ;
SYMBOLS : . ;


//keywords
NEWPAIR: 'newpair' ;
FST: 'fst' ;
SND: 'snd' ;
CALL: 'call' ;
PAIR: 'pair' ;
BOOL: 'bool' ;
CHAR: 'char' ;
STRING: 'string' ;
INT: 'int' ;
SKIP: 'skip' ;
READ: 'read' ;
FREE: 'free' ;
RETURN: 'return' ;
EXIT: 'exit' ;
PRINT: 'print' ;
PRINTLN: 'println' ;
IF: 'if' ;
THEN: 'then' ;
ELSE: 'else' ;
FI: 'fi' ;
WHILE: 'while' ;
DO: 'do' ;
DONE: 'done' ;
BEGIN: 'begin' ;
END: 'end' ;
IS: 'is' ;


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


//brackets
OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;
OPEN_SQPARENTHESES : '[' ;
CLOSE_SQPARENTHESES : ']' ;


//numbers
fragment DIGIT : '0'..'9' ;
fragment SIGN : '+' | '-' ;

INTEGER: (SIGN)? DIGIT+ ;


//character
fragment LETTER : ('a'..'z'|'A'..'Z'|'_'| ' ') ;
fragment ESCCHAR : ('\u0000' | '\b' | '\t' | '\n' | '\f' | '\r' | '\"' | '\'' | '\\');

CHARLITER: ('\'' (LETTER) '\''| (ESCCHAR) ) ;
STRINGLITER:'"' (LETTER)* '"' ;


//boolean
BOOLLITER: ('true' | 'false') ;


//pair
PAIRLITER: 'null' ;

//identifier
IDENT: ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')* ;
