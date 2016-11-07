package ast;

import ast.expression.IdentNode;
import ast.parameter.ParamListNode;
import ast.statement.StatementNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

import java.util.ArrayList;

public class FunctionNode implements ASTNode {

    //<func> ::= <returnType> <functionName> ‘(’ <param-list>? ‘)’ ‘is’ <bodyStat> ‘end’

    private Type returnType;
    private IdentNode functionName;
    private ArrayList<ParamListNode> paramList;
    private StatementNode bodyStat;

    //Constructor
    public FunctionNode(Type type,
                        IdentNode functionName,
                        ArrayList<ParamListNode> paramList,
                        StatementNode bodyStat){
        this.returnType = type;
        this.functionName = functionName;
        this.paramList = paramList;
        this.bodyStat = bodyStat;
    }


    public Type getReturnType(){
        return returnType;
    }

    public IdentNode getFunctionName(){
        return functionName;
    }

    public void addParamListNode(ParamListNode paramLN){
        paramList.add(paramLN);
    }
    public ArrayList<ParamListNode> getParamListNode(){
        return paramList;
    }

    public StatementNode getStatement(){
        return bodyStat;
    }


    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return null;
    }
}
