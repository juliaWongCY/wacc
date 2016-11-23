package ast.expression;

import backEnd.Util;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.PairType;
import type.Type;

public class PairLiterNode extends ExpressionNode {

    public PairLiterNode() {
        //PairLiter = null
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        typeIndicator = Util.PAIR_TYPE;
        return new PairType();
    }

}
