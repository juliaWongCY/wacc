package type;

public class PairType extends Type {

    private boolean isLiter;
    private Type fstExprType;
    private Type sndExprType;

    // for pair literal - pair literal only used in declaration of newpair
    public PairType() {
        isLiter     = true;
        fstExprType = null;
        sndExprType = null;
    }

    public PairType(Type fstExprType, Type sndExprType) {
        this.isLiter     = false;
        this.fstExprType = fstExprType;
        this.sndExprType = sndExprType;
    }

    public Type getFstExprType() {
        return fstExprType;
    }

    public Type getSndExprType() {
        return sndExprType;
    }

    public boolean isLiter() {
        return isLiter;
    }

    public void setLiter() {
        isLiter = true;
        fstExprType = null;
        sndExprType = null;
    }

    public void setExprTypes(Type fstExprType, Type sndExprType) {
        this.fstExprType = fstExprType;
        this.sndExprType = sndExprType;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual =  super.equals(obj);
        if (isEqual) {
            PairType t = (PairType)obj;
            if (!isLiter() && !(t.isLiter())) {
                isEqual = getFstExprType().equals(t.getFstExprType())
                        && getSndExprType().equals(t.getSndExprType());
            }
        }

//        if (isEqual && isLiter) {
//                PairType t = (PairType)obj;
//                isEqual = ((getFstExprType() instanceof PairType && t.getFstExprType() instanceof PairType)
//                        || getFstExprType().equals(t.getFstExprType()))
//                        && ((getSndExprType() instanceof PairType && t.getSndExprType() instanceof PairType)
//                        || getSndExprType().equals(t.getSndExprType()));
//        }


        return isEqual;
    }
}
