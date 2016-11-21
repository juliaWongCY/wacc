package ast.assignLeft;

import ast.expression.IdentNode;
import backEnd.AssemblyCode;
import backEnd.General.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

import java.util.List;

public class IdentAsLNode implements AssignLeftNode {

    private IdentNode id;

    public IdentAsLNode(IdentNode id) {
        this.id = id;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return id.getNodeType(st);
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }

    /* this is a wrapper node to contain the IdentExprNode */


}
