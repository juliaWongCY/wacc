package type;

import java.util.List;

public class FunctionType extends Type{

    private Type returnType;
    private List<Type> params;

    public FunctionType(Type returnType) {
        this.returnType = returnType;
        params = null;
    }

    public FunctionType(Type returnType, List<Type> params) {
        this.returnType = returnType;
        this.params = params;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<Type> getParams() {
        return params;
    }

    @Override
    public String getTypeInString() {
        return "func";
    }
}

