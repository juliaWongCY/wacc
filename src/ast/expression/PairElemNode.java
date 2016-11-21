package ast.expression;

import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.PairType;
import type.Type;

import java.util.List;

public class PairElemNode implements ExpressionNode {

    private ExpressionNode expressionNode;
    private boolean isFirst;

    public PairElemNode(ExpressionNode expressionNode, boolean isFirst) {
        this.expressionNode = expressionNode;
        this.isFirst = isFirst;
    }

    //This will be useful for backend
    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    public boolean isFirst() {
        return isFirst;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        if (expressionNode == null) {
            throw new SemanticException("Expression node is null");
        } else {
            Type t = expressionNode.getNodeType(st);
            if (t instanceof PairType) {
                if (isFirst) {
                    return ((PairType) t).getFstExprType();
                } else {
                    return ((PairType) t).getSndExprType();
                }
            }
            throw new SemanticException("Expression node not of required type pair");
        }

    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }
}
