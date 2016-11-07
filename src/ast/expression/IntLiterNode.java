package ast.expression;

import frontEnd.SemanticException;
import type.IntType;
import type.Type;

public class IntLiterNode implements ExpressionNode {

    private final int value;

    public IntLiterNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public Type getNodeType() throws SemanticException {
        IntType intType = new IntType();
        return intType.getType();
    }
}
