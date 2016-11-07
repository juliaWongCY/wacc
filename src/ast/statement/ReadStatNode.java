package ast.statement;

import ast.ASTNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class ReadStatNode implements StatementNode {

    private ASTNode assignLHS;

    public ReadStatNode(ASTNode assignLHS) {
        this.assignLHS = assignLHS;
    }


    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return null;
    }
}
