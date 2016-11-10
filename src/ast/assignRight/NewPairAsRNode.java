package ast.assignRight;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.PairType;
import type.Type;

public class NewPairAsRNode implements AssignRightNode {


    //Not sure if it is PairElemType or ExpressionNode
    //It should be ExpressionNode since NewPairAsRNode initialises a pair
    // [DL] this should be a "constructor/assignment" of a pair type variable
    private ExpressionNode fst;
    private ExpressionNode snd;

    public NewPairAsRNode(ExpressionNode fst, ExpressionNode snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public Type getFstType(SymbolTable st) throws SemanticException {
        try {
            return fst.getNodeType(st);
        } catch (SemanticException e) {
            throw new SemanticException("Failed to get frst expression's type.");
        }
    }

    public Type getSndType(SymbolTable st) throws SemanticException {
        try {
            return snd.getNodeType(st);
        } catch (SemanticException e) {
            throw new SemanticException("Failed to get frst expression's type.");
        }
    }
    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        PairType pairType = new PairType(getFstType(st), getSndType(st));
        return pairType;
    }
}
