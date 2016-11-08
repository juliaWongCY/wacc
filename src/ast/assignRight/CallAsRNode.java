package ast.assignRight;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.FunctionType;
import type.Type;

public class CallAsRNode implements AssignRightNode {

    private String functionName;


    public CallAsRNode(String functionName) {
        this.functionName = functionName;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        Type type = st.lookUpFunction(functionName);
        if (type instanceof FunctionType) {
            return ((FunctionType)type).getReturnType();
        } else {
            throw new SemanticException("Call not apply to function type");
        }
    }
}
