lexer grammar BasicLexer;


//syntax
WS : ( ' ' | '\t' | '\r'| '\n')+ -> skip ;
ASSIGN : '=' ;
SEMICOLON : ';' ;
COMMA :  ',' ;
fragment EOL : ('\r' | '\n') ;
fragment COMMENTSYM : '#' ;
COMMENT : COMMENTSYM .+? (EOL) -> skip ;

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
SKIP_: 'skip' ;
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

//Side-effect operator
INCREMENT: '++';
DECREMENT: '--';

//Unary operator
NOT: '!' ;
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
INTEGER: DIGIT+ ;

//character
fragment LETTER : ~('\\' | '\'' | '\"') ;
fragment ESCCHAR : ( '0' | 'b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\') ;
fragment CHARACTER : (LETTER | '\\' ESCCHAR) ;

CHARLITER: '\'' (CHARACTER) '\'' ;
STRINGLITER: '"' (CHARACTER)* '"' ;

//boolean
BOOLLITER: ('true' | 'false') ;

//pairLiter
PAIRLITER: 'null' ;

//identifier
IDENT: ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')* ;

