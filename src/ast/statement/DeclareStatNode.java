package ast.statement;

import ast.assignRight.AssignRightNode;
import ast.expression.IdentNode;
import backEnd.AssemblyCode;
import backEnd.General.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

import java.util.List;

public class DeclareStatNode implements StatementNode {

    private Type type;
    private IdentNode id;
    private AssignRightNode assignRightNode;

    public DeclareStatNode(Type type,
                           IdentNode id,
                           AssignRightNode assignRightNode) {
        this.type = type;
        this.id = id;
        this.assignRightNode = assignRightNode;
    }

    public Type getType(){
        return type;
    }

    public IdentNode getId(){
        return id;
    }

    public AssignRightNode getAssignRightNode(){
        return assignRightNode;
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
