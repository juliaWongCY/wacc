package ast.expression;

import ast.BinaryOpr;
import backEnd.Util;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.*;

public class BinaryOprNode extends ExpressionNode {

    private final BinaryOpr binaryOpr;
    private final ExpressionNode exprL;
    private final ExpressionNode exprR;

    public BinaryOprNode(BinaryOpr binaryOpr, ExpressionNode exprL, ExpressionNode exprR) {
        this.binaryOpr = binaryOpr;
        this.exprL = exprL;
        this.exprR = exprR;
        if (isArithmetic()) {
            typeIndicator = Util.INT_TYPE;
        } else {
            typeIndicator = Util.BOOL_TYPE;
        }
    }

    public ExpressionNode getExprL() {
        return exprL;
    }

    public ExpressionNode getExprR() {
        return exprR;
    }

    public BinaryOpr getBinaryOpr() {
        return binaryOpr;
    }

    public boolean isArithmetic() {
        return binaryOpr == BinaryOpr.PLUS || binaryOpr == BinaryOpr.MINUS
                || binaryOpr == BinaryOpr.MULT || binaryOpr == BinaryOpr.DIV
                || binaryOpr == BinaryOpr.MOD;
    }

    public boolean isComparison() {
        return binaryOpr == BinaryOpr.GT || binaryOpr == BinaryOpr.GTE
                || binaryOpr == BinaryOpr.LT || binaryOpr == BinaryOpr.LTE
                || binaryOpr == BinaryOpr.EQ || binaryOpr == BinaryOpr.NEQ;
    }

    public boolean isLogical() {
        return binaryOpr == BinaryOpr.AND || binaryOpr == BinaryOpr.OR;
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

}

