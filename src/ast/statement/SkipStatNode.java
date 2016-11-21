package ast.statement;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class SkipStatNode implements StatementNode {

    public SkipStatNode() {

    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        StatementType stat = new StatementType();
        return stat.getType();
    }

}
