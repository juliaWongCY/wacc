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

public class IfStatNode implements StatementNode {

    private ExpressionNode expr;
    private StatListNode statThenBody;
    private StatListNode statElseBody;


    public IfStatNode(ExpressionNode expr,
                      StatListNode statThenBody,
                      StatListNode statElseBody) {
        this.expr = expr;
        this.statThenBody = statThenBody;
        this.statElseBody = statElseBody;
    }

    public ExpressionNode getCond(){
        return expr;
    }

    public StatListNode getStatThenBody(){
        return statThenBody;
    }

    public StatListNode getStatElseBody(){
        return statElseBody;
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
