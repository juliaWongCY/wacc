package ast;

public interface ASTNode {

    // this class should be able to compare itself with other ASTNode with type and content(?)



    // wrong responsibility? ////////////////////////////////////////
    /* Should iterate through all tokens in the context, attempting to match a rule, which may
     * include recursively calling match method on non-terminal in the given context. If a
     * rule is matched, the corresponding ASTNode should be returned, otherwise a
     * UnwantedTokenException is thrown, indicating a semantic error
     *
     * Pre: the syntactically corrected context
     * Post: the ASTNode of the corresponding target
     * */
    //ASTNode match(ParserRuleContext cxt) throws UnwantedTokenException;
    ///////////////////////////////////////////////////////////////

}
