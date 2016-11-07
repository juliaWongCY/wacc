package ast.assignLeft;

import ast.expression.IdentNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class IdentAsLNode implements AssignLeftNode {

    private IdentNode id;

    public IdentAsLNode(IdentNode id) {
        this.id = id;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        try {
            return id.getNodeType(st);
        } catch (SemanticException e) {
            throw new SemanticException("ERROR");
        }
    }

    /* this is a wrapper node to contain the IdentExprNode */


}
