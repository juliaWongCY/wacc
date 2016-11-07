package ast.assignLeft;


import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class PairElemAsLNode implements AssignLeftNode {

    private ExpressionNode pairElem;
    private boolean isFirst;

    public PairElemAsLNode(ExpressionNode pairElem, boolean isFirst) {
        this.pairElem = pairElem;
        this.isFirst = isFirst;
    }

    public ExpressionNode getPairElem() {
        return pairElem;
    }

    public boolean isFirst() {
        return isFirst;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return pairElem.getNodeType(st);
    }

    /* this is a wrapper class to contain the pairElemTypeNode */


}
