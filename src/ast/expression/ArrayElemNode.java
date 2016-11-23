package ast.expression;

import backEnd.Util;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.ArrayType;
import type.Type;
import java.util.List;

public class ArrayElemNode extends ExpressionNode {

    private IdentNode arrayName;
    private List<ExpressionNode> indexes;

    public ArrayElemNode(IdentNode arrayName, List<ExpressionNode> indexes) {
        this.arrayName = arrayName;
        this.indexes = indexes;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        Type type = st.lookUpVariable(arrayName.getId());
        int counter = indexes.size();
        while (type instanceof ArrayType && counter > 0) {
            type = ((ArrayType) type).getElemType();
            counter--;
        }
        typeIndicator = Util.convertTypeToIndicator(type);
        return type;
    }

}
