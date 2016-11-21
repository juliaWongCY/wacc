package ast.assignLeft;

import ast.expression.PairElemNode;
import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

import java.util.List;

public class PairElemAsLNode implements AssignLeftNode {

    private PairElemNode pairElemNode;

    public PairElemAsLNode(PairElemNode pairElemNode) {
        this.pairElemNode = pairElemNode;
    }

    // Functions will be used in backend
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
