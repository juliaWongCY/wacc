package ast.statement;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class PrintStatNode implements StatementNode {

    // <stat> ='print' <expr>

    private ExpressionNode expr;
    public PrintStatNode(ExpressionNode expr) {
        this.expr = expr;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return expr.getNodeType(st);
        //StatementType stat = new StatementType();
        //return stat.getType();
    }
}
