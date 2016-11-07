package type;

public class ArrayType extends Type {

    private Type elemType;
    private int length;
    private int nestedLayer;

    public ArrayType() {
        this.elemType = null;
        this.length = 0;
        this.nestedLayer = 0;
    }

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

    public void setElemType(Type elemType) {
        this.elemType = elemType;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
