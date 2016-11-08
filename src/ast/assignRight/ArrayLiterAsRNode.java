package ast.assignRight;

import ast.expression.ExpressionNode;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.ArrayType;
import type.Type;

import java.util.ArrayList;
import java.util.List;

public class ArrayLiterAsRNode implements AssignRightNode {

    private List<ExpressionNode> elements;

    public ArrayLiterAsRNode() {
        elements = new ArrayList<>();
    }

    public ArrayLiterAsRNode(List<ExpressionNode> elements) {
        this.elements = elements;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        if (elements.isEmpty()) {
            return new ArrayType();
        } else {
            Type type = elements.get(0).getNodeType(st);
            for (ExpressionNode e : elements) {
                if (!type.equals(e.getNodeType(st))) {
                    throw new SemanticException("Multiple type in array");
                }
            }
            return type;
        }
    }
}
