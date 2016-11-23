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
    }

    public String getValue() {
        return value;
    }

    public int getStringSize(){
        return value.length();
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
//        StringType stringType = new StringType();
//        return stringType.getType();
        typeIndicator = Util.STRING_TYPE;
        return new ArrayType(new CharType());
    }

    public String getTypeInString() {
        return "string";
    }

}
