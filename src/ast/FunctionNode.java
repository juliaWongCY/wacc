package ast;

import ast.parameter.ParamListNode;
import ast.statement.StatementNode;
import org.antlr.runtime.UnwantedTokenException;
import org.antlr.v4.runtime.ParserRuleContext;
import type.Type;

public class FunctionNode implements ASTNode {

    //<func> ::= <type> <ident> ‘(’ <param-list>? ‘)’ ‘is’ <stat> ‘end’

    private Type type;
    private IdentNode ident;
    private ParamListNode paramList;
    private StatementNode stat;


    public Type getType(){
        return type;
    }

    public IdentNode getIdentNode(){
        return ident;
    }

    public ParamListNode getParamListNode(){
        return paramList;
    }

    public StatementNode getStatement(){
        return stat;
    }





}
