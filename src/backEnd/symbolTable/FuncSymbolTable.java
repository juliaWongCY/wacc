package backEnd.symbolTable;

import java.util.HashMap;
import java.util.Map;

public class FuncSymbolTable {

    private Map<String, VarSymbolTable> funcTable;

    public FuncSymbolTable() {
        this.funcTable = new HashMap<>();
    }

    public void addFunction(String funcName, VarSymbolTable table) {
        funcTable.put(funcName, table);
    }

    public void getFunction(String funcName) {
        if (funcTable.containsKey(funcName)) {
            funcTable.get(funcName);
        } else {
            System.err.println("undefined function");
        }
    }
}
