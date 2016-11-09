package ast;

import ast.statement.StatementNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.StatementType;
import type.Type;

import java.util.ArrayList;

public class ProgramNode implements ASTNode {

    // <program> ::= ‘begin’ <func>* <stat> ‘end’

    private ArrayList<FunctionNode> functions;
    private StatementNode statement;

    public ProgramNode() {
        this.functions = new ArrayList<>();
        this.statement = null;
    }

    public void addFunction(FunctionNode func) {
        functions.add(func);
    }

    public void setStatementNode(StatementNode statement) {
        this.statement = statement;
    }

    public ArrayList<FunctionNode> getFunctionNodes(){
        return functions;
    }

    public StatementNode getStatementNode(){
        return statement;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        for (FunctionNode f : functions) {
            f.getNodeType(st);
        }
        if (!(statement.getNodeType(st) instanceof StatementType)) {
            throw new SemanticException
                    ("Type error in statement" + statement +
                            ", expecting statement type -" +
                            " actual type is" + statement.getNodeType(st));
        }

        return null;
    }

}
