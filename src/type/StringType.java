package type;

public class StringType extends Type {

    public StringType() {

    }

    @Override
    public Type getType() {
        return new ArrayType(new CharType());
    }
}
