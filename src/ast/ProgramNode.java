package ast;

import ast.statement.StatListNode;
import ast.statement.StatementNode;
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

}
