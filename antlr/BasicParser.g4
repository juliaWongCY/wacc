parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}


argList : expr ( COMMA expr )* ;

arrayLiter : OPEN_SQPARENTHESES ( expr ( COMMA expr )* )? CLOSE_SQPARENTHESES ;

arrayElem : name=IDENT (OPEN_SQPARENTHESES expr CLOSE_SQPARENTHESES)+ ;

pairElem : FST expr | SND expr ;

binaryOper : PLUS | MINUS | MULT | DIV | MOD | GT | GTE | LT | LTE | EQ | NEQ | AND | OR ;

unaryOper : NOT | NEG | LEN | ORD | CHR ;

paramList: param ( COMMA param )*;

param : type IDENT;

pairType : PAIR OPEN_PARENTHESES pairElemType COMMA pairElemType CLOSE_PARENTHESES ;

pairElemType : baseType | arrayType | PAIR ;

arrayType : type OPEN_SQPARENTHESES CLOSE_SQPARENTHESES ;

baseType : INT | BOOL | CHAR | STRING ;

program : BEGIN (func)* stat END EOF;

func : type IDENT OPEN_PARENTHESES ( paramList )? CLOSE_PARENTHESES IS stat END;


stat : SKIP_ #skip_stat
| type IDENT ASSIGN assignRHS #declare_stat
| assignLHS ASSIGN assignRHS #assign_stat
| READ assignLHS #read_stat
| FREE expr #free_stat
| RETURN expr #return_stat
| EXIT expr #exit_stat
| PRINT expr #print_stat
| PRINTLN expr #println_stat
| IF expr THEN stat ELSE stat FI #if_stat
| WHILE expr DO stat DONE #while_stat
| BEGIN stat END #scope_stat
| stat SEMICOLON stat #concat_stat
;

assignRHS : expr #assignr_expr
| arrayLiter #assignr_arrayliter
| NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES #assignr_newpair
| pairElem #assignr_pairelem
| CALL IDENT OPEN_PARENTHESES (argList)? CLOSE_PARENTHESES #assignr_paren
;

assignLHS : IDENT #assignl_id
| arrayElem #assignl_arrayelem
| pairElem #assignl_pairelem
;

expr : INTEGER #int_liter
| BOOLLITER #bool_liter
| CHARLITER #char_liter
| STRINGLITER #string_liter
| PAIRLITER #pair_liter
| IDENT #ident
| arrayElem #arrayelem
| unaryOper expr #unary_op
| expr binaryOper expr #binary_op
| OPEN_PARENTHESES expr CLOSE_PARENTHESES #paren
;

type : baseType
| type OPEN_SQPARENTHESES CLOSE_SQPARENTHESES
| pairType
;

// EOF indicates that the program must consume to the end of the input.
//prog: (expr)*  EOF ;
