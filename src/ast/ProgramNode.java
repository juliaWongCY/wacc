package ast;

import ast.statement.StatementNode;

import java.util.ArrayList;

public class ProgramNode implements ASTNode {

    private ArrayList<FunctionNode> functions;
    private ArrayList<StatementNode> statements;

    public void addFunction(FunctionNode func) {
        functions.add(func);
    }

    public void addStatement(StatementNode stat) {
        statements.add(stat);
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
