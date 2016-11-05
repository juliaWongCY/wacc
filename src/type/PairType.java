package type;

public class PairType implements Type {
    @Override
    public TypeEnum getType() {
        return TypeEnum.PAIR;
    }
}
