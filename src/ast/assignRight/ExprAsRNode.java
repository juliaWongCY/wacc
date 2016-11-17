package ast.assignRight;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class ExprAsRNode implements AssignRightNode {

    private ExpressionNode expr;

    public ExprAsRNode(ExpressionNode expr) {
        this.expr = expr;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return expr.getNodeType(st);
    }
}
