package ast;

import ast.expression.IdentNode;
import ast.parameter.ParamListNode;
import ast.statement.StatListNode;
import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.FunctionType;
import type.Type;

import java.util.List;

public class FunctionNode implements ASTNode {


    private Type type;
    private IdentNode functionName;
    private ParamListNode paramList;
    private StatListNode bodyStat;

    //Constructor
    public FunctionNode(Type type,
                        IdentNode functionName,
                        ParamListNode paramList,
                        StatListNode bodyStat){
        if (paramList == null) {
            this.type = new FunctionType(type);
        } else {
            try {
                this.type = new FunctionType(type, paramList.getNodeTypes(null));
            } catch (SemanticException e) {
                System.err.println("Internal error in creating function node - " +
                        "paramList returned semanticException");
            }
        }
        this.functionName = functionName;
        this.paramList = paramList;
        this.bodyStat = bodyStat;
    }

    public String getFunctionName(){
        return functionName.getId();
    }

    public ParamListNode getParamListNode(){
        return paramList;
    }

    public StatListNode getStatement(){
        return bodyStat;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        return type;
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }
}
