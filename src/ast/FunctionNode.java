package ast;

import ast.parameter.ParamListNode;
import ast.statement.StatementNode;
import org.antlr.runtime.UnwantedTokenException;
import org.antlr.v4.runtime.ParserRuleContext;
import type.Type;

import java.util.ArrayList;

public class FunctionNode implements ASTNode {

    //<func> ::= <type> <ident> ‘(’ <param-list>? ‘)’ ‘is’ <stat> ‘end’

    private Type type;
    private IdentNode ident;
    private ArrayList<ParamListNode> paramList;
    private StatementNode stat;

    //Constructor
    public FunctionNode(Type type,
                        IdentNode ident,
                        ArrayList<ParamListNode> paramList,
                        StatementNode stat){
        this.type = type;
        this.ident = ident;
        this.paramList = paramList;
        this.stat = stat;
    }


    public Type getType(){
        return type;
    }

    public IdentNode getIdentNode(){
        return ident;
    }

    public void addParamListNode(ParamListNode paramLN){
        paramList.add(paramLN);
    }
    public ArrayList<ParamListNode> getParamListNode(){
        return paramList;
    }

    public StatementNode getStatement(){
        return stat;
    }





}
