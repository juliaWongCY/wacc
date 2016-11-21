package ast.expression;

import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.IntType;
import type.Type;

import java.util.List;

public class IntLiterNode implements ExpressionNode {

    private final int value;

    public IntLiterNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        IntType intType = new IntType();
        return intType.getType();
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }
}
