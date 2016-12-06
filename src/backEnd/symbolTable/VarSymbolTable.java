package backEnd.symbolTable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class VarSymbolTable {

    private VarSymbolTable parent;
    private Map<String, VarProperty> varTable;

    private Stack<Integer> states = new Stack<>();

    public VarSymbolTable() {
        parent = null;
        this.varTable = new HashMap<>();
    }

    public VarSymbolTable(VarSymbolTable parent) {
        this.parent = parent;
        this.varTable = new HashMap<>();
    }

    // splitting addVar and modVar to ensure the integrity of the symbol table
    // TODO: change back to just call put method after the entire backend working

    public void addVariable(String varName, VarProperty varProperty) {
        if (varTable.containsKey(varName)) {
            System.err.println("Duplicate variable in same scope: " + varName);
        } else {
            varTable.put(varName, varProperty);
        }
    }

    public void modifyVariable(String varName, VarProperty varProperty) {
        if (varTable.containsKey(varName)) {
            varTable.put(varName, varProperty);
        } else {
            if (parent == null) {
                System.err.println("Undefined variable");
            } else {
                parent.modifyVariable(varName, varProperty);
            }
        }
    }

    public VarProperty getVarProperty(String varName) {
        if (varTable.containsKey(varName)) {
            return varTable.get(varName);
        }
        if (parent == null) {
            System.err.println("variable not found");
            return null;
        } else {
            return parent.getVarProperty(varName);
        }
    }


    public void clearVariables() {
        Iterator<Map.Entry<String, VarProperty>> iter = varTable.entrySet().iterator();
        Map<String, VarProperty> newVarTable = new HashMap<>();
        while (iter.hasNext()) {
            Map.Entry<String, VarProperty> entry = iter.next();
            if (entry.getKey().startsWith("f_inc")) {
                newVarTable.put(entry.getKey(), entry.getValue());
            }

        }
        varTable = newVarTable;


    }


    public int getVarLocalSize() {
        int size = 0;
        Iterator<Map.Entry<String, VarProperty>> iter = varTable.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, VarProperty> entry = iter.next();
            size += entry.getValue().getTypeSize();
        }
        return size;
    }

    public int getVarTotalSize() {
        if (parent == null) {
            return getVarLocalSize();
        } else {
            return getVarLocalSize() + parent.getVarTotalSize();
        }
    }

    public VarSymbolTable getParent() {
        return parent;
    }

    public int saveState() {
        states.push(getVarTotalSize());
        return states.peek();
    }

    public boolean hasAddedNewVar() {
        return getVarTotalSize() != states.pop();
    }

}