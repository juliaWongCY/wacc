package type;

public class PairElemType implements Type {

    //A pair contains two elements that can be of any type.
    private final Type fst;
    private final Type snd;

    public PairElemType(Type fst, Type snd) {
        //TODO: fst and snd could be either a pair or any other types respectively.
        this.fst = fst;
        this.snd = snd;
    }

    public Type getFst() {
        return fst;
    }

    public Type getSnd() {
        return snd;
    }

    @Override
    public TypeEnum getType() {
        return TypeEnum.PAIR_ELEM;
    }
}
