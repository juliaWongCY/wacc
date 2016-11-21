package ast.statement;

import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

import java.util.List;

public class ScopingStatNode implements StatementNode {


    private StatListNode stat;

    public ScopingStatNode(StatListNode stat) {
        this.stat = stat;
    }

    public StatListNode getchildrenStat(){
        return stat;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        StatementType stat = new StatementType();
        return stat.getType();
    }

}
