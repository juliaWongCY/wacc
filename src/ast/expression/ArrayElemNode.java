package ast.expression;

import backEnd.Util;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.ArrayType;
import type.Type;
import java.util.List;

public class ArrayElemNode extends ExpressionNode {

    private IdentNode iNode;
    private List<ExpressionNode> indexes;

    public ArrayElemNode(IdentNode arrayName, List<ExpressionNode> indexes) {
        this.iNode = arrayName;
        this.indexes = indexes;
        typeIndicator = Util.ARRAY_TYPE;
    }

    public Type getElemType() {
        return iNode.getType();
    }

    public String getArrayName() {
        return iNode.getId();
    }

    public List<ExpressionNode> getIndexes() {
        return indexes;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        Type type = st.lookUpVariable(iNode.getId());

        int counter = indexes.size();
        while (type instanceof ArrayType && counter > 0) {
            type = ((ArrayType) type).getElemType();
            typeIndicator = Util.convertTypeToIndicator(type);
            counter--;
        }
        return type;
    }

}
