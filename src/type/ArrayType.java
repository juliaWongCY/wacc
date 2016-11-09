package type;

public class ArrayType extends Type {

    private Type elemType;

    public ArrayType() {
        this.elemType = null;
    }

    public ArrayType(Type elemType) {
        this.elemType = elemType;
    }

    public Type getElemType() {
        return elemType;
    }

    public void setElemType(Type elemType) {
        this.elemType = elemType;
    }


}
