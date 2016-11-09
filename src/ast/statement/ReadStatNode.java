package ast.statement;

import ast.ASTNode;
import ast.assignLeft.PairElemAsLNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.*;

import javax.swing.plaf.nimbus.State;

public class ReadStatNode implements StatementNode {

    // <stat> = 'read' <assign-lhs>
    // the read statement can only handle character or integer input
    // a read statement can only target a program variable, an array element or a pair element.

    private ASTNode assignLHS;
    private String id;

    public ReadStatNode(ASTNode assignLHS) {
        this.assignLHS = assignLHS;
    }


    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        /* Remark:
        <assign-lhs> = <ident> | <array-elem> = <ident> (‘[’ <expr> ‘]’)+ | <pair-elem>
        where
        <pair-elem> = <base-type> | <array-type> | 'pair'
        */

        /*
        if(assignLHS.equals(st.lookUpFunction(id))){
            if(!(assignLHS instanceof IntType) || !(assignLHS instanceof CharType)){
                throw new SemanticException("The read statement can only handle character or integer input.");
            }

        } else if(assignLHS instanceof PairElemAsLNode){
            PairType pairType = (PairType) assignLHS.getNodeType(st);
            PairElemAsLNode assignLPair = (PairElemAsLNode) assignLHS;

            Type elemType;
            elemType = assignLPair.isFirst() ? pairType.getFstExprType() : pairType.getSndExprType();


            if(!(elemType instanceof IntType || elemType instanceof CharType)) {
                throw new SemanticException("The read statement can only handle character or integer input.");

            }

        } else if(!(assignLHS instanceof IntType) || !(assignLHS instanceof CharType)){
            throw new SemanticException("The read statement can only handle character or integer input.");
        }

        */
        StatementType stat = new StatementType();
        return stat.getType();
    }
}
