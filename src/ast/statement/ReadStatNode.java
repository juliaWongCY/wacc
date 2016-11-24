package ast.statement;

import ast.assignLeft.AssignLeftNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.*;

public class ReadStatNode implements StatementNode {

    /* the read statement can only handle character or integer input
     a read statement can only target a program variable, an array element or a pair element.*/

    private AssignLeftNode target;

    public ReadStatNode(AssignLeftNode target) {
        this.target = target;
    }


    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        StatementType stat = new StatementType();
        return stat.getType();
    }

    public AssignLeftNode getTarget() {
        return target;
    }

    @Override
    public int getTypeIndicator() {
        return -1;
    }

}
