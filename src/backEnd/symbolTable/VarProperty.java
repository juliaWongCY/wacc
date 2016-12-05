package backEnd.symbolTable;

import backEnd.Util;
import type.ArrayType;
import type.PairType;
import type.Type;

public class VarProperty {

    private Type type;
    private int stackPos;

    public VarProperty(Type type, int stackPos) {
        this.type = type;
        this.stackPos = stackPos;
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

    // TODO: refactor class to VarProperty, since doesn't need the value field

//    private int elementIndicator    = Util.EMPTY_TYPE;
//    private int elementIndicatorSnd = Util.EMPTY_TYPE;
//    private boolean isArray         = false;
//    private boolean isPair          = false;
//    private int locationInStack     = 0;
//
//    public VarProperty(int elementIndicator, int locationInStack) {
//        this.elementIndicator = elementIndicator;
//        this.locationInStack = locationInStack;
//    }
//
//    public VarProperty(boolean isArray, int elementIndicator, int locationInStack) {
//        this.elementIndicator = elementIndicator;
//        this.isArray = isArray;
//        this.locationInStack = locationInStack;
//    }
//
//    public VarProperty(boolean isPair, int elementIndicator, int elementIndicatorSnd, int locationInStack) {
//        this.elementIndicator = elementIndicator;
//        this.elementIndicatorSnd = elementIndicatorSnd;
//        this.isPair = isPair;
//        this.locationInStack = locationInStack;
//    }
//
//    // for base type value
//
//    public int getValueType() {
//        return elementIndicator;
//    }
//
//    public int getArrayElemType() {
//        return elementIndicator;
//    }
//
//    public int getFstElemType() {
//        return elementIndicator;
//    }
//
//    public int getSndElemType() {
//        return elementIndicatorSnd;
//    }
//
//
//    public int getLocationInStack(){
//        return locationInStack;
//    }
//
//    public int getTypeSize() {
//        if (!(isArray || isPair)) {
//            return Util.getTypeSize(elementIndicator);
//        } else {
//            return 4;
//        }
//    }

}
