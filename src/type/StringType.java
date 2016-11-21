package type;

public class StringType extends Type {

    public StringType() {

    }

    @Override
    public String getTypeInString() {
        return "string";
    }

    @Override
    public Type getType() {
        return new ArrayType(new CharType());
    }
}
