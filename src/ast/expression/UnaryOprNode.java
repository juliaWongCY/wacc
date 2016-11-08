package ast.expression;

import ast.UnaryOpr;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.*;

public class UnaryOprNode implements ExpressionNode {

    //<expr> = <unary-opr> <expr>
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
                break;
            case NEG:
                if (t instanceof IntType) {
                    return intType.getType();
                }
                break;
            case LEN:
                if (t instanceof ArrayType || t instanceof StringType) {
                    return intType.getType();
                }
                break;
            case ORD:
                if (t instanceof CharType) {
                    return intType.getType();
                }
                break;
            case CHR:
                if (t instanceof IntType) {
                    return charType.getType();
                }
                break;
            default: //Should never reach here
                throw new SemanticException("Error: Unary opeartor not found.");

        }

        //Once reach here, it means type mismatch.
        throw new SemanticException("WRONG TYPE");
    }
}
