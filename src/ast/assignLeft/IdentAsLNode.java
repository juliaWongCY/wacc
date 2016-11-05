package ast.assignLeft;

import ast.ASTNode;
import org.antlr.runtime.UnwantedTokenException;
import org.antlr.v4.runtime.ParserRuleContext;

public class IdentAsLNode implements AssignLeftNode {

    /* this is a wrapper node to contain the IdentExprNode */

    @Override
    public ASTNode match(ParserRuleContext cxt) throws UnwantedTokenException {
        return null;
    }
}
