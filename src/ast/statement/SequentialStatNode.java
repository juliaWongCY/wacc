package ast.statement;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

import java.util.ArrayDeque;
import java.util.Deque;

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

    //TODO: Double-check
    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        /*
        if(!(firstStat instanceof StatementType)){
            throw new SemanticException("The first statement should be a StatementType");
        }

        Type nodeType;
        for(StatementNode statNode: listOfStatNode){
            try{
              nodeType = statNode.getNodeType(st);
            } catch (SemanticException e){
                throw new SemanticException("The first statement should be a StatementType");
            }

            if(!(nodeType instanceof StatementType)){
                throw new SemanticException("The first statement should be a StatementType");
            }
        }
         */
        //return nodeType;
        StatementType stat = new StatementType();
        return stat.getType();
    }
}
