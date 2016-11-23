package ast.expression;

import backEnd.Util;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class IdentNode extends ExpressionNode {

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
            Type type = st.lookUpVariable(id);
            typeIndicator = Util.convertTypeToIndicator(type);
            return type;
        } catch (SemanticException e) {
            throw new SemanticException("This " + id + " not an identifier.");
        }

    }

}
