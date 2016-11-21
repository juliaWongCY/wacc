package ast;

import ast.statement.StatListNode;
import ast.statement.StatementNode;
import backEnd.AssemblyCode;
import backEnd.General.Header;
import backEnd.General.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

import java.util.ArrayList;
import java.util.List;

public class ProgramNode implements ASTNode {
    
    private List<FunctionNode> functions;
    private StatListNode statListNode;

    public ProgramNode(List<FunctionNode> functions, StatListNode statListNode) {
        this.functions = functions;
        this.statListNode = statListNode;
    }

    public List<FunctionNode> getFunctionNodes(){
        return functions;
    }

    public StatListNode getStatListNode() {
        return statListNode;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return null;
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        originalInstructions.add(new Header(".text\n\n"), null);
        originalInstructions.add(new Header(".global main\n"), null);

        return originalInstructions;
    }
}
