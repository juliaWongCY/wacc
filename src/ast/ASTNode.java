package ast;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public interface ASTNode {

    /* return the type of the node, which will internally perform a type check
     * to ensure all it's children has the correct type*/
    Type getNodeType(SymbolTable st) throws SemanticException;


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
