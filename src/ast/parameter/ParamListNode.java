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

    //This function will be useful for backend
    public List<ParamNode> getParams() {
        return params;
    }

    public List<Type> getParamTypes() throws SemanticException {
        List<Type> types = new ArrayList<>();
        for (ParamNode p : params) {
            types.add(p.getNodeType(null));
        }
        return types;
    }

    public List<String> getParamNames() {
        List<String> names = new ArrayList<>();
        for (ParamNode p : params) {
            names.add(p.getParamName());
        }
        return names;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        throw new SemanticException
                ("ParamListNode can contain multiple types, use method - "
                + "\"getParamTypes\" instead");
    }


}
