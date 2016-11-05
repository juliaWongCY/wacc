package ast.expression;

public class StringLiterNode implements ExpressionNode {

    private final String value;

    public StringLiterNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
