package ast.statement;

import ast.expression.ExpressionNode;
import com.sun.org.apache.xpath.internal.operations.Bool;
import frontEnd.SemanticException;
import type.BoolType;
import type.Type;
import type.TypeEnum;

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

    //TODO!!!
    @Override
    public Type getNodeType() throws SemanticException {
        BoolType bool = null;
        if(!expr.getNodeType().equals(bool.getType())){
            throw new SemanticException("the condition must return a boolean");
        }
        return null;
    }
}
