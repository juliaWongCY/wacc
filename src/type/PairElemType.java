package type;

public class PairElemType extends Type {

    private Type elem;

    public PairElemType(Type elem) {
        this.elem = elem;
    }

    public Type getElemType() {
        return elem.getType();
    }

}
