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
            PairType pairType = new PairType();
            return pairType.getType();
        } else {
            Type t = expressionNode.getNodeType(st);
            if (t instanceof PairType) {
                if (isFirst) {
                    return ((PairType) t).getFstExprType();
                } else {
                    return ((PairType) t).getSndExprType();
                }
            }
            return t;
        }

    }

}
