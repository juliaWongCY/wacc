package ast.expression;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.CharType;
import type.Type;

public class CharLiterNode implements ExpressionNode {

    private final char value;

    public CharLiterNode(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        CharType charType = new CharType();
        return charType.getType();
    }

}
