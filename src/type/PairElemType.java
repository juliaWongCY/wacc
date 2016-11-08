package type;

import ast.expression.ExpressionNode;

public class PairElemType extends Type {

    private Type elem;
    private ExpressionNode expressionNode;

    public PairElemType(Type elem, ExpressionNode expressionNode) {
        this.elem = elem;
        this.expressionNode = expressionNode;
    }

    public Type getElemType() {
        return elem.getType();
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    public void setExpressionNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }

}
