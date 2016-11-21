package ast.assignRight;

import ast.expression.IdentNode;
import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.FunctionType;
import type.Type;

import java.util.List;

public class CallAsRNode implements AssignRightNode {

    private IdentNode functionId;
    private ArgListNode argList;

    public CallAsRNode(IdentNode functionId) {
        this.functionId = functionId;
        this.argList = null;
    }

    public CallAsRNode(IdentNode functionId, ArgListNode argList) {
        this.functionId = functionId;
        this.argList = argList;
    }

    //These functions will be useful for backend
    public IdentNode getFunctionId() {
        return functionId;
    }

    public void setFunctionId(IdentNode functionId) {
        this.functionId = functionId;
    }

    public ArgListNode getArgList() {
        return argList;
    }

    public void setArgList(ArgListNode argList) {
        this.argList = argList;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        Type type = st.lookUpFunction(functionId.getId()); // return the return type of the function, instead of its parameters
        if (type instanceof FunctionType) {
            return ((FunctionType)type).getReturnType();
        } else {
            throw new SemanticException("Call not apply to function type");
        }
    }
}
