package ast.assignRight;

import ast.expression.IdentNode;
import backEnd.Util;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.FunctionType;
import type.Type;

public class CallAsRNode implements AssignRightNode {

    private IdentNode functionId;
    private ArgListNode argList;
    private Type retType;

    public CallAsRNode(IdentNode functionId) {
        this.functionId = functionId;
        this.argList = null;
        this.retType = null;
    }

    public CallAsRNode(IdentNode functionId, ArgListNode argList) {
        this.functionId = functionId;
        this.argList = argList;
    }

    //These functions will be useful for backend
    public IdentNode getFunctionId() {
        return functionId;
    }

    public ArgListNode getArgList() {
        return argList;
    }

    @Override
    public int getTypeIndicator() {
        return Util.convertTypeToIndicator(retType);
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        Type type = st.lookUpFunction(functionId.getId()); // return the return type of the function, instead of its parameters
        if (type instanceof FunctionType) {
            type = ((FunctionType) type).getReturnType();
            retType = type;
            return retType;
        } else {
            throw new SemanticException("Call not apply to function type");
        }
    }
}
