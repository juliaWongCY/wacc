package ast;

import ast.statement.StatementNode;
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

    public ProgramNode(ArrayList<FunctionNode> functions,
                       ArrayList<StatementNode> statements){
        this.functions = functions;
        this.statements = statements;
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
    public Type getNodeType() {
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
