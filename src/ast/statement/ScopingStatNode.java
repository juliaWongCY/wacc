package ast.statement;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class ScopingStatNode implements StatementNode {


    private StatementNode stat;

    public ScopingStatNode(StatementNode stat) {
        this.stat = stat;
    }

    public StatementNode getchildrenStat(){
        return stat;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        StatementType stat = new StatementType();
        return stat.getType();
    }
}
