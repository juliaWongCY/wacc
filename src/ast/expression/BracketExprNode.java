package ast.expression;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class BracketExprNode implements ExpressionNode {

    private ExpressionNode expressionNode;

    public BracketExprNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        try {
            return expressionNode.getNodeType(st);
        } catch (SemanticException e) {
            throw new SemanticException("This is not a valid expression");
        }
    }
}
