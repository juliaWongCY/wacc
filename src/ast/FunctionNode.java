package ast;

import org.antlr.runtime.UnwantedTokenException;
import org.antlr.v4.runtime.ParserRuleContext;

public class FunctionNode implements ASTNode {
    @Override
    public ASTNode match(ParserRuleContext cxt) throws UnwantedTokenException {
        return null;
    }
}
