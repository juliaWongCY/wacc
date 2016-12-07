package optimisation;

import ast.expression.ExpressionNode;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private SymbolTable parent;
    private Map<String, ExpressionNode> varTable;


    public SymbolTable() {
        parent = null;
        this.varTable = new HashMap<>();
    }

    public SymbolTable(SymbolTable parent) {
        this.parent = parent;
        this.varTable = new HashMap<>();
    }

    public SymbolTable getParent() {
        return parent;
    }

    public void addVariable(String varName, ExpressionNode expressionNode) {
        if (!varTable.containsKey(varName)) {
            varTable.put(varName, expressionNode);
        } else {
            System.err.println("Duplicate variable in same scope: " + varName);
        }
    }

    public void modifyVariable(String varName, ExpressionNode expressionNode) {
        if (varTable.containsKey(varName)) {
            varTable.put(varName, expressionNode);
        } else {
            if (parent == null) {
                System.err.println("Undefined variable");
            } else {
                parent.modifyVariable(varName, expressionNode);
            }
        }
    }

    public ExpressionNode getVariable(String varName) {
        if (varTable.containsKey(varName)) {
            return varTable.get(varName);
        }
        if (parent == null) {
            System.err.println("variable not found");
            return null;
        } else {
            return parent.getVariable(varName);
        }
    }

}
