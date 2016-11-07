package ast.expression;

import frontEnd.SemanticException;
import type.StringType;
import type.Type;

public class StringLiterNode implements ExpressionNode {

    private final String value;

    public StringLiterNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Type getNodeType() throws SemanticException {
        StringType stringType = new StringType();
        return stringType.getType();
    }
}
