package ast.expression;

import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.BoolType;
import type.Type;

import java.util.List;

public class BoolLiterNode implements ExpressionNode {

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
