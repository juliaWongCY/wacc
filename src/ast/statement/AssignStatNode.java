package ast.statement;

import ast.assignLeft.AssignLeftNode;
import ast.assignRight.AssignRightNode;
import ast.expression.ExpressionNode;
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
        /*Remark:
        <assign-lhs> = <ident> | <array-elem> | <pair-elem>
        <assign-rhs> = <expr> | <array-liter> | ‘newpair’ ‘(’ <expr> ‘,’ <expr> ‘)’ | <pair-elem> | ‘call’ <ident> ‘(’ <arg-list>? ‘)’
        */
        Type lhs;
        Type rhs;
        Type ident;
        ExpressionNode expr;

        //TODO: Do I need to check each type in assignLHS and assignRHS?
        try{
            lhs = assignLHS.getNodeType(st);
        } catch (SemanticException e) {
            throw new SemanticException("The type must be either an ident, array-elem or pair-elem.");
        }

        try{
            rhs = assignRHS.getNodeType(st);
        } catch (SemanticException se) {
            throw new SemanticException("The type must be either an expression / an array literal / a function call / a pair constructor / a pair element.");
        }

        if(lhs != rhs){
            throw new SemanticException("The target value and assignment values should have the same type");
        }

        /*
        try{
            ident = st.lookUpVariable(id);
        } catch (SemanticException e) {
            throw new SemanticException("There is no ident.");
        }

        //TODO: Check if that's how to check expr

        if(!(lhs.equals(ident) || (lhs instanceof PairElemType))){
            throw new SemanticException("The target of an assignment can be either a program " +
                    "variable, an array element or a pair element");
        }

        */
        StatementType stat = new StatementType();
        return stat.getType();
    }
}
