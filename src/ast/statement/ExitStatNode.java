package ast.statement;

import ast.expression.ExpressionNode;
import ast.expression.IntLiterNode;
import backEnd.symbolTable.VarSymbolTable;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class ExitStatNode implements StatementNode {


    public ExpressionNode expr;

    public ExitStatNode(ExpressionNode expr) {
        this.expr = expr;
    }

    public ExpressionNode getExpr() {
        return expr;
    }

    public Integer getExitValue(VarSymbolTable varSymbolTable) {
        return ((IntLiterNode) expr).getValue();
    }


    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        StatementType stat = new StatementType();
        return stat.getType();
    }
}
