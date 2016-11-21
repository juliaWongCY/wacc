package ast.parameter;

import ast.ASTNode;
import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

import java.util.ArrayList;
import java.util.List;

public class ParamListNode implements ASTNode{

    List<ParamNode> params;

    public ParamListNode(List<ParamNode> params) {
        this.params = params;
    }

    //This function will be useful for backend
    public List<ParamNode> getParams() {
        return params;
    }

    public List<Type> getNodeTypes(SymbolTable st) throws SemanticException {
        ArrayList<Type> types = new ArrayList<>();
        for (ParamNode p : params) {
            types.add(p.getNodeType(st));
        }
        return types;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        throw new SemanticException
                ("ParamListNode can contain multiple types, use method - "
                + "\"getNodeTypes\" instead");
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }

}
