package backEnd.symbolTable;

import java.util.HashMap;
import java.util.Map;

public class VarSymbolTable {

    private VarSymbolTable parent;
    private Map<String, Value> varTable;

    public VarSymbolTable() {
        parent = null;
        this.varTable = new HashMap<>();
    }

    public VarSymbolTable(VarSymbolTable parent) {
        this.parent = parent;
        this.varTable = new HashMap<>();
    }

    // spliting addVar and modVar to ensure the integrity of the symbol table
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
}