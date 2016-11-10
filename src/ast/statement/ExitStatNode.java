package ast.statement;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.IntType;
import type.StatementType;
import type.Type;

public class ExitStatNode implements StatementNode {


    public ExpressionNode expr;

    public ExitStatNode(ExpressionNode expr) {
        this.expr = expr;
    }


    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        /*
        Type type;
        try{
            type = expr.getNodeType(st);
        } catch (SemanticException se) {
            throw new SemanticException("The type must be an int in exit statement.");
        }

        if(!(type instanceof IntType)){
            throw new SemanticException("The type must be an int in exit statement.");
        }

        */
        StatementType stat = new StatementType();
        return stat.getType();
    }
}
