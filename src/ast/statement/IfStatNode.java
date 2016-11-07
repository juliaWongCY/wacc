package ast.statement;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.BoolType;
import type.StatementType;
import type.Type;

public class IfStatNode implements StatementNode {

    // <stat> = 'if' <expr> 'then' <stat> 'else' <stat> 'fi'

    private ExpressionNode expr;
    private StatementNode statThenBody;
    private StatementNode statElseBody;
    private SymbolTable thenST;
    private SymbolTable elseST;

    public IfStatNode(ExpressionNode expr,
                      StatementNode statThenBody,
                      StatementNode statElseBody) {
        this.expr = expr;
        this.statThenBody = statThenBody;
        this.statElseBody = statElseBody;
    }

    public ExpressionNode getCond(){
        return expr;
    }

    public StatementNode getStatThenBody(){
        return statThenBody;
    }

    public StatementNode getStatElseBody(){
        return statElseBody;
    }



    //TODO: Check the return statement
    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        BoolType bool = new BoolType();

        //the condition must be of type bool
        if(!expr.getNodeType(st).equals(bool.getType())){
            throw new SemanticException("the condition must return a boolean");
        }

        Type thenStatType = statThenBody.getNodeType(thenST);
        Type elseStatType = statElseBody.getNodeType(elseST);
        return statThenBody.getNodeType(st);
    }
}
