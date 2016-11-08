package type;

import ast.expression.ExpressionNode;

public class PairType extends Type {


    private Type fstExprType;
    private Type sndExprType;
    private ExpressionNode fstExpr;
    private ExpressionNode sndExpr;

    public PairType() {

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

    public ExpressionNode getFstExpr() {
        return fstExpr;
    }

    public ExpressionNode getSndExpr() {
        return sndExpr;
    }

    public void setFstExpr(ExpressionNode fstExpr) {
        this.fstExpr = fstExpr;
    }

    public void setSndExpr(ExpressionNode sndExpr) {
        this.sndExpr = sndExpr;
    }

}
