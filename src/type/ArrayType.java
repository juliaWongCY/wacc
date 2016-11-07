package type;

public class ArrayType extends Type {

    private Type elemType;
    private int length;
    private int nestedLayer;

    public ArrayType(Type elemType, int length, int nestedLayer) {
        this.elemType = elemType;
        this.length = length;
        this.nestedLayer = nestedLayer;
    }

    public Type getElemType() {
        return elemType;
    }

    public int getLength() {
        return length;
    }

    public int getNestedLayer() {
        return nestedLayer;
    }
}
