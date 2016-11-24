package ast.statement;

import ast.assignLeft.AssignLeftNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.*;

public class ReadStatNode implements StatementNode {

    /* the read statement can only handle character or integer input
     a read statement can only assignLHS a program variable, an array element or a pair element.*/

    private AssignLeftNode assignLHS;

    public ReadStatNode(AssignLeftNode assignLHS) {
        this.assignLHS = assignLHS;
    }


    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        StatementType stat = new StatementType();
        return stat.getType();
    }

    public AssignLeftNode getAssignLHS() {
        return assignLHS;
    }

    @Override
    public int getTypeIndicator() {
        return -1;
    }

}
