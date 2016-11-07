package ast.statement;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import type.Type;

public class ReturnStatNode implements StatementNode {

    ExpressionNode expr;

    public ReturnStatNode(ExpressionNode expr) {
        this.expr = expr;
    }

    @Override
    public Type getNodeType() throws SemanticException {
        return null;
    }
}
