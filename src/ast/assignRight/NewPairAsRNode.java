package ast.assignRight;

import ast.expression.ExpressionNode;
import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.PairType;
import type.Type;

import java.util.List;

public class NewPairAsRNode implements AssignRightNode {

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
            throw new SemanticException("Failed to get first expression's type.");
        }
    }

    public Type getSndType(SymbolTable st) throws SemanticException {
        try {
            return snd.getNodeType(st);
        } catch (SemanticException e) {
            throw new SemanticException("Failed to get second expression's type.");
        }
    }
    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        PairType pairType = new PairType(getFstType(st), getSndType(st));
        return pairType;
    }

}
