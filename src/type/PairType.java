package type;

import ast.expression.ExpressionNode;

public class PairType extends Type {


    private Type fstExprType;
    private Type sndExprType;

    public PairType() {
        fstExprType = null;
        sndExprType = null;
    }

    public PairType(Type fstExprType, Type sndExprType) {
        this.fstExprType = fstExprType;
        this.sndExprType = sndExprType;
    }

    public Type getFstExprType() {
        return fstExprType;
    }

    public Type getSndExprType() {
        return sndExprType;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual =  super.equals(obj);
        if (isEqual) {
            isEqual = getFstExprType().equals(((PairType)obj).getFstExprType())
                    && getSndExprType().equals(((PairType)obj).getSndExprType());
        }
        return isEqual;
    }
}
