package ast.expression;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.CharType;
import type.Type;

public class CharLiterNode implements ExpressionNode {

    // <expr> = <char-liter>
    //CharLiter value has to be String since escape character contains two characters.
    private final String value;

    public CharLiterNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        CharType charType = new CharType();
        return charType.getType();
    }
}
