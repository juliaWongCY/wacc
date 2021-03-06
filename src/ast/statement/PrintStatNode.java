package ast.statement;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class PrintStatNode implements StatementNode {

    private ExpressionNode expr;
    public PrintStatNode(ExpressionNode expr) {
        this.expr = expr;
    }

    public ExpressionNode getExpr() {
        return expr;
    }

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
