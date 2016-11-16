parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}


argList : expr ( COMMA expr )*;

arrayLiter : OPEN_SQPARENTHESES ( expr ( COMMA expr )* )? CLOSE_SQPARENTHESES;

arrayElem : name=IDENT (OPEN_SQPARENTHESES expr CLOSE_SQPARENTHESES)+;

pairElem : FST expr | SND expr;

binaryOper_IntHigher : MULT | DIV | MOD;

binaryOper_IntLower: PLUS | MINUS;

binaryOper_CompareHigher: GT | GTE | LT | LTE;

binaryOper_CompareLower: EQ | NEQ;

sign : (MINUS|PLUS);

intliter : sign? INTEGER;

paramList: param ( COMMA param )*;

param : type IDENT;

pairType : PAIR OPEN_PARENTHESES pairElemType COMMA pairElemType CLOSE_PARENTHESES;

pairElemType : baseType | arrayType | PAIR;

arrayType : (baseType | pairType) (OPEN_SQPARENTHESES CLOSE_SQPARENTHESES)+;

baseType : INT | BOOL | CHAR | STRING;


// EOF indicates that the program must consume to the end of the input.
program : BEGIN (func)* statList END EOF;

func : type IDENT OPEN_PARENTHESES ( paramList )? CLOSE_PARENTHESES IS statList END;

statList : stat (SEMICOLON stat)*;

stat : SKIP_                        #skip_stat
| type IDENT ASSIGN assignRHS       #declare_stat
| assignLHS ASSIGN assignRHS        #assign_stat
| READ assignLHS                    #read_stat
| FREE expr                         #free_stat
| RETURN expr                       #return_stat
| EXIT expr                         #exit_stat
| PRINT expr                        #print_stat
| PRINTLN expr                      #println_stat
| IF expr THEN stat ELSE stat FI    #if_stat
| WHILE expr DO stat DONE           #while_stat
| BEGIN stat END                    #scope_stat
;

assignRHS : expr                                                #assignr_expr
| arrayLiter                                                    #assignr_arrayliter
| NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES    #assignr_newpair
| pairElem                                                      #assignr_pairelem
| CALL IDENT OPEN_PARENTHESES (argList)? CLOSE_PARENTHESES      #assignr_call
;

assignLHS : IDENT   #assignl_id
| arrayElem         #assignl_arrayelem
| pairElem          #assignl_pairelem
;

expr : intliter                                   #int_liter
| BOOLLITER                                       #bool_liter
| CHARLITER                                       #char_liter
| STRINGLITER                                     #string_liter
| PAIRLITER                                       #pair_liter
| IDENT                                           #ident
| arrayElem                                       #arrayElem_expr
| unaryOper                                       #unary_op
| exprL=expr binaryOper_IntHigher exprR=expr      #binary_opIntHigher
| exprL=expr binaryOper_IntLower exprR=expr       #binary_opIntLower
| exprL=expr binaryOper_CompareHigher exprR=expr  #binary_opCompareHigher
| exprL=expr binaryOper_CompareLower exprR=expr   #binary_opCompareLower
| exprL=expr AND exprR=expr                       #binary_opAnd
| exprL=expr OR exprR=expr                        #binary_opOr
| OPEN_PARENTHESES expr CLOSE_PARENTHESES         #paren_expr
;

unaryOper : NOT expr #uary_opNot
| MINUS expr #unary_opNeg
| LEN   expr #unary_opLen
| ORD   expr #unary_opOrd
| CHR   expr #unary_opChr
;

type : baseType
| arrayType
| pairType
;

