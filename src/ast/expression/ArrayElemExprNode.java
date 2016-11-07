package ast.expression;

import type.Type;

import java.util.List;

public class ArrayElemExprNode implements ExpressionNode {

    private Type arrayType;
    private IdentNode arrayName;
    private List<String> indexes;

    public ArrayElemExprNode(Type arrayType, IdentNode arrayName, List<String> indexes) {
        this.arrayType = arrayType;
        this.arrayName = arrayName;
        this.indexes = indexes;
    }

    @Override
    public Type getNodeType() {
        // look up
        return null;
    }
}
