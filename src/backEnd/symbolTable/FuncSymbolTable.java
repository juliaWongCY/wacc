package backEnd.symbolTable;

import java.util.HashMap;
import java.util.Map;

public class FuncSymbolTable {

    private Map<String, Integer> retTypeTable;
    private Map<String, VarSymbolTable> paramTable;

    public FuncSymbolTable() {
        this.retTypeTable = new HashMap<>();
        this.paramTable = new HashMap<>();
    }

    public void addFunction(String funcName, Integer typeIndicator, VarSymbolTable table) {
        retTypeTable.put(funcName, typeIndicator);
        paramTable.put(funcName, table);
    }

    public Integer getFunctionRetType(String funcName) {
        if (retTypeTable.containsKey(funcName)) {
            return retTypeTable.get(funcName);
        } else {
            System.err.println("undefined function");
            return null;
        }
    }

    public VarSymbolTable getFunctionParams(String funcName) {
        if (paramTable.containsKey(funcName)) {
            return paramTable.get(funcName);
        } else {
            System.err.println("undefined function");
            return null;
        }
    }
}
