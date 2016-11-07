package ast.statement;

import ast.assignLeft.AssignLeftNode;
import ast.assignRight.AssignRightNode;
import ast.expression.IdentNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class AssignStatNode implements StatementNode {

  // <stat> = <assign-lhs> '=' <assign-rhs>
  // The target of an assignment can be either a program variable, an array element or a pair element.
  // The assignment value can be one of five possible types:
  // an expression / an array literal / a function call / a pair constructor / a pair element.

    private AssignRightNode assignRHS;
    private AssignLeftNode assignLHS;
    private String id;

    public AssignStatNode(AssignRightNode assignRHS, AssignLeftNode assignLHS) {
        this.assignRHS = assignRHS;
        this.assignLHS = assignLHS;
    }

    public AssignRightNode getAssignRHS(){
        return assignRHS;
    }

    public AssignLeftNode getAssignLHS(){
        return assignLHS;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        Type lhs;
        Type rhs;
        Type ident;

        try{
            lhs = assignLHS.getNodeType(st);
        } catch (SemanticException e) {
            throw new SemanticException("The type must be an int in exit statement.");
        }

        try{
            rhs = assignRHS.getNodeType(st);
        } catch (SemanticException se) {
            throw new SemanticException("The type must be an int in exit statement.");
        }

        try{
            ident = st.lookUpVariable(id);
        } catch (SemanticException e) {
            throw new SemanticException("There is no ident.");
        }

        if(!(lhs instanceof ident))

        StatementType stat = new StatementType();
        return stat.getType();
    }
}
