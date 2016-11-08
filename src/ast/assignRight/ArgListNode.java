package ast.assignRight;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

import java.util.ArrayList;
import java.util.List;

public class ArgListNode implements AssignRightNode {

    private List<ExpressionNode> args;

    public ArgListNode(List<ExpressionNode> args) {
        this.args = args;
    }

    public List<Type> getNodeTypes(SymbolTable st) throws SemanticException {
        ArrayList<Type> types = new ArrayList<>();
        for (ExpressionNode a : args) {
            types.add(a.getNodeType(st));
        }
        return types;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        throw new SemanticException
                ("ArgListNode can contain multiple types, use method - "
                        + "\"getNodeTypes\" instead");
    }
}
