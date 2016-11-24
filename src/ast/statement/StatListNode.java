package ast.statement;

import ast.ASTNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

import java.util.List;

public class StatListNode implements ASTNode{

    List<StatementNode> statList;

    public StatListNode(List<StatementNode> statList) {
        this.statList = statList;
    }

    public List<StatementNode> getStatList() {
        return statList;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        for (StatementNode statementNode : statList) {
            if (!(statementNode instanceof StatementNode)) {
                throw new SemanticException(statementNode + " is not instance of statementNode");
            }
        }
        return new StatementType();
    }


}
