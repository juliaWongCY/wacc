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
        // <expr> = <expr> <binary-oper> <expr>
        //<binary-oper> ::= ‘*’ | ‘/’ | ‘%’ | ‘+’ | ‘-’ | ‘>’ | ‘>=’ | ‘<’ | ‘<=’ | ‘==’ | ‘!=’ | ‘&&’ | ‘||’
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
                    //Is it better if we don't use instanceof
                    if (tL instanceof IntType || tL instanceof CharType) {
                        return boolType.getType();
                    }
                    break;
                case EQ:
                case NEQ:
                    if (tL instanceof IntType || tL instanceof CharType ||
                            tL instanceof StringType || tL instanceof BoolType ||
                            tL instanceof PairType) {
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

        throw new SemanticException("If none of above, then there is error.");
    }
}

