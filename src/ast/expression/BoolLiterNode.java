package ast.expression;

import backEnd.Util;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.BoolType;
import type.Type;

public class BoolLiterNode extends ExpressionNode {

    private final boolean value;

    public BoolLiterNode(boolean value) {
        typeIndicator = Util.BOOL_TYPE;
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        BoolType boolType = new BoolType();
        return boolType.getType();
    }

}
