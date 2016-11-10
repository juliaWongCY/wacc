package frontEnd;

import type.Type;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private SymbolTable parent;
    private Map<String, Type> functionTable = new HashMap<>();
    private Map<String, Type> varTable = new HashMap<>();

    public SymbolTable() {
        this.parent = null;
    }

    //Constructor
    public SymbolTable(SymbolTable parent){
        this.parent = parent;
    }

    public SymbolTable getParent() {
        return parent;
    }

    public Map<String, Type> getFunctionTable() {
        return functionTable;
    }

    public Map<String, Type> getVarTable() {
        return varTable;
    }

    public void addFunction(String func, Type retType) throws SemanticException{
        if (functionTable.containsKey(func)) {
            throw new SemanticException("Function with same identifier is already declared");
        } else {
            functionTable.put(func, retType);
        }
    }

    public void addVariable(String var, Type varType) throws SemanticException{
        if (varTable.containsKey(var)) {
            throw new SemanticException
                    ("Variable with same identifier is already declared in current scope");
        } else {
            varTable.put(var, varType);
        }
    }

    public Type lookUpFunction(String func) throws SemanticException{
        if (functionTable.containsKey(func)) {
            return functionTable.get(func);
        }
        if (getParent() == null) {
            throw new SemanticException("Function not found");
        } else {
            return getParent().lookUpFunction(func);
        }
    }

    public Type lookUpVariable(String var) throws SemanticException{
        if (varTable.containsKey(var)) {
            return varTable.get(var);
        }
        if (getParent() == null) {
            throw new SemanticException("Variable not found");
        } else {
            return getParent().lookUpVariable(var);
        }
    }



}
