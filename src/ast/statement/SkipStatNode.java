package ast.statement;

import frontEnd.SemanticException;
import type.StatementType;
import type.Type;

public class SkipStatNode implements StatementNode {
    // <stat> := skip;

    public SkipStatNode() {

    }

    @Override
    public Type getNodeType() throws SemanticException {
        StatementType stat = new StatementType();
        return stat.getType();
    }

}
