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

    @Override
    public String getTypeInString() {
        return "array";
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = super.equals(obj);
        if (isEqual) {
            Type t = ((ArrayType)obj).getElemType();
            if (getElemType() == null || t == null) {
                return true;
            }
            isEqual = getElemType().equals(t);
        }
        return isEqual;
    }
}
