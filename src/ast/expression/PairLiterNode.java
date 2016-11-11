package ast.expression;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.PairType;
import type.Type;

public class PairLiterNode implements ExpressionNode {

    public PairLiterNode() {
        //PairLiter = null
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return new PairType(true);
    }
}
