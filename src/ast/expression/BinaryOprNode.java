package ast.expression;

import ast.BinaryOpr;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.*;

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
        Type t1 = exprL.getNodeType(st);
        Type t2 = exprR.getNodeType(st);

        if (t1.equals(t2)) {
            switch (binaryOpr) {
                case MULT:
                case DIV:
                case MOD:
                case PLUS:
                case MINUS:
                    if (t1 instanceof IntType) {
                        IntType intType = new IntType();
                        return intType.getType();
                    }
                    break;
                case GT:
                case GTE:
                case LT:
                case LTE:
                    if (t1 instanceof PairType) {
                        throw new SemanticException("You can't use PairType here.");
                    }
                    //Is it better if we don't use instanceof
                    if (t1 instanceof IntType || t1 instanceof CharType) {
                        BoolType boolType = new BoolType();
                        return boolType.getType();
                    }
                    break;
                case EQ:
                case NEQ:
                    BoolType boolType = new BoolType();
                    return boolType.getType();
                break;
                case AND:
                case OR:
                    BoolType boolType = new BoolType();
                    return boolType.getType();
                break;
            }

        }
    }
}

