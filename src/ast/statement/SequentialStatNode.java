package ast.statement;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

import java.util.ArrayDeque;
import java.util.Deque;

public class SequentialStatNode implements StatementNode {

  // <stat> = <stat> ; <stat>
  // The second statement can itself be a sequential composition

    private Deque<StatementNode> listOfStatNode;
    private StatementNode firstStat;

    public SequentialStatNode(StatementNode firstStat) {
       this.firstStat = firstStat;
      listOfStatNode = new ArrayDeque<>();
    }

    public void addStatNode(StatementNode statNode){
        listOfStatNode.add(statNode);
    }

    public Deque<StatementNode> getListOfStatNode(){
        return listOfStatNode;
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
