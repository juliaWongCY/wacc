package ast.statement;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class ReturnStatNode implements StatementNode {

    ExpressionNode expr;

    public ReturnStatNode(ExpressionNode expr) {
        this.expr = expr;
    }

    public Type getReturnType(SymbolTable symbolTable) throws SemanticException {
        return expr.getNodeType(symbolTable);
    }

    public ExpressionNode getExpr() {
        return expr;
    }

    /*The type of the expression given to the return statement must match
     the return type of the function */
    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        StatementType stat = new StatementType();
        return stat.getType();
    }

    @Override
    public int getTypeIndicator() {
        return -1;
    }
}
