package ast;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public interface ASTNode {

    // return the type of the node, which will be done so by recursively telling its children to call this method.
    Type getNodeType(SymbolTable st) throws SemanticException;


}
