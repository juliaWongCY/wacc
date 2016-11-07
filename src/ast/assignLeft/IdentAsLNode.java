package ast.assignLeft;

import ast.ASTNode;
import ast.expression.IdentNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import org.antlr.runtime.UnwantedTokenException;
import org.antlr.v4.runtime.ParserRuleContext;
import type.Type;

public class IdentAsLNode implements AssignLeftNode {

    private IdentNode identifier;

    public IdentAsLNode(IdentNode identifier) {
        this.identifier = identifier;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return identifier.getNodeType(st);
    }

    /* this is a wrapper node to contain the IdentExprNode */


}
