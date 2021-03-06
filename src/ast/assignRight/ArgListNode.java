package ast.assignRight;

import ast.expression.ExpressionNode;
import backEnd.Util;
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

    public int getSize() {
        return args.size();
    }

    public List<ExpressionNode> getArgs() {
        return args;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        throw new SemanticException
                ("ArgListNode can contain multiple types, use method - "
                        + "\"getParamTypes\" instead");
    }

    public int getTypeSize() {
        int size = 0;
        for (ExpressionNode arg : args) {
            size += Util.getTypeSize(arg.getTypeIndicator());
        }
        return size;
    }

    @Override
    public int getTypeIndicator() {
        return -1;
    }


}
