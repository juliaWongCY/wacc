package ast.assignRight;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.PairElemType;
import type.PairType;
import type.Type;

public class NewPairAsRNode implements AssignRightNode {


    //Not sure if it is PairElemType or ExpressionNode
    //It should be ExpressionNode since NewPairAsRNode initialises a pair
    private ExpressionNode fstElem;
    private ExpressionNode sndElem;

    public NewPairAsRNode(PairElemType fstElem, PairElemType sndElem) {
        this.fstElem = fstElem;
        this.sndElem = sndElem;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        PairType pairType = new PairType(fstElem, sndElem);
        return pairType.getType();
    }
}
