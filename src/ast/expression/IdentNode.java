package ast.expression;

import ast.ASTNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class IdentNode implements ExpressionNode {

    private final String id;

    public IdentNode(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        try {
            return st.lookUpVariable(id);
        } catch (SemanticException e) {
            throw new SemanticException("This " + id + " not an identifier.");
        }

    }
}
