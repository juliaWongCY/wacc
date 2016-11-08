package ast.statement;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.ArrayType;
import type.PairType;
import type.Type;

public class FreeStatNode implements StatementNode {
    // <stat> = 'free' <expr>

    //‘free’ is used to free the heap memory allocated for a pair or array and its immediate content.
    // The expression must evaluate to a valid reference to a pair or array
    // free is not recursive

    private ExpressionNode expr;

    public FreeStatNode(ExpressionNode expr) {
        this.expr = expr;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        Type type;
        type = expr.getNodeType(st);

        if (!((type instanceof PairType) || (type instanceof ArrayType))){
            throw new SemanticException("The expression must evaluate to a valid ref to a pair.");
        }
        return type;
    }
}
