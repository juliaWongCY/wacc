package ast.statement;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;


public class SequentialStatNode implements StatementNode {

  // The second statement can itself be a sequential composition

    private StatementNode fstStat;
    private StatementNode sndStat;

    public SequentialStatNode(StatementNode fstStat, StatementNode sndStat) {
        this.fstStat = fstStat;
        this.sndStat = sndStat;
    }

    public StatementNode getFstStat() {
        return fstStat;
    }

    public StatementNode getSndStat() {
        return sndStat;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        StatementType stat = new StatementType();
        return stat.getType();
    }
}
