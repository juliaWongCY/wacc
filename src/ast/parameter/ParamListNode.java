package ast.parameter;

import ast.ASTNode;
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

}
