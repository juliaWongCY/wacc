package type;

public class ArrayType implements Type {
    @Override
    public TypeEnum getType() {
        return TypeEnum.ARRAY;
    }
}
