package ast.expression;

import type.Type;

import java.util.List;

public class ArrayElemExprNode implements ExpressionNode {

    private Type arrayType;
    private IdentNode arrayName;
    private List<String> indexes;

    @Override
    public Type getNodeType() {
        // look up
        return null;
    }
}
