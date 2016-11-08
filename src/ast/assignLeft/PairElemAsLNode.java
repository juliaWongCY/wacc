package ast.assignLeft;


import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class PairElemAsLNode implements AssignLeftNode {

    private ExpressionNode expressionNode;
    private boolean isFirst;

    public PairElemAsLNode(ExpressionNode expressionNode, boolean isFirst) {
        this.expressionNode = expressionNode;
        this.isFirst = isFirst;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    public boolean isFirst() {
        return isFirst;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return expressionNode.getNodeType(st);
    }

    /* this is a wrapper class to contain the pairElemTypeNode */


}
