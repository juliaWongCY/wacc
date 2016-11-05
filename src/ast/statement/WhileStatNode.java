package ast.statement;

import ast.expression.ExpressionNode;

public class WhileStatNode implements StatementNode {
    //<stat> = ‘while’ <expr> ‘do’ <stat> ‘done’

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

}
