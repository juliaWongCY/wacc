package ast.expression;

import backEnd.Util;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.CharType;
import type.Type;

public class CharLiterNode extends ExpressionNode {

//    private final char value;

    private final String value;

//    public CharLiterNode(char value) {
//        this.value = value;
//    }

    public CharLiterNode(String value) {
        this.value = value;
    }

    public char getValue() {
        return value.charAt(1);
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        CharType charType = new CharType();
        typeIndicator = Util.convertTypeToIndicator(charType);
        return charType.getType();
    }

}
