package ast.expression;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.ArrayType;
import type.Type;

import java.util.List;

public class ArrayElemNode implements ExpressionNode {

    private IdentNode arrayName;
    private List<ExpressionNode> indexes;

    public ArrayElemNode(IdentNode arrayName, List<ExpressionNode> indexes) {

        //<array-elem> ::= <ident> (‘[’ <expr > ‘]’)+
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

        return type;
    }
}
