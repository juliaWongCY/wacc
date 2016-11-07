package ast.expression;

import frontEnd.SemanticException;
import type.BoolType;
import type.Type;

public class BoolLiterNode implements ExpressionNode {

    private final boolean value;

    public BoolLiterNode(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public Type getNodeType() throws SemanticException {
        BoolType boolType = new BoolType();
        return boolType.getType();
    }
}
