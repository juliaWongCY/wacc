package ast.expression;

import frontEnd.SemanticException;
import type.PairType;
import type.Type;

public class PairLiterNode implements ExpressionNode {

    public PairLiterNode() {
        //PairLiter = null
    }


    @Override
    public Type getNodeType() throws SemanticException {
        PairType pairType = new PairType();
        return pairType.getType();
    }
}
