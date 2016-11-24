package ast.statement;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class PrintlnStatNode implements StatementNode {

    private ExpressionNode expr;
    public PrintlnStatNode(ExpressionNode expr) {
        this.expr = expr;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        StatementType stat = new StatementType();
        return stat.getType();
    }

    public ExpressionNode getExpr() {
        return expr;
    }

    @Override
    public int getTypeIndicator() {
        return -1;
    }

}
