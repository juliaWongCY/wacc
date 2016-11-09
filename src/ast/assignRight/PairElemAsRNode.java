package ast.assignRight;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.PairType;
import type.Type;

public class PairElemAsRNode implements AssignRightNode {

    private ExpressionNode expressionNode;
    private boolean isFirst;

    public PairElemAsRNode(ExpressionNode expressionNode, boolean isFirst) {
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

        if (expressionNode == null) {
            throw new SemanticException("Expression node is null");
        } else {
            Type t = expressionNode.getNodeType(st);
            if (t instanceof PairType) {
                if (isFirst) {
                    return ((PairType) t).getFstExprType();
                } else {
                    return ((PairType) t).getSndExprType();
                }
            }
            throw new SemanticException("Expression node not of required type pair");
        }

    }

}
