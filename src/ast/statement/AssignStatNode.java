package ast.statement;

import ast.assignLeft.AssignLeftNode;
import ast.assignRight.AssignRightNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class AssignStatNode implements StatementNode {

  /* The target of an assignment can be either a program variable, an array element or a pair element.
   The assignment value can be one of five possible types:
   an expression / an array literal / a function call / a pair constructor / a pair element. */

    private AssignRightNode assignRHS;
    private AssignLeftNode assignLHS;

    public AssignStatNode(AssignRightNode assignRHS, AssignLeftNode assignLHS) {
        this.assignRHS = assignRHS;
        this.assignLHS = assignLHS;
    }

    //These functions will be useful for backend
    public AssignRightNode getAssignRHS(){
        return assignRHS;
    }

    public AssignLeftNode getAssignLHS(){
        return assignLHS;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        StatementType stat = new StatementType();
        return stat.getType();
    }

}
