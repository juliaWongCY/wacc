package ast.statement;

import ast.expression.ExpressionNode;
import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

import java.util.List;

public class FreeStatNode implements StatementNode {

    /* free is used to free the heap memory allocated for a pair or array and its immediate content.
     The expression must evaluate to a valid reference to a pair or array
     free is not recursive */

    private ExpressionNode expr;

    public FreeStatNode(ExpressionNode expr) {
        this.expr = expr;
    }

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
