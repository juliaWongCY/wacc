package ast.statement;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class SequentialStatNode implements StatementNode {


    public SequentialStatNode() {
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return null;
    }
}
