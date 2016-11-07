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

    public StatementNode getStat(){
        return stat;
    }
    //TODO
    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return null;
    }
}
