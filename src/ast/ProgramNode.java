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
    private ArrayList<StatementNode> statements;

    public ProgramNode() {
        this.functions = new ArrayList<>();
        this.statements = new ArrayList<>();
    }

    public void addFunction(FunctionNode func) {
        functions.add(func);
    }

    public void addStatement(StatementNode stat) {
        statements.add(stat);
    }

    public ArrayList<FunctionNode> getFunctionNodes(){
        return functions;
    }

    public ArrayList<StatementNode> getStatementsNode(){
        return statements;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        for (FunctionNode f : functions) {
            f.getNodeType(st);
        }
        for (StatementNode s : statements) {
            if (!s.getNodeType(st).equals(new StatementType())) {
                throw new SemanticException
                        ("Type error in statement" + s +
                                ", expecting statement type -" +
                                " actual type is" + s.getNodeType(st));
            }
        }
        return null;
    }


//    @Override
//    public ASTNode match(ParserRuleContext cxt) throws UnwantedTokenException {
//        /* pseudo code:
//         * check next token is NormalisedNode - 'Begin'
//         * if true: check next token is FunctionNode, or stateNode
//         *      if true: call match on either node
//         *          if true: check next token is NormalisedNode - 'End'
//         * else: return exception
//         */
//
//
//        return null;
//    }
}
