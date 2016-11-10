package ast.assignLeft;


import ast.expression.ExpressionNode;
import ast.expression.PairElemNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class PairElemAsLNode implements AssignLeftNode {

    private PairElemNode pairElemNode;

    public PairElemAsLNode(PairElemNode pairElemNode) {
        this.pairElemNode = pairElemNode;
    }

    public PairElemNode getPairElemNode() {
        return pairElemNode;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return pairElemNode.getNodeType(st);
    }
}
