package ast.expression;

import ast.UnaryOpr;
import backEnd.Util;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.*;

public class UnaryOprNode extends ExpressionNode {

    private UnaryOpr unaryOpr;
    private ExpressionNode expr;

    public UnaryOprNode(UnaryOpr unaryOpr, ExpressionNode expr) {
        this.unaryOpr = unaryOpr;
        this.expr = expr;
        switch (unaryOpr) {
            case NOT:
                typeIndicator = Util.BOOL_TYPE;
            case NEG:
            case LEN:
            case ORD:
                typeIndicator = Util.INT_TYPE;
            case CHR:
                typeIndicator = Util.CHAR_TYPE;
            default: //Should never reach here
        }
    }

    public UnaryOpr getUnaryOpr() {
        return unaryOpr;
    }

    public ExpressionNode getExpr() {
        return expr;
    }


    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        Type t = expr.getNodeType(st);

        IntType intType = new IntType();
        BoolType boolType = new BoolType();
        CharType charType = new CharType();

        switch (unaryOpr) {
            case NOT:
                if (t instanceof BoolType) {
                    typeIndicator = Util.BOOL_TYPE;
                    return boolType.getType();
                }
            case NEG:
                if (t instanceof IntType) {
                    typeIndicator = Util.INT_TYPE;
                    return intType.getType();
                }
            case LEN:
                if (t instanceof ArrayType || t instanceof StringType) {
                    typeIndicator = Util.INT_TYPE;
                    return intType.getType();
                }
            case ORD:
                if (t instanceof CharType) {
                    typeIndicator = Util.INT_TYPE;
                    return intType.getType();
                }
            case CHR:
                if (t instanceof IntType) {
                    typeIndicator = Util.CHAR_TYPE;
                    return charType.getType();
                }
            default: //Should never reach here
                throw new SemanticException("Error: Unary opeartor not found.");

        }

    }

}
