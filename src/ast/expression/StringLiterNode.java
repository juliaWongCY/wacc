package ast.expression;

import backEnd.Util;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.ArrayType;
import type.CharType;
import type.Type;

public class StringLiterNode extends ExpressionNode {

    private final String value;

    public StringLiterNode(String value) {
        this.value = value;
        typeIndicator = Util.STRING_TYPE;
    }

    public String getValue() {
        return value;
    }

    public int getStringSize(){
        int numberOfEscapes = 0;
        for (int i = 0; i < value.length() - 1; i++) {
            if (value.charAt(i) == '\\' && value.charAt(i + 1) != '\\') {
                numberOfEscapes++;
            }
        }
        return value.length() - 2 - numberOfEscapes;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
//        StringType stringType = new StringType();
//        return stringType.getType();
        return new ArrayType(new CharType());
    }

    public String getTypeInString() {
        return "string";
    }

}
