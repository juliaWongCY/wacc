package type;

import ast.expression.ExpressionNode;

public class PairType extends Type {

    private PairElemType fst;
    private PairElemType snd;

    public PairType() {

    }

    //Type instead of PairElemType???
    //Our goal is to get the basetype instead of what the pair stores.
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

    public ExpressionNode getFstExpression() {
        return fst.getExpressionNode();
    }

    public ExpressionNode getSndExoression() {
        return snd.getExpressionNode();
    }

    public void setFstExpression(ExpressionNode expressionNode) {
        fst.setExpressionNode(expressionNode);
    }

    public void setSndExpression(ExpressionNode expressionNode) {
        snd.setExpressionNode(expressionNode);
    }


}
