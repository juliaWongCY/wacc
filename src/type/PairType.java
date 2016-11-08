package type;

public class PairType extends Type {

    private PairElemType fst;
    private PairElemType snd;

    public PairType() {

    }

    public PairType(PairElemType fst, PairElemType snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public Type getFst() {
        return fst.getElemType();
    }

    public Type getSnd() {
        return snd.getElemType();
    }


}
