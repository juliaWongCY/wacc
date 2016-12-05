package ast.statement;

import ast.SideEffectingOpr;
import ast.assignLeft.AssignLeftNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class SideEffectNode implements StatementNode {

    private SideEffectingOpr sideEffectingOpr;
    private AssignLeftNode assignLeftNode;


    public SideEffectNode(SideEffectingOpr sideEffectingOpr, AssignLeftNode assignLeftNode) {
        this.sideEffectingOpr = sideEffectingOpr;
        this.assignLeftNode = assignLeftNode;
    }

    public SideEffectingOpr getSideEffectingOpr() {
        return sideEffectingOpr;
    }

    public AssignLeftNode getAssignLeftNode() {
        return assignLeftNode;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        StatementType stat = new StatementType();
        return stat.getType();
    }

    @Override
    public int getTypeIndicator() {
        return -1;
    }

}
