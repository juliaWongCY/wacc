package ast.assignRight;

import ast.expression.ExpressionNode;
import ast.expression.PairElemNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.PairType;
import type.Type;

public class PairElemAsRNode implements AssignRightNode {

    private PairElemNode pairElemNode;

    public PairElemAsRNode(PairElemNode pairElemNode) {
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
