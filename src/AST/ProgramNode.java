package AST;

import org.antlr.runtime.UnwantedTokenException;
import org.antlr.v4.runtime.ParserRuleContext;

public class ProgramNode implements ASTNode {


    @Override
    public ASTNode match(ParserRuleContext cxt) throws UnwantedTokenException {
        /* pseudo code:
         * check next token is NormalisedNode - 'Begin'
         * if true: check next token is FunctionNode, or stateNode
         *      if true: call match on either node
         *          if true: check next token is NormalisedNode - 'End'
         * else: return exception
         */
        return null;
    }
}
