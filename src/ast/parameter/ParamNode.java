package ast.parameter;

import ast.ASTNode;
import ast.expression.IdentNode;
import backEnd.AssemblyCode;
import backEnd.General.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

import java.util.List;

public class ParamNode implements ASTNode {

    private Type type;
    private IdentNode paramName;

    public ParamNode(Type type, IdentNode paramName) {
        this.type = type;
        this.paramName = paramName;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return type;
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }

}
