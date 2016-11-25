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
        typeIndicator = Util.ARRAY_TYPE;
    }

    public IdentNode getArrayName() {
        return arrayName;
    }

    public List<ExpressionNode> getIndexes() {
        return indexes;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        Type type = st.lookUpVariable(arrayName.getId());
        Type elemType = type;
        for (int i = 0; i < indexes.size(); i++) {
            if (elemType instanceof ArrayType) {
                elemType = ((ArrayType) elemType).getElemType();
                typeIndicator = Util.convertTypeToIndicator(elemType);
            }
        }
        int counter = indexes.size();
        while (type instanceof ArrayType && counter > 0) {
            type = ((ArrayType) type).getElemType();
            counter--;
        }
        return type;
    }

}
