package ast.statement;

import ast.assignRight.AssignRightNode;
import ast.expression.IdentNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

public class DeclareStatNode implements StatementNode {
    // <stat> = <type> <ident> '=' <assign-rhs>

    private Type type;
    private IdentNode id;
    private AssignRightNode assignRightNode;

    public DeclareStatNode(Type type,
                           IdentNode id,
                           AssignRightNode assignRightNode) {
        this.type = type;
        this.id = id;
        this.assignRightNode = assignRightNode;
    }

    public Type getType(){
        return type;
    }

    public IdentNode getId(){
        return id;
    }

    public AssignRightNode getAssignRightNode(){
        return assignRightNode;
    }


    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        //to check the lhs type is the same as the rhs

        /*
        Type t;
        try{
            t = assignRightNode.getNodeType(st);
        } catch (SemanticException e){
            throw new SemanticException("Type of LHS must be same as RHS's type");
        }

        if(!type.equals(t)){
            throw new SemanticException("Type of LHS must be same as RHS's type.");
        }
        */
        StatementType stat = new StatementType();
        return stat.getType();
    }

}
