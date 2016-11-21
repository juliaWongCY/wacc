package ast.assignLeft;

import ast.expression.ArrayElemNode;
import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

import java.util.List;

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
