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

    //The type of the expression given to the return statement must match
    // the return type of the function
    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        //return expr.getNodeType(st);
        StatementType stat = new StatementType();
        return stat.getType();
    }
}
