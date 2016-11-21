package ast.statement;

import ast.expression.ExpressionNode;
import backEnd.AssemblyCode;
import backEnd.General.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.BoolType;
import type.StatementType;
import type.Type;

import java.util.List;

public class WhileStatNode implements StatementNode {


    private ExpressionNode expr;
    private StatListNode stat;

    public WhileStatNode(ExpressionNode expr,
                         StatListNode stat){
        this.expr = expr;
        this.stat = stat;
    }

    public ExpressionNode getCondition(){
        return expr;
    }

    public StatListNode getBody(){
        return stat;
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
