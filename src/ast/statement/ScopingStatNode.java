package ast.statement;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class ScopingStatNode implements StatementNode {
    // <stat> = 'begin' <stat> 'end'

    private StatementNode stat;

    public ScopingStatNode(StatementNode stat) {
        this.stat = stat;
    }

    public StatementNode getchildrenStat(){
        return stat;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return stat.getNodeType(st);
        //StatementType stat = new StatementType();
        //return stat.getType();
    }
}
