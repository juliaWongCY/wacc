package ast.statement;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class ScopingStatNode implements StatementNode {


    private StatListNode stat;

    public ScopingStatNode(StatListNode stat) {
        this.stat = stat;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        StatementType stat = new StatementType();
        return stat.getType();
    }

    @Override
    public int getTypeIndicator() {
        return -1;
    }

    public StatListNode getBody() {
        return stat;
    }
}
