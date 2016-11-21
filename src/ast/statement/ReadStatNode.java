package ast.statement;

import ast.ASTNode;
import backEnd.AssemblyCode;
import backEnd.General.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.*;

import java.util.List;

public class ReadStatNode implements StatementNode {

    /* the read statement can only handle character or integer input
     a read statement can only target a program variable, an array element or a pair element.*/

    private ASTNode assignLHS;
    private String id;

    public ReadStatNode(ASTNode assignLHS) {
        this.assignLHS = assignLHS;
    }


    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        StatementType stat = new StatementType();
        return stat.getType();
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }
}
