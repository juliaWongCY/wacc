package ast.expression;

import ast.UnaryOpr;
import backEnd.Util;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.PairType;
import type.Type;

public class PairElemNode extends ExpressionNode {

    private ExpressionNode expressionNode;
    private boolean isFirst;

    public PairElemNode(ExpressionNode expressionNode, boolean isFirst) {
        this.expressionNode = expressionNode;
        this.isFirst = isFirst;
    }

    //This will be useful for backend
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
                Type type;
                if (isFirst) {
                    type = ((PairType) t).getFstExprType();
                } else {
                    type = ((PairType) t).getSndExprType();
                }
                typeIndicator = Util.convertTypeToIndicator(type);
                return type;
            }
            throw new SemanticException("Expression node not of required type pair");
        }

    }
}
