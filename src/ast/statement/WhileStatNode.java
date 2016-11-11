package ast.statement;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.BoolType;
import type.StatementType;
import type.Type;

public class WhileStatNode implements StatementNode {


    private ExpressionNode expr;
    private StatementNode stat;

    public WhileStatNode(ExpressionNode expr,
                         StatementNode stat){
        this.expr = expr;
        this.stat = stat;
    }

    public ExpressionNode getCondition(){
        return expr;
    }

    public StatementNode getBody(){
        return stat;
    }


    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        StatementType stat = new StatementType();
        return stat.getType();
    }
}
