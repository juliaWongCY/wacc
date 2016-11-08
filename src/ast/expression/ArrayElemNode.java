package ast.expression;

import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.ArrayType;
import type.Type;

import java.util.List;

public class ArrayElemNode implements ExpressionNode {

    private Type elemType;
    private IdentNode arrayName;
    private List<String> indexes;

    public ArrayElemNode(Type elemType, IdentNode arrayName, List<String> indexes) {

        //<array-elem> ::= <ident> (‘[’ <expr > ‘]’)+
        this.elemType = elemType;
        this.arrayName = arrayName;
        this.indexes = indexes;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        Type type = st.lookUpVariable(arrayName.getId());
        while (type instanceof ArrayType) {
            if (((ArrayType) type).getNestedLayer() < indexes.size()) {
                type = ((ArrayType) type).getElemType();
            }
        }

        return type;
    }
}
