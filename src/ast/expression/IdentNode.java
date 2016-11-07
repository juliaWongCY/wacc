package ast.expression;

import ast.ASTNode;
import type.Type;

public class IdentNode implements ExpressionNode {

    private final String id;

    public Ident(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    @Override
    public Type getNodeType() {

    }
}
