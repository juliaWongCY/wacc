package AST.Expression;

public class BoolLiterNode implements ExpressionNode {

    private final boolean value;

    public BoolLiterNode(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

}
