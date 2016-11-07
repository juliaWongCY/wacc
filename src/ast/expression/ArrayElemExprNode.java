package ast.expression;

import frontEnd.SymbolTable;
import type.Type;

import java.util.List;

public class ArrayElemExprNode implements ExpressionNode {

    private Type arrayType;
    private IdentNode arrayName;
    private List<String> indexes;

    @Override
    public Type getNodeType(SymbolTable st) {
        // look up
        return null;
    }
}
