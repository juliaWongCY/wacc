package ast.expression;

public class CharLiterNode implements ExpressionNode {

    //CharLiter value has to be String since escape character contains two characters.
    private final String value;

    public CharLiterNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
