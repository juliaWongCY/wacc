package ast;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

public class ErrorNode implements ASTNode {

    private ErrorNode child;
    private String ctx;

    public ErrorNode(String ctx) {
        this.child = null;
        this.ctx = ctx;
    }

    public ErrorNode(ErrorNode child, String ctx) {
        this.child = child;
        this.ctx = ctx;
    }

    public ErrorNode getChild() {
        return child;
    }

    public String getCtx() {
        return ctx;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return null;
    }
}
