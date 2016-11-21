package ast.assignRight;

import ast.expression.ExpressionNode;
import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

import java.util.List;

public class ExprAsRNode implements AssignRightNode {

    private ExpressionNode expr;

    public ExprAsRNode(ExpressionNode expr) {
        this.expr = expr;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return expr.getNodeType(st);
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }
}
