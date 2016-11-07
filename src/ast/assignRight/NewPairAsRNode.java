package ast.assignRight;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class NewPairAsRNode implements AssignRightNode {
    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return null;
    }
}
