package ast.statement;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class BeginStatNode implements StatementNode {
    // <stat> = 'begin' <stat> 'end'

    private StatementNode stat;

    public BeginStatNode(StatementNode stat) {
        this.stat = stat;
    }

    public StatementNode getchildrenStat(){
        return stat;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return stat.getNodeType(st);
    }
}
