package ast.expression;

import ast.UnaryOpr;
import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.*;

import java.util.List;

public class UnaryOprNode implements ExpressionNode {

    private UnaryOpr unaryOpr;
    private ExpressionNode expr;

    public UnaryOprNode(UnaryOpr unaryOpr, ExpressionNode expr) {
        this.unaryOpr = unaryOpr;
        this.expr = expr;
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
                    return boolType.getType();
                }
            case NEG:
                if (t instanceof IntType) {
                    return intType.getType();
                }
            case LEN:
                if (t instanceof ArrayType || t instanceof StringType) {
                    return intType.getType();
                }
            case ORD:
                if (t instanceof CharType) {
                    return intType.getType();
                }
            case CHR:
                if (t instanceof IntType) {
                    return charType.getType();
                }
            default: //Should never reach here
                throw new SemanticException("Error: Unary opeartor not found.");

        }

    }

}
