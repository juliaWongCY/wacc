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

        IntType intType = new IntType();
        BoolType boolType = new BoolType();

        if (t1.equals(t2)) {
            switch (binaryOpr) {
                case MULT:
                case DIV:
                case MOD:
                case PLUS:
                case MINUS:
                    if (t1 instanceof IntType) {
                        return intType.getType();
                    } else {
                        throw new SemanticException("Only IntLiter");
                    }
                case GT:
                case GTE:
                case LT:
                case LTE:
                    //Is it better if we don't use instanceof
                    if (t1 instanceof IntType || t1 instanceof CharType) {
                        return boolType.getType();
                    }
                    break;
                case EQ:
                case NEQ:
                    if (t1 instanceof IntType || t1 instanceof CharType ||
                            t1 instanceof StringType || t1 instanceof BoolType ||
                            t1 instanceof PairType) {
                        return boolType.getType();
                    }
                    break;
                case AND:
                case OR:
                    if (t1 instanceof BoolType) {
                        return boolType.getType();
                    }
                    break;
                default: //Should never reach here
                    throw new SemanticException("Error: Binary opeartor not found.");
            }
        }

        throw new SemanticException("If none of above, then there is error.");
    }
}

