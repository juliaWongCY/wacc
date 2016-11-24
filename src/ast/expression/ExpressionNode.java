package ast.expression;

import ast.ASTNode;
import backEnd.Util;

public abstract class ExpressionNode implements ASTNode {

    protected int typeIndicator = Util.EMPTY_TYPE;

    public int getTypeIndicator() {
        return typeIndicator;
    }



}
