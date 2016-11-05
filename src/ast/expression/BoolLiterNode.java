package ast.expression;

import ast.ASTNode;
import org.antlr.runtime.UnwantedTokenException;
import org.antlr.v4.runtime.ParserRuleContext;

public class BoolLiterNode implements ExpressionNode {

    private final boolean value;

    public BoolLiterNode(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
    
}
