package backEnd.symbolTable;

import backEnd.Util;
import type.ArrayType;
import type.PairType;
import type.Type;

public class VarProperty {

    private Type type;
    private int stackPos;
    private boolean isParam = false;

    public VarProperty(Type type, int stackPos) {
        this.type = type;
        this.stackPos = stackPos;
    }

    public VarProperty(Type type, int stackPos, boolean isParam) {
        this.type = type;
        this.stackPos = stackPos;
        this.isParam = isParam;
    }

    public Type getType() {
        return type;
    }

    public int getStackPos() {
        return stackPos;
    }

    public int getTypeSize() {
        if (type instanceof ArrayType || type instanceof PairType) {
            return 4;
        } else {
            return Util.getTypeSize(type);
        }
    }

    public boolean isParam() {
        return isParam;
    }
}
