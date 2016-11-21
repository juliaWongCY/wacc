package ast.expression;

import backEnd.AssemblyCode;
import backEnd.General.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.PairType;
import type.Type;

import java.util.List;

public class PairLiterNode implements ExpressionNode {

    public PairLiterNode() {
        //PairLiter = null
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return new PairType();
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }
}
