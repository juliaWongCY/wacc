package ast.expression;

import ast.ASTNode;

public abstract class ExpressionNode implements ASTNode {

    protected int typeIndicator = -1;

    public int getTypeIndicator() {
        return typeIndicator;
    }



}
