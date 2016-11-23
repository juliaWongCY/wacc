package ast.expression;

import backEnd.Util;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.IntType;
import type.Type;

public class IntLiterNode extends ExpressionNode {

    private final int value;

    public IntLiterNode(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        IntType intType = new IntType();
        typeIndicator = Util.convertTypeToIndicator(intType);
        return intType.getType();
    }

}
