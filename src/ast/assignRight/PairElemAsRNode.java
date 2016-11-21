package ast.assignRight;

import ast.expression.PairElemNode;
import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

import java.util.List;

public class PairElemAsRNode implements AssignRightNode {

    private PairElemNode pairElemNode;

    public PairElemAsRNode(PairElemNode pairElemNode) {
        this.pairElemNode = pairElemNode;
    }

    //This function will be useful for backend
    public PairElemNode getPairElemNode() {
        return pairElemNode;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return pairElemNode.getNodeType(st);
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }
}
