package ast.parameter;

import ast.ASTNode;
import ast.expression.IdentNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

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

    public String getParamName() {
        return paramName.getId();
    }
}
