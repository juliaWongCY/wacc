package ast.assignLeft;

import ast.expression.ArrayElemExprNode;
import ast.expression.IdentNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;


public class ArrayElemAsLNode implements AssignLeftNode {

    private IdentNode identifier;
    private ArrayElemExprNode arrayElem;

    public ArrayElemAsLNode(IdentNode identifier, ArrayElemExprNode arrayElem) {
        this.identifier = identifier;
        this.arrayElem = arrayElem;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return null;
    }
}
