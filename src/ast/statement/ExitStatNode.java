package ast.statement;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class ExitStatNode implements StatementNode {

    //<stat> = ‘exit’ <expr>

    public ExpressionNode expr;

    public ExitStatNode(ExpressionNode expr) {
        this.expr = expr;
    }


    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        StatementType stat = new StatementType();
        return stat.getType();
    }
}
