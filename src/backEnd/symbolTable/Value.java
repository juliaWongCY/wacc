package backEnd.symbolTable;

public class Value {

    public static final int INT_TYPE    = 0;
    public static final int BOOL_TYPE   = 1;
    public static final int CHAR_TYPE   = 2;
    public static final int STRING_TYPE = 3;
    public static final int ARRAY_TYPE  = 4;
    public static final int PAIR_TYPE   = 5;

    private String value = null;
    private int elementIndicator    = -1;
    private int elementIndicatorSnd = -1;
    private boolean isArray         = false;
    private boolean isPair          = false;

    // for base type value
    public Value(String value, int elementIndicator) {
        this.value = value;
        this.elementIndicator = elementIndicator;
    }

    // for array type value, where the indicator indicates the element type
    public Value(String value, boolean isArray, int elementIndicator) {
        this.value = value;
        this.isArray = true;
        this.elementIndicator = elementIndicator;
    }

    // for pair type value, where the two indicators indicate the fst and snd elements respectively
    public Value(String value, boolean isPair, int elementIndicator, int elementIndicatorSnd) {
        this.value = value;
        this.isPair = true;
        this.elementIndicator = elementIndicator;
        this.elementIndicatorSnd = elementIndicatorSnd;
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

    public int getTypeSize() {
        if (!(isArray || isPair)
                && (elementIndicator == BOOL_TYPE
                || elementIndicator == CHAR_TYPE)) {
            return 1;
        } else {
            return 4;
        }
    }

}
