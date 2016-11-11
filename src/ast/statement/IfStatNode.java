package ast.statement;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class IfStatNode implements StatementNode {

    private ExpressionNode expr;
    private StatementNode statThenBody;
    private StatementNode statElseBody;


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


    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        StatementType stat = new StatementType();
        return stat.getType();
    }
}
