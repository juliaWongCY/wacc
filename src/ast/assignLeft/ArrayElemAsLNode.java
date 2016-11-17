package ast.assignLeft;

import ast.expression.ArrayElemNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class ArrayElemAsLNode implements AssignLeftNode {

    private ArrayElemNode arrayElem;

    public ArrayElemAsLNode(ArrayElemNode arrayElem) {
        this.arrayElem = arrayElem;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return arrayElem.getNodeType(st);
    }
}
