package ast.expression;

import ast.BinaryOpr;
import backEnd.AssemblyCode;
import backEnd.General.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.*;

import java.util.List;

public class BinaryOprNode implements ExpressionNode {

    private final BinaryOpr binaryOpr;
    private final ExpressionNode exprL;
    private final ExpressionNode exprR;

    public BinaryOprNode(BinaryOpr binaryOpr, ExpressionNode exprL, ExpressionNode exprR) {
        this.binaryOpr = binaryOpr;
        this.exprL = exprL;
        this.exprR = exprR;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        Type tL = exprL.getNodeType(st);
        Type tR = exprR.getNodeType(st);

        IntType intType = new IntType();
        BoolType boolType = new BoolType();

        if (tL.equals(tR)) {
            switch (binaryOpr) {
                case MULT:
                case DIV:
                case MOD:
                case PLUS:
                case MINUS:
                    if (tL instanceof IntType) {
                        return intType.getType();
                    } else {
                        throw new SemanticException("Only IntLiter");
                    }
                case GT:
                case GTE:
                case LT:
                case LTE:
                    if (tL instanceof IntType || tL instanceof CharType) {
                        return boolType.getType();
                    }
                    break;
                case EQ:
                case NEQ:
                    if (tL instanceof IntType || tL instanceof CharType ||
                            tL instanceof StringType || tL instanceof BoolType ||
                            tL instanceof PairType || tL instanceof ArrayType) {
                        return boolType.getType();
                    }
                    break;
                case AND:
                case OR:
                    if (tL instanceof BoolType) {
                        return boolType.getType();
                    }
                    break;
                default: //Should never reach here
                    throw new SemanticException("Error: Binary opeartor not found.");
            }
        }

        throw new SemanticException("If none of the above, there is error.");
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }
}

