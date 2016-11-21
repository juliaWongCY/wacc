package ast.statement;

import ast.expression.ExpressionNode;
import backEnd.AssemblyCode;
import backEnd.General.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

import java.util.List;

public class ReturnStatNode implements StatementNode {

    ExpressionNode expr;

    public ReturnStatNode(ExpressionNode expr) {
        this.expr = expr;
    }

    public Type getReturnType(SymbolTable symbolTable) throws SemanticException {
        return expr.getNodeType(symbolTable);
    }

    /*The type of the expression given to the return statement must match
     the return type of the function */
    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        StatementType stat = new StatementType();
        return stat.getType();
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }
}
