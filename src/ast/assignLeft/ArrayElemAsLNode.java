package ast.assignLeft;

import ast.expression.ArrayElemExprNode;
import ast.expression.IdentNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;


public class ArrayElemAsLNode implements AssignLeftNode {

    private ArrayElemExprNode arrayElem;

    public ArrayElemAsLNode(ArrayElemExprNode arrayElem) {
        this.arrayElem = arrayElem;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return arrayElem.getNodeType(st);
    }
}
