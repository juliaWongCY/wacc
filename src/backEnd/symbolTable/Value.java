package backEnd.symbolTable;

import backEnd.Util;

public class Value {



    private String value = null;
    private int elementIndicator    = Util.EMPTY_TYPE;
    private int elementIndicatorSnd = Util.EMPTY_TYPE;
    private boolean isArray         = false;
    private boolean isPair          = false;
    private int locationInStack     = 0;

    // for base type value
    public Value(String value, int elementIndicator, int locationInStack) {
        this.value = value;
        this.elementIndicator = elementIndicator;
        this.locationInStack = locationInStack;
    }

    // for array type value, where the indicator indicates the element type
    public Value(String value, boolean isArray, int elementIndicator, int locationInStack) {
        this.value = value;
        this.isArray = true;
        this.elementIndicator = elementIndicator;
        this.locationInStack = locationInStack;
    }

    // for pair type value, where the two indicators indicate the fst and snd elements respectively
    public Value(String value, boolean isPair, int elementIndicator, int elementIndicatorSnd, int locationInStack) {
        this.value = value;
        this.isPair = true;
        this.elementIndicator = elementIndicator;
        this.elementIndicatorSnd = elementIndicatorSnd;
        this.locationInStack = locationInStack;
    }

    public String getValue() {
        return value;
    }

    public int getValueType() {
        return elementIndicator;
    }

    public int getArrayElemType() {
        return elementIndicator;
    }

    public int getFstElemType() {
        return elementIndicator;
    }

    public int getSndElemType() {
        return elementIndicatorSnd;
    }

    public int getLocationInStack(){
        return locationInStack;
    }

    public int getTypeSize() {
        if (!(isArray || isPair)) {
            return Util.getTypeSize(elementIndicator);
        } else {
            return 4;
        }
    }

}
