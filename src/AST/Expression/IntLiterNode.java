package AST.Expression;

public class IntLiterNode implements ExpressionNode {

    private final int value;

    public IntLiterNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
