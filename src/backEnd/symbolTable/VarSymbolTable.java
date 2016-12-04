package backEnd.symbolTable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VarSymbolTable {

    private VarSymbolTable parent;
    private Map<String, Value> varTable;

    private int state = -1;

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

    public void addVariable(String varName, Value value) {
        if (varTable.containsKey(varName)) {
            System.err.println("Duplicate variable in same scope: " + varName);
        } else {
            varTable.put(varName, value);
        }
    }

    public void modifyVariable(String varName, Value value) {
        if (varTable.containsKey(varName)) {
            varTable.put(varName, value);
        } else {
            if (parent == null) {
                System.err.println("Undefined variable");
            } else {
                parent.modifyVariable(varName, value);
            }
        }
    }

    public Value getVariable(String varName) {
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


    public void clearVariables(){
        Iterator<Map.Entry<String, Value>> iter = varTable.entrySet().iterator();
        Map<String, Value> newVarTable = new HashMap<>();
        while(iter.hasNext()){
            Map.Entry<String, Value> entry = iter.next();
            if (entry.getKey().startsWith("f_inc")){
                newVarTable.put(entry.getKey(), entry.getValue());
            }

        }
        varTable = newVarTable;


    }


    public int getVarLocalSize() {
        int size = 0;
        Iterator<Map.Entry<String, Value>> iter = varTable.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Value> entry = iter.next();
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

    public void saveState() {
        state = getVarTotalSize();
    }

    public boolean checkSameState() {
        return getVarTotalSize() == state;
    }

    public int getState() {
        return state;
    }
}
