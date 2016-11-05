package AST;

import org.antlr.runtime.UnwantedTokenException;
import org.antlr.v4.runtime.ParserRuleContext;

public interface ASTNode {

    /* Should iterate through all tokens in the context, attempting to match a rule, which may
     * include recursively calling match method on non-terminal in the given context. If a
     * rule is matched, the corresponding ASTNode should be returned, otherwise a
     * UnwantedTokenException is thrown, indicating a semantic error
     *
     * Pre: the syntactically corrected context
     * Post: the ASTNode of the corresponding target
     * */
    ASTNode match(ParserRuleContext cxt) throws UnwantedTokenException;

}
