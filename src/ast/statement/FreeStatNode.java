package ast.statement;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import type.Type;

public class FreeStatNode implements StatementNode {

    private ExpressionNode expr;

    public FreeStatNode(ExpressionNode expr) {
        this.expr = expr;
    }

    @Override
    public Type getNodeType() throws SemanticException {
        return null;
    }
}
