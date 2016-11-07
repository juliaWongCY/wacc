package ast.assignRight;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class ExprAsRNode implements AssignRightNode {

    private ExpressionNode expressionNode;

    public ExprAsRNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        try {
            return expressionNode.getNodeType(st);
        } catch (SemanticException e) {
            throw new SemanticException("ERROR");
        }
    }

}
