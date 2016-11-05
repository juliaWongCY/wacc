package ast.assignLeft;

import ast.ASTNode;
import org.antlr.runtime.UnwantedTokenException;
import org.antlr.v4.runtime.ParserRuleContext;

public class PairElemAsLNode implements AssignLeftNode {

    /* this is a wrapper class to contain the pairElemTypeNode */

    @Override
    public ASTNode match(ParserRuleContext cxt) throws UnwantedTokenException {
        return null;
    }
}
