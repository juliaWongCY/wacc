package ast.expression;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.BoolType;
import type.Type;

public class BoolLiterNode implements ExpressionNode {

    // <expr> = <bool-liter>
    //<bool-liter > ::= ‘true’ | ‘false’

    private final boolean value;

    public BoolLiterNode(boolean value) {
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
