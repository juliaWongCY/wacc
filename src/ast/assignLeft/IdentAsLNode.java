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

    public IdentNode getId() {
        return id;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return id.getNodeType(st);
    }

    /* this is a wrapper node to contain the IdentExprNode */

}
