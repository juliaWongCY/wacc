package optimisation;

import ast.ASTNode;
import ast.expression.ExpressionNode;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private SymbolTable parent;
    private Map<String, OptimiseProperty> varTable;


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

    public void addVariable(String varName, OptimiseProperty property) {
        if (!varTable.containsKey(varName)) {
            varTable.put(varName, property);
        } else {
            System.err.println("Duplicate variable in same scope: " + varName);
        }
    }

//    public void modifyVariable(String varName, ExpressionNode expressionNode, int assignLevel) {
//        if (varTable.containsKey(varName)) {
//            OptimiseProperty optimiseProperty = varTable.get(varName);
//            optimiseProperty.setExpressionNode(expressionNode);
//            optimiseProperty.pushAssignLevels(assignLevel);
//            varTable.put(varName, optimiseProperty);
//        } else {
//            if (parent == null) {
//                System.err.println("Undefined variable");
//            } else {
//                parent.modifyVariable(varName, expressionNode, assignLevel);
//            }
//        }
//    }

    public void modifyVariable(String varName, OptimiseProperty property) {
        if (varTable.containsKey(varName)) {
            varTable.put(varName, property);
        } else {
            if (parent == null) {
                System.err.println("Undefined variable");
            } else {
                parent.modifyVariable(varName, property);
            }
        }
    }

    public void modifyVariable(String varName, ASTNode value, int assignLevel) {
        if (varTable.containsKey(varName)) {
            OptimiseProperty optimiseProperty = varTable.get(varName);
            optimiseProperty.setValue(value);
            optimiseProperty.pushAssignLevels(assignLevel);
            varTable.put(varName, optimiseProperty);
        } else {
            if (parent == null) {
                System.err.println("Undefined variable");
            } else {
                parent.modifyVariable(varName, value, assignLevel);
            }
        }
    }

    public OptimiseProperty getVariable(String varName) {
        if (varTable.containsKey(varName)) {
            return varTable.get(varName);
        } else {
            if (parent == null) {
                System.err.println("variable not found");
                return null;
            } else {
                return parent.getVariable(varName);
            }
        }
    }

}
