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



//brackets
OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;

//numbers
fragment DIGIT : '0'..'9' ; 

INTEGER: DIGIT+ ;

//character
fragment LETTER : ('a'..'z'|'A'..'Z'|'_') ;
fragment ESCCHAR : ('\u0000' | '\b' | '\t' | '\n' | '\f' | '\r' | '\"' | '\'' | '\\');

CHAR: ('\'' (LETTER) '\''| (ESCCHAR) ) ;
STRING:'"' (LETTER)* '"' ;


//fragment TAB : ('\t') ;
//fragment NEWLINE : ('\r'|'\n') ;
//fragment SPACE : (' ') ;


